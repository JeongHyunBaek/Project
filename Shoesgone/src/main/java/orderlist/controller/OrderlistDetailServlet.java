package orderlist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.model.service.OrderlistService;
import orderlist.model.vo.Orderlist;

/**
 * Servlet implementation class OrderlistDetailServlet
 */
@WebServlet("/odetail")
public class OrderlistDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderlistDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));

		// 페이징 처리를 위한 목록 페이지 변수
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 서비스 객체 메소드 실행하고 결과받기
		OrderlistService olservice = new OrderlistService();

		// 해당 게시글 리턴 받음 : select
		Orderlist orderlist = olservice.selectOne(orderNo);

		RequestDispatcher view = null;
		if (orderlist != null) {
			view = request.getRequestDispatcher("views/myPage/orderdetail.jsp");
			request.setAttribute("orderlist", orderlist);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", orderlist + "번 주문내 상세조회 실패!");
			view.forward(request, response);
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
