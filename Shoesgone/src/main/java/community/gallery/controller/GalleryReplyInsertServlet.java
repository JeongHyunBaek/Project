package community.gallery.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import community.gallery.model.service.GalleryService;
import community.gallery.model.vo.Gallery;

/**
 * Servlet implementation class GalleryReplyInsertServlet
 */
@WebServlet("/galleryreply")
public class GalleryReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryReplyInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 댓글 등록 처리용 컨트롤러
		//1.
		request.setCharacterEncoding("utf-8");
		
		//2.
		//댓글에 대한 원글 번호 추출
		int GalleryNo = Integer.parseInt(request.getParameter("gNo"));
		int currentPage = Integer.parseInt(request.getParameter("page"));
		
		//댓글에 대한 값 추출해서 객체에 저장
		Gallery reply = new Gallery();
		
		reply.setGalleryTitle(request.getParameter("title"));
		reply.setGalleryWriter(Integer.parseInt(request.getParameter("writer")));
		reply.setGalleryContent(request.getParameter("content"));
		
		//원글 조회
		GalleryService bservice = new GalleryService();
		Gallery origin = bservice.selectGallery(GalleryNo);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
