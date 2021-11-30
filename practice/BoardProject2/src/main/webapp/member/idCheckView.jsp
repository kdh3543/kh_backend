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

	<c:choose>
		<c:when test="${result }">
			<table border=1 align=center>
				<tr>
					<th>아이디 확인 여부
				</tr>
				<tr>
					<td>이미 사용중인 ID 입니다. <br> 
					다른 아이디를 사용해주세요.
				</tr>
				<tr>
					<td><button id="close">닫기</button>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<div>
				<table border=1 align=center>
					<tr>
						<th>아이디 확인 여부
					</tr>
					<tr>
						<td colspan=2>사용 가능한 ID 입니다. <br> 
						이 아이디를 사용하시겠습니까?
					</tr>
					<tr>
						<td><button id="use">사용</button>
						<td><button id="cancel">취소</button>
					</tr>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>