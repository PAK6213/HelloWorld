package co.micol.geun.student.dao;
import java.io.FileReader;
import java.io.IOException;
//
/*
 JDBC 실행 순서
1. Class.forName(dirver) => jdbc 드라이버 연결
2. con = Drivermanager.getConnection(url(데이터베이스 물리적주소), id(사용자계정),pw(패스워드))
드라이버를 통해 DBMS와 연결
3. PreparedStatement(Sql문을 들고 connection을 통해 DBMS에게 가서 sql문을 실행을 요청)
   sql문에 대한 결과를 받는다.
   select -> resultset
   insert -> int
   delete -> int
   update -> int


DAO(Data Access Object) 

DTO(Data Transform object)
VO (멤버변수 게터 세터)


정리
Java에서 DataBase를 사용하기 위해서는
1. driver load
2. connection(Drivermanager를통해 연결)
3. PreparedStatement 객체를 통해 sql문을 connetion을 통해 전달하고 결과를 받아온다.
4. 받아온 결과를 이용하여 활용.

 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
// 싱글툰 class 패턴

public class DataSource {
	//싱글톤 class를 만드는 기본적인 방법.
	// 자신을 객체로 하나 만듦.
	private static DataSource dataSource = new DataSource();
	// 자기자신을 외부에서 생성못하게함.
	private DataSource() {};
	
	
	private Connection conn;  // App과 DBMS간의 연결객체
	private String driver;
	private String url;
	private String user;
	private String password;
	
	// 나를 호출해서 사용할 getInstance생성 (스택영역) -> static , class
	public static DataSource getInstance() {
		return dataSource;
	}
	
	// 연결
	public Connection getConnection() {
		configuration();  // properties driver url user password 값을 읽어옴.
		try {
			Class.forName(driver); //jdbc 드라이버 연결
			// DB와 Java가 연결될 통로를 만들자
			conn = DriverManager.getConnection(url, user, password); 
			System.out.println("DB 연결성공!!");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패!!");
		}
		return conn;
	}
	// Properties 객체를 이용하여 외부에 있는 파일을 읽어옴.
	private void configuration() {
		//Properties 경로를 읽어옴.  Properties 파일의 경로는 src/main/resources 밑에 있어야함.
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		try {
			//properties 객체에 한쌍씩 불러온다.
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
