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
import itemPage.model.vo.Item;

/**
 * Servlet implementation class ItemDetailAdminListServlet
 */
@WebServlet("/itemlist.ad")
public class ItemDetailAdminListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailAdminListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Item> items = new ItemDetailService().selectList();
		//페이지로 이동
				RequestDispatcher view = null;
				if(items != null) {
					view = request.getRequestDispatcher("views/managerPage/adminItem.jsp");
					request.setAttribute("items", items);
					view.forward(request, response);
				} else {
					System.out.println("null");
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "아이템 존재하지 않음");
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
