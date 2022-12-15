package com.kfh.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseImport {

//		try{  
//			Class.forName("com.mysql.jdbc.Driver");  
//			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/school");  
//			Statement stmt=(Statement) ((java.sql.Connection) con).createStatement();  
//			ResultSet rs=((java.sql.Statement) stmt).executeQuery(null);  
//			while(rs.next())  
//			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//			con.close();  
//			}catch(Exception e){ System.out.println(e);}  
//			}
	public static final String DB_URLTOCONNECT = "jdbc:mysql://localhost:3306/school";

	public static final String DB_USERNAME = "root";

	public static final String DB_PASSWORD = "";
	
	static private Connection dbCon;
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			 dbCon = DriverManager
			.getConnection(DB_URLTOCONNECT, DB_USERNAME, DB_PASSWORD);

			System.out.println("Successfully connect to the database...");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load the driver : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Can't connect, some issues : " + e.getMessage());
		}
	}

	void getAllDeveloperData() {

		String qry = "slect * from school";

	}

}
