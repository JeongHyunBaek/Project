package community.qna.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.qna.model.dao.QnADao;
import community.qna.model.vo.QnA;

public class QnAService {
	private QnADao qdao = new QnADao();
	
	public ArrayList<QnA> selectTop3(){
		Connection conn = getConnection();
		ArrayList<QnA> list = qdao.selectTop3(conn);
		close(conn);
		return list;
	}
	public QnA selectQnA(int QnANo) {
		Connection conn = getConnection();
		QnA QnA = qdao.selectQnA(conn, QnANo);
		close(conn);
		return QnA;
	}
	
	public void addReadCount(int QnANo) {
		Connection conn = getConnection();
		int result = qdao.updateReadCount(conn, QnANo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = qdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<QnA> selectList(int startRow, int endRow, String orderBy) {
		Connection conn = getConnection();
		ArrayList<QnA> list = qdao.selectList(conn, startRow, endRow, orderBy);
		close(conn);
		return list;
	}

	public int insertOriginQnA(QnA QnA) {
		Connection conn = getConnection();
		int result = qdao.insertOriginQnA(conn, QnA);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateOrigin(QnA QnA) {
		Connection conn = getConnection();
		int result = qdao.updateOrigin(conn, QnA);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReply(QnA QnA) {
		Connection conn = getConnection();
		int result = qdao.updateReply(conn, QnA);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	public int deleteQnA(int QnANo) {
		Connection conn = getConnection();
		int result = qdao.deleteQnA(conn, QnANo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
