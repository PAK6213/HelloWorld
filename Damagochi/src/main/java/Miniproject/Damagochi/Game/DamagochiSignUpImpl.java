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
		String sql = "INSERT INTO DAMAGOCHI VALUES (?,?,?,?,?,?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damagochi.getUserId());
			psmt.setString(2, damagochi.getDamagochiName());
			psmt.setInt(3, damagochi.getSatiety());
			psmt.setInt(4, damagochi.getThirst());
			psmt.setInt(5, damagochi.getIqExp());
			psmt.setInt(6, damagochi.getIqLevel());
			psmt.setInt(7, damagochi.getSocialExp());
			psmt.setInt(8, damagochi.getSocialLevel());
			psmt.setInt(9, damagochi.getHealthExp());
			psmt.setInt(10, damagochi.getHealthLevel());
			n = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateDamagochi(Damagochi damagochi) {
		// TODO Auto-generated method stub
		return 0;
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
				vo.setDamagochiName(result.getString("DAMAGOCHI_NAME"));
				vo.setSatiety(result.getInt("SATITEY"));
				vo.setThirst(result.getInt("THIRST"));
				vo.setIqExp(result.getInt("IQ_EXP"));
				vo.setIqLevel(result.getInt("IQ_LEVEL"));
				vo.setSocialExp(result.getInt("SOCIAL_EXP"));
				vo.setSocialLevel(result.getInt("SOCIAL_LEVEL"));
				vo.setHealthExp(result.getInt("HEALTH_LEVEL"));
				vo.setHealthLevel(result.getInt("HEALTH_LEVEL"));
			}
			//user_id랑 damagochi name을 못가져옴.
			System.out.println(vo.toString() + " 불러오기 성공!!");
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return vo;
	}

}
