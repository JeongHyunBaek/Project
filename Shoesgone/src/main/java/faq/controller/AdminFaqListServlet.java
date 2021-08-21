package faq.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;

/**
 * Servlet implementation class FaqListServlet
 */
@WebServlet("/flist.ad")
public class AdminFaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFaqListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//출력할 페이지 지정
		int currentPage = 1;
		//전송온 페이지 값이 있다면 추출함
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//한 페이지당 출력할 목록 갯수 지정
		int limit = 10;
		
		//조회용 서비스 객체 생성
		FaqService fservice = new FaqService();
		
		//총 페이지수 계산을 위한 목록 갯수 조회
		int listCount = fservice.getListCount();
		
		
		//요청한 페이지의 출력될 목록의 행번호를 계산
		//한 페이지에 출력할 목록 갯수가 10개인 경우
		//3page 가 요청되었다면 행번호는 21 ~ 30행임.
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		//서비스로 해당 페이지에 출력할 게시글만 조회해 옴
		ArrayList<Faq> list = fservice.selectList(startRow, endRow);
		
		//뷰 페이지로 같이 내보낼 페이지 관련 숫자 계산 처리
		//총 페이지 수 : 총 목록이 21개인 경우
		//한 페이지에 출력할 목록이 10개이면, 페이지는 3임
		int maxPage = (int)((double)listCount / limit + 0.9);
		
		//뷰에 출력할 페이지그룹의 시작 페이지 지정
		//뷰 목록 아래쪽에 페이지 숫자를 10를 출력한다면..
		//현재 페이지가 3페이지이면, 페이지 그룹은 1 ~10 이 됨
		//현재 페이지가 15페이지이면, 페이지 그룹은 11~20 이 됨
		int startPage = (((int)((double)currentPage / limit + 0.9)) - 1)
				* limit + 1;
		int endPage = startPage + limit - 1;
		
		//총페이수 숫자와 페이지 그룹의 마지막 숫자 조정
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		//뷰 지정해서 내보내기
		RequestDispatcher view = null; 
	
        	

	
			view = request.getRequestDispatcher(
					"views/customerservicePage/adminfaqlistView.jsp");
			
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
