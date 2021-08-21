package community.qna.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.qna.model.vo.QnA;

public class QnADao {

	public ArrayList<QnA> selectTop3(Connection conn) {
		ArrayList<QnA> list = new ArrayList<QnA>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, QnA_No, QnA_TITLE, QnA_READCOUNT "
				+ "        FROM (SELECT * FROM QnA "
				+ "                WHERE QnA_LEVEL = 1 "
				+ "                ORDER BY QnA_READCOUNT DESC)) "
				+ "WHERE RNUM >= 1 AND RNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				QnA QnA = new QnA();
				
				QnA.setQnANo(rset.getInt("QnA_No"));
				QnA.setQnATitle(rset.getString("QnA_title"));
				QnA.setQnAReadCount(rset.getInt("QnA_readcount"));
				
				list.add(QnA);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		
		return list;
	}
	public QnA selectQnA(Connection conn, int QnANo) {
		QnA QnA = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select qna_no, qna_title, qna_content, qna_writer, to_char(qna_date, 'YYYY-MM-DD HH24:MI:SS') as qna_date"
				+ ", qna_readcount, qna_like from QnA "
				+ "where QnA_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, QnANo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				QnA = new QnA();
				
				QnA.setQnANo(QnANo);
				QnA.setQnATitle(rset.getString("QnA_title"));
				QnA.setQnAWriter(rset.getInt("QnA_writer"));
				QnA.setQnAContent(rset.getString("QnA_content"));
				QnA.setQnAOriginalFilename(rset.getString("QnA_original_filename"));
				QnA.setQnARenameFilename(rset.getString("QnA_rename_filename"));
				QnA.setQnADate(rset.getString("QnA_date"));
				QnA.setQnAReadCount(rset.getInt("QnA_readcount"));
				QnA.setQnALike(rset.getInt("QnA_like"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return QnA;
	}

	public int updateReadCount(Connection conn, int QnANo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update QnA set "
				+ "QnA_readcount = QnA_readcount + 1 "
				+ "where QnA_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, QnANo);
			
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
		
		String query = "select count(*) from QnA";
		
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

	public ArrayList<QnA> selectList(Connection conn, 
			int startRow, int endRow, String orderBy) {
		ArrayList<QnA> list = new ArrayList<QnA>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*
		 * String query = "SELECT * " +
		 * "FROM (SELECT ROWNUM RNUM, QnA_No, QnA_TITLE, QnA_WRITER,  " +
		 * "                QnA_ORIGINAL_FILENAME, QnA_RENAME_FILENAME,  " +
		 * "                QnA_DATE, QnA_LEVEL, QnA_REF, QnA_REPLY_REF,  " +
		 * "                QnA_REPLY_SEQ, QnA_READCOUNT, QnA_content , QnA_like " +
		 * "        FROM (SELECT * FROM QnA " +
		 * "                ORDER BY QnA_REF DESC, QnA_REPLY_REF DESC, " +
		 * "                          QnA_LEVEL ASC, QnA_REPLY_SEQ ASC)) " +
		 * "WHERE RNUM >= ? AND RNUM <= ?";
		 */
		String query = "SELECT *"
				+ "FROM (SELECT ROWNUM RNUM, QnA_No, QnA_TITLE, QnA_WRITER,  "
				/* + "                QnA_ORIGINAL_FILENAME, QnA_RENAME_FILENAME,  " */
				+ "                  QnA_DATE, QnA_READCOUNT, QnA_content , QnA_like "
				+ "            FROM (SELECT *"
				+ "		               FROM QnA "
				+ "                   ORDER BY " + orderBy
				+ "                 )"
				+ "      )"
				+ "WHERE RNUM >= ? AND RNUM <=?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnA QnA  = new QnA();
				
				QnA.setQnANo(rset.getInt("QnA_No"));
				QnA.setQnATitle(rset.getString("QnA_title"));
				QnA.setQnAWriter(rset.getInt("QnA_writer"));
				QnA.setQnAContent(rset.getString("QnA_content"));				
				QnA.setQnADate(rset.getString("QnA_date"));
				//QnA.setQnAOriginalFilename(rset.getString("QnA_original_filename"));
				//QnA.setQnARenameFilename(rset.getString("QnA_rename_filename"));
				QnA.setQnAReadCount(rset.getInt("QnA_readcount"));
				QnA.setQnALike(rset.getInt("QnA_like"));
				
				list.add(QnA);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertOriginQnA(Connection conn, QnA QnA) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into QnA values ("
				+ "(select max(QnA_No) + 1 from QnA), "
				+ "?, ?, ?, ?, ?, sysdate, 1, "
				+ "(select max(QnA_No) + 1 from QnA), "
				+ "null, default, default)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, QnA.getQnATitle());
			pstmt.setInt(2, QnA.getQnAWriter());
			pstmt.setString(3, QnA.getQnAContent());
			pstmt.setString(4, QnA.getQnAOriginalFilename());
			pstmt.setString(5, QnA.getQnARenameFilename());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateOrigin(Connection conn, QnA origin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update QnA set "
				+ "QnA_title = ?, "
				+ "QnA_content = ?, "
				+ "QnA_original_filename = ?, "
				+ "QnA_rename_filename = ? "
				+ "where QnA_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, origin.getQnATitle());
			pstmt.setString(2, origin.getQnAContent());
			pstmt.setString(3, origin.getQnAOriginalFilename());
			pstmt.setString(4, origin.getQnARenameFilename());
			pstmt.setInt(5, origin.getQnANo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReply(Connection conn, QnA reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update QnA set "
				+ "QnA_title = ?, "
				+ "QnA_content = ? "
				+ "where QnA_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getQnATitle());
			pstmt.setString(2, reply.getQnAContent());
			pstmt.setInt(3, reply.getQnANo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public int deleteQnA(Connection conn, 
			int QnANo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from QnA where qna_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, QnANo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













