package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//여러 클래스가 공통으로 이용할 코드 작성용 클래스 : 공통 모듈
//데이터베이스 연결에 대한 Connection 관리와 트랜잭션 관리용 기능 제공
//싱글톤 패턴 적용 : 프로그램 구동내내 메모리에 딱 한번, 한개만 기록해서
//		여러 클래스가 공유하게 하는 구현 방식 => static 이용
public class JDBCTemp {
//	public static Connection getConnection() {
//		Connection conn = null;
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@127.0.0.1:1521:xe", 
//					"c##student", "c##student");
//			conn.setAutoCommit(false);		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return conn;
//	}
	
	public static Connection getConnection() {
		Connection conn = null;
		Properties settings = new Properties();		
		
		try {
			//현재 구동중인 웹애플리케이션에서 특정 폴더 안의
			//파일을 읽을려면, 폴더 지정부터 해야 함
			
			//JDBCTemp.class 파일의 위치부터 파악함
			String currentPath = JDBCTemp.class.getResource("./").getPath();
			//해당 폴더 안의 파일을 읽어들이게 함
			settings.load(new FileReader(currentPath + "jdbc.properties"));
			
			String driver = settings.getProperty("driver");
			String url = settings.getProperty("url");
			String user = settings.getProperty("user");
			String passwd = settings.getProperty("passwd");
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, passwd);
			conn.setAutoCommit(false);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}