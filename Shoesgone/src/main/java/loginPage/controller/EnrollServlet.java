package loginPage.controller;

import java.io.IOException;
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

import loginPage.model.service.LoginService;
import loginPage.model.vo.Login;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int result;
		String userpwd;
		String cryptoUserpwd = null;
		String shoesSize = request.getParameter("shoesSize");
		Login login = new Login();
		
		login.setUserId(request.getParameter("userid"));
		login.setEmail(request.getParameter("userid"));
		if (shoesSize == "") {
			login.setShoesSize(0);
		} else {
			login.setShoesSize(Integer.parseInt(shoesSize));
		}
		login.setUserName(request.getParameter("username"));
		login.setPhone(request.getParameter("phone"));
		login.setAddress(request.getParameter("address1") + "," + request.getParameter("address2") + "," + request.getParameter("address3"));
		userpwd = request.getParameter("userpwd");
		
		// 회원가입 비밀번호 SHA-512 적용
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));

			md.update(pwdValues);

			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		login.setUserPwd(cryptoUserpwd);

		// 회원가입 정보 데이터베이스에 기록
		result = new LoginService().insertLogin(login);
		
		// 회원가입 성공, 실패에 따른 화면 구현
		if (result > 0) {
			response.sendRedirect("/Shoesgone/menubarsearch?menu=login");
		}else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");

			request.setAttribute("message", "회원 가입 실패!");

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
