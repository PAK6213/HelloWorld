package co.edu.variable;

import java.util.Scanner;

public class ChangeCtoF {

	public static void main(String[] args) {
		// Scanner 클래스활용 화씨온도를 입력하면 섭씨온도를 계산출력. 소수 첫번째자리 까지 출력
		//c = 5/9*(f-32) 
		
		double c;
		double f;
		Scanner scn = new Scanner(System.in);
		System.out.println("화씨온도를 입력하세요 :");
		f = scn.nextDouble();
		
		c = (double)5/9*(f-32);
		System.out.printf("계산된 섭씨 온도는 %.1f 입니다.", c);

		
	
		
	}

}
