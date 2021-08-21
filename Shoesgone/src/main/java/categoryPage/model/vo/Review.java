package categoryPage.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int ReviewNo;  //게시글번호
	private int ReviewWriter; //게시글 작성자 아이디
	private String ReviewTitle;  //게시글 제목
	private String ReviewContent;  //게시글 내용
	private String ReviewOriginalFilename;  //첨부파일 원래이름
	private String ReviewRenameFilename;  //변경된 첨부파일이름
	private int ReviewReadCount; //읽은 조회수
	private java.sql.Date ReviewDate;  //게시글 등록 날짜
	private int ReviewItemNo; //리뷰하는 물품 번호
	private int ReviewStar; //별점
	private int ReviewLike; //추천수
	private int ReviewUnlike;
	
	public Review() {}

	public Review(int ReviewWriter, String ReviewTitle, String ReviewContent) {
		super();
		this.ReviewWriter = ReviewWriter;
		this.ReviewTitle = ReviewTitle;
		this.ReviewContent = ReviewContent;
	}

	public Review(int ReviewWriter, String ReviewTitle, 
			String ReviewContent, String ReviewOriginalFilename,
			String ReviewRenameFilename) {
		super();
		this.ReviewWriter = ReviewWriter;
		this.ReviewTitle = ReviewTitle;
		this.ReviewContent = ReviewContent;
		this.ReviewOriginalFilename = ReviewOriginalFilename;
		this.ReviewRenameFilename = ReviewRenameFilename;
	}

	public Review(int reviewNo, int reviewWriter, String reviewTitle, String reviewContent,
			String reviewOriginalFilename, String reviewRenameFilename, int reviewReadCount, Date reviewDate,
			int reviewItemNo, int reviewStar, int reviewLike, int reviewUnlike) {
		super();
		this.ReviewNo = reviewNo;
		this.ReviewWriter = reviewWriter;
		this.ReviewTitle = reviewTitle;
		this.ReviewContent = reviewContent;
		this.ReviewOriginalFilename = reviewOriginalFilename;
		this.ReviewRenameFilename = reviewRenameFilename;
		this.ReviewReadCount = reviewReadCount;
		this.ReviewDate = reviewDate;
		this.ReviewItemNo = reviewItemNo;
		this.ReviewStar = reviewStar;
		this.ReviewLike = reviewLike;
		this.ReviewUnlike = reviewUnlike;
	}

	public int getReviewNo() {
		return ReviewNo;
	}

	public void setReviewNo(int reviewNo) {
		ReviewNo = reviewNo;
	}

	public int getReviewWriter() {
		return ReviewWriter;
	}

	public void setReviewWriter(int reviewWriter) {
		ReviewWriter = reviewWriter;
	}

	public String getReviewTitle() {
		return ReviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		ReviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return ReviewContent;
	}

	public void setReviewContent(String reviewContent) {
		ReviewContent = reviewContent;
	}

	public String getReviewOriginalFilename() {
		return ReviewOriginalFilename;
	}

	public void setReviewOriginalFilename(String reviewOriginalFilename) {
		ReviewOriginalFilename = reviewOriginalFilename;
	}

	public String getReviewRenameFilename() {
		return ReviewRenameFilename;
	}

	public void setReviewRenameFilename(String reviewRenameFilename) {
		ReviewRenameFilename = reviewRenameFilename;
	}

	public int getReviewReadCount() {
		return ReviewReadCount;
	}

	public void setReviewReadCount(int reviewReadCount) {
		ReviewReadCount = reviewReadCount;
	}

	public java.sql.Date getReviewDate() {
		return ReviewDate;
	}

	public void setReviewDate(java.sql.Date reviewDate) {
		ReviewDate = reviewDate;
	}

	public int getReviewItemNo() {
		return ReviewItemNo;
	}

	public void setReviewItemNo(int reviewItemNo) {
		ReviewItemNo = reviewItemNo;
	}

	public int getReviewStar() {
		return ReviewStar;
	}

	public void setReviewStar(int reviewStar) {
		ReviewStar = reviewStar;
	}

	public int getReviewLike() {
		return ReviewLike;
	}

	public void setReviewLike(int reviewLike) {
		ReviewLike = reviewLike;
	}

	public int getReviewUnlike() {
		return ReviewUnlike;
	}

	public void setReviewUnlike(int reviewUnlike) {
		ReviewUnlike = reviewUnlike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Review [ReviewNo=" + ReviewNo + ", ReviewWriter=" + ReviewWriter + ", ReviewTitle=" + ReviewTitle
				+ ", ReviewContent=" + ReviewContent + ", ReviewOriginalFilename=" + ReviewOriginalFilename
				+ ", ReviewRenameFilename=" + ReviewRenameFilename + ", ReviewReadCount=" + ReviewReadCount
				+ ", ReviewDate=" + ReviewDate + ", ReviewItemNo=" + ReviewItemNo + ", ReviewStar=" + ReviewStar
				+ ", ReviewLike=" + ReviewLike + ", ReviewUnlike=" + ReviewUnlike + "]";
	}
}
