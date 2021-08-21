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
 * Servlet implementation class RegInsertServlet
 */
@WebServlet("/regteninsert")
public class RegTenderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegTenderInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 판매 상품 등록 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		
		// 1. item_reg_sta 테이블에 저장할 값 추출
		ItemRegSta reg = new ItemRegSta();
		
		reg.setUserNo(Integer.parseInt(request.getParameter("userno")));
		reg.setItemNo(Integer.parseInt(request.getParameter("itemno")));
		reg.setSize(Integer.parseInt(request.getParameter("size")));
		reg.setPrice(Integer.parseInt(request.getParameter("price")));
		reg.setAddress(request.getParameter("address") + " " +request.getParameter("detailaddress"));
		reg.setPenalty(request.getParameter("penalty"));
		
		// 2. 서비스 메소드로 전달하고 결과받기
		int result = new ItemRegStaService().insertRegTen(reg);
		
		// 3. 받은 결과 가지고 성공|실패 페이지 출력
		RequestDispatcher view = null;
		if(result > 0) {
			// 판매 등록 완료 페이지로 전달
			view = request.getRequestDispatcher("views/sellPage/sell_complete.jsp");
			
			request.setAttribute("itemno", request.getParameter("itemno"));
			request.setAttribute("size", request.getParameter("size"));
			
			view.forward(request, response);
		}else {
			// 에러 페이지로 연결
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "새 상품 판매 등록 실패!");
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
