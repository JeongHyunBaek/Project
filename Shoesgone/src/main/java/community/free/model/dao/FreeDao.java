package community.free.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.free.model.vo.Free;

public class FreeDao {

	/*
	 * 조회수 많은 순서로 최대 3개의 글을 가져오는 selectTop3
	 * SQL쿼리는 정상적으로 작동하는 것을 확인
	 */
	public ArrayList<Free> selectTop3(Connection conn) {
		ArrayList<Free> list = new ArrayList<Free>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, Free_NO, Free_TITLE, Free_READCOUNT "
				+ "        FROM (SELECT * FROM Free "
				+ "                WHERE Free_LEVEL = 1 "
				+ "                ORDER BY Free_READCOUNT DESC)) "
				+ "WHERE RNUM >= 1 AND RNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Free Free = new Free();
				
				Free.setFreeNo(rset.getInt("Free_no"));
				Free.setFreeTitle(rset.getString("Free_title"));
				Free.setFreeReadCount(rset.getInt("Free_readcount"));
				
				list.add(Free);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		
		return list;
	}
	
	/*
	 * 게시판 번호(FreeNO)로 게시물 조회
	 * SQL 쿼리 정상 작동
	 */
	public Free selectFree(Connection conn, int FreeNO) {
		Free Free = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select free_no, free_title, free_content, free_writer, to_char(free_date, 'YYYY-MM-DD HH24:MI:SS') as free_date"
				+ ", free_readcount, free_like from Free "
				+ "where Free_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, FreeNO);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Free = new Free();
				
				Free.setFreeNo(FreeNO);
				Free.setFreeTitle(rset.getString("Free_title"));
				Free.setFreeWriter(rset.getInt("Free_writer"));
				Free.setFreeContent(rset.getString("Free_content"));
				Free.setFreeOriginalFilename(rset.getString("Free_original_filename"));
				Free.setFreeRenameFilename(rset.getString("Free_rename_filename"));
				Free.setFreeDate(rset.getString("Free_date"));
				Free.setFreeReadCount(rset.getInt("Free_readcount"));
				Free.setFreeLike(rset.getInt("Free_like"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return Free;
	}

	/*
	 * 조회수 1 증가하는 메소드
	 * SQL 쿼리 정상 작동 확인
	 */
	public int updateReadCount(Connection conn, int FreeNO) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Free set "
				+ "Free_readcount = Free_readcount + 1 "
				+ "where Free_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, FreeNO);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/*
	 * 자유게시판(Free 테이블)의 전체 갯수 확인
	 * 
	 */
	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from Free";
		
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

	public ArrayList<Free> selectList(Connection conn, 
			int startRow, int endRow, String orderBy) {
		ArrayList<Free> list = new ArrayList<Free>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		/*
		 * String query = "SELECT * " +
		 * "FROM (SELECT ROWNUM RNUM, Free_NO, Free_TITLE, Free_WRITER,  " +
		 * "                Free_ORIGINAL_FILENAME, Free_RENAME_FILENAME,  " +
		 * "                Free_DATE, Free_LEVEL, Free_REF, Free_REPLY_REF,  " +
		 * "                Free_REPLY_SEQ, Free_READCOUNT, Free_content " +
		 * "        FROM (SELECT * FROM Free " +
		 * "                ORDER BY Free_REF DESC, Free_REPLY_REF DESC, " +
		 * "                          Free_LEVEL ASC, Free_REPLY_SEQ ASC)) " +
		 * "WHERE RNUM >= ? AND RNUM <= ?";
		 */
		
		
		String query = "SELECT *" 
				+ "FROM (SELECT ROWNUM RNUM, Free_NO, Free_TITLE, Free_WRITER,  "
				+ "                Free_ORIGINAL_FILENAME, Free_RENAME_FILENAME,  "
				+ "                  Free_DATE, Free_READCOUNT, Free_Content , Free_like "
				+ "            FROM (SELECT *" 
				+ "		               FROM FREE " 
				+ "                   ORDER BY "+ orderBy 
				+ "                 )" 
				+ "      )" 
				+ "WHERE RNUM >= ? AND RNUM <=?";
		 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Free Free  = new Free();
				
				Free.setFreeNo(rset.getInt("Free_no"));
				Free.setFreeTitle(rset.getString("Free_title"));
				Free.setFreeWriter(rset.getInt("Free_writer"));
				Free.setFreeContent(rset.getString("Free_content"));				
				Free.setFreeDate(rset.getString("Free_date"));
				Free.setFreeOriginalFilename(rset.getString("Free_original_filename"));
				Free.setFreeRenameFilename(rset.getString("Free_rename_filename"));
				Free.setFreeReadCount(rset.getInt("Free_readcount"));
				Free.setFreeLike(rset.getInt("Free_like"));
				
				list.add(Free);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertOriginFree(Connection conn, Free Free) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Free values ("
				+ "(select max(Free_NO) + 1 from Free), "
				+ "?, ?,sysdate, ?, ?, ?,  1, "
				+ " default)";		
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Free.getFreeTitle());
			pstmt.setInt(2, Free.getFreeWriter());
			pstmt.setString(3, Free.getFreeContent());
			pstmt.setString(4, Free.getFreeOriginalFilename());
			pstmt.setString(5, Free.getFreeRenameFilename());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateOrigin(Connection conn, Free origin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Free set "
				+ "Free_title = ?, "
				+ "Free_content = ?, "
				+ "Free_original_filename = ?, "
				+ "Free_rename_filename = ? "
				+ "where Free_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, origin.getFreeTitle());
			pstmt.setString(2, origin.getFreeContent());
			pstmt.setString(3, origin.getFreeOriginalFilename());
			pstmt.setString(4, origin.getFreeRenameFilename());
			pstmt.setInt(5, origin.getFreeNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReply(Connection conn, Free reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Free set "
				+ "Free_title = ?, "
				+ "Free_content = ? "
				+ "where Free_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getFreeTitle());
			pstmt.setString(2, reply.getFreeContent());
			pstmt.setInt(3, reply.getFreeNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
		
		

	

	public int deleteFree(Connection conn, 
			int FreeNO) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from Free where free_no = ? ";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, FreeNO);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













