
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
<style type="text/css">
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	background-color: #fefefe;
	margin: 20% auto;
	padding: 30px;
	border: 1px solid #888;
	width: 50%;
}

.close {
	color: #aaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
	cursor: pointer;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>
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
					name="password" placeholder="*************" required >
			</div>

			<div class="form-group" style="padding-top: 20px; text-align: center">
				<button type="button" class="btn btn-primary" onclick="login();"
					style="color: black; background: darkgray; width: 100%; font-weight: bold">
					Login</button>
			</div>
			<div style="text-align: center;">
				<span style="cursor: pointer;" onclick="openForgotPasswordModal()">Forgot
					Password</span>
			</div>
			<div id="forgotPasswordModal" class="modal">
				<div class="modal-content">
					<span class="close" onclick="closeForgotPasswordModal()">&times;</span>
					<!-- Place your forgot password design content here -->
					<h2>Forgot Password</h2>
					<p>Please Enter Your Email</p>
					<form>
						<input id="forgetPasswordEmail" type="email" placeholder="Email"
							required>
						<button onclick="forgetPassword()" type="submit">Send</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>

</html>