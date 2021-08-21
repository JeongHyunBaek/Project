package community.review.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.review.model.dao.ReviewDao;
import community.review.model.vo.Review;

public class ReviewService {
	private ReviewDao rdao = new ReviewDao();
	
	public ArrayList<Review> selectTop3(){
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectTop3(conn);
		close(conn);
		return list;
	}
	public Review selectReview(int ReviewNo) {
		Connection conn = getConnection();
		Review Review = rdao.selectReview(conn, ReviewNo);
		close(conn);
		return Review;
	}
	
	public void addReadCount(int ReviewNo) {
		Connection conn = getConnection();
		int result = rdao.updateReadCount(conn, ReviewNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = rdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Review> selectList(int startRow, int endRow, String orderBy) {
		Connection conn = getConnection();
		ArrayList<Review> list = rdao.selectList(conn, startRow, endRow, orderBy);
		close(conn);
		return list;
	}

	public int insertOriginReview(Review Review) {
		Connection conn = getConnection();
		int result = rdao.insertOriginReview(conn, Review);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateOrigin(Review Review) {
		Connection conn = getConnection();
		int result = rdao.updateOrigin(conn, Review);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReply(Review Review) {
		Connection conn = getConnection();
		int result = rdao.updateReply(conn, Review);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	public int deleteReview(int ReviewNo) {
		Connection conn = getConnection();
		int result = rdao.deleteReview(conn, ReviewNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
