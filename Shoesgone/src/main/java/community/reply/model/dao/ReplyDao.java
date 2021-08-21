package community.reply.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import community.free.model.vo.Free;
import community.reply.model.vo.Reply;

public class ReplyDao {
	/*
	 * 조회수 많은 순서로 최대 3개의 댓글을 가져오는 selectTop3 SQL쿼리는 정상적으로 작동하는 것을 확인
	 */
	/*
	 * public ArrayList<Reply> selectTop3(Connection conn) { ArrayList<Reply> list =
	 * new ArrayList<Reply>(); Statement stmt = null; ResultSet rset = null;
	 * 
	 * String query = "SELECT * " +
	 * "FROM (SELECT ROWNUM RNUM, Reply_NO, Reply_TITLE, Reply_READCOUNT " +
	 * "        FROM (SELECT * FROM Reply " +
	 * "                WHERE Reply_LEVEL = 1 " +
	 * "                ORDER BY Reply_READCOUNT DESC)) " +
	 * "WHERE RNUM >= 1 AND RNUM <= 3";
	 * 
	 * try { stmt = conn.createStatement(); rset = stmt.executeQuery(query);
	 * 
	 * while(rset.next()) { Reply Reply = new Reply();
	 * 
	 * Reply.setReplyNo(rset.getInt("Reply_no"));
	 * Reply.setReplyTitle(rset.getString("Reply_title"));
	 * Reply.setReplyReadCount(rset.getInt("Reply_readcount"));
	 * 
	 * list.add(Reply); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(rset);
	 * close(stmt); }
	 * 
	 * return list; }
	 */

	/*
	 * 댓글 번호(ReplyNO)로 게시물 조회 SQL 쿼리 정상 작동
	 */
	/*
	 * public Reply selectReply(Connection conn, int ReplyNO) { Reply Reply = null;
	 * PreparedStatement pstmt = null; ResultSet rset = null;
	 * 
	 * String query =
	 * "select reply_no, Reply_title, Reply_content, Reply_writer, to_char(Reply_date, 'YYYY-MM-DD HH24:MI:SS') as Reply_date"
	 * + ", Reply_readcount, Reply_like from Reply " + "where Reply_NO = ?";
	 * 
	 * try { pstmt = conn.prepareStatement(query); pstmt.setInt(1, ReplyNO);
	 * 
	 * rset = pstmt.executeQuery();
	 * 
	 * if(rset.next()) { Reply = new Reply();
	 * 
	 * Reply.setReplyNo(ReplyNO);
	 * Reply.setReplyTitle(rset.getString("Reply_title"));
	 * Reply.setReplyWriter(rset.getInt("Reply_writer"));
	 * Reply.setReplyContent(rset.getString("Reply_content"));
	 * //Reply.setReplyOriginalFilename(rset.getString("Reply_original_filename"));
	 * //Reply.setReplyRenameFilename(rset.getString("Reply_rename_filename"));
	 * Reply.setReplyDate(rset.getString("Reply_date"));
	 * //Reply.setReplyLevel(rset.getInt("Reply_level"));
	 * //Reply.setReplyRef(rset.getInt("Reply_ref"));
	 * //Reply.setReplyReplyRef(rset.getInt("Reply_reply_ref"));
	 * //Reply.setReplyReplySeq(rset.getInt("Reply_reply_seq"));
	 * Reply.setReplyReadCount(rset.getInt("Reply_readcount"));
	 * Reply.setReplyLike(rset.getInt("Reply_like")); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(rset);
	 * close(pstmt); }
	 * 
	 * return Reply; }
	 * 
	 * 
	 * 조회수 1 증가하는 메소드 SQL 쿼리 정상 작동 확인
	 * 
	 * public int updateReadCount(Connection conn, int ReplyNO) { int result = 0;
	 * PreparedStatement pstmt = null;
	 * 
	 * String query = "update Reply set " + "Reply_readcount = Reply_readcount + 1 "
	 * + "where Reply_NO = ?";
	 * 
	 * try { pstmt = conn.prepareStatement(query); pstmt.setInt(1, ReplyNO);
	 * 
	 * result = pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(pstmt); }
	 * 
	 * return result; }
	 */

	/*
	 * 댓글(Reply 테이블)의 전체 갯수 확인
	 * 
	 */
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from Reply";

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

