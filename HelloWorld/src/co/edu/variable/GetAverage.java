package co.edu.variable;

import java.util.Scanner;

public class GetAverage {

	public static void main(String[] args) {
		// 입력값을 num1 , num2, num3 를 정수값으로 받고 
		Scanner scn = new Scanner(System.in);
		String myName = "박근형";
		int age = 29;
		int num1, num2, num3;
		System.out.print("첫 번째 정수를 입력하세요 :");
		num1 = scn.nextInt();
		System.out.print("두 번째 정수를 입력하세요 :");
		num2 = scn.nextInt();
		System.out.print("세 번째 정수를 입력하세요 :");
		num3 = scn.nextInt();
		
		double avg;
		avg = (num1 + num2 + num3)/3.0;
		System.out.printf("결과값 : 입력한 세 정수는 %2d, %2d, %2d 이고 평균은 %.2f 입니다.", num1,num2,num3,avg);
		System.out.println();
		System.out.printf("이름은 %3s이고 평균은 %.2f이고 나이는 %5d이다.", myName, avg, age);
	}
}
