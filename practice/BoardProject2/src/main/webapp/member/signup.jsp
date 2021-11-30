<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- window prefer template -> jsp template -> html5 -> edit // jquery, uri 추가-->
<script>
	$(function(){ // 아래쪽이 모두 실행된 이후에 실행된다. 제일 마지막에 실행된다고 봐도 괜찮을듯!
		$("#check").on("click", function(){
			
			let id = $("#id").val();
			if(id==""){
				alert("아이디를 입력하세요.");
				return;
			}		
			
			window.open("/idCheck.mem?id="+$("#id").val(),"","width=300px, height=200px, top=200px, left=200px");
			// "idCheck.mem?id="+$("#id").val() idCheck에 있는 id 값을 꺼내오는 명령어
			// idCheck.mem 앞에 member/가 붙는 이유 1.
			// 절대경로 : 대상의 경로가 시작되는 부분부터 끝나는 부분까지! 절대경로를 사용하고 싶으면 앞에다가 /를 붙여주어야한다.
			// 상대경로 : 대상이 그냥 있는 곳? 이름? 상대경로를 사용하고 싶으면 앞에다가 아무것도 안붙이면 된다.
			// 현재 내가 위치한 곳으로부터 상대를 부른다. 암묵적으로 같은 공간에 있는 idCheck을 부르기 때문에 member/idCheck이 불려진다.
			// /앞에 ..을 붙여서 ../이렇게 사용하면 상위폴더를 의미하게 된다.
			// 절대 : d:/dest/image_02.jpg
			// 상대 : d드라이브 웹응용폴더에서 ../dest/image_02.jp		
			
		})
	})
</script>
</head>
<body>
	<div>
		<table border=1>
			<tr>
				<td colspan=4 align="center">회원 가입 정보
			</tr>
			<tr>
				<td align="right">아이디 :
				<td><input type=text id="id">
					<button id="check">중복 확인</button>
			</tr>
			<tr>
				<td align="right">비밀번호 :
				<td><input type=text id="pw1">
			</tr>
			<tr>
				<td align="right">비밀번호 확인 :
				<td><input type=text id="pw2">
				<div id="result"></div>
			</tr>
			<tr>
				<td align="right">이름 :
				<td><input type=text>
			</tr>
			<tr>
				<td align="right">전화번호 :
				<td><select>
						<option>02</option>
						<option>010</option>
						<option>011</option>
				</select> -<input type=text>-<input type=text>
			</tr>
			<tr>
				<td align="right">이메일 :
				<td><input type=text>
			</tr>
			<tr>
				<td align="right">우편번호 :
				<td><input type=text id="postcode">
					<button id="search">찾기</button>
			</tr>
			<tr>
				<td align="right">주소1 :
				<td><input type=text id="roadAddress">
			</tr>
			<tr>
				<td align="right">주소2 :
				<td><input type=text id="detailAddress">
			</tr>
			<tr>
				<td colspan=4 align="center">
					<button>회원가입</button>
					<button>다시입력</button>
			</tr>
		</table>
	</div>

	<script>
		document.getElementById("search").onclick = function() {
			new daum.Postcode(
					{
						oncomplete : function(data) {

							document.getElementById('postcode').value = data.zonecode;
							document.getElementById("roadAddress").value = data.roadAddress;
							document.getElementById("jibunAddress").value = data.jibunAddress;
						}
					}).open(); //
		}

		let pw2 = document.getElementById("pw2");
		let result = document.getElementById("result");

		pw2.onkeyup = function() { // pw2가 입력 되었을 때 값을 비교하기 시작!!
			let pw1 = document.getElementById("pw1").value;
			let pw2 = document.getElementById("pw2").value;

			if (pw1 != pw2) {
				result.innerHTML = "비밀번호가 일치하지 않습니다.";
			} else {
				result.innerHTML = "비밀번호가 일치합니다.";
			}
		}
	</script>
</body>
</html>