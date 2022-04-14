package co.edu;

public class Student {
	//필드 -> 데이터
	String name;
	String studNo;
	int age;
	double height;
	
	
	//생성자 -> 인스턴스를 만들어줄 떄 처리할 기능 정의.
	//매개값이 없는 생성자를 기본 생성자이다. 생성자가 정의되어 있지 않으면 컴파일러가 기본 생성자를 추가.
	//다른 생성자가 생성 된 경우에는 기본 생성자를 자동으로 추가하지 않는다
	//반환타입, 매개값이 없다. 

	public Student() {
		
	}
	// 생성자는 필드의 값을 지정할 때 많이 사용.
	public Student(String nm, String sn) {
		name = nm;
		studNo = sn;
		
	}
	
//	public Student(String nm, String sn, int ag, double hei) {
//		name = nm;
//		studNo = sn;
//		age = ag;
//		height = hei;
//	}
	
	public Student(String name, String studNo, int age, double height) {
		super();
		this.name = name;
		this.studNo = studNo;
		this.age = age;
		this.height = height;
	}
	//메서드 -> 기능
	void study() {
		System.out.println(name + "가 공부를 합니다.");
	}
	
	void eat() {
		System.out.println(name + "가 식사를 합니다.");
	}
	
	void showInfo() {
		System.out.println("이름은 " + name + "이고 학생번호는 " + studNo + "이고 나이는 " + age + "이고 키는 " + height + "입니다.");
	}

}
