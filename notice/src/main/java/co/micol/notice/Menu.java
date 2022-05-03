package co.micol.notice;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.serviceImpl.NoticeServiceImpl;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private int menu;


	public void main() {
		menuTitle();
		boolean b = true;
		while(b) {
			System.out.print("이용하실 메뉴를 입력하세요 : ");
			menu = sc.nextInt();
			sc.nextLine();
			if(menu == 1) {
				studentMenu();
			}
			if(menu == 2) {
				boardMenu();
			}
		}
	}

	private void menuTitle() {
		System.out.println("=================================");
		System.out.println("     1.학생관리 2.공지사항 3. 종료    ");
		System.out.println("=================================");
	}

	private void boardMenu() {
		NoticeService notice = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo2 = new NoticeVO();
		int bmenu;
		boolean b = true;
	

		while(b) {
			System.out.println("=================================");
			System.out.println("============1.전체조회=============");
			System.out.println("============2.한건조회=============");
			System.out.println("============3.게시글등록============");
			System.out.println("============4.게시글수정============");
			System.out.println("============5.게시글삭제============");
			System.out.println("============6.메인메뉴==============");

			System.out.print("메뉴를 입력하세요 : ");
			bmenu = sc.nextInt();
			sc.nextLine();
			
			if(bmenu == 1) {
				// 전체 목록조회하기
				list = notice.noticeSelectList();
				for(NoticeVO vo : list) {
					vo.toString();
				}
			}else if(bmenu == 2) {
				// 한건 조회
				System.out.println("조회할 게시글 번호를 입력하세요 :");
				int findNum = sc.nextInt();
				sc.nextLine();
				vo2.setId(findNum);
				vo2 = notice.noticeSelect(vo2);
				vo2.toString2();
				break;
			}else if(bmenu == 3) {
				// 게시글 등록을 해야함. date처리부터 이어서
				System.out.print("게시글 번호를 입력하세요 :");
				int boardnum = sc.nextInt();
				sc.nextLine();
				vo2.setId(boardnum);
				System.out.print("작성자를 입력하세요 :");
				String boardWriter = sc.nextLine();
				vo2.setWriter(boardWriter);
				System.out.print("게시글 제목을 입력하세요 :");
				String boardTitle = sc.nextLine();
				vo2.setTitle(boardTitle);
				System.out.print("게시글 내용을 입력하세요 :");
				String boardSubject = sc.nextLine();
				vo2.setSubject(boardSubject);
				
				vo2.setHit(0);
						
				notice.noticeInsert(vo2);
			}else if(bmenu == 4) {
				notice.noticeUpdate(vo2);
			}else if(bmenu == 5) {
				notice.noticeDelete(vo2);
			}else if(bmenu == 6) {
				b = false;
			}else {
				System.out.println("잘못된 메뉴를 입력하였습니다.");
			}

		}

	}

	private void studentMenu() {
		StudentService student = new StudentServiceImpl();
		List<StudentVO> list = new ArrayList<StudentVO>();
		StudentVO vo2 = new StudentVO();
		int smenu;
		boolean b = true;
		

		while(b) {
			System.out.println("=================================");
			System.out.println("============1.전체조회=============");
			System.out.println("============2.한건조회=============");
			System.out.println("============3.학생등록============");
			System.out.println("============4.학생수정============");
			System.out.println("============5.학생삭제============");
			System.out.println("============6.메인메뉴============");
			System.out.print("메뉴를 입력하세요 : ");
			smenu = sc.nextInt();
			sc.nextLine();
			
			if(smenu == 1) {
				// 전체 조회하기
				list = student.selectListStudent();
				for(StudentVO vo : list) {
					vo.toString();
				}
			}else if(smenu == 2) {
				// id로 조회하기
				vo2.setStudentId("park@abc.com");
				vo2 = student.selectStudent(vo2);
				vo2.toString();
			}else if(smenu == 3) {
				//학생등록
				System.out.print("등록할 학생의 학번을 입력하세요.");
				String stuid = sc.nextLine();
				vo2.setStudentId(stuid);
				System.out.print("등록할 학생의 이름을 입력하세요.");
				String stuname = sc.nextLine();
				vo2.setName(stuname);
				System.out.print("등록할 학생의 생일을 입력하세요.");
				String stubir = sc.nextLine();
				vo2.setBirthDay(Date.valueOf(stubir));
				System.out.print("등록할 학생의 전공을 입력하세요.");
				String stumajor = sc.nextLine();
				vo2.setMajor(stumajor);
				System.out.print("등록할 학생의 주소를 입력하세요.");
				String stuaddress = sc.nextLine();
				vo2.setAddress(stuaddress);
				System.out.print("등록할 학생의 연락처를 입력하세요.");
				String stutel = sc.nextLine();
				vo2.setTel(stutel);
				
				student.insertStudent(vo2);
		    	
			}else if(smenu == 4) {
				// 수정할 id를 입력하고 그에따른 수정. 
				System.out.print("수정할 학생의 id를 입력하세요.");
				String modifyname = sc.nextLine();
				vo2.setStudentId(modifyname);
				System.out.print("수정할 학생의 전공을 입력하세요.");
				String modifymajor = sc.nextLine();
				vo2.setMajor(modifymajor);
				System.out.print("수정할 학생의 주소를 입력하세요.");
				String modifyadd = sc.nextLine();
				vo2.setAddress(modifyadd);
				System.out.print("수정할 학생의 연락처를 입력하세요.");
				String modifytel = sc.nextLine();
				vo2.setTel(modifytel);
				student.updateStudent(vo2);
	
			}else if(smenu == 5) {
				// id를 읽어서 삭제하기.
				System.out.print("삭제할 학생의 id를 입력하세요.");
				String deleteId = sc.nextLine();
				vo2.setStudentId(deleteId);
				student.deleteStudent(vo2);
			}else if(smenu == 6) {
				//종료
				b = false;
			}else {
				System.out.println("잘못된 메뉴를 입력하였습니다.");
			}
		}
	}
}
