package co.edu.inherit;

class Driver {
	public void drive(Car car) {
		car.drive();
	}
}

public class PolyExample {
	public static void main(String[] args) {
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		Driver driver = new Driver();
		driver.drive(bus);  // 매개변수의 다형성 Car 부모참조타입에 자손 bus taxi타입을 참조 할 수 있다.
		driver.drive(taxi);
	}


}
