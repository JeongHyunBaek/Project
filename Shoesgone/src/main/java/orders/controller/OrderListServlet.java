package orders.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itemPage.model.service.ItemDetailService;
import itemPage.model.vo.Picture;
import itemregsta.model.vo.ItemRegSta;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/orlist")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 페이지별로 출력되는 주문 상품 조회용 컨트롤러
		request.setCharacterEncoding("utf-8");

		// 1. 상품 상세 페이지 -> 구매 동의 페이지에서 전달받은 Item 객체 list 저장
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		int size = Integer.parseInt(request.getParameter("size"));
		String itemEngName = request.getParameter("itemengname");
		String itemKrName = request.getParameter("itemkrname");
		int userNo = Integer.parseInt(request.getParameter("userno"));

		ArrayList<ItemRegSta> rlist = new ItemDetailService().selectRegList(itemNo, size);

		// 2. 사진 어레이 가져오기
		ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);

		// 3. 주문 등록 페이지로 정보 전달
		RequestDispatcher view = null;
		if(userNo == 0) {
			view = request.getRequestDispatcher("views/loginPage/login.jsp");
			view.forward(request, response);
		} else if (rlist != null || plist != null) {
			view = request.getRequestDispatcher("views/buyPage/select_buy_list.jsp");

			request.setAttribute("rlist", rlist);
			request.setAttribute("plist", plist);
			request.setAttribute("size", size);
			request.setAttribute("itemengname", itemEngName);
			request.setAttribute("itemkrname", itemKrName);

			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", itemNo + "번 아이템 주문 실패");
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
