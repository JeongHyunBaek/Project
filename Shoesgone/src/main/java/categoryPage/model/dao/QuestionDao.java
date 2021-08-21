package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Question;

public class QuestionDao {

	public ArrayList<Question> selectQuestionList(Connection conn) {
		ArrayList<Question> list = new ArrayList<Question>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from question";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

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
			close(stmt);
		}
		return list;
	}
}
