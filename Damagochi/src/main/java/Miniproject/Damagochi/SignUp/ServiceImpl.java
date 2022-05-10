package Miniproject.Damagochi.SignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	@Override
	public int insertUser(User user) {
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
		return n;
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
				System.out.println("!!!!!!!!!!!!!로그인 성공!!!!!!!!!!!!!");
				return 1;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}

}
