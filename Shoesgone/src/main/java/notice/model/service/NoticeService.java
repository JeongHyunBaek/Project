package notice.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;


import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import question.model.vo.Question;


public class NoticeService {
	private NoticeDao ndao = new NoticeDao();
	
	public ArrayList<Notice> selectList(int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Notice> list = ndao.selectList(conn, startRow, endRow);
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

	public int insertNotice(Notice notice) {
		Connection conn = getConnection();
		int result = ndao.insertNotice(conn, notice);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int adminDeleteNotice(int noticeNo) {
		Connection conn = getConnection();
		int result = ndao.adminDeleteNotice(conn, noticeNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}



	public int adminUpdateNotice(Notice notice) {
		
			Connection conn = getConnection();
			int result = ndao.adminUpdateNotice(conn, notice);
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		}
	}
