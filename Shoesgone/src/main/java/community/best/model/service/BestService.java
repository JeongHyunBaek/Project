package community.best.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.best.model.dao.BestDao;
import community.best.model.vo.Best;

public class BestService {
	private BestDao bdao = new BestDao();
	
	public ArrayList<Best> selectTop3(){
		Connection conn = getConnection();
		ArrayList<Best> list = bdao.selectTop3(conn);
		close(conn);
		return list;
	}
	public Best selectBest(int BestNo) {
		Connection conn = getConnection();
		Best Best = bdao.selectBest(conn, BestNo);
		close(conn);
		return Best;
	}
	
	public void addReadCount(int BestNo) {
		Connection conn = getConnection();
		int result = bdao.updateReadCount(conn, BestNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = bdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Best> selectList(int startRow, int endRow, String orderBy) {
		Connection conn = getConnection();
		ArrayList<Best> list = bdao.selectList(conn, startRow, endRow, orderBy);
		close(conn);
		return list;
	}

	public int insertOriginBest(Best Best) {
		Connection conn = getConnection();
		int result = bdao.insertOriginBest(conn, Best);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateOrigin(Best Best) {
		Connection conn = getConnection();
		int result = bdao.updateOrigin(conn, Best);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReply(Best Best) {
		Connection conn = getConnection();
		int result = bdao.updateReply(conn, Best);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public void updateReplySeq(Best reply) {
		Connection conn = getConnection();
		int result = bdao.updateReplySeq(conn, reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);		
	}

	public int insertReplyBest(Best reply) {
		Connection conn = getConnection();
		int result = bdao.insertReplyBest(conn, reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteBest(int BestNo, int BestLevel) {
		Connection conn = getConnection();
		int result = bdao.deleteBest(conn, BestNo, BestLevel);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
