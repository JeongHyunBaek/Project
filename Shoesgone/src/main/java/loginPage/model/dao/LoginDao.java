package loginPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import loginPage.model.vo.Login;

public class LoginDao {

	public Login selectLogin(Connection conn, String userid, String userpwd) {
		Login login = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from user_info where user_id = ? and user_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				login = new Login();
				
				// 컬럼값 꺼내서, 필드에 옮겨 기록하기 : 결과매핑
				login.setUserNo(rset.getInt("user_no"));
				login.setUserName(rset.getString("user_name"));
				login.setUserId(userid);
				login.setUserPwd(userpwd);
				login.setEmail(rset.getString("email"));
				login.setPhone(rset.getString("phone"));
				login.setAddress(rset.getString("address"));
				login.setShoesSize(rset.getInt("shoes_size"));
				login.setPoint(rset.getInt("point"));
				login.setMgr(rset.getString("mgr"));
				login.setBankName(rset.getString("bank_name"));
				login.setAccountNo(rset.getString("account_no"));
				login.setLoginOk(rset.getString("login_ok"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return login;
	}

	public int insertLogin(Connection conn, Login login) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into user_info (user_no, user_id, user_pwd) "
				+ "values (?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, login.getUserNo());
			pstmt.setString(2, login.getUserId());
			pstmt.setString(3, login.getUserPwd());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
