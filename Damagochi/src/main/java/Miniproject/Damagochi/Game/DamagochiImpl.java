package Miniproject.Damagochi.Game;

import java.util.Scanner;

import Minigame.Minigame;
import Miniproject.Damagochi.StatePrint;
import Miniproject.Damagochi.dto.Damagochi;

public class DamagochiImpl implements DamagochiService {

	StatePrint sp = new StatePrint();
	Scanner sc = new Scanner(System.in);
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();
	Minigame minigame = new Minigame();

	@Override
	public Damagochi eat(Damagochi damagochi) {
		// 음식먹기
		//satiety 증가(o) thirsty 증가(o) ,hp 감소(o),depressionCount(x)
		boolean b = true;
		int menu;
		while(b) {

			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("            1.냉면");
				System.out.println("            2.치킨");
				System.out.println("            3.피자");
				System.out.println("            4.육회비빔밥");
				System.out.println("            5.군고구마");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("음식을 선택하세요 : ");
				menu = Integer.parseInt(sc.nextLine());

				if(menu == 1) {
					sp.clearScreen();
					sp.noddle();
					System.out.println("냉면을 먹었습니다. 포만감 45 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 45);
					break;
				} else if(menu == 2) {
					sp.clearScreen();
					sp.chicken();
					System.out.println("치킨을 먹었습니다. 포만감 60 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 60);
					break;
				} else if(menu == 3) {
					sp.clearScreen();
					sp.pizza();
					System.out.println("피자를 먹었습니다. 포만감 55 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 55);
					break;
				} else if(menu == 4) {
					sp.clearScreen();
					System.out.println("육회비빔밥을 먹었습니다. 포만감 45 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 45);
					break;
				} else if(menu == 5) {
					sp.clearScreen();
					sp.goguma();
					System.out.println("군고구마를 먹었습니다. 포만감 25 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 25);
					break;
				} 
			} catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
		}

		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);
		return damagochi;
	}

	@Override
	public Damagochi drinking(Damagochi damagochi) {
		// 마시기  
		// 종류에따른 satitey 증가,  thirst 감소,  hp 감소,depressionCount
		boolean b = true;
		int menu;
		while(b) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("        1.물");
				System.out.println("        2.커피");
				System.out.println("        3.음료수");
				System.out.println("        4.식혜");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("마실것을 선택하세요 : ");
				menu = Integer.parseInt(sc.nextLine());

				if(menu == 1) {
					sp.clearScreen();
					sp.drinking();
					System.out.println("물을 마셨습니다. 목마름 30 감소 하였습니다.");
					damagochi.setThirst(damagochi.getThirst() - 30);
					break;
				} else if(menu == 2) {
					sp.clearScreen();
					sp.drinking();
					System.out.println("커피를 먹었습니다. 목마름 35 감소 하였습니다.");
					damagochi.setThirst(damagochi.getThirst() - 35);
					break;
				} else if(menu == 3) {
					sp.clearScreen();
					sp.drinking();
					System.out.println("음료수를 먹었습니다. 목마름 30 감소, 포만감 10 증가 하였습니다.");
					damagochi.setThirst(damagochi.getThirst() - 30);
					damagochi.setSatiety(damagochi.getSatiety() + 10);
					break;
				} else if(menu == 4) {
					sp.clearScreen();
					sp.drinking();
					System.out.println("식혜를 먹었습니다. 목마름 40 감소, 포만감 15 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 15);
					damagochi.setThirst(damagochi.getThirst() - 40);
					break;
				}

			} catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
		}

		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);
		return damagochi;

	}

	@Override
	public Damagochi sleeping(Damagochi damagochi) {
		// 잠자기  
		// hp 증가 , satitey 감소, thirst 증가
		sp.sleeping();
		damagochi.setHp(damagochi.getHp() + 100);
		damagochi.setSatiety(damagochi.getSatiety() - 20);
		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);
		sp.clearScreen();
		System.out.println("잠자기를 완료 했습니다. HP 100 상승!!");
		return damagochi;

	}

