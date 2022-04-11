package co.edu.variable;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		/* 원격 repository 클론해서 집에서도 동일한 repository를 생성
		   아래의 2문제의 기능을 구현하는 코드를 작성하고 commit & push 작업
		   내일 학원에서 pull하여 확인
		   오렌지 127개 10개씩 담을 수 있는 상자. 5개씩 담을 수 있는 상자.
		 */

		Scanner scn = new Scanner(System.in);
		System.out.print("오렌지의 개수를 입력하세요 :");
		
		int orange;
		orange = scn.nextInt();
		int tenbox, fivebox;

		tenbox = orange / 10;
		orange = orange % 10;

		fivebox = orange / 5;
		orange = orange % 5;
		
		if(orange != 0)
		{
			fivebox = fivebox + 1;
		}

		System.out.printf("10개씩 담은 상자는 %d개이고, 5개씩 담은 상자는 %d개이다.", tenbox, fivebox);

	}

}
