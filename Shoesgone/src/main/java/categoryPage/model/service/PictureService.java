package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.PictureDao;
import categoryPage.model.vo.Picture;

public class PictureService {
	private PictureDao pdao = new PictureDao();

	// PicturesDao의 selectRegList() 값을 받아서 전달하는 메소드
	public ArrayList<Picture> selectRegList() {
		Connection conn = getConnection();
		ArrayList<Picture> list = pdao.selectRegList(conn);
		close(conn);
		return list;
	}

	// PicturesDao의 selectHotList() 값을 받아서 전달하는 메소드
	public ArrayList<Picture> selectHotList() {
		Connection conn = getConnection();
		ArrayList<Picture> list = pdao.selectHotList(conn);
		close(conn);
		return list;
	}

	// PicturesDao의 selectRecList() 값을 받아서 전달하는 메소드
	public ArrayList<Picture> selectRecList() {
		Connection conn = getConnection();
		ArrayList<Picture> list = pdao.selectRecList(conn);
		close(conn);
		return list;
	}

	// PicturesDao의 selectNewBuyList() 값을 받아서 전달하는 메소드
	public ArrayList<Picture> selectNewBuyList() {
		Connection conn = getConnection();
		ArrayList<Picture> list = pdao.selectNewBuyList(conn);
		close(conn);
		return list;
	}

	// PicturesDao의 selectNewSellList() 값을 받아서 전달하는 메소드
	public ArrayList<Picture> selectNewSellList() {
		Connection conn = getConnection();
		ArrayList<Picture> list = pdao.selectNewSellList(conn);
		close(conn);
		return list;
	}

	// PicturesDao의 selectUpcomingList() 값을 받아서 전달하는 메소드
	public ArrayList<Picture> selectUpcomingList() {
		Connection conn = getConnection();
		ArrayList<Picture> list = pdao.selectUpcomingList(conn);
		close(conn);
		return list;
	}
}
