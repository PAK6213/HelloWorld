package co.edu.abstracts;

public class Main {
	public static void main(String[] args) {
		// 추상클래스는 1. 인스턴스를 생성할 수 없다.
		// 2. 추상메서드를 반드시 구현해야한다.
		Animal animal = null;  
		animal = new Bird();
		animal.eat();
		animal.run();
		animal.sleep();
		
		animal = new Fish();
		animal.eat();
		animal.run();
		animal.sleep();
	}

}
