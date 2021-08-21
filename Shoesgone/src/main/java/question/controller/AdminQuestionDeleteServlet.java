package question.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import question.model.service.QuestionService;

/**
 * Servlet implementation class AdminQuestionDeleteServlet
 */
@WebServlet("/qudelete.ad")
public class AdminQuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQuestionDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionNo = Integer.parseInt(request.getParameter("questionNo"));
		int questionLevel = Integer.parseInt(request.getParameter("level"));
		
		//서비스 메소드로 삭제 실행하고 결과받기		
		if(new QuestionService().adminDeleteQuestion(questionNo, questionLevel) > 0) {
			//받은 결과가 성공일 때, 저장 폴더의 파일도 삭제 처리함
			RequestDispatcher view = request.getRequestDispatcher("qulist.ad?page=1");
			view.forward(request, response);
			
			//response.sendRedirect("/Shoesgone/qulist.ad?page=1");
		}else {
			RequestDispatcher view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", questionNo + "번 글 삭제 실패.");
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
