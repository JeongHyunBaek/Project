package orderlist.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;
import orderlist.model.vo.Orderlist;

public class OrderlistDao {

	
	public ArrayList<Orderlist> selectList(Connection conn, int startRow, int endRow, int userNo){
		ArrayList<Orderlist> list = new ArrayList<Orderlist>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select * from ("
				+ "select rownum rnum, o.orders_no, o.item_no, o.buyer_no, o.shoes_size, o.price, o.count, o.del_fee, o.progress, i.ITEM_ENG_NAME, i.item_kr_name "
				+ "from orders o join item i "
				+ "on o.item_no = i.item_no where buyer_no = ? "
				+ "order by o.orders_no desc) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userNo);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
		
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Orderlist orderlist = new Orderlist();
				
				orderlist.setOrdersNo(rs.getInt("orders_no"));
				orderlist.setItemNo(rs.getInt("item_no"));
				orderlist.setBuyerNo(rs.getInt("buyer_no"));
				orderlist.setShoesSize(rs.getInt("shoes_size"));
				orderlist.setPrice(rs.getInt("price"));
				orderlist.setCount(rs.getInt("count"));
				orderlist.setDelFee(rs.getInt("del_fee"));
				orderlist.setProgress(rs.getString("progress"));
				orderlist.setItemEngName(rs.getString("ITEM_ENG_NAME"));
				orderlist.setItemKrName(rs.getString("ITEM_KR_NAME"));
				
				list.add(orderlist);
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
		int ordersListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) from orders where buyer_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				ordersListCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return ordersListCount;
	}
	
	
	public Orderlist selectOne(Connection conn, int orderNo) {
		Orderlist orderlist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from ( "
				+ "select o.ORDERS_NO,o.SELLER_NO,o.ITEM_NO,o.BUYER_NO,o.PUR_DATE,o.COUNT,o.PROGRESS, "
				+ "o.PRICE,o.ADDRESS,o.SHOES_SIZE,o.PHONE,o.DEL_FEE, "
				+ "o.PAYMENT, i.ITEM_ENG_NAME, i.item_kr_name, p.point "
				+ "from orders o join item i "
				+ "on o.item_no = i.item_no "
				+ "left join points p "
				+ "on o.orders_no = p.orders_no "
				+ "order by o.orders_no desc) "
				+ "where orders_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, orderNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				orderlist = new Orderlist();
				
				orderlist.setOrdersNo(orderNo);
				orderlist.setSellerNo(rset.getInt("seller_no"));
				orderlist.setItemNo(rset.getInt("item_no"));
				orderlist.setBuyerNo(rset.getInt("buyer_no"));
				orderlist.setPurDate(rset.getDate("pur_date"));
				orderlist.setCount(rset.getInt("count"));
				orderlist.setProgress(rset.getString("progress"));
				orderlist.setPrice(rset.getInt("price"));
				orderlist.setAddress(rset.getString("address"));
				orderlist.setShoesSize(rset.getInt("shoes_size"));
				orderlist.setPhone(rset.getString("phone"));
				orderlist.setDelFee(rset.getInt("del_fee"));
				orderlist.setPayment(rset.getString("payment"));
				orderlist.setItemEngName(rset.getString("ITEM_ENG_NAME"));
				orderlist.setItemKrName(rset.getString("ITEM_KR_NAME"));
				orderlist.setPoint(rset.getInt("point"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return orderlist;
	}

	public ArrayList<Orderlist> adminSelectList(Connection conn, int startRow, int endRow){
		ArrayList<Orderlist> list = new ArrayList<Orderlist>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select * from ("
				+ "select rownum rnum, o.orders_no, o.item_no, o.seller_no, o.buyer_no, o.price, o.count, o.progress, i.ITEM_ENG_NAME "
				+ "from orders o join item i "
				+ "on o.item_no = i.item_no "
				+ "order by o.orders_no desc) "
				+ "where rnum >= ? and rnum <=?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Orderlist orderlist = new Orderlist();
				
				orderlist.setOrdersNo(rs.getInt("orders_no"));
				orderlist.setItemNo(rs.getInt("item_no"));
				orderlist.setSellerNo(rs.getInt("seller_no"));
				orderlist.setBuyerNo(rs.getInt("buyer_no"));
				orderlist.setPrice(rs.getInt("price"));
				orderlist.setCount(rs.getInt("count"));
				orderlist.setProgress(rs.getString("progress"));
				orderlist.setItemEngName(rs.getString("ITEM_ENG_NAME"));
				
				list.add(orderlist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}
	
	
	public int adminGetListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select count(*) from orders ";
		
		try {
			pstmt = conn.prepareStatement(query);

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
	
	
	
}
