<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>get 방식</h3>
	<form action="/root/my/result" method="get">
		<input type="text" name="name"> <br>
		<input type="text" name="age"> <br>
		<input type="submit" value="get전송"> <br>
	</form>
	
	<h3>dto 방식</h3>
	<form action="dto" method="post">
		<input type="text" name="name"> <br>
		<input type="text" name="age11"> <br>
		<input type="text" name="addr11"> <br>
		<input type="submit" value="dto 전송"> <br>
	</form>
</body>
</html>