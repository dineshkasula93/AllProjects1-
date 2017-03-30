<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
</head>
<body>
<h2>Login</h2>
<form:form action="http://localhost:8080/Springs-Website-flow/Forgot" method="post" modelAttribute ="info">
UserName <input type = "text" title="Please enter User Name" placeholder="Enter Username" name="UserName" /><br><br>
Email <input type = "text" title="Please enter Email" placeholder="Enter Your Email" name="Email" /><br><br>
MaidenName <input type = "text" title="Please enter MaidenName" placeholder="Enter Your MaidenName" name="MaidenName" /><br><br>
<button type="submit" class="btn">Login</button>
</form:form>
<br><br>

</body>
</html>