package categoryPage.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable {
	private static final long serialVersionUID = 19L;
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private java.sql.Date noticeDate;
	private String noticeContent;
	private int noticeavailable;
	private int noticeReadcount;
	
	public Notice() {}

	public Notice(int noticeNo, String noticeTitle, String noticeWriter, Date noticeDate, String noticeContent,
			int noticeavailable, int noticeReadcount) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.noticeavailable = noticeavailable;
		this.noticeReadcount = noticeReadcount;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public java.sql.Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(java.sql.Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeavailable() {
		return noticeavailable;
	}

	public void setNoticeavailable(int noticeavailable) {
		this.noticeavailable = noticeavailable;
	}

	public int getNoticeReadcount() {
		return noticeReadcount;
	}

	public void setNoticeReadcount(int noticeReadcount) {
		this.noticeReadcount = noticeReadcount;
	}

	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeDate=" + noticeDate + ", noticeContent=" + noticeContent + ", noticeavailable="
				+ noticeavailable + ", noticeReadcount=" + noticeReadcount + "]";
	}

	

	
	
}