package com.kolyshkin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	  static final String JDBC_DRIVER= "org.postgresql.Driver";
	  static final String DB_URL= "jdbc:postgresql://ec2-79-125-12-27.eu-west-1.compute.amazonaws.com:5432/d62eqh47p7qeld?sslmode=require";
	  static final String USER= "xpgujmrxspfbng";
	  static final String PASS= "91f04b6988fb279741b103ed5fb70c5e054ae4e157ea2d223477a75be674524b";
	public static Connection getConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			//open connection
			   System.out.println("Connecting to a selected database...");
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			   System.out.println("Connected database successfully...");
		return connection;
	 }catch(SQLException sqlEx){
		 sqlEx.printStackTrace();//handle errors for jdbc
		 System.out.println("Exeption occured in the process: "+sqlEx);
	 }catch(Exception ex){
		 ex.printStackTrace();//handle errors for ClassForName
		 System.out.println("Exception occured in the process: "+ex);
		}
		return null;
	}

	public static void close(Connection connect) {
		try {
			connect.close();
		System.out.println("DataBase Connection closed!!!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
