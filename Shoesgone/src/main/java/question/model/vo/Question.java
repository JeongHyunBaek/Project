package question.model.vo;

import java.sql.Date;

public class Question implements java.io.Serializable {
	private static final long serialVersionUID = 20L;
	
	private int questionNo;
	private String questionTitle;
	private String questionWriter;
	private java.sql.Date questionDate;
	private String questionContent;
	private int questionReadcount;
	private int questionRef;  //원글은 자기번호, 댓글은 원글번호
	private int questionLevel;  //원글 1, 댓글 2
	private int questionAvailable;

	
	public Question() {}


	public Question(int questionNo, String questionTitle, String questionWriter, Date questionDate,
			String questionContent, int questionReadcount, int questionRef, int questionLevel, int questionAvailable) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionWriter = questionWriter;
		this.questionDate = questionDate;
		this.questionContent = questionContent;
		this.questionReadcount = questionReadcount;
		this.questionRef = questionRef;
		this.questionLevel = questionLevel;
		this.questionAvailable = questionAvailable;
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


	public String getQuestionWriter() {
		return questionWriter;
	}


	public void setQuestionWriter(String questionWriter) {
		this.questionWriter = questionWriter;
	}


	public java.sql.Date getQuestionDate() {
		return questionDate;
	}


	public void setQuestionDate(java.sql.Date questionDate) {
		this.questionDate = questionDate;
	}


	public String getQuestionContent() {
		return questionContent;
	}


	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}


	public int getQuestionReadcount() {
		return questionReadcount;
	}


	public void setQuestionReadcount(int questionReadcount) {
		this.questionReadcount = questionReadcount;
	}


	public int getQuestionRef() {
		return questionRef;
	}


	public void setQuestionRef(int questionRef) {
		this.questionRef = questionRef;
	}


	public int getQuestionLevel() {
		return questionLevel;
	}


	public void setQuestionLevel(int questionLevel) {
		this.questionLevel = questionLevel;
	}


	public int getQuestionAvailable() {
		return questionAvailable;
	}


	public void setQuestionAvailable(int questionAvailable) {
		this.questionAvailable = questionAvailable;
	}


	@Override
	public String toString() {
		return "Question [questionNo=" + questionNo + ", questionTitle=" + questionTitle + ", questionWriter="
				+ questionWriter + ", questionDate=" + questionDate + ", questionContent=" + questionContent
				+ ", questionReadcount=" + questionReadcount + ", questionRef=" + questionRef + ", questionLevel="
				+ questionLevel + ", questionAvailable=" + questionAvailable + "]";
	}
	
	

	
	
}
