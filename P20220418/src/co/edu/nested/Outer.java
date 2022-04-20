package co.edu.nested;


public class Outer {
	private String f1;
	
	
	
	// Inner(인스턴스 멤버 클래스) 
	class Inner1 {
		String f2;
		
		void method2() {
			System.out.println("method2() call.");
		}
		
	
	}
	// Inner(static 멤버 클래스)
	static class Inner2 {
		String f4;
		static String f5;
		// 인스턴스 메소드 (인스턴스 생성 후 사용가능)
		void method4() {
			System.out.println("method4() call.");
		}
		// static 메소드 (인스턴스 생성 없이 사용가능)
		static void method5() {
			System.out.println("method5() call.");
		}
	}
	
	public void method1() {
		System.out.println("method1() call.");
		
		// 메서드 안의 클래스 -> 로컬 클래스
		class Local {
			String f3;
			
			void method3() {
				System.out.println("method3() call.");
			}
		}
		
		Local local = new Local();
		local.method3();
		
	}
}
