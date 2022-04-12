package co.edu.condition;

import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.print("피자의 종류를 입력하세요:");
	    String type = scn.nextLine();
	    int price;
	    switch(type) {
	    case "치즈":
	    case "고구마":
	    	price = 20000;
	    	System.out.println("고구마 피자를 선택하였습니다. 가격은 :" + price + " 입니다.");
	    	break;
	    case "쉬림프":
	    	price = 27000;
	    	System.out.println("쉬림프 피자를 선택하였습니다. 가격은 :" + price + " 입니다.");
	    	break;
	    case "페퍼로니":
	    	price = 25000;
	    	System.out.println("페퍼로니 피자를 선택하였습니다. 가격은 :" + price + " 입니다.");
	    	break;
	    default:
	    	price = 0;
	 
	    }
	}

}
