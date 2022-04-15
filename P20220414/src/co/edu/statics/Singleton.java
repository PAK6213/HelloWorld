package co.edu.statics;
// Singleton : 단 하나의 객체만 생성되게 한다.
public class Singleton { 
	
	private static Singleton singleton = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
}
// 클래스는 public default만 가능
class Car {
	Car () {
		
	}
}
