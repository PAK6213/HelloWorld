package co.edu.abstracts;

public class Bird extends Animal {  // 반드시 추상메서드의 메서드를 구현해야 오류가안남.
	public void eat() {
		System.out.println("새가 먹이를 먹습니다.");
	}
	
	public void run() {
		System.out.println("새가 날아갑니다.");
	}

	public void sleep() {
		System.out.println("새가 잡니다.");
	}
}
