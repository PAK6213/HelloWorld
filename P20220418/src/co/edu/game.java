package co.edu;
// 중복제거 방법
public class game {

	public static void main(String[] args) {
		int Ary[] = new int[5];
		Ary[0] = (int)(Math.random()*5) + 1;  // 배열의 첫번째 인덱스값에 1~5임의의 값 대입
		int count = 1; // 몇번째까지 비교할 것인지?
		int random = (int)(Math.random()*5) + 1;
		int flag = 0;  // 0 이면 넣어도됨 1이면 넣으면 안됨

		for(int i = 1; i < Ary.length; i++) {
			
			for(int j = 0; j < i ; j++) {
				if(Ary[j] == random) {
					j = 0;
					random = (int)(Math.random()*5) + 1;
				}
				if(j == i - 1) {
					Ary[j] = random;
				}
			}
		}

		for(int i = 0; i < Ary.length; i++) {
			System.out.println(Ary[i]);
		}
	}
}
