<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.title }</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<form>
		<table border=2 align=center>
			<tr>
				<td colspan="5" align="center"><b>자유게시판 글 작성하기</b></td>
			</tr>
			<tr>
				<td colspan="5"><input type=text placeholder="글 제목을 입력하세요."
					id=title name=title readonly value="${dto.title }"></td>
			</tr>
			<tr>
				<td colspan="5" align="center" height=500><textarea rows="30"
						cols="100" name=contents readonly>${dto.contents }</textarea></td>
			</tr>
			<tr>
				<td colspan="5" align="right">
				<a href="/toboard.board"><button type=button>목록으로</button></a> 
				<c:if test="${dto.writer == loginId }">
					<a href="/delete.board?seq=${dto.seq }"><button type=button>삭제하기</button></a>
				</c:if>
			</tr>
		</table>
	</form>
</body>
</html>