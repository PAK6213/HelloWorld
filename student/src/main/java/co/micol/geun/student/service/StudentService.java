package co.micol.geun.student.service;

import java.util.List;

import co.micol.geun.student.dto.StudentVO;

public interface StudentService {
	//READ
	// 모든 학생의 정보를 조회
	List<StudentVO> selectListStudent(); 
	// 한명의 학생 정보를 조회
	StudentVO selectStudent(StudentVO student); 
	// 한명의 학생 추가
	int insertStudent(StudentVO student);
	// 한명의 학생 갱신
	int updateStudent(StudentVO student);
	// 한명의 학생 삭제
	int deleteStudent(StudentVO student);
}
