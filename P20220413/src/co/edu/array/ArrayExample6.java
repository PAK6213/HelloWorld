package co.edu.array;

import java.util.Scanner;
//학생이름, 점수
// 배열, 배열 선언 
public class ArrayExample6 {

	public static void main(String[] args) {
		/*
		Scanner scn = new Scanner(System.in);
		
		String[] names = new String[3];
		int[] scores = new int[3];
		
		for(int i = 0; i < names.length; i++) {
			
			System.out.print("학생의 이름을 입력하세요.");
			names[i] = scn.nextLine();
			
			System.out.print("학생의 점수을 입력하세요.");
			scores[i] = scn.nextInt();
			scn.nextLine();
		}
		
		System.out.println("조회할 학생이름 입력 :");
		String searchName = scn.nextLine();
		
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals(searchName)) {
				System.out.printf("%s 학생의 점수는 %d점입니다.\n", names[i], scores[i]);
			}
		}
		System.out.println("end of prog.");
	*/
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------------");
			System.out.println("1.학생수|2.점수입력|3.점수리스트|4.분석|5.종료");
			System.out.println("-----------------------------------");
			System.out.print("선택> ");
			int selectNo = Integer.parseInt(scanner.nextLine()); // 엔터키까지 처리
			
			if(selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			}
			if(selectNo == 2) {
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d]> ",i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			}
			if(selectNo == 3) {
				if(scores == null) {
					System.out.println("학생수와 점수가 입력되지 않았습니다.");
					continue;
				}
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("score[%d]> %d\n", i, scores[i]);
				}
				
			}
			if(selectNo == 4) {
				if(scores == null) {
					System.out.println("학생수와 점수가 입력되지 않았습니다.");
					continue;
				}
				int maxVal, sum;
				maxVal = sum = 0; // 변수초기화.
				for (int i = 0 ; i < scores.length; i++) {
					sum += scores[i];
					//최고점수 계산.
					if(scores[i] > maxVal) {
						maxVal = scores[i];
					}
				}
				System.out.println("최고 점수 :" + maxVal);
				System.out.printf("평균 점수: %.2f\n", (double)sum/scores.length);
			}
			if(selectNo == 5) {
				run = !run;
			}
		}
		
		System.out.println("프로그램 종료");
	}
}
