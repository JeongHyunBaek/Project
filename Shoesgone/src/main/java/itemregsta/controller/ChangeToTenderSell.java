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
 * Servlet implementation class ChangeToTender
 */
@WebServlet("/tendersell")
public class ChangeToTenderSell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeToTenderSell() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 즉시 판매에서 판매 입찰 화면으로 전환 처리용 컨트롤러
		// 1. 즉시 판매에서 객체 받아오기
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		Item item = new ItemDetailService().selectOne(itemNo);
		
		// 2. 사진 어레이 가져오기
		ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);
		
		// 3. 선택한 사이즈 가져오기
		int size = Integer.parseInt(request.getParameter("size"));
		
		// 4. 판매 등록 페이지로 정보 전달
		RequestDispatcher view = null;
		if(item != null && plist != null) {
			view = request.getRequestDispatcher("views/sellPage/tender_sell.jsp");
					
			request.setAttribute("item", item);
			request.setAttribute("plist", plist);
			request.setAttribute("size", size);
					
			view.forward(request, response);
		}else {
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
