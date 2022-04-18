package co.edu.abstracts;

public abstract class Animal {
	// Animal() 생성자로 인스턴스 생성x
	public Animal() {
		
	}
	
	public abstract void eat(); // 강제로 eat() 구현하도록함.
	
	public abstract void run();
	
	public abstract void sleep();
}
