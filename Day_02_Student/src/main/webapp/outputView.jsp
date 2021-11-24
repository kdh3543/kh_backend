<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border=1 align="center">
		<tr>
			<th colspan=6 align="center">Student Score
		</tr>
		<tr>
			<th>
			<th>name
			<th>kor
			<th>eng
			<th>sum
			<th>avg
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.id }
				<td>${dto.name }
				<td>${dto.kor }
				<td>${dto.eng }
				<td>${dto.kor+dto.eng }
				<td>${(dto.kor+dto.eng)/2.0 }
			</tr>
		</c:forEach>
		<tr>
			<td colspan=6 align=center><a href="index.html">Back</a>
		</tr>
		<form action="delete.con">
			<tr>
				<td colspan=6 align=center>Delete
			</tr>
			<tr>
				<td colspan=4><input type=text placeholder="input id to delete" name=id>
				<td colspan=2><button>Delete</button>
			</tr>
		</form>
		<form action="update.con">
			<tr>
				<td colspan=6 align=center>Update
			</tr>
			<tr>
				
				<td colspan=4><input type=text placeholder="input name to update" name=name>
				<td colspan=2 rowspan=4><button>update</button>
			</tr>
			<tr>
				<td colspan=4><input type=text placeholder="input kor to update" name=kor>
			</tr>
			<tr>
				<td colspan=4><input type=text placeholder="input eng to update" name=eng>
			</tr>
			<tr>
				<td colspan=4><input type=text placeholder="input id to target" name=updateId>
			</tr>
		</form>
	</table>
</body>
</html>