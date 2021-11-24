<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    
<style type="text/css">
	.title{text-align:right;}
</style>

<script>
	$(function(){
		$("#check").on("click",function(){
			window.open("/idCheck.con?id="+$("#id").val(),"","width=200px,height=100px,top=200px,left=200px");
		})
	})
</script>
</head>
<body>
	<form action="" id=form>
		<table border="1" align=center>
			<tr>
				<th colspan=2 align=center>회원 가입 정보
			</tr>
			<tr>
				<td class=title>아이디 :
				<td><input type=text id=id><input type=button value=중복확인 id=check>
			</tr>
			<tr>
				<td class=title>비밀번호 :
				<td><input type=password id=pwd>
			</tr>
			<tr>
				<td class=title>비밀번호 확인 :
				<td><input type=password id=repwd>
				<span id=result></span>
			</tr>
			<tr>
				<td class=title>이름 :
				<td><input type=text id=name>
			</tr>
			<tr>
				<td class=title>전화번호 :
				<td>
					<select>
						<option>02
						<option>055
						<option>010
						<option>080
					</select>
					 - <input type=text id=num1> - <input type=text id=num2>
				</td>
			</tr>
			<tr>
				<td class=title>이메일 :
				<td><input type=text id=email>
			</tr>
			<tr>
				<td class=title>우편번호 :
				<td><input type=text><input type=button value=찾기 id=search>
			</tr>
			<tr>
				<td class=title>주소1 :
				<td><input type=text id=postcode>
			</tr>
			<tr>
				<td class=title>주소2 :
				<td><input type=text id=adrs1><input type=text>
			</tr>
			
			<tr>
				<td colspan=2 align=center>
					<button type=submit>회원가입</button> <button type="reset">다시 입력</button>
			</tr>
		</table>
	</form>
	
	<script>
		let form = $("#form");
		let pwd = $("#pwd");
		let repwd = $("#repwd");
		let result = $("#result");
		let id = $("#id");
		let name = $("#name");
		let num1 = $("#num1");
		let num2 = $("#num2");
		let email = $("#email");
		
		repwd.on("keyup",function(){
			if(pwd.val()!=repwd.val()){
				result.html("비밀번호가 일치하지 않습니다.");
				result.css("color","red");
			}else{
				result.html("비밀번호가 일치합니다.");
				result.css("color","blue");
			}
		})
		
		pwd.on("keyup",function(){
			if(pwd.val()!=repwd.val()){
				result.html("비밀번호가 일치하지 않습니다.");
				result.css("color","red");
			}else{
				result.html("비밀번호가 일치합니다.");
				result.css("color","blue");
			}
		})
		
		form.on("submit",function(){
			let idRegex = /[a-z][a-z0-9]{5,10}/g;
			let idResult = idRegex.test(id.val());
			if(!idResult){
				alert("아이디를 제대로 입력해주세요.")
				id.val("");
				id.focus();
				return false;
			}
			
			let nameRegex = /[가-힣a-z]{2,}/g;
			let nameResult = nameRegex.test(name.val());
			if(!nameResult){
				alert("이름을 입력해주세요.")
				name.val("");
				name.focus();
				return false;
			}
			
			let numRegex = /[0-9]{4}/;
			let num1Result = numRegex.test(num1.val());
			let num2Result = numRegex.test(num2.val());
			if(!num1Result||!num2Result){
				alert("전화번호를 제대로 입력해주세요.")
				num1.val("");
				num1.focus();
				return false;
			}
			
			let emailRegex = /.+?@.+?\.com/g;
			let emailResult = emailRegex.test(email.val());
			if(!emailResult){
				alert("이메일을 제대로 입력하세요.")
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
                }
            }).open();
        }
	</script>
	
</body>
</html>