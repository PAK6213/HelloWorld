package co.edu.condition;

public class IfExample {

	public static void main(String[] args) {
		int score = 85;
		// 90점크면 A 80크면 B 70크면 C 나머지F
		if(score >= 90) {
			System.out.println("A");
		} else if(score >= 80) {
			System.out.println("B");
		} else if(score >= 70) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}
		// 구분 .

		if(score >= 90) {
			System.out.println("A");
		}
		if(score >= 80 && score < 90) {
			System.out.println("B");
		}
		if(score >= 70 && score < 80 ) {
			System.out.println("C");
		}
		if(score < 70) {
			System.out.println("F");
		}
	}
}
