package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTableCreationByUsingPreparedStatement {
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/School";
	private static String userName = "root";
	private static String password = "Anand@9441437496";
	private static String creationOfTable = "create table SecondClass (id int not null primary key,rollnum int not null unique,"
											+ "studentName varchar(100) not null,"
											+ "fatherName varchar(100) not null,age int not null)";
	
	public static void main(String[] args) {
		
		try {
			Class.forName(driverName);
			System.out.println("class loading successfully...");
			Connection connection = DriverManager.getConnection(url,userName,password);
			System.out.println("connection successfull...");
			Statement statement = connection.createStatement();
			System.out.println("statement created successfully....");
			boolean tablecreation = statement.execute(creationOfTable);
			System.out.println("table created successfully... "+tablecreation);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
