package point.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import point.model.dao.PointDao;
import point.model.vo.Point;

public class PointService {
	private PointDao pdao = new PointDao();

	public ArrayList<Point> selectList(int startRow, int endRow, int userNo){
		Connection conn = getConnection();
		ArrayList<Point> list = pdao.selectList(conn, startRow, endRow, userNo);
		close(conn);
		return list;
	}
	
	public int getListCount(int userNo) {
		Connection conn = getConnection();
		int listCount = pdao.getListCount(conn, userNo);
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Point> selectpoint(int userNo){
		Connection conn = getConnection();
		ArrayList<Point> pointlist = pdao.selectpoint(conn, userNo);
		close(conn);
		return pointlist;
	}
}
