package co.micol.prj.listTest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.dto.StudentVO;

public class ListTest {
	public void listTest() {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("박기자");
		list.add("이승리");
		
		for(String str : list) {
			System.out.println(str);
		}
		
	}
	
	public void studentList() {
		List<StudentVO> students = new ArrayList<StudentVO>();
		StudentVO student = new StudentVO();
		student.setStudentId("20220400101");
		student.setName("홍길동");
		student.setAge(23);
		student.setGender("남");
		student.setBirthDay(Date.valueOf("2000-11-13"));  // String -> Date로 변환
		students.add(student);
		
		student = new StudentVO();
		student.setStudentId("20220400102");
		student.setName("박길동");
		student.setAge(23);
		student.setGender("남");
		student.setBirthDay(Date.valueOf("2001-11-13"));  // String -> Date로 변환
		students.add(student);
		
		for(StudentVO vo : students) {
			vo.toString();
		}
		
		
	}

}
