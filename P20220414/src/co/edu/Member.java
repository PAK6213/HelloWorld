package co.edu;

public class Member {
	// 필드 => 회원ID , 회원이름, 회원연락처, 회원나이
	// private으로 필드에 직접 변수에 접근하는 것을 막는다.
	private String memberID;
	private String memberName;
	private String memberPhone;
	private int memberAge;  // - 값이 들어가면 안됨.
	
	// 생성자
	Member () {
		
	}
	
	public Member(String memberID, String memberName, String memberPhone, int memberAge) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAge = memberAge;
	}
		
	// 메서드
	void showInfo() {
		System.out.println("회원ID는 " + memberID + "이고 회원이름은 " + memberName + "이고 회원연락처는 " + memberPhone + "이고 회원나이는 " + memberAge + "입니다.");
	}
	
	void setMemberAge(int age) {
		if(age < 0) {
			memberAge = 10;
		} else {
			memberAge = age;
		}
	}
	
	int getMemberAge() {
		return this.memberAge;
	}
	//this 지역변수와 멤버변수의 구분을 위해 사용
	void setMemberId(String memberID) {
		this.memberID = memberID;
	}
	
	String getMemberId() {
		return this.memberID;
	}
	
	String getMemberName() {
		return this.memberName;
	}
	
	void setmemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

}
