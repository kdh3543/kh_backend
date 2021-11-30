<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<form action="/update.con" id=form method=post>
		<table border="1" align=center>
			<tr>
				<th colspan=2 align=center>회원 정보 수정
			</tr>
			<tr>
				<td class=title>아이디 :
				<td><input type="text" name=id id="id" value="${dto.id }" disabled><br>
				가입일 : ${dto.signup_date }
			</tr>
			<tr>
				<td class=title>비밀번호 :
				<td><input type=password id=pwd name=pwd >
			</tr>
			<tr>
				<td class=title>비밀번호 확인 :
				<td><input type=password id=repwd >
				<span id=result></span>
			</tr>
			<tr>
				<td class=title>이름 :
				<td><input type=text id=name name=name value="${dto.name }">
			</tr>
			<tr>
				<td class=title>전화번호 :
				<td>
					<input type=text id=num name=num value="${dto.phone }">
				</td>
			</tr>
			<tr>
				<td class=title>이메일 :
				<td><input type=text id=email name=email value ="${dto.email }">
			</tr>
			<tr>
				<td class=title>우편번호 :
				<td><input type=text id=postcode name=postcode value="${dto.zipcode }">
				<input type=button value=찾기 id=search>
			</tr>
			<tr>
				<td class=title>주소1 :
				<td><input type=text id=adrs1 name=adrs1 value="${dto.address1}">
			</tr>
			<tr>
				<td class=title>주소2 :
				<td><input type=text id=adrs2 name=adrs2 value="${dto.address2}">
			</tr>
			
			<tr>
				<td colspan=2 align=center>
					<button type=submit>수정하기</button> <button type="reset">다시 입력</button>
			</tr>
		</table>
	</form>
	
	<script>
		let form = $("#form");
		let pwd = $("#pwd");
		let repwd = $("#repwd");
		let result = $("#result");
		let name = $("#name");
		let num = $("#num");
		let email = $("#email");
		let id = $("#id");
		
		id.on("click",function){
			alert("아이디는 수정할 수 없습니다.");
			pwd.focus();
		}
		
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
			let nameRegex = /[가-힣a-z]{2,}/g;
			let nameResult = nameRegex.test(name.val());
			if(!nameResult){
				alert("이름을 입력해주세요.")
				name.val("");
				name.focus();
				return false;
			}
			
			let numRegex = /^[0-9]{10,11}$/;
			let numResult = numRegex.test(num.val());
		
			if(!numResult){
				alert("전화번호를 제대로 입력해주세요.")
				num.val("");
				num.focus();
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
                    document.getElementById("adrs2").value = data.jibunAddress;
                }
            }).open();
        }
	</script>
</body>
</html>