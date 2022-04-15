package co.edu.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.edu.Board;

public class AccountApp {
	Scanner scn = new Scanner(System.in);
	// 계좌정보를 저장하기위한 객체배열 100개짜리
	Account[] accounts = new Account[100];

	public void execute() {
		while(true) {
			System.out.println("1. 계좌 생성 2.입금 3. 출금 4.목록 조회 5.종료\n");
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
				createAccount();
			}else if(menu == 2) {
				deposit();
			}else if(menu == 3) {
				withdraw();
			}else if(menu == 4) {
				accountList();
			}else if(menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else {
				System.out.println("잘못된 숫자를 입력하였습니다. 다시 입력하세요.");
			}
		}
		System.out.println("end of prog.");
	}

	// 계좌생성 시 실행 메소드
	public void createAccount() {
		System.out.print("계좌번호 : ");
		String aNum = scn.nextLine();
		System.out.print("예금주 : ");
		String aName = scn.nextLine();
		System.out.print("초기 입금액 : ");
		int inimoney = scn.nextInt();
		scn.nextLine();

		if(inimoney < 0) {
			System.out.println("입금금액이 올바르지 않습니다. ");	
		} else {


			for(int i = 0; i < accounts.length; i++) {
				if(accounts[i] != null && accounts[i].getAccountNumber().equals(aNum)) {
					System.out.println("중복된 계좌번호 입니다. 다시입력하세요");
					continue;
				}
				if(accounts[i] == null) {
					Account a = new Account(inimoney, aName, aNum);
					accounts[i] = a;
					System.out.println("계좌가 생성되었습니다.");
					break;
				}
			}
		}
	}

	// 입금처리를 실행할 메소드
	public void deposit() {
		System.out.print("계좌번호 :");
		String searchAccountNumber = scn.nextLine();
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i].getAccountNumber().equals(searchAccountNumber)) {
				System.out.print("예금액 :");
				int depositMoney = scn.nextInt();
				if(depositMoney > 1000000) {
					System.out.println("1일한도 금액을 초과하였습니다.");
					break;
				}
				depositMoney = depositMoney + accounts[i].getMoney();
				accounts[i].setMoney(depositMoney);
				System.out.println("결과: 예금이 성공되었습니다.");
				break;
			}
		}	

	}
	// 출금처리를 할 메소드
	public void withdraw() {
		System.out.println("계좌번호 :");
		String searchAccountNumber = scn.nextLine();
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i].getAccountNumber().equals(searchAccountNumber)) {
				System.out.println("출금액 :");
				int depositMoney = scn.nextInt();
				// 잔액이 부족한경우 출금이 되지않도록 함.
				if(depositMoney > accounts[i].getMoney()) {
					System.out.println("잔액이 부족합니다.");
					break;
				}
				depositMoney = accounts[i].getMoney() - depositMoney;
				accounts[i].setMoney(depositMoney);
				System.out.println("결과: 출금이 성공되었습니다.");
				break;
			}
		}	
	}

	// 전체 목록 실행 메소드
	public void accountList() {
		System.out.println("======");
		System.out.println("계좌목록");
		System.out.println("======");
		for (Account board : accounts) { // 참조형 변수  참조배열
			if(board != null) { // board 객체의 주소가 있다면.
				board.getInfo();
			}
		}
	}
}
