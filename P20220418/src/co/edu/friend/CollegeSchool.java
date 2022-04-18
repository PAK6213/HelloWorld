package co.edu.friend;

public class CollegeSchool extends Friend {
	// 필드
	private String colleagename;
	private String major;
	
	// 생성자
	public CollegeSchool (String name, String phone, String univ, String major) {
		super(name, phone);
		this.colleagename = univ;
		this.major = major;
	}

	public String getColleagename() {
		return colleagename;
	}

	public void setColleagename(String colleagename) {
		this.colleagename = colleagename;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "CollegeSchool [name=" + this.getName() + " phoneNumber: " + super.getPhoneNumber() +" colleagename=" + colleagename + ", major=" + major + "]";
	}
	
}
