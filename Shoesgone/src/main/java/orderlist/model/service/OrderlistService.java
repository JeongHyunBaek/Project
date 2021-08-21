package orderlist.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.vo.Notice;
import orderlist.model.dao.OrderlistDao;
import orderlist.model.vo.Orderlist;

public class OrderlistService {

	private OrderlistDao oldao = new OrderlistDao();
	
	public ArrayList<Orderlist> selectList(int startRow, int endRow, int userNo){
		Connection conn = getConnection();
		ArrayList<Orderlist> list = oldao.selectList(conn, startRow, endRow, userNo);
		close(conn);
		return list;
	}
	
	public int getListCount(int userNo) {
		Connection conn = getConnection();
		int ordersListCount = oldao.getListCount(conn, userNo);
		close(conn);
		
		return ordersListCount;
	}
	
	public Orderlist selectOne(int orderNo) {
		Connection conn = getConnection();
		Orderlist orderlist = oldao.selectOne(conn, orderNo);
		close(conn);
		return orderlist;
	}
	
	public ArrayList<Orderlist> adminSelectList(int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Orderlist> list = oldao.adminSelectList(conn, startRow, endRow);
		close(conn);
		return list;
	}
	
	public int adminGetListCount() {
		Connection conn = getConnection();
		int ordersListCount = oldao.adminGetListCount(conn);
		close(conn);
		
		return ordersListCount;
	}
	
}
