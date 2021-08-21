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
 * Servlet implementation class MenubarSearchEnterServlet
 */
@WebServlet("/menubarsearchenter")
public class MenubarSearchEnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenubarSearchEnterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String text = request.getParameter("text");
		ArrayList<ItemPicture> item = new ItemPictureService().selectSearchList(text);
		
		RequestDispatcher view = null;
		
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
