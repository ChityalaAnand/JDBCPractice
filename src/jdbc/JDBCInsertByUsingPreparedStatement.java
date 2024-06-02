package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertByUsingPreparedStatement {
	
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/School";
	private static String userName = "root";
	private static String password = "Anand@9441437496";
	
	private static String insertQuery = "insert into SecondClass (id,rollNum,studentName,fatherName,age)"
			+ "values(?,?,?,?,?)";

	public static void main(String[] args) {
		try {
			Class.forName(driverName);
			System.out.println("class loading successfully...");
			Connection connection = DriverManager.getConnection(url,userName,password);
			System.out.println("connection successfull...");
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, 2);
			preparedStatement.setInt(2,2);
			preparedStatement.setString(3, "Gundu Varun");
			preparedStatement.setString(4,"Mahesh");
			preparedStatement.setInt(5,12);
			boolean bb = preparedStatement.execute();
			
			System.out.println(preparedStatement.toString());
			System.out.println("statement created successfully.... "+bb);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
