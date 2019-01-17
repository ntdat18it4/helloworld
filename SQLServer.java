package GiaoDien;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServer {
	public static void main(String[] args){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://MAYTINH\\SQLEXPRESS;databaseName=quanlybenhnhan;integratedSecurity=true");
			System.out.println("Thanh Cong!");
		} catch (Exception e) {
	e.printStackTrace();	
	}
	}
}
