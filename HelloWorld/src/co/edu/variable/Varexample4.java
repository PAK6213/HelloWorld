package co.edu.variable;

public class Varexample4 {

	public static void main(String[] args) {
		// 영어 80  수학 70 영어 > 수학
		
		int english = 80;
		int math = 70;
		
		boolean score = english > math;
		if(score) {
			System.out.println("영어점수 " + english + "점이 수학점수 " + math + "점보다 큽니다.");
		}
	}

}
