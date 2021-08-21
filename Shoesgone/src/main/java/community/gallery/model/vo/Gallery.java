package community.gallery.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Gallery implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int GalleryNo;  //게시글번호
	private int GalleryWriter; //게시글 작성자 아이디
	private String GalleryTitle;  //게시글 제목
	private String GalleryContent;  //게시글 내용
	private String GalleryOriginalFilename;  //첨부파일 원래이름
	private String GalleryRenameFilename;  //변경된 첨부파일이름
	private int GalleryReadCount; //읽은 조회수
	private String GalleryDate;  //게시글 등록 날짜
	private int GalleryLike; // 추천수
	
	public Gallery() {}

	public Gallery(int GalleryWriter, String GalleryTitle, String GalleryContent) {
		super();
		this.GalleryWriter = GalleryWriter;
		this.GalleryTitle = GalleryTitle;
		this.GalleryContent = GalleryContent;
	}

	public Gallery(int GalleryWriter, String GalleryTitle, 
			String GalleryContent, String GalleryOriginalFilename,
			String GalleryRenameFilename) {
		super();
		this.GalleryWriter = GalleryWriter;
		this.GalleryTitle = GalleryTitle;
		this.GalleryContent = GalleryContent;
		this.GalleryOriginalFilename = GalleryOriginalFilename;
		this.GalleryRenameFilename = GalleryRenameFilename;
	}

	public Gallery(int GalleryNo, int GalleryWriter, String GalleryTitle, String GalleryContent, String GalleryOriginalFilename,
			String GalleryRenameFilename, int GalleryRef, int GalleryLevel, int GalleryReplyRef, int GalleryReplySeq,
			int GalleryReadCount, String GalleryDate, int GalleryLike) {
		super();
		this.GalleryNo = GalleryNo;
		this.GalleryWriter = GalleryWriter;
		this.GalleryTitle = GalleryTitle;
		this.GalleryContent = GalleryContent;
		this.GalleryOriginalFilename = GalleryOriginalFilename;
		this.GalleryRenameFilename = GalleryRenameFilename;
		this.GalleryReadCount = GalleryReadCount;
		this.GalleryDate = GalleryDate;
		this.GalleryLike = GalleryLike;
	}

	public int getGalleryNo() {
		return GalleryNo;
	}

	public void setGalleryNo(int GalleryNo) {
		this.GalleryNo = GalleryNo;
	}

	public int getGalleryWriter() {
		return GalleryWriter;
	}

	public void setGalleryWriter(int GalleryWriter) {
		this.GalleryWriter = GalleryWriter;
	}

	public String getGalleryTitle() {
		return GalleryTitle;
	}

	public void setGalleryTitle(String GalleryTitle) {
		this.GalleryTitle = GalleryTitle;
	}

	public String getGalleryContent() {
		return GalleryContent;
	}

	public void setGalleryContent(String GalleryContent) {
		this.GalleryContent = GalleryContent;
	}

	public String getGalleryOriginalFilename() {
		return GalleryOriginalFilename;
	}

	public void setGalleryOriginalFilename(String GalleryOriginalFilename) {
		this.GalleryOriginalFilename = GalleryOriginalFilename;
	}

	public String getGalleryRenameFilename() {
		return GalleryRenameFilename;
	}

	public void setGalleryRenameFilename(String GalleryRenameFilename) {
		this.GalleryRenameFilename = GalleryRenameFilename;
	}

	public int getGalleryReadCount() {
		return GalleryReadCount;
	}

	public void setGalleryReadCount(int GalleryReadCount) {
		this.GalleryReadCount = GalleryReadCount;
	}

	public String getGalleryDate() {
		return GalleryDate;
	}

	public void setGalleryDate(String GalleryDate) {
		this.GalleryDate = GalleryDate;
	}
	public int getGalleryLike() {
		return GalleryLike;
	}

	public void setGalleryLike(int GalleryLike) {
		this.GalleryLike = GalleryLike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Gallery [GalleryNo=" + GalleryNo + ", GalleryWriter=" + GalleryWriter + ", GalleryTitle=" + GalleryTitle
				+ ", GalleryContent=" + GalleryContent + ", GalleryOriginalFilename=" + GalleryOriginalFilename
				+ ", GalleryRenameFilename=" + GalleryRenameFilename 
				+ ", GalleryReadCount=" + GalleryReadCount + ", GalleryDate=" + GalleryDate + ", GalleryLike=" + GalleryLike + "]";
	}

	

	

	
}

