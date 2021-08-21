package community.best.controller;

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

import community.best.model.service.BestService;
import community.best.model.vo.Best;

/**
 * Servlet implementation class BestTop3Servlet
 */
@WebServlet("/besttop3")
public class BestTop3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestTop3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax 요청으로 조회수 많은 인기게시글 3개 조회 전송 처리용 컨트롤러
		
		ArrayList<Best> list = new BestService().selectTop3();
		
		JSONArray jarr = new JSONArray();
		
		for(Best Best : list) {
			JSONObject job = new JSONObject();
			
			job.put("bNo", Best.getBestNo());
			job.put("btitle", URLEncoder.encode(Best.getBestTitle(), "utf-8"));
			job.put("rcount", Best.getBestReadCount());
			
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
