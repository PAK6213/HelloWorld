package co.edu.statics;

public class SigletonExample {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if (s1 == s2) { // getInstance에서 동일한 singleton을 가르키기때문에 주소값이 같다.
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
	}
	
	Car car = new Car();

}

