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
import itemPage.model.vo.Picture;

/**
 * Servlet implementation class ItemDetailViewServlet
 */
@WebServlet("/ItemDV")
public class ItemDetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//제품 상세보기 페이지 redirect용 서블렛
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		Item item = new ItemDetailService().selectOne(itemNo);
		ArrayList<Picture> plist = new ItemDetailService().selectPList(item.getModelNo());
		if(plist==null) {
			System.out.println("null");
		}
		RequestDispatcher view = null;
		if(item != null && plist != null) {
			view = request.getRequestDispatcher("views/itemPage/itemDetailView.jsp");
			request.setAttribute("item", item);
			request.setAttribute("plist", plist);
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
