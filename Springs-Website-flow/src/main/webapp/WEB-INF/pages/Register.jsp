<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Users Registration Page</title>
</head>
<body>
 <div>
<h2>Login</h2>
<form:form action="http://localhost:8080/Springs-Website-flow/Register" method="post" modelAttribute ="info">
FirstName<input type="text" title="Please Enter Your Fisrtname" placeholder="Enter Your Firstname" name="Firstname"><br><br>
LastName<input type="text" title="Please Enter Your Lastname" placeholder="Enter Your Lastname" name="Lastname"><br><br>
Email<input type="text" title="Please Enter Your Email" placeholder="Enter Your Email" name="Email"><br><br>
UserName <input type = "text" title="Please enter UserName" placeholder="Enter Username" name="UserName" /><br><br>
Password <input type ="password" title="Please enter User Password" placeholder="Enter Password" name="Password" /><br><br>
PhoneNumber<input type="number"  minLength="10" maxLength="13" title="Please Enter Your PhoneNumber" placeholder="Enter Your Phone Number" name="PhoneNumber"><br><br>
MaidenName<input type="text" title="Please Enter Your MaidenName" placeholder="Enter your MaidenName" name="MaidenName"><br><br>
<button type="submit" class="btn">Register</button>
</form:form>
</div>
</body>
</html>