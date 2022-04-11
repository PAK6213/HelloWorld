package co.edu.variable;

import java.util.Scanner;

public class Score {

	public static void main(String[] args) {
			/* 점수를 3개 입력. 합, 평균, 고득점 합은 ##이고 평균은 ##이고 가장 큰 값은 ## 입니다.*/
		
		Scanner scn = new Scanner(System.in);
		int score1 , score2, score3;
		System.out.print("첫번째 점수를 입력하세요 :");
		score1 = scn.nextInt();
		System.out.print("두번째 점수를 입력하세요 :");
		score2 = scn.nextInt();
		System.out.print("세번째 점수를 입력하세요 :");
		score3 = scn.nextInt();
		
		int sum;
		double avg;
		int max;
		
		sum = score1 + score2 + score3;
		avg = (score1 + score2 + score3) / 3.0;
		
		if(score1 > score2) {
			max = score1;
		} else {
			max = score2;
		}
		
		if(max < score3) {
			max = score3;
		}
		
		System.out.printf("합은 %3d점이고 평균은 %.2f점이고 최고점은 %3d점입니다.",sum,avg,max);

	}

}
