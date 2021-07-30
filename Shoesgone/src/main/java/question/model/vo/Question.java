package question.model.vo;

import java.sql.Date;

public class Question implements java.io.Serializable {
	private static final long serialVersionUID = 20L;
	
	private int questionNo;
	private String questionTitle;
	private java.sql.Date questionDate;
	private String questionWriter;
	private String questionContent;
	private int questionViews;
	private String questionReplyContents;
	
	
	public Question() {}
	
	public Question(int questionNo, String questionTitle, Date questionDate, String questionWriter,
			String questionContent, int questionViews, String questionReplyContents) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionDate = questionDate;
		this.questionWriter = questionWriter;
		this.questionContent = questionContent;
		this.questionViews = questionViews;
		this.questionReplyContents = questionReplyContents;
	}

	public int getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public java.sql.Date getQuestionDate() {
		return questionDate;
	}

	public void setQuestionDate(java.sql.Date questionDate) {
		this.questionDate = questionDate;
	}

	public String getQuestionWriter() {
		return questionWriter;
	}

	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public int getQuestionViews() {
		return questionViews;
	}

	public void setQuestionViews(int questionViews) {
		this.questionViews = questionViews;
	}

	public String getQuestionReplyContents() {
		return questionReplyContents;
	}

	public void setQuestionReplyContents(String questionReplyContents) {
		this.questionReplyContents = questionReplyContents;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionDate="
				+ questionDate + ", questionWriter=" + questionWriter + ", questionContent=" + questionContent
				+ ", questionViews=" + questionViews + ", questionReplyContents=" + questionReplyContents + "]";
	}
	
	
	
}
