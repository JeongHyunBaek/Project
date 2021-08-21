package community.qna.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class QnA implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int QnANo;  //게시글번호
	private int QnAWriter; //게시글 작성자 아이디
	private String QnATitle;  //게시글 제목
	private String QnAContent;  //게시글 내용
	private String QnAOriginalFilename;  //첨부파일 원래이름
	private String QnARenameFilename;  //변경된 첨부파일이름
	private int QnAReadCount; //읽은 조회수
	private String QnADate;  //게시글 등록 날짜
	private int QnALike; //추천수
	
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

	public QnA(int QnANo, int QnAWriter, String QnATitle, String QnAContent, String QnAOriginalFilename,
			String QnARenameFilename, int QnAReadCount, String QnADate, int QnALike) {
		super();
		this.QnANo = QnANo;
		this.QnAWriter = QnAWriter;
		this.QnATitle = QnATitle;
		this.QnAContent = QnAContent;
		this.QnAOriginalFilename = QnAOriginalFilename;
		this.QnARenameFilename = QnARenameFilename;
		this.QnAReadCount = QnAReadCount;
		this.QnADate = QnADate;
		this.QnALike = QnALike;
	}

	public int getQnANo() {
		return QnANo;
	}

	public void setQnANo(int QnANo) {
		this.QnANo = QnANo;
	}

	public int getQnAWriter() {
		return QnAWriter;
	}

	public void setQnAWriter(int QnAWriter) {
		this.QnAWriter = QnAWriter;
	}

	public String getQnATitle() {
		return QnATitle;
	}

	public void setQnATitle(String QnATitle) {
		this.QnATitle = QnATitle;
	}

	public String getQnAContent() {
		return QnAContent;
	}

	public void setQnAContent(String QnAContent) {
		this.QnAContent = QnAContent;
	}

	public String getQnAOriginalFilename() {
		return QnAOriginalFilename;
	}

	public void setQnAOriginalFilename(String QnAOriginalFilename) {
		this.QnAOriginalFilename = QnAOriginalFilename;
	}

	public String getQnARenameFilename() {
		return QnARenameFilename;
	}

	public void setQnARenameFilename(String QnARenameFilename) {
		this.QnARenameFilename = QnARenameFilename;
	}


	public int getQnAReadCount() {
		return QnAReadCount;
	}

	public void setQnAReadCount(int QnAReadCount) {
		this.QnAReadCount = QnAReadCount;
	}

	public String getQnADate() {
		return QnADate;
	}

	public void setQnADate(String QnADate) {
		this.QnADate = QnADate;
	}
	public int getQnALike() {
		return QnALike;
	}

	public void setQnALike(int QnALike) {
		this.QnALike = QnALike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "QnA [QnANo=" + QnANo + ", QnAWriter=" + QnAWriter + ", QnATitle=" + QnATitle
				+ ", QnAContent=" + QnAContent + ", QnAOriginalFilename=" + QnAOriginalFilename
				+ ", QnARenameFilename=" + QnARenameFilename + ", QnAReadCount=" + QnAReadCount 
				+ ", QnADate=" + QnADate + ", QnALike=" + QnALike + "]";
	}

	

}

