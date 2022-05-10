package Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Book.Service.BookService;
import Book.Service.BookServiceImpl;
import Test.Book.dto.BookVO;

public class Menu {
	BookService book = new BookServiceImpl();
	List<BookVO> list = new ArrayList<BookVO>();
	BookVO vo = new BookVO();
	BookVO vo2 = new BookVO();
	Scanner sc = new Scanner(System.in);
	public Menu () {

	}

	public void main() {
		boolean b = true;
		while(b) {
			menuTitle();
			System.out.print("메뉴선택>");
			int menu = sc.nextInt();
			sc.nextLine();

			if(menu == 1) {
				//전체조회
				list = book.BookList();
				for(BookVO vo : list) {
					vo.toString();
				}
				
			} else if(menu == 2) {
				//단건조회
				System.out.print("책제목>");
				String findName = sc.nextLine();
				vo2.setBookName(findName);
				vo2 = book.bookSelect(vo2);
				vo2.toString();
			} else if(menu == 3) {
				//내용검색
				System.out.print("검색내용>");
				String findContent = sc.nextLine();
				vo2.setContent(findContent);
				list = book.Booksearch(vo2);
				for(BookVO vo : list) {
					vo.toString();
				}
				
			} else if(menu == 4) {
				//대여가능
				list = book.Bookrent();
				for(BookVO vo : list) {
					vo.toString();
				}
			} else if(menu == 5) {
				//책 대여
			} else if(menu == 6) {
				//책 반납
			} else if(menu == 7) {
				//책 등록
				register();
			} else if(menu == 9) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
				
				//종료
			}

		}
	}

	public void menuTitle() {
		System.out.println("====================================================================================");
		System.out.println("1.전체조회 | 2.단건조회 | 3.내용검색 | 4.대여가능 | 5. 책 대여 | 6. 책 반납 | 7. 책 등록 | 9.종료");
		System.out.println("====================================================================================");

	}
	// 책등록
	public void register() {
		vo = new BookVO();
		System.out.println("책 등록을 시작합니다.");
		System.out.print("책 이름 : ");
		String bookName = sc.nextLine();
		vo.setBookName(bookName);
		System.out.print("저자 이름 :");
		String writer = sc.nextLine();
		vo.setWritername(writer);
		System.out.print("내용 :");
		String content = sc.nextLine();
		vo.setContent(content);
		System.out.print("대여여부 : ");
		String rent = sc.nextLine();
		vo.setRent(rent);

		book.bookInsert(vo);
	}

}
