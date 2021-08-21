package categoryPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import categoryPage.model.vo.Review;

public class ReviewDao {

	public ArrayList<Review> selectReviewList(Connection conn) {
		ArrayList<Review> list = new ArrayList<Review>();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * "
				+ "from review";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				Review review = new Review();
				
				review.setReviewNo(rset.getInt("review_no"));
				review.setReviewTitle(rset.getString("review_title"));
				review.setReviewWriter(rset.getInt("review_writer"));
				review.setReviewDate(rset.getDate("review_date"));
				review.setReviewContent(rset.getString("review_content"));
				review.setReviewOriginalFilename(rset.getString("review_original_filename"));
				review.setReviewRenameFilename(rset.getString("review_rename_filename"));
				review.setReviewItemNo(rset.getInt("review_itemno"));
				review.setReviewStar(rset.getInt("review_star"));
				review.setReviewLike(rset.getInt("review_like"));
				review.setReviewUnlike(rset.getInt("review_unlike"));
				review.setReviewReadCount(rset.getInt("review_readcount"));
				
				list.add(review);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
}
