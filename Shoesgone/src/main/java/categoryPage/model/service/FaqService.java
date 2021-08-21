package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.FaqDao;
import categoryPage.model.vo.Faq;

public class FaqService {
	private FaqDao fdao = new FaqDao();

	public ArrayList<Faq> selectFaqList() {
		Connection conn = getConnection();
		ArrayList<Faq> list = fdao.selectFaqList(conn);
		close(conn);
		return list;
	}
}
