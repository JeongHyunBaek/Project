package wishlist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wishlist.model.service.WishlistService;

/**
 * Servlet implementation class WishlistAllDeleteServlet
 */
@WebServlet("/walldelete")
public class WishlistAllDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistAllDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		

		// 서비스 메소드로 삭제 실행하고 결과받기
		if (new WishlistService().deleteAll(userNo) > 0) {
			RequestDispatcher view = request.getRequestDispatcher("wlist?userNo="+ userNo);
			view.forward(request, response);
			//response.sendRedirect("/Shoesgone/wlist?userNo="+ userNo);
		} else if(new WishlistService().getListCount(userNo) == 0){
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message",  "삭제할 위시리스트가 없습니다.");
			view.forward(request, response);
		}
		else{
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message",  "전체 삭제 실패.");
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
