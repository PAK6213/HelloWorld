package co.micol.geun.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import co.micol.geun.student.dao.DataSource;
import co.micol.geun.student.dto.StudentVO;
import co.micol.geun.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn = dataSource.getConnection(); // connection
	private PreparedStatement psmt; // sql 명령어 전송
	private ResultSet rs; // sql 명령에 대한 결과값 

	@Override
	public List<StudentVO> selectListStudent() {
		// 전체 학생 목록 가져오기
		List<StudentVO> students = new ArrayList<StudentVO>();  // result 값을 받기위한 ArrayList
		StudentVO student;  // rs의 값들을 하나읽어와서 Arraylist에 넣기위함.
		String sql = "SELECT * FROM STUDENT";  // sql 명령은 대문자
		try {
			psmt = conn.prepareStatement(sql); // conn 객체를 통해 sql명령어 전송 후 실행
			rs = psmt.executeQuery(); // sql을 실행하고 결과를 담음.
			
			while(rs.next()) {
				// 읽을 데이터가 있다면 rs에 저장된 읽고싶은 칼렁명을 통해 가져온다.
				student = new StudentVO(); // 인스턴스 초기화
				student.setStudentId(rs.getString("studentid"));
				student.setName(rs.getString("name"));
				student.setBirthDay(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student);
			}
		} catch (SQLException e) {  //DB가 꺼져있는경우 발생할 에외
			e.printStackTrace();
		}
		return students;
	}

	@Override
	// 한명조회
	public StudentVO selectStudent(StudentVO student) {
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql); //conn객체를 통해 sql 명령어 전송 및 실행
			psmt.setString(1, student.getStudentId());  // 첫번째 ?에 대응됨.
			rs = psmt.executeQuery(); // sql실행
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthDay(rs.getDate("birthday"));
				vo.setMajor(rs.getString("major"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
			}
			
			return vo;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int insertStudent(StudentVO student) {
		// 한명의 데이터 insert
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthDay());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate(); // insert는 executeUpdate
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {
		// 한명의 데이터 업데이트
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, ADDRESS = ?,"
			        	+ " TEL = ? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudent(StudentVO student) {
		// 한명의 데이터 삭제
		int n = 0;
		String sql = "DELETE FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
