package categoryPage.model.vo;

import java.sql.Date;

public class Faq implements java.io.Serializable {
	private static final long serialVersionUID = 21L;
	
	private int faqNo;
	private String faqTitle;
	private String faqWriter;
	private java.sql.Date faqDate;
	private String faqContent;
	private int faqReadcount;
	private int faqavailable;
	
	public Faq() {}

	public Faq(int faqNo, String faqTitle, String faqWriter, Date faqDate, String faqContent, int faqReadcount,
			int faqavailable) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqWriter = faqWriter;
		this.faqDate = faqDate;
		this.faqContent = faqContent;
		this.faqReadcount = faqReadcount;
		this.faqavailable = faqavailable;
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

	public String getFaqWriter() {
		return faqWriter;
	}

	public void setFaqWriter(String faqWriter) {
		this.faqWriter = faqWriter;
	}

	public java.sql.Date getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(java.sql.Date faqDate) {
		this.faqDate = faqDate;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}

	public int getFaqReadcount() {
		return faqReadcount;
	}

	public void setFaqReadcount(int faqReadcount) {
		this.faqReadcount = faqReadcount;
	}

	public int getFaqavailable() {
		return faqavailable;
	}

	public void setFaqavailable(int faqavailable) {
		this.faqavailable = faqavailable;
	}

	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqWriter=" + faqWriter + ", faqDate=" + faqDate
				+ ", faqContent=" + faqContent + ", faqReadcount=" + faqReadcount + ", faqavailable=" + faqavailable
				+ "]";
	}

	
	
	
	

}
