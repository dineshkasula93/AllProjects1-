<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="http://localhost:8080/Springs-Website-flow/Forgot/ResetPass" method="post" modelAttribute ="info">
Password <input type = "password" title="Please enter Password" placeholder="Enter Your Password" name="Password" /><br><br>
Re-Enter Password <input type = "password" title="Re-Please enter Password" placeholder="Re-Enter Your Password" name="Re-Password" /><br><br>
<button type="submit" class="btn">Login</button>
</form:form>
</body>
</html>