package co.edu.loop;
import java.util.Scanner;

public class WhileExample2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean isTrue = true;
		int sum = 0;
		
		// 200이 넘게 되면 반복문 종료 후 출력
		while(isTrue) {
			int i = 0;
			System.out.print("숫자를 입력 하세요:");
			i = scn.nextInt();
			sum = sum + i;
			if(sum > 200) {
				isTrue = !isTrue;
			}
		}
		System.out.println("결과: " + sum);
	}
}
