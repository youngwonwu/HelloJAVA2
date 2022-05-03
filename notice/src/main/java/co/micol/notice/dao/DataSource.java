package co.micol.notice.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//dao는 관례적으로 DataSource 이름을 쓴다
public class DataSource {	//싱클툰
	
	////3
	private static DataSource dataSource = new DataSource();
	private DataSource() {};	//외부에서 생성 못하도록
	
	//사용할 변수
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
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
	
	//db.properties을 읽어올수 있도록
	private void dbConfig() {
		Properties properties = new Properties();	//객체만들고
		String resource = getClass().getResource("/db.properties").getPath();	///db.properties 읽어옴
		try {
			properties.load(new FileInputStream(resource));
			//변수 값 담기
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
