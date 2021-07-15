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
		// 클라이언트의 요청을 받는 메소드
		// 전송방식이 get 방식으로 요청이 왔을 때 자동 연결됨
		// System.out.println("get 방식으로 전송 요청옴...");
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// request :
		// 사용자가 input 으로 입력한 값, 쿼리스트링으로 전달한 값을 가지고 옴
		// 전송방식이 get 이면 request head 에 전송값이 기록되서 옴
		// url 에 보여짐
		// 전송방식이 post 이면 request body 에 전송값이 기록되서 옴
		// url 에 안 보여짐

		// response : 서비스를 요청한 클라이언트 정보를 가지고 있음
		// url ip 주소 등
		// 웹에서는 클라이언트와 서버 간의 request 와 response 가 쌍으로
		// 왔다갔다 함

		// 1. 전송온 값에 한글이 있다면 인코딩 처리함
		request.setCharacterEncoding("utf-8");

		// 2. 전송온 값 꺼내서, 변수 또는 객체에 기록하기
		// String 변수 = request.getParameter("input의 이름");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		// System.out.println(userid + ", " + userpwd);

		// 웹에서는 단방향 알고리즘 적용 : SHA-512
		// 단방향 : 암호화만 하고, 복호화가 안되는 알고리즘
		// java.security.MessageDigest 클래스 이용함
		String cryptoUserpwd = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			// 패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환해야 함
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 바꾸기
			md.update(pwdValues);
			// 암호화된 byte[]을 String으로 바꿈 : 암호문 상태임
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			// 확인
			System.out.println(cryptoUserpwd);
			System.out.println(cryptoUserpwd.length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// 3. 서비스 메소드로 전달해서 실행하고 결과받기
		//Member member = new MemberService().selectLogin(userid, userpwd);
		Login login = new LoginService().selectLogin(userid, cryptoUserpwd);

		// 4. 받은 결과에 따라 성공/실패 페이지 내보내기
		if (login != null && login.getLoginOk().equals("Y")) { // 로그인 성공
			// 로그인 확인용 객체 생성함
			HttpSession session = request.getSession();
			System.out.println("생성된 세션 객체의 id : " + session.getId());

			// 로그인한 회원의 정보는 세션객체에 저장함
			session.setAttribute("loginMember", login);

			// 로그인 성공시 내보낼 페이지 지정
			response.sendRedirect("index.jsp");

		} else { // 로그인 실패
			// 뷰로 내보낼 메세지 지정과 뷰 파일 지정

			// 상대경로만 사용할 수 있음.
			// 모든 서블릿을 root 에서 실행됨
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			// 지정한 뷰(error.jsp)로 내보낼 값이 있다면
			if (login != null && login.getLoginOk().equals("N")) {
				request.setAttribute("message", "로그인 제한된 회원입니다. 관리자에게 문의하세요.");
			}

			if (login == null) {
				request.setAttribute("message", "로그인 실패! 아이디 또는 암호를 다시 확인하고 로그인하세요.");
			}

			// 요청한 클라이언트로 응답 처리함
			view.forward(request, response);
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
