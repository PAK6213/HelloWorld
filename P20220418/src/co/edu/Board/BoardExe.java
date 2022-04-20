package co.edu.Board;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardExe {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		Board board;
		int boardNo = 1;
		// 현재 시간을 불러오기 위한 Date 인스턴스
		Date today = new Date(); 
		// 인터페이스를 구현한 BoardApp 인스턴스 생성.
		BoardService service = new BoardApp();
		while(true) {
			int menu = 0;
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글상세조회(글번호) 5.전체목록 6.종료");
			System.out.print("메뉴를 입력하세요: ");
		
			// 메뉴입력시 숫자가아닌 다른문자를 사용자가 잘못입력 했을 때 예외처리
			try {
			menu = scn.nextInt();
			scn.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력해주세요.");
				scn.nextLine();
			}
			if (menu == BoardService.ADD) {
				//System.out.print("게시글번호를 입력하세요 :");
				//String boardNo = scn.nextLine();
				System.out.print("제목을 입력하세요 :");
				String boardName = scn.nextLine();
				System.out.print("내용을 입력하세요 :");
				String boardContent = scn.nextLine();
				System.out.print("작성자를 입력하세요 :");
				String writer = scn.nextLine();
				//System.out.print("작성일시를 입력하세요 :");
				//String writeDate = scn.nextLine();
				board = new Board(boardNo,boardName,boardContent,writer,today);
				service.addBoard(board);
				boardNo++;
			
			} else if (menu == BoardService.MOD) {
				// 변경할 게시글 번호를 입력 받고 이를 인스턴스에 담은뒤 modBoard 메서드의 매개변수로 넘겨줌.
				System.out.print("변경할 게시글 번호를 입력하세요 :");
				int modNum = scn.nextInt();
				scn.nextLine();
				board = new Board(modNum,null,null,null,null);
				service.modBoard(board);
			} else if (menu == BoardService.DEL) {
				// 삭제할 게시글 번호를 입력받고 해당값을 매개변수로 넘겨줌.
				System.out.println("삭제할 게시글 번호를 입력하세요 :");
				boardNo = scn.nextInt();
				scn.nextLine();
				service.delBoard(boardNo);
			} else if (menu == BoardService.DETAIL) {
				// 조회할 게시글 번호를 입력받고 해당값을 매개변수로 넘겨줌.
				System.out.println("조회할 게시글 번호를 입력하세요 :");
				boardNo = scn.nextInt();
				scn.nextLine();
				service.detailBoard(boardNo);
			} else if (menu == BoardService.ALL) {
				// 입력받은 글 모두 조회
				service.allBoard();
			} else if (menu == BoardService.END) {
				System.out.println("종료되었습니다.");
				break;
			}

		}
		System.out.println("end of prog.");
	}
}
