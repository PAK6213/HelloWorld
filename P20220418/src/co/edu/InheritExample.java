package co.edu;

public class InheritExample {

	public static void main(String[] args) {
		
		Child1 c1 = new Child1();
		
		c1.field1 = "";  // 부모 클래스 필드
		c1.field2 = "";  // 자식 클래스 필드
		
		c1.method1();
		c1.method2();
		
		
		Child2 c2 = new Child2();
		c2.field1 = "";  // 부모 클래스 필드
		c2.field3 = "";  // 자식 클래스 필드
		
		c2.method1();
		c2.method3();
		
		// 부모의 참조변수에 자식인스턴스를 할당. (다형성)
		Parent p1 = new Parent();
		p1 = new Child1();  // 
		p1 = new Child2();
		
		//p1.field3 = ""; // 부모클래스에는 field3의 필드가 없다. 
		p1.method1(); // 참조형이 Parent이기 때문에 method1()만 사용가능하다.
		
		c2 = (Child2) p1;  // 큰 범위의 참조변수를 작은 범위의 참조변수에 할당하려면 형변환을 해야한다.  
		c2.field1 = ""; // Child2의 참조형이기 때문에 field1,3 둘다 사용 가능.
		c2.field3 = "";
	}

}
