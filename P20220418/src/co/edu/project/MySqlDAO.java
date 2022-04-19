package co.edu.project;

public class MySqlDAO implements DAO {

	@Override
	public void insert() {
		System.out.println("MySQL 입력처리.");
	}

	@Override
	public void update() {
		System.out.println("MySQL 수정처리.");
	}

	@Override
	public void delete() {
		System.out.println("MySQL 삭제처리.");
	}

	@Override
	public void list() {
		System.out.println("MySQL 리스트처리.");
	}
	
}
