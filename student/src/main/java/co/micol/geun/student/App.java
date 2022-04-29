package co.micol.geun.student;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.geun.student.dto.StudentVO;
import co.micol.geun.student.service.StudentService;
import co.micol.geun.student.serviceImpl.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	StudentService dao = new StudentServiceImpl();
    	int n = 0;
    	List<StudentVO> list = new ArrayList<StudentVO>();
    	list = dao.selectListStudent();
    	
    	for(StudentVO vo : list) {
    		vo.toString();
    	}
//    	
//    	System.out.println("==============================");
//    	
//    	StudentVO student = new StudentVO();
//    	student.setStudentId("parkk@abc.com");
//    	student = dao.selectStudent(student);
//    	student.toString();
//    	
//    	StudentVO student = new StudentVO();
//    	student.setStudentId("kee@abc.com");
//    	student.setName("이길동동");
//    	student.setBirthDay(Date.valueOf("2001-07-29"));
//    	student.setMajor("국어국문학과");
//    	student.setAddress("대구광역시 달서구 용산2동");
//    	student.setTel("010-5454-1212");
//    	
//    	n = dao.insertStudent(student);
//    	if(n != 0) {
//    		System.out.println("정상적으로 입력");
//    	} else {
//    		System.out.println("입력실패");
//    	}
    	
    }
}
