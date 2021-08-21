package categoryPage.model.service;

import static common.JDBCTemp.close;
import static common.JDBCTemp.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import categoryPage.model.dao.FreeDao;
import categoryPage.model.vo.Free;

public class FreeService {
	private FreeDao fdao = new FreeDao();

	public ArrayList<Free> selectFreeList() {
		Connection conn = getConnection();
		ArrayList<Free> list = fdao.selectFreeList(conn);
		close(conn);
		return list;
	}
}
