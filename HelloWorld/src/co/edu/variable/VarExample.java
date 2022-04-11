package co.edu.variable;

public class VarExample {

	public static void main(String[] args) {
		int age = 20;
		double height = 123.23;
		String myName = "박근형";
		
		age = 23;
		System.out.println("이름은 " + myName);
		System.out.println("나이는 " + age + "살 입니다.");
		System.out.println("키는 " + height + "cm 입니다.");
		
		// 영어점수 : 85; engScore 할당
		int engScore = 85;
		int mathScore = 90;
		int result = engScore + mathScore;
		
		engScore = 133;
		mathScore = 1234;
		result = engScore + mathScore;
		System.out.println("영어점수 " + engScore + "과 수학점수 " + mathScore + "의 합은 " + result + "입니다.");
		
	
	}

}
