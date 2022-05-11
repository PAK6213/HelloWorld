package Miniproject.Damagochi.SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Miniproject.Damagochi.StatePrint;
import Miniproject.Damagochi.dao.DataSource;
import Miniproject.Damagochi.dto.User;

public class ServiceImpl implements Service {
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
	public int insertUser(User user) {
		// 입력받은 회원의 ID가 가입되어있는지 확인
		User user2 = new User();
		String sql2 = "SELECT USER_ID FROM USERS WHERE USER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, user.getUserId());
			result = psmt.executeQuery();
					
			if(result.next()) {
				user2.setUserId(result.getString("USER_ID"));
				} 
				if(user2.getUserId() != null) {
					return 2;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 한명의 회원 데이터를 입력받아 DB로 insert
		String sql = "INSERT INTO USERS VALUES(?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			psmt.setString(2, user.getPassword());
			psmt.setInt(3, user.getAge());
			psmt.setString(4, user.getBirthDay());
			psmt.setString(5, user.getTel());
			n = psmt.executeUpdate(); // insert는 executeUpdate
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 1;
	}
	
	@Override
	// User 인스턴스를 받아 DB에 저장된 ID, password와 매칭하여 로그인 여부를 반환
	// user : 입력한 아이디 및 패스워드 정보를 가짐  user2 : 매칭된 ID의 DB에 존재하는 password
	public int loginuser(User user) { 
		User user2 = new User();
		String sql = "SELECT USER_ID, PASSWORD FROM USERS WHERE USER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			result = psmt.executeQuery();
			
			if(result.next()) {
				user2.setPassword(result.getString("PASSWORD"));
				user2.setUserId(result.getString("USER_ID"));
			} 
			if(user2.getUserId() == null) {
				return 2;
			}
			if(user.getPassword().equals(user2.getPassword())) {
				sp.success();
				System.out.println("계정명 : " + user2.getUserId() + "으로 접속되었습니다.");
				return 1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	
	public int Deleteuser(User user) {
		
		// 0: 정상 삭제 1 : 입력한 패스워드가 불일치함. 2 : 생성된 아이디가 없음
		User user2 = new User();
		String sql = "SELECT USER_ID, PASSWORD FROM USERS WHERE USER_ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUserId());
			result = psmt.executeQuery();
			
			if(result.next()) {
				user2.setUserId(result.getString("USER_ID"));
				user2.setPassword(result.getString("PASSWORD"));
			}
			
			if(user2.getUserId() == null) {
				return 2;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		// 입력한 패스워드가 일치한다면 삭제 아니면 삭제불가능
		if(user2.getPassword().equals(user.getPassword())) {
			int n = 0;
			String sql2 = "DELETE FROM USERS WHERE USER_ID = ?";
			try {
				psmt = conn.prepareStatement(sql2);
				psmt.setString(1, user.getUserId());
				n = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		} else {
			return 1;
		}
	}

}
