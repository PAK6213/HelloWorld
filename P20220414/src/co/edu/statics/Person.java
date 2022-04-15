package co.edu.statics;

public class Person {
	final String nation = "Korea";
	final String ssn;
	String name;
	static final double PI = 3.14; // 클래스 변수, 값 변경 불가, 상수필드
	
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	
	
}
