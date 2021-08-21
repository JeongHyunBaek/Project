package community.free.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Free implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int FreeNo;  //게시글번호
	private int FreeWriter; //게시글 작성자 아이디
	private String FreeTitle;  //게시글 제목
	private String FreeContent;  //게시글 내용
	private String FreeOriginalFilename;  //첨부파일 원래이름
	private String FreeRenameFilename;  //변경된 첨부파일이름
	private int FreeReadCount; //읽은 조회수
	private String FreeDate;  //게시글 등록 날짜
	private int FreeLike; //추천수
	
	public Free() {}

	public Free(int FreeWriter, String FreeTitle, String FreeContent) {
		super();
		this.FreeWriter = FreeWriter;
		this.FreeTitle = FreeTitle;
		this.FreeContent = FreeContent;
	}

	public Free(int FreeWriter, String FreeTitle, 
			String FreeContent, String FreeOriginalFilename,
			String FreeRenameFilename) {
		super();
		this.FreeWriter = FreeWriter;
		this.FreeTitle = FreeTitle;
		this.FreeContent = FreeContent;
		this.FreeOriginalFilename = FreeOriginalFilename;
		this.FreeRenameFilename = FreeRenameFilename;
	}

	public Free(int FreeNo, int FreeWriter, String FreeTitle, String FreeContent, String FreeOriginalFilename,
			String FreeRenameFilename, int FreeReadCount, String FreeDate, int FreeLike) {
		super();
		this.FreeNo = FreeNo;
		this.FreeWriter = FreeWriter;
		this.FreeTitle = FreeTitle;
		this.FreeContent = FreeContent;
		this.FreeOriginalFilename = FreeOriginalFilename;
		this.FreeRenameFilename = FreeRenameFilename;
		this.FreeReadCount = FreeReadCount;
		this.FreeDate = FreeDate;
		this.FreeLike = FreeLike;
	}

	public int getFreeNo() {
		return FreeNo;
	}

	public void setFreeNo(int FreeNo) {
		this.FreeNo = FreeNo;
	}

	public int getFreeWriter() {
		return FreeWriter;
	}

	public void setFreeWriter(int FreeWriter) {
		this.FreeWriter = FreeWriter;
	}

	public String getFreeTitle() {
		return FreeTitle;
	}

	public void setFreeTitle(String FreeTitle) {
		this.FreeTitle = FreeTitle;
	}

	public String getFreeContent() {
		return FreeContent;
	}

	public void setFreeContent(String FreeContent) {
		this.FreeContent = FreeContent;
	}

	public String getFreeOriginalFilename() {
		return FreeOriginalFilename;
	}

	public void setFreeOriginalFilename(String FreeOriginalFilename) {
		this.FreeOriginalFilename = FreeOriginalFilename;
	}

	public String getFreeRenameFilename() {
		return FreeRenameFilename;
	}

	public void setFreeRenameFilename(String FreeRenameFilename) {
		this.FreeRenameFilename = FreeRenameFilename;
	}

	public int getFreeReadCount() {
		return FreeReadCount;
	}

	public void setFreeReadCount(int FreeReadCount) {
		this.FreeReadCount = FreeReadCount;
	}

	public String getFreeDate() {
		return FreeDate;
	}

	public void setFreeDate(String FreeDate) {
		this.FreeDate = FreeDate;
	}
	public int getFreeLike() {
		return FreeLike;
	}

	public void setFreeLike(int FreeLike) {
		this.FreeLike = FreeLike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Free [FreeNo=" + FreeNo + ", FreeWriter=" + FreeWriter + ", FreeTitle=" + FreeTitle
				+ ", FreeContent=" + FreeContent + ", FreeOriginalFilename=" + FreeOriginalFilename
				+ ", FreeRenameFilename=" + FreeRenameFilename + ", FreeReadCount=" + FreeReadCount  
				+ ", FreeDate=" + FreeDate + ", FreeLike=" + FreeLike + "]";
	}

	
	
}

