package community.best.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.best.model.dao.BoardDao;
import community.best.model.vo.Board;

public class BoardService {
	private BoardDao bdao = new BoardDao();
	
	public ArrayList<Board> selectTop3(){
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectTop3(conn);
		close(conn);
		return list;
	}
	public Board selectBoard(int boardNum) {
		Connection conn = getConnection();
		Board board = bdao.selectBoard(conn, boardNum);
		close(conn);
		return board;
	}
	
	public void addReadCount(int boardNum) {
		Connection conn = getConnection();
		int result = bdao.updateReadCount(conn, boardNum);
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

	public ArrayList<Board> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Board> list = bdao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}

	public int insertOriginBoard(Board board) {
		Connection conn = getConnection();
		int result = bdao.insertOriginBoard(conn, board);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateOrigin(Board board) {
		Connection conn = getConnection();
		int result = bdao.updateOrigin(conn, board);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReply(Board board) {
		Connection conn = getConnection();
		int result = bdao.updateReply(conn, board);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public void updateReplySeq(Board reply) {
		Connection conn = getConnection();
		int result = bdao.updateReplySeq(conn, reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);		
	}

	public int insertReplyBoard(Board reply) {
		Connection conn = getConnection();
		int result = bdao.insertReplyBoard(conn, reply);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int deleteBoard(int boardNum, int boardLevel) {
		Connection conn = getConnection();
		int result = bdao.deleteBoard(conn, boardNum, boardLevel);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
