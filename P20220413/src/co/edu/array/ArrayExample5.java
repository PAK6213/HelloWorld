package co.edu.array;

import java.util.Scanner;

public class ArrayExample5 {

	public static void main(String[] args) {
		//학생 5명의 수학점수를 담을 배열을 만들고 
		Scanner scn = new Scanner(System.in);
		
		int[] scores = new int[5];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.print("학생 점수를 입력하세요:");
			scores[i] = scn.nextInt();
		}
		
		int maxscore = scores[0];
		int minscore = scores[0];
		
		// 학생중에서 최고점, 최저점, 
		for(int i = 1; i < scores.length; i++) {
			if(maxscore < scores[i]) {
				maxscore = scores[i];
			}
			if(minscore > scores[i]) {
				minscore = scores[i];
			}
		}
		
		System.out.printf("최고점은 %d점, 최저점은 %d점", maxscore, minscore);
		
		// 학생이름, 점수
		// 배열, 배열 선언 
		
	}

}
