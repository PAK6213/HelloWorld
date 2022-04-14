package co.edu;

import java.util.Scanner;

public class MemberEx {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		 // 객체 배열을 생성하여 3개의 객체를 만들어 주소를 각 저장.
		 // 아직 객체를 생성안했으므로 생성하고 사용해야함.
		Member[] members = new Member[3];
		// members.length = 3
		for(int i = 0; i < members.length; i++) {
			System.out.println("아이디 이름 연락처 나이 입력.");
			
			String id = scn.next(); // 스페이스 기준으로 앞의 값을 읽어옴.
			String name = scn.next();
			String phone = scn.next();
			int age = Integer.parseInt(scn.next()); // 가져온 문자열을 int로 변환
			// Member 객체를 생성하고 입력한 값들을 이용하여 초기화하여 newMember 참조변수에 주소값을 저장
			Member newMember = new Member(id, name, phone, age);  
			// newMember의 참조변수에 저장된 주소값을 members 객체배열에 저장.
			members[i] = newMember;
		}
		
		// 1. 조회(이름)
		// 2. 변경(아이디, 연락처) 아이디로 해당하는것을 찾아 연락처를 변경 
		// 3. 조회(입력한 나이보다 큰 회원만 조회)
		// 4. 종료.
		while(true) {
			System.out.println("1. 조회(이름) 2. 변경(아이디, 연락처) 아이디로 해당하는것을 찾아 연락처를 변경 3. 조회(입력한 나이보다 큰 회원만 조회) 4. 종료.");
			System.out.print("선택> ");
			int menu = scn.nextInt();
			scn.nextLine();  // 메뉴와 엔터키 까지 처리
			 // 비교할대상1.equals(비교할대상2)
			if(menu == 1) {
				System.out.println("조회하실 이름을 입력하세요:");
				String name = scn.nextLine();
				
				// 1
				for(Member member : members) {
					if(name.equals(member.getMemberName())) {
						member.showInfo();
					}
				}		
				//2
				for(int i = 0; i < members.length; i++) {
					if(name.equals(members[i].getMemberName())) {
						members[i].showInfo();
					}
				}
			} else if(menu == 2) {
				System.out.println("연락처를 변경하실 아이디를 입력하세요:");
				String id = scn.nextLine();
				for(int i = 0; i < members.length; i++) {
					if(id.equals(members[i].getMemberId())) {
						System.out.println("변경하실 연락처를 입력하세요.:");
						String memberPhone = scn.nextLine();
						members[i].setmemberPhone(memberPhone);
					}
				}
			} else if(menu == 3) {
				
				System.out.println("나이를 입력하세요:");
				int age = scn.nextInt();
				for(int i = 0; i < members.length; i++) {
					if(age < members[i].getMemberAge()) {
						members[i].showInfo();
					}
				}
				
			} else if(menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				for(Member member : members) {
					member.showInfo();
			}
			
		}
		
		// 
	
		}
		System.out.println("end of prog.");
	}

}
