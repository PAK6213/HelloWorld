package Miniproject.Damagochi.Game;

import java.util.Scanner;

import Miniproject.Damagochi.dto.Damagochi;

public class DamagochiImpl implements DamagochiService {
	Scanner sc = new Scanner(System.in);
	@Override
	public Damagochi eat(Damagochi damagochi) {
		// 음식먹기 
		
		System.out.println("음식을 선택하세요.");
		System.out.println("1.냉면");
		System.out.println("2.치킨");
		System.out.println("3.피자");
		System.out.println("4.육회비빔밥");
		System.out.println("5.군고구마");
//		System.out.println("6.비빔만두");
//		System.out.println("7.쫄면");
//		System.out.println("8.돈까스");
//		System.out.println("9.과자");
		int menu = sc.nextInt();
		sc.nextLine();
		
		if(menu == 1) {
			System.out.println("냉면을 먹었습니다. satiety 45 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 45);
		} else if(menu == 2) {
			System.out.println("치킨을 먹었습니다. satiety 60 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 60);
		} else if(menu == 3) {
			System.out.println("피자를 먹었습니다. satiety 55 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 55);
		} else if(menu == 4) {
			System.out.println("육회비빔밥을 먹었습니다. satiety 45 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 45);
		} else if(menu == 5) {
			System.out.println("군고구마를 먹었습니다. satiety 25 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 25);
		} else {
			System.out.println("잘못입력했습니다. 음식을 먹지 못하였습니다.");
		}
		
		damagochi.setThirst(damagochi.getThirst() + 15);
		
		return damagochi;
	}

	@Override
	public void drinking() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sleeping() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void excercising() {
		// TODO Auto-generated method stub

	}

	@Override
	public void friendmeeting() {
		// TODO Auto-generated method stub

	}

	@Override
	public void studying() {
		// TODO Auto-generated method stub

	}

}
