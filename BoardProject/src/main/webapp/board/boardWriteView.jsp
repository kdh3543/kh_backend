<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
#title {
	width: 500px
}
</style>
</head>
<body>
	<form action="/writeSuccess.board" method=get>
		<table border=2 align=center>
			<tr>
				<td colspan="5" align="center"><b>자유게시판 글 작성하기</b></td>
			</tr>
			<tr>
				<td colspan="5"><input type=text placeholder="글 제목을 입력하세요."
					id=title name=title></td>
			</tr>
			<tr>
				<td colspan="5" align="center" height=500><textarea rows="30"
						cols="100" name=contents></textarea></td>
			</tr>
			<tr>
				<td colspan="5" align="right">
				<a href="/toboard.board"><input type=button value="목록으로"></a> 
					<button type=submit>작성하기</button></td>
			</tr>
		</table>
	</form>
</body>
</html>