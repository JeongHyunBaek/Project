package community.best.model.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Best implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int BestNo;  //게시글번호
	private int BestWriter; //게시글 작성자 아이디
	private String BestTitle;  //게시글 제목
	private String BestContent;  //게시글 내용
	private String BestOriginalFilename;  //첨부파일 원래이름
	private String BestRenameFilename;  //변경된 첨부파일이름
	private int BestRef;  //원글은 자기번호, 댓글은 원글번호
	private int BestLevel;  //원글 1, 댓글 2, 대댓글 3
	private int BestReplyRef;  //원글 0, 댓글은 자기번호, 대댓글은 참조하는 댓글번호
	private int BestReplySeq;  //댓글과 대댓글의 순번, 최근 댓글을 1
	private int BestReadCount; //읽은 조회수
	private java.sql.Date BestDate;  //게시글 등록 날짜
	private int BestLike; //추천수
	
	public Best() {}

	public Best(int BestWriter, String BestTitle, String BestContent) {
		super();
		this.BestWriter = BestWriter;
		this.BestTitle = BestTitle;
		this.BestContent = BestContent;
	}

	public Best(int BestWriter, String BestTitle, 
			String BestContent, String BestOriginalFilename,
			String BestRenameFilename) {
		super();
		this.BestWriter = BestWriter;
		this.BestTitle = BestTitle;
		this.BestContent = BestContent;
		this.BestOriginalFilename = BestOriginalFilename;
		this.BestRenameFilename = BestRenameFilename;
	}

	public Best(int BestNo, int BestWriter, String BestTitle, String BestContent, String BestOriginalFilename,
			String BestRenameFilename, int BestRef, int BestLevel, int BestReplyRef, int BestReplySeq,
			int BestReadCount, Date BestDate, int BestLike) {
		super();
		this.BestNo = BestNo;
		this.BestWriter = BestWriter;
		this.BestTitle = BestTitle;
		this.BestContent = BestContent;
		this.BestOriginalFilename = BestOriginalFilename;
		this.BestRenameFilename = BestRenameFilename;
		this.BestRef = BestRef;
		this.BestLevel = BestLevel;
		this.BestReplyRef = BestReplyRef;
		this.BestReplySeq = BestReplySeq;
		this.BestReadCount = BestReadCount;
		this.BestDate = BestDate;
		this.BestLike = BestLike;
	}

	public int getBestNo() {
		return BestNo;
	}

	public void setBestNo(int BestNo) {
		this.BestNo = BestNo;
	}

	public int getBestWriter() {
		return BestWriter;
	}

	public void setBestWriter(int BestWriter) {
		this.BestWriter = BestWriter;
	}

	public String getBestTitle() {
		return BestTitle;
	}

	public void setBestTitle(String BestTitle) {
		this.BestTitle = BestTitle;
	}

	public String getBestContent() {
		return BestContent;
	}

	public void setBestContent(String BestContent) {
		this.BestContent = BestContent;
	}

	public String getBestOriginalFilename() {
		return BestOriginalFilename;
	}

	public void setBestOriginalFilename(String BestOriginalFilename) {
		this.BestOriginalFilename = BestOriginalFilename;
	}

	public String getBestRenameFilename() {
		return BestRenameFilename;
	}

	public void setBestRenameFilename(String BestRenameFilename) {
		this.BestRenameFilename = BestRenameFilename;
	}

	public int getBestRef() {
		return BestRef;
	}

	public void setBestRef(int BestRef) {
		this.BestRef = BestRef;
	}

	public int getBestLevel() {
		return BestLevel;
	}

	public void setBestLevel(int BestLevel) {
		this.BestLevel = BestLevel;
	}

	public int getBestReplyRef() {
		return BestReplyRef;
	}

	public void setBestReplyRef(int BestReplyRef) {
		this.BestReplyRef = BestReplyRef;
	}

	public int getBestReplySeq() {
		return BestReplySeq;
	}

	public void setBestReplySeq(int BestReplySeq) {
		this.BestReplySeq = BestReplySeq;
	}

	public int getBestReadCount() {
		return BestReadCount;
	}

	public void setBestReadCount(int BestReadCount) {
		this.BestReadCount = BestReadCount;
	}

	public java.sql.Date getBestDate() {
		return BestDate;
	}

	public void setBestDate(java.sql.Date BestDate) {
		this.BestDate = BestDate;
	}
	public int getBestLike() {
		return BestLike;
	}

	public void setBestLike(int BestLike) {
		this.BestLike = BestLike;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Best [BestNo=" + BestNo + ", BestWriter=" + BestWriter + ", BestTitle=" + BestTitle
				+ ", BestContent=" + BestContent + ", BestOriginalFilename=" + BestOriginalFilename
				+ ", BestRenameFilename=" + BestRenameFilename + ", BestRef=" + BestRef + ", BestLevel="
				+ BestLevel + ", BestReplyRef=" + BestReplyRef + ", BestReplySeq=" + BestReplySeq
				+ ", BestReadCount=" + BestReadCount + ", BestDate=" + BestDate + ", BestLike=" + BestLike + "]";
	}

	
	
}

