package community.gallery.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.gallery.model.vo.Gallery;

public class GalleryDao {

	public ArrayList<Gallery> selectTop3(Connection conn) {
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * "
				+ "FROM (SELECT ROWNUM RNUM, Gallery_No, Gallery_TITLE, Gallery_READCOUNT "
				+ "        FROM (SELECT * FROM Gallery "
				+ "                WHERE Gallery_LEVEL = 1 "
				+ "                ORDER BY Gallery_READCOUNT DESC)) "
				+ "WHERE RNUM >= 1 AND RNUM <= 3";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Gallery Gallery = new Gallery();
				
				Gallery.setGalleryNo(rset.getInt("Gallery_No"));
				Gallery.setGalleryTitle(rset.getString("Gallery_title"));
				Gallery.setGalleryReadCount(rset.getInt("Gallery_readcount"));
				
				list.add(Gallery);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}		
		
		return list;
	}
	public Gallery selectGallery(Connection conn, int GalleryNo) {
		Gallery Gallery = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select gallery_no, gallery_title, gallery_content, gallery_writer, to_char(gallery_date, 'YYYY-MM-DD HH24:MI:SS') as gallery_date"
				+ ", gallery_readcount from gallery "
				+ "where Gallery_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, GalleryNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Gallery = new Gallery();
				
				Gallery.setGalleryNo(GalleryNo);
				Gallery.setGalleryTitle(rset.getString("Gallery_title"));
				Gallery.setGalleryWriter(rset.getInt("Gallery_writer"));
				Gallery.setGalleryContent(rset.getString("Gallery_content"));
				Gallery.setGalleryOriginalFilename(rset.getString("Gallery_original_filename"));
				Gallery.setGalleryRenameFilename(rset.getString("Gallery_rename_filename"));
				Gallery.setGalleryDate(rset.getString("Gallery_date"));
				Gallery.setGalleryReadCount(rset.getInt("Gallery_readcount"));
				Gallery.setGalleryLike(rset.getInt("Gallery_like"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return Gallery;
	}

	public int updateReadCount(Connection conn, int GalleryNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Gallery set "
				+ "Gallery_readcount = Gallery_readcount + 1 "
				+ "where Gallery_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, GalleryNo);
			
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
		
		String query = "select count(*) from Gallery";
		
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

	public ArrayList<Gallery> selectList(Connection conn, 
			int startRow, int endRow, String orderBy) {
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		/*
		 * String query = "SELECT * " +
		 * "FROM (SELECT ROWNUM RNUM, Gallery_No, Gallery_TITLE, Gallery_WRITER,  " +
		 * "                Gallery_ORIGINAL_FILENAME, Gallery_RENAME_FILENAME,  " +
		 * "                Gallery_DATE, Gallery_LEVEL, Gallery_REF, Gallery_REPLY_REF,  "
		 * + "                Gallery_REPLY_SEQ, Gallery_READCOUNT, Gallery_content , Gallery_like" +
		 * "        FROM (SELECT * FROM Gallery " +
		 * "                ORDER BY Gallery_REF DESC, Gallery_REPLY_REF DESC, " +
		 * "                          Gallery_LEVEL ASC, Gallery_REPLY_SEQ ASC)) " +
		 * "WHERE RNUM >= ? AND RNUM <= ?";
		 */
		String query = "SELECT *"
				+ "FROM (SELECT ROWNUM RNUM, Gallery_No, Gallery_TITLE, Gallery_WRITER,  "
				+ "                  Gallery_DATE, Gallery_READCOUNT, Gallery_content , Gallery_like "
				+ "            FROM (SELECT *"
				+ "		               FROM Gallery "
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
				Gallery Gallery  = new Gallery();
				
				Gallery.setGalleryNo(rset.getInt("Gallery_No"));
				Gallery.setGalleryTitle(rset.getString("Gallery_title"));
				Gallery.setGalleryWriter(rset.getInt("Gallery_writer"));
				Gallery.setGalleryContent(rset.getString("Gallery_content"));				
				Gallery.setGalleryDate(rset.getString("Gallery_date"));
				//Gallery.setGalleryOriginalFilename(rset.getString("Gallery_original_filename"));
				//Gallery.setGalleryRenameFilename(rset.getString("Gallery_rename_filename"));
				Gallery.setGalleryReadCount(rset.getInt("Gallery_readcount"));
				Gallery.setGalleryLike(rset.getInt("Gallery_like"));
				
				list.add(Gallery);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertOriginGallery(Connection conn, Gallery Gallery) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into Gallery values ("
				+ "(select max(Gallery_No) + 1 from Gallery), "
				+ "?, ?, ?, ?, ?, sysdate, 1, "
				+ "(select max(Gallery_No) + 1 from Gallery), "
				+ "null, default, default)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, Gallery.getGalleryTitle());
			pstmt.setInt(2, Gallery.getGalleryWriter());
			pstmt.setString(3, Gallery.getGalleryContent());
			pstmt.setString(4, Gallery.getGalleryOriginalFilename());
			pstmt.setString(5, Gallery.getGalleryRenameFilename());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateOrigin(Connection conn, Gallery origin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Gallery set "
				+ "Gallery_title = ?, "
				+ "Gallery_content = ?, "
				+ "Gallery_original_filename = ?, "
				+ "Gallery_rename_filename = ? "
				+ "where Gallery_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, origin.getGalleryTitle());
			pstmt.setString(2, origin.getGalleryContent());
			pstmt.setString(3, origin.getGalleryOriginalFilename());
			pstmt.setString(4, origin.getGalleryRenameFilename());
			pstmt.setInt(5, origin.getGalleryNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReply(Connection conn, Gallery reply) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update Gallery set "
				+ "Gallery_title = ?, "
				+ "Gallery_content = ? "
				+ "where Gallery_No = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, reply.getGalleryTitle());
			pstmt.setString(2, reply.getGalleryContent());
			pstmt.setInt(3, reply.getGalleryNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

	

	public int deleteGallery(Connection conn, 
			int GalleryNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from Gallery where gallery_no = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, GalleryNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}













