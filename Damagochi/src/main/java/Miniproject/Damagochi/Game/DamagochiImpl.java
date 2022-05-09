package Miniproject.Damagochi.Game;

import java.util.Scanner;

import Miniproject.Damagochi.dto.Damagochi;

public class DamagochiImpl implements DamagochiService {
	//콘솔창 클리어
	public static void clearScreen() {  
		for (int i = 0; i < 80; i++)
			System.out.println("");
	}

	Scanner sc = new Scanner(System.in);
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();

	@Override
	public Damagochi eat(Damagochi damagochi) {
		// 음식먹기
		//satiety 증가(o) thirsty 증가(o) ,hp 감소(o),depressionCount(x)

		System.out.println("음식을 선택하세요.");
		System.out.println("1.냉면");
		System.out.println("2.치킨");
		System.out.println("3.피자");
		System.out.println("4.육회비빔밥");
		System.out.println("5.군고구마");

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
		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);

		return damagochi;
	}

	@Override
	public Damagochi drinking(Damagochi damagochi) {
		// 마시기  
		// 종류에따른 satitey 증가,  thirst 감소,  hp 감소,depressionCount

		System.out.println("음식을 선택하세요.");
		System.out.println("1.물");
		System.out.println("2.커피");
		System.out.println("3.음료수");
		System.out.println("4.식혜");

		int menu = sc.nextInt();
		sc.nextLine();

		if(menu == 1) {
			System.out.println("물을 마셨습니다. thirst 30 감소 하였습니다.");
			damagochi.setThirst(damagochi.getThirst() - 30);
		} else if(menu == 2) {
			System.out.println("커피를 먹었습니다. thirst 35 감소 하였습니다.");
			damagochi.setThirst(damagochi.getThirst() - 35);
		} else if(menu == 3) {
			System.out.println("음료수를 먹었습니다. thirst 30 감소, satitey 10 증가 하였습니다.");
			damagochi.setThirst(damagochi.getThirst() - 30);
			damagochi.setSatiety(damagochi.getSatiety() + 10);
		} else if(menu == 4) {
			System.out.println("식혜를 먹었습니다. thirst 40 감소, satitey 15 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 15);
			damagochi.setThirst(damagochi.getThirst() - 40);
		}

		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);
		return damagochi;

	}

	@Override
	public Damagochi sleeping(Damagochi damagochi) {
		// 잠자기  
		// hp 증가 , satitey 감소, thirst 증가

		try {

			for(int i = 0; i < 3; i++) {
				clearScreen();
				System.out.println("         **********    ***********");
				System.out.println("                 *             *  ");
				System.out.println("                *             *   ");
				System.out.println("               *             *    ");
				System.out.println("******        *             *     ");
				System.out.println("    *        *             *      ");
				System.out.println("   *        *             *       ");
				System.out.println("  *        *             *        ");
				System.out.println(" *        *             *         ");
				System.out.println("******   ***********   ***********    *  *  *  *  *");
				Thread.sleep(1000);
				clearScreen();
				System.out.println("           **********    ***********");
				System.out.println("                   *             *  ");
				System.out.println("                  *             *   ");
				System.out.println("                 *             *    ");
				System.out.println("  ******        *             *     ");
				System.out.println("      *        *             *      ");
				System.out.println("     *        *             *       ");
				System.out.println("    *        *             *        ");
				System.out.println("   *        *             *         ");
				System.out.println("  ******   ***********   ***********    *  *  *  *  *");
				Thread.sleep(1000);

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		damagochi.setHp(damagochi.getHp() + 100);
		damagochi.setSatiety(damagochi.getSatiety() - 20);
		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setDepressionCount(damagochi.getDepressionCount() + 1);
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
		return damagochi;

	}

	@Override
	public Damagochi excercising(Damagochi damagochi) {
		// 운동하기
		// healthexp 증가 , hp 감소 , satitey 감소 , thirst 증가, socialexp 증가
		System.out.println("운동을 선택하세요.");
		
		System.out.println("1. 산책 ");
		System.out.println("2. 야구 ");
		System.out.println("3. 축구 ");
		System.out.println("4. 배드민턴 ");
		System.out.println("5. 수영 ");

		int menu = sc.nextInt();
		sc.nextLine();

		if(menu == 1) {
			try {
				for(int i = 0; i < 3; i++) {
					clearScreen();
					System.out.println("   ***         ");
					System.out.println("  *****        ");
					System.out.println("   ***         ");
					System.out.println("    *          ");
					System.out.println("   ***         ");
					System.out.println("  * * *        ");
					System.out.println("   * *         ");
					System.out.println("  *   *        ");
					Thread.sleep(1000);
					clearScreen();

					System.out.println("          ***      ");
					System.out.println("         *****     ");
					System.out.println("          ***      ");
					System.out.println("           *       ");
					System.out.println("          ***      ");
					System.out.println("         * * *     ");
					System.out.println("          * *      ");
					System.out.println("         *   *     ");
					Thread.sleep(1000);
					clearScreen();
					
					System.out.println("                     ***      ");
					System.out.println("                    *****     ");
					System.out.println("                     ***      ");
					System.out.println("                      *       ");
					System.out.println("                     ***      ");
					System.out.println("                    * * *     ");
					System.out.println("                     * *      ");
					System.out.println("                    *   *     ");
					Thread.sleep(1000);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("산책을 진행합니다.  healthExp가 30 증가 하였습니다.");
			damagochi.setHealthExp(damagochi.getHealthExp() + 30);
		} else if(menu == 2) {
			try {
				for(int i = 0; i < 3; i++) {
					clearScreen();
					System.out.println("   ***                   ***      ");
					System.out.println("  ***** * ●●          * *****     ");
					System.out.println("   *** *               * ***      ");
					System.out.println("    * *                 * *       ");
					System.out.println("   ***                   ***      ");
					System.out.println("  * *                     * *     ");
					System.out.println("   * *                   * *      ");
					System.out.println("  *   *                 *   *     ");
					Thread.sleep(1000);
					clearScreen();

					System.out.println("   ***                   ***      ");
					System.out.println("  ***** *     ●●      * *****     ");
					System.out.println("   *** *               * ***      ");
					System.out.println("    * *                 * *       ");
					System.out.println("   ***                   ***      ");
					System.out.println("  * *                     * *     ");
					System.out.println("   * *                   * *      ");
					System.out.println("  *   *                 *   *     ");
					Thread.sleep(1000);
					clearScreen();
					
					System.out.println("   ***                   ***      ");
					System.out.println("  ***** *          ●● * *****     ");
					System.out.println("   *** *               * ***      ");
					System.out.println("    * *                 * *       ");
					System.out.println("   ***                   ***      ");
					System.out.println("  * *                     * *     ");
					System.out.println("   * *                   * *      ");
					System.out.println("  *   *                 *   *     ");
					Thread.sleep(1000);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("야구을 진행합니다. healthExp가 60 증가 하였습니다.");
			damagochi.setHealthExp(damagochi.getHealthExp() + 60);
		} else if(menu == 3) {
			try {
				for(int i = 0; i < 3; i++) {
					clearScreen();
					System.out.println("   ***                   ***      ");
					System.out.println("  *****                 *****     ");
					System.out.println("   ***                   ***      ");
					System.out.println("    *                     *       ");
					System.out.println("   ***                   ***      ");
					System.out.println("  * * *                 * * *     ");
					System.out.println("   * *                   * *      ");
					System.out.println("  *   * ●●              *   *     ");
					Thread.sleep(1000);
					clearScreen();

					System.out.println("   ***                   ***      ");
					System.out.println("  *****                 *****     ");
					System.out.println("   ***                   ***      ");
					System.out.println("    *                     *       ");
					System.out.println("   ***                   ***      ");
					System.out.println("  * * *                 * * *     ");
					System.out.println("   * *                   * *      ");
					System.out.println("  *   *       ●●        *   *     ");
					Thread.sleep(1000);
					clearScreen();
					
					System.out.println("   ***                   ***      ");
					System.out.println("  *****                 *****     ");
					System.out.println("   ***                   ***      ");
					System.out.println("    *                     *       ");
					System.out.println("   ***                   ***      ");
					System.out.println("  * * *                 * * *     ");
					System.out.println("   * *                   * *      ");
					System.out.println("  *   *              ●● *   *     ");
					Thread.sleep(1000);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("축구를 진행합니다. healthExp가 45 증가 하였습니다.");
			damagochi.setHealthExp(damagochi.getHealthExp() + 45);
		} else if(menu == 4) {
			System.out.println("배드민턴을 진행합니다. healthExp가 40 증가 하였습니다.");
			damagochi.setHealthExp(damagochi.getHealthExp() + 40);
		} else if(menu == 5) {
			System.out.println("수영을 진행합니다. healthExp가 50 증가 하였습니다.");
			damagochi.setHealthExp(damagochi.getHealthExp() + 40);
		} else {
			System.out.println("메뉴를 잘못 선택하였습니다.");
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

		System.out.println("친구와 하고싶은 활동을 선택하세요.");
		System.out.println("1. 영화보기 ");
		System.out.println("2. PC방 ");
		System.out.println("3. 음식먹기 ");
		System.out.println("4. 쇼핑 ");
		//음악 넣어보기!!
		System.out.println("5. 뮤지컬보기 ");

		int menu = sc.nextInt();
		sc.nextLine();

		if(menu == 1) {
			System.out.println("친구와 영화보기를 진행합니다.  socialExp가 40 증가 하였습니다.");
		} else if(menu == 2) {
			System.out.println("친구와 PC방에서 게임을 진행합니다.  socialExp가 40 증가 하였습니다.");
		} else if(menu == 3) {
			System.out.println("친구와 음식먹기를 진행합니다. satitey 40 증가, socialExp가 40 증가 하였습니다.");
			damagochi.setSatiety(damagochi.getSatiety() + 40);
		} else if(menu == 4) {
			System.out.println("친구와 쇼핑을 진행합니다.  socialExp가 40 증가 하였습니다.");
		} else if(menu == 5) {
			System.out.println("친구와 뮤지컬 보기를 진행합니다.  socialExp가 40 증가 하였습니다.");
		} else {
			System.out.println("메뉴를 잘못 선택하였습니다.");
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
		System.out.println("메뉴를 선택하세요!!");
		System.out.println("1. 숫자 맞추기(UP & DOWN)");
		System.out.println("2. 단어 순서맞추기  ");

		int menu = sc.nextInt();
		sc.nextLine();
		//숫자 맞추기(UP & DOWN)
		if(menu == 1) {
			int randomNumber = (int)(Math.random()*10000) + 1;
			int answerNumber;
			boolean b = true;
			System.out.println("숫자 맞추기 게임을시작합니다!!!!!!!!!");
			System.out.println("숫자의 범위는 1~10000사이의 숫자입니다.");
			while(b) {
				System.out.print("정답 숫자를 입력하세요 : ");
				answerNumber = sc.nextInt();
				sc.nextLine();
				if(randomNumber == answerNumber) {
					System.out.println("정답입니다. iq_exe가 15증가하였습니다.");
					damagochi.setIqExp(damagochi.getIqExp() + 15);
					break;
				} else if(randomNumber > answerNumber) {
					System.out.println("입력한 수는 정답보다 작습니다.");
				} else if(randomNumber < answerNumber) {
					System.out.println("입력한 수는 정답보다 큽니다.");
				}
			}
		} else if(menu == 2) {

		}



		damagochi.setSatiety(damagochi.getSatiety() - 20);
		damagochi.setThirst(damagochi.getThirst() + 15);
		damagochi.setHp(damagochi.getHp() - 20);
		damagochi.setDepressionCount(damagochi.getDepressionCount() - 3);

		return damagochi;

	}

	@Override
	public int checking(Damagochi damagochi) {
		// 0 : 다마고치 성공  1 : 다마고치 실패  2 : 다마고치 불러오기 실패
		// 다마고치의 성공, 실패조건 확인.
		// 다른 활동을 5번초과 할 때 친구를 만나지 않으면 우울증 경고를 받으며 6번 초과시 실패 한다. !!
		// hp (0미만시 경고 -50 실패)
		// satiety (0미만 시 경고 -50 실패)
		// thirst (100초과 시 경고 150 실패)
		int check = 1;

		if(damagochi.getDepressionCount() > 5) {
			System.out.println(damagochi.getDamagochiName() + "가 우울증 위기 입니다. 친구 또는 운동을하여 사람을 만나세요!!");
			if(damagochi.getDepressionCount() > 6) {
				System.out.println(damagochi.getDamagochiName() + "가 우울증으로 인해 죽었습니다........");
				System.out.println("다마고치를 다시 생성하세요.");
				return check;
			}
		}

		if(damagochi.getHp() < 0) {
			System.out.println(damagochi.getDamagochiName() +"가 피곤해합니다.");
			if(damagochi.getHp() < -50) {
				System.out.println(damagochi.getDamagochiName() + "가 체력부족으로인해 죽었습니다.");
				System.out.println("다마고치를 다시 생성하세요.");
				return check;
			}
		}
		if(damagochi.getSatiety() < 0) {
			System.out.println(damagochi.getDamagochiName() + "가 배가고픕니다.");
			if(damagochi.getSatiety() < -50) {
				System.out.println(damagochi.getDamagochiName() + "가 배고픔으로인해 죽었습니다.");
				System.out.println("다마고치를 다시 생성하세요.");
				return check;
			}
		}
		if(damagochi.getThirst() > 100) {
			System.out.println(damagochi.getDamagochiName() + "가 목이마릅니다.");
			if(damagochi.getThirst() > 150) {
				System.out.println(damagochi.getDamagochiName() + "가 수분부족으로인해 죽었습니다.");
				System.out.println("다마고치를 다시 생성하세요.");
				return check;
			}
		}
		if(damagochi.getHealthExp() > damagochi.getHealthLevel() * 70) {
			damagochi.setHealthLevel(damagochi.getHealthLevel() + 1);
			damagochi.setHealthExp(damagochi.getHealthExp() % 70);
			System.out.println(damagochi.getDamagochiName() + "의 Health_level이 증가하였습니다.");
		}
		if(damagochi.getSocialExp() > damagochi.getSocialLevel() * 70) {
			damagochi.setSocialLevel(damagochi.getSocialLevel() + 1);
			damagochi.setSocialExp(damagochi.getSocialExp() % 70);
			System.out.println(damagochi.getDamagochiName() + "의 Social_level이 증가하였습니다.");
		}
		if(damagochi.getIqExp() > damagochi.getIqLevel() * 70) {
			damagochi.setIqLevel(damagochi.getIqLevel() + 1);
			damagochi.setIqExp(damagochi.getIqExp() % 70);
			System.out.println(damagochi.getDamagochiName() + "의 Iq_level이 증가하였습니다.");
		}

		if(damagochi.getDamagochiName() == null) {
			return 2;
		}

		damagochi.setScore(damagochi.getHealthLevel()+damagochi.getIqLevel()+damagochi.getSocialLevel());
		return 0;
	}

}
