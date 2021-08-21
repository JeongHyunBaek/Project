package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Notice;

public class NoticeDao {

	// 새로운 즉시 구매가에 따른 판매입찰 데이터베이스 조회
	public ArrayList<Notice> selectNoticeList(Connection conn) {

		ArrayList<Notice> list = new ArrayList<Notice>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from notice";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("noticeno"));
				notice.setNoticeTitle(rset.getString("noticetitle"));
				notice.setNoticeWriter(rset.getString("noticewriter"));
				notice.setNoticeDate(rset.getDate("noticedate"));
				notice.setNoticeContent(rset.getString("noticecontent"));
				notice.setNoticeavailable(rset.getInt("noticeavailable"));
				notice.setNoticeReadcount(rset.getInt("noticereadcount"));

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
}
