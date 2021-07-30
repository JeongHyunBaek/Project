package community.best.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.best.model.vo.Board;

public class BoardDao {

	public ArrayList<Board> selectTop3(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_TITLE, BOARD_READCOUNT "
				+ "        FROM (SELECT * FROM BOARD "
				+ "                WHERE BOARD_LEVEL = 1 "
				+ "                ORDER BY BOARD_READCOUNT DESC)) "
				+ "WHERE RNUM >= 1 AND RNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Board board = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				list.add(board);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		
		return list;
	}
	public Board selectBoard(Connection conn, int boardNum) {
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from board "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				board = new Board();
				
				board.setBoardNum(boardNum);
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));
				board.setBoardOriginalFilename(rset.getString("board_original_filename"));
				board.setBoardRenameFilename(rset.getString("board_rename_filename"));
				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardLevel(rset.getInt("board_level"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return board;
	}

	public int updateReadCount(Connection conn, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board set "
				+ "board_readcount = board_readcount + 1 "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
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
		
		String query = "select count(*) from board";
		
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

	public ArrayList<Board> selectList(Connection conn, 
			int startRow, int endRow) {
		ArrayList<Board> list = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, BOARD_NUM, BOARD_TITLE, BOARD_WRITER,  "
				+ "                BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME,  "
				+ "                BOARD_DATE, BOARD_LEVEL, BOARD_REF, BOARD_REPLY_REF,  "
				+ "                BOARD_REPLY_SEQ, BOARD_READCOUNT, board_content "
				+ "        FROM (SELECT * FROM BOARD "
				+ "                ORDER BY BOARD_REF DESC, BOARD_REPLY_REF DESC, "
				+ "                          BOARD_LEVEL ASC, BOARD_REPLY_SEQ ASC)) "
				+ "WHERE RNUM >= ? AND RNUM <= ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board board  = new Board();
				
				board.setBoardNum(rset.getInt("board_num"));
				board.setBoardTitle(rset.getString("board_title"));
				board.setBoardWriter(rset.getString("board_writer"));
				board.setBoardContent(rset.getString("board_content"));				board.setBoardDate(rset.getDate("board_date"));
				board.setBoardOriginalFilename(rset.getString("board_original_filename"));
				board.setBoardRenameFilename(rset.getString("board_rename_filename"));
				board.setBoardRef(rset.getInt("board_ref"));
				board.setBoardLevel(rset.getInt("board_level"));
				board.setBoardReplyRef(rset.getInt("board_reply_ref"));
				board.setBoardReplySeq(rset.getInt("board_reply_seq"));
				board.setBoardReadCount(rset.getInt("board_readcount"));
				
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertOriginBoard(Connection conn, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into board values ("
				+ "(select max(board_num) + 1 from board), "
				+ "?, ?, ?, ?, ?, sysdate, 1, "
				+ "(select max(board_num) + 1 from board), "
				+ "null, default, default)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardWriter());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardOriginalFilename());
			pstmt.setString(5, board.getBoardRenameFilename());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateOrigin(Connection conn, Board origin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board set "
				+ "board_title = ?, "
				+ "board_content = ?, "
				+ "board_original_filename = ?, "
				+ "board_rename_filename = ? "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, origin.getBoardTitle());
			pstmt.setString(2, origin.getBoardContent());
			pstmt.setString(3, origin.getBoardOriginalFilename());
			pstmt.setString(4, origin.getBoardRenameFilename());
			pstmt.setInt(5, origin.getBoardNum());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReply(Connection conn, Board reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update board set "
				+ "board_title = ?, "
				+ "board_content = ? "
				+ "where board_num = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getBoardTitle());
			pstmt.setString(2, reply.getBoardContent());
			pstmt.setInt(3, reply.getBoardNum());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReplySeq(Connection conn, Board reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		//새로 등록할 댓글이 원글의 댓글일 때
		if(reply.getBoardLevel() == 2) {
			query = "update board set "
				+ "board_reply_seq = board_reply_seq + 1 "
				+ "where board_ref = ? and board_level = ?";
		}
		
		//새로 등록할 댓글이 댓글의 댓글일 때
		if(reply.getBoardLevel() == 3) {
			query = "update board set "
					+ "board_reply_seq = board_reply_seq + 1 "
					+ "where board_ref = ? and board_level = ? "
					+ "and board_reply_ref = ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reply.getBoardRef());
			pstmt.setInt(2, reply.getBoardLevel());
			
			if(reply.getBoardLevel() == 3) {
				pstmt.setInt(3, reply.getBoardReplyRef());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReplyBoard(Connection conn, Board reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = null;
		
		if(reply.getBoardLevel()  == 2) {
			query = "insert into board values ("
				+ "(select max(board_num) + 1 from board), "
				+ "?, ?, ?, null, null, sysdate, 2, ?, "
				+ "(select max(board_num) + 1 from board), "
				+ "?, default)";
		}		
		
		if(reply.getBoardLevel()  == 3) {
			query = "insert into board values ("
					+ "(select max(board_num) + 1 from board), "
					+ "?, ?, ?, null, null, sysdate, 3, ?, "
					+ "?, ?, default)";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getBoardTitle());
			pstmt.setString(2, reply.getBoardWriter());
			pstmt.setString(3, reply.getBoardContent());
			pstmt.setInt(4, reply.getBoardRef());
			
			if(reply.getBoardLevel() == 2) {
				pstmt.setInt(5, reply.getBoardReplySeq());
			}
			
			if(reply.getBoardLevel() == 3) {
				pstmt.setInt(5, reply.getBoardReplyRef());
				pstmt.setInt(6, reply.getBoardReplySeq());
			}
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, 
			int boardNum, int boardLevel) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from board ";
		
		if(boardLevel == 1) {
			//원글 삭제시에는 원글, 댓글, 대댓글 모두 삭제됨
			query += "where board_ref = ?";
		}
		
		if(boardLevel == 2) {
			//원글에 대한 댓글 삭제시, 대댓글 같이 삭제
			query += "where board_reply_ref = ?";
		}
		
		if(boardLevel == 3) {
			//대댓글은 자기글만 삭제
			query += "where board_num = ?";
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













