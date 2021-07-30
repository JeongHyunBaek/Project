package loginPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;

import loginPage.model.dao.LoginDao;
import loginPage.model.vo.Login;

public class LoginService {
	private LoginDao ldao = new LoginDao();

	// LoginDao 클래스에서 selectLogin 값 가져오는 메소드
	public Login selectLogin(String userid, String userpwd) {
		Connection conn = getConnection();
		Login login = ldao.selectLogin(conn, userid, userpwd);
		close(conn);
		return login;
	}

	// LoginDao 클래스에서 insertLogin 값 가져오는 메소드
	public int insertLogin(Login login) {
		Connection conn = getConnection();
		int result = ldao.insertLogin(conn, login);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// LoginDao 클래스에서 idValidate 값 가져오는 메소드
	public Login idValidate(String userid) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		Login login = ldao.idValidate(conn, userid);
		close(conn);
		return login;
	}

	// LoginDao 클래스에서 selectNaverLogin 값 가져오는 메소드
	public Login selectNaverLogin(String userid) {
		Connection conn = getConnection();
		Login login = ldao.selectNaverLogin(conn, userid);
		close(conn);
		return login;
	}

	// LoginDao 클래스에서 searchId 값 가져오는 메소드
	public Login searchId(String phone) {
		Connection conn = getConnection();
		Login login = ldao.searchId(conn, phone);
		close(conn);
		return login;
	}

	// LoginDao 클래스에서 insertNaverLogin 값 가져오는 메소드
	public int insertNaverLogin(Login newLogin) {
		Connection conn = getConnection();
		int result = ldao.insertNaverLogin(conn, newLogin);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	// LoginDao 클래스에서 searchPassword 값 가져오는 메소드
	public Login searchPassword(String phone, String email) {
		Connection conn = getConnection();
		Login login = ldao.searchPassword(conn, phone, email);
		close(conn);
		return login;
	}

	// LoginDao 클래스에서 tempPassword 값 가져오는 메소드
	public void tempPassword(String randomPassword, String phone, String email) {
		Connection conn = getConnection();
		int result = ldao.tempPassword(conn, randomPassword, phone, email);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	// LoginDao 클래스에서 updateLogin 값 가져오는 메소드
	public void updateLogin(Login newLogin, String cryptoUserpwd) {
		Connection conn = getConnection();
		int result = ldao.updateLogin(conn, newLogin, cryptoUserpwd);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}
}
