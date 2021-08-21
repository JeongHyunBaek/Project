package notice.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;
import question.model.vo.Question;

public class NoticeDao {

	// 공지사항 전체조회 : 공지사항 목록보기용
	public ArrayList<Notice> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * " + "from (select rownum rnum, noticeno, noticetitle, NOTICEWRITER, "
				+ "NOTICEDATE, NOTICECONTENT, NOTICEAVAILABLE, NOTICEREADCOUNT "
				+ "from notice where noticeavailable = 1 order by noticeno desc) " + "where rnum >=? and rnum <= ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Notice notice = new Notice();

				notice.setNoticeNo(rset.getInt("NOTICENO"));
				notice.setNoticeTitle(rset.getString("NOTICETITLE"));
				notice.setNoticeWriter(rset.getString("NOTICEWRITER"));
				notice.setNoticeDate(rset.getDate("NOTICEDATE"));
				notice.setNoticeContent(rset.getString("NOTICECONTENT"));
				notice.setNoticeavailable(rset.getInt("NOTICEAVAILABLE"));
				notice.setNoticeReadcount(rset.getInt("noticereadcount"));

				list.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	// 공지글번호로 한 개 조회 : 공지사항 상세보기용
	public Notice selectOne(Connection conn, int noticeNo) {
		Notice notice = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from notice " + "where noticeno = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				notice = new Notice();

				notice.setNoticeNo(noticeNo);
				notice.setNoticeTitle(rset.getString("NOTICETITLE"));
				notice.setNoticeWriter(rset.getString("NOTICEWRITER"));
				notice.setNoticeDate(rset.getDate("NOTICEDATE"));
				notice.setNoticeContent(rset.getString("NOTICECONTENT"));
				notice.setNoticeavailable(rset.getInt("NOTICEAVAILABLE"));
				notice.setNoticeReadcount(rset.getInt("noticereadcount"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return notice;
	}

	public int updateReadCount(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update notice set " + "noticereadcount = noticereadcount + 1 " + "where noticeno = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

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

		String query = "select count(*) from notice where noticeavailable = 1";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
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

	public int insertNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "insert into notice "
				+ "values ((select max(noticeno) + 1 from notice), ?, '관리자', sysdate, ?, 1, default)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int adminDeleteNotice(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update notice set noticeavailable = 0 where noticeno = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int adminUpdateNotice(Connection conn, Notice notice) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update notice set "
				+ "noticetitle = ?, "
				+ "noticecontent = ? , noticedate = sysdate "
				+ "where noticeno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());		
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
	
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
}
}
