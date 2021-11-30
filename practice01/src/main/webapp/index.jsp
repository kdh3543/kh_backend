<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	
		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">회원 로그인</td>
			</tr>
			<form action="/login.mem">	
			<tr>
				<td align="left">아이디 :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td align="left">비밀번호 :</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">로그인</button>
					</form> 
					<a href="/signup.mem"><input type="button" value="회원가입"></a>
				</td>
				
			</tr>
		</table>
	
</body>
</html>