package community.reply.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import community.reply.model.dao.ReplyDao;
import community.reply.model.vo.Reply;

public class ReplyService {
private ReplyDao rpdao = new ReplyDao();
	

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = rpdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	/*
	 * public ArrayList<Reply> selectList(int startRow, int endRow, String orderBy)
	 * { Connection conn = getConnection(); ArrayList<Reply> list =
	 * rpdao.selectList(conn, startRow, endRow, orderBy); close(conn); return list;
	 * }
	 */

	/*
	public int insertOriginreply(Reply Reply) {
		Connection conn = getConnection();
		int result = rpdao.insertOriginReply(conn, Reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateOrigin(Reply Reply) {
		Connection conn = getConnection();
		int result = rpdao.updateOrigin(Reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReply(Reply Reply) {
		Connection conn = getConnection();
		int result = rpdao.updateReply(Reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public void updateReplySeq(Reply reply) {
		Connection conn = getConnection();
		int result = rpdao.updateReplySeq(conn, reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);		
	}

	public int insertReplyreply(Reply reply) {
		Connection conn = getConnection();
		int result = rpdao.insertReplyReply(conn, reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteReply(int ReplyNo, int ReplyLevel) {
		Connection conn = getConnection();
		int result = rpdao.deleteReply(conn, ReplyNo, ReplyLevel);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	*/
	public List<Reply> selectReplyList(int freeNo) {
		Connection conn = getConnection();
		
		List<Reply> replyList = rpdao.selectReplyList(conn, freeNo);
		
		close(conn);
		return replyList;
	}

}
