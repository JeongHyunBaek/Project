package community.review.controller;

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

import community.review.model.service.ReviewService;
import community.review.model.vo.Review;

/**
 * Servlet implementation class ReviewTop3Servlet
 */
@WebServlet("/reviewtop3")
public class ReviewTop3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewTop3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax 요청으로 조회수 많은 인기게시글 3개 조회 전송 처리용 컨트롤러
		
		ArrayList<Review> list = new ReviewService().selectTop3();
		
		JSONArray jarr = new JSONArray();
		
		for(Review Review : list) {
			JSONObject job = new JSONObject();
			
			job.put("rNo", Review.getReviewNo());
			job.put("btitle", URLEncoder.encode(Review.getReviewTitle(), "utf-8"));
			job.put("rcount", Review.getReviewReadCount());
			
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
