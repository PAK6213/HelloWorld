package co.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

class User {
	// 아이디, 비밀번호, 사용자명.
	private String userId;
	private String passwd;
	private String userName;

	User(String userId, String passwd, String userName) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	

}

// 6. 작성자 조회 (작성자 이름을 넣으면 작성자 기준의 이름 조회)
public class BoardExe {
	private User[] members = new User[3];  // User객체를 담을 객체배열

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		User[] members = {new User("user1" , "1234", "홍길동")
				,new User("user2" , "2222", "박길동")
				,new User("user3" , "3333", "김길동")};
		// Id를 입력하고 passwd가 맞으면  아래 while을 실햄
		int flag = -1;
		System.out.print("Id를 입력하세요 :");
		String uid = scn.nextLine();
		for(int i = 0; i < members.length; i++) {
			if(members[i].getUserId().equals(uid)) {
				while(true) {
					System.out.print("password를 입력하세요 :");
					String password = scn.nextLine();
					if(members[i].getPasswd().equals(password)) {
						System.out.println("접속되었습니다.");
						flag = 1;
						break;
					} else {
						System.out.println("비밀번호가 틀렸습니다. 다시 입력하세요");
					}
				}
			}
		}			
		if(flag == 1) {

			// BoardList에 정의해놓은 필드와 메소드를 활용해서 기능.
			BoardList bl = new BoardList();  
			bl.init(5);

			while(true) {
				System.out.println("1.추가 2.수정 3.목록 4.삭제 5.한건조회 6.사용자조회 9.종료");
				System.out.print("선택>> ");
				int menu = -1;
				try {
					menu = scn.nextInt();
				} catch(InputMismatchException e) {
					System.out.println("잘못된 처리를 시도했습니다.");
				}
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

					int chk = bl.addBoard(newBoard);
					if(chk == 0) {
						System.out.println("정상처리");
					} else if (chk == -1){
						System.out.println("저장공간이 없습니다.");
					} else if (chk == 1) {
						System.out.println("동일한 값이 있습니다.");
					}

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
					//				Board[] boards = bl.boardList();
					//				System.out.println("작성자 이름을 입력하세요");
					//				String Wrname = scn.nextLine();
					//				boards = bl.searchdetailBoard(Wrname);
					//				for (Board board : boards) { // 참조형 변수  참조배열
					//					if(board != null) { // board 객체의 주소가 있다면.
					//						board.getInfo();
					//					}
					//				}

					// 작성자
					System.out.println("검색할 작성자 이름을 입력하세요");
					String sWriter = scn.nextLine();
					Board[] writerList = bl.searchdetailBoard(sWriter);
					// writerList 내용들을 출력하는 반복문
					System.out.println("게시글번호          제목                             내용                   사용자   조회수");
					System.out.println("=======================================================================");
					for (Board board
							: writerList) { // 참조형 변수  참조배열
						if(board != null) { // board 객체의 주소가 있다면.
							board.getInfo();
						}
					}
				}
				else {
					System.out.println("정확한 메뉴를 입력하세요.");
				}

			}
		}
	}
}
