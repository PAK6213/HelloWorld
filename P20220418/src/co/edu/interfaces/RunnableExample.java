package co.edu.interfaces;

interface Runnable {
	public void run();
}

class RunClass implements Runnable {
	@Override
	public void run () {
		System.out.println("움직입니다.");
	}
}

public class RunnableExample {
	public static void main(String[] args) {
		Runnable runnable = new RunClass();
		runnable.run();
		// 익명 구현객체 : 인터페이스를 클래스생성없이 객체로 생성하여 사용하겠다.
		runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("멍멍이가 달립니다.");
			}
			
		};
		runnable.run();
		// 람다 표현 방식 (익명 구현객체)
		runnable = () -> System.out.println("멍멍이2가 달립니다.");			
		runnable.run();
	}

}
