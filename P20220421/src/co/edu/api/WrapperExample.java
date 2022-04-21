package co.edu.api;

public class WrapperExample {

	public static void main(String[] args) {
		// 래퍼클래스
		// 래퍼(기본타입을 가지는 객체)
		// int, long, byte, float -> Integer, Long, Byte, Float
		
		int n1 = 100;  // 기본형(정수)
		Integer n2 = 200;  // Integer 참조형
		n1 = n2;  // 언박싱
		byte b1 = n2.byteValue();
		System.out.println(b1);
	}

}
