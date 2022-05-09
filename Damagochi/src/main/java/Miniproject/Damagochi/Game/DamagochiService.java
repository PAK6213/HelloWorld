package Miniproject.Damagochi.Game;

import Miniproject.Damagochi.dto.Damagochi;

public interface DamagochiService {
	
	
	public Damagochi eat(Damagochi damagochi);  // 음식먹기
	public Damagochi drinking(Damagochi damagochi);  // 마시기
	public Damagochi sleeping(Damagochi damagochi); // 잠자기
	public Damagochi resting(Damagochi damagochi); // 휴식하기
	public Damagochi excercising(Damagochi damagochi); // 운동하기
	public Damagochi friendmeeting(Damagochi damagochi); // 친구만나기
	public Damagochi studying(Damagochi damagochi); // 공부하기
	public int checking(Damagochi damagochi); // 다마고치의 조건확인
	
}
