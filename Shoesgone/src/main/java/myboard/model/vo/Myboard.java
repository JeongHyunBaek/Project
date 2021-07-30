package myboard.model.vo;

import java.sql.Date;

public class Myboard implements java.io.Serializable {
	private static final long serialVersionUID = 25L;
	
	private int textNo;
	private int userNo;
	private String title;
	private String writer;
	private java.sql.Date registDate;
	
	public Myboard() {}

	public Myboard(int textNo, int userNo, String title, String writer, Date registDate) {
		super();
		this.textNo = textNo;
		this.userNo = userNo;
		this.title = title;
		this.writer = writer;
		this.registDate = registDate;
	}

	public int getTextNo() {
		return textNo;
	}

	public void setTextNo(int textNo) {
		this.textNo = textNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public java.sql.Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(java.sql.Date registDate) {
		this.registDate = registDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Myboard [textNo=" + textNo + ", userNo=" + userNo + ", title=" + title + ", writer=" + writer
				+ ", registDate=" + registDate + "]";
	}
	
	
}
