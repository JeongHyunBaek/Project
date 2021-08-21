package categoryPage.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;


import categoryPage.model.dao.NoticeDao;
import categoryPage.model.vo.Notice;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();

	// NoticeDao의 selectNoticeList() 값을 받아서 전달하는 메소드
	public ArrayList<Notice> selectNoticeList() {
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectNoticeList(conn);
		close(conn);
		return list;
	}
}
