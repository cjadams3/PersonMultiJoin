<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="listThisServlet">
	<table>
		<c:forEach items="${requestScope.allItems}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.name}</td>
			<td>${currentitem.age}</td>
			<td>${currentitem.gender}</td>
		</tr>
		</c:forEach>
	</table><br/>
	<input type="submit" value="View Details" name="doThis">
	<input type="submit" value="Delete Person" name="doThis">
	<a href="index.jsp">Return to Menu</a>
	</form>
</body>
</html>