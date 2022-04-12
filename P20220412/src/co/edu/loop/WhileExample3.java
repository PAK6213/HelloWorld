package co.edu.loop;

import java.util.Scanner;

public class WhileExample3 {

	public static void main(String[] args) {
		// Math.random()의 생성범위 1 ~ 10까지가 되도록
		// 사용자의 입력값을 담는 변수 randomVal
		// while 구문을 사용해서 임의의 값이랑 입력값이 같으면 종료
		// 사용자 값 비교 랜덤값이랑  비교.... 입력한 랜덤값과 비교하여 크다 작다를 출력
		Scanner scn = new Scanner(System.in);
		boolean isTure = true;
		int randomVal;
		int userVal = 0;
		randomVal = (int)(Math.random() * 10000) + 1;
		
		

		while(isTure) {
			System.out.print("답을 입력하세요 :");
			userVal = scn.nextInt();
			
			if(randomVal == userVal) {
				System.out.println("정답입니다.");
				break;
			} else if(randomVal > userVal) {
				System.out.println("입력하신값은 정답보다 작습니다.");
			} else if(randomVal < userVal) {
				System.out.println("입력하신값은 정답보다 큽니다.");
			}
		}
	}
}
