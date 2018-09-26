<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">

	<h1>Update Employee</h1>
	<hr>
	<form:form action="/employeeapp/updateEmployee" method="post" modelAttribute="employee">
		<form:label path="employeeId">Employee Id:</form:label>
		<form:input path="employeeId" readonly="readonly" />
		<br>

		<form:label path="employeeName">Employee Name</form:label>
		<form:input path="employeeName" />
		<br>

		<form:label path="employeeDepartment">Employee Department</form:label>
		<form:input path="employeeDepartment" />
		<br>

		<form:label path="employeeSalary">Employee Salary </form:label>
		<form:input path="employeeSalary" />
		<br>

		<input type="submit" value="UpdateEmployee" />
	</form:form>


</body>
</html>