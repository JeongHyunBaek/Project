package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Free;

public class FreeDao {

	public ArrayList<Free> selectFreeList(Connection conn) {
		ArrayList<Free> list = new ArrayList<Free>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from free";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Free free = new Free();
				
				free.setFreeNo(rset.getInt("free_no"));
				free.setFreeTitle(rset.getString("free_title"));
				free.setFreeWriter(rset.getInt("free_writer"));
				free.setFreeDate(rset.getDate("free_date"));
				free.setFreeContent(rset.getString("free_content"));
				free.setFreeOriginalFilename(rset.getString("free_original_filename"));
				free.setFreeRenameFilename(rset.getString("free_rename_filename"));
				free.setFreeLike(rset.getInt("free_like"));
				free.setFreeUnlike(rset.getInt("free_unlike"));
				free.setFreeReadCount(rset.getInt("free_readcount"));
				
				list.add(free);
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
