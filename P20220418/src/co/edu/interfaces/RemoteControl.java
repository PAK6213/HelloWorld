package co.edu.interfaces;

// 인터페이스는 상수와 추상메소드를 가짐.

public interface RemoteControl {
	// 상수
	public static final int MAX_VOLUME = 10;
	
	public void turnOn(); // 추상메서드 
	public void turnOff();
	public void volumeUp();
	public void volumeDown();
	// default 메소드를 이용하면 인터페이스에서 구현부를 작성할 수 있다.
	// 클래스에서 구현하지 않아도 됨.
	public default void adjustScreen() {
		System.out.println("TV 화면을 조정합니다.");
	}
	
	// import 메소드는 인터페이스명.메소드명으로 호출가능하며 구현하는 클래스에서 꼭 구현하지 않아도 된다.
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
