package loginPage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

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
 * Servlet implementation class SearchPasswordServlet
 */
@WebServlet("/searchpwd")
public class SearchPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		// 해당하는 전화번호와 이메일에 따른 사용자 비밀번호 찾기
		Login login = new LoginService().searchPassword(phone, email);

		// 해당 전화번호와 이메일을 가지고 있는 사용자 유무 판별 조건식
		if (login != null) { 
			RequestDispatcher view = null;
			
			view = request.getRequestDispatcher("views/loginPage/resultPassword.jsp");
			
			// 임시 비밀번호로 업데이트
			new LoginService().tempPassword(getRandomPassword(), phone, email);
			
			// 변경된 비밀번호 정보 다시 가져오기
			login = new LoginService().searchPassword(phone, email);
			
			String userpwd = login.getUserPwd();
			String cryptoUserpwd = null;

			// 새로운 비밀번호에 대한 SHA-512 적용
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));

				md.update(pwdValues);
	
				cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			Login newLogin = new Login();

			newLogin.setUserPwd(login.getUserPwd());
			
			// 임시 비밀번호를 찾아 SHA-512 적용한 비밀번호로 업데이트
			new LoginService().updateLogin(newLogin, cryptoUserpwd);
			
			request.setAttribute("login", login);
	        
	        view.forward(request, response);
		} else {
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('일치하는 사용자 정보를 찾을 수 없습니다.'); location.href='/Shoesgone/views/loginPage/searchPassword.jsp';</script>");

			out.flush();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 임시 비밀번호 생성 메소드
	public String getRandomPassword() {
		char[] digit = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] alpha = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		char[] schar = new char[] { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+' };
		StringBuffer sb = new StringBuffer();
		SecureRandom sr = new SecureRandom();
		sr.setSeed(new Date().getTime());

		int idx = 0;
		int lenDigit = digit.length;
		int lenAlpha = alpha.length;
		int lenSchar = schar.length;
		
		for (int i = 0; i < 10; i++) {
			if (i < 2) {
				idx = sr.nextInt(lenDigit);
				sb.append(digit[idx]);
			} else if (i < 8) {
				idx = sr.nextInt(lenAlpha);
				sb.append(alpha[idx]);
			} else {
				idx = sr.nextInt(lenSchar);
				sb.append(schar[idx]);
			}
		}
		return sb.toString();
	}
}
