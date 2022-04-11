package co.edu.variable;

public class Homework {

	public static void main(String[] args) {
		/* 원격 repository 클론해서 집에서도 동일한 repository를 생성
		   아래의 2문제의 기능을 구현하는 코드를 작성하고 commit & push 작업
		   내일 학원에서 pull하여 확인
		   오렌지 127개 10개씩 담을 수 있는 상자. 5개씩 담을 수 있는 상자.

		   영수증 물건의 가격과 현금
		   [현금] 10000원
		   [물건가격] 7500원
		   [부가세] 750원
		   [잔돈] 2500원
		 */


		int orange = 127;
		int tenbox, fivebox;

		tenbox = orange / 10;
		orange = orange % 10;

		fivebox = orange / 5;
		orange = orange % 5;

		System.out.printf("10개씩 담은 상자는 %d개이고, 5개씩 담은 상자는 %d개이고 남은 오렌지의 개수는 %d개이다.", tenbox, fivebox, orange);

	}

}
