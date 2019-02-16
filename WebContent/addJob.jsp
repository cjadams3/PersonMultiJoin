<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Work History</title>
</head>
<body>
	<form method="post" action="addJobDetailsServlet">
		<label for="title">Job Title</label>
		<input type="text" name="title"><br/>
		<label for="employer">Employer</label>
		<input type="text" name="employer"><br/>
		<label for="salary">Yearly Salary</label>
		<input type="text" name="salary"><br/>
		<label for="stDate">Start Date</label>
		<input type="text" name="stMM" placeholder="MM">
		<input type="text" name="stDD" placeholder="DD">
		<input type="text" name="stYYYY" placeholder="YYYY"><br/>
		<label for="endDate">End Date</label>
		<input type="text" name="endMM" placeholder="MM">
		<input type="text" name="endDD" placeholder="DD">
		<input type="text" name="endYYYY" placeholder="YYYY"><br/>
		<input type = "hidden" name = "id" value="${PersonInfo.id}">
		<input type = "hidden" name = "name" value="${PersonInfo.name}">
		<input type = "hidden" name = "age" value="${PersonInfo.age}">
		<input type = "hidden" name = "gender" value="${PersonInfo.gender}">
		<input type=submit name="toAdd" value="Submit">
	</form>

</body>
</html>