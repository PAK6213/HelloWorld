package co.edu.loop;

import java.util.Scanner;

public class AccountExample {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		int menu;


		while(run) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");

			menu = scanner.nextInt();
			if(menu == 1) {
				System.out.print("예금액> ");
				int money = scanner.nextInt();
				balance = balance + money;
				System.out.println(money + "원이 예금되었습니다.");
			} else if(menu == 2) {
				System.out.print("출금액> ");
				int money2 = scanner.nextInt();
				if(balance < money2) {
					System.out.println("잔고가 부족합니다.");
					continue;
				}
				balance = balance - money2;
				System.out.println(money2 + "원이 출금되었습니다.");
			} else if(menu == 3) {
				System.out.println("잔고> " + balance);
			} else if(menu == 4) {
				run = false;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다.");
			}
		}
		System.out.println("프로그램 종료");

	}

}
