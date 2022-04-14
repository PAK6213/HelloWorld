package co.edu;
//객체 -> 도면 -> 텔레비전(쌈성, 엘지)
//Object -> Class -> instance
//추상화(텔레비전의 모든 속성 -> 필요한 부분만 사용)

//클래스는 설계도이다. instance를 만들기위해 사용
public class Television {
	//속성  -> 필드!!
	String company;
	String model;
	int price;
	String color;
	
	//기능 -> 메서드(반환유형, 메소드명, 매개변수) 3개의 정보가 정해져야한다. !!
	void turnOn() {
		System.out.println("텔레비젼을 켭니다.");
	}
	
	void turnOff() {
		System.out.println("텔레비젼을 끕니다.");
	}
	
	void changeChannel(int channel) {
		System.out.println(channel + "번 채널로 변경합니다.");
	}
	
}
