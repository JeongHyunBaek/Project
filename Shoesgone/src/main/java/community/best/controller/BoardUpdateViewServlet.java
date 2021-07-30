package community.best.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.best.model.service.BoardService;
import community.best.model.vo.Board;

/**
 * Servlet implementation class BoardUpdateViewServlet
 */
@WebServlet("/bestupview")
public class BoardUpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 수정페이지 출력 처리용 컨트롤러
		
		int boardNum = Integer.parseInt(request.getParameter("cnum"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		Board board = new BoardService().selectBoard(boardNum);
		
		RequestDispatcher view = null;
		if(board != null) {
			view = request.getRequestDispatcher(
					"views/community/communityUpdateView.jsp");
			request.setAttribute("board", board);
			request.setAttribute("page", currentPage);
			view.forward(request, response);
		}else {
			view = request.getRequestDispatcher(
					"views/common/error.jsp");
			request.setAttribute("message", 
					boardNum + "번 게시글 수정페이지로 이동 실패!");
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
