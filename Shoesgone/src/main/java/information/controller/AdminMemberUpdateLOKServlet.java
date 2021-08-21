package information.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import information.model.service.InformationService;
import information.model.vo.Information;

/**
 * Servlet implementation class AdminMemberUpdateMGRServlet
 */
@WebServlet("/updatelok.ad")
public class AdminMemberUpdateLOKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateLOKServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MGR 변환 서블릿
		//넘어온 userno 로 원래 값 불러오기
		int result = 0;
		int userno = Integer.parseInt(request.getParameter("userno"));
		Information user = new InformationService().adminselectMGRLOKMember(userno);
		//user의 값중에 MGR값 확인 후 변경
		if(user.getLoginOk().equals("Y")) {
			String lokstatus = "N";
			result = new InformationService().adminupdateLOK(userno, lokstatus);
		}else {
			String lokstatus = "Y";
			result = new InformationService().adminupdateLOK(userno, lokstatus);
		}
		
		if (result > 0) {
			// 서블릿에서 서블릿 호출 : myinfo 서블릿 호출
			response.sendRedirect("/Shoesgone/memberlist.ad");
		
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "회원 정보 수정 실패!");
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
