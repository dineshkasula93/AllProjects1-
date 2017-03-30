<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Players</title>
</head>
<body>
<p>Here you can see the list of the players, edit them, delete.</p>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">Id</th><th width="10%">Team Name</th><th width="15%">PlayerName</th><th width="10%">Age</th><th width="15%">Specialization</th>
<th width="15%">Number of Centuries</th><th width="10%">Total Runs</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="player" items="${players}">
<tr>
    <td>${player.id}</td>
    <td>${player.teamname}</td>
    <td>${player.playername}</td>
    <td>${player.age}</td>
      <td>${player.specialization}</td>
        <td>${player.noc}</td>
          <td>${player.totalruns}</td>
    <td>
   <a href="${pageContext.request.contextPath}/team/editplayer/${player.id}.html">Edit Player</a></br> 
        <a href="${pageContext.request.contextPath}/team/deleteplayer/${player.id}.html">Delete Player</a></br>
    
     
    </td>
</tr>
</c:forEach>
</tbody>
</table>
 <a href="${pageContext.request.contextPath}/team/addplayer/${player.id}.html">Add Player</a><br>
 <p><a href="${pageContext.request.contextPath}/playerhome.html">Player Home page</a></p><br>
 <a href="${pageContext.request.contextPath}/index.html">Home page</a>
</body>
</html>