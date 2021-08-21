package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Item;

public class ItemDao {

	// 발매 상품에 따른 상품 데이터베이스 조회
	public ArrayList<Item> selectRegList(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from(select rownum, item.* "
				+ "    from item "
				+ "	   order by item_drop_date desc) "
				+ "where rownum <= 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("item_eng_name"));
				item.setItemKrName(rset.getString("item_kr_name"));
				item.setBrand(rset.getString("item_brand"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				item.setViews(rset.getInt("item_views"));
				
				list.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	// 인기 상품에 따른 상품 데이터베이스 조회
	public ArrayList<Item> selectHotList(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from item "
				+ "where item_no in (select item_no "
				+ "				from(select rownum, item_no "
				+ "                    from(select count(*) order_count, orders.item_no "
				+ "                        from orders "
				+ "                        join item on orders.item_no = item.item_no "
				+ "                        group by orders.item_no "
				+ "                        order by 1 desc) "
				+ "                    where rownum <= 4)) "
				+ "order by item_no";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("item_eng_name"));
				item.setItemKrName(rset.getString("item_kr_name"));
				item.setBrand(rset.getString("item_brand"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				item.setViews(rset.getInt("item_views"));
				
				list.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	// 추천 상품에 따른 상품 데이터베이스 조회
	public ArrayList<Item> selectRecList(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from(select rownum, item.* "
				+ "    from item "
				+ "    order by item_views desc) "
				+ "where rownum <= 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("item_eng_name"));
				item.setItemKrName(rset.getString("item_kr_name"));
				item.setBrand(rset.getString("item_brand"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				item.setViews(rset.getInt("item_views"));
				
				list.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	// 새로운 즉시 구매가에 따른 상품 데이터베이스 조회
	public ArrayList<Item> selectNewBuyList(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from(select * "
				+ "    from(select rownum, sell_bid.* "
				+ "        from sell_bid "
				+ "        where price in (select max(sell_bid.price) "
				+ "                        from sell_bid "
				+ "                        join item on item.item_no = sell_bid.item_no "
				+ "                        group by item.item_no) "
				+ "        order by reg_date desc) "
				+ "    where rownum <=4) "
				+ "join item using(item_no) "
				+ "order by reg_date desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("item_eng_name"));
				item.setItemKrName(rset.getString("item_kr_name"));
				item.setBrand(rset.getString("item_brand"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				item.setViews(rset.getInt("item_views"));
				
				list.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	// 새로운 즉시 판매가에 따른 상품 데이터베이스 조회
	public ArrayList<Item> selectNewSellList(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from(select * "
				+ "    from(select rownum, buy_bid.* "
				+ "        from buy_bid "
				+ "        where price in (select max(buy_bid.price) "
				+ "                        from buy_bid "
				+ "                        join item on item.item_no = buy_bid.item_no "
				+ "                        group by item.item_no) "
				+ "        order by reg_date desc) "
				+ "    where rownum <=4) "
				+ "join item using(item_no) "
				+ "order by reg_date desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("item_eng_name"));
				item.setItemKrName(rset.getString("item_kr_name"));
				item.setBrand(rset.getString("item_brand"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				item.setViews(rset.getInt("item_views"));
				
				list.add(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	// 발매 예정에 따른 상품 데이터베이스 조회
	public ArrayList<Item> selectUpcomingList(Connection conn) {
		ArrayList<Item> list = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * "
				+ "from(select rownum, item.* "
				+ "    from item "
				+ "    order by item_drop_date desc) "
				+ "where rownum <= 4";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("item_eng_name"));
				item.setItemKrName(rset.getString("item_kr_name"));
				item.setBrand(rset.getString("item_brand"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				item.setViews(rset.getInt("item_views"));
				
				list.add(item);
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