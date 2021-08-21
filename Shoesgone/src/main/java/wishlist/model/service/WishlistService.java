package wishlist.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import point.model.vo.Point;
import wishlist.model.dao.WishlistDao;
import wishlist.model.vo.Wishlist;

public class WishlistService {
	private WishlistDao wdao = new WishlistDao();

	public ArrayList<Wishlist> selectList(int startRow, int endRow, int userNo){
		Connection conn = getConnection();
		ArrayList<Wishlist> list = wdao.selectList(conn, startRow, endRow, userNo);
		close(conn);
		return list;
	}
	
	public int getListCount(int userNo) {
		Connection conn = getConnection();
		int listCount = wdao.getListCount(conn, userNo);
		close(conn);
		
		return listCount;
	}
	
	public int deleteAll(int userNo) {
		Connection conn = getConnection();
		int result = wdao.deleteAll(conn, userNo);
		close(conn);
		
		return result;
	}
	
	public int deleteWishlist(int userNo, int wishlistNo) {
		Connection conn = getConnection();
		int result = wdao.deleteWishlist(conn, userNo, wishlistNo);
		close(conn);
		
		return result;
	}

	


}
