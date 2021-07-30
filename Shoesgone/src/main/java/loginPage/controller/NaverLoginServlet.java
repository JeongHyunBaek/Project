package loginPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginPage.model.service.LoginService;
import loginPage.model.vo.Login;

/**
 * Servlet implementation class NaverLoginServlet
 */
@WebServlet("/naverlogin")
public class NaverLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NaverLoginServlet() {
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

		String userid = request.getParameter("email");
		Login login = new LoginService().selectNaverLogin(userid);

		if (login != null && login.getLoginOk().equals("Y")) {
			HttpSession session = request.getSession();

			session.setAttribute("loginMember", login);

			response.sendRedirect("index.jsp");

		} else {
			response.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = response.getWriter();
			
			if (login != null && login.getLoginOk().equals("N")) {
				out.println("<script>alert('로그인 제한된 회원입니다. 관리자에게 문의하세요.'); location.href='/Shoesgone/views/loginPage/login.jsp';</script>");
			}

			// 해당하는 아이디가 없을 때 아이디, 비밀번호 데이터베이스에 생성
			if (login == null) {
				String cryptoUserpwd = null;
				Login newLogin = new Login();
				String userpwd = "0000";
				String username = request.getParameter("name");
				
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-512");
					byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));

					md.update(pwdValues);

					cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
				newLogin.setUserId(userid);
				newLogin.setUserPwd(cryptoUserpwd);
				newLogin.setEmail(userid);
				newLogin.setUserName(username);
				
				int result = new LoginService().insertNaverLogin(newLogin);
				
				if (result > 0) {
					HttpSession session = request.getSession();

					session.setAttribute("loginMember", newLogin);

					response.sendRedirect("index.jsp");
				}else {
					RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
					
					request.setAttribute("message", "회원 가입 실패!");

					view.forward(request, response);
				}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
