<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>	
	<c:choose>
		<c:when test="${loginId != null}">
			<table border=1 align=center>
				<tr>
					<th colspan=4>${loginId }님 안녕하세요.
				</tr>
				<tr>
					<td><button id="Toboard">To Board</button>
					<td><button id="Mypage">MyPage</button>
					<td><button id="logout">LogOut</button>
					<td><button id="leave">Leave</button>
				</tr>
			</table>
			<script>
				$("#logout").on("click",function(){
					if(confirm("정말 로그아웃 하시겠습니까?")){
						location.href="/logout.con";
					}
				})
				
				$("#leave").on("click",function(){
					if(confirm("지금 회원을 탈퇴하시면 모든 정보가 사라집니다. 그래도 탈퇴하시겠습니까?")){
						location.href="/leave.con";
					}
				})
				
				$("#Mypage").on("click",function(){
					location.href="/mypage.con";
				})
				
				$("#Toboard").on("click",function(){
					location.href="/toboard.board";
				})
			</script>
		</c:when>
		<c:otherwise>
			<table border=1 align=center>
				<tr>
					<td colspan=2 align=center>회원 로그인
				</tr>
				<form action="/login.con" method=post>
					<tr>
						<td>아이디 :
						<td><input type=text name=id>
					</tr>
					<tr>
						<td>비밀번호 :
						<td><input type=password name=pw>
					</tr>
					<tr>
						<td colspan=2 align=center><button type=submit>로그인</button>
				</form>
				<a href="/signup.con"><button>회원가입</button></a>
				</tr>
			</table>
			
		</c:otherwise>
	</c:choose>
</body>
</html>