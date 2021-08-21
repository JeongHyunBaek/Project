package community.reply.model.vo;

public class Reply implements java.io.Serializable {
	private static final long serialVersionUID = 113L;
	
	private int ReplyNo; //댓글 번호
	private int ParentReplyNo; //부모댓글 번호
	private int ReplyLevel; // 댓글 깊이
	private int ReplyOrder; // 댓글 정렬 순서
	private String BoardType; // 댓글 달린 게시판 종류
	private int BoardNo; // 댓글 달린 게시판 번호
	private int ReplyWriter; //댓글작성자
	private String ReplyDate; //댓글 등록 일자
	private int ReplyLike; //추천수
	private String ReplyContent; //댓글내용
	
	public Reply() {}

	public Reply(int replyNo, int parentReplyNo, int replyLevel, int replyOrder, String boardType, int boardNo,
			int replyWriter, String replyDate, int replyLike, String replyContent) {
		super();
		ReplyNo = replyNo;
		ParentReplyNo = parentReplyNo;
		ReplyLevel = replyLevel;
		ReplyOrder = replyOrder;
		BoardType = boardType;
		BoardNo = boardNo;
		ReplyWriter = replyWriter;
		ReplyDate = replyDate;
		ReplyLike = replyLike;
		ReplyContent = replyContent;
	}






	public int getReplyNo() {
		return ReplyNo;
	}

	public void setReplyNo(int replyNo) {
		ReplyNo = replyNo;
	}

	public int getParentReplyNo() {
		return ParentReplyNo;
	}

	public void setParentReplyNo(int parentReplyNo) {
		ParentReplyNo = parentReplyNo;
	}

	public int getReplyLevel() {
		return ReplyLevel;
	}

	public void setReplyLevel(int replyLevel) {
		ReplyLevel = replyLevel;
	}
	
	public int getReplyOrder() {
		return ReplyOrder;
	}

	public void setReplyOrder(int replyOrder) {
		ReplyOrder = replyOrder;
	}

	public String getBoardType() {
		return BoardType;
	}

	public void setBoardType(String boardType) {
		BoardType = boardType;
	}

	public int getBoardNo() {
		return BoardNo;
	}

	public void setBoardNo(int boardNo) {
		BoardNo = boardNo;
	}

	public int getReplyWriter() {
		return ReplyWriter;
	}

	public void setReplyWriter(int replyWriter) {
		ReplyWriter = replyWriter;
	}

	public String getReplyDate() {
		return ReplyDate;
	}

	public void setReplyDate(String replyDate) {
		ReplyDate = replyDate;
	}

	public int getReplyLike() {
		return ReplyLike;
	}

	public void setReplyLike(int replyLike) {
		ReplyLike = replyLike;
	}

	public String getReplyContent() {
		return ReplyContent;
	}

	public void setReplyContent(String replyContent) {
		ReplyContent = replyContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Reply [ReplyNo=" + ReplyNo + ", ParentReplyNo=" + ParentReplyNo + ", ReplyLevel=" + ReplyLevel
				+ ", ReplyOrder=" + ReplyOrder + ", BoardType=" + BoardType + ", BoardNo=" + BoardNo + ", ReplyWriter="
				+ ReplyWriter + ", ReplyDate=" + ReplyDate + ", ReplyLike=" + ReplyLike + ", ReplyContent="
				+ ReplyContent + "]";
	}

}


