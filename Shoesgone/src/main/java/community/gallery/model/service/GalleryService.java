package community.gallery.model.service;

import static common.JDBCTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

import community.gallery.model.dao.GalleryDao;
import community.gallery.model.vo.Gallery;

public class GalleryService {
	private GalleryDao gdao = new GalleryDao();
	
	public ArrayList<Gallery> selectTop3(){
		Connection conn = getConnection();
		ArrayList<Gallery> list = gdao.selectTop3(conn);
		close(conn);
		return list;
	}
	public Gallery selectGallery(int GalleryNo) {
		Connection conn = getConnection();
		Gallery Gallery = gdao.selectGallery(conn, GalleryNo);
		close(conn);
		return Gallery;
	}
	
	public void addReadCount(int GalleryNo) {
		Connection conn = getConnection();
		int result = gdao.updateReadCount(conn, GalleryNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = gdao.getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Gallery> selectList(int startRow, int endRow, String orderBy) {
		Connection conn = getConnection();
		ArrayList<Gallery> list = gdao.selectList(conn, startRow, endRow, orderBy);
		close(conn);
		return list;
	}

	public int insertOriginGallery(Gallery Gallery) {
		Connection conn = getConnection();
		int result = gdao.insertOriginGallery(conn, Gallery);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int updateOrigin(Gallery Gallery) {
		Connection conn = getConnection();
		int result = gdao.updateOrigin(conn, Gallery);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int updateReply(Gallery Gallery) {
		Connection conn = getConnection();
		int result = gdao.updateReply(conn, Gallery);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
	public int deleteGallery(int GalleryNo) {
		Connection conn = getConnection();
		int result = gdao.deleteGallery(conn, GalleryNo);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
