package co.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;
// 예외 처리는 성능상의 문제로 꼭 필요한 곳에 추가
public class MismatchEx {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while(true) {
			System.out.println("1.추가 2.종료");
			System.out.println("선택>>");
			int menu = 0;

			try {
				Class.forName("java.lang.String");   // Exception
			} catch (ClassNotFoundException e2) {   
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			
			try {
				menu = Integer.parseInt(scn.next());
			} catch(InputMismatchException e) {     // RuntimeException
				System.out.println("int형을 입력하세요");
				scn.nextLine();
			} catch(ArrayIndexOutOfBoundsException e1) {
				System.out.println("배열의 범위를 넘었습니다.");
			} catch(NumberFormatException e2) {
				System.out.println("int형 변환이 불가능합니다.");
			} catch(Exception e3) {  // 최상위 예외 클래스를 입력하면 발생하는 예외는 넘어갈 수 있다.
				System.out.println("알수 없는 예외");
			} finally {
				System.out.println("예외처리에서 반드시 한번은 실행");  //try문이 한번이라도 작동하면 예외 발생여부에 상관없이 한번 실행하는 코드
			}
			
			if (menu == 1) {
				System.out.println("추가 선택");
			} else if (menu == 2) {
				break;
			}
			
		}
		System.out.println("end of prog.");
	}
}
