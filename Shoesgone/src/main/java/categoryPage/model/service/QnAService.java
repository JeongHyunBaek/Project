package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.QnADao;
import categoryPage.model.vo.QnA;

public class QnAService {
	private QnADao qdao = new QnADao();

	public ArrayList<QnA> selectQnaList() {
		Connection conn = getConnection();
		ArrayList<QnA> list = qdao.selectQnaList(conn);
		close(conn);
		return list;
	}
}
