package co.edu.interfaces;

// 인터페이스 구현에서는 implements를 사용
public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV를 켭니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV를 끕니다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("TV의 Volume 올립니다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("TV의 Volume 내립니다.");
	}
	
	
	

}
