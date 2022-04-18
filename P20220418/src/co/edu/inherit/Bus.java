package co.edu.inherit;

public class Bus extends Car {
	//필드
	String busNo;
	
	// 생성자.
	public Bus () {
		super(); // 부모 기본 생성자 호출
		System.out.println("Bus() 생성자 호출");
	}
	
	// 메소드
	public void fee() {
		System.out.println("요금을 받습니다.");
	}
	@Override
	// 오버라이딩 (부모의 메서드를 자식클래스에서 그대로 가져와 수정하여 사용하는 것.)
	public void drive() {
		System.out.println("버스가 운행을 합니다.");
	}

	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", model= " + super.model + "]" ;
	}
}
