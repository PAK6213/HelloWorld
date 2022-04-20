package co.edu.Board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp implements BoardService {
	//  Board 참조타입 ArrayList 생성
	ArrayList<Board> boards = new ArrayList<Board>();

	Scanner scn = new Scanner(System.in);


	@Override
	//ArrayList에 객체추가
	public void addBoard(Board board) {
		boards.add(board);
	}

	@Override
	// 글번호 기준으로 내용을 변경
	public void modBoard(Board board) {
		for(int i = 0; i < boards.size(); i++) {
			// ArrayList의 i번째의 Name과 매개변수 인스턴스의 Name과 비교
			if(boards.get(i).getBoardNo() == (board.getBoardNo())) {
				System.out.print("변경할 내용을 입력하세요 :");
				String modContent = scn.nextLine();
				// 입력한 내용을 해당 i번째의 ArrayList에 저장
				boards.get(i).setBoardContent(modContent);
				break;
			}
		}
	}

	@Override
	// 게시글 번호 기준으로 게시글 삭제
	public void delBoard(int boardNo) {
		for(int i = 0; i < boards.size(); i++) {
			// ArrayList의 i번째의 Name과 매개변수 인스턴스의 Name과 비교
			if(boards.get(i).getBoardNo()==(boardNo)) {
				// 조건에 만족하는 i번째 ArrayList의 객체를 삭제함
				boards.remove(i);
				break;
			}
		}
	}

	@Override
	public void detailBoard(int boardNo) {
		// 조회할 boardNo을 매개변수로 받아 작업을 진행.
		for(int i = 0; i < boards.size(); i++) {
			// ArrayList의 i번째의 Name과 매개변수 인스턴스의 Name과 비교
			if(boards.get(i) != null && boards.get(i).getBoardNo()==(boardNo)) {
				System.out.printf("|게시글번호 : %-3d   제목 : %-25s |\n|작성자 : %-3s   작성일 : %s|\n|내용 : %-43s|\n",boards.get(i).getBoardNo(),boards.get(i).getBoardName(),boards.get(i).getWriter(),boards.get(i).getWriteDate(),boards.get(i).getBoardContent());
				
				//System.out.println(boards.get(i).toString());

			}
		}
	}

	@Override
	public void allBoard() {
		for(int i = 0; i < boards.size(); i++) {
			System.out.println(boards.get(i).toString());
		}
		// TODO Auto-generated method stub
	}


}
