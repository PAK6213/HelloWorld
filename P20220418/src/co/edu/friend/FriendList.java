package co.edu.friend;

import java.util.Scanner;

public class FriendList {

	public static void main(String[] args) {
		Friend [] friends = new Friend[10]; // Friend 참조타입 객체배열 생성
//		상수는 다시 값 변경 불가능
//		final String val = "Hong";
//		val = "Hong2"



		// 친구 3명의 종류에따라 등록방법이 달라져야함.
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1.친구등록 2.리스트 3.조회(이름) 4.종료");
			System.out.print("메뉴를 입력하세요: ");
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				Friend newFriend;
				System.out.print("이름을 입력하세요:");
				String name = scn.nextLine();
				System.out.print("연락처 입력하세요:");
				String phoneNumber = scn.nextLine();
				System.out.print("입력할 친구의 종류: ");
				String friendType = scn.nextLine();
				if(friendType.equals("College")) {

					System.out.print("대학명을 입력하세요:");
					String collegeName = scn.nextLine();
					System.out.print("전공을 입력하세요:");
					String major = scn.nextLine();
					//다형성 조상타입 Friend의 참조변수로 자손타입 CollegeSchool의 객체를 컨트롤 함.
					newFriend = new CollegeSchool(name, phoneNumber, collegeName, major);  

				} else if(friendType.equals("Company")) {
					System.out.print("회사명을 입력하세요:");
					String collegeName = scn.nextLine();
					System.out.print("부서를 입력하세요:");
					String major = scn.nextLine();
					//다형성 조상타입 Friend의 참조변수로 자손타입 ComFriend의 객체를 컨트롤 함.
					newFriend = new ComFriend(name, phoneNumber, collegeName, major);
				} else {
					newFriend = new Friend(name, phoneNumber);
				}
				for(int i = 0 ; i < friends.length; i++) {
					if(friends[i] == null) {
						friends[i] = newFriend;
						break;
					}
				}	
			} else if (menu == 2) {
				System.out.println("=====================================================");
				for(Friend friend : friends) {
					if(friend != null) {
						System.out.println("친구정보: " + friend.toString());
					}
				}
			} else if (menu == 3) {
				System.out.print("조회할 이름을 입력하세요:");
				String searchName = scn.nextLine();
				for(int i = 0 ; i < friends.length; i++) {
					if(friends[i] != null && friends[i].getName().equals(searchName)) {
						System.out.println("친구정보: " + friends[i].toString());
					}
				}

			} else if (menu == 4) {
				System.out.println("프로그램 종료.");
				break;
			}
		}
	}
}
