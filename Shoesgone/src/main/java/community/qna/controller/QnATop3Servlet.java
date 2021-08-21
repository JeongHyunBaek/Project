package community.qna.controller;

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

import community.qna.model.service.QnAService;
import community.qna.model.vo.QnA;

/**
 * Servlet implementation class QnATop3Servlet
 */
@WebServlet("/qnatop3")
public class QnATop3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnATop3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ajax 요청으로 조회수 많은 인기게시글 3개 조회 전송 처리용 컨트롤러
		
		ArrayList<QnA> list = new QnAService().selectTop3();
		
		JSONArray jarr = new JSONArray();
		
		for(QnA QnA : list) {
			JSONObject job = new JSONObject();
			
			job.put("qNo", QnA.getQnANo());
			job.put("btitle", URLEncoder.encode(QnA.getQnATitle(), "utf-8"));
			job.put("rcount", QnA.getQnAReadCount());
			
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
