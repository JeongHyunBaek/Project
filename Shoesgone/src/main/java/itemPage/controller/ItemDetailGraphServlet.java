package itemPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itemPage.model.service.ItemDetailService;
import orders.model.vo.SalesList;

/**
 * Servlet implementation class ItemDetailGraphServlet
 */
@WebServlet("/ItemDG")
public class ItemDetailGraphServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailGraphServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		int size = Integer.parseInt(request.getParameter("option1"));
		int days = Integer.parseInt(request.getParameter("option2"));
		
		ArrayList<SalesList> orderlist = new ItemDetailService().selectOrderList(itemNo, size, days);
		RequestDispatcher view = null;
		if(orderlist != null) {
			view = request.getRequestDispatcher("views/itemPage/graphView.jsp");
			request.setAttribute("olist", orderlist);
			request.setAttribute("sortno", days);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", itemNo + "번 아이템 존재하지 않음");
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
