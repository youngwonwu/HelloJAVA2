package co.micol.student.dao;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.module.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {	//싱글툰 class 패턴
	
	//private static Connection conn;	//자신을 객체로 만들고
	//private DataSource() {}	// 자기자신을 외부에서 사용 못하도록 private
	
//	private static String driver = "oracle.jdbc.driver.OracleDriver";
//	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private static String user = "micol";
//	private static String password = "1234";
	
	private static DataSource dataSource = new DataSource();	//인스턴스
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {
		
	}
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {	//연결함
		try {
			configuration();
			Class.forName(driver);	//내 앱과 연결함 driver loading 
			conn = DriverManager.getConnection(url, user, password);	// 연결할 수있는 터널만듬, 사용자의 주소, 계정, 비번 입력
			System.out.println("DB 연결성공");
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패");
		}
		return conn;
	}
	
	
	//리소스 파일 읽어오기?
	private void configuration() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
