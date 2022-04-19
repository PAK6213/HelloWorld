package co.edu;

import java.util.Scanner;

// 중복제거 방법
public class game {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);	

		int number = 0;
		int answer = 0;
		int[] open = new int[5];
		for(int i = 0; i < open.length; i++) {
			open[i] = 0;
		}
		int[] Answer = new int[5];

		for(int i = 0; i < Answer.length; i++) {
			Answer[i] = (int)(Math.random()*5) + 1;
			for(int j = 0 ; j < i; j++) {
				if(Answer[i] == Answer[j]) {
					i--;
				} 
			}
		}

		System.out.print("찾을 숫자를 입력하세요. :");
		number = scn.nextInt();
		for(int i = 0; i < Answer.length; i++) {
			if(open[i] == 0) {
				System.out.printf("[*]");
			}
		}
		System.out.println();


		for(int i = 0 ; i < Answer.length; i++) {
			System.out.print("열어볼 카드를 입력하세요 :");
			answer = scn.nextInt();  // 3
			if(Answer[answer-1] == number) {
				open[answer-1] = Answer[answer-1];
				for(int j = 0; j < Answer.length; j++) {
					if(open[j] == 0) {
						System.out.printf("[*]",open[j]);

					} else {
						System.out.printf("[%d]",open[j]);
					}
				}
				System.out.println();
				System.out.printf("%d번째 카드입니다.\n",answer);
				break;
			} else {
				open[answer-1] = Answer[answer-1];

				for(int k = 0; k < Answer.length; k++) {
					if(open[k] == 0) {
						System.out.printf("[*]");

					} else {
						System.out.printf("[%d]",open[k]);
					}
				}
				System.out.println();
			}



		}


	}








	/*int Ary[] = new int[5];
		Scanner scn = new Scanner(System.in);	
		int answer = 0;

		for(int i = 0; i < Ary.length; i++) {
			Ary[i] = (int)(Math.random()*5) + 1;
			for(int j = 0 ; j < i; j++) {
				if(Ary[i] == Ary[j]) {
					i--;
				} 
			}
		}
		// 맞추기 구현
		for(int i = 0; i < Ary.length; i++) {
			System.out.printf("5를 입력하세요: ", i+1);
			answer = scn.nextInt();
			if(Ary[i] == answer) {
				System.out.printf("%d번째에 맞췄습니다.\n" , i+1);
				break;
			} else {
				System.out.println("틀렸습니다.");
			}
		}
		for(int i = 0; i < Ary.length; i++) {
			System.out.println(Ary[i]);
		}*/
}


