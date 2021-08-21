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

/**
 * Servlet implementation class BuyAcceptViewServlet
 */
@WebServlet("/buyaccept")
public class BuyAcceptViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyAcceptViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 구매 선택 처리용 컨트롤러
		// Item 객체 생성
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		Item item = new ItemDetailService().selectOne(itemNo);
		
		//사진 어레이 가져오기
		ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);
				
		// 사이즈 어레이 가져오기
		String[] ssizes = item.getShoesSizes().split(",");
		ArrayList<Integer> isizes = new ArrayList<Integer>(ssizes.length);
		for(String s:ssizes){
			isizes.add(Integer.parseInt(s));
		}
				
		// 판매 정보 가져오기
		// 페이지 출력
		RequestDispatcher view = null;
		if(item != null && plist != null) {
			view = request.getRequestDispatcher("views/buyPage/buy_accept.jsp");
			request.setAttribute("item", item);
			request.setAttribute("plist", plist);
			request.setAttribute("isizes", isizes);
			view.forward(request, response);
		}else {
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
