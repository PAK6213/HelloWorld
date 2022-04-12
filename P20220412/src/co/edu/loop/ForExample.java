package co.edu.loop;

import java.util.Scanner;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		int gugudan = 15;



		for(int i=1; i <= 5 ; i++) {
			sum = sum + i;
		}
		System.out.println(sum);

		// 
		System.out.println("=============");
		for(int i = 1; i <= 9 ; i++) {
			System.out.printf("%d * %d = %d\n" ,gugudan, i , i*gugudan);
		}

		sum = 0;
		
		for(int i = 1 ; i <= 9 ; i=i+2) {  // 1 3 5 7 9 2씩증가
			sum = sum + i;
		}
		System.out.println("1,3,5,7,9의 합은 :" + sum);
		sum = 0;
		
		for(int i = 2 ; i <= 10 ; i=i+2) {  // 1 3 5 7 9 2씩증가
			sum = sum + i;
		}
		System.out.println("2,4,6,8,10의 합은 :" + sum);
		sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("짝수의 합은 :" + sum);
	}
}
