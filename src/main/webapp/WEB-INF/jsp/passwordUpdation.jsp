<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
		<head>
			<link rel="stylesheet"
				href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
			<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>
		<body>
			<div class="container">
				<div class="row">
					<div class="col m6 offset-m3">
						<div class="card">
							<div class="card-content">
								<h4 style="margin-top: 10px;" class="center-align">Password
									Update</h4>
								<h5 id="msg" class="center-align"></h5>
								<div class="form center-align">
									<form id="myform">
										<input type="password" id="email" name="email"
											placeholder="Enter new password" required="required" /> <input
											type="password" id="password" name="user_password"
											placeholder="ReEnter password" autocomplete="on"
											required="required" />
										<button type="submit" class="btn blue">save</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</body>
	</html>