package co.edu.condition;

public class CondExample {

	public static void main(String[] args) {
		// 임의 값: Math.random() 
		// 51 ~ 100 까지의 임의 값.
		// 100 ~ 90 A  ~ 80 B ~ 70 C 
		int randomVal;
		randomVal = (int)(Math.random() * 50) + 51; // 0 ~ 0.99999 * 50 -> 0 ~ 49.xxxxxx -> 0 + 51 ~ 49 + 51  51 ~ 100
		System.out.printf("점수는 %d 점입니다.\n", randomVal);
		randomVal = randomVal / 10;
		
		switch(randomVal) {
		case 10 :
		case 9 :
			System.out.println("A학점입니다.");
			break;
		case 8 :
			System.out.println("B학점입니다.");
			break;
		case 7 :
			System.out.println("C학점입니다.");
			break;
		default :
			System.out.println("F학점입니다.");
			break;
		}
	}

}
