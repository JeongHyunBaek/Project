package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.ItemDao;
import categoryPage.model.vo.Item;

public class ItemService {
	private ItemDao idao = new ItemDao();
	
	// ItemDao의 selectRegList() 값을 받아서 전달하는 메소드
	public ArrayList<Item> selectRegList() {
		Connection conn = getConnection();
		ArrayList<Item> list = idao.selectRegList(conn);
		close(conn);
		return list;
	}

	// ItemDao의 selectHotList() 값을 받아서 전달하는 메소드
	public ArrayList<Item> selectHotList() {
		Connection conn = getConnection();
		ArrayList<Item> list = idao.selectHotList(conn);
		close(conn);
		return list;
	}

	// ItemDao의 selectRecList() 값을 받아서 전달하는 메소드
	public ArrayList<Item> selectRecList() {
		Connection conn = getConnection();
		ArrayList<Item> list = idao.selectRecList(conn);
		close(conn);
		return list;
	}

	// ItemDao의 selectNewBuyList() 값을 받아서 전달하는 메소드
	public ArrayList<Item> selectNewBuyList() {
		Connection conn = getConnection();
		ArrayList<Item> list = idao.selectNewBuyList(conn);
		close(conn);
		return list;
	}

	// ItemDao의 selectNewSellList() 값을 받아서 전달하는 메소드
	public ArrayList<Item> selectNewSellList() {
		Connection conn = getConnection();
		ArrayList<Item> list = idao.selectNewSellList(conn);
		close(conn);
		return list;
	}

	// ItemDao의 selectUpcomingList() 값을 받아서 전달하는 메소드
	public ArrayList<Item> selectUpcomingList() {
		Connection conn = getConnection();
		ArrayList<Item> list = idao.selectUpcomingList(conn);
		close(conn);
		return list;
	}
}
