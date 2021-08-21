package categoryPage.model.vo;

import java.sql.Date;

public class Gallery implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int GalleryNo;  //게시글번호
	private int GalleryWriter; //게시글 작성자 아이디
	private String GalleryTitle;  //게시글 제목
	private String GalleryContent;  //게시글 내용
	private String GalleryOriginalFilename;  //첨부파일 원래이름
	private String GalleryRenameFilename;  //변경된 첨부파일이름
	private int GalleryReadCount; //읽은 조회수
	private java.sql.Date GalleryDate;  //게시글 등록 날짜
	private int GalleryLike; // 추천수
	private int GalleryUnlike;
	
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

	public Gallery(int galleryNo, int galleryWriter, String galleryTitle, String galleryContent,
			String galleryOriginalFilename, String galleryRenameFilename, int galleryReadCount, Date galleryDate,
			int galleryLike, int galleryUnlike) {
		super();
		this.GalleryNo = galleryNo;
		this.GalleryWriter = galleryWriter;
		this.GalleryTitle = galleryTitle;
		this.GalleryContent = galleryContent;
		this.GalleryOriginalFilename = galleryOriginalFilename;
		this.GalleryRenameFilename = galleryRenameFilename;
		this.GalleryReadCount = galleryReadCount;
		this.GalleryDate = galleryDate;
		this.GalleryLike = galleryLike;
		this.GalleryUnlike = galleryUnlike;
	}

	public int getGalleryNo() {
		return GalleryNo;
	}

	public void setGalleryNo(int galleryNo) {
		GalleryNo = galleryNo;
	}

	public int getGalleryWriter() {
		return GalleryWriter;
	}

	public void setGalleryWriter(int galleryWriter) {
		GalleryWriter = galleryWriter;
	}

	public String getGalleryTitle() {
		return GalleryTitle;
	}

	public void setGalleryTitle(String galleryTitle) {
		GalleryTitle = galleryTitle;
	}

	public String getGalleryContent() {
		return GalleryContent;
	}

	public void setGalleryContent(String galleryContent) {
		GalleryContent = galleryContent;
	}

	public String getGalleryOriginalFilename() {
		return GalleryOriginalFilename;
	}

	public void setGalleryOriginalFilename(String galleryOriginalFilename) {
		GalleryOriginalFilename = galleryOriginalFilename;
	}

	public String getGalleryRenameFilename() {
		return GalleryRenameFilename;
	}

	public void setGalleryRenameFilename(String galleryRenameFilename) {
		GalleryRenameFilename = galleryRenameFilename;
	}

	public int getGalleryReadCount() {
		return GalleryReadCount;
	}

	public void setGalleryReadCount(int galleryReadCount) {
		GalleryReadCount = galleryReadCount;
	}

	public java.sql.Date getGalleryDate() {
		return GalleryDate;
	}

	public void setGalleryDate(java.sql.Date galleryDate) {
		GalleryDate = galleryDate;
	}

	public int getGalleryLike() {
		return GalleryLike;
	}

	public void setGalleryLike(int galleryLike) {
		GalleryLike = galleryLike;
	}

	public int getGalleryUnlike() {
		return GalleryUnlike;
	}

	public void setGalleryUnlike(int galleryUnlike) {
		GalleryUnlike = galleryUnlike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Gallery [GalleryNo=" + GalleryNo + ", GalleryWriter=" + GalleryWriter + ", GalleryTitle=" + GalleryTitle
				+ ", GalleryContent=" + GalleryContent + ", GalleryOriginalFilename=" + GalleryOriginalFilename
				+ ", GalleryRenameFilename=" + GalleryRenameFilename + ", GalleryReadCount=" + GalleryReadCount
				+ ", GalleryDate=" + GalleryDate + ", GalleryLike=" + GalleryLike + ", GalleryUnlike=" + GalleryUnlike
				+ "]";
	}
}
