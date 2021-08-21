package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.SellBidDao;
import categoryPage.model.vo.SellBid;

public class SellBidService {
	private SellBidDao sdao = new SellBidDao();

	// SellBidDao의 selectNewBuyList() 값을 받아서 전달하는 메소드
	public ArrayList<SellBid> selectNewBuyList() {
		Connection conn = getConnection();
		ArrayList<SellBid> list = sdao.selectNewBuyList(conn);
		close(conn);
		return list;
	}
}
