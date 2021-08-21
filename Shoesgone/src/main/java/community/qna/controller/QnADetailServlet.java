package community.qna.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.qna.model.service.QnAService;
import community.qna.model.vo.QnA;
import community.reply.model.service.ReplyService;
import community.reply.model.vo.Reply;

/**
 * Servlet implementation class QnADetailServlet
 */
@WebServlet("/qnadetail")
public class QnADetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnADetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 (원글, 댓글, 대댓글) 상세보기 처리용 컨트롤러
		
		int QnANo = Integer.parseInt(request.getParameter("qNo"));
		
		//페이징 처리를 위한 목록 페이지 변수
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//서비스 객체 메소드 실행하고 결과받기
		QnAService bservice = new QnAService();
		
		//해당 글에 대한 조회수 1증가 : update
		bservice.addReadCount(QnANo);
		
		//해당 게시글 리턴 받음 : select
		QnA QnA = bservice.selectQnA(QnANo);

		ReplyService rservice = new ReplyService();

		
		List<Reply> reply = rservice.selectReplyList(QnANo);  
		
		RequestDispatcher view = null;
		if(QnA != null) {
			view = request.getRequestDispatcher(
					"views/community/qna/qnaDetailView.jsp");
			request.setAttribute("qna", QnA);
			request.setAttribute("replyList", reply);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", 
					QnANo + "번 게시글 상세조회 실패!");
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
