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
 * Servlet implementation class CategoryFilterServlet
 */
@WebServlet("/categoryfilter")
public class CategoryFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String size = request.getParameter("size");
		String priceone = request.getParameter("priceone");
		String pricetwo = request.getParameter("pricetwo");
		String collection = request.getParameter("collection");
		ArrayList<ItemPicture> item = null;
		
		// 카테고리 종류에 따른 조건문
		if (category.equals("sneakers")) {
			item = new ItemPictureService().selectSneakersList();
		} else if (category.equals("brand")) {
			item = new ItemPictureService().selectBrandList(brand);
		} else if (category.equals("size")) {
			item = new ItemPictureService().selectShoesSizeList(size);
		} else if (category.equals("price1")) {
			item = new ItemPictureService().selectPrice1List(priceone);
		} else if (category.equals("price2")) {
			item = new ItemPictureService().selectPrice2List(priceone, pricetwo);
		} else if (category.equals("price3")) {
			item = new ItemPictureService().selectPrice3List(priceone);
		} else if (category.equals("collection")) {
			item = new ItemPictureService().selectCollectionList(collection);
		}
		
		RequestDispatcher view = null;
		
		// 데이터베이스 조회 성공에 따른 값 전달
		if (item.size() > 0) {
			view = request.getRequestDispatcher("views/categoryPage/category.jsp");
			
			request.setAttribute("item", item);
			request.setAttribute("sort", "");

			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/categoryPage/category.jsp");

			request.setAttribute("item", item);
			request.setAttribute("sort", "");

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
