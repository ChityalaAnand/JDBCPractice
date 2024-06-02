package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateQuery {
	
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/School";
	private static String userName = "root";
	private static String password = "Anand@9441437496";
	
	private static String updateQuery = "update FirstClass set fatherName = 'Saidaiah' where id = 5";

	public static void main(String[] args) {
		try {
			Class.forName(driverName);
			System.out.println("driver loading successfully....");
			Connection connection = DriverManager.getConnection(url,userName,password);
			System.out.println("Connection happened successfully.....");
			Statement statement = connection.createStatement();
			System.out.println("Statement created Successfully...");
			int a = statement.executeUpdate(updateQuery);
			System.out.println(a+"Rows updated successfully");
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
