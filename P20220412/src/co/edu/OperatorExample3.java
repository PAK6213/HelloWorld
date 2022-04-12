package co.edu;

public class OperatorExample3 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 20;
		
		if(num1 == num2) {
			System.out.println("같다");
		}
		if(num1 != num2) {
			System.out.println("다르다");
		}
		if(num1 >= num2) {
			System.out.println("num1이 같거나 크다");
		}
		if((num1 % 2 == 0) && ((num2 % 2  == 0))) {
			System.out.println("둘다 짝수");
		} else {
			System.out.println("두수가 짝수가 아님");
		}
		
		if((num1 % 2 == 0) || ((num2 % 2  == 0))) {
			System.out.println("하나이상 짝수");
		} else {
			System.out.println("두수가 홀수");
		}
		
		System.out.println("end of prog");
	}

}