	@Override
	public Damagochi resting(Damagochi damagochi) {
		// 휴식하기

		System.out.println("휴식을 진행합니다.");

		damagochi.setSatiety(damagochi.getSatiety() - 20);
		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);
		sp.clearScreen();
		return damagochi;

	}

	@Override
	public Damagochi excercising(Damagochi damagochi) {
		// 운동하기
		// healthexp 증가 , hp 감소 , satitey 감소 , thirst 증가, socialexp 증가
		boolean b = true;
		int menu;
		while(b) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("                1. 산책 ");
				System.out.println("                2. 야구 ");
				System.out.println("                3. 축구 ");
				System.out.println("                4. 배드민턴 ");
				System.out.println("                5. 수영 ");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("운동을 선택하세요.");
				menu = Integer.parseInt(sc.nextLine());

				if(menu == 1) {
					sp.walking();
					System.out.println("산책을 진행합니다.  건강 경험치가 30 증가 하였습니다.");
					sp.clearScreen();
					damagochi.setHealthExp(damagochi.getHealthExp() + 30);
					break;
				} else if(menu == 2) {
					sp.baseball();
					System.out.println("야구을 진행합니다. 건강 경험치가 60 증가 하였습니다.");
					sp.clearScreen();
					damagochi.setHealthExp(damagochi.getHealthExp() + 60);
					break;
				} else if(menu == 3) {
					sp.sc();
					System.out.println("축구를 진행합니다. 건강 경험치가 45 증가 하였습니다.");
					sp.clearScreen();
					damagochi.setHealthExp(damagochi.getHealthExp() + 45);
					break;
				} else if(menu == 4) {
					sp.badminton();
					System.out.println("배드민턴을 진행합니다. 건강 경험치가 40 증가 하였습니다.");
					sp.clearScreen();
					damagochi.setHealthExp(damagochi.getHealthExp() + 40);
					break;
				} else if(menu == 5) {
					sp.swimming();
					System.out.println("수영을 진행합니다. 건강 경험치가 50 증가 하였습니다.");
					sp.clearScreen();
					damagochi.setHealthExp(damagochi.getHealthExp() + 40);
					break;
				} else {
					System.out.println("메뉴를 잘못 선택하였습니다.");
				}
			}catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
		}
		damagochi.setSatiety(damagochi.getSatiety() - 30);
		damagochi.setThirst(damagochi.getThirst() + 25);
		damagochi.setHp(damagochi.getHp() - 30);
		damagochi.setSocialExp(damagochi.getSocialExp() + 10);
		damagochi.setDepressionCount(damagochi.getDepressionCount() - 2);

		return damagochi;

	}

	@Override
	public Damagochi friendmeeting(Damagochi damagochi) {
		// 친구만나기 
		boolean b = true;
		int menu;
		while(b) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("              1. 영화보기 ");
				System.out.println("              2. PC방 ");
				System.out.println("              3. 음식먹기 ");
				System.out.println("              4. 쇼핑 ");
				System.out.println("              5. 뮤지컬보기 ");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("친구와 하고싶은 활동을 선택하세요.");
				menu = Integer.parseInt(sc.nextLine());

				if(menu == 1) {
					sp.clearScreen();
					System.out.println("친구와 영화보기를 진행합니다.  사회성 경험치가 40 증가 하였습니다.");
					break;
				} else if(menu == 2) {
					sp.pc();
					sp.clearScreen();
					System.out.println("친구와 PC방에서 게임을 진행합니다.  사회성 경험치가 40 증가 하였습니다.");
					break;
				} else if(menu == 3) {
					sp.clearScreen();
					System.out.println("친구와 음식먹기를 진행합니다. 포만감 40 증가, 사회성 경험치가 40 증가 하였습니다.");
					damagochi.setSatiety(damagochi.getSatiety() + 40);
					break;
				} else if(menu == 4) {
					sp.clearScreen();
					System.out.println("친구와 쇼핑을 진행합니다.  사회성 경험치가 40 증가 하였습니다.");
					break;
				} else if(menu == 5) {
					sp.clearScreen();
					System.out.println("친구와 뮤지컬 보기를 진행합니다.  사회성 경험치가 40 증가 하였습니다.");
					break;
				}
			}catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
		}

		damagochi.setSatiety(damagochi.getSatiety() - 20);
		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setSocialExp(damagochi.getSocialExp() + 40);
		damagochi.setDepressionCount(damagochi.getDepressionCount() - 3);


		return damagochi;
	}

	@Override
	public Damagochi studying(Damagochi damagochi) {
		// 공부하기
		boolean b = true;
		int menu;
		while(b) {
			try {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("      1. 숫자 맞추기(UP & DOWN)");
				System.out.println("      2. 단어 순서맞추기  ");
				System.out.println("      3. 수도 맞추기 ");
				System.out.println("      4. 끝말잇기");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("메뉴를 선택하세요 : ");
				menu = Integer.parseInt(sc.nextLine());

				//숫자 맞추기(UP & DOWN)
				if(menu == 1) {
					minigame.UpDown();
					damagochi.setIqExp(damagochi.getIqExp() + 15);
					sp.clearScreen();
					System.out.println("");
					break;
					//단어 순서 맞추기
				} else if(menu == 2) {
					minigame.word();
					damagochi.setIqExp(damagochi.getIqExp() + 30);
					break;
				} else if(menu == 3) {
					//수도 맞추기
					minigame.Capital();
					damagochi.setIqExp(damagochi.getIqExp() + 30);
					break;
				} else if(menu == 4) {
					//끝말잇기
					minigame.endword();
					damagochi.setIqExp(damagochi.getIqExp() + 30);
					break;
				}
			}catch (Exception e) {
				sp.clearScreen();
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
			}
		}
		damagochi.setSatiety(damagochi.getSatiety() - 20);
		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() - 3);

		return damagochi;

	}

	@Override
	public int checking(Damagochi damagochi) {
		// 0 : 다마고치 성공  1 : 다마고치 실패  2 : 다마고치 불러오기 실패 3:체력실패
		// 다마고치의 성공, 실패조건 확인.
		// 다른 활동을 5번초과 할 때 친구를 만나지 않으면 우울증 경고를 받으며 6번 초과시 실패 한다. !!
		// hp (0미만시 경고 -50 실패)
		// satiety (0미만 시 경고 -50 실패)
		// thirst (100초과 시 경고 150 실패)
		int check = 1;

		if(damagochi.getDepressionCount() > 5) {
			sp.warning();
			System.out.println(damagochi.getDamagochiName() + "가 우울증 위기 입니다. 친구 또는 운동을하여 사람을 만나세요!!");
			if(damagochi.getDepressionCount() > 6) {
				return check;
			}
		}

		if(damagochi.getHp() < 0) {
			sp.warning();
			System.out.println(damagochi.getDamagochiName() +"가 피곤해합니다.");
			if(damagochi.getHp() < -50) {
				return check;
			}
		}
		if(damagochi.getSatiety() < 0) {
			sp.warning();
			System.out.println(damagochi.getDamagochiName() + "가 배가고픕니다.");
			if(damagochi.getSatiety() < -50) {
				return check;
			}
		}
		if(damagochi.getThirst() > 100) {
			sp.warning();
			System.out.println(damagochi.getDamagochiName() + "가 목이마릅니다.");
			if(damagochi.getThirst() > 150) {

				return check;
			}
		}
		if(damagochi.getHealthExp() > damagochi.getHealthLevel() * 70) {
			damagochi.setHealthLevel(damagochi.getHealthLevel() + 1);
			damagochi.setHealthExp(damagochi.getHealthExp() % 70);
			sp.levelup();
			System.out.println(damagochi.getDamagochiName() + "의 Health_level이 증가하였습니다.");

		}
		if(damagochi.getSocialExp() > damagochi.getSocialLevel() * 70) {
			damagochi.setSocialLevel(damagochi.getSocialLevel() + 1);
			damagochi.setSocialExp(damagochi.getSocialExp() % 70);
			sp.levelup();
			System.out.println(damagochi.getDamagochiName() + "의 Social_level이 증가하였습니다.");

		}
		if(damagochi.getIqExp() > damagochi.getIqLevel() * 70) {
			damagochi.setIqLevel(damagochi.getIqLevel() + 1);
			damagochi.setIqExp(damagochi.getIqExp() % 70);
			sp.levelup();
			System.out.println(damagochi.getDamagochiName() + "의 Iq_level이 증가하였습니다.");

		}

		if(damagochi.getDepressionCount() < 0) {
			damagochi.setDepressionCount(0);
		}

		if(damagochi.getHp() > 100) {
			damagochi.setHp(100);
		}

		if(damagochi.getThirst() < 0) {
			damagochi.setThirst(0);
		}

		if(damagochi.getSatiety() > 100) {
			damagochi.setSatiety(100);
		}

		if(damagochi.getDamagochiName() == null) {
			return 2;
		}

		damagochi.setScore(damagochi.getHealthLevel()+damagochi.getIqLevel()+damagochi.getSocialLevel());
		return 0;
	}

}
