package co.test;

// 배열의 사용.
// 크기가 10인 배열에 1 ~ 10까지의 임의의 수를 저장.  
// 평균값보다 큰 값을 새로운 배열에 저장하도록 하세요.
public class Exam3 {
	public static void main(String[] args) {
		double [] doubleAry = new double[10];
		double [] newDoubleAry = new double[10];
		double sum = 0;
		double avg = 0;
		
		for(int i = 0; i < doubleAry.length; i++) {
			doubleAry[i] = (int)(Math.random()*10) + 1;
			sum = sum + doubleAry[i];
		}
		avg = sum / doubleAry.length;
		
		for(int i = 0; i < doubleAry.length; i++) {
			if(doubleAry[i] > avg) {
				newDoubleAry[i] = doubleAry[i];			
			}
		}
		
		
		System.out.println("평균값보다 큰 값의 새로운 배열 출력입니다.");
		for(int i = 0 ; i < newDoubleAry.length; i++) {
			System.out.printf("newDoubleAry[%d] = %.1f \n",i,newDoubleAry[i]);
		}
	
		
	}
}
