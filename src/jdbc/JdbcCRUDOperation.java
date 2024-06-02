package jdbc;

import java.sql.*;


public class JdbcCRUDOperation {
	
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/School";
	private static String userName = "root";
	private static String password = "Anand@9441437496";
	


	public static void main(String[] args) {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url,userName,password);
			createTable(connection);
			System.out.println("table creation method successfully completed...");
			insertDataIntoTable(connection);
			System.out.println("Data inserted method succesfully completed..");
			fetchingRecordsFromTable(connection);
			System.out.println("records fetched successfully...");
			updateDataIntoTable(connection);
			System.out.println("data updated method successfully completed...");
			deletRecordFromTable(connection);
			System.out.println("Record deltion method successfully completed");
			fetchingRecordsFromTable(connection);
			System.out.println("CRUD operation compleated successfully...");
		}	
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	private static void createTable(Connection connection) {
		try {
			Statement statement = connection.createStatement();
			boolean tableCreated = statement.execute("create table FamilyMember (id int primary key unique,name varchar(100) not null,fatherName varchar(100) not null,age int not null)");
			System.out.println("table created successfully...."+tableCreated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void insertDataIntoTable(Connection connection) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("insert into FamilyMember (id,name,fatherName,age) values(?,?,?,?)");
			
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "Chityala Anand");
			preparedStatement.setString(3, "Chityala Yalamanada");
			preparedStatement.setInt(4, 25);
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "Chityala Suresh");
			preparedStatement.setString(3, "Chityala Yalamanada");
			preparedStatement.setInt(4, 27);
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, 3);
			preparedStatement.setString(2, "Chityala Durgamma");
			preparedStatement.setString(3, "Pagidi Saidulu");
			preparedStatement.setInt(4, 40);
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "Chityala Yalamanda");
			preparedStatement.setString(3, "Chityala Saidulu");
			preparedStatement.setInt(4, 50);
			preparedStatement.executeUpdate();
			
			preparedStatement.setInt(1, 5);
			preparedStatement.setString(2, "Chityala chintu");
			preparedStatement.setString(3, "Chityala yalaman");
			preparedStatement.setInt(4, 29);
			preparedStatement.executeUpdate();
			
			System.out.println("Data inserted Successfully.... ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	private static void updateDataIntoTable(Connection connection) {
		Statement statement;
		try {
			statement = connection.createStatement();
			int numRowsUpdated = statement.executeUpdate("update FamilyMember set fatherName = 'Saidaiah' where id = 4");
			System.out.println(numRowsUpdated+" Rows updated successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void deletRecordFromTable(Connection connection) {
		Statement stateMent;
		try {
			stateMent = connection.createStatement();
			int numRowsDeleted = stateMent.executeUpdate("delete from FamilyMember where id = 5");
			System.out.println(numRowsDeleted+" Rows deleted Successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void fetchingRecordsFromTable(Connection connection) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from FamilyMember");
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String fatherName = resultSet.getString("fatherName");
				int age = resultSet.getInt("age");
				System.out.println(resultSet.toString());
				System.out.println(id+" "+name+" "+" "+fatherName+" "+age);
				System.out.println("records fetching successfully..");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
