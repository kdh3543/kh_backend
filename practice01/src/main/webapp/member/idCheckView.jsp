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
	<c:choose>
		<c:when test="${result }">
			<table border="1" align="center">
				<tr>
					<th align="center">아이디 사용 여부</th>
				</tr>
				<tr>
					<td>
						이미 사용중인 id입니다.<br>
						다른 id를 입력해주세요.
					</td>
				</tr>
				<tr>
					<td align=center><button id="close">닫기</button>
					<script>
						$("#close").on("click",function(){
							opener.document.getElementById("id").value="";
							window.close();
						})
					</script>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table border=1 align=center>
				<tr>
					<th colspan=2>아이디 사용유무
				</tr>
				<tr>
					<td colspan=2>
					사용가능한 ID입니다.<br>
					이 아이디를 사용하시겠습니까?	
				</tr>
				<tr align=center>
					<td><button id="use">사용</button>
					<script>
						$("#use").on("click",function(){
							
							window.close();
						})
					</script>
					<td><button id="cancel">취소</button>
					<script>
						$("#cancel").on("click",function(){
							opener.document.getElementById("id").value="";
							window.close();
						})
					</script>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>