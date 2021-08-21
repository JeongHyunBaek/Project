package point.model.vo;

import java.sql.Date;

public class Point implements java.io.Serializable {
	private static final long serialVersionUID = 24L;
	
	private int userNo;
	private int orderNo;
	private java.sql.Date registDate;
	private int point;
	private String history;
	
	public Point() {}

	public Point(int userNo, int orderNo, Date registDate, int point, String history) {
		super();
		this.userNo = userNo;
		this.orderNo = orderNo;
		this.registDate = registDate;
		this.point = point;
		this.history = history;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public java.sql.Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(java.sql.Date registDate) {
		this.registDate = registDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "Point [userNo=" + userNo + ", orderNo=" + orderNo + ", registDate=" + registDate + ", point=" + point
				+ ", history=" + history + "]";
	}

	
	
	
	
}