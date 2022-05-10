package Book.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Test.Book.dao.DataSource;
import Test.Book.dto.BookVO;

public class BookServiceImpl implements BookService {
			private DataSource dataSource = DataSource.getInstance();
			private Connection conn = dataSource.getConnection();
			private PreparedStatement psmt;
			private ResultSet result;
			
	@Override
	public List<BookVO> BookList() {
		List<BookVO> list = new ArrayList<BookVO>();
		BookVO vo;
		String sql = "SELECT * FROM BOOK";
		
		try {
			conn = dataSource.getConnection(); // 커넥션 연결
			psmt = conn.prepareStatement(sql); // 쿼리문을 보내고 실행.
			result = psmt.executeQuery(); // 결과를 받아옴.
			while(result.next()) {// 읽을것이 있을 때 까지 반복. 
				vo = new BookVO(); // 결과를 받아올  인스턴스생성
				vo.setBookName(result.getString("BOOK_NAME"));
				vo.setWritername(result.getString("WRITER_NAME"));
				vo.setContent(result.getString("CONTENT"));
				vo.setRent(result.getString("RENT"));
				list.add(vo); // 하나의 noticeVO를 읽어서 ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookVO bookSelect(BookVO vo) {
		// 단건 조회
		String sql = "SELECT * FROM BOOK WHERE BOOK_NAME = ?";
		try {
			conn = dataSource.getConnection(); // 커넥션 연결
			psmt = conn.prepareStatement(sql); // 쿼리문을 보내고 실행.
			psmt.setString(1, vo.getBookName());
			result = psmt.executeQuery(); // 결과를 받아옴.
			
			if(result.next()) {
				vo = new BookVO(); // 하나를 보내야 하기 때문에 VO인스턴스 초기화
				vo.setBookName(result.getString("BOOK_NAME"));
				vo.setWritername(result.getString("WRITER_NAME"));
				vo.setContent(result.getString("CONTENT"));
				vo.setRent(result.getString("RENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int bookInsert(BookVO vo) {
		// 책등록
				String sql = "INSERT INTO BOOK VALUES(?,?,?,?)";
				
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getBookName());
					psmt.setString(2, vo.getWritername());
					psmt.setString(3, vo.getContent());
					psmt.setString(4, vo.getRent());
					psmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return 0;
	}

	@Override
	public List<BookVO> Bookrent() {
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOK WHERE RENT = '대여가능'";
		BookVO vo;
		try {
			conn = dataSource.getConnection(); // 커넥션 연결
			psmt = conn.prepareStatement(sql); // 쿼리문을 보내고 실행.
			result = psmt.executeQuery(); // 결과를 받아옴.
			while(result.next()) {// 읽을것이 있을 때 까지 반복. 
				vo = new BookVO(); // 결과를 받아올  인스턴스생성
				vo.setBookName(result.getString("BOOK_NAME"));
				vo.setWritername(result.getString("WRITER_NAME"));
				vo.setContent(result.getString("CONTENT"));
				vo.setRent(result.getString("RENT"));
				list.add(vo); // 하나의 noticeVO를 읽어서 ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<BookVO> Booksearch(BookVO vo) {
		List<BookVO> list = new ArrayList<BookVO>();
		String sql = "SELECT * FROM BOOK WHERE CONTENT LIKE '%'||?||'%'";
		try {
			conn = dataSource.getConnection(); // 커넥션 연결
			psmt = conn.prepareStatement(sql); // 쿼리문을 보내고 실행.
			psmt.setString(1, vo.getContent());
			result = psmt.executeQuery(); // 결과를 받아옴.
			while(result.next()) {// 읽을것이 있을 때 까지 반복. 
				vo = new BookVO(); // 결과를 받아올  인스턴스생성
				vo.setBookName(result.getString("BOOK_NAME"));
				vo.setWritername(result.getString("WRITER_NAME"));
				vo.setContent(result.getString("CONTENT"));
				vo.setRent(result.getString("RENT"));
				list.add(vo); // 하나의 noticeVO를 읽어서 ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	

}
