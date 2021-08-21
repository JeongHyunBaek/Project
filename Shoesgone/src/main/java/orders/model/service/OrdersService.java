package orders.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import orders.model.vo.Orders;
import orders.model.dao.OrdersDao;

public class OrdersService {
	// DI
	private OrdersDao odao = new OrdersDao();
	
	// Method
	// 모든 주문의 정보 출력용 메소드
	public ArrayList<Orders> selectOrdersList(int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Orders> list = odao.selectOrdersList(conn, startRow, endRow);
		close(conn);
		
		return list;
	}
	
	// 해당 주문 번호의 정보 출력용 메소드
	public Orders selectOne(int orderNo) {
		Connection conn = getConnection();
		Orders order = odao.selectOne(conn, orderNo);
		close(conn);
		
		return order;
	}
	
	// 새 즉시 구매 주문용 메소드
	public int insertOrders(Orders orders) {
		Connection conn = getConnection();
		int result = odao.insertOrders(conn, orders);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	// 주문 취소용 메소드
	public int deleteOrder(int orderNo) {
		Connection conn = getConnection();
		int result = odao.deleteOrder(conn, orderNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	// 배송현황 갱신용 메소드
	public int updateProgress(Orders upProgress) {
		Connection conn = getConnection();
		int result = odao.updateProgress(conn, upProgress);
		close(conn);
		
		return result;
	}
	
	// 배송지 변경용 메소드
	public int updateAddress(Orders upAdd) {
		Connection conn = getConnection();
		int result = odao.updateAddress(conn, upAdd);
		close(conn);
		
		return result;
	}
	
	// 전체 주문목록 갯수 출력용 메소드
	public int getOrdersListCount() {
		Connection conn = getConnection();
		int ordersListCount = odao.getOrdersListCount(conn);
		close(conn);
		
		return ordersListCount;
	}

	// 새 입찰 구매 주문용 메소드
	public int insertOrdersTen(Orders orders) {
		Connection conn = getConnection();
		int result = odao.insertOrdersTen(conn, orders);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
}
