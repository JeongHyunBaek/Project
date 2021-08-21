package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Faq;

public class FaqDao {

	public ArrayList<Faq> selectFaqList(Connection conn) {
		ArrayList<Faq> list = new ArrayList<Faq>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from faq";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Faq faq = new Faq();
				
				faq.setFaqNo(rset.getInt("faq_no"));
				faq.setFaqTitle(rset.getString("faq_title"));
				faq.setFaqWriter(rset.getString("faq_writer"));
				faq.setFaqDate(rset.getDate("faq_date"));
				faq.setFaqContent(rset.getString("faq_content"));
				faq.setFaqReadcount(rset.getInt("faq_readcount"));
				faq.setFaqavailable(rset.getInt("faq_available"));

				list.add(faq);
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
