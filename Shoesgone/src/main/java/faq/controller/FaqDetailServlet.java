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
 * Servlet implementation class FaqDetailServlet
 */
@WebServlet("/fdetail")
public class FaqDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FaqDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int faqNo = Integer.parseInt(request.getParameter("faqNo"));

		// 페이징 처리를 위한 목록 페이지 변수
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 서비스 객체 메소드 실행하고 결과받기
		FaqService fservice = new FaqService();

		// 해당 글에 대한 조회수 1증가 : update
		fservice.updateReadCount(faqNo);

		// 해당 게시글 리턴 받음 : select
		Faq faq = fservice.selectOne(faqNo);

		RequestDispatcher view = null;
		if (faq != null) {
			view = request.getRequestDispatcher("views/customerservicePage/faqDetailView.jsp");
			request.setAttribute("faq", faq);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		} else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", faqNo + "번 공지글 상세조회 실패!");
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
