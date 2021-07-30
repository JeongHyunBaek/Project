package community.best.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardFileDownloadServlet
 */
@WebServlet("/bestfdown")
public class BoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardFileDownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 파일 다운로드 처리용 컨트롤러

		// 현재 파일이 저장된 폴더 지정
		String savePath = request.getSession()
				.getServletContext().getRealPath(
						"/resources/board_upfiles");

		// 전송온 파일명에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("utf-8");

		// 전송온 파일명 추출해서 변수에 저장
		String originalFileName = request.getParameter("ofile");
		String renameFileName = request.getParameter("rfile");

		// 저장 폴더에서 파일읽기용 스트림 생성
		File readFile = new File(savePath + "\\" + renameFileName);
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(readFile));

		// 요청한 클라이언트로 내보낼 출력 스트림 생성
		ServletOutputStream downOut = response.getOutputStream();

		// 파일 다운을 위한 response 설정 처리
		response.setContentType("text/plain; charset=utf-8");
		// 한글 파일명은 다운되는 컴퓨터의 os 문자셋에 맞추기
		response.addHeader("Content-Disposition",
				"attachment; filename=\"" + new String(originalFileName.getBytes("utf-8"), "ISO-8859-1") + "\"");
		response.setContentLength((int) readFile.length());

		// 파일 읽어서 내보내기
		int data = -1;
		while ((data = bin.read()) != -1) {
			downOut.write(data);
			downOut.flush();
		}

		downOut.close();
		bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
