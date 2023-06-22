
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>User Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/login.js"></script>
</head>

<body>
	<div class="row" style="width: 95%">
		<div class="col-sm-8">
			<img src="jsp/upsp-logo.png" style="width: 100%; max-height: 680px;">
		</div>
		<div class="col-sm-4">
			<div style="text-align: center; padding-top: 100px;">
				<h1 style="text-shadow: 0 0 2px red">Sign in</h1>
			</div>
			<div class="form-group">
				<label
					style="font-size: 20px; padding-top: 20px; text-shadow: 0 0 2px rgb(135, 152, 153)">User
					Name</label> <input id="username" class="form-control" type="text"
					name="username" placeholder="Enter Your User Name..." required>
			</div>
			<div class="form-group">
				<label
					style="font-size: 20px; padding-top: 20px; text-shadow: 0 0 2px rgb(135, 152, 153)">Password</label>
				<input id="password" class="form-control" type="text"
					name="password" placeholder="*************" required required>
			</div>

			<div class="form-group" style="padding-top: 20px; text-align: center">
				<button type="submit" class="btn btn-primary" onclick="login();"
					style="color: black; background: darkgray; width: 100%; font-weight: bold">
					Login</button>
			</div>
		</div>
	</div>

</body>

</html>