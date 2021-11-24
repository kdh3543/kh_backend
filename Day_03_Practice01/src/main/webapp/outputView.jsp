<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>outputView</title>
</head>
<body>
	<table border=1 align=center>
		<tr>
			<th colspan=4 align=center>Employee List
		</tr>
		<tr>
			<td>EMP_ID
			<td>EMP_NAME
			<td>DEPARTMENT
			<td>EMAIL
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.emp_id }
				<td>${dto.emp_name }
				<td>${dto.dept_title }
				<td>${dto.email }
			</tr>
		</c:forEach>
		<form action="index.jsp">
			<tr>
				<th colspan=4 align=center>Back to index
			</tr>
			<tr>
				<td colspan=4><button>Back</button>
			</tr>
		</form>
	</table>
</body>
</html>