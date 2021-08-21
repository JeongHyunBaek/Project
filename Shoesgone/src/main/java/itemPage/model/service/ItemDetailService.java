package itemPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.commit;
import static common.JDBCTemp.getConnection;
import static common.JDBCTemp.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import community.review.model.vo.Review;
import itemPage.model.dao.ItemDetailDao;
import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;
import itemregsta.model.vo.ItemRegSta;
import orders.model.vo.Orders;
import orders.model.vo.SalesList;

public class ItemDetailService {
	private ItemDetailDao iddao = new ItemDetailDao();
	
	public ArrayList<Item> selectList() {
		Connection conn = getConnection();
		ArrayList<Item> ilist = iddao.selectList(conn);
		return ilist;
	}
	
	public Item selectOne(int itemNo) {
		//주어진 제품번호로 제품의 내용을 갖고 오는 method
		Connection conn = getConnection();
		Item item = iddao.selectOne(conn, itemNo);
		close(conn);
		return item;
	}

	public ArrayList<Picture> selectPList(int itemNo) {
		// 주어진 모델번호로 이에 맞는 사진 리스트 가져오기
		Connection conn = getConnection();
		ArrayList<Picture> plist = iddao.selectPList(conn, itemNo);
		return plist;
	}

	public ArrayList<SalesList> selectOrderList(int itemNo, int size, int days) {
		// 주어진 정보로 맞는 정보 가져오기
		Connection conn = getConnection();
		ArrayList<SalesList> orderlist = iddao.selectOrderList(conn, itemNo, size, days);
		return orderlist;
	}

	public ArrayList<Review> selectRlist(int itemNo) {
		Connection conn = getConnection();
		ArrayList<Review> reviewlist = iddao.selectReviewList(conn, itemNo);
		return reviewlist;
	}

	public ArrayList<Picture> selectRPList(int itemNo, String brand) {
		Connection conn = getConnection();
		ArrayList<Picture> rplist = iddao.selectRPList(conn, itemNo, brand);
		return rplist;
	}

	public int updateItem(Item item) {
		Connection conn = getConnection();
		int result = iddao.updateItem(conn, item);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int selectCheckModelno(String modelno) {
		Connection conn = getConnection();
		int count = iddao.selectCheckModelno(conn, modelno);
		close(conn);
		return count;
	}

	public int insertItem(Item item) {
		Connection conn = getConnection();
		int count = iddao.insertItem(conn, item);
		close(conn);
		return count;
	}

	public int insertPicture(Picture picture) {
		Connection conn = getConnection();
		int count = iddao.insertPicture(conn, picture);
		close(conn);
		return count;
	}

	public int deletePhoto(int itemNo) {
		Connection conn = getConnection();
		int count = iddao.deletePhoto(conn, itemNo);
		close(conn);
		return count;
	}

	public int deleteItem(int itemNo) {
		Connection conn = getConnection();
		int count = iddao.deleteItem(conn, itemNo);
		close(conn);
		return count;
	}

	public void addReadCount(int itemNo) {
		Connection conn = getConnection();
		int result = iddao.updateReadCount(conn, itemNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	// 해당 정보에 맞는 판매등록상품 출력용 메소드
	public ArrayList<ItemRegSta> selectRegList(int itemNo, int size) {
		Connection conn = getConnection();
		ArrayList<ItemRegSta> regList = iddao.selectRegList(conn, itemNo, size);
		close(conn);
		
		return regList;
	}

	public ArrayList<Orders> selectOrders(int itemNo) {
	      Connection conn = getConnection();
	      ArrayList<Orders> olist = iddao.selectOrders(conn, itemNo);
	      return olist;
	   }
}
