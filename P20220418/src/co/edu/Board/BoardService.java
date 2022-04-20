package co.edu.Board;

import java.util.ArrayList;

public interface BoardService {
	// 인터페이스 상수 생성
	public int ADD = 1;
	public int MOD = 2;
	public int DEL = 3;
	public int DETAIL = 4;
	public int ALL = 5;
	public int END = 6;
	
	// 인터페이스 추상메서드 생성
	public void addBoard(Board board); // 글등록
	public void modBoard(Board board); // 글수정
	public void delBoard(int boardNo); // 글삭제
	public void detailBoard(int boardNo); // 글상세조회
	public void allBoard(); // 글전체조회
	
	
}
