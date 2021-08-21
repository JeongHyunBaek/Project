package faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faq.model.service.FaqService;
import faq.model.vo.Faq;

/**
 * Servlet implementation class AdminFaqUpdateServlet
 */
@WebServlet("/fupdate.ad")
public class AdminFaqUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFaqUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 원글 수정 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		RequestDispatcher view = null;

		// 5. 데이터베이스 board 테이블에 기록할 값 추출

		Faq faq = new Faq();

		faq.setFaqNo(Integer.parseInt(request.getParameter("faqNo")));
		faq.setFaqTitle(request.getParameter("title"));
		faq.setFaqContent(request.getParameter("content"));


		// 6. 서비스 메소드로 전달하고 결과받기
		int result = new FaqService().adminUpdateFaq(faq);

		// 7. 받은 결과로 성공/실패 페이지 내보내기
		if (result > 0) {
			// 수정 성공시 목록 보기의 해당 페이지 출력 요청
			// response.sendRedirect("blist?page=" + currentPage);

			view = request.getRequestDispatcher("fdetail.ad?faqNo=" + faq.getFaqNo());
			view.forward(request, response);
			// 수정 성공시 해당 글의 상세보기 페이지 출력 요청
			//response.sendRedirect("fdetail.ad?faqNo=" + faq.getFaqNo());

		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", faq.getFaqNo() + "번 게시 원글 수정 실패!");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
