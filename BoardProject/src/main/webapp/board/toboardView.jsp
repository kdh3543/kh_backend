<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<form action="/boardWrite.board">
		<table border=2 align=center>
			<tr>
				<td colspan="5" align="center"><b>자유게시판</b></td>
			</tr>
			<tr align="center">
				<td width=5%></td>
				<td width=60%>제목</td>
				<td width=15%>작성자</td>
				<td width=15%>날짜</td>
				<td width=5%>조회</td>
			</tr>
			<c:forEach var="dto" items="${list }">
				<tr>
							<td align="center">${dto.seq }</td>
							<td style="padding:5px;">
								<a href="/detail.board?seq=${dto.seq}">${dto.title }</a>
							</td>
							<td align="center">${dto.writer }</td>
							<td align="center">${dto.detailDate }</td>
							<td align="center">${dto.view_count }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="center">1 2 3 4 5 6 7 8 9 10</td>
			</tr>
			<tr>
				<td colspan="5" align="right"><button type=submit>작성하기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>