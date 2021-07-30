package community.best.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int boardNum;  //게시글번호
	private String boardWriter; //게시글 작성자 아이디
	private String boardTitle;  //게시글 제목
	private String boardContent;  //게시글 내용
	private String boardOriginalFilename;  //첨부파일 원래이름
	private String boardRenameFilename;  //변경된 첨부파일이름
	private int boardRef;  //원글은 자기번호, 댓글은 원글번호
	private int boardLevel;  //원글 1, 댓글 2, 대댓글 3
	private int boardReplyRef;  //원글 0, 댓글은 자기번호, 대댓글은 참조하는 댓글번호
	private int boardReplySeq;  //댓글과 대댓글의 순번, 최근 댓글을 1
	private int boardReadCount; //읽은 조회수
	private java.sql.Date boardDate;  //게시글 등록 날짜
	
	public Board() {}

	public Board(String boardWriter, String boardTitle, String boardContent) {
		super();
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public Board(String boardWriter, String boardTitle, 
			String boardContent, String boardOriginalFilename,
			String boardRenameFilename) {
		super();
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardOriginalFilename = boardOriginalFilename;
		this.boardRenameFilename = boardRenameFilename;
	}

	public Board(int boardNum, String boardWriter, String boardTitle, String boardContent, String boardOriginalFilename,
			String boardRenameFilename, int boardRef, int boardLevel, int boardReplyRef, int boardReplySeq,
			int boardReadCount, Date boardDate) {
		super();
		this.boardNum = boardNum;
		this.boardWriter = boardWriter;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardOriginalFilename = boardOriginalFilename;
		this.boardRenameFilename = boardRenameFilename;
		this.boardRef = boardRef;
		this.boardLevel = boardLevel;
		this.boardReplyRef = boardReplyRef;
		this.boardReplySeq = boardReplySeq;
		this.boardReadCount = boardReadCount;
		this.boardDate = boardDate;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardOriginalFilename() {
		return boardOriginalFilename;
	}

	public void setBoardOriginalFilename(String boardOriginalFilename) {
		this.boardOriginalFilename = boardOriginalFilename;
	}

	public String getBoardRenameFilename() {
		return boardRenameFilename;
	}

	public void setBoardRenameFilename(String boardRenameFilename) {
		this.boardRenameFilename = boardRenameFilename;
	}

	public int getBoardRef() {
		return boardRef;
	}

	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}

	public int getBoardLevel() {
		return boardLevel;
	}

	public void setBoardLevel(int boardLevel) {
		this.boardLevel = boardLevel;
	}

	public int getBoardReplyRef() {
		return boardReplyRef;
	}

	public void setBoardReplyRef(int boardReplyRef) {
		this.boardReplyRef = boardReplyRef;
	}

	public int getBoardReplySeq() {
		return boardReplySeq;
	}

	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public java.sql.Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(java.sql.Date boardDate) {
		this.boardDate = boardDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardWriter=" + boardWriter + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardOriginalFilename=" + boardOriginalFilename
				+ ", boardRenameFilename=" + boardRenameFilename + ", boardRef=" + boardRef + ", boardLevel="
				+ boardLevel + ", boardReplyRef=" + boardReplyRef + ", boardReplySeq=" + boardReplySeq
				+ ", boardReadCount=" + boardReadCount + ", boardDate=" + boardDate + "]";
	}
	
}

