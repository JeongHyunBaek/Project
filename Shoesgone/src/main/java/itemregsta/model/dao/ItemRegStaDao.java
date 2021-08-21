package itemregsta.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import itemregsta.model.vo.ItemRegSta;
import static common.JDBCTemp.close;

public class ItemRegStaDao {
	// Method
	// 등록된 전체 상품 조회용 메소드
	// 페이징 처리 적용(1페이지 당 10개의 제품만)
	public ArrayList<ItemRegSta> selectRegList(Connection conn, int startRow, int endRow){
		ArrayList<ItemRegSta> list = new ArrayList<ItemRegSta>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select * from * ("
					 + "select rownum rnum, item_reg_sta_no, user_no, user_id, item_no, shoes_size, reg_date, price, address "
					 + "from ("
					 + "select * from item_reg_sta order by item_reg_sta_no desc)) "
					 + "where rnum >= ? and rnum <= ?";
		
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ItemRegSta reg = new ItemRegSta();
				
				reg.setRegNo(rs.getInt("item_sta_reg_no"));
				reg.setUserNo(rs.getInt("user_no"));
				reg.setItemNo(rs.getInt("item_no"));
				reg.setSize(rs.getInt("shoes_size"));
				reg.setRegDate(rs.getDate("reg_date"));
				reg.setPrice(rs.getInt("price"));
				reg.setAddress(rs.getString("address"));
				
				list.add(reg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	// 해당 등록 번호의 상품 정보 조회용 메소드
	public ItemRegSta selectOne(Connection conn, int regNo) {
		ItemRegSta reg = new ItemRegSta();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "select * from item_reg_sta where item_reg_sta_no = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, regNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				reg.setRegNo(rs.getInt("item_reg_sta_no"));
				reg.setUserNo(rs.getInt("user_no"));
				reg.setItemNo(rs.getInt("item_no"));
				reg.setSize(rs.getInt("shoes_size"));
				reg.setRegDate(rs.getDate("reg_date"));
				reg.setPrice(rs.getInt("price"));
				reg.setAddress(rs.getString("address"));
				reg.setPenalty(rs.getString("penalty"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return reg;
	}
	
	// 해당 상품번호의 판매등록 제품 출력용 메소드
		public ArrayList<ItemRegSta> selectedRegList(Connection conn, int itemNo, int size) {
			ArrayList<ItemRegSta> list = new ArrayList<ItemRegSta>();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String query = "select * from item_reg_sta where item_no = ? and shoes_size = ? order by reg_date desc";
			
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
					
					list.add(reg);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(ps);
			}
			
			return list;
		}
	
	// 새 즉시 판매 상품 등록용 메소드
	public int insertReg(Connection conn, ItemRegSta reg) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "insert into item_reg_sta values (ITEM_REG_STA_SEQ.NEXTVAL, ?, ?, ?, sysdate, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, reg.getUserNo());
			ps.setInt(2, reg.getItemNo());
			ps.setInt(3, reg.getSize());
			ps.setInt(4, reg.getPrice());
			ps.setString(5, reg.getPenalty());
			ps.setString(6, reg.getAddress());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	// 상품 등록 삭제용(판매완료후) 메소드
	public int deleteReg(Connection conn, int regNo) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "delete from item_reg_sta where item_reg_sta_no = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, regNo);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	// 등록 상품 수정 메소드
	public int updateReg(Connection conn, ItemRegSta upReg) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "update item_reg_sta set shoes_size = ?, "
						+ "reg_date = sysdate, price = ?, "
						+ "where item_reg_sta_no = ?";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, upReg.getSize());
			ps.setInt(2, upReg.getPrice());
			ps.setInt(3, upReg.getRegNo());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	// 등록된 상품 총 갯수 출력용 메소드
	public int getRegListCount(Connection conn) {
		int regListCount = 0;
		Statement stm = null;
		ResultSet rs = null;
		
		String query = "select count(*) from item_reg_sta";
		
		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(query);
			
			if(rs.next()) {
				regListCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stm);
		}
		
		return regListCount;
	}

	// 새 즉시 판매 상품 등록용 메소드
	public int insertRegTen(Connection conn, ItemRegSta reg) {
		int result = 0;
		PreparedStatement ps = null;
		
		String query = "insert into sell_bid values (ITEM_REG_STA_SEQ.NEXTVAL, ?, ?, ?, sysdate, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, reg.getUserNo());
			ps.setInt(2, reg.getItemNo());
			ps.setInt(3, reg.getSize());
			ps.setInt(4, reg.getPrice());
			ps.setString(5, reg.getPenalty());
			ps.setString(6, reg.getAddress());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
}
