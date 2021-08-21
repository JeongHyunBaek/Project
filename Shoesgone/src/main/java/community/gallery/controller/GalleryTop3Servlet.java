package community.gallery.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import community.gallery.model.service.GalleryService;
import community.gallery.model.vo.Gallery;

/**
 * Servlet implementation class GalleryTop3Servlet
 */
@WebServlet("/gallerytop3")
public class GalleryTop3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryTop3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax 요청으로 조회수 많은 인기게시글 3개 조회 전송 처리용 컨트롤러
		
		ArrayList<Gallery> list = new GalleryService().selectTop3();
		
		JSONArray jarr = new JSONArray();
		
		for(Gallery Gallery : list) {
			JSONObject job = new JSONObject();
			
			job.put("gNo", Gallery.getGalleryNo());
			job.put("btitle", URLEncoder.encode(Gallery.getGalleryTitle(), "utf-8"));
			job.put("rcount", Gallery.getGalleryReadCount());
			
			jarr.add(job);
		}
		
		JSONObject sendJson = new JSONObject();
		sendJson.put("list", jarr);
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out  =  response.getWriter();
		out.write(sendJson.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
