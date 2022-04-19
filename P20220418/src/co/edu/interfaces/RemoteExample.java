package co.edu.interfaces;

public class RemoteExample {
	public static void main(String[] args) {
		/*/RemoteControl 인터페이스를 구현하는 Television클래스의 인스턴스 생성
		인터페이스의 규칙을 따라서 인스턴스를 생성하게 되면 각 인스턴스마다 메소드의 구현을 할 수 있으며
		개발코드의 큰 변경없이 다양하게 구현가능하다.
		추상클래스 vs 인터페이스
		추상클래스는 필드값(변수)와 추상메서드를가진다.
		인터페이스는 상수와 추상메소드를 가진다.*/
		RemoteControl rc = new Television();
		
		//rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.volumeDown();
		rc.volumeUp();
		
		RemoteControl.changeBattery();
	}
}