	/*
	 * public ArrayList<Reply> selectList(Connection conn, int startRow, int endRow,
	 * String orderBy) { ArrayList<Reply> list = new ArrayList<Reply>();
	 * PreparedStatement pstmt = null; ResultSet rset = null;
	 * 
	 * 
	 * String query = "SELECT * " +
	 * "FROM (SELECT ROWNUM RNUM, Reply_NO, Reply_TITLE, Reply_WRITER,  " +
	 * "                Reply_ORIGINAL_FILENAME, Reply_RENAME_FILENAME,  " +
	 * "                Reply_DATE, Reply_LEVEL, Reply_REF, Reply_REPLY_REF,  " +
	 * "                Reply_REPLY_SEQ, Reply_READCOUNT, Reply_content " +
	 * "        FROM (SELECT * FROM Reply " +
	 * "                ORDER BY Reply_REF DESC, Reply_REPLY_REF DESC, " +
	 * "                          Reply_LEVEL ASC, Reply_REPLY_SEQ ASC)) " +
	 * "WHERE RNUM >= ? AND RNUM <= ?";
	 * 
	 * 
	 * String query = "SELECT *" +
	 * "FROM (SELECT ROWNUM RNUM, Reply_NO, Reply_TITLE, Reply_WRITER,  " +
	 * "                  Reply_DATE, Reply_READCOUNT, Reply_content , Reply_like "
	 * + "            FROM (SELECT *" + "		               FROM Reply " +
	 * "                   ORDER BY " + orderBy + "                 )" + "      )" +
	 * "WHERE RNUM >= ? AND RNUM <=?";
	 * 
	 * try { pstmt = conn.prepareStatement(query); pstmt.setInt(1, startRow);
	 * pstmt.setInt(2, endRow);
	 * 
	 * rset = pstmt.executeQuery();
	 * 
	 * while (rset.next()) { Reply Reply = new Reply();
	 * 
	 * Reply.setReplyNo(rset.getInt("Reply_no"));
	 * Reply.setReplyTitle(rset.getString("Reply_title"));
	 * Reply.setReplyWriter(rset.getInt("Reply_writer"));
	 * Reply.setReplyContent(rset.getString("Reply_content"));
	 * Reply.setReplyDate(rset.getString("Reply_date")); //
	 * Reply.setReplyOriginalFilename(rset.getString("Reply_original_filename")); //
	 * Reply.setReplyRenameFilename(rset.getString("Reply_rename_filename")); //
	 * ree.setReplyRef(rset.getInt("Reply_ref")); //
	 * Reply.setReplyLevel(rset.getInt("Reply_level")); //
	 * Reply.setReplyReplyRef(rset.getInt("Reply_reply_ref")); //
	 * Reply.setReplyReplySeq(rset.getInt("Reply_reply_seq"));
	 * Reply.setReplyReadCount(rset.getInt("Reply_readcount"));
	 * Reply.setReplyLike(rset.getInt("Reply_like"));
	 * 
	 * list.add(Reply); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { close(rset);
	 * close(pstmt); }
	 * 
	 * return list; }
	 */
//
//	public int insertOriginReply(Connection conn, Reply Reply) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//
//		String query = "insert into Reply values (" 
//				+ "(select max(Reply_NO) + 1 from Reply), "
//				+ "?, ?, ?, ?, ?, sysdate, 1, " 
//				+ "(select max(Reply_NO) + 1 from Reply), " 
//				+ "null, default, default)";
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, Reply.getReplyTitle());
//			pstmt.setInt(2, Reply.getReplyWriter());
//			pstmt.setString(3, Reply.getReplyContent());
//			pstmt.setString(4, Reply.getReply());
//			pstmt.setString(5, Reply.getReply());
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		return result;
//	}
//
//	public int updateOrigin(Connection conn, Reply origin) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//
//		String query = "update Reply set " 
//				+ "Reply_title = ?, " 
//				+ "Reply_content = ?, "
//				+ "Reply_original_filename = ?, " 
//				+ "Reply_rename_filename = ? " 
//				+ "where Reply_NO = ?";
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, origin.getReplyTitle());
//			pstmt.setString(2, origin.getReplyContent());
//			pstmt.setString(3, origin.getReplyOriginalFilename());
//			pstmt.setString(4, origin.getReplyRenameFilename());
//			pstmt.setInt(5, origin.getReplyNo());
//
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		return result;
//	}
//
//	public int updateReply(Connection conn, Reply reply) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//
//		String query = "update Reply set " 
//				+ "Reply_title = ?, " 
//				+ "Reply_content = ? " 
//				+ "where Reply_NO = ?";
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, reply.getReplyTitle());
//			pstmt.setString(2, reply.getReplyContent());
//			pstmt.setInt(3, reply.getReplyNo());
//
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		return result;
//	}
//
//	public int updateReplySeq(Connection conn, Reply reply) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//
//		String query = null;
//
//		// 새로 등록할 댓글이 원글의 댓글일 때
//		if (reply.getReplyLevel() == 2) {
//			query = "update Reply set " 
//					+ "Reply_reply_seq = Reply_reply_seq + 1 "
//					+ "where Reply_ref = ? and Reply_level = ?";
//		}
//
//		// 새로 등록할 댓글이 댓글의 댓글일 때
//		if (reply.getReplyLevel() == 3) {
//			query = "update Reply set " 
//					+ "Reply_reply_seq = Reply_reply_seq + 1 "
//					+ "where Reply_ref = ? and Reply_level = ? " 
//					+ "and Reply_reply_ref = ?";
//		}
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, reply.getReplyRef());
//			pstmt.setInt(2, reply.getReplyLevel());
//
//			if (reply.getReplyLevel() == 3) {
//				pstmt.setInt(3, reply.getReplyReplyRef());
//			}
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		return result;
//	}
//
//	public int insertReplyReply(Connection conn, Reply reply) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//
//		String query = null;
//
//		if (reply.getReplyLevel() == 2) {
//			query = "insert into Reply values (" 
//					+ "(select max(Reply_NO) + 1 from Reply), "
//					+ "?, ?, ?, null, null, sysdate, 2, ?, " 
//					+ "(select max(Reply_NO) + 1 from Reply), "
//					+ "?, default)";
//		}
//
//		if (reply.getReplyLevel() == 3) {
//			query = "insert into Reply values (" 
//					+ "(select max(Reply_NO) + 1 from Reply), "
//					+ "?, ?, ?, null, null, sysdate, 3, ?, " 
//					+ "?, ?, default)";
//		}
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, reply.getReplyTitle());
//			pstmt.setInt(2, reply.getReplyWriter());
//			pstmt.setString(3, reply.getReplyContent());
//			pstmt.setInt(4, reply.getReplyRef());
//
//			if (reply.getReplyLevel() == 2) {
//				pstmt.setInt(5, reply.getReplySeq());
//			}
//
//			if (reply.getReplyLevel() == 3) {
//				pstmt.setInt(5, reply.getReplyRef());
//				pstmt.setInt(6, reply.getReplySeq());
//			}
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		return result;
//	}
//
//	public int deleteReply(Connection conn, int ReplyNO, int ReplyLevel) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//
//		String query = "delete from Reply ";
//
//		if (ReplyLevel == 1) {
//			// 원글 삭제시에는 원글, 댓글, 대댓글 모두 삭제됨
//			query += "where Reply_ref = ?";
//		}
//
//		if (ReplyLevel == 2) {
//			// 원글에 대한 댓글 삭제시, 대댓글 같이 삭제
//			query += "where Reply_reply_ref = ?";
//		}
//
//		if (ReplyLevel == 3) {
//			// 대댓글은 자기글만 삭제
//			query += "where Reply_NO = ?";
//		}
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setInt(1, ReplyNO);
//
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//
//		return result;
//	}

	public List<Reply> selectReplyList(Connection conn, int freeNo) {
		// TODO Auto-generated method stub
		ArrayList<Reply> list = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		String query = "SELECT "
				+ "REPLY_NO"
				+ ", PARENT_REPLY_NO"
				+ ", REPLY_LEVEL"
				+ ", REPLY_ORDER"
				+ ", BOARD_TYPE"
				+ ", BOARD_NO"
				+ ", REPLY_WRITER"
				+ ", TO_CHAR(REPLY_DATE, 'YYYY-MM-DD HH24:MI:SS') AS REPLY_DATE"
				+ ", REPLY_CONTENT"
				+ ", REPLY_LIKE"
	  		+ "  FROM REPLY A"
	  		+ " WHERE A.BOARD_NO = ?"
	  		+ "  ORDER BY REPLY_ORDER, REPLY_LEVEL";
	 
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply reply  = new Reply();
				
				reply.setReplyNo(rset.getInt("REPLY_NO"));
				reply.setParentReplyNo(rset.getInt("PARENT_REPLY_NO"));
				reply.setReplyLevel(rset.getInt("REPLY_LEVEL"));
				reply.setReplyOrder(rset.getInt("REPLY_ORDER"));
				reply.setBoardNo(rset.getInt("BOARD_NO"));
				reply.setReplyWriter(rset.getInt("REPLY_WRITER"));
				reply.setReplyDate(rset.getString("REPLY_DATE"));
				reply.setReplyContent(rset.getString("REPLY_CONTENT"));
				reply.setReplyLike(rset.getInt("REPLY_LIKE"));
				
				list.add(reply);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
