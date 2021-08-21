package point.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import point.model.vo.Point;

public class PointDao {
	public ArrayList<Point> selectList(Connection conn, int startRow, int endRow, int userNo){
		ArrayList<Point> list = new ArrayList<Point>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select * from ( "
				+ "select rownum rnum, USER_NO , orders_no, reg_date, point, history "
				+ "FROM POINTS where user_no = ? "
				+ "order by orders_no desc) "
				+ "where rnum >= ? and rnum <= ? ";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userNo);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
			
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Point point = new Point();
				
				point.setUserNo(rs.getInt("user_no"));
				point.setOrderNo(rs.getInt("orders_no"));
				point.setRegistDate(rs.getDate("reg_date"));
				point.setPoint(rs.getInt("point"));
				point.setHistory(rs.getString("history"));
		
				
				list.add(point);
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
		
		String query = "select count(*) from points where user_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
	
	public ArrayList<Point> selectpoint(Connection conn, int userNo){
		ArrayList<Point> pointlist = new ArrayList<Point>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select point from points "
				+ "where user_no = ?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, userNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Point point = new Point();
			
				point.setPoint(rs.getInt("point"));
				
		
				
				pointlist.add(point);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return pointlist;
	}
}
