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
 * Servlet implementation class OrdersUpdateServlet
 */
@WebServlet("/orderupdate")
public class OrdersUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 주문 배송지 수정 처리용 컨트롤러
		// 1. 수정이 필요한 주문 상품 정보 조회
		Orders upAdd = new Orders();
		
		// 2. 수정된 배송지로 변경
		upAdd.setAddress(request.getParameter("address") + " " + request.getParameter("detailaddress"));
		upAdd.setOrdersNo(Integer.parseInt(request.getParameter("ordersno")));
		
		// 3. 서비스 메소드에 전달하고 결과받기
		int result = new OrdersService().updateAddress(upAdd);
		
		// 4. 성공|실패 출력
		RequestDispatcher view = null;
		if(result > 0) {
			// 수정 성공 페이지 출력
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "배송지 수정 실패");
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
