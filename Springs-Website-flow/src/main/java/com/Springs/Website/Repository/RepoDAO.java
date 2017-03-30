package com.Springs.Website.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Springs.Website.Model.UsersInfo;

public class RepoDAO {
	Connection con;
	private static final String SEQUENCE = "CREATE SEQUENCE id_seq";
	private static final String CREATE_TABLE = "create table registration (ID integer nextval('id_seq') primary key"
			+ " unique not null,Firstname text not null, Lastname text not null, Email text not null, Username text "
			+ "UNIQUE not null, Password text not null, Maidenname text not null);";
	private static final String INSERT_REGISTER = "insert into registration (Firstname,Lastname,Email,Username,"
			+ "Password,PhoneNumber,MaidenName) values(?,?,?,?,?,?,?);";
	private static final String GET_DETAILS = "select* from registration where Username = ? and Password = ?;";
	private static final String VIEW_DETAILS = "select * from registration where username=?;";
	private static final String PASS_CHECk_CONFIRM = "select exists(select Username,Email,MaidenName from"
			+ " registration where Username =? and Email=? and Maidenname=?);";
	private static final String RESET_PASS = "update registration set password=?  where username=?;";
	private static final String SELECT_PASS = "Select password from registration where username=?;";
	public final String VIEW_BALANCE_REWARDS = "Select Balance,Rewards from payment where username=?;";

	public static String UserName;
	public static String FirstName;
	public static String LastName;
	public static String Email;
	public static String Password;
	public static String Phone;
	public static String MaidenName;

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

	public boolean insertUserInfo(ArrayList<UsersInfo> info) {
		PreparedStatement ps = null;
		boolean result = false;
		try {
			getConnection();
			for (int i = 0; i < info.size(); i++) {
				getConnection();
				ps = con.prepareStatement(INSERT_REGISTER);
				ps.setString(1, info.get(i).getFirstname());
				ps.setString(2, info.get(i).getLastname());
				ps.setString(3, info.get(i).getEmail());
				ps.setString(4, info.get(i).getUsername());
				ps.setString(5, info.get(i).getPassword());
				ps.setLong(6, info.get(i).getPhonenumber());
				ps.setString(7, info.get(i).getMaidenname());
				result = ps.execute();
				ps.close();
			}
			if (result == false) {
				System.out.println("****************Values Inserted Successfully***************");
			} else {
				System.out.println("Something Went Wrong Please Try Again!!!");
			}
		} catch (IndexOutOfBoundsException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void getDetails() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean userExists = false;
		try {
			getConnection();
			UsersInfo usf = UsersInfo.getinstance();
			ps = con.prepareStatement(GET_DETAILS);
			ps.setString(1, usf.getUsername());
			ps.setString(2, usf.getPassword());
			System.out.println(
					"From UsersInfo pojo class to verify details\t" + usf.getUsername() + "\t" + usf.getPassword());
			rs = ps.executeQuery();
			while (rs.next()) {
				UserName = rs.getString("Username");
				FirstName = rs.getString("Firstname");
				LastName = rs.getString("Lastname");
				Email = rs.getString("Email");
				Password = rs.getString("Password");
				Phone = rs.getString("Phonenumber");
				MaidenName = rs.getString("Maidenname");
				System.out.println("from the repo dao class: " + userExists);
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
		// return userExists;
	}

	public String viewDetails() {
		String details = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			getConnection();
			UsersInfo usf = UsersInfo.getinstance();
			ps = con.prepareStatement(VIEW_DETAILS);
			ps.setString(1, usf.getUname());
			System.out.println("From RepoDAO class viewDetials Methd Uname value:\t" + usf.getUname());
			rs = ps.executeQuery();
			while (rs.next()) {
				details = "<table border=>" + "<tr>" + "<td>ID</td>" + "<td>" + rs.getString("Id") + "</td>" + "</tr>"
						+ "<tr>" + "<td>FirstName</td>" + "<td>" + rs.getString("FirstName") + "</td>" + "</tr>"
						+ "<tr>" + "<td>LastName</td>" + "<td>" + rs.getString("LastName") + "</td>" + "</tr>" + "<tr>"
						+ "<td>Username</td>" + "<td>" + rs.getString("Username") + "</td>" + "</tr>" + "<tr>"
						+ "<td>PhoneNumber</td>" + "<td>" + rs.getString("PhoneNumber") + "</td>" + "</tr>" + "<tr>"
						+ "<td>MaidenName</td>" + "<td>" + rs.getString("MaidenName") + "</td>" + "</tr>" + "</table>";
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

	public boolean forgetPasswordMtd() {
		String email = null;
		String mname = null;
		String confirmMail = null;
		String confirmMName = null;
		boolean confirmDetails = false;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			getConnection();
			UsersInfo usf = UsersInfo.getinstance();
			ps = con.prepareStatement(PASS_CHECk_CONFIRM);
			ps.setString(1, usf.getUsername());
			ps.setString(2, usf.getEmail());
			ps.setString(3, usf.getMaidenname());
			System.out.println("From RepoDAO class forgotpass Methd Uname value:\t" + usf.getUsername() + " "
					+ usf.getEmail() + " " + usf.getMaidenname());
			rs = ps.executeQuery();
			while (rs.next()) {
				confirmDetails = rs.getBoolean(1);
				System.out.println("From the RepoDao class and frogot pass mtd" + confirmDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return confirmDetails;
	}

	public String resetPass() {
		PreparedStatement ps = null;
		ResultSet rs;
		String passReset = null;
		try {
			getConnection();
			UsersInfo usf = UsersInfo.getinstance();
			ps = con.prepareStatement(RESET_PASS);
			ps.setString(1, usf.getPassword());
			ps.setString(2, usf.getUsername());
			System.out.println("From RepoDAO cls resetPass mtd:\t" + usf.getUsername() + "\t" + usf.getPassword());
			ps.executeUpdate();
			System.out.println("Check 0:Resetpass Method in reapoDAO ");
			ps = con.prepareStatement(SELECT_PASS);
			ps.setString(1, usf.getUsername());
			System.out.println("Check 1:Resetpass Method in reapoDAO ");
			rs = ps.executeQuery();
			System.out.println("Check 2:Resetpass Method in reapoDAO ");
			while (rs.next()) {
				System.out.println("Check 3:Resetpass Method in reapoDAO ");
				passReset = rs.getString("Password");
				System.out.println("from the RepoDao class and resetpass mtd passReset" + passReset);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return passReset;
	}

	public String balance() {
		PreparedStatement ps = null;
		ResultSet rs;
		String balance=null;

		try {
			getConnection();
			UsersInfo usf = UsersInfo.getinstance();
			ps = con.prepareStatement(VIEW_BALANCE_REWARDS);
			ps.setString(1, usf.getUname());
			rs = ps.executeQuery();
			while (rs.next()) {
				balance = " <table>" + "<tr>" + "<td>Balance</td>" + "<td>Rewards</td>"
						+ "</tr>" + "<tr>" + "<td>" + rs.getInt("Balance") + "</td>" + "<td>" + rs.getInt("Rewards")
						+ "</td>" + "</tr>" + "</table>";
				System.out.println("From the RepoDao class Balance method" + balance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return balance;
	}

	public static void main(String[] args) {
		RepoDAO rd1 = new RepoDAO();
		rd1.getDetails();
		System.out.println("Value of username:  " + UserName + "\t" + "Password:   " + Password);
	}

}
