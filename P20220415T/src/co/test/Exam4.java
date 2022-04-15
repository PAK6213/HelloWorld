package co.test;

import java.util.Scanner;

//클래스의 생성과 필드, 메소드, 생성자.
public class Exam4 {
	// 친구의 이름, 생일, 연락처(중복값이 없는 키의 역할)\
	Scanner scn = new Scanner(System.in);
	
	
	private String name;
	private String birthday;
	private String phoneNumber;
	
	
	
	
	//생성자
	public Exam4(String name, String birthday, String phoneNumber) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.phoneNumber = phoneNumber;
	}
	
	//메소드
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void friendList() {
		
		System.out.println("이름      생일       연락처");
		System.out.printf("%-4s %-10s %-15s\n", this.name, this.birthday, this.phoneNumber);
	}
	

	
}
