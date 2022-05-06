package Miniproject.Damagochi.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Miniproject.Damagochi.dao.DataSource;
import Miniproject.Damagochi.dto.Damagochi;

public class DamagochiSignUpImpl implements DamagochiSignUp {
	// dao 인스턴스를 생성하여 dataSource 참조변수에 대입.
		private DataSource dataSource = DataSource.getInstance();
		// Connection을 위한 인스턴스를 생성하여 conn 참조변수에 대입.
		private Connection conn = dataSource.getConnection();
		// sql 명령어 전송을 위한 인스턴스
		private PreparedStatement psmt;
		// sql 명령에 대한 결과값
		private ResultSet result;
		
		
	@Override
	public int insertDamagochi(Damagochi damagochi) {
		// 다마고치를 입력받은 사용자 이름, 다마고치 이름이 외의 값은 기본값으로 생성
		String sql = "INSERT INTO DAMAGOCHI VALUES (?,?,100,0,0,0,0,0,0,0)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damagochi.getUserId());
			psmt.setString(2, damagochi.getDamagochiName());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateDamagochi(Damagochi damagochi) {
		// 다마고치 업데이트
	
		int n = 0;
		String sql = "UPDATE DAMAGOCHI SET SATIETY = ? , THIRST = ?, IQ_EXP = ? , IQ_LEVEL = ?, SOCIAL_EXP = ?"
				+ ", SOCIAL_LEVEL = ? ,HEALTH_EXP = ?  ,HEALTH_LEVEL = ? WHERE DAMAGOCHI_NAME = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, damagochi.getSatiety());
			psmt.setInt(2, damagochi.getThirst());
			psmt.setInt(3, damagochi.getIqExp());
			psmt.setInt(4, damagochi.getIqLevel());
			psmt.setInt(5, damagochi.getSocialExp());
			psmt.setInt(6, damagochi.getSocialLevel());
			psmt.setInt(7, damagochi.getHealthExp());
			psmt.setInt(8, damagochi.getHealthLevel());
			psmt.setString(9, damagochi.getDamagochiName());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteDamagochi(Damagochi damagochi) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	// 다마고치 이름으로 검색하여 해당 다마고치의 정보를 Damagochi VO에 담아서 반환.
	public Damagochi readDamagochi(Damagochi damagochi) {
		Damagochi vo = new Damagochi();
		String sql = "SELECT * FROM DAMAGOCHI WHERE DAMAGOCHI_NAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damagochi.getDamagochiName());
			result = psmt.executeQuery();
			
			if(result.next()) {
				vo.setUserId(result.getString("USER_ID"));
				vo.setDamagochiName(result.getString("DAMAGOCHI_NAME"));
				vo.setSatiety(result.getInt("SATIETY"));
				vo.setThirst(result.getInt("THIRST"));
				vo.setIqExp(result.getInt("IQ_EXP"));
				vo.setIqLevel(result.getInt("IQ_LEVEL"));
				vo.setSocialExp(result.getInt("SOCIAL_EXP"));
				vo.setSocialLevel(result.getInt("SOCIAL_LEVEL"));
				vo.setHealthExp(result.getInt("HEALTH_LEVEL"));
				vo.setHealthLevel(result.getInt("HEALTH_LEVEL"));
			}
			//user_id랑 damagochi name을 못가져옴.
			
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return vo;
	}

}
