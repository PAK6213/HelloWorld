package Test.Book.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	//싱글톤 기본 생성
	//자기자신의 인스턴스를 하나 만들고 자신생성자 private 생성 
	private static DataSource dataSource = new DataSource();
	private DataSource() {};
	
	// App과 DBMS 연결을 위해 사용할 멤버변수들.
	private Connection conn; 
	private String driver;
	private String url;
	private String user;
	private String password;
	
	// 만든 인스턴스를 사용할수 있도록 리턴
	public static DataSource getInstance() {
		return dataSource;
	}
	
	// Connection 연결 : App과 DBMS 연결
	public Connection getConnection() {
		dbConfig();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 외부에서 properties 파일을 가져오기 , src/main/resources 에 해당 파일이 있어야함.
	private void dbConfig() {
		Properties properties = new Properties(); // Properties 인스턴스생성
		String resource = getClass().getResource("/db.properties").getPath();  //resource에 db.properties의 파일을 가져옴 .
		try {
			properties.load(new FileInputStream(resource)); // resource 경로의 파일 값을 읽어 로드
			// key값을 읽어 해당하는 value값을 저장한다.	
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}

