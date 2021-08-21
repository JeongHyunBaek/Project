package itemregsta.controller;

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
 * Servlet implementation class RegSelectServlet
 */
@WebServlet("/regselect")
public class RegSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 판매 상품 선택 후 처리용 컨트롤러
		// 1. 상품 상세 페이지 -> 판매 동의 페이지에서 전달받은 Item 객체 저장
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		Item item = new ItemDetailService().selectOne(itemNo);
		int userNo = Integer.parseInt(request.getParameter("userno"));
		
		// 2. 사진 어레이 가져오기
		ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);
		
		// 3. 선택한 사이즈 가져오기
		int size = Integer.parseInt(request.getParameter("size"));
		
		// 4. 판매 등록 페이지로 정보 전달
		RequestDispatcher view = null;
		if(userNo == 0) {
			view = request.getRequestDispatcher("views/loginPage/login.jsp");
			view.forward(request, response);
		} else if(item != null && plist != null) {
			view = request.getRequestDispatcher("views/sellPage/now_sell.jsp");
			
			request.setAttribute("item", item);
			request.setAttribute("plist", plist);
			request.setAttribute("size", size);
			
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", itemNo + "번 아이템 판매 등록 실패");
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
