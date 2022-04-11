package co.edu.variable;

import java.util.Scanner;

public class OperatorExample {

	public static void main(String[] args) {
		// 지폐 개수 파악
		int money;
		int fithou, tenthou, fivethou, thou, fivehun, hun, fifty , ten;
		
		Scanner scn = new Scanner(System.in);
		System.out.print("금액을 입력하세요 : ");
		money = scn.nextInt();
		
		fithou = money / 50000;  // 75300 / 50000 -> 1
		money = money % 50000; // 75300 % 50000 -> 25300
		
		tenthou = money / 10000; // 25300 / 10000 -> 2
		money = money % 10000; // 25300 % 10000 -> 5300
		
		fivethou = money / 5000;
		money = money % 5000;
		
		thou = money / 1000;
		money = money % 1000;
		
		fivehun = money / 500;
		money = money % 500;
		
		hun = money / 100;
		money = money % 100;
		
		fifty = money / 50;
		money = money % 50;
		
		ten = money /10;
		money = money % 10;
		
		money = 50000 * fithou + 10000 * tenthou + 5000 * fivethou + 1000 * thou + 500 * fivehun + 100 * hun + 50 * fifty + 10 * ten;
		
		System.out.printf("%d원의 금액은 5만원 %d개, 1만원 %d개, 5천원 %d개, 1천원 %d개, 5백원 %d개, 백원 %d개, 50원 %d개, 10원 %d개가 필요합니다." ,money, fithou ,tenthou, fivethou, thou, fivehun, hun, fifty, ten);
		
	}

}
