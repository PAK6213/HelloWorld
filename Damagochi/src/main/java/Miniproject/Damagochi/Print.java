package Miniproject.Damagochi;

import Miniproject.Damagochi.Game.DamagochiImpl;
import Miniproject.Damagochi.Game.DamagochiService;
import Miniproject.Damagochi.Game.DamagochiSignUp;
import Miniproject.Damagochi.Game.DamagochiSignUpImpl;
import Miniproject.Damagochi.dto.Damagochi;

public class Print extends Thread {
	private boolean stop;
	DamagochiService damagochiservice = new DamagochiImpl();
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	

	@Override
	// 일정 시간이 지나면 체력 포만감 갈증 수치증가 후 업데이트 !!
	public void run() {
		// 다마고치 정보 불러오기
		StatePrint sp = new StatePrint();
		int check = 0;
		Damagochi damagochi = new Damagochi();
		
		while(!stop) {
			try {
				Thread.sleep(1000); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("스레드 종료");
			}
			
			damagochisignup.updateDamagochi2(Menu.damagochiName);
			System.out.println("");
			System.out.println("30초 경과로 인해 HP -20 포만감 -20 목마름 15 수치 변동이 있습니다.");
			
			damagochi = damagochisignup.readDamagochi2(Menu.damagochiName);
			damagochisignup.updateDamagochi(damagochi);
			System.out.println(damagochi.toString());
			
			check = damagochiservice.checking(damagochi);
			if(check == 1) {
				damagochisignup.deleteDamagochi(damagochi);
				sp.clearScreen();
				sp.death();
				System.out.println(damagochi.getDamagochiName() + "가 조건 미달성으로 실패하였습니다.");
				System.out.println("진행하려면 Enter를 누르세요!!");
				break;
			}

		}

	}

}
