package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchingRecords {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/School";
	private static String userName = "root";
	private static String password = "Anand@9441437496";
	private static String fetchQuery = "select * from FirstClass";

	public static void main(String[] args) {
		try {
			Class.forName(driverName);
			System.out.println("driver loading successfully...");
			Connection connection = DriverManager.getConnection(url,userName,password);
			System.out.println("Connection Successfully...");
			Statement statement = connection.createStatement();
			System.out.println("statement created successfully...");
			ResultSet resultSet = statement.executeQuery(fetchQuery);
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int rollNum = resultSet.getInt("rollNum");
				String studentName = resultSet.getString("studentName");
				String fatherName = resultSet.getString("fatherName");
				int age = resultSet.getInt("age");
				System.out.println(id+" "+rollNum+" "+studentName+" "+fatherName+" "+age);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
