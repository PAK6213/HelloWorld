package co.edu.api;

public class SystemExample {
	public static void main(String[] args) {
		System.out.println("start");
		//System.exit(0);  // 메인문 강제종료
		System.out.println("end");
		
		int sum = 0;
		
		long start = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			sum += i;
		}
		
		long end = System.nanoTime();
		System.out.println(end-start);
	}

}
