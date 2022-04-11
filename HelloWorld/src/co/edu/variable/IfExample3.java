package co.edu.variable;
import java.util.Scanner;

public class IfExample3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num1, num2;

		System.out.println("첫 번째 정수를 입력하세요.");
		num1 = scn.nextInt();  // 사용자 입력 값을 읽고 int형 반환

		System.out.println("두 번째 정수를 입력하세요.");
		num2 = scn.nextInt();  // 사용자 입력 값을 읽고 int형 반환

		int result;
		// 큰 수에서 작은 수를 뺀 결과값을 result에 저장
		if(num1 > num2) {
			result = num1 - num2;
			System.out.println("큰 수에서 작은 수를 뺀 값은:" + result + "입니다.");
		} else {
			result = num2 - num1;
			System.out.println("큰 수에서 작은 수를 뺀 값은:" + result + "입니다.");
		}
	}
}
