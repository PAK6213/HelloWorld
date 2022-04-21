package co.edu.api;

import java.util.Calendar;

public class MyCalendar {

	public static void main(String[] args) {
		String y = "2022";
		String m = "04";
		
		showcal(y,m);
	}
	
	public static void showcal(String year, String month) {
		// 달력 출력
		String[] days = {"Sun" , "Mon" , "Tue" , "Wed" ,"Thr","Fri", "Sat"};
		Calendar today = Calendar.getInstance();
		
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month) -1;  // -1을 해주어야함.
		today.set(y, m, 1);
		int week = today.get(Calendar.DAY_OF_WEEK);  // 해당 월의 첫번째요일
		int lastDay = today.getActualMaximum(Calendar.DATE); // 해당월의 마지막일
		int[] day = new int[lastDay];
		
		//배열값지정
		for(int i = 0; i < day.length; i++) {
			day[i] = i + 1;
		}
	
		System.out.printf("          %s년  %s월            \n",y,m+1);
		// 요일출력
		for(int i = 0; i < days.length ; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		System.out.print(" ============================\n");
		
		
		// 시작 날짜에 따른 공백을 추가
		for(int i = 0; i < week-1; i++) {
			System.out.printf("%4s", " ");
		}
		
		
		
		
		// 출력문. 
		for(int i = 0; i < day.length; i++) {
			System.out.printf("%4d", day[i]);
			if((i+week-1) % 7 == 6) {
				System.out.println();
			}
		}
		
	}

}
