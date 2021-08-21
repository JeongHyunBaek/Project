package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.QnA;

public class QnADao {

	public ArrayList<QnA> selectQnaList(Connection conn) {
		ArrayList<QnA> list = new ArrayList<QnA>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from qna";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				QnA qna = new QnA();
				
				qna.setQnANo(rset.getInt("qna_no"));
				qna.setQnATitle(rset.getString("qna_title"));
				qna.setQnAWriter(rset.getInt("qna_writer"));
				qna.setQnADate(rset.getDate("qna_date"));
				qna.setQnAContent(rset.getString("qna_date"));
				qna.setQnAOriginalFilename(rset.getString("qna_original_filename"));
				qna.setQnARenameFilename(rset.getString("qna_rename_filename"));
				qna.setQnALike(rset.getInt("qna_like"));
				qna.setQnAUnlike(rset.getInt("qna_unlike"));
				qna.setQnAReadCount(rset.getInt("qna_readcount"));
				
				list.add(qna);
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
