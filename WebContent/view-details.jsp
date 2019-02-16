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
<form method="post" action="vdActionServlet">
	<table>
		<tr>
			<td><input type="hidden" name="pId" value="${personItem.id}"></td>
			<td>Name: ${personItem.name}</td>
			<td>Age: ${personItem.age}</td>
			<td>Gender: ${personItem.gender}</td>
		</tr>
		<c:forEach items="${requestScope.jobsList}" var="thisItem">
		<tr>
			<td><input type="radio" name="jId" value="${thisItem.id}"></td>
			<td><strong>Job Title: </strong>${thisItem.jobTitle}</td>
			<td><strong>Employer: </strong>${thisItem.employer}</td>
			<td><strong>Salary: </strong>${thisItem.salary}</td>
			<td><strong>Start Date: </strong>${thisItem.startDate}</td>
			<td><strong>End Date: </strong>${thisItem.endDate}</td>
		</tr>
		</c:forEach>
	</table>
	<input type="submit" value="Add New Job" name="thisAction">
	<input type="submit" value="Delete Job" name="thisAction">
	<a href="index.jsp">Return To Menu</a>
</form>
</body>
</html>