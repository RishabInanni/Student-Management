package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

	public String user= "root";
	public final String password="20051955";
	public String url="jdbc:mysql://localhost:3306/studentmanagement";
	
	public String driverString="com.mysql.cj.jdbc.Driver";
	static Connection connection;
	
	private static DBconnection DB = new DBconnection();
	
	
	private DBconnection() {
		try {
			Class.forName(driverString);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private Connection createConnection() {
		connection = null;
		try {
			
			connection = DriverManager.getConnection(url,user,password);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("connection creation failed");
		}
		return connection;
		
	}
	
	public static Connection getConnection() {
		return DB.createConnection();
	}
	
	
}
