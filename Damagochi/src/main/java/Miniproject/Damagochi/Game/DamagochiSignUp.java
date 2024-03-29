package Miniproject.Damagochi.Game;

import java.util.List;

import Miniproject.Damagochi.dto.Damagochi;

public interface DamagochiSignUp {
		// 다마고치 생성
		int insertDamagochi(Damagochi damagochi);
		// 다마고치 정보 저장
		int updateDamagochi(Damagochi damagochi);
		// 다마고치 정보 저장
		public void updateDamagochi2(String name);
		// 다마고치 삭제
		int deleteDamagochi(Damagochi damagochi);
		// 다마고치 읽어오기
		Damagochi readDamagochi(Damagochi damagochi);
		// 다마고치 랭크
		public List<Damagochi> selectListDamagochi();
		
		public List<Damagochi> DamagochiNameList();
		// 스레드에서 다마고치 정보 불러오기
		public Damagochi readDamagochi2(String name);
		
		
		// exp, level update
		public void DamagochiIQLevelUp(String name);
		public void DamagochiIQExp(String name , int number);
		public void DamagochiHealthLevelUp(String name);
		public void DamagochiHealthExp(String name , int number);
		public void DamagochiSocialLevelUp(String name);
		public void DamagochiSocialExp(String name , int number);
		
		// constraint
		public void DamagochiHpCon();
		public void DamagochiThirstCon();
		public void DamagochiSatiteyCon();
		public void DamagochiDepression();
		
		//score set
		public void DamagochiScore(String name);
}
