package co.edu;

public class BoardList {
	
	private Board[] boards;
	// 배열크기 초기화
	public void init(int size) {
		boards = new Board[size];
	}
	

	// 배열에 한건 입력.
	public int addBoard(Board board) {
		// 더이상 저장공간이 없을 떄 .. false
		int errorCase = -1;
		for(int i = 0; i <boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == board.getBoardNo()) {
				errorCase = 1; // 같은 값이 올경우 에러		
				break;
			}
			if(boards[i] == null) {
				boards[i] = board;
				errorCase = 0; // 정상처리
				break;
			}
		}
		return errorCase;
		
	}
	
	// 수정 : 게시글번호를 찾아서 내용과 제목을 변경
	public boolean modifyBoard(Board board) {
		boolean check = false;
		for(int i=0; i < boards.length; i++) {
			if(boards[i].getBoardNo() == board.getBoardNo()) {
				boards[i].setContent(board.getContent());
				boards[i].setTitle(board.getTitle());
				check = true;
				break;
			}
		}
		return check;
	}
	
	// 삭제 : 게시글번호를 찾아서 삭제
	public boolean removeBoard(int bNo) {
		boolean check = false;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i].getBoardNo() == bNo) {
				boards[i] = null;
				check = true;
				break;
			
			}
		}
		return check;
	}
	
	// 한건 조회
	public Board detailBoard(int bNo) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i].getBoardNo() == bNo) {
				int currentCnt = boards[i].getSearchCnt();
				boards[i].setSearchCnt(currentCnt + 1);// 조회수증가
				//boards[i].
				return boards[i];
			}
		}
		return null;
	}
	
	// 게시글 목록 
	public Board[] boardList() {
		return boards;
	}
	

	// 작성자 이름을 받아 조회 같은 작성자만 조회
	public Board[] searchdetailBoard(String Wr) {
		Board[] sBoards = new Board[5];  // 객체배열 5개짜리 생성
		for(int i = 0; i < boards.length ; i++) {  // 찾을대상배열
			if(boards[i] != null && boards[i].getWriter().equals(Wr)) {
				for(int j = 0 ; j < sBoards.length ; j++) { // 이름이 같은거만 저장할 배열
					if(sBoards[j] == null) {
						sBoards[j] = boards[i];
						break;
					}
				}
			}
		}
		return sBoards;
	}
}
