package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.GalleryDao;
import categoryPage.model.vo.Gallery;

public class GalleryService {
	private GalleryDao gdao = new GalleryDao();

	public ArrayList<Gallery> selectGalleryList() {
		Connection conn = getConnection();
		ArrayList<Gallery> list = gdao.selectGalleryList(conn);
		close(conn);
		return list;
	}
}
