package co.edu.inherit;

public class CarExample {

	public static void main(String[] args) {
		Bus bus = new Bus(); // Bus 클래스의 인스턴스생성
		// 부모에게 상속받은 필드, 메소드
		bus.model = "45인승버스";
		bus.drive();
				
		// 자식에서 새로 생성한 필드, 메소드
		bus.busNo = "240";
		bus.fee();
		System.out.println(bus.toString());
		
		
		Taxi taxi = new Taxi();
		taxi.model = "SonataTaxi";
		taxi.drive();
		
		taxi.type = "개인택시";
		taxi.metering();
		System.out.println(taxi.toString());
		
		// 자식클래스의 인스턴스 => 부모 참조변수 할당가능.
		Bus[] buses = new Bus[10]; // 참조형이 Bus인 객체배열 buses
		Taxi[] txies = new Taxi[10]; // 참조형이 Taxi인 객체배열 buses
		
		Car[] cars = new Car[10];
		cars[0] = bus; // 
		cars[1] = taxi;		
	}

}
