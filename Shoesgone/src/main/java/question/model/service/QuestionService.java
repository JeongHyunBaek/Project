package question.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.vo.Notice;
import question.model.vo.Question;
import question.model.dao.QuestionDao;

public class QuestionService {
	private QuestionDao qdao = new QuestionDao();

	public ArrayList<Question> selectList(int startRow, int endRow) {
		Connection conn = getConnection();
		ArrayList<Question> list = qdao.selectList(conn, startRow, endRow);
		close(conn);
		return list;
	}

	public Question selectOne(int questionNo) {
		Connection conn = getConnection();
		Question question = qdao.selectOne(conn, questionNo);
		close(conn);
		return question;
	}

	public void updateReadCount(int questionNo) {
		Connection conn = getConnection();
		int result = qdao.updateReadCount(conn, questionNo);
		if (result > 0) {
			commit(conn);
		} else {
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

	public int insertQuestion(Question question) {
		Connection conn = getConnection();
		int result = qdao.insertQuestion(conn, question);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}		

	public int updateQuestion(Question question) {
		Connection conn = getConnection();
		int result = qdao.updateQuestion(conn, question);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteQuestion(int questionNo) {
		Connection conn = getConnection();
		int result = qdao.deleteQuestion(conn, questionNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int adminReplyInsert(Question question) {
		Connection conn = getConnection();
		int result = qdao.adminReplyInsert(conn, question);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int adminDeleteQuestion(int questionNo, int questionLevel) {
		Connection conn = getConnection();
		int result = qdao.adminDeleteQuestion(conn, questionNo, questionLevel);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int adminUpdateReply(Question question) {
		Connection conn = getConnection();
		int result = qdao.adminUpdateReply(conn, question);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
