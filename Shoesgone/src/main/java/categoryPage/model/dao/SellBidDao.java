package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.SellBid;

public class SellBidDao {

	// 새로운 즉시 구매가에 따른 판매입찰 데이터베이스 조회
	public ArrayList<SellBid> selectNewBuyList(Connection conn) {
		ArrayList<SellBid> list = new ArrayList<SellBid>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from(select rownum, sell_bid.* "
				+ "    from sell_bid "
				+ "    where price in (select min(sell_bid.price) "
				+ "                    from sell_bid "
				+ "                    join item on item.item_no = sell_bid.item_no "
				+ "                    group by item.item_no) "
				+ "    order by reg_date desc) "
				+ "where rownum <=4 "
				+ "order by price";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				SellBid sellbid = new SellBid();
				
				sellbid.setSellBidNo(rset.getInt("sell_bid_no"));
				sellbid.setUserNo(rset.getInt("user_no"));
				sellbid.setItemNo(rset.getInt("item_no"));
				sellbid.setShoesSize(rset.getInt("shoes_size"));
				sellbid.setRegDate(rset.getDate("reg_date"));
				sellbid.setPrice(rset.getInt("price"));
				sellbid.setPenalty(rset.getString("penalty"));
				sellbid.setAddress(rset.getString("address"));

				list.add(sellbid);
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
