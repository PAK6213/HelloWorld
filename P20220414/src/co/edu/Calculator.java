package co.edu;

public class Calculator {
	// 필드
	private double pi = 3.14;
	
	// 메서드(리턴타입 X)
	void printPI() {
		System.out.println("원주율은 " + pi + "입니다.");
	}
	
	void getArea(double radius) {
		double area = radius * radius * pi;
		System.out.println("반지름" + radius + "의 넓이는 " + area);
	}
	
	
	// 메서드(리턴타입 O)  
	int sum(int num1, int num2) {
		return num1 + num2;
	}
	//오버로딩 : 동일한 이름의 메서드를 여러개 정의하는 것. ( 매개변수의 타입 또는 개수가 달라야한다.)
	double sum(double num1, double num2) {
		return num1 + num2;
	}
	
	// 밑변과 높이를 입력 => 삼각형의 넓이를 계산하는 메소드 . getTrianglArea
	double getTrianglArea(double a , double b ) {
		return (a * b) / 2;
	}
	
	// 매개변수 타입에는 참조형 변수(클래스, 배열)도 올 수 잇다
	int sum(int[] ary) {
		int result = 0;
		for(int i = 0; i < ary.length; i++) {
			result = result + ary[i];
		}
		return result;
	}
	
	double average(int num1, int num2, int num3, int num4) {
		return (num1 + num2 + num3 + num4) / 4.0;
	}
	// 매개변수의 개수에 상관없이 받아 오겠다.
	double average(int... args) {
		int result = 0;
		for(int i = 0; i < args.length; i++) {
			result = result + args[i];
		}
		return (double)result / args.length;
	}
}
