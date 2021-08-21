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
 * Servlet implementation class AdminUserUpdateServlet
 */
@WebServlet("/userupdate.ad")
public class AdminUserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자 회원정보 수정 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		// 1. 수정할 회원 정보 저장용 객체 생성
		Information userUp = new Information();
		
		// 2. 수정한 내용 객체에 저장
		userUp.setMgr(request.getParameter("mrg"));
		userUp.setLoginOk(request.getParameter("loginok"));
		userUp.setUserNo(Integer.parseInt(request.getParameter("userno")));
		
		// 3. 서비스에 전달하여 결과받기
		int result = new InformationService().adminUserUpdate(userUp);
		
		// 4. 결과 성공|실패 출력하기
		if(result > 0) {
			response.sendRedirect("/Shoesgone/userlist.ad");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			System.out.println("실패");
			request.setAttribute("message", "회원 정보 수정 실패!");
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
