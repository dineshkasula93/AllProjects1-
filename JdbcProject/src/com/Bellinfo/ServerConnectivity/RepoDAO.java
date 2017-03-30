package com.Bellinfo.ServerConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class RepoDAO {
	Connection con;
	private static final String SEQUENCE = "CREATE SEQUENCE id_seq";
	private static final String CREATE_TABLE = "create table registration (ID integer nextval('id_seq') primary key unique not null,Firstname text not null, Lastname text not null, Email text not null, Username text UNIQUE not null, Password text not null, Maidenname text not null);";
	private static final String INSERT_REGISTER = "insert into registration (Firstname,Lastname,Email,Username,Password,PhoneNumber,MaidenName) values(?,?,?,?,?,?,?);";
	private static final String GET_DETAILS = "select exists(select Username,Password from registration where Username = ? and Password = ?);";
	private static final String VIEW_DETAILS = "select * from registration where username=?;";

	public void getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/BellinfoBatch4", "postgres", "dinesh");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void createTable() {
		boolean isSequenceExists = false;
		boolean isTableExists = false;
		Statement stmt = null;
		try {
			getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select exists (select 1 from pg_tables where schemaname = 'public' and tablename = 'registration')");
			ResultSet rs1 = stmt.executeQuery("select * from id_seq");
			while (rs1.next()) {
				isSequenceExists = rs1.getBoolean(1);
			}
			if (!isSequenceExists) {
				stmt.execute(SEQUENCE);
			}
			while (rs.next()) {
				isTableExists = rs.getBoolean(1);
			}
			if (!isTableExists) {
				stmt.execute(CREATE_TABLE);
				System.out.println("****************Database Created Successfully***************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException sq) {
				sq.printStackTrace();
			}
		}

	}

	public boolean insertUserInfo() {
//		PreparedStatement ps = null;
	boolean result = false;
//		try {
//			getConnection();
//			for (int i = 0; i < info.size(); i++) {
//				getConnection();
//				ps = con.prepareStatement(INSERT_REGISTER);
//				ps.setString(1, info.get(i).getFirstname());
//				ps.setString(2, info.get(i).getLastname());
//				ps.setString(3, info.get(i).getEmail());
//				ps.setString(4, info.get(i).getUsername());
//				ps.setString(5, info.get(i).getPassword());
//				ps.setLong(6, info.get(i).getPhonenumber());
//				ps.setString(7, info.get(i).getMaidenname());
//				result = ps.execute();
//				ps.close();
//			}
//			if (result == false) {
//				System.out.println("****************Values Inserted Successfully***************");
//			} else {
//				System.out.println("Something Went Wrong Please Try Again!!!");
//			}
//		} catch (IndexOutOfBoundsException ie) {
//			ie.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return result;
	}

	public boolean getDetails() {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
	boolean userExists = false;
//		try {
//			getConnection();
////			UsersInfo usf = UsersInfo.getinstance();
//			ps = con.prepareStatement(GET_DETAILS);
//			ps.setString(1, usf.getUsername());
//			ps.setString(2, usf.getPassword());
//			System.out.println(
//					"From UsersInfo pojo class to verify details\t" + usf.getUsername() + "\t" + usf.getPassword());
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				userExists = rs.getBoolean(1);
//				System.out.println("from the repo dao class:  " + userExists);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				ps.close();
//			} catch (SQLException s) {
//				s.printStackTrace();
//			}
//		}
		return userExists;
	}

	public String viewDetails() {
		String details = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			getConnection();
			System.out.println("Check from the Details Method");
//			UsersInfo usf = UsersInfo.getinstance();
			ps = con.prepareStatement(VIEW_DETAILS);
			System.out.println("Check1 from the Details Method");
			ps.setString(1,  "testid2");
			System.out.println("Check2 from the Details Method");
			rs = ps.executeQuery();
			System.out.println("Check3 from the Details Method");
			while (rs.next()) {
				System.out.println("Check4 from the Details Method");
				details = "<tr>" + "<td>ID</td>" + "<td>FirstName</td>" + "<td>LastName</td>" + "<td>Username</td>"
						+ "<td>Password</td>" + "<td>PhoneNumber</td>" + "<td>MaidenName</td>" + "</tr>" + "<tr>"
						+ "<td>" + rs.getString("Id") + "</td>" + "<td>" + rs.getString("FirstName") + "</td>" + "<td>"
						+ rs.getString("LastName") + "</td>" + "<td>" + rs.getString("Username") + "</td>" + "<td>"
						+ rs.getString("Password") + "</td>" + "<td>" + rs.getString("PhoneNumber") + "</td>" + "<td>"
						+ rs.getString("MaidenName") + "</td>" + "</tr>";
				
				System.out.println("From the pojo class UsersInfo"+details);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}

		return details;
	}
	
	
	public static void main(String[] args){
		RepoDAO  rd1 = new RepoDAO();
		rd1.viewDetails();
	}

}

