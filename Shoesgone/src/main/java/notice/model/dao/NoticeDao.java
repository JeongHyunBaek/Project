package notice.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;

public class NoticeDao {

	//공지사항 전체조회 : 공지사항 목록보기용
	public ArrayList<Notice> selectList(Connection conn){
		ArrayList<Notice> list = new ArrayList<Notice>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice "
				+ "order by noticeno desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeContent(rset.getString("noticecontent"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				
				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	
	//공지글번호로 한 개 조회 : 공지사항 상세보기용
	public Notice selectOne(Connection conn, int noticeNo) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from notice where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeContent(rset.getString("noticecontent"));
				notice.setNoticeDate(rset.getDate("noticedate"));
			
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return notice;
	}
	

	
	public int updateReadCount(Connection conn, int noticeno) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board set "
				+ "board_readcount = board_readcount + 1 "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeno);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from notice";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			 
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	
}







