package faq.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import faq.model.dao.FaqDao;
import faq.model.vo.Faq;
import notice.model.vo.Notice;

public class FaqService {
	private FaqDao fdao = new FaqDao();

	public ArrayList<Faq> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Faq> list = fdao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}

	public Faq selectOne(int faqNo) {
		Connection conn = getConnection();
		Faq faq = fdao.selectOne(conn, faqNo);
		close(conn);
		return faq;
	}

	public void updateReadCount(int faqNo) {
		Connection conn = getConnection();
		int result = fdao.updateReadCount(conn, faqNo);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = fdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public int insertFaq(Faq faq) {
		Connection conn = getConnection();
		int result = fdao.insertFaq(conn, faq);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int adminDeleteFaq(int faqNo) {
		Connection conn = getConnection();
		int result = fdao.adminDeleteFaq(conn, faqNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	public int adminUpdateFaq(Faq faq) {
		
			Connection conn = getConnection();
			int result = fdao.adminUpdateFaq(conn, faq);
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		}

	
	
}
