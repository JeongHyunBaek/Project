package itemPage.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import itemPage.model.vo.Item;
import itemPage.model.vo.Picture;

public class ItemDetailDao {

	public Item selectOne(Connection conn, int itemNo) {
		// 제품 하나의 정보를 전달하는 메소드
		Item item = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from items where item_no = ?";
		
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

	public ArrayList<Picture> selectPList(Connection conn, String modelNo) {
		// 모델번호로 사진들 가져오기
		ArrayList<Picture> plist = new ArrayList<Picture>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println(modelNo);
		
		String query = "select * from pictures where modelno = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "DD1391-101");
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Picture picture = new Picture();
				
				picture.setPictureno(rset.getInt("pictures_no"));
				picture.setModelno(rset.getString("modelno"));
				picture.setPicturepath(rset.getString("pictures_path"));
				System.out.println(picture.getPicturepath());
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

}
