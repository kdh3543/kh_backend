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
	<form id=frm>
		<button id=btn>버튼</button>
	</form>
	<script>
		let frm = $("#frm");
		let btn = $("#btn");
		frm.on("submit",function(){
			alert("핼로");
		})
	</script>
</body>
</html>