package Miniproject.Damagochi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Miniproject.Damagochi.Game.DamagochiImpl;
import Miniproject.Damagochi.Game.DamagochiService;
import Miniproject.Damagochi.Game.DamagochiSignUp;
import Miniproject.Damagochi.Game.DamagochiSignUpImpl;
import Miniproject.Damagochi.SignUp.Service;
import Miniproject.Damagochi.SignUp.ServiceImpl;
import Miniproject.Damagochi.dto.Damagochi;
import Miniproject.Damagochi.dto.User;

public class Menu {
	List<Damagochi> damagochis = new ArrayList<Damagochi>();
	Service service = new ServiceImpl();
	DamagochiService damagochiservice = new DamagochiImpl();
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();
	public static String loginId = "";
	public static String damagochiName ="";
	private Scanner sc = new Scanner(System.in);
	private int menu;
	StatePrint sp = new StatePrint();
	Print Pr = new Print();

	

	// main Menu 실행
	public void main() {
		sp.mainTitle();
		boolean b = true;
		sp.clearScreen();
		while(b) {

			try {
				menuTitle();
				System.out.print("안녕하세요. 이용하실 메뉴를 입력하세요 : ");
				menu = Integer.parseInt(sc.nextLine());


			} catch (Exception e) {
				sp.clearScreen();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");

			}
			if(menu == 1) { // 회원 가입.
				signUp();		
			} else if(menu == 2) { // 로그인
				login();
			} else if(menu == 3) { // 순위
				rank();
			} else if(menu == 4) {
				delete();
			} else if(menu == 5) {
				sp.bye();
				break;
			} else {

			}
		} 
	}



