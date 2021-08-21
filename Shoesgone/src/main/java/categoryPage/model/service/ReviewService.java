package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.ReviewDao;
import categoryPage.model.vo.Review;

public class ReviewService {
	private ReviewDao rdao = new ReviewDao();

	public ArrayList<Review> selectReviewList() {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectReviewList(conn);
		close(conn);
		return list;
	}
}
