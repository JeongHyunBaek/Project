package faq.model.vo;

import java.sql.Date;

public class Faq implements java.io.Serializable {
	private static final long serialVersionUID = 21L;
	
	private int faqNo;
	private String faqTitle;
	private java.sql.Date faqDate;
	private String faqWriter;
	private String faqContent;
	private int faqViews;
	
	public Faq() {}

	public Faq(int faqNo, String faqTitle, Date faqDate, String faqWriter, String faqContent, int faqViews) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqDate = faqDate;
		this.faqWriter = faqWriter;
		this.faqContent = faqContent;
		this.faqViews = faqViews;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqTitle() {
		return faqTitle;
	}

	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}

	public java.sql.Date getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(java.sql.Date faqDate) {
		this.faqDate = faqDate;
	}

	public String getFaqWriter() {
		return faqWriter;
	}

	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public int getFaqViews() {
		return faqViews;
	}

	public void setFaqViews(int faqViews) {
		this.faqViews = faqViews;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqDate=" + faqDate + ", faqWriter=" + faqWriter
				+ ", faqContent=" + faqContent + ", faqViews=" + faqViews + "]";
	}
	
	
	

}
