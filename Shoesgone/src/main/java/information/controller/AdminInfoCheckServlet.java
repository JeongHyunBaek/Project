package information.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import information.model.service.InformationService;
import information.model.vo.Information;

/**
 * Servlet implementation class AdminInfoCheckServlet
 */
@WebServlet("/info.ad")
public class AdminInfoCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInfoCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		//3. 서비스 메소드 실행하고 결과받기
		Information information = new InformationService().adminselectMember(userNo);
		
		//4. 받은 결과로 성공/실패에 대한 뷰 내보냄
		RequestDispatcher view = null;
		if(information != null) {
			view = request.getRequestDispatcher(
					"views/managerPage/selectMember.jsp");
			request.setAttribute("information", information);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", userNo 
					+ "번 회원정보 조회 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
