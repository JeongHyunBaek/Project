package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.ItemPictureDao;
import categoryPage.model.vo.ItemPicture;

public class ItemPictureService {
	private ItemPictureDao ipdao = new ItemPictureDao();

	// ItemPictureDao의 selectLookupList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectLookupList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectLookupList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectHotList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectHotList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectHotList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectPremiumList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectPremiumList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectPremiumList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectBuyList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectBuyList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectBuyList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectSellList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectSellList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectSellList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectDropList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectDropList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectDropList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectSneakersList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectSneakersList() {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectSneakersList(conn);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectBrandList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectBrandList(String brand) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectBrandList(conn, brand);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectShoesSizeList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectShoesSizeList(String size) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectShoesSizeList(conn, size);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectPrice1List() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectPrice1List(String priceone) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectPrice1List(conn, priceone);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectPrice2List() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectPrice2List(String priceone, String pricetwo) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectPrice2List(conn, priceone, pricetwo);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectPrice3List() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectPrice3List(String priceone) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectPrice3List(conn, priceone);
		close(conn);
		return list;
	}

	// ItemPictureDao의 selectCollectionList() 값을 받아서 전달하는 메소드
	public ArrayList<ItemPicture> selectCollectionList(String collection) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectCollectionList(conn, collection);
		close(conn);
		return list;
	}

	public ArrayList<ItemPicture> selectSearchList(String text) {
		Connection conn = getConnection();
		ArrayList<ItemPicture> list = ipdao.selectSearchList(conn, text);
		close(conn);
		return list;
	}
}
