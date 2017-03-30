<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
 <div>
<h2>Login</h2>
<form:form action="http://localhost:8080/Springs-Website-flow/Login" method="post" modelAttribute ="info">
UserName <input type = "text" title="Please enter User Name" placeholder="Enter Username" name="UserName" /><br><br>
Password <input type = "password" title="Please enter Password" placeholder="Enter Your Password" name="Password" /><br><br>
<button type="submit" class="btn">Login</button>
</form:form>
<br><br>
<%-- <form:form action="http://localhost:8080/Springs-Website-flow/Register" method="get" modelAttribute ="info"> --%>
<a href="http://localhost:8080/Springs-Website-flow/Register">New Users Signup</a><br><br>
<a href="http://localhost:8080/Springs-Website-flow/Forgot">Forgot Password</a>
<%-- </form:form> --%>
</div>
</body>
</html>