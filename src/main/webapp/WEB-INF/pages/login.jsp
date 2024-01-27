<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
</head>
<body>
	

	<div class="container">
		<form action="login" method="Post">
			<div class="mb-3">
				<label for="uname" class="form-label">User Name</label>
				<input class="form-control col-3" type="text" name="username" id="uname"/>
			</div>
			
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input class="form-control col-3" type="password" name="password" id="password"/>
			</div>
			<input type="submit" value="Login">
		</form>
		<p> ${message} <p>
	</div>

</body>
</html>