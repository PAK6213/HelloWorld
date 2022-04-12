package co.edu;

import java.util.Scanner;

public class CalTimeEx {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("초를 입력하세요 :");
		int time = scn.nextInt();
		// 시, 분, 초 -> 
		int hours, minutes, secs;
		hours = time / (60*60);  // 5000 
		time = time % (60*60); 
		
		minutes = time / 60;   // 1400
		time = time % 60;
		
		secs = time;   
		
		time = hours * 3600 + minutes * 60 + secs;
		System.out.printf("입력한 초는 %d초이며 이는 %d시 %d분 %d초입니다." ,time,hours ,minutes, secs);
	}

}
