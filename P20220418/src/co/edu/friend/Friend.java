package co.edu.friend;
// 친구의 주소록 : 이름, 연락처
// 학교친구 : 학교이름, 전공
// 회사친구 : 회사이름, 부서
public class Friend {
	// 필드
	private String name;  // 이름
	private String phoneNumber; // 연락처
	
	// 생성자
	public Friend(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Friend [name= " + name + ", phoneNumber=" + phoneNumber + "]";
	}

}
