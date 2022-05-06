package Miniproject.Damagochi;

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
			menu = sc.nextInt();
			sc.nextLine();


			try {
				if(menu == 1) { // 회원 가입.
					signUp();		
				} else if(menu == 2) { // 로그인
					login();
				} else if(menu == 3) { // 순위

				} else if(menu == 4) {
					System.out.println("종료");
					break;
				} else {
					System.out.println("잘못입력");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// first MenuTitle
	private void menuTitle() {
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("=========안녕하세요!! 메뉴를 선택하세요.========");
		System.out.println("================1.회원가입 =================");
		System.out.println("================2.로그인   ================");
		System.out.println("================3.순위    =================");
		System.out.println("================4.종료    =================");
		System.out.println("==========================================");
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
			//0 : 접속불가  1 : 접속완료
			if(result == 1) {
				break;
			} else {
				System.out.println("입력 정보가 다릅니다. 다시 입력하세요");
			}
		}
		damagochiMenu();
	}



	private void damagochiMenu() {
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("==========다마고치 게임을 시작합니다.===========");
		System.out.println("============ 1.다마고치 생성 ================");
		System.out.println("=============2.다마고치 불러오기==============");
		System.out.println("=============3.다마고치 저장=================");
		System.out.println("=============4.다마고치 삭제=================");
		System.out.println("=============5.이전메뉴    =================");
		System.out.println("==========================================");

		boolean b = true;
		while(b) {
			System.out.print("안녕하세요. 이용하실 메뉴를 입력하세요 : ");
			menu = sc.nextInt();
			sc.nextLine();

			try {
				// 다마고치 생성
				if(menu == 1) { 
					damagochiMenuSignUp();
					// 플레이 할 다마고치 불러와 게임시작
				} else if(menu == 2) { 
					damagochiloadToplay();
					// 다마고치 저장
				} else if(menu == 3) { 

					// 다마고치 삭제
				} else if(menu == 4) {

					//이전메뉴로 돌아가기.
				} else if(menu == 5) {
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}
	
	// 이름은 입력받고 나머지 변수는 기본값으로 적용.
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
		Damagochi damagochi = new Damagochi();
		System.out.print("불러올 다마고치의 이름을 입력하세요 : ");
		String damagochiName = sc.nextLine();
		damagochi.setUserId(damagochiName);
		damagochisignup.readDamagochi(damagochi);
		
	}
	
	
}
