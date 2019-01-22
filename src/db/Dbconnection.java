package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

	private static String url="jdbc:mysql://localhost/application";
	private static String dbUser="root";
	private static String dbPass="";
	private static Connection con;
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,dbUser,dbPass);
			//System.out.println("Connection Data");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection Exception "+e);
		}
		return con;
	}
	public static void main(String[] args) {
		getConnection();
	}
}
