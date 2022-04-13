package co.edu.dimension;

public class ArrayExample {

	public static void main(String[] args) {
//		int[][] intAry = new int[4][3];
//
//		intAry[0][0] = 10;
//		intAry[1][0] = 20;
//		intAry[3][2] = 100;
//		for(int j=0 ; j < intAry.length; j++) {		
//			for(int i = 0; i < intAry[j].length ; i++) {
//				System.out.printf("[%d][%d] => %d",i,j, intAry[j][i]);
//			}
//			System.out.println();
//		}
		

		int[][] intAry = new int[5][5];
		int count = 1;
		for(int i = 0; i < intAry.length; i++) {
			for(int j = 0; j < intAry[i].length; j++) {
				intAry[i][j] = count;
				count++;
			}
		}
		
		
		for(int i = 0; i < intAry.length; i++) {
			for(int j = 0; j < intAry[i].length; j++) {
				System.out.printf("%3d",intAry[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < intAry.length; i++) {
			for(int j = 0; j < intAry[i].length; j++) {
				System.out.printf("%3d",intAry[j][i]);
			}
			System.out.println();
		}
		// 배열에서는 인덱스 주소값으로 값을 지정.
		System.out.println();
		for(int i = 4; i >= 0; i--) {
			for(int j = 0; j < 5; j++) {
				System.out.printf("%3d",intAry[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
		for(int i = 0; i <= 4; i++) {
			for(int j = 4; j >= 0; j--) {
				System.out.printf("%3d",intAry[i][j]);
			}
			System.out.println();
		}

	}

}
