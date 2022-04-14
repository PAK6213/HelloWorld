package co.edu;

public class TVExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		String str = "Hello";
		
		Television tv = new Television(); // 참조형 변수 tv에 Television 인스턴스를 heap 영역에 생성하여 해당 주소를 저장한다.
		//인스턴스의 변수 초기화
		tv.company ="삼성";
		tv.color = "검정";
		tv.price = 400000;
		tv.model = "30InchTv";
		//인스턴스의 메서드 호출
		tv.turnOn();
		tv.changeChannel(10);
		tv.turnOff();
		
		
		Television tv2 = new Television(); // 참조형 변수 tv2에 Television 인스턴스를 생성하여 해당 주소를 저장한다.
		//인스턴스의 변수 초기화
		tv2.company ="LG";
		tv2.color = "흰색";
		tv2.price = 200000;
		tv2.model = "30InchTv";
		//인스턴스의 메서드 호출
		tv2.turnOn();
		tv2.changeChannel(10);
		tv2.turnOff();
		
		System.out.println(tv == tv2);  // 참조변수를 비교하면 참조변수에 저장 된 주소를 비교하기 때문에 false이다.
		System.out.println(tv);
		System.out.println(tv2);
		
		
		Student stud1 = new Student(); // Student클래스의 인스턴스를 힙영역에 생성하여 해당 주소를 stud1에 저장한다.
		stud1.name = "홍길동";
		stud1.studNo = "22-1234567";
		stud1.age = 20;
		stud1.height = 174.2;
		
		Student stud2 = new Student(); // Student클래스의 인스턴스를 힙영역에 생성하여 해당 주소를 stud1에 저장한다.
		stud2.name = "김길동";
		stud2.studNo = "22-98765412";
		stud2.age = 28;
		stud2.height = 167.2;
		
		Student stud3 = new Student("박길동", "22-45484354"); // Student클래스의 인스턴스를 힙영역에 생성하여 해당 주소를 stud1에 저장한다.
		stud3.showInfo();
		
		Student stud4 = new Student("박근형","15-34124123", 29, 178.5);
		stud4.showInfo();
		
		
		
		
		
	}

}
