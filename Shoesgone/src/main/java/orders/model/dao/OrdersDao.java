package orders.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import orders.model.vo.Orders;

public class OrdersDao {
	// 전체 주문 목록 조회용 메소드
	// 페이징 처리 적용(1페이지 당 10개의 주문만)
		public ArrayList<Orders> selectOrdersList(Connection conn, int startRow, int endRow){
			ArrayList<Orders> list = new ArrayList<Orders>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String query = "select * from * ("
						 + "select rownum rnum, orders_no, user_no, item_no, user_id, pur_date, count, "
						 + "progress, price, address, shoes_size, phone, del_fee, payment "
						 + "from ("
						 + "select * from orders order by orders_no desc)) "
						 + "where rnum >= ? and rnum <= ?";
			
			try {
				ps = conn.prepareStatement(query);
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Orders orders = new Orders();
					
					orders.setOrdersNo(rs.getInt("orders_no"));
					orders.setSellerNo(rs.getInt("seller_no"));
					orders.setItemNo(rs.getInt("item_no"));
					orders.setBuyerNo(rs.getInt("buyer_id"));
					orders.setPurDate(rs.getDate("pur_date"));
					orders.setCount(rs.getInt("count"));
					orders.setProgress(rs.getString("progress"));
					orders.setPrice(rs.getInt("price"));
					orders.setAddress(rs.getString("address"));
					orders.setSize(rs.getInt("shoes_size"));
					orders.setPhone(rs.getString("phone"));
					orders.setDelFee(rs.getInt("del_fee"));
					orders.setPayment(rs.getString("payment"));
					
					list.add(orders);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(ps);
			}
			
			return list;
		}
	
	// 해당 주문 번호의 정보 출력용 메소드
	public Orders selectOne(Connection conn, int orderNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// 새 즉시 구매 주문용 메소드
	public int insertOrders(Connection conn, Orders orders) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "insert into orders values("
						+ "(SELECT MAX(ORDERS_NO)+1 FROM ORDERS), ?, ?, ?, sysdate, 1, '준비중', ?, "
						+ "?, ?, ?, 2500, ?)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, orders.getSellerNo());
			ps.setInt(2, orders.getItemNo());
			ps.setInt(3, orders.getBuyerNo());
			ps.setInt(4, orders.getPrice());
			ps.setString(5, orders.getAddress());
			ps.setInt(6, orders.getSize());
			ps.setString(7, orders.getPhone());
			ps.setString(8, orders.getPayment());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	// 주문 취소용 메소드
	public int deleteOrder(Connection conn, int orderNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	// 배송현황 갱신용 메소드
	public int updateProgress(Connection conn, Orders upProgress) {
		int result = 0;
		PreparedStatement ps =null;
		
		String query ="update orders set progress = ? where orders_no = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, upProgress.getProgress());
			ps.setInt(2, upProgress.getOrdersNo());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	// 배송지 변경용 메소드
	public int updateAddress(Connection conn, Orders upAdd) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "update orders set address = ? where orders_no = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setString(1, upAdd.getAddress());
			ps.setInt(2, upAdd.getOrdersNo());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	
	// 전체 주문목록 갯수 출력용 메소드
	public int getOrdersListCount(Connection conn) {
		int ordersListCount = 0;
		Statement stm = null;
		ResultSet rs = null;
		
		String query = "select count(*) from orders";
		
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			
			if(rs.next()) {
				ordersListCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stm);
		}
		
		return ordersListCount;
	}

	// 새 입찰 구매 주문용 메소드
	public int insertOrdersTen(Connection conn, Orders orders) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "insert into buy_bid values("
						+ "(SELECT MAX(ORDERS_NO)+1 FROM ORDERS), ?, ?, ?, sysdate, 1, '준비중', ?, "
						+ "?, ?, ?, 2500, ?)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, orders.getSellerNo());
			ps.setInt(2, orders.getItemNo());
			ps.setInt(3, orders.getBuyerNo());
			ps.setInt(4, orders.getPrice());
			ps.setString(5, orders.getAddress());
			ps.setInt(6, orders.getSize());
			ps.setString(7, orders.getPhone());
			ps.setString(8, orders.getPayment());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
}
