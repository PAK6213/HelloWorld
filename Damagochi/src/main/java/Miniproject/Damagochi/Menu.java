package Miniproject.Damagochi;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
//	// user의 정보를 담기위한 ArrayList
//	List<User> userlist = new ArrayList<User>();
//	// damagochi의 정보를 담기위한 ArrayList
//	List<Damagochi> damagochilist = new ArrayList<Damagochi>();
	List<Damagochi> damagochis = new ArrayList<Damagochi>();
	Service service = new ServiceImpl();
	DamagochiService damagochiservice = new DamagochiImpl();
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();
	private String loginId;
	private Scanner sc = new Scanner(System.in);
	private int menu;

	// main Menu 실행
	public void main() {

		boolean b = true;

		while(b) {
			menuTitle();
			System.out.print("안녕하세요. 이용하실 메뉴를 입력하세요 : ");
			
			try {
				menu = sc.nextInt();
				sc.nextLine();
				if(menu == 1) { // 회원 가입.
					signUp();		
				} else if(menu == 2) { // 로그인
					login();
				} else if(menu == 3) { // 순위
					rank();
				} else if(menu == 4) {
					System.out.println("종료");
					break;
				} else {
					System.out.println("잘못입력");
				}
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요!!!");
			}
		}
	}

	// first MenuTitle
	private void menuTitle() {
		System.out.println("==========================================");
		System.out.println("============ 메뉴를 선택하세요.===============");
		System.out.println("============    1.회원가입 =================");
		System.out.println("============    2.로그인   ================");
		System.out.println("============    3.순위    =================");
		System.out.println("============    4.종료    =================");
		System.out.println("==========================================");

	}
	// 회원가입 
	private void signUp() {
		
		User user = new User();
		System.out.println("회원가입을 진행합니다.");
		System.out.print("userId를 입력하세요 : ");
		String userId = sc.nextLine();
		user.setUserId(userId);
		System.out.print("passWord를 입력하세요 : ");
		String password = sc.nextLine();
		user.setPassword(password);
		System.out.print("age를 입력하세요 : ");
		int age = sc.nextInt();
		sc.nextLine();
		user.setAge(age);
		System.out.print("birthDay를 입력하세요 : ");
		String birthDay = sc.nextLine();
		user.setBirthDay(birthDay);
		System.out.print("tel을 입력하세요 : ");
		String tel = sc.nextLine();
		user.setTel(tel);
		// 각 정보를 입력받아서 insert
		service.insertUser(user);
		
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

			result = service.loginuser(user);
			//0 : 비밀번호 오류  1 : 접속완료  2 : ID 생성이 되지 않음.
			if(result == 1) {
				damagochiMenu();
				break;
			} else if(result == 2) {
				System.out.println("생성된 아이디가 없습니다. 회원가입을 해주세요!!");
				break;
			}else{
				System.out.println("비밀번호가 틀렸습니다. 다시 입력하세요");
			}
		}
	}
	
	// 사용자의 score 기준으로 정렬하여 출력
	private void rank() {
		int rank = 1;
		damagochis = damagochisignup.selectListDamagochi();
		System.out.println("===============순위================");
		System.out.println("     user_id          score       ");
		for(Damagochi da : damagochis) {
			System.out.printf("%d등   %-10s  %5d\n",rank,da.getUserId(),da.getScore());
			rank++;
		}
	}



	private void damagochiMenu() {
		

		boolean b = true;
		while(b) {
			System.out.println("==========================================");
			System.out.println("==========다마고치 게임을 시작합니다.===========");
			System.out.println("============ 1.다마고치 생성 ================");
			System.out.println("=============2.다마고치 불러오기==============");
			System.out.println("=============3.다마고치 삭제=================");
			System.out.println("=============4.이전메뉴    =================");
			System.out.println("==========================================");
			System.out.print("안녕하세요. 이용하실 메뉴를 입력하세요 : ");
			menu = sc.nextInt();
			sc.nextLine();

			try {
				if(menu == 1) { 
					// 다마고치 생성
					damagochiMenuSignUp();
					
				} else if(menu == 2) { 
					// 플레이 할 다마고치 불러와 게임시작
					damagochiloadToplay();
					
				} else if(menu == 3) {
					// 다마고치 삭제
					damagochidelete();
					
				} else if(menu == 4) {
					//이전메뉴로 돌아가기.
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
	
	// 이름은 입력받고 나머지 변수는 기본값으로 적용.
	// 중복된 다마고치의 이름이 있는지 확인해야함. (O)
	private void damagochiMenuSignUp () {
		Damagochi damagochi = new Damagochi();
		System.out.print("생성할 다마고치 이름을 입력하세요 : ");
		String damagochiName = sc.nextLine();
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
		String damagochiName = sc.nextLine();
		damagochi.setDamagochiName(damagochiName);
		damagochi = damagochisignup.readDamagochi(damagochi);
		
		
		boolean b = true;
		while(b) {
			/* 다마고치의 조건확인 
			1. 활동을 한번 할 때 satiety 감소 , thirst 증가는 무조건 이루어진다.
			2. 잠자기 및 휴식을 제외한 활동은 hp가 감소한다.
			3. 다른 활동을 3번이상 할 때 친구를 만나지 않으면 우울증 경고를 받으며 5번 초과시 실패 한다. !!
			4. hp (0미만시 경고 -50 실패)
			5. satiety (0미만 시 경고 -50 실패)
			6. thirst (100초과 시 경고 150 실패)*/
						
			
			// 메뉴가 한번 수행되고 나서 다마고치의 성공 실패 조건을 수행한 뒤 업데이트
			// 다마고치가 조건으로 실패했을경우 해당 다마고치를 삭제하고 이전메뉴로이동.
			damagochisignup.updateDamagochi(damagochi);
			check = damagochiservice.checking(damagochi);
			if(check == 1) {
				damagochisignup.deleteDamagochi(damagochi);
				break;
			}
			// 다마고치가 생성되지 않은경우에는 진행되지 않음.
			if(check == 2) {
				System.out.println("입력하신 다마고치가 존재하지 않습니다.");
				System.out.println("다마고치를 생성 후 진행하세요!!!!!!!");
				break;
			}
			
			//Thread thread = new Print();
			//thread.start();
			
			// 불러온 다마고치로 게임시작!
			System.out.println("선택하신 다마고치의 정보는 다음과 같습니다.\n" + damagochi.toString());
			System.out.println("===============게임을 시작합니다===============");
			System.out.println("===============1. 음식먹기    ===============");
			System.out.println("===============2. 마시기     ===============");
			System.out.println("===============3. 잠자기     ===============");
			System.out.println("===============4. 휴식하기    ===============");
			System.out.println("===============5. 운동하기    ===============");
			System.out.println("===============6. 친구만나기  ===============");
			System.out.println("===============7. 공부하기    ===============");
			System.out.println("===============8. 종료      ================");
			System.out.print("활동을 선택하세요 : ");
			menu = sc.nextInt();
			sc.nextLine();
			//thread.stop();
			try {
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
					//thread.stop();
					break;
				} else {
					System.out.println("잘못 입력 하였습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	private void damagochidelete () {
		Damagochi damagochi = new Damagochi();
		System.out.print("삭제할 다마고치의 이름을 입력하세요 : ");
		String damagochiName = sc.nextLine();
		damagochi.setDamagochiName(damagochiName);
		damagochisignup.deleteDamagochi(damagochi);
	}
	
}
