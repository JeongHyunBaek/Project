package orderlist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderlist.model.service.OrderlistService;
import orderlist.model.vo.Orderlist;

/**
 * Servlet implementation class OrderlistListServlet
 */
@WebServlet("/olist.ad")
public class AdminOrderlistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminOrderlistListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		// 출력할 페이지 지정
		int currentPage = 1;
		
		// 전송 온 페이지 값이 있다면 추출
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		// 한 페이지당 출력할 갯수 설정
		int limit = 1000;
		
		// 총 페이지 수 계산을 위한 목록 조회
		OrderlistService olservice = new OrderlistService();
		int listCount = olservice.adminGetListCount();// 서비스 객체 메소드 실행하고 결과받기
	

		
		// 요청한 페이지의 행번호 계산
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		// 서비스로 해당 페이지에 출력할 제품들만 조회
		ArrayList<Orderlist> list = olservice.adminSelectList(startRow, endRow);
		
		// 출력할 페이지 관련 숫자 처리
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		// 출력할 페이지 그룹의 시작 페이지 지정
		int startPage = ((int)((double)currentPage / limit + 0.9) - 1) * limit + 1;
		int endPage = startPage + limit - 1;
		
		// 총 페이지수와 마지막 페이지 조정
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		// 화면에 출력
		RequestDispatcher view = null;
		
			view = request.getRequestDispatcher("views/managerPage/adminOrdersView.jsp");
			request.setAttribute("list", list);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("startPage", startPage);
			request.setAttribute("endPage", endPage);
			request.setAttribute("listCount", listCount);
		
			
			view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
