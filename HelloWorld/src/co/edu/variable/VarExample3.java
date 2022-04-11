package co.edu.variable;

public class VarExample3 {

	public static void main(String[] args) {
		{
			int age = 20;
			System.out.println("나이는 " + age);
		}
		int age = 26;
		System.out.println("나이는 " + age);
		
		// 조건문 if
		boolean isTrue = true;
		isTrue = false;
		isTrue = age > 20 ;
		
		if(isTrue) {
			System.out.println(age + "는 20보다 큽니다.");
		}
	}
}
