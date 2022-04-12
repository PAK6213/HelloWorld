package co.edu.loop;

import java.util.Scanner;

public class WhileHomework {

	public static void main(String[] args) {
		// 1. 임의의 값 범위( 1 ~ 6 : 주사위의 면의 갯수.)
//		      주사위 맞추기 게임.
//		   2. 임의의 값 범위( 1: 가위, 2: 바위, 3:보)
//		      사용자 입력값 : 가위(1) , 바위(2) , 보(3)
//		      이기는 경우 1=2  2=3  3=1 
//		      이외의 경우는 짐.
//		      가위 (1) -> You Win. You lose.
		
		
		Scanner scn = new Scanner(System.in);
		int dice;
		int answer;
		boolean isTrue = true;
		dice = (int)(Math.random()*6) + 1;
		while(isTrue) {
			System.out.print("주사위 숫자를 입력하세요:");
			answer = scn.nextInt();
			if(answer == dice) {
				System.out.printf("정답은 %d입니다.",answer);
				break;
			}
			System.out.println("틀렸습니다. 다시 입력하세요.");
		}
		
		/* 2번
		Scanner scn = new Scanner(System.in);
		int you , me;
		you = (int)(Math.random()*3) + 1;
		boolean isTrue = true;
	
		
		while(isTrue) {
			System.out.print("가위(1) 바위(2) 보(3) 중 하나를 고르십시오.");
			me = scn.nextInt();
			if(me == 1) {
				if(you == 3) {
					System.out.println("You Win. game over");
					break;
				} else {
					System.out.println("You Lose");
				}
			}
			
			if(me == 2) {
				if(you == 1) {
					System.out.println("You Win. game over");
					break;
				} else {
					System.out.println("You Lose");
				}
			}
			
			if(me == 3) {
				if(you == 2) {
					System.out.println("You Win. game over");
					break;
				} else {
					System.out.println("You Lose.");
				}
			}
			
		}
		System.out.printf("상대는 %d를 냈습니다." , you);*/
	}

}
