package co.edu.dimension;

import java.util.Scanner;

public class StudentExample2 {

	public static void main(String[] args) {
		
		String name;
		Scanner scn = new Scanner(System.in);
		//System.out.println(scn.next()); // 스페이스를 기준으로 하나씩 처리한다. 홍길동 80 20

		
		Student[] students = {new Student(), new Student(), new Student()}; // 비어있는 3개의 공간을 만듦.
		for(int i = 0 ; i < students.length; i++) {
			System.out.println("학생이름 점수 나이순으로 입력하세요."); 
			students[i].studName = scn.next();
			students[i].score = Integer.parseInt(scn.next());
			students[i].age = Integer.parseInt(scn.next());
		}
		
		System.out.print("조회하고 싶은 이름을 입력하세요 :");
		
		
		
	
		
		// 조회하고 싶은 이름 입력
		// 홍길동은 ??살이고 ??점입니다.  
	}

}
