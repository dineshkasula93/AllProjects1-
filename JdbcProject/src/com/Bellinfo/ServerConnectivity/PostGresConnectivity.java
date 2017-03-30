package com.Bellinfo.ServerConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PostGresConnectivity {

	Connection con;
	String Query = "Create table register1(fullname varchar(40) NOT NULL, email varchar(60)PRIMARY KEY NOT NULL, username varchar(40) NOT NULL, password varchar(40) NOT NULL, phone INTEGER NOT NULL);";
	String Query1 = "Insert into register1(fullname, email,username, password, phone) values(?,?,?,?,?);";
	String Qurey2 = "SELECT EXISTS ( SELECT 1  FROM   pg_tables WHERE  schemaname = 'public' AND   tablename = 'register1');";
	String Query3 = "Select * from register1";
	PreparedStatement st = null;

	public void getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/BellinfoBatch4", "postgres", "dinesh");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createStatement() {

		boolean result = false;
		Scanner scan;
		try {
			getConnection();
			st = con.prepareStatement(Qurey2);
			ResultSet rs = st.executeQuery();
			System.out.println("check 1");
			while (rs.next()) {
				System.out.println("check 2 while rs");
				result = rs.getBoolean(1);
				System.out.println("Result value \t" + result);
			}
			if (!result) {
				System.out.println("check 3 if query statement");
				st = con.prepareStatement(Query);
				ResultSet rs2 = st.executeQuery();
				System.out.println("check 3 if query statement executed");
			} else {
				System.out.println("check 4 else query statement for storing values");
				st = con.prepareStatement(Query1);
				scan = new Scanner(System.in);
				System.out.println("Enter the fullname:");
				String fullname = scan.next();
				System.out.println("enter the email:");
				String email = scan.next();
				System.out.println("enter the name:");
				String name = scan.next();
				System.out.println("enter the password:");
				String password = scan.next();
				System.out.println("enter the phone:");
				double phone = scan.nextDouble();

				st.setString(1, fullname);
				st.setString(2, email);
				st.setString(3, name);
				st.setString(4, password);
				st.setDouble(5, phone);
				st.executeQuery();
				System.out.println("This is to see all the condition are executed");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void retrivevalues() throws SQLException {
		getConnection();
		ResultSet rs;
		st = con.prepareStatement(Query3);
		rs = st.executeQuery();
		while (rs.next()) {
			System.out.println("check from retive Values 2 from rs next ");
			System.out.println("fullname: \t" + rs.getString("fullname") + "\t" + "email: \t" + rs.getString("email")
					+ "\t" + "Name:\t" + rs.getString("username") + "\t" + "passwors: \t" + rs.getString("password")
					+ "Phone: \t" + rs.getDouble("phone"));
		}

	}

	public static void main(String[] args) throws SQLException {
		PostGresConnectivity pgc = new PostGresConnectivity();
//		pgc.createStatement();
		pgc.retrivevalues();

	}

}
