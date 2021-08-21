package information.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import information.model.dao.InformationDao;
import information.model.vo.Information;
import loginPage.model.vo.Login;

public class InformationService {
	private InformationDao idao = new InformationDao();
	
	public Information selectMember(String userid) {
		Connection conn = getConnection();
		Information information = idao.selectMember(conn, userid);
		close(conn);
		return information;
	}
	public int updateMember(Information information) {
		Connection conn = getConnection();
		int result = idao.updateMember(conn, information);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateName(Information information) {
		Connection conn = getConnection();
		int result = idao.updateName(conn, information);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public Information adminselectMember(int userNo) {
		Connection conn = getConnection();
		Information information = idao.adminSelectMember(conn, userNo);
		close(conn);
		return information;
	}
	
	public ArrayList<Information> adminselectAllMembers() {
		Connection conn = getConnection();
		ArrayList<Information> users = idao.adminselectAllMembers(conn);
		close(conn);
		return users;
	}
	public Information adminselectMGRLOKMember(int userno) {
		Connection conn = getConnection();
		Information user = idao.adminselectMGRLOKMember(conn, userno);
		close(conn);
		return user;
	}
	public int adminupdateMGR(int userno, String mgrstatus) {
		Connection conn = getConnection();
		int result = idao.adminupdateMGR(conn, userno, mgrstatus);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	public int adminupdateLOK(int userno, String lokstatus) {
		Connection conn = getConnection();
		int result = idao.adminupdateLOK(conn, userno, lokstatus);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
}