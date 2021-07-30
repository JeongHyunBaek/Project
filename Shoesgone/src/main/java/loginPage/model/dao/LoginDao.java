package loginPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import loginPage.model.vo.Login;

public class LoginDao {

	// 아이디, 비밀번호에 해당하는 모든 데이터베이스 값을 기록하는 메소드
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

	// 사용자 번호, 아이디, 비밀번호 값 데이터베이스에 삽입하는 메소드
	public int insertLogin(Connection conn, Login login) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into user_info (user_no, user_id, user_pwd) "
				+ "values (user_seq.nextval, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, login.getUserId());
			pstmt.setString(2, login.getUserPwd());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 해당하는 아이디에 따른 사용자 아이디 값 기록 메소드
	public Login idValidate(Connection conn, String userid) {
		Login login = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select user_id from user_info where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				login = new Login();
				
				login.setUserId(userid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return login;
	}

	// 해당하는 아이디에 따른 사용자 아이디, 비밀번호, 로그인 가능 유무 값 기록 메소드
	public Login selectNaverLogin(Connection conn, String userid) {
		Login login = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select user_id, user_pwd, login_ok from user_info where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				login = new Login();
				
				login.setUserId(userid);
				login.setUserPwd(rset.getString("user_pwd"));
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

	// 해당하는 전화번호에 따른 사용자 아이디 값 기록 메소드
	public Login searchId(Connection conn, String phone) {
		Login login = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select user_id from user_info where phone = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				login = new Login();
				
				login.setUserId(rset.getString("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return login;
	}

	// 사용자 번호, 이름, 아이디, 비밀번호, 이메일 값 데이터베이스에 삽입하는 메소드
	public int insertNaverLogin(Connection conn, Login newLogin) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into user_info (user_no, user_name, user_id, user_pwd, email) "
				+ "values (user_seq.nextval, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newLogin.getUserName());
			pstmt.setString(2, newLogin.getUserId());
			pstmt.setString(3, newLogin.getUserPwd());
			pstmt.setString(4, newLogin.getEmail());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 해당하는 전화번호, 이메일에 따른 비밀번호 값 기록 메소드
	public Login searchPassword(Connection conn, String phone, String email) {
		Login login = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select user_pwd from user_info where phone = ? and email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			pstmt.setString(2, email);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				login = new Login();
				
				login.setUserPwd(rset.getString("user_pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return login;
	}

	// 해당하는 전화번호, 이메일 사용자의 비밀번호를 임시 비밀번호로 데이터베이스에 업데이트하는 메소드
	public int tempPassword(Connection conn, String randomPassword, String phone, String email) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update user_info "
				+ "set user_pwd = ? "
				+ "where phone = ? and email = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, randomPassword);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 해당하는 비밀번호 사용자의 비밀번호를 SHA-512 비밀번호로 데이터베이스에 업데이트하는 메소드
	public int updateLogin(Connection conn, Login newLogin, String cryptoUserpwd) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update user_info "
				+ "set user_pwd = ? "
				+ "where user_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, cryptoUserpwd);
			pstmt.setString(2, newLogin.getUserPwd());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
}
