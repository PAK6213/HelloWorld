package co.edu.nested;

import java.util.Scanner;

class Friend {
	String name;
	String phone;
	int age;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Friend(String name, String phone, int age) {
		super();
		this.name = name;
		this.phone = phone;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", phone=" + phone + ", age=" + age + "]";
	}

}
// 중첩클래스, 중첨인터페이스
public class NestedApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friend = new Friend[10];
	// 중첩 인터페이스
	interface FriendService {
		int ADD = 1;
		int MOD = 2;
		int LIST = 3;

		void add();
		void modify();
		void list();
	}

	// 중첩클래스
	static class FriendApp implements FriendService {
		@Override
		public void add() {
			// TODO Auto-generated method stub
			System.out.println("이름>>");
			String name = scn.nextLine();
			System.out.println("연락처>>");
			String phone = scn.nextLine();
			System.out.println("나이>>");
			int age = scn.nextInt();

			Friend friend = new Friend(name,phone,age);


		}
		// 배열에 비어있는 위치에 저장.


		@Override
		public void modify() {
			// TODO Auto-generated method stub
			System.out.println("찾을 이름을 입력하세요.");
			String name = scn.nextLine();

			for(int i = 0; i < friend.length; i++) {
				if(friend[i] != null && friend[i].getName().equals(name)) {
					System.out.println("변경할 연락처를 입력하세요.");
					String phone = scn.nextLine();
					friend[i].setPhone(phone);
					break;
				}
			}

		}

		@Override
		// 배열에 저장되어 있는 값 출력
		public void list() {
			for(int i = 0; i < friend.length; i++) {
				if(friend[i] != null) {
					System.out.println(friend[i].toString());
					break;
				}
			}
			// TODO Auto-generated method stub

		}
	}

	public static void main(String[] args) {
		FriendApp app = new FriendApp();

		while(true) {
			System.out.println("1.추가 2.수정 3.조회");
			System.out.print("메뉴를 입력하세요: ");
			int menu = scn.nextInt();
			scn.nextLine();

			if(menu == 1) {
				app.add();
			} else if(menu == 2) {
				app.modify();
			} else if(menu == 3) {
				app.list();
			}

		}
	}

}