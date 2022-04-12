package co.edu.loop;

public class ForExample3 {

	public static void main(String[] args) {
		// 1 ~ 100 번 반복.
		// 최초로 1000 보다 큰 값중 최소값을 구하는, 
		int sum = 0;
		for(int i = 1 ; i <= 50; i++) {
			sum = sum + i;
			if(sum > 1000) {
				System.out.println("1000보다 큰 최소합계: " + sum + ", 순번: " + i );
				break;
			}
		}
		
		// 1 ~ 10번을 반복    sum = sum * i
		sum = 1;
		for(int i = 1; i <= 10; i++) {
			sum = sum * i;
		}
		System.out.println("1~10까지 곱한 값 : " + sum);
		
		// 숫자 1000의 약수를 출력 
		for(int i = 1; i <= 1000; i++) {
			if(1000 % i == 0) {
				System.out.println(i);
			}
		}
	}
}
