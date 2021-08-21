package categoryPage.model.vo;

import java.sql.Date;

public class Free implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int FreeNo;  //게시글번호
	private int FreeWriter; //게시글 작성자 아이디
	private String FreeTitle;  //게시글 제목
	private String FreeContent;  //게시글 내용
	private String FreeOriginalFilename;  //첨부파일 원래이름
	private String FreeRenameFilename;  //변경된 첨부파일이름
	private int FreeReadCount; //읽은 조회수
	private java.sql.Date FreeDate;  //게시글 등록 날짜
	private int FreeLike; //추천수
	private int FreeUnlike;
	
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
	
	public Free(int freeNo, int freeWriter, String freeTitle, String freeContent, String freeOriginalFilename,
			String freeRenameFilename, int freeReadCount, Date freeDate, int freeLike, int freeUnlike) {
		super();
		this.FreeNo = freeNo;
		this.FreeWriter = freeWriter;
		this.FreeTitle = freeTitle;
		this.FreeContent = freeContent;
		this.FreeOriginalFilename = freeOriginalFilename;
		this.FreeRenameFilename = freeRenameFilename;
		this.FreeReadCount = freeReadCount;
		this.FreeDate = freeDate;
		this.FreeLike = freeLike;
		this.FreeUnlike = freeUnlike;
	}

	public int getFreeNo() {
		return FreeNo;
	}

	public void setFreeNo(int freeNo) {
		FreeNo = freeNo;
	}

	public int getFreeWriter() {
		return FreeWriter;
	}

	public void setFreeWriter(int freeWriter) {
		FreeWriter = freeWriter;
	}

	public String getFreeTitle() {
		return FreeTitle;
	}

	public void setFreeTitle(String freeTitle) {
		FreeTitle = freeTitle;
	}

	public String getFreeContent() {
		return FreeContent;
	}

	public void setFreeContent(String freeContent) {
		FreeContent = freeContent;
	}

	public String getFreeOriginalFilename() {
		return FreeOriginalFilename;
	}

	public void setFreeOriginalFilename(String freeOriginalFilename) {
		FreeOriginalFilename = freeOriginalFilename;
	}

	public String getFreeRenameFilename() {
		return FreeRenameFilename;
	}

	public void setFreeRenameFilename(String freeRenameFilename) {
		FreeRenameFilename = freeRenameFilename;
	}

	public int getFreeReadCount() {
		return FreeReadCount;
	}

	public void setFreeReadCount(int freeReadCount) {
		FreeReadCount = freeReadCount;
	}

	public java.sql.Date getFreeDate() {
		return FreeDate;
	}

	public void setFreeDate(java.sql.Date freeDate) {
		FreeDate = freeDate;
	}

	public int getFreeLike() {
		return FreeLike;
	}

	public void setFreeLike(int freeLike) {
		FreeLike = freeLike;
	}

	public int getFreeUnlike() {
		return FreeUnlike;
	}

	public void setFreeUnlike(int freeUnlike) {
		FreeUnlike = freeUnlike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Free [FreeNo=" + FreeNo + ", FreeWriter=" + FreeWriter + ", FreeTitle=" + FreeTitle + ", FreeContent="
				+ FreeContent + ", FreeOriginalFilename=" + FreeOriginalFilename + ", FreeRenameFilename="
				+ FreeRenameFilename + ", FreeReadCount=" + FreeReadCount + ", FreeDate=" + FreeDate + ", FreeLike="
				+ FreeLike + ", FreeUnlike=" + FreeUnlike + "]";
	}
}
