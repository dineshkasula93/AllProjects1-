<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="http://localhost:8080/Springs-Website-flow/Payment"
		method="post" modelAttribute="info">
Enter Amount <input type="number" title="Please Enter Amount You Want To Pay"
			placeholder="Please Enter Amount To Pay" name="Pay">
		<br>
		<br>
		<button type="submit" class="btn">Pay</button>
	</form:form>
</body>
</html>