package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.BuyBidDao;
import categoryPage.model.vo.BuyBid;

public class BuyBidService {
	private BuyBidDao bdao = new BuyBidDao();

	// BuyBidDao의 selectNewSellList() 값을 받아서 전달하는 메소드
	public ArrayList<BuyBid> selectNewSellList() {
		Connection conn = getConnection();
		ArrayList<BuyBid> list = bdao.selectNewSellList(conn);
		close(conn);
		return list;
	}
}
