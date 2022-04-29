package co.micol.geun.student.dto;

import java.sql.Date;

import lombok.Data;

// lombok
@Data

// 테이블명 + VO(한명의 데이터를 입출력  DTO)
public class StudentVO {
	//VO는 멤버변수와 getter setter
	private String studentId;
	private String name;
	private Date birthDay;
	private String major;
	private String address;
	private String tel;
	
	

	@Override
	public String toString() {
		System.out.print(studentId + " : ");
		System.out.print(name + " : ");
		System.out.print(birthDay + " : ");
		System.out.print(major + " : ");
		System.out.print(address + " : ");
		System.out.println(tel);
		return null;
	}
	
	
}
