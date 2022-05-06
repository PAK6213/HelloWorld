package Miniproject.Damagochi.Game;

import Miniproject.Damagochi.dto.Damagochi;

public interface DamagochiService {
	
	
	public Damagochi eat(Damagochi damagochi);  // 음식먹기
	public void drinking();  // 마시기
	public void sleeping(); // 잠자기
	public void resting(); // 휴식하기
	public void excercising(); // 운동하기
	public void friendmeeting(); // 친구만나기
	public void studying(); // 공부하기
}
