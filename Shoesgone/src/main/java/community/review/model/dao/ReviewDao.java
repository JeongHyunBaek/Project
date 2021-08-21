package community.review.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.review.model.vo.Review;

public class ReviewDao {

	public ArrayList<Review> selectTop3(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, Review_No, Review_TITLE, Review_READCOUNT "
				+ "        FROM (SELECT * FROM Review "
				+ "                WHERE Review_LEVEL = 1 "
				+ "                ORDER BY Review_READCOUNT DESC)) "
				+ "WHERE RNUM >= 1 AND RNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Review Review = new Review();
				
				Review.setReviewNo(rset.getInt("Review_No"));
				Review.setReviewTitle(rset.getString("Review_title"));
				Review.setReviewReadCount(rset.getInt("Review_readcount"));
				
				list.add(Review);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		
		return list;
	}
	public Review selectReview(Connection conn, int ReviewNo) {
		Review Review = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from Review "
				+ "where Review_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ReviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Review = new Review();
				
				Review.setReviewNo(ReviewNo);
				Review.setReviewTitle(rset.getString("Review_title"));
				Review.setReviewWriter(rset.getInt("Review_writer"));
				Review.setReviewContent(rset.getString("Review_content"));
				Review.setReviewOriginalFilename(rset.getString("Review_original_filename"));
				Review.setReviewRenameFilename(rset.getString("Review_rename_filename"));
				Review.setReviewDate(rset.getString("Review_date"));
				Review.setReviewReadCount(rset.getInt("Review_readcount"));
				Review.setReviewLike(rset.getInt("Review_like"));			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return Review;
	}

	public int updateReadCount(Connection conn, int ReviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Review set "
				+ "Review_readcount = Review_readcount + 1 "
				+ "where Review_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ReviewNo);
			
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
		
		String query = "select count(*) from Review";
		
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

	public ArrayList<Review> selectList(Connection conn, 
			int startRow, int endRow, String orderBy) {
		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*
		 * String query = "SELECT * " +
		 * "FROM (SELECT ROWNUM RNUM, Review_No, Review_TITLE, Review_WRITER,  " +
		 * "                Review_ORIGINAL_FILENAME, Review_RENAME_FILENAME,  " +
		 * "                Review_DATE, Review_LEVEL, Review_REF, Review_REPLY_REF,  "
		 * + "                Review_REPLY_SEQ, Review_READCOUNT, Review_content , Review_like " +
		 * "        FROM (SELECT * FROM Review " +
		 * "                ORDER BY Review_REF DESC, Review_REPLY_REF DESC, " +
		 * "                          Review_LEVEL ASC, Review_REPLY_SEQ ASC)) " +
		 * "WHERE RNUM >= ? AND RNUM <= ?";
		 */
		String query = "SELECT *"
				+ "FROM (SELECT ROWNUM RNUM, Review_No, Review_TITLE, Review_WRITER,  "
				+ "                  Review_DATE, Review_READCOUNT, Review_content , Review_like "
				+ "            FROM (SELECT *"
				+ "		               FROM Review "
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
				Review Review  = new Review();
				
				Review.setReviewNo(rset.getInt("Review_No"));
				Review.setReviewTitle(rset.getString("Review_title"));
				Review.setReviewWriter(rset.getInt("Review_writer"));
				Review.setReviewContent(rset.getString("Review_content"));				
				Review.setReviewDate(rset.getString("Review_date"));
				//Review.setReviewOriginalFilename(rset.getString("Review_original_filename"));
				//Review.setReviewRenameFilename(rset.getString("Review_rename_filename"));
				Review.setReviewReadCount(rset.getInt("Review_readcount"));
				Review.setReviewLike(rset.getInt("Review_like"));
				
				list.add(Review);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertOriginReview(Connection conn, Review Review) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Review values ("
				+ "(select max(Review_No) + 1 from Review), "
				+ "?, ?, ?, ?, ?, sysdate, 1, "
				+ "(select max(Review_No) + 1 from Review), "
				+ "null, default, default)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Review.getReviewTitle());
			pstmt.setInt(2, Review.getReviewWriter());
			pstmt.setString(3, Review.getReviewContent());
			pstmt.setString(4, Review.getReviewOriginalFilename());
			pstmt.setString(5, Review.getReviewRenameFilename());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateOrigin(Connection conn, Review origin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Review set "
				+ "Review_title = ?, "
				+ "Review_content = ?, "
				+ "Review_original_filename = ?, "
				+ "Review_rename_filename = ? "
				+ "where Review_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, origin.getReviewTitle());
			pstmt.setString(2, origin.getReviewContent());
			pstmt.setString(3, origin.getReviewOriginalFilename());
			pstmt.setString(4, origin.getReviewRenameFilename());
			pstmt.setInt(5, origin.getReviewNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReply(Connection conn, Review reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Review set "
				+ "Review_title = ?, "
				+ "Review_content = ? "
				+ "where Review_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getReviewTitle());
			pstmt.setString(2, reply.getReviewContent());
			pstmt.setInt(3, reply.getReviewNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

	public int deleteReview(Connection conn, 
			int ReviewNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from Review where review_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, ReviewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













