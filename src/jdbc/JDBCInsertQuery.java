package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertQuery {
	private static String  driverName= "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/school";
	private static String userName = "root";
	private static String password = "Anand@9441437496";

	public static void main(String[] args) {
		System.out.println("Hello");
		try {
			Class.forName(driverName);
			System.out.println("Helloooo");
			try {
				Connection con = DriverManager.getConnection(url,userName,password);
				System.out.println("Successfullt connected");

				Statement stmt = con.createStatement();
				System.out.println("====");
				int m = stmt.executeUpdate("Insert into FirstClass values(5,5,'ChityalaDurgana','Saidulu',40)");
				if(m==1) {
					System.out.println("yes");
				}else {
					System.out.println("no");
				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
