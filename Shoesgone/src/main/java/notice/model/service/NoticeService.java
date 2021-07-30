package notice.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	public ArrayList<Notice> selectList(){
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectList(conn);
		close(conn);
		return list;
	}
	
	public Notice selectOne(int noticeNo) {
		Connection conn = getConnection();
		Notice notice = ndao.selectOne(conn, noticeNo);
		close(conn);
		return notice;
	}
	

	
	public void updateReadCount(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.updateReadCount(conn, noticeNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = ndao.getListCount(conn);
		close(conn);
		return listCount;
	}


}