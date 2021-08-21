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
import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;
import itemregsta.model.service.ItemRegStaService;
import itemregsta.model.vo.ItemRegSta;

/**
 * Servlet implementation class OrderSelectServlet
 */
@WebServlet("/orderselect")
public class OrderSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderSelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 주문 상품 선택 후 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		// 1. 선택 화면에서 넘어온 값 받아오기
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		int regNo = Integer.parseInt(request.getParameter("regno"));
		
		// 2. 사진 어레이 가져오기
		ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);
		
		// 3. 값에 맞는 Item객체와 ItemRegSta 객체 가져오기
		Item item = new ItemDetailService().selectOne(itemNo);
		ItemRegSta reg = new ItemRegStaService().selectOne(regNo);
		
		// 4. 구매 등록 페이지로 전달
		RequestDispatcher view = null;
		if(reg != null && plist != null) {
			view = request.getRequestDispatcher("views/buyPage/now_buy.jsp");
			
			request.setAttribute("item", item);
			request.setAttribute("reg", reg);
			request.setAttribute("reg", reg);
			request.setAttribute("plist", plist);
			
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", itemNo + "번 상품 구매 등록 실패");
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
