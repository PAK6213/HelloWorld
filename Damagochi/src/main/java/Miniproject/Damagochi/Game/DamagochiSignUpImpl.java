package Miniproject.Damagochi.Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Miniproject.Damagochi.Menu;
import Miniproject.Damagochi.StatePrint;
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
	StatePrint sp = new StatePrint();

	@Override
	public int insertDamagochi(Damagochi damagochi) {
		// 입력한 이름의 다마고치가 생성되어 있는지 확인
		String sql = "SELECT DAMAGOCHI_NAME FROM DAMAGOCHI WHERE DAMAGOCHI_NAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damagochi.getDamagochiName());
			result = psmt.executeQuery();
			if(result.next()) {
				sp.Fail();
				System.out.println("이미 생성된 닉네임이 있습니다.");
				System.out.println("다른 다마고치의 닉네임을 사용해주세요.");
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}



		// 다마고치를 입력받은 사용자 이름, 다마고치 이름이 외의 값은 기본값으로 생성
		String sql2 = "INSERT INTO DAMAGOCHI VALUES (?,?,100,0,0,1,0,1,0,1,100,0,0)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, damagochi.getUserId());
			psmt.setString(2, damagochi.getDamagochiName());
			n = psmt.executeUpdate();

			sp.success();
			System.out.println("다마고치 이름 : " + damagochi.getDamagochiName() + "으로 생성되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateDamagochi(Damagochi damagochi) {
		// 다마고치 업데이트

		int n = 0;
		String sql = "UPDATE DAMAGOCHI SET SATIETY = ? , THIRST = ?, IQ_EXP = ? , IQ_LEVEL = ?, SOCIAL_EXP = ?, SOCIAL_LEVEL = ? ,HEALTH_EXP = ?  ,HEALTH_LEVEL = ? , HP = ?, DEPRESSION_COUNT = ?, SCORE = ? WHERE DAMAGOCHI_NAME = ?";

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
			psmt.setInt(9, damagochi.getHp());
			psmt.setInt(10, damagochi.getDepressionCount());
			psmt.setInt(11, damagochi.getScore());
			psmt.setString(12, damagochi.getDamagochiName());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteDamagochi(Damagochi damagochi) {
		// 다마고치 이름으로 검색하여 해당 다마고치의 정보를 삭제 
		int n = 0;
		String sql = "DELETE FROM DAMAGOCHI WHERE DAMAGOCHI_NAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damagochi.getDamagochiName());
			n = psmt.executeUpdate();
			sp.success();
			System.out.println("다마고치 이름 : " + damagochi.getDamagochiName() + "이 정상삭제 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return n;
	}

	@Override
	// 다마고치 이름으로 검색하여 해당 다마고치의 정보를 Damagochi VO에 담아서 반환.
	public Damagochi readDamagochi(Damagochi damagochi) {
		Damagochi vo = new Damagochi();
		Damagochi vo2 = new Damagochi();
		String sql = "SELECT USER_ID FROM DAMAGOCHI WHERE DAMAGOCHI_NAME = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, damagochi.getDamagochiName());
			result = psmt.executeQuery();

			if(result.next()) {
				vo2.setUserId(result.getString("USER_ID"));
			}
		} catch(SQLException e) {

			e.printStackTrace();
		}	
		
		if(vo2.getUserId() == null) {
			vo2.setUserId("****");
		}


		if(vo2.getUserId().equals(Menu.loginId)) {
			String sql2 = "SELECT * FROM DAMAGOCHI WHERE DAMAGOCHI_NAME = ?";
			try {
				psmt = conn.prepareStatement(sql2);
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
					vo.setHp(result.getInt("HP"));
					vo.setDepressionCount(result.getInt("DEPRESSION_COUNT"));
					vo.setScore(result.getInt("SCORE"));
				}


			} catch(SQLException e) {

				e.printStackTrace();
			}
			// 불러올 다마고치를 찾을 수 없으면 		
		} else {
			System.out.println("사용자 계정의 다마고치가 아닙니다.");
		}
		return vo;


	}
	
	public List<Damagochi> selectListDamagochi() {
		// sql 쿼리문의 결과 데이터를 ArrayList에 담음.
		List<Damagochi> damagochis = new ArrayList<Damagochi>();
		Damagochi vo;
		String sql = "SELECT u.USER_ID AS 사용자이름, SUM(d.SCORE) AS 점수합계"
				+ " FROM USERS u JOIN DAMAGOCHI d"
				+ " ON (u.USER_ID = d.USER_ID)"
				+ "	GROUP BY u.USER_ID"
				+ " ORDER BY 2 DESC";
		try {
			psmt = conn.prepareStatement(sql);
			result = psmt.executeQuery();

			while(result.next()) {
				vo = new Damagochi();
				vo.setUserId(result.getString("사용자이름"));
				vo.setScore(result.getInt("점수합계"));
				damagochis.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return damagochis;
	}
	
	public List<Damagochi> DamagochiNameList() {
		List<Damagochi> damagochis = new ArrayList<Damagochi>();
		Damagochi vo;
		String sql = "SELECT USER_ID ,DAMAGOCHI_NAME FROM DAMAGOCHI WHERE USER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Menu.loginId);
			result = psmt.executeQuery();

			while(result.next()) {
				vo = new Damagochi();
				vo.setUserId(result.getString("USER_ID"));
				vo.setDamagochiName(result.getString("DAMAGOCHI_NAME"));
				damagochis.add(vo);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return damagochis;
	}
	//다마고치 
	public Damagochi readDamagochi2(String name) {
		Damagochi vo = new Damagochi();
		String sql2 = "SELECT * FROM DAMAGOCHI WHERE DAMAGOCHI_NAME = ?";
		try {
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, name);
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
				vo.setHp(result.getInt("HP"));
				vo.setDepressionCount(result.getInt("DEPRESSION_COUNT"));
				vo.setScore(result.getInt("SCORE"));
			}


		} catch(SQLException e) {

			e.printStackTrace();
		}
		
		return vo;
	}

}
