package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Gallery;

public class GalleryDao {

	public ArrayList<Gallery> selectGalleryList(Connection conn) {
		ArrayList<Gallery> list = new ArrayList<Gallery>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from gallery";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Gallery gallery = new Gallery();
				
				gallery.setGalleryNo(rset.getInt("gallery_no"));
				gallery.setGalleryTitle(rset.getString("gallery_title"));
				gallery.setGalleryWriter(rset.getInt("gallery_writer"));
				gallery.setGalleryDate(rset.getDate("gallery_date"));
				gallery.setGalleryContent(rset.getString("gallery_content"));
				gallery.setGalleryOriginalFilename(rset.getString("gallery_original_filename"));
				gallery.setGalleryRenameFilename(rset.getString("gallery_rename_filename"));
				gallery.setGalleryLike(rset.getInt("gallery_like"));
				gallery.setGalleryUnlike(rset.getInt("gallery_unlike"));
				gallery.setGalleryReadCount(rset.getInt("gallery_readcount"));
				
				list.add(gallery);
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
