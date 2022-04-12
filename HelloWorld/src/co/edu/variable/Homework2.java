package co.edu.variable;
import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
//		  영수증 물건의 가격과 현금
//		   [현금] 10000원
//		   [물건가격] 7500원
//		   [부가세] 750원
//		   [잔돈] 2500원   공급가액 + 부가가치세액(공급가액*10%)
		
		Scanner scn = new Scanner(System.in);
		int money, productprice, remains;
		double valueaddedtax;
		System.out.print("현금을 입력하세요 :");
		money = scn.nextInt();
		System.out.print("물건가격을 입력하세요 :");
		productprice = scn.nextInt();
		
		valueaddedtax = productprice - (productprice/1.1);
		remains = money - productprice;
		
		System.out.printf("물건가격은 %d원이며 현금으로 %d원을 지불하셨습니다.\n물건의 부가세는 %.1f원이며 잔돈은 %d원입니다.", productprice, money, valueaddedtax, remains);
	}

}
