package co.micol.geun.game;

import java.util.Scanner;

public class Mabangjin {
	private Scanner sc = new Scanner(System.in);

	public void run() {
		mabangjin();
	}


	public void mabangjin() {
		System.out.println("마방진 차수를 입력하세요(홀수)");
		int size = sc.nextInt();
		sc.nextLine();
		int num = 1;
		int[][] ary = new int[size][size];

		ary[0][size/2] = num;
		for(int i = 0 , j = size/2 ; num <= size * size; num++) {
			ary[i][j] = num;
			if(num % size == 0) {
				i++;
			}else {
				i--;
				j++;
				if(i < 0) i = size -1;
				if(j > size-1) j = 0;
			}
		}
		toPrint(ary);

	}
	
	private void toPrint(int[][] result) {
		for(int i = 0 ; i < result.length; i++) {
			for(int j = 0; j <result[i].length ; j++) {
				System.out.printf("[%2d]",result[i][j]);
			}
			System.out.println();
		}
	}
}
