package itemregsta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itemregsta.model.service.ItemRegStaService;
import itemregsta.model.vo.ItemRegSta;

/**
 * Servlet implementation class RegUpdateServlet
 */
@WebServlet("/itemregupdate")
public class RegUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 판매 등록 상품 수정 처리용 컨트롤러
		// 1. 수정할 정보 저장용 객체 생성
		ItemRegSta upReg = new ItemRegSta();
		
		// 2. 수정 정보 객체에 저장
		upReg.setPrice(Integer.parseInt(request.getParameter("price")));
		upReg.setSize(Integer.parseInt(request.getParameter("size")));
		
		// 3. 서비스 메소드로 전달하고 결과받기
		int result = new ItemRegStaService().updateReg(upReg);
		
		// 4. 성공|실패 결과 출력
		RequestDispatcher view = null;
		if(result > 0) {
			// 즉시 구매 화면으로 전달
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "판매 상품 수정 실패");
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
