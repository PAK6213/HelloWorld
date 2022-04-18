package co.edu.poly;

public class Tire {
	// 필드.
	public int maxRotation; // 타이어 최대 회전가능수(수명)
	public int accumulateRotation; // 현재까지 사용한 누적 회전수
	public String location; // 자동차의 타이어 위치
	
	// 생성자.
	public Tire (String location , int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	// 메소드.
	public boolean roll() {
		accumulateRotation++;
		if(accumulateRotation < maxRotation) {
			System.out.println(location + " Tire수명 " + (maxRotation-accumulateRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + " Tire 펑크 ***");
			return false;
		}
	}
}
