package co.edu.collection;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.friend.Friend;
import co.edu.friend.Gender;

// 친구목록저장하기 위한 App.
// 추가, 수정, 삭제, 조회
// 1) 배열 2) 컬렉션 <- 인터페이스 구현.
// enum 클래스 이용방법


public class FriendApp {
	public static void main(String[] args) {
		Friend friend = new Friend();
		//FriendService service =  new FriendServiceArray();


		// 인터페이스를 구현하여 List
		FriendService service =  new FriendServiceList();  
		// 1.추가(이름, 연락처) 2.수정(이름으로 찾아서 연락처를 수정) 3.삭제 4.조회 -> 컨트롤



		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.남자 6.여자");
			System.out.print("메뉴를 입력하세요: ");
			int menu = scn.nextInt();
			scn.nextLine();

			if(menu == FriendService.ADD) {  // 객체를 매개변수로 넘겨주고 add 할 것.
				System.out.print("이름을 입력하세요.");
				String name = scn.nextLine();
				System.out.print("연락처를 입력하세요.");
				String phone = scn.nextLine();
				System.out.print("성별를 입력하세요. ex)남자 / 여자");
				String gender = scn.nextLine();

				Gender gen = Gender.MEN;

				if(gender.startsWith("남")) {
					gen = Gender.MEN;
				} else if(gender.startsWith("여")) {
					gen = Gender.WOMEN;
				}

				friend = new Friend(name, phone, gen);
				service.addFriend(friend);

			} else if (menu == FriendService.MOD) { // 리스트에서 같은 이름값이 있는지 찾고 연락처를 수정해야함. 객체를 넘겨줌.
				System.out.print("수정할 이름을 입력하세요.");
				String modname = scn.nextLine();
				System.out.print("수정할 연락처를 입력하세요.");
				String modphone = scn.nextLine();
				friend = new Friend(modname,modphone);
				service.modFriend(friend); // 매개변수로 객체가 넘어갔음.

			} else if (menu == FriendService.REM) {
				System.out.println("삭제할 이름을 입력하세요 :");
				String rm = scn.nextLine();
				service.remFriend(rm);
			} else if (menu == FriendService.FIND) {
				System.out.println("조회하실 이름을 입력하세요.");
				String showname = scn.nextLine();
				friend = service.findFriend(showname);
				System.out.println(friend.toString());
			} else if (menu == FriendService.MEN) {
				ArrayList<Friend> list = service.findGender(Gender.MEN);
				for(Friend friend1 : list) {
					System.out.println(friend1.toString());
				}
			} else if (menu == FriendService.WOMEN) {
				ArrayList<Friend> list = service.findGender(Gender.WOMEN);
				for(Friend friend1 : list) {
					System.out.println(friend1.toString());
				}
			} else {
				System.out.println("end of prog.");
				break;
			}

		}
	}
}
