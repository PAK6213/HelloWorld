package Miniproject.Damagochi;

import Miniproject.Damagochi.Game.DamagochiSignUp;
import Miniproject.Damagochi.Game.DamagochiSignUpImpl;
import Miniproject.Damagochi.dto.Damagochi;

public class Print extends Thread {
	Damagochi damagochi = new Damagochi();
	DamagochiSignUp damagochisignup = new DamagochiSignUpImpl();
	@Override
	// 일정 시간이 지나면 체력 포만감 갈증 수치증가 후 업데이트 !!
	public void run() {
		while(true) {
			
			
			try {
				sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

	}

}
