package categoryPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import categoryPage.model.service.ItemPictureService;
import categoryPage.model.vo.ItemPicture;

/**
 * Servlet implementation class CategoryItemServlet
 */
@WebServlet("/categorysort")
public class CategorySortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySortServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String sortValue = null;
		ArrayList<ItemPicture> item = null;
		
		// 정렬 기준 값
		sortValue = request.getParameter("sortValue");
		
		// 상품 페이지에 보낼 정렬 리스트 값
		if (sortValue == null) {
			item = new ItemPictureService().selectLookupList();
		} else if (sortValue.equals("sort-hot")) {
			item = new ItemPictureService().selectHotList();
		} else if (sortValue.equals("sort-premium")) {
			item = new ItemPictureService().selectPremiumList();
		} else if (sortValue.equals("sort-buy")) {
			item = new ItemPictureService().selectBuyList();
		} else if (sortValue.equals("sort-sell")) {
			item = new ItemPictureService().selectSellList();
		} else if (sortValue.equals("sort-drop")) {
			item = new ItemPictureService().selectDropList();
		}
		
		RequestDispatcher view = null;
		
		// 데이터베이스 조회 성공에 따른 값 전달
		if (item.size() > 0) {
			view = request.getRequestDispatcher("views/categoryPage/category.jsp");
			
			request.setAttribute("item", item);
			if (sortValue == null) {
				request.setAttribute("sort", "");
			} else {
				request.setAttribute("sort", sortValue);
			}
			
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			
			request.setAttribute("message", "상품 조회 실패");
			
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
