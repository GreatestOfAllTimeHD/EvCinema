<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	$(function() {
		$("#btnLogin").click(function() {
			id = $("#id").val();
			var pw = $("#pw").val();
			if (id == "") {
				alert("아이디를 입력하세요");
				$("#id").focus(); //입력포커스 이동

				return; //함수 종료
			}
			if (pw == "") {
				alert("비밀번호를 입력하세요");
				$("#pw").focus();
				return;
			}
			//폼 내부의 데이터를 전송할 주소
			document.form1.action = "${path}/login_check";
			document.form1.submit(); //제출
		});
	});
</script>
</head>

<body>
	<h2>로그인</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input id="id" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button> 
					<c:if test="${message == 'error'}">
						<div style="color: red;">아이디 또는 비밀번호가 일치하지 않습니다.</div>
					</c:if> 
					<c:if test="${message == 'logout'}">
						<div style="color: red;">로그아웃되었습니다.</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>