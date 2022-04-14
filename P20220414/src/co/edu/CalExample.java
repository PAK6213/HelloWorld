package co.edu;

public class CalExample {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		cal.printPI();
		cal.getArea(2.4);
		
		double result = cal.sum(7, 3);
		System.out.println(result);
		double result1 = cal.sum(2.4, 5);
		System.out.println(result1);
		double result2 = cal.getTrianglArea(3,5);
		System.out.printf("삼각형의 넓이는 %.2f입니다.\n", result2);
		
		int[] intAry = {10,20,30,40,50};
		int Arrresult = cal.sum(intAry);
		System.out.printf("배열요소의 합은 %d입니다.\n", Arrresult);
		
		result = cal.average(10,30,20,30);
		result1 = cal.average(10,20,30,510,513,8,1,8,1,3,8,1);
		
		System.out.println(result);
		System.out.println(result1);
	}

}
