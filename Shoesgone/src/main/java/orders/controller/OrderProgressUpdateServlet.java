package orders.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.model.service.OrdersService;
import orders.model.vo.Orders;

/**
 * Servlet implementation class OrderProgressUpdateServlet
 */
@WebServlet("/progressupdate")
public class OrderProgressUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderProgressUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주문 상품 배송현황 갱신용 컨트롤러
		// 이 서블릿은 관리자가 사용할 서블릿입니ㅏㄷ.
		// 1. 배송현황 저장용 객체 생성 및 저장
		Orders upProgress = new Orders();
		upProgress.setProgress(request.getParameter("progress"));
		upProgress.setOrdersNo(Integer.parseInt(request.getParameter("ordersno")));
		
		// 2. 서비스 메소드에 전달하고 결과받기
		int result = new OrdersService().updateProgress(upProgress);
		
		// 3. 성공|실패 출력
		RequestDispatcher view = null;
		if(result > 0) {
			// 성공시 출력할 페이지로 연결
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "배송현황 갱신 실패");
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
