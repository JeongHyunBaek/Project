package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.QuestionDao;
import categoryPage.model.vo.Question;

public class QuestionService {
	private QuestionDao qdao = new QuestionDao();

	public ArrayList<Question> selectQuestionList() {
		Connection conn = getConnection();
		ArrayList<Question> list = qdao.selectQuestionList(conn);
		close(conn);
		return list;
	}
}
