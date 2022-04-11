package co.edu.variable;

import java.io.IOException;
import java.util.Scanner;

public class SystemExample {

	public static void main(String[] args) {
		// 표준입출력.
//		Scanner scn = new Scanner(System.in); // 키보드
//		System.out.println("3개의 단어를 입력. 예) 안녕 하이 바이");
//		while(scn.hasNext()) {
//			String str = scn.next();
//			System.out.println(str);
//			if(str.equals("exit")) {
//				break;
//			}
//		}
		System.out.println("숫자를 입력하세요.");
		while(true) {
			int readByte;
			try {
				readByte = System.in.read();
				System.out.println(readByte);
				if(readByte == -1)
					break;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}
}
