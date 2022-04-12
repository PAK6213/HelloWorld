package co.edu.condition;

public class IfExample2 {

	public static void main(String[] args) {
		int num = 36;

		// 2의 배수, 3의 배수, 2와 3의 공통 배수인지 check  공통배수인경우 2,3 공통배수 먼저 출력
		// 
		if(num % 2 == 0 && num % 3 == 0) {
			System.out.printf("%d는 2와 3의 공통배수 입니다.", num);
		} else if (num % 2 == 0) {
			System.out.printf("%d는 2의 배수 입니다.", num);
		} else if (num % 3 == 0) {
			System.out.printf("%d는 3의 배수 입니다.", num);
		} else {
			System.out.printf("%d는 2와 3의 배수가 아니다.", num);
		}
	}
}
