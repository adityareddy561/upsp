<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>otp verification</title>
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script src="js/Otp.js"></script>
</head>
<body>
	<div class="row">
		<div class="col m6 offset-m3">
			<div class="card">
				<div class="card-content">
					<h5 id="msg" class="center-align"></h5>
					<div class="form center-align">
						<form id="myform">
							<input type="text" id="otp" name="otp"
								placeholder="Enter OTP" required="required" />
							<button type="submit" class="btn lightblue"
								onclick="sendOtp(${userId});">Send</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>