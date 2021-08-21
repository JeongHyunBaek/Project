package myboard.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import myboard.model.dao.MyboardDao;
import myboard.model.vo.Myboard;

public class MyboardService {
private MyboardDao mdao = new MyboardDao();
	
	public ArrayList<Myboard> reviewList(int userno, int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Myboard> rlist = mdao.reviewList(conn, userno, startRow, endRow);
		close(conn);
		return rlist;
	}
	
	public int getReviewListCount(int userno) {
		Connection conn = getConnection();
		int rlistCount = mdao.getReviewListCount(conn, userno);
		close(conn);
		return rlistCount;
	}
	
	public ArrayList<Myboard> freeList(int userno, int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Myboard> flist = mdao.freeList(conn, userno, startRow, endRow);
		close(conn);
		return flist;
	}
	
	public int getFreeListCount(int userno) {
		Connection conn = getConnection();
		int flistCount = mdao.getFreeListCount(conn, userno);
		close(conn);
		return flistCount;
	}
	
	public ArrayList<Myboard> qnaList(int userno, int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Myboard> qlist = mdao.qnaList(conn, userno, startRow, endRow);
		close(conn);
		return qlist;
	}
	
	public int getQnaListCount(int userno) {
		Connection conn = getConnection();
		int qlistCount = mdao.getQnaListCount(conn, userno);
		close(conn);
		return qlistCount;
	}
	
	public ArrayList<Myboard> galleryList(int userno, int startRow, int endRow){
		Connection conn = getConnection();
		ArrayList<Myboard> glist = mdao.galleryList(conn, userno, startRow, endRow);
		close(conn);
		return glist;
	}
	
	public int getGalleryListCount(int userno) {
		Connection conn = getConnection();
		int glistCount = mdao.getGalleryListCount(conn, userno);
		close(conn);
		return glistCount;
	}
}
