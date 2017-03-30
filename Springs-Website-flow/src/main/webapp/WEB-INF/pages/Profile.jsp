<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.Springs.Website.Repository.RepoDAO"%>
<%@ page import="com.Springs.Website.Model.UsersInfo"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Hello
		<%
		RepoDAO rd = new RepoDAO();
		String name 	= rd.FirstName;
		String lname	= rd.LastName;
		out.println(name +" "+ lname);
	%>
		Welcome View Profile<br>
		<h4><a href="http://localhost:8080/Springs-Website-flow/Login/redirect">back</a></h4>
		<h4><a href="http://localhost:8080/Springs-Website-flow/Payment">Payment</a></h4>
	</h3>
	<table>
		<%
			RepoDAO rd1 = new RepoDAO();
			String details = rd1.viewDetails();
			out.println(details);
		%>
	</table>
</html>