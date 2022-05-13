package Miniproject.Damagochi;

import Miniproject.Damagochi.Game.DamagochiImpl;
import Miniproject.Damagochi.Game.DamagochiService;
import Miniproject.Damagochi.Game.DamagochiSignUp;
import Miniproject.Damagochi.Game.DamagochiSignUpImpl;
import Miniproject.Damagochi.dto.Damagochi;

public class Print extends Thread {
	DamagochiService damagochiservice = new DamagochiImpl();
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();
	@Override
	// 일정 시간이 지나면 체력 포만감 갈증 수치증가 후 업데이트 !!
	public void run() {
		// 다마고치 정보 불러오기
		StatePrint sp = new StatePrint();
		int check = 0;
		Damagochi damagochi = new Damagochi();
		damagochi = damagochisignup.readDamagochi2(Menu.damagochiName);
		while(true) {
			try {
				Thread.sleep(20000);
				damagochi.setHp(damagochi.getHp() - 20);	
				//System.out.println("5초경과로 HP가 20 감소하였습니다.");
				damagochi.setThirst(damagochi.getThirst() + 15);	
				//System.out.println("5초경과로 목마름이 15 증가하였습니다.");
				damagochi.setSatiety(damagochi.getSatiety() - 20);
				//System.out.println("5초경과로 배고픔이 20 감소하였습니다.");
				
				
				damagochisignup.updateDamagochi(damagochi);
				check = damagochiservice.checking(damagochi);
				if(check == 1) {
					damagochisignup.deleteDamagochi(damagochi);
					sp.clearScreen();
					sp.death();
					System.out.println(damagochi.getDamagochiName() + "가 조건 미달성으로 실패하였습니다.");
					System.out.println("진행하려면 Enter를 누르세요!!");
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
