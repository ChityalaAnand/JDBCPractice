package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBVDeleteQuery {
	
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/School";
	private static String userName = "root";
	private static String password = "Anand@9441437496";

	private static String deleteQuery = "delete from FirstClass where id = 5";

	public static void main(String[] args) {
		try {
			Class.forName(driverName);
			System.out.println("driver loading successfully.....");
			Connection connection = DriverManager.getConnection(url,userName,password);
			System.out.println("Connecion Successfylly....");
			Statement statement = connection.createStatement();
			System.out.println("Statement created successfully...");
			int deletedRows = statement.executeUpdate(deleteQuery);
			
			System.out.println(deletedRows+" Rows deleted");
			
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
