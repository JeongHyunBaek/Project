package itemPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itemPage.model.service.ItemDetailService;

/**
 * Servlet implementation class MemberDupIDCheckServlet
 */
@WebServlet("/dupmodelno")
public class AdminDupItemnoCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDupItemnoCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 가입시 등록할 아이디 중복 체크 처리용 컨트롤러
		
		String modelno = request.getParameter("modelno");
		
		int idCount = new ItemDetailService().selectCheckModelno(modelno);
		
		String returnValue = null;  //ajax 로 보낼값 기록용
		if(idCount == 0) {
			returnValue = "ok";
		}else {
			returnValue = "duplicate";
		}
		
		//ajax 통신은 네트워크 입출력임.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.append(returnValue);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
