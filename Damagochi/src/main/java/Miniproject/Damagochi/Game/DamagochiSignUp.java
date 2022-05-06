package Miniproject.Damagochi.Game;

import Miniproject.Damagochi.dto.Damagochi;

public interface DamagochiSignUp {
		// 다마고치 생성
		int insertDamagochi(Damagochi damagochi);
		// 다마고치 정보 저장
		int updateDamagochi(Damagochi damagochi);
		// 다마고치 삭제
		int deleteDamagochi(Damagochi damagochi);
		// 다마고치 읽어오기
		Damagochi readDamagochi(Damagochi damagochi);
}
