package categoryPage.model.vo;

import java.sql.Date;

public class QnA implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int QnANo;  //게시글번호
	private int QnAWriter; //게시글 작성자 아이디
	private String QnATitle;  //게시글 제목
	private String QnAContent;  //게시글 내용
	private String QnAOriginalFilename;  //첨부파일 원래이름
	private String QnARenameFilename;  //변경된 첨부파일이름
	private int QnAReadCount; //읽은 조회수
	private java.sql.Date QnADate;  //게시글 등록 날짜
	private int QnALike; //추천수
	private int QnAUnlike;
	
	public QnA() {}

	public QnA(int QnAWriter, String QnATitle, String QnAContent) {
		super();
		this.QnAWriter = QnAWriter;
		this.QnATitle = QnATitle;
		this.QnAContent = QnAContent;
	}

	public QnA(int QnAWriter, String QnATitle, 
			String QnAContent, String QnAOriginalFilename,
			String QnARenameFilename) {
		super();
		this.QnAWriter = QnAWriter;
		this.QnATitle = QnATitle;
		this.QnAContent = QnAContent;
		this.QnAOriginalFilename = QnAOriginalFilename;
		this.QnARenameFilename = QnARenameFilename;
	}

	public QnA(int qnANo, int qnAWriter, String qnATitle, String qnAContent, String qnAOriginalFilename,
			String qnARenameFilename, int qnAReadCount, Date qnADate, int qnALike, int qnAUnlike) {
		super();
		this.QnANo = qnANo;
		this.QnAWriter = qnAWriter;
		this.QnATitle = qnATitle;
		this.QnAContent = qnAContent;
		this.QnAOriginalFilename = qnAOriginalFilename;
		this.QnARenameFilename = qnARenameFilename;
		this.QnAReadCount = qnAReadCount;
		this.QnADate = qnADate;
		this.QnALike = qnALike;
		this.QnAUnlike = qnAUnlike;
	}

	public int getQnANo() {
		return QnANo;
	}

	public void setQnANo(int qnANo) {
		QnANo = qnANo;
	}

	public int getQnAWriter() {
		return QnAWriter;
	}

	public void setQnAWriter(int qnAWriter) {
		QnAWriter = qnAWriter;
	}

	public String getQnATitle() {
		return QnATitle;
	}

	public void setQnATitle(String qnATitle) {
		QnATitle = qnATitle;
	}

	public String getQnAContent() {
		return QnAContent;
	}

	public void setQnAContent(String qnAContent) {
		QnAContent = qnAContent;
	}

	public String getQnAOriginalFilename() {
		return QnAOriginalFilename;
	}

	public void setQnAOriginalFilename(String qnAOriginalFilename) {
		QnAOriginalFilename = qnAOriginalFilename;
	}

	public String getQnARenameFilename() {
		return QnARenameFilename;
	}

	public void setQnARenameFilename(String qnARenameFilename) {
		QnARenameFilename = qnARenameFilename;
	}

	public int getQnAReadCount() {
		return QnAReadCount;
	}

	public void setQnAReadCount(int qnAReadCount) {
		QnAReadCount = qnAReadCount;
	}

	public java.sql.Date getQnADate() {
		return QnADate;
	}

	public void setQnADate(java.sql.Date qnADate) {
		QnADate = qnADate;
	}

	public int getQnALike() {
		return QnALike;
	}

	public void setQnALike(int qnALike) {
		QnALike = qnALike;
	}

	public int getQnAUnlike() {
		return QnAUnlike;
	}

	public void setQnAUnlike(int qnAUnlike) {
		QnAUnlike = qnAUnlike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Qna [QnANo=" + QnANo + ", QnAWriter=" + QnAWriter + ", QnATitle=" + QnATitle + ", QnAContent="
				+ QnAContent + ", QnAOriginalFilename=" + QnAOriginalFilename + ", QnARenameFilename="
				+ QnARenameFilename + ", QnAReadCount=" + QnAReadCount + ", QnADate=" + QnADate + ", QnALike=" + QnALike
				+ ", QnAUnlike=" + QnAUnlike + "]";
	}
}
