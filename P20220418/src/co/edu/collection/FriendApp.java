package co.edu.collection;

import java.util.Scanner;

import co.edu.friend.Friend;

// 친구목록저장하기 위한 App.
// 추가, 수정, 삭제, 조회
// 1) 배열 2) 컬렉션 <- 인터페이스 구현.


public class FriendApp {
	public static void main(String[] args) {
		Friend friend = new Friend();
		//FriendService service =  new FriendServiceArray();
		
		
		// 인터페이스를 구현하여 List
		FriendService service =  new FriendServiceList();  
		// 1.추가(이름, 연락처) 2.수정(이름으로 찾아서 연락처를 수정) 3.삭제 4.조회 -> 컨트롤



		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회");
			System.out.print("메뉴를 입력하세요: ");
			int menu = scn.nextInt();
			scn.nextLine();
		
			if(menu == 1) {  // 객체를 매개변수로 넘겨주고 add 할 것.
				System.out.print("이름을 입력하세요.");
				String name = scn.nextLine();
				System.out.print("연락처를 입력하세요.");
				String phone = scn.nextLine();
				friend = new Friend(name,phone);
				service.addFriend(friend);
			} else if (menu == 2) { // 리스트에서 같은 이름값이 있는지 찾고 연락처를 수정해야함. 객체를 넘겨줌.
				System.out.print("수정할 이름을 입력하세요.");
				String findname = scn.nextLine();
				friend = new Friend(findname,null);
				service.modFriend(friend); // 매개변수로 객체가 넘어갔음.
				
			} else if (menu == 3) {
				System.out.println("삭제할 이름을 입력하세요 :");
				String rm = scn.nextLine();
				service.remFriend(rm);
			} else if (menu == 4) {
				System.out.println("조회하실 이름을 입력하세요.");
				String showname = scn.nextLine();
				friend = service.findFriend(showname);
				service.showFriend();
			} else {
				//종료
				break;
				
			}

		}
	}
}
