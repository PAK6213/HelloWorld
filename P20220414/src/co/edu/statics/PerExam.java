package co.edu.statics;

public class PerExam {

	public static void main(String[] args) {
		Person p1 = new Person("213212-21212", "홍길동");
		p1.name = "김길동";
		//p1.ssn = "216546352458";  // 상수여서 변경 불가능
		
		Person p2 = new Person("123123123-1231231223", "123123");
		System.out.println(p1.ssn + p2.ssn);
	}

}
