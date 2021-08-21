package community.qna.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.qna.model.service.QnAService;
import community.qna.model.vo.QnA;

/**
 * Servlet implementation class QnAReplyUpdateServlet
 */
@WebServlet("/qnareplyupdate")
public class QnAReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAReplyUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 댓글/대댓글 수정 처리용 컨트롤러
		
		request.setCharacterEncoding("utf-8");
		
		QnA reply = new QnA();
		reply.setQnANo(Integer.parseInt(
				request.getParameter("qNo")));
		reply.setQnATitle(request.getParameter("title"));
		reply.setQnAContent(request.getParameter("content"));
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		int result = new QnAService().updateReply(reply);
				
		if (result > 0) {
			//수정 성공시 목록 보기의 해당 페이지 출력 요청
			//response.sendRedirect("blist?page=" + currentPage);
			
			//수정 성공시 해당 글의 상세보기 페이지 출력 요청
			response.sendRedirect("qnadetail?qNo=" 
						+ reply.getQnANo()+ "&page="
						+ currentPage);
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", 
					reply.getQnANo() + "번 게시 원글 수정 실패!");
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
