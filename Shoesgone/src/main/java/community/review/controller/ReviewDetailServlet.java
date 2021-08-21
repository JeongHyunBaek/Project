package community.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.reply.model.service.ReplyService;
import community.reply.model.vo.Reply;
import community.review.model.service.ReviewService;
import community.review.model.vo.Review;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/reviewdetail")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 (원글, 댓글, 대댓글) 상세보기 처리용 컨트롤러
		
		int ReviewNo = Integer.parseInt(request.getParameter("rNo"));
		
		//페이징 처리를 위한 목록 페이지 변수
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		//서비스 객체 메소드 실행하고 결과받기
		ReviewService bservice = new ReviewService();
		
		//해당 글에 대한 조회수 1증가 : update
		bservice.addReadCount(ReviewNo);
		
		//해당 게시글 리턴 받음 : select
		Review Review = bservice.selectReview(ReviewNo);

		ReplyService rservice = new ReplyService();

		
		List<Reply> reply = rservice.selectReplyList(ReviewNo);  
		
		RequestDispatcher view = null;
		if(Review != null) {
			view = request.getRequestDispatcher(
					"views/community/review/reviewDetailView.jsp");
			request.setAttribute("review", Review);
			request.setAttribute("replyList", reply);
			request.setAttribute("currentPage", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", 
					ReviewNo + "번 게시글 상세조회 실패!");
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
