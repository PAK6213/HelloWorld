package co.edu.condition;

public class IfExample4 {

	public static void main(String[] args) {
		// 임의의 값을 생성해주는 Math.random().
		int randomVal = (int)(Math.random() * 100) + 1; // 반환값이 double 0 ~ 1 사이의 실수 반환
		System.out.println(randomVal);
		
		// 생성된 값이 1 ~ 50 까지
	    // 생성된 값이 51 ~ 60  61 ~ 70  71 ~ 80  81 ~ 90 91 ~ 100
		
		if(randomVal > 90) {
			System.out.println("생성된 값은 91 ~ 100까지의 범위 값.");
		} else if(randomVal > 80) {
			System.out.println("생성된 값은 81 ~ 90까지의 범위 값.");
		} else if(randomVal > 70) {
			System.out.println("생성된 값은 71 ~ 80까지의 범위 값.");
		} else if(randomVal > 60) {
			System.out.println("생성된 값은 61 ~ 70까지의 범위 값.");
		} else if(randomVal > 50) {
			System.out.println("생성된 값은 51 ~ 60까지의 범위 값.");
		} else {
			System.out.println("생성된 값은 1 ~ 50까지의 범위 값.");
		}
	}
}
