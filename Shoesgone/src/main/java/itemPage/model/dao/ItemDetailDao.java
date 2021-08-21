package itemPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import community.review.model.vo.Review;
import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;
import itemregsta.model.vo.ItemRegSta;
import orders.model.vo.Orders;
import orders.model.vo.SalesList;

public class ItemDetailDao {
	
	public ArrayList<Item> selectList(Connection conn) {
		ArrayList<Item> ilist = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM ITEM";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Item item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("ITEM_ENG_NAME"));
				item.setItemKrName(rset.getString("ITEM_KR_NAME"));
				item.setBrand(rset.getString("ITEM_BRAND"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
				ilist.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return ilist;
	}
	
	public Item selectOne(Connection conn, int itemNo) {
		// 제품 하나의 정보를 전달하는 메소드
		Item item = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from item where item_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				item = new Item();
				
				item.setItemNo(rset.getInt("item_no"));
				item.setItemEngName(rset.getString("ITEM_ENG_NAME"));
				item.setItemKrName(rset.getString("ITEM_KR_NAME"));
				item.setBrand(rset.getString("ITEM_BRAND"));
				item.setModelNo(rset.getString("item_modelno"));
				item.setShoesColors(rset.getString("item_colors"));
				item.setPrice(rset.getInt("item_price"));
				item.setRegDate(rset.getDate("item_reg_date"));
				item.setDropDate(rset.getDate("item_drop_date"));
				item.setShoesSizes(rset.getString("item_sizes"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return item;
	}

	public ArrayList<Picture> selectPList(Connection conn, int itemNo) {
		// 모델번호로 사진들 가져오기
		ArrayList<Picture> plist = new ArrayList<Picture>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from pictures where pictures_itemno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Picture picture = new Picture();
				
				picture.setPictureno(rset.getInt("pictures_no"));
				picture.setModelno(rset.getInt("pictures_itemno"));
				picture.setPicturepath(rset.getString("pictures_path"));
				plist.add(picture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return plist;
	}

	public ArrayList<SalesList> selectOrderList(Connection conn, int itemNo, int size, int days) {
		ArrayList<SalesList> olist = new ArrayList<SalesList>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "";
		if(size == 0) {
			if(days==1) {
				query = "SELECT TO_CHAR(PUR_DATE, 'YYYY-MM-DD') as DATES, AVG(PRICE) as PRICE "
						+ "FROM ORDERS "
						+ "WHERE ITEM_NO = ? "
						+ "GROUP BY TO_CHAR(PUR_DATE, 'YYYY-MM-DD') "
						+ "ORDER BY 1";
			} else if (days==7) {
				query = "SELECT TO_CHAR(PUR_DATE, 'YYYY-MM-W') as DATES, AVG(PRICE) as PRICE "
						+ "FROM ORDERS "
						+ "WHERE ITEM_NO = ? "
						+ "GROUP BY TO_CHAR(PUR_DATE, 'YYYY-MM-W') "
						+ "ORDER BY 1";
			} else {
				query = "SELECT TO_CHAR(PUR_DATE, 'YYYY-MM') as DATES, AVG(PRICE) as PRICE "
						+ "FROM ORDERS "
						+ "WHERE ITEM_NO = ? "
						+ "GROUP BY TO_CHAR(PUR_DATE, 'YYYY-MM') "
						+ "ORDER BY 1";
			}
		} else {
			if(days==1) {
				query = "SELECT TO_CHAR(PUR_DATE, 'YYYY-MM-DD') as DATES, AVG(PRICE) as PRICE "
						+ "FROM ORDERS "
						+ "WHERE ITEM_NO = ? AND SHOES_SIZE = " + Integer.toString(size)
						+ " GROUP BY TO_CHAR(PUR_DATE, 'YYYY-MM-DD') "
						+ "ORDER BY 1";
			} else if (days==7) {
				query = "SELECT TO_CHAR(PUR_DATE, 'YYYY-MM-W') as DATES, AVG(PRICE) as PRICE "
						+ "FROM ORDERS "
						+ "WHERE ITEM_NO = ? AND SHOES_SIZE = " + Integer.toString(size)
						+ "GROUP BY TO_CHAR(PUR_DATE, 'YYYY-MM-W') "
						+ "ORDER BY 1";
			} else {
				query = "SELECT TO_CHAR(PUR_DATE, 'YYYY-MM') as DATES, AVG(PRICE) as PRICE "
						+ "FROM ORDERS "
						+ "WHERE ITEM_NO = ? AND SHOES_SIZE = " + Integer.toString(size)
						+ "GROUP BY TO_CHAR(PUR_DATE, 'YYYY-MM') "
						+ "ORDER BY 1";
			}
		}
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SalesList sales = new SalesList();
				
				sales.setDate(rset.getString("DATES"));
				sales.setPrice(rset.getDouble("PRICE"));
				olist.add(sales);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return olist;
	}

	public ArrayList<Review> selectReviewList(Connection conn, int itemNo) {
		// 모델번호로 사진들 가져오기
		ArrayList<Review> rlist = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM REVIEW WHERE REVIEW_ITEMNO = ? ORDER BY REVIEW_READCOUNT DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review review = new Review();
				
				review.setReviewNo(rset.getInt("REVIEW_NO"));
				review.setReviewTitle(rset.getString("REVIEW_TITLE"));
				review.setReviewWriter(rset.getInt("REVIEW_WRITER"));
				review.setReviewContent(rset.getString("REVIEW_CONTENT"));
				review.setReviewItemNo(rset.getInt("REVIEW_ITEMNO"));
				review.setReviewStar(rset.getInt("REVIEW_STAR"));
				review.setReviewLike(rset.getInt("REVIEW_LIKE"));
				review.setReviewReadCount(rset.getInt("REVIEW_READCOUNT"));
				rlist.add(review);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rlist;
	}

	public ArrayList<Picture> selectRPList(Connection conn, int itemNo, String brand) {
		// 모델번호로 사진들 가져오기
		ArrayList<Picture> rplist = new ArrayList<Picture>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "SELECT PICTURES_NO, PICTURES_ITEMNO, PICTURES_PATH "
				+ "FROM (SELECT PICTURES_NO, PICTURES_ITEMNO, PICTURES_PATH, ITEM_BRAND "
			            + "FROM PICTURES P, ITEM I "
			            + "WHERE P.PICTURES_ITEMNO = I.ITEM_NO) "
			    + "WHERE PICTURES_ITEMNO != ? AND ITEM_BRAND = ? AND PICTURES_PATH LIKE '%0.png'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			pstmt.setString(2, brand);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Picture picture = new Picture();
				
				picture.setPictureno(rset.getInt("PICTURES_NO"));
				picture.setModelno(rset.getInt("PICTURES_ITEMNO"));
				picture.setPicturepath(rset.getString("PICTURES_PATH"));
				rplist.add(picture);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rplist;
	}

	public int updateItem(Connection conn, Item item) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "UPDATE ITEM SET "
				+ "ITEM_ENG_NAME = ?, "
				+ "ITEM_KR_NAME = ?, "
				+ "ITEM_BRAND = ?, "
				+ "ITEM_MODELNO = ?, "
				+ "ITEM_COLORS = ?, "
				+ "ITEM_PRICE = ?, "
				+ "ITEM_REG_DATE = SYSDATE, "
				+ "ITEM_DROP_DATE = ?, "
				+ "ITEM_SIZES = ? "
				+ "WHERE ITEM_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, item.getItemEngName());
			pstmt.setString(2, item.getItemKrName());
			pstmt.setString(3, item.getBrand());
			pstmt.setString(4, item.getModelNo());
			pstmt.setString(5, item.getShoesColors());
			pstmt.setInt(6, item.getPrice());
			pstmt.setDate(7, item.getDropDate());
			pstmt.setString(8, item.getShoesSizes());
			pstmt.setInt(9, item.getItemNo());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectCheckModelno(Connection conn, String modelno) {
		int modelCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(item_modelno) from item "
				+ "where item_modelno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, modelno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				modelCount = rset.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return modelCount;
	}

	public int insertItem(Connection conn, Item item) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO ITEM VALUES("
				+ "(SELECT MAX(ITEM_NO)+1 FROM ITEM), "
				+ "?, ?, ?, ?, ?, ?, "
				+ "SYSDATE, "
				+ "?, ?, default)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, item.getItemEngName());
			pstmt.setString(2, item.getItemKrName());
			pstmt.setString(3, item.getBrand());
			pstmt.setString(4, item.getModelNo());
			pstmt.setString(5, item.getShoesColors());
			pstmt.setInt(6, item.getPrice());
			pstmt.setDate(7, item.getDropDate());
			pstmt.setString(8, item.getShoesSizes());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertPicture(Connection conn, Picture picture) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "INSERT INTO PICTURES VALUES("
				+ "(SELECT MAX(PICTURES_NO)+1 FROM PICTURES), "
				+ "(SELECT MAX(ITEM_NO) FROM ITEM), "
				+ "?)";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, picture.getPicturepath());
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deletePhoto(Connection conn, int itemNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "DELETE FROM PICTURES "
				+ "WHERE PICTURES_ITEMNO = ?";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteItem(Connection conn, int itemNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "DELETE FROM ITEM "
				+ "WHERE ITEM_NO = ?";		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
						
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReadCount(Connection conn, int itemNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update item set "
				+ "item_views = item_views + 1 "
				+ "where item_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, itemNo);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	// 해당 정보에 맞는 판매등록상품 출력용 메소드
	public ArrayList<ItemRegSta> selectRegList(Connection conn, int itemNo, int size) {
		ArrayList<ItemRegSta> regList = new ArrayList<ItemRegSta>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select * from item_reg_sta where item_no = ? and shoes_size = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, itemNo);
			ps.setInt(2, size);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ItemRegSta reg = new ItemRegSta();
				
				reg.setRegNo(rs.getInt("item_reg_sta_no"));
				reg.setUserNo(rs.getInt("user_no"));
				reg.setItemNo(rs.getInt("item_no"));
				reg.setSize(rs.getInt("shoes_size"));
				reg.setRegDate(rs.getDate("reg_date"));
				reg.setPrice(rs.getInt("price"));
				reg.setPenalty(rs.getString("penalty"));
				reg.setAddress(rs.getString("address"));
				
				regList.add(reg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return regList;
	}

	public ArrayList<Orders> selectOrders(Connection conn, int itemNo) {
	      ArrayList<Orders> olist = new ArrayList<Orders>();
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String query = "SELECT * FROM ORDERS WHERE ITEM_NO = ? ORDER BY PUR_DATE DESC";
	      
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setInt(1, itemNo);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            Orders order = new Orders();
	            
	            order.setOrdersNo(rset.getInt("ORDERS_NO"));
	            order.setSize(rset.getInt("SHOES_SIZE"));
	            order.setPrice(rset.getInt("PRICE"));
	            order.setPurDate(rset.getDate("PUR_DATE"));
	            
	            olist.add(order);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return olist;
	   }
}
