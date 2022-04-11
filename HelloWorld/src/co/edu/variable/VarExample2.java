package co.edu.variable;

public class VarExample2 {

	public static void main(String[] args) {
		// 국어 80, 영어 70, 수학 63  평균 변수 선언, 
		int korea = 80;
		int english = 70;
		int math = 63;
		
		//국어 85 영어 75 수학 60
		korea = 85;
		english = 75;
		math = 60;
		
		double avg = (korea + english + math) / 3.0;
		System.out.println("국어점수는 " + korea + "점이고, 영어점수는 " + english + "점이고, 수학점수는 " + math + "점이다. 그리고 평균점수는 " + avg + "점이다.");
	}

}
