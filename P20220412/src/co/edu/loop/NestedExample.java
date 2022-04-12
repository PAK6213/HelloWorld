package co.edu.loop;

public class NestedExample {

	public static void main(String[] args) {
		// 구구단.
		//		for(int j = 2; j <= 9; j++) {
		//			for(int i = 1; i <= 9 ; i++) {
		//				System.out.println(j + " * " + i + " = " + (j*i));
		//			}
		//		}

		for(int j = 5 ; j>=1; j-- ) {	
			for(int i = 1; i <= j; i++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println();

         // p161  6번
		for(int i = 10; i >= 1; i--) {
			for(int j = 1; j <= 10; j++) {
				if(j < i) {
					System.out.print(" ");	
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		// p161 3번
//		int dice1;
//		int dice2;
//		boolean isTrue = true;
//		while(isTrue) {
//			dice1 = (int)(Math.random() * 6) + 1;
//			dice2 = (int)(Math.random() * 6) + 1;
//			System.out.printf("주사위의 눈은 (%d,%d)입니다.\n",dice1, dice2);
//			if(dice1 + dice2 == 5) {
//				isTrue = !isTrue;
//			}
//		}
//		
//		
//		// p161 4번
//		for(int x = 1; x <= 10; x++) {
//			for(int y = 1; y <= 10; y++) {
//				if((4*x)+(5*y)==60) {
//					System.out.println("4x + 5y = 60의 해는 (" + x + "," + y + ")");
//				}
//			}
//		}
		
	}
}
