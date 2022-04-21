package co.edu.api;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CalendarExample {

	public static void main(String[] args) {

		Calendar today = Calendar.getInstance();
		today.set(2021, 1,1);
		System.out.println("년도: " + today.get(Calendar.YEAR));
		System.out.println("월: " + today.get(Calendar.MONTH)); // 월은 0 ~ 11
		System.out.println("일: " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("요일: " + today.get(Calendar.DAY_OF_MONTH)); // 요일은 일 ~ 토  1 ~ 7
		System.out.println("마지막날: " + today.getActualMaximum(Calendar.DATE));
		
		
		/*
		// Date 클래스는 잘 사용 안함.
		
		Date todate = new Date();
		System.out.println(todate.toString());
		todate.setYear(2022);
		System.out.println(todate.toString());
		
		
		LocalDate ldate = LocalDate.of(2021, 10, 10);
		System.out.println(ldate.toString());
		
		LocalTime ltime = LocalTime.of(10, 10, 10);
		System.out.println(ltime.toString());
		
		LocalDateTime ldt = LocalDateTime.now();
		ldt = LocalDateTime.of(2021, 10, 2, 12, 27, 24);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		System.out.println(ldt.format(dtf));*/
	}
}
