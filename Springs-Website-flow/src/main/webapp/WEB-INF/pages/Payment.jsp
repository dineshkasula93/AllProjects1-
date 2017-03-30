<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page
	import="com.Springs.Website.Repository.RepoDAO, java.sql.Connection, java.sql.PreparedStatement, 
	java.sql.ResultSet,java.sql.SQLException,java.sql.Statement"%>
<%@ page import="com.Springs.Website.Model.UsersInfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello
	<%
	RepoDAO rd = new RepoDAO();
	String name = rd.FirstName;
	String lname = rd.LastName;
	out.println(name + " " + lname);
%>
	welcome to Payment
	<br>
	<br> Your Current Balance is:
	<br>
	<%
		String balance = rd.balance();
		out.println(balance);
	%>
	
	
	
	<% 
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs;
	String balan=null;
	try {
		rd.getConnection();
		UsersInfo usf = UsersInfo.getinstance();
		ps = con.prepareStatement("Select Balance,Rewards from payment where username=?;");
		ps.setString(1, "dineshk93");
		rs = ps.executeQuery();
		while (rs.next()) {
			balan = " <table>" + "<tr>" + "<td>Balance</td>" + "<td>Rewards</td>"
					+ "</tr>" + "<tr>" + "<td>" + rs.getInt("Balance") + "</td>" + "<td>" + rs.getInt("Rewards")
					+ "</td>" + "</tr>" + "</table>";
			out.println("From the RepoDao class Balance method" + balance);
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

	%>

	<br>
	<a
		href="http://localhost:8080/Springs-Website-flow/Payment/MakePayment">Make
		Payment</a>
	<br>
	<a href="http://localhost:8080/Springs-Website-flow/Profile">Profile</a>
	<br>
	<br>
	<br>
</body>
</html>