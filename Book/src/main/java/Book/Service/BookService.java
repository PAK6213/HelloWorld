package Book.Service;
import java.util.List;

import Test.Book.dto.BookVO;


public interface BookService {
	List<BookVO> BookList(); // 전체조회
	BookVO bookSelect(BookVO vo); 
	int bookInsert(BookVO vo); // 책등록
	List<BookVO> Bookrent(); // 대여가능 책 조회
	List<BookVO> Booksearch(BookVO vo);
}
