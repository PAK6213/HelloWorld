package co.edu.api;

import java.util.Scanner;

public class StringExample {

	public static void main(String[] args) {
		// 주민등록번호 => 생년월일-남/여 구분.
		// 950405-2345678 : 95년생 4월 5일 생, 여자입니다.
		// 010213-3548154 : 01년생 2월 13일 생, 남자입니다.

		Scanner scn = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요 :");
		String privacyNumber = scn.nextLine();
		String result = checkInfo(privacyNumber);
		System.out.println(result);

	}

	public static String checkInfo(String jumin) {
		String error = "잘못된 입력입니다.";

		String yearNum = jumin.substring(0,2); // 첫 2자리를 가져옴(년도)
		int year = Integer.parseInt(yearNum); 
		String yearMon = jumin.substring(2,4); // 첫 2자리를 가져옴(월)
		int month = Integer.parseInt(yearMon); 
		String dayMon = jumin.substring(4,6); // 첫 2자리를 가져옴(일)
		int day = Integer.parseInt(dayMon); 
	
		if(month < 0 || month > 12 || day < 0 || day > 31) {
			return error;
			
		}
		
		
		if(jumin.indexOf("-") != -1) { // -가 포함되어있음.
			String gender = jumin.substring(7,8);
			if(gender.equals("1")) {
				gender = "남자";
			} else if(gender.equals("2")) {
				gender = "여자";
			} else if(gender.equals("3")) {
				gender = "남자";
			} else if(gender.equals("4")) {
				gender = "여자";
			} else {
				return error;
			}
			
			String result = yearNum +"년" + yearMon + "월" + dayMon + "일 생, " + gender +"입니다."; 
			return result;
	
		} else {  // -가 포함되어 있지 않음.
			String gender = jumin.substring(6,7);
			if(gender.equals("1")) {
				gender = "남자";
			} else if(gender.equals("2")) {
				gender = "여자";
			} else if(gender.equals("3")) {
				gender = "남자";
			} else if(gender.equals("4")) {
				gender = "여자";
			} else {
				return error;
			}
			String result = yearNum +"년" + yearMon + "월" + dayMon + "일 생" + gender +"입니다."; 
			return result;
		}
		
		
	}

}
