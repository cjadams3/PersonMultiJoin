<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Work History</title>
<script type="text/javascript">
function ValidateThis() {
	
	var y = document.getElementById("salary").value;
	var a = document.getElementById("stMM").value;
	var b = document.getElementById("stDD").value;
	var c = document.getElementById("stYYYY").value;
	var d = document.getElementById("endMM").value;
	var e = document.getElementById("endDD").value;
	var f = document.getElementById("endYYYY").value;
	
	if (isNaN(y)) {
		alert("Invalid Salary");
		return false;
	}
	else if (isNaN(a) || a < 1 || a > 12) {
		alert("Invalid Start Month");
		return false;
	}
	else if (isNaN(b) || b < 1 || b > 31) {
		alert("Invalid Start Day");
		return false;
	}
	else if (isNaN(c)) {
		alert("Invalid Start Year");
		return false;
	}
	else if (isNaN(d) || d < 1 || d > 12) {
		alert("Invalid End Year");
		return false;
	}
	else if (isNaN(e) || e < 1 || e > 31) {
		alert("Invalid End Day");
		return false;
	}
	else if (isNaN(f)) {
		alert("Invalid End Year");
		return false;
	}
	else if (f < c) {
		alert("End Date must be after Start Date");
		return false;
	}
	
	if (f === c) {
		if (d === a) {
			if (e < b) {
				alert("End Date must be after Start Date");
				return false;
			}
		}
		else if (d < a) {
			alert("End Date must be after Start Date");
			return false;
		}
	}
	return true;
}
</script>
</head>
<body>
	<form method="post" action="addJobDetailsServlet" onsubmit="return ValidateThis()">
		<label for="title">Job Title</label>
		<input type="text" id="title" name="title" required="required"><br/>
		<label for="employer">Employer</label>
		<input type="text" id="emloyer" name="employer" required="required"><br/>
		<label for="salary">Yearly Salary</label>
		<input type="text" id="salary" name="salary" required="required"><br/>
		<label for="stDate">Start Date</label>
		<input type="text" id="stMM" name="stMM" placeholder="MM" required="required">
		<input type="text" id="stDD" name="stDD" placeholder="DD" required="required">
		<input type="text" id="stYYYY" name="stYYYY" placeholder="YYYY" required="required"><br/>
		<label for="endDate">End Date</label>
		<input type="text" id="endMM" name="endMM" placeholder="MM" required="required">
		<input type="text" id="endDD" name="endDD" placeholder="DD" required="required">
		<input type="text" id="endYYYY" name="endYYYY" placeholder="YYYY" required="required"><br/>
		<input type = "hidden" name = "id" value="${PersonInfo.id}">
		<input type = "hidden" name = "name" value="${PersonInfo.name}">
		<input type = "hidden" name = "age" value="${PersonInfo.age}">
		<input type = "hidden" name = "gender" value="${PersonInfo.gender}">
		<input type=submit name="toAdd" value="Submit">
	</form>

</body>
</html>