package loginPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginPage.model.service.LoginService;
import loginPage.model.vo.Login;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입 시 데이터베이스에 아이디가 이미 존재하는지 유효성 검사 처리
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		Login login = new LoginService().idValidate(userid);
		PrintWriter out = response.getWriter();
		
		if (login != null) {
			out.println("false");
		}else {
			out.println("true");
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
