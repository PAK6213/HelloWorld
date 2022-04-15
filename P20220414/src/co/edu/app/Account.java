package co.edu.app;

public class Account {
	// 필드 : 계좌번호(String 유니크 ,키역할임), 예금주(String), 잔액(int)
	
	private int money; // 잔액
	private String name; // 예금주
	private String accountNumber; // 계좌번호
	
	
	// 생성자
	Account (int money , String name, String accountNumber) {
		this.money = money;
		this.name = name;
		this.accountNumber = accountNumber;
	}

	// getter, setter
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void getInfo() {
		// 게시글번호 제목 내용 작성자 조회수
		System.out.printf("%-20s %-30s %d \n",this.name, this.accountNumber, this.money);
	}
	
	
}
