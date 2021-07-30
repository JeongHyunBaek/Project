package itemPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import itemPage.model.dao.ItemDetailDao;
import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;

public class ItemDetailService {
	private ItemDetailDao iddao = new ItemDetailDao();

	public Item selectOne(int itemNo) {
		//주어진 제품번호로 제품의 내용을 갖고 오는 method
		Connection conn = getConnection();
		Item item = iddao.selectOne(conn, itemNo);
		close(conn);
		return item;
	}

	public ArrayList<Picture> selectPList(String modelNo) {
		// 주어진 모델번호로 이에 맞는 사진 리스트 가져오기
		Connection conn = getConnection();
		ArrayList<Picture> plist = iddao.selectPList(conn, modelNo);
		return plist;
	}

	

}
