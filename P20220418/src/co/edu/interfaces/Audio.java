package co.edu.interfaces;

public class Audio implements RemoteControl {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Audio를 끕니다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("Audio의 Volmue를 올립니다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("Audio의 Volmue를 내립니다.");
	}
	

}
