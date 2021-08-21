package itemregsta.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import itemregsta.model.dao.ItemRegStaDao;
import itemregsta.model.vo.ItemRegSta;

public class ItemRegStaService {
	// DI
	private ItemRegStaDao regdao = new ItemRegStaDao();
	
	// Method
	// 등록된 전체 상품 조회용 메소드
	public ArrayList<ItemRegSta> selectRegList(int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<ItemRegSta> list = regdao.selectRegList(conn, startRow, endRow);
		close(conn);
		
		return list;
	}

	// 해당 등록 번호의 상품 정보 조회용 메소드
	public ItemRegSta selectOne(int regNo) {
		Connection conn = getConnection();
		ItemRegSta reg = regdao.selectOne(conn, regNo);
		close(conn);
		
		return reg;
	}
	
	// 상품 번호에 해당하는 판매등록 제품 출력용 메소드
	public ArrayList<ItemRegSta> selectedRegList(int itemNo, int size) {
		Connection conn = getConnection();
		ArrayList<ItemRegSta> list = regdao.selectedRegList(conn, itemNo, size);
		close(conn);
		
		return list;
	}

	// 새 즉시 판매 상품 등록용 메소드
	public int insertReg(ItemRegSta reg) {
		Connection conn = getConnection();
		int result = regdao.insertReg(conn, reg);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 상품 등록 삭제용 메소드
	public int deleteReg(int regNo) {
		Connection conn = getConnection();
		int result = regdao.deleteReg(conn, regNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 등록 상품 수정 메소드
	public int updateReg(ItemRegSta upReg) {
		Connection conn = getConnection();
		int result = regdao.updateReg(conn, upReg);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	// 등록된 상품 총 갯수 출력용 메소드
	public int getRegListCount() {
		Connection conn = getConnection();
		int regListCount = regdao.getRegListCount(conn);
		close(conn);
		
		return regListCount;
	}

	// 새 입찰 판매 상품 등록용 메소드
	public int insertRegTen(ItemRegSta reg) {
		Connection conn = getConnection();
		int result = regdao.insertRegTen(conn, reg);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
}
