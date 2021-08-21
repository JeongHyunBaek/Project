package wishlist.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import wishlist.model.vo.Wishlist;

public class WishlistDao {

	public ArrayList<Wishlist> selectList(Connection conn, int startRow, int endRow, int userNo) {
		ArrayList<Wishlist> list = new ArrayList<Wishlist>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from ( "
				+ "select rownum rnum, w.wish_list_no, w.user_no, w.item_no, i.ITEM_ENG_NAME, i.item_kr_name, i.item_price "
				+ "from wish_list w join item i " + "on w.item_no = i.item_no " + "where user_no = ?  order by w.wish_list_no desc )  "
				+ "where rnum >= ? and rnum <= ? ";

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userNo);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
		
			rs = ps.executeQuery();

			while (rs.next()) {
				Wishlist wishlist = new Wishlist();

				wishlist.setWishlistNo(rs.getInt("wish_list_no"));
				wishlist.setUserNo(rs.getInt("user_no"));
				wishlist.setItemNo(rs.getInt("item_no"));
				wishlist.setItemEngName(rs.getString("item_eng_name"));
				wishlist.setItemKrName(rs.getString("item_kr_name"));
				wishlist.setPrice(rs.getInt("item_price"));

				list.add(wishlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}

		return list;
	}

	public int getListCount(Connection conn, int userNo) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String query = "select count(*) from wish_list where user_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return listCount;
	}

	public int deleteAll(Connection conn, int userNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "DELETE FROM wish_list "
				+ "WHERE user_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	
	public int deleteWishlist(Connection conn, int userNo, int wishlistNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "delete from wish_list where user_no = ? and wish_list_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
		
			pstmt.setInt(1, userNo);
			
			pstmt.setInt(2, wishlistNo);
			
			result = pstmt.executeUpdate();
	


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}



	
	


}