	// first MenuTitle
	private void menuTitle() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("■            메뉴를 선택하세요   	         ■");
		System.out.println("■               1.회원가입    	         ■");
		System.out.println("■               2.로그인     	     \t ■");
		System.out.println("■               3.순위       	         ■");
		System.out.println("■               4.회원탈퇴    	         ■");
		System.out.println("■               5.종료     	         ■");
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

	}
	// 회원가입 
	private void signUp() {
		boolean b = true;
		while(b) {
			try {
				sp.clearScreen();
				int result;
				User user = new User();
				System.out.println("●●●●●●●●●●●●●●●●●●");
				System.out.println("●●●●● 회원가입 ●●●●●");
				System.out.println("●●●●●●●●●●●●●●●●●●");
				System.out.print("ID를 입력하세요 : ");
				String userId = sc.nextLine();
				user.setUserId(userId);
				System.out.print("PassWord를 입력하세요 : ");
				String password = sc.nextLine();
				user.setPassword(password);
				System.out.print("Age를 입력하세요 : ");
				int age = Integer.parseInt(sc.nextLine());
				user.setAge(age);
				System.out.print("BirthDay를 입력하세요 : ");
				String birthDay = sc.nextLine();
				user.setBirthDay(birthDay);
				System.out.print("Tel을 입력하세요 : ");
				String tel = sc.nextLine();
				user.setTel(tel);
				sp.process();
				// 각 정보를 입력받아서 insert
				result = service.insertUser(user);
				//1 : 정상가입  2 : 중복으로인해 가입실패
				if(result == 2) {
					sp.Fail();
					System.out.println("이미 가입된 ID가 있습니다.");
				}else if(result == 1) {
					sp.success();
					System.out.println("정상적으로 ID가 생성되었습니다. 로그인 진행 후 이용해주세요.");
					break;
				}
			} catch (Exception e) {
				sp.warning();
				System.out.println("숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! 숫자를 입력하세요! ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	// ID와 password를 입력받아 DB의 사용자 계정과 일치여부를 확인하여 접속하는 기능.
	private void login() {
		boolean b = true;
		User user = new User();
		int result = 0; // 로그인 결과 여부
		while(b) {
			System.out.print("로그인 아이디 입력 :");
			loginId = sc.nextLine();
			System.out.print("로그인 패스워드 입력 : ");
			String password = sc.nextLine();
			user.setUserId(loginId);
			user.setPassword(password);
			sp.process();

			result = service.loginuser(user);
			//0 : 비밀번호 오류  1 : 접속완료  2 : ID 생성이 되지 않음.
			if(result == 1) {
				damagochiMenu();
				break;
			} else if(result == 2) {
				sp.Fail();
				System.out.println("생성된 아이디가 없습니다. 회원가입을 해주세요!!");
				break;
			}else{
				sp.Fail();
				System.out.println("비밀번호가 틀렸습니다. 다시 입력하세요");
			}
		}
	}

	// 사용자의 score 기준으로 정렬하여 출력
	private void rank() {
		int rank = 1;
		damagochis = damagochisignup.selectListDamagochi();
		sp.clearScreen();
		System.out.println("■■■■■■■■■■■■■■ 순위 ■■■■■■■■■■■■■■■■");
		System.out.println("■     user_id          score      ■");
		for(Damagochi da : damagochis) {
			System.out.printf("■%d등 %-10s           %-3d점\t  ■\n",rank,da.getUserId(),da.getScore());
			rank++;
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	// 회원 탈퇴 (사용자 ID와 PASSWORD를 입력받아 일치하면 삭제가능)
	private void delete() {
		sp.clearScreen();
		boolean b = true;
		User user = new User();
		int result = 0; // 삭제 결과 여부
		while(b) {
			System.out.println("         회원 탈퇴를 진행합니다.        ");
			System.out.print("회원탈퇴 ID를 입력 : ");
			loginId = sc.nextLine();
			System.out.print("회원탈퇴 ID의 패스워드 입력 : ");
			String password = sc.nextLine();
			user.setUserId(loginId);
			user.setPassword(password);

			result = service.Deleteuser(user);
			if(result == 0) {
				sp.process();
				sp.success();
				System.out.println(user.getUserId() + "가 정상삭제 되었습니다.");
				break;
			} else if(result == 1) {
				sp.process();
				sp.Fail();
				System.out.println("입력한 PassWord가 불일치합니다.");
			} else if(result == 2) {
				sp.process();
				sp.Fail();
				System.out.println(user.getUserId() + "로 생성된 ID가 없습니다.");
				break;
			}

		}
	}



	private void damagochiMenu() {
		boolean b = true;
		while(b) {
			try {
				System.out.println("");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■         다마고치 게임을 시작합니다.            ■");
				System.out.println("■            1.다마고치 생성                 ■");
				System.out.println("■            2.다마고치 불러오기     	         ■");
				System.out.println("■            3.다마고치 삭제                 ■");
				System.out.println("■            4.다마고치 목록                 ■");
				System.out.println("■            5.로그아웃                 	 ■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("이용하실 메뉴를 입력하세요 : ");

				menu = Integer.parseInt(sc.nextLine());


				if(menu == 1) { 
					// 다마고치 생성
					sp.clearScreen();
					damagochiMenuSignUp();

				} else if(menu == 2) { 
					// 플레이 할 다마고치 불러와 게임시작
					sp.clearScreen();
					damagochiloadToplay();

				} else if(menu == 3) {
					// 다마고치 삭제
					sp.clearScreen();
					damagochidelete();

				} else if(menu == 4) {
					// 다마고치 목록
					sp.clearScreen();
					damagochilist();
				} else if(menu == 5) {
					//이전메뉴로 돌아가기.
					sp.clearScreen();
					break;
				}
			} catch (Exception e) {
				sp.clearScreen();
				
			}
		}
	}
	
	public void damagochilist() {
		List<Damagochi> damagochis2 = new ArrayList<Damagochi>();
		damagochis2 = damagochisignup.DamagochiNameList();
		
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("      user_id          damagochi_name       ");
		for(Damagochi da : damagochis2) {
			System.out.printf("      %-10s           %-10s\n",da.getUserId(),da.getDamagochiName());
		}
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}

	// 이름은 입력받고 나머지 변수는 기본값으로 적용.
	// 중복된 다마고치의 이름이 있는지 확인해야함. (O)
	private void damagochiMenuSignUp () {
		Damagochi damagochi = new Damagochi();
		System.out.print("생성할 다마고치 이름을 입력하세요 : ");
		String damagochiName = sc.nextLine();
		sp.process();
		damagochi.setUserId(loginId);
		damagochi.setDamagochiName(damagochiName);
		damagochisignup.insertDamagochi(damagochi);
	}

	// 다마고치 불러오기
	private void damagochiloadToplay() {
		// 다마고치 불러오기 

		int check = 0;
		Damagochi damagochi = new Damagochi();
		System.out.print("불러올 다마고치의 이름을 입력하세요 : ");
		String name = sc.nextLine();
		damagochiName = name;
		sp.process();
		damagochi.setDamagochiName(damagochiName);
		damagochi = damagochisignup.readDamagochi(damagochi);
// 여기까진 디버깅상 문제없음

		boolean b = true;
		while(b) {
            // 음식을 먹었는데 여기 와일문을 탈출함..
			// 메뉴가 한번 수행되고 나서 다마고치의 성공 실패 조건을 수행한 뒤 업데이트
			// 다마고치가 조건으로 실패했을경우 해당 다마고치를 삭제하고 이전메뉴로이동.
			damagochisignup.updateDamagochi(damagochi);
			check = damagochiservice.checking(damagochi);
			if(check == 1) {
				damagochisignup.deleteDamagochi(damagochi);
				sp.clearScreen();
				sp.death();
				System.out.println(damagochi.getDamagochiName() + "가 조건 미달성으로 실패하였습니다.");
				break;
			}
			// 다마고치가 생성되지 않은경우에는 진행되지 않음.
			if(check == 2) {
				sp.Fail();
				System.out.println("입력하신 다마고치가 존재하지 않습니다.");
				break;
			}
			// 불러온 다마고치로 게임시작!  (여기 시점부터 쓰레드로 다마고치의 hp , 목마름, 포만감을 일정시간이 지날때마다 조정한다.)
			//Pr.start();
			
			try {
				
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("                          다마고치의 조건확인 \r\n"
						+ "1. 30초마다 포만감 20 감소 , 목마름 15 증가 , HP 20감소가 이루어진다.\r\n"
						+ "2. 다른 활동을 5번이상 할 때 친구를 만나지 않으면 우울증 경고를 받으며 6번 초과시 실패 한다.\r\n"
						+ "3. hp (0미만시 경고 -50 실패)\r\n"
						+ "4. 포만감 (0미만 시 경고 -50 실패)\r\n"
						+ "5. 목마름 (100초과 시 경고 150 실패)\r\n"
						+ "6. 위의 조건을 만족하면서 iq_level, health_level, social_level을 올려 합산 스코어를 랭킹에 반영한다.");
				System.out.println(damagochi.toString());
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("               게임을 시작합니다               ");
				System.out.println("               1. 음식먹기                   ");
				System.out.println("               2. 마시기                 	   ");
				System.out.println("               3. 잠자기     				   ");
				System.out.println("               4. 휴식하기    ");
				System.out.println("               5. 운동하기    ");
				System.out.println("               6. 친구만나기  ");
				System.out.println("               7. 공부하기   ");
				System.out.println("               8. 종료      ");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.print("활동을 선택하세요 : ");

				menu = Integer.parseInt(sc.nextLine());
				sp.clearScreen();

				//thread.stop();
				// 음식먹기
				if(menu == 1) { 
					damagochi = damagochiservice.eat(damagochi);
					//마시기
				} else if(menu == 2) { 
					damagochi = damagochiservice.drinking(damagochi);
					//잠자기
				} else if(menu == 3) { 
					damagochi = damagochiservice.sleeping(damagochi);
					//휴식하기
				} else if(menu == 4) {
					damagochi = damagochiservice.resting(damagochi);
					// 운동하기
				} else if(menu == 5) {
					damagochi = damagochiservice.excercising(damagochi);
					// 친구만나기
				} else if(menu == 6) {
					damagochi = damagochiservice.friendmeeting(damagochi);
					// 공부하기
				} else if(menu == 7) {
					damagochi = damagochiservice.studying(damagochi);
					// 종료
				} else if(menu == 8) {
					System.out.println("다마고치 게임을 종료합니다.");
					//Pr.stop();
					break;
				} else {
					System.out.println("잘못 입력 하였습니다.");
				}
			} catch(Exception e) {
				sp.clearScreen();
			}
		}
	}


	private void damagochidelete () {
		Damagochi damagochi = new Damagochi();
		System.out.print("삭제할 다마고치의 이름을 입력하세요 : ");
		String damagochiName = sc.nextLine();
		sp.process();
		damagochi.setDamagochiName(damagochiName);
		damagochisignup.deleteDamagochi(damagochi);
	}


}
