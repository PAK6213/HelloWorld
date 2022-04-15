package co.test;

import java.util.InputMismatchException;
import java.util.Scanner;


// 종합.
// 클래스의 인스턴스와 배열의 활용.
// 친구의 소중한 정보를 관리하는 앱을 구현하세요.
// Exam4(친구정보) 클래스의 인스턴스를 저장, 수정(사용자이름을찾아서 그에 맞는 연락처를 수정), 삭제(이름 배열 null 삭제), 조회(이름) 처리.
public class Exam5 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Exam4[] exams = new Exam4[5];

		while (true) {
			System.out.println("1.추가 2.수정 3.삭제 4.조회(이름) 5.종료");
			System.out.print("선택>> ");
			int menu = -1;
			try {
				menu = scn.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("잘못된 처리를 시도했습니다.");
				continue;
			}
			scn.nextLine(); // 공백제거
			if(menu == 1) {
				System.out.print("친구의 이름을 입력하세요 :");
				String fname = scn.nextLine();
				System.out.print("친구의 생일을 입력하세요 :");
				String fbirthday = scn.nextLine();
				System.out.print("친구의 연락처를 입력하세요 :");
				String fphonenumber = scn.nextLine();
				
				for(int i = 0; i < exams.length; i++) {
					if(exams[i] != null && exams[i].getPhoneNumber().equals(fphonenumber)) {
						System.out.println("동일한 연락처가 입력되었습니다. 연락처를 다르게 입력해주세요.");
						break;
					}
					if(exams[i] == null) {
						Exam4 exam = new Exam4(fname,fbirthday,fphonenumber);
						exams[i] = exam;
						System.out.println("친구정보가 입력 되었습니다.");
						break;
					}
				}
			}else if(menu == 2) {  // 사용자 이름을 찾아서 그에 맞게 수정
				System.out.print("찾을 친구의 이름을 입력하세요 :");
				String findName = scn.nextLine();
				for(int i = 0; i < exams.length; i++) {
					if(exams[i].getName().equals(findName)) {
						System.out.print("수정할 연락처를 입력하세요 :");
						String modifyPhoneNumber = scn.nextLine();
						exams[i].setPhoneNumber(modifyPhoneNumber);
						System.out.print("수정완료.\n");
						break;
					}
				}
				
			}else if(menu == 3) {
				System.out.print("삭제할 친구의 이름을 입력하세요 :");
				String removeName = scn.nextLine();
				for(int i = 0; i < exams.length; i++) {
					if(exams[i].getName().equals(removeName)) {
						exams[i] = null;
						break;
					}
				}
			}else if(menu == 4) {
				Exam4[] exams2 = new Exam4[5];
				System.out.print("조회할 친구의 이름을 입력하세요 :");
				String searchName = scn.nextLine();
				for(int i = 0; i < exams.length; i++) {
					if(exams[i] != null && exams[i].getName().equals(searchName)) {
						for(int j = 0; j < exams2.length; j++) {
							if(exams2[j] == null) {
								exams2[j] = exams[i];
								break;
							}else {
								continue;							
							}
						}
						break;
					}
				}
				System.out.println("=====================================================");
				for (Exam4 exam: exams2) { // 참조형 변수  참조배열
					if(exam != null) { // board 객체의 주소가 있다면.
						exam.friendList();
					}
				}
				
			}else if(menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 숫자를 입력하였습니다. 다시 입력하세요.");
			}
		}
		System.out.println("end of prog.");
	}
}



