package co.edu.nested;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer outer = new Outer();
		outer.method1();
		
		// instance  vs  static
		// instance (outer 인스턴스 생성 없이 inner 클래스 메소드 사용불가능)
		Outer.Inner1 inner = outer.new Inner1();
		inner.method2();
		// static (outer 인스턴스 생성 없이 inner 클래스 메소드 사용가능)
		Outer.Inner2.method5(); // instance 메소드
		Outer.Inner2 inner2 = new Outer.Inner2();
		inner2.method4(); // static 메소드

	}

}
