package question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.model.service.QuestionService;
import question.model.vo.Question;

/**
 * Servlet implementation class QuestionDetailServlet
 */
@WebServlet("/qudetail.ad")
public class AdminQuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminQuestionDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));

		// 페이징 처리를 위한 목록 페이지 변수
		int currentPage = 1;
		if (request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}

		// 서비스 객체 메소드 실행하고 결과받기
		QuestionService qservice = new QuestionService();

		// 해당 글에 대한 조회수 1증가 : update
		qservice.updateReadCount(questionNo);

		// 해당 게시글 리턴 받음 : select
		Question question = qservice.selectOne(questionNo);

		RequestDispatcher view = null;

		view = request.getRequestDispatcher("views/customerservicePage/adminQuestionDetailView.jsp");
		request.setAttribute("question", question);
		request.setAttribute("currentPage", currentPage);
		view.forward(request, response);

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
