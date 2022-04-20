package co.edu.Board;

import java.util.Date;

public class Board {
	//필드
	private int boardNo;  // 게시글번호
	private String boardName; // 제목
	private String boardContent; // 내용
	private String writer; //작성자
	private Date writeDate; // 작성일시
	
	//생성자
	public Board() {
		
	}
	
	
	public Board(int boardNo, String boardName, String boardContent, String writer, Date writeDate) {
		super();
		this.boardNo = boardNo;
		this.boardName = boardName;
		this.boardContent = boardContent;
		this.writer = writer;
		this.writeDate = writeDate;
	}
	
	// getter and setter
	

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}


	public Date getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}


	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardName=" + boardName + ", boardContent=" + boardContent + ", writer="
				+ writer + ", writeDate=" + writeDate + "]";
	}
	
	
	
	
	
	
	

}
