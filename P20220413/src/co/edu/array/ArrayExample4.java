package co.edu.array;

public class ArrayExample4 {

	public static void main(String[] args) {
		int[] intAry = new int[5];
		
		//int형 값  1 ~ 30 범위의 임의 값 .
		//반복문 활용 임의의 값 5개 저장
		for(int i = 0; i < intAry.length; i++) {
			intAry[i] = (int) (Math.random() * 30) + 1;
		}
		
	}

}
