package information.controller;

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

import information.model.vo.Information;
import information.model.service.InformationService;

/**
 * Servlet implementation class InformationUpdateServlet
 */
@WebServlet("/iupdate")
public class InformationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 수정 처리용 컨트롤러
				// 1.
				request.setCharacterEncoding("utf-8");

				// 2.
				Information information = new Information();
				
				information.setUserId(request.getParameter("userid"));
				information.setUserName(request.getParameter("username"));
				information.setEmail(request.getParameter("email"));
				information.setPhone(request.getParameter("phone"));
				information.setAddress(String.join(",", request.getParameterValues("address")));
				information.setShoesSize(Integer.parseInt(request.getParameter("shoesize")));
				information.setBankName(request.getParameter("bankname"));
				information.setAccountNo(request.getParameter("accountno"));
				

				// 웹에서는 단방향 알고리즘 적용 : SHA-512
				// 단방향 : 암호화만 하고, 복호화가 안되는 알고리즘
				// java.security.MessageDigest 클래스 이용함
				String userpwd = request.getParameter("userpwd");
				String cryptoUserpwd = null;
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-512");
					// 패스워드 문자열을 암호문으로 바꾸려면, btye[]로 변환해야 함
					byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
					// 암호문으로 바꾸기
					md.update(pwdValues);
					// 암호화된 btye[]을 String으로 바꿈 : 암호문 상태임
					cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
					// 확인
					System.out.println(cryptoUserpwd);
					System.out.println(cryptoUserpwd.length());
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
				information.setUserPwd(cryptoUserpwd);

				// 3.
				int result = new InformationService().updateMember(information);

				// 4.
				if (result > 0) {
					// 서블릿에서 서블릿 호출 : myinfo 서블릿 호출
					RequestDispatcher view = request.getRequestDispatcher("ilist?userid=" 
									+ information.getUserId());
					view.forward(request, response);
//					response.sendRedirect("/Shoesgone/ilist?userid=" 
//									+ information.getUserId());
				
				} else {
					RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", information.getUserId() + " 회원 정보 수정 실패!");
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
