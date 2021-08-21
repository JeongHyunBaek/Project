package community.best.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.best.model.vo.Best;

public class BestDao {

	public ArrayList<Best> selectTop3(Connection conn) {
		ArrayList<Best> list = new ArrayList<Best>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, Best_No, Best_TITLE, Best_READCOUNT "
				+ "        FROM (SELECT * FROM Best "
				+ "                WHERE Best_LEVEL = 1 "
				+ "                ORDER BY Best_READCOUNT DESC)) "
				+ "WHERE RNUM >= 1 AND RNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Best Best = new Best();
				
				Best.setBestNo(rset.getInt("Best_No"));
				Best.setBestTitle(rset.getString("Best_title"));
				Best.setBestReadCount(rset.getInt("Best_readcount"));
				
				list.add(Best);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		
		return list;
	}
	public Best selectBest(Connection conn, int BestNo) {
		Best Best = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from Best "
				+ "where Best_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, BestNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Best = new Best();
				
				Best.setBestNo(BestNo);
				Best.setBestTitle(rset.getString("Best_title"));
				Best.setBestWriter(rset.getInt("Best_writer"));
				Best.setBestContent(rset.getString("Best_content"));
				Best.setBestOriginalFilename(rset.getString("Best_original_filename"));
				Best.setBestRenameFilename(rset.getString("Best_rename_filename"));
				Best.setBestDate(rset.getDate("Best_date"));
				Best.setBestLevel(rset.getInt("Best_level"));
				Best.setBestRef(rset.getInt("Best_ref"));
				Best.setBestReplyRef(rset.getInt("Best_reply_ref"));
				Best.setBestReplySeq(rset.getInt("Best_reply_seq"));
				Best.setBestReadCount(rset.getInt("Best_readcount"));
				Best.setBestLike(rset.getInt("Best_like"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return Best;
	}

	public int updateReadCount(Connection conn, int BestNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Best set "
				+ "Best_readcount = Best_readcount + 1 "
				+ "where Best_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, BestNo);
			
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
		
		String query = "select count(*) from Best";
		
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

	public ArrayList<Best> selectList(Connection conn, 
			int startRow, int endRow, String orderBy) {
		ArrayList<Best> list = new ArrayList<Best>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*
		 * String query = "SELECT * " +
		 * "FROM (SELECT ROWNUM RNUM, Best_No, Best_TITLE, Best_WRITER,  " +
		 * "                Best_ORIGINAL_FILENAME, Best_RENAME_FILENAME,  " +
		 * "                Best_DATE, Best_LEVEL, Best_REF, Best_REPLY_REF,  " +
		 * "                Best_REPLY_SEQ, Best_READCOUNT, Best_content , Best_like " +
		 * "        FROM (SELECT * FROM Best " +
		 * "                ORDER BY Best_REF DESC, Best_REPLY_REF DESC, " +
		 * "                          Best_LEVEL ASC, Best_REPLY_SEQ ASC)) " +
		 * "WHERE RNUM >= ? AND RNUM <= ?";
		 */
		String query = "SELECT *"
				+ "FROM (SELECT ROWNUM RNUM, Best_No, Best_TITLE, Best_WRITER,  "
				+ "                  Best_DATE, Best_READCOUNT, Best_content , Best_like "
				+ "            FROM (SELECT *"
				+ "		               FROM Best "
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
				Best Best  = new Best();
				
				Best.setBestNo(rset.getInt("Best_No"));
				Best.setBestTitle(rset.getString("Best_title"));
				Best.setBestWriter(rset.getInt("Best_writer"));
				Best.setBestContent(rset.getString("Best_content"));				
				Best.setBestDate(rset.getDate("Best_date"));
				Best.setBestOriginalFilename(rset.getString("Best_original_filename"));
				Best.setBestRenameFilename(rset.getString("Best_rename_filename"));
				Best.setBestRef(rset.getInt("Best_ref"));
				Best.setBestLevel(rset.getInt("Best_level"));
				Best.setBestReplyRef(rset.getInt("Best_reply_ref"));
				Best.setBestReplySeq(rset.getInt("Best_reply_seq"));
				Best.setBestReadCount(rset.getInt("Best_readcount"));
				Best.setBestLike(rset.getInt("Best_like"));
				
				list.add(Best);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertOriginBest(Connection conn, Best Best) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Best values ("
				+ "(select max(Best_No) + 1 from Best), "
				+ "?, ?, ?, ?, ?, sysdate, 1, "
				+ "(select max(Best_No) + 1 from Best), "
				+ "null, default, default)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Best.getBestTitle());
			pstmt.setInt(2, Best.getBestWriter());
			pstmt.setString(3, Best.getBestContent());
			pstmt.setString(4, Best.getBestOriginalFilename());
			pstmt.setString(5, Best.getBestRenameFilename());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateOrigin(Connection conn, Best origin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Best set "
				+ "Best_title = ?, "
				+ "Best_content = ?, "
				+ "Best_original_filename = ?, "
				+ "Best_rename_filename = ? "
				+ "where Best_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, origin.getBestTitle());
			pstmt.setString(2, origin.getBestContent());
			pstmt.setString(3, origin.getBestOriginalFilename());
			pstmt.setString(4, origin.getBestRenameFilename());
			pstmt.setInt(5, origin.getBestNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReply(Connection conn, Best reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Best set "
				+ "Best_title = ?, "
				+ "Best_content = ? "
				+ "where Best_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getBestTitle());
			pstmt.setString(2, reply.getBestContent());
			pstmt.setInt(3, reply.getBestNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReplySeq(Connection conn, Best reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		//새로 등록할 댓글이 원글의 댓글일 때
		if(reply.getBestLevel() == 2) {
			query = "update Best set "
				+ "Best_reply_seq = Best_reply_seq + 1 "
				+ "where Best_ref = ? and Best_level = ?";
		}
		
		//새로 등록할 댓글이 댓글의 댓글일 때
		if(reply.getBestLevel() == 3) {
			query = "update Best set "
					+ "Best_reply_seq = Best_reply_seq + 1 "
					+ "where Best_ref = ? and Best_level = ? "
					+ "and Best_reply_ref = ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reply.getBestRef());
			pstmt.setInt(2, reply.getBestLevel());
			
			if(reply.getBestLevel() == 3) {
				pstmt.setInt(3, reply.getBestReplyRef());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReplyBest(Connection conn, Best reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		if(reply.getBestLevel()  == 2) {
			query = "insert into Best values ("
				+ "(select max(Best_No) + 1 from Best), "
				+ "?, ?, ?, null, null, sysdate, 2, ?, "
				+ "(select max(Best_No) + 1 from Best), "
				+ "?, default)";
		}		
		
		if(reply.getBestLevel()  == 3) {
			query = "insert into Best values ("
					+ "(select max(Best_No) + 1 from Best), "
					+ "?, ?, ?, null, null, sysdate, 3, ?, "
					+ "?, ?, default)";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getBestTitle());
			pstmt.setInt(2, reply.getBestWriter());
			pstmt.setString(3, reply.getBestContent());
			pstmt.setInt(4, reply.getBestRef());
			
			if(reply.getBestLevel() == 2) {
				pstmt.setInt(5, reply.getBestReplySeq());
			}
			
			if(reply.getBestLevel() == 3) {
				pstmt.setInt(5, reply.getBestReplyRef());
				pstmt.setInt(6, reply.getBestReplySeq());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBest(Connection conn, 
			int BestNo, int BestLevel) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from Best ";
		
		if(BestLevel == 1) {
			//원글 삭제시에는 원글, 댓글, 대댓글 모두 삭제됨
			query += "where Best_ref = ?";
		}
		
		if(BestLevel == 2) {
			//원글에 대한 댓글 삭제시, 대댓글 같이 삭제
			query += "where Best_reply_ref = ?";
		}
		
		if(BestLevel == 3) {
			//대댓글은 자기글만 삭제
			query += "where Best_No = ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, BestNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













