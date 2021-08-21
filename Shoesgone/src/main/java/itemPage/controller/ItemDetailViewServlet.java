package itemPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.review.model.vo.Review;
import itemPage.model.service.ItemDetailService;
import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;
import orders.model.vo.Orders;

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
		//물품객체 가져오기
		int itemNo = Integer.parseInt(request.getParameter("itemno"));
		Item item = new ItemDetailService().selectOne(itemNo);
		//사진 어레이 가져오기
		ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);
		//사이즈 어레이 가져오기
		String[] ssizes = item.getShoesSizes().split(",");
		ArrayList<Integer> isizes = new ArrayList<Integer>(ssizes.length);
		for(String s:ssizes){
			isizes.add(Integer.parseInt(s));
		}
		//리뷰 목록 가져오기
		ArrayList<Review> rlist = new ItemDetailService().selectRlist(itemNo);
		
		//관련 제품 가져오기
		ArrayList<Picture> rplist = new ItemDetailService().selectRPList(itemNo, item.getBrand());
		ArrayList<String> rpnames = new ArrayList<String>();
		for(Picture rp:rplist) {
			Item rpitem = new ItemDetailService().selectOne(rp.getModelno());
			String rpname = rpitem.getItemEngName();
			rpnames.add(rpname);
		}
		
		//가장 최근 판매목록들 가져오기
		ArrayList<Orders> olist = new ItemDetailService().selectOrders(itemNo);
		//판매정보 가져오기
		//페이지로 이동
		RequestDispatcher view = null;
		if(item != null && plist != null) {
			view = request.getRequestDispatcher("views/itemPage/itemDetailView.jsp");
			request.setAttribute("item", item);
			request.setAttribute("plist", plist);
			request.setAttribute("isizes", isizes);
			request.setAttribute("rlist", rlist);
			request.setAttribute("rplist", rplist);
			request.setAttribute("rpnames", rpnames);
			request.setAttribute("olist", olist);
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
