package information.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import information.model.service.InformationService;
import information.model.vo.Information;

/**
 * Servlet implementation class InformationListServlet
 */
@WebServlet("/ilist")
public class InformationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InformationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 내 정보보기(My Page) 요청 처리용 컨트롤러
		//1. 전송온 값에 한글있으면 인코딩함
		//2. 전송온 값 꺼내서 변수 또는 객체에 기록하기
		String userid = request.getParameter("userid");
		
		//3. 서비스 메소드 실행하고 결과받기
		Information information = new InformationService().selectMember(userid);
		
		//4. 받은 결과로 성공/실패에 대한 뷰 내보냄
		RequestDispatcher view = null;
		if(information != null) {
			view = request.getRequestDispatcher(
					"views/myPage/infomodify.jsp");
			request.setAttribute("information", information);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", userid 
					+ " 회원정보 조회 실패!");
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
