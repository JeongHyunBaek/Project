package question.model.dao;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import question.model.vo.Question;
import question.model.service.QuestionService;

public class QuestionDao {

	public ArrayList<Question> selectList(Connection conn, int startRow, int endRow) {
		ArrayList<Question> list = new ArrayList<Question>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from (select rownum rnum, question_no, question_title, question_writer, "
				+ "    question_date, question_content, question_readcount, question_ref, question_level,question_available "
				+ "    from (select * from question where question_available = 1 "
				+ "    order by question_ref desc, question_level asc)) "
				+ "WHERE RNUM >= ? AND RNUM <= ?";

		try {

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Question question = new Question();

				question.setQuestionNo(rset.getInt("question_no"));
				question.setQuestionTitle(rset.getString("question_title"));
				question.setQuestionWriter(rset.getString("question_writer"));
				question.setQuestionDate(rset.getDate("question_date"));
				question.setQuestionContent(rset.getString("question_content"));
				question.setQuestionReadcount(rset.getInt("question_readcount"));
				question.setQuestionRef(rset.getInt("question_ref"));
				question.setQuestionLevel(rset.getInt("question_level"));
				question.setQuestionAvailable(rset.getInt("question_available"));

				list.add(question);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

//	공지글번호로 한 개 조회 : 공지사항 상세보기용
	public Question selectOne(Connection conn, int questionNo) {
		Question question = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from question " + "where question_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, questionNo);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				question = new Question();

				question.setQuestionNo(questionNo);
				question.setQuestionTitle(rset.getString("question_title"));
				question.setQuestionWriter(rset.getString("question_writer"));
				question.setQuestionDate(rset.getDate("question_date"));
				question.setQuestionContent(rset.getString("question_content"));
				question.setQuestionReadcount(rset.getInt("question_readcount"));
				question.setQuestionRef(rset.getInt("question_ref"));
				question.setQuestionLevel(rset.getInt("question_level"));
				question.setQuestionAvailable(rset.getInt("question_available"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return question;
	}

	public int updateReadCount(Connection conn, int questionNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update question set " + "question_readcount = question_readcount + 1 "
				+ "where question_no = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, questionNo);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int getListCount(Connection conn) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select count(*) from question where question_available = 1";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public int insertQuestion(Connection conn, Question question) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into question "
				+ "values ((select max(question_no) + 1 from question), ?, ?, sysdate, ?, default, "
				+ "(select max(question_no) + 1 from question), 1, 1)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, question.getQuestionTitle());
			pstmt.setString(2, question.getQuestionWriter());
			pstmt.setString(3, question.getQuestionContent());
			
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int updateQuestion(Connection conn, Question question) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update question set "
				+ "question_title = ?, "
				+ "question_content = ? "
				+ "where question_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, question.getQuestionTitle());		
			pstmt.setString(2, question.getQuestionContent());
			pstmt.setInt(3, question.getQuestionNo());
	
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteQuestion(Connection conn, 
			int questionNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update question set question_available = 0 where question_ref = ? ";
		
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, questionNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int adminReplyInsert(Connection conn, Question question) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into question "
				+ "values ((select max(question_no) + 1 from question), '답변입니다.', '관리자', sysdate, ?, default, "
				+ "?, 2, 1)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, question.getQuestionContent());
			pstmt.setInt(2, question.getQuestionNo());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adminDeleteQuestion(Connection conn, 
			int questionNo, int questionLevel) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from question ";
		
		if(questionLevel == 1) {
		
			query += "where question_ref = ?";
		}
		
		if(questionLevel == 2) {
			
			query += "where question_no = ?";
		}
		

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, questionNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int adminUpdateReply(Connection conn, Question question) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update question set "
				+ "question_content = ? "
				+ "where question_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
				
			pstmt.setString(1, question.getQuestionContent());
			pstmt.setInt(2, question.getQuestionNo());
	
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
