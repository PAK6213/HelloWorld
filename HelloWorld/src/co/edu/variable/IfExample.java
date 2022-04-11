package co.edu.variable;

public class IfExample {

	public static void main(String[] args) {
		int myAge = 29;
		boolean over20; // 변수의 길이는 상관 x 의미있는 변수명 필요.
		over20 = myAge > 20; // true
		if(over20) {
			System.out.println("over 20");
		} else {
			System.out.println("under 20");
		}
	}
}
