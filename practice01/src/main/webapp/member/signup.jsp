<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	.title{text-align:right;}
</style>
</head>
<script>
	$(function() {
		$("#idCheck").on(
				"click",
				function() {
					let id = $("#id").val();
					if (id == "") {
						alert("아이디를 입력하세요.");
						return;
					}
					window.open("/idCheck.mem?id=" + $("#id").val(), "",
							"width=400px,height=400px,top=200px,left=200px");
				})
	})
</script>
<body>
	<form action="/insert.mem" method="post" id="frm">
		<table border="1" align="center">
			<tr>
				<th colspan="2" align="center">회원 가입 정보</th>
			</tr>
			<tr>
				<td class="title">아이디 :</td>
				<td><input type="text" name="id" id="id"> <input type="button"
					value="중복확인" id="idCheck"></td>
			</tr>
			<tr>
				<td class="title">비밀번호 :</td>
				<td><input type="password" name="pw" id="pwd"></td>
			</tr>
			<tr>
				<td class="title">비밀번호 확인 :</td>
				<td><input type="password" name="repwd" id="repwd"><span id="result"></span></td>
				
			</tr>
			<tr>
				<td class="title">이름 :</td>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td class="title">전화번호 :</td>
				<td>
					<select name="select">
						<option>010</option>
						<option>016</option>
						<option>017</option>
						<option>018</option>
					</select>
					 - 
					<input type="text" name="num1">
					 - 
					<input type="text" name="num2"> 
				</td>
			</tr>
			<tr>
				<td class="title">이메일 :</td>
				<td><input type="text" name="email" id="email"></td>
			</tr>
			<tr>
				<td class="title">우편번호 :</td>
				<td><input type="text" name="zipcode" id="postcode"> <input type="button" value="찾기" id="search"></td>
			</tr>
			<tr>
				<td class="title">주소1 :</td>
				<td><input type="text" name="addr1" id="adrs1"></td>
			</tr>
			<tr>
				<td class="title">주소2 :</td>
				<td><input type="text" name="addr2" id="adrs2"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit">회원가입</button>
					<button type="reset">다시 입력</button>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		let frm = $("#frm");
		let id = $("#id");
		let pwd = $("#pwd");
		let repwd = $("#repwd");
		let result = $("#result");
		let name = $("#name");
		let email = $("#email");
		
		repwd.on("keyup",function(){
			if(pwd.val()!=repwd.val()){
				result.html("비밀번호가 일치하지 않습니다.");
			}else{
				result.html("비밀번호가 일치합니다.");
			}
		})
		
		frm.on("submit", function(){
			let idRegex = /[a-z][a-z0-9]{5,10}/g;
			let idResult = idRegex.test(id.val());
			if(!idResult){
				alert("아이디를 제대로 입력해주세요.");
				id.val("");
				id.focus();
				return false;
			}
			
			let nameRegex = /[가-힣]{2,5}/g;
			let nameResult = nameRegex.test(name.val());
			if(!nameResult){
				alert("이름을 제대로 입력해주세요.");
				name.val("");
				name.focus();
				return false;
			}
			
			let emailRegex = /^.+?@.+?.com$/g;
			let emailResult = emailRegex.test(email.val());
			if(!emailResult){
				alert("이메일을 제대로 입력해주세요.");
				email.val("");
				email.focus();
				return false;
			}
		})
		
		document.getElementById("search").onclick = function(){
            new daum.Postcode({
                oncomplete: function(data){
                    document.getElementById('postcode').value = data.zonecode;
                    document.getElementById("adrs1").value = data.roadAddress;
                    document.getElementById("adrs2").value = data.jibunAddress;
                }
            }).open();
        }
	</script>
</body>
</html>