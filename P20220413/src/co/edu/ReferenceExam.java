package co.edu;

import java.util.Scanner;

public class ReferenceExam {

	public static void main(String[] args) {
		
		// 기본타입
		int num1 = 100;
		int num2 = 100;
		if(num1 == num2) {
			System.out.println("같은 값.");
		} else {
			System.out.println("다른 값.");
		}
		
		// 참조타입
		Scanner scn = new Scanner(System.in);
		String str1 = new String("홍길동");  // 인스턴스의 주소값 1
		String str2 = new String("홍길동");  // 인스턴스의 주소값 2 
		//if(str1 == str2)  -> str1 str2의 각 인스턴스의 주소값을 비교하는 것이다. 실제값을 비교하는것이 아님.
		str1 = null; // 인스턴스의 주소값이 NULL로 되어 연결이 끊어짐.
		str1 = "김길동";
		if(str1.equals(str2)) {
			System.out.println("같은 값.");
		} else {
			System.out.println("다른 값.");
		} 
	}

}
