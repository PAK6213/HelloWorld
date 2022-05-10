package Test.Book.dto;

import lombok.Data;

@Data

public class BookVO {
	private String bookName; // 책제목
	private String writername; // 저자
	private String content; // 내용
	private String rent; // 대여
	
	public BookVO () {
		
	}
	
	@Override
	public String toString() {
		System.out.println("책제목 : " + this.getBookName() + ", 저자명 : " + this.getWritername() + ", 내용 : " + this.getContent() + ", 대여여부 : " + this.getRent());
		return null;
	
	}
}
