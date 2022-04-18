package co.edu.friend;

public class ComFriend extends Friend {
	// 필드
	private String companyName;
	private String department;

	// 생성자
		public ComFriend(String name, String phoneNumber, String companyName, String department) {
		super(name, phoneNumber);
		
		this.companyName = companyName;
		this.department = department;
	}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}
		
		
		@Override
		public String toString() {
			return "ComFriend [name=" + super.getName() + " phoneNumber: " + super.getPhoneNumber() +" companyName=" + companyName + ", department=" + department + "]";
		}
	

}
