package co.edu.condition;

public class IfExample3 {

	public static void main(String[] args) {
		// 중첩 구문
		// 90 점이상 A 80점 이상 B 70점 이상 C 그외에 F
		int score = 88;
		
		if (score >= 90) {
			if(score >= 95) {
				System.out.println("A+");
			}else {
				System.out.println("A");
			}
			
			if(score >= 80) {
				if(score >= 85) {
					System.out.println("B+");
				} else {
					System.out.println("B");
				}				
				if(score >= 70 && score < 80) {
					if(score >= 75) {
						System.out.println("C+");
					} else {
						System.out.println("C");
					}					
					if(score < 70) {
						System.out.println("F");
					}
				}
			}
		}
	}
}
