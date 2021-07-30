package loginPage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import loginPage.model.service.LoginService;
import loginPage.model.vo.Login;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet("/searchid")
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String phone = request.getParameter("phone");
		Login login = new LoginService().searchId(phone);

		// 데이터베이스에 전화번호 값 유무에 따른 화면 구현
		if (login != null) {
			RequestDispatcher view = null;
			
			view = request.getRequestDispatcher("views/loginPage/resultId.jsp");
			
	        request.setAttribute("login", login);
	        
	        view.forward(request, response);
		} else { 
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('일치하는 사용자 정보를 찾을 수 없습니다.'); location.href='/Shoesgone/views/loginPage/searchId.jsp';</script>");

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

}
