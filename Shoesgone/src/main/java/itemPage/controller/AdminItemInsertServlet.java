package itemPage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import itemPage.model.service.ItemDetailService;
import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;

/**
 * Servlet implementation class AdminItemInsertServlet
 */
@WebServlet("/iteminsert.ad")
public class AdminItemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminItemInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. multipart 방식으로 인코딩되어서 전송왔는지 확인
		// 아니면 에러 페이지를 내보냄
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "form 의 enctype='multipart/form-data' 속성 누락됨.");
			view.forward(request, response);
		}
		// 2. 업로드할 파일의 용량제한 : 10메가바이트로 제한한다면
		int maxSize = 1024 * 1024 * 10;
		
		// 3. 업로드되는 파일의 저장 폴더 지정
		String savePath = request.getSession().getServletContext().getRealPath("/resources/img/shoes_images");
		
		// 4. request 를 MultipartRequest 로 변환해야 함
		// cos.jar 가 제공하는 클래스를 사용
		// MultipartRequest 객체가 생성되면,
		// 자동으로 폴더에 파일이 저장됨
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",new DefaultFileRenamePolicy());
		//Date형식으로 변환
		String from = mrequest.getParameter("itemdropdate");
		Date to = Date.valueOf(from);
		// 5. 데이터베이스 board 테이블에 기록할 값 추출
		// mrequest 사용해야 함 (request 사용 못 함)
		Item item = new Item();
		
		item.setItemEngName(mrequest.getParameter("itemengname"));
		item.setItemKrName(mrequest.getParameter("itemkrname"));
		item.setBrand(mrequest.getParameter("itembrand"));
		item.setModelNo(mrequest.getParameter("itemmodelno"));
		item.setShoesColors(mrequest.getParameter("itemcolors"));
		item.setPrice(Integer.parseInt(mrequest.getParameter("itemprice")));
		item.setDropDate(to);
		String[] sizes = mrequest.getParameterValues("shoessize");
		//문자열배열을 하나의 String 으로 변환함, 구분자는 "," 사용한다면
		String size = String.join(",", sizes);
		item.setShoesSizes(size);
		
		//물품객체 저장
		int result1 = new ItemDetailService().insertItem(item);
		
		if(result1>0) {
			ArrayList<String> pictures = new ArrayList<String>();
			@SuppressWarnings("rawtypes")
			Enumeration files = mrequest.getFileNames();
			while(files.hasMoreElements()) {
				String name = (String)files.nextElement();
				String file_name = mrequest.getFilesystemName(name);
				pictures.add(file_name);
			}
			if(pictures.isEmpty()) {
				response.sendRedirect("/Shoesgone/itemlist.ad");
			}
			System.out.println(pictures);
			//파일들을 하나씩 insert 처리함
			if(pictures!=null) {
				for(int i=0; i<pictures.size(); i++) {
					Picture picture = new Picture();
					String originalFilename = pictures.get(i);
					String renameFilename = "";
					
					renameFilename += mrequest.getParameter("itemmodelno") + "_" + 
								String.valueOf(i) + "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);;
					
					File originFile = new File(savePath + "\\" + originalFilename);
					File renameFile = new File(savePath + "\\" + renameFilename);
					
					if (!originFile.renameTo(renameFile)) {
						// renameTo() 메소드가 실패한 경우(false)
						// 직접 수동으로 바꾸기함
						// 원본 파일 읽어서 파일복사하고,
						// 원본 파일 삭제로 처리함

						FileInputStream fin = new FileInputStream(originFile);
						FileOutputStream fout = new FileOutputStream(renameFile);
						
						int data = -1;
						byte[] buffer = new byte[1024];

						while ((data = fin.read(buffer, 0, buffer.length)) != -1) {
							fout.write(buffer, 0, buffer.length);
						}

						fin.close();
						fout.close();
						originFile.delete(); // 원본 파일 삭제함
					} // 직접 이름바꾸기

					picture.setPicturepath(renameFilename);
					
					int result2 = new ItemDetailService().insertPicture(picture);
					
					if(result2<=0) {
						view = request.getRequestDispatcher("views/common/error.jsp");
						request.setAttribute("message", i + "번째 사진 등록 실패!");
						view.forward(request, response);
					}else if(result2>0 && i==pictures.size()-1) {
						response.sendRedirect("/Shoesgone/itemlist.ad");
					}
				} 
			}
		}else {
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "새 물품 등록 실패!");
			view.forward(request, response);
		}
		// 업로드된 원본 파일이름들 추출
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
