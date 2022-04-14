package co.edu;

import java.util.Scanner;
// 6. 작성자 조회 (작성자 이름을 넣으면 작성자 기준의 이름 조회)
public class BoardExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// BoardList에 정의해놓은 필드와 메소드를 활용해서 기능.
		BoardList bl = new BoardList();  
		bl.init(5);

		while(true) {
			System.out.println("1.추가 2.수정 3.목록 4.삭제 9.종료");
			System.out.print("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine(); // 공백제거

			if (menu == 1) {
				System.out.print("글번호입력>> ");
				int bNo = scn.nextInt();
				scn.nextLine(); // 공백제거
				System.out.print("제목입력>> ");
				String bTitle = scn.nextLine();
				System.out.print("내용입력>> ");
				String bContent = scn.nextLine();
				System.out.print("작성자입력>> ");
				String bWriter = scn.nextLine();
				// 생성자를 호출하여 입력받은 값으로 초기화하고 newBoard 참조변수에 저장. 
				Board newBoard = new Board(bNo, bTitle, bContent, bWriter);
				bl.addBoard(newBoard);
//				int chk = bl.addBoard(newBoard);
//				if(chk == 0) {
//					System.out.println("정상처리");
//				} else if (chk == -1){
//					System.out.println("저장공간이 없습니다.");
//				} else if (chk == 1) {
//					System.out.println("동일한 값이 있습니다.");
//				}

			} else if (menu == 2) {
				System.out.print("수정할 게시글 번호를 입력하세요.");
				int bNo = Integer.parseInt(scn.nextLine());
				System.out.print("변경할 제목을 입력하세요.");
				String title = scn.nextLine();
				System.out.print("변경할 내용을 입력하세요.");
				String content = scn.nextLine();
				// 변경할 내용을 담는 객체를 생성
				Board cBoard = new Board(bNo, title, content, null);
				if(bl.modifyBoard(cBoard)) {
					System.out.println("정상수정완료");
				} else {
					System.out.println("비정상수정완료");
				}

			} else if (menu == 3) {
				Board[] boards = bl.boardList();
				System.out.println("게시글번호          제목                             내용                   사용자   조회수");
				System.out.println("=======================================================================");
				for (Board board : boards) { // 참조형 변수  참조배열
					if(board != null) { // board 객체의 주소가 있다면.
						board.getInfo();
					}
				}
			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if(menu == 4) {
				System.out.print("삭제할 번호를 입력하세요.");
				int bNo = Integer.parseInt(scn.nextLine());
				if(bl.removeBoard(bNo)) {
					System.out.println("삭제정상처리");
				} else {
					System.out.println("삭제 비정상처리");
				}
			} else if(menu == 5) {
				System.out.print("조회할 번호를 입력하세요.");
				int bNo = Integer.parseInt(scn.nextLine());
				Board getBoard = bl.detailBoard(bNo);
				if(getBoard == null) {
					System.out.println("조회할 내용이 없습니다.");
				} else {
					getBoard.getDetailInfo();
				}

			} else if(menu == 6) {
				Board[] boards = bl.boardList();
				System.out.println("작성자 이름을 입력하세요");
				String Wrname = scn.nextLine();
				
			}
			else {
				System.out.println("정확한 메뉴를 입력하세요.");
			}
			
		}
	}
}
