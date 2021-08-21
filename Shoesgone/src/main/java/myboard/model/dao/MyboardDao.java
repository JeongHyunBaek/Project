package myboard.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import myboard.model.vo.Myboard;

public class MyboardDao {
	
	public ArrayList<Myboard> reviewList(Connection conn, int userno, int startRow, int endRow) {
		ArrayList<Myboard> rlist = new ArrayList<Myboard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * " + "from (select rownum rnum, REVIEW_NO, REVIEW_TITLE, REVIEW_WRITER, "
				+ "REVIEW_DATE, REVIEW_READCOUNT "
				+ "from review where review_writer = ? order by REVIEW_NO desc) " + "where rnum >=? and rnum <= ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Myboard review = new Myboard();

				review.setTextNo(rset.getInt("REVIEW_NO"));
				review.setTitle(rset.getString("REVIEW_TITLE"));
				review.setWriter(rset.getInt("REVIEW_WRITER"));
				review.setRegistDate(rset.getDate("REVIEW_DATE"));
				review.setTextReadcount(rset.getInt("REVIEW_READCOUNT"));

				rlist.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rlist;
	}
	
	public int getReviewListCount(Connection conn, int userno) {
		int rlistCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from review where review_writer = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				rlistCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return rlistCount;
	}
	
	public ArrayList<Myboard> freeList(Connection conn, int userno, int startRow, int endRow) {
		ArrayList<Myboard> flist = new ArrayList<Myboard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * " + "from (select rownum rnum, FREE_NO, FREE_TITLE, FREE_WRITER, "
				+ "FREE_DATE, FREE_READCOUNT "
				+ "from free where FREE_WRITER = ? order by FREE_NO desc) " + "where rnum >=? and rnum <= ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Myboard free = new Myboard();

				free.setTextNo(rset.getInt("FREE_NO"));
				free.setTitle(rset.getString("FREE_TITLE"));
				free.setWriter(rset.getInt("FREE_WRITER"));
				free.setRegistDate(rset.getDate("FREE_DATE"));
				free.setTextReadcount(rset.getInt("FREE_READCOUNT"));

				flist.add(free);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return flist;
	}
	
	public int getFreeListCount(Connection conn, int userno) {
		int flistCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from free where FREE_WRITER = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				flistCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return flistCount;
	}
	
	public ArrayList<Myboard> qnaList(Connection conn, int userno, int startRow, int endRow) {
		ArrayList<Myboard> qlist = new ArrayList<Myboard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * " + "from (select rownum rnum, QNA_NO, QNA_TITLE, QNA_WRITER, "
				+ "QNA_DATE, QNA_READCOUNT "
				+ "from QNA where QNA_WRITER = ? order by QNA_NO desc) " + "where rnum >=? and rnum <= ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Myboard qna = new Myboard();

				qna.setTextNo(rset.getInt("QNA_NO"));
				qna.setTitle(rset.getString("QNA_TITLE"));
				qna.setWriter(rset.getInt("QNA_WRITER"));
				qna.setRegistDate(rset.getDate("QNA_DATE"));
				qna.setTextReadcount(rset.getInt("QNA_READCOUNT"));

				qlist.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return qlist;
	}
	
	public int getQnaListCount(Connection conn, int userno) {
		int qlistCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from qna where QNA_WRITER = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				qlistCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return qlistCount;
	}
	
	public ArrayList<Myboard> galleryList(Connection conn, int userno, int startRow, int endRow) {
		ArrayList<Myboard> glist = new ArrayList<Myboard>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * " + "from (select rownum rnum, GALLERY_NO, GALLERY_TITLE, GALLERY_WRITER, "
				+ "GALLERY_DATE, GALLERY_READCOUNT "
				+ "from GALLERY where GALLERY_WRITER = ? order by GALLERY_NO desc) " + "where rnum >=? and rnum <= ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
		
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Myboard gallery = new Myboard();

				gallery.setTextNo(rset.getInt("GALLERY_NO"));
				gallery.setTitle(rset.getString("GALLERY_TITLE"));
				gallery.setWriter(rset.getInt("GALLERY_WRITER"));
				gallery.setRegistDate(rset.getDate("GALLERY_DATE"));
				gallery.setTextReadcount(rset.getInt("GALLERY_READCOUNT"));

				glist.add(gallery);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return glist;
	}
	
	public int getGalleryListCount(Connection conn, int userno) {
		int glistCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) from GALLERY where GALLERY_WRITER = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userno);

			rset = pstmt.executeQuery();
			if (rset.next()) {
				glistCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return glistCount;
	}
}
