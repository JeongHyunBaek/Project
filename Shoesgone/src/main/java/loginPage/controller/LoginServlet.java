package loginPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginPage.model.service.LoginService;
import loginPage.model.vo.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		Login login;
		String cryptoUserpwd = null;
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");

		// 로그인 비밀번호 SHA-512 적용
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));

			md.update(pwdValues);

			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 로그인 정보 데이터베이스에서 찾기
		login = new LoginService().selectLogin(userid, cryptoUserpwd);
		
		// 로그인 성공, 실패에 따른 화면 구현
		if (login != null && login.getLoginOk().equals("Y")) {
			HttpSession session = request.getSession();

			session.setAttribute("loginMember", login);

			response.sendRedirect("menubarsearch");
		} else { 
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			if (login != null && login.getLoginOk().equals("N")) {
				out.println("<script>alert('로그인 제한된 회원입니다. 관리자에게 문의하세요.'); location.href='/Shoesgone/menubarsearch?menu=login';</script>");
			}
			
			if (login == null) {
				out.println("<script>alert('로그인 실패! 아이디 또는 암호를 다시 확인하고 로그인하세요.'); location.href='/Shoesgone/menubarsearch?menu=login';</script>");
			}
			out.flush();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 클라이언트의 요청을 받는 메소드
		// 전송방식이 post 방식으로 요청이 왔을 때 자동 연결됨
		// System.out.println("post 방식으로 전송 요청옴...");
		doGet(request, response);
	}
}
