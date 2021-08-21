package itemPage.controller;

import java.io.File;
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

/**
 * Servlet implementation class AdminItemDeleteServlet
 */
@WebServlet("/itemdelete.ad")
public class AdminItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		String savePath = request.getSession().getServletContext().getRealPath("/resources/img/shoes_images");
		RequestDispatcher view = null;
		//먼저 사진파일삭제
		ArrayList<Picture> pictures = new ItemDetailService().selectPList(itemNo);
		if(pictures.isEmpty()) {
			System.out.println("파일 존재하지 않음");
			//파일 DB삭제
			int result2 = new ItemDetailService().deletePhoto(itemNo);
			int result1 = new ItemDetailService().deleteItem(itemNo);
			if(result2==0 && result1==0) {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "사진 삭제 실패!");
				view.forward(request, response);
			}else {
				response.sendRedirect("/Shoesgone/itemlist.ad");
			}			
		}else {
			for(Picture pic : pictures) {
				String filepath = savePath +"\\"+ pic.getPicturepath();
				File file = new File(filepath);
				file.delete();
			}
			//파일 DB삭제
			int result2 = new ItemDetailService().deletePhoto(itemNo);
			if(result2>0) {
				int result1 = new ItemDetailService().deleteItem(itemNo);
				if(result1>0) {
					response.sendRedirect("/Shoesgone/itemlist.ad");
				}else {
					view = request.getRequestDispatcher("views/common/error.jsp");
					request.setAttribute("message", "물품 삭제 실패!");
					view.forward(request, response);
				}
			}else {
				view = request.getRequestDispatcher("views/common/error.jsp");
				request.setAttribute("message", "사진 삭제 실패!");
				view.forward(request, response);
			}
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
