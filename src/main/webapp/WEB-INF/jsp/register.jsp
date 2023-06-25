<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style type="text/css">
.header {
	margin-top: 10px;
}

button {
	margin: 0px 5px;
	padding: 5px;
	border-radius: 10px;
	border-style: none;
	background-color: gray;
}

.icon {
	margin-top: 15px;
	padding: 0px 10px;
	font-size: 18px;
}

.inputContainer {
	display: flex;
	margin: 15px;
}

.iconHeader {
	border: 1px solid gray;
	padding: 5px 10px;
}

.inputHolder {
	border: 1px solid gray;
	border-top-right-radius: 3px;
	border-bottom-right-radius: 3px;
	width: 100%;
}

#email {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 10px;
}

#password {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 10px;
}

#phoneNo {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 10px;
}

#userName {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 10px;
}

#profileEmage {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 10px;
}

.userIndentity {
	display: flex;
	justify-content: space-between;
}

.forRegister {
	display: flex;
	margin: 10px;
	margin-left: 15px;
	width: 50%;
}

.forRegister span {
	color: black;
}

.btn {
	width: 95%;
	margin: 10px;
}

.gendarInput {
	border: none;
	outline: none;
	box-shadow: none;
}
</style>

<meta charset="UTF-8">
<title>Registration</title>
<script src="js/register.js" type="text/javascript"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col m7 offset-m3">

				<div class="card">
					<div class="card-content">
						<h3 class="center-align header">Registration</h3>
						<h5 id="msg" class="center-align"></h5>
						<div class="form center-align">
							<form id="myform">
								<div class="inputContainer">
									<div class="iconHeader">
										<i class="fa fa-user icon" aria-hidden="true"></i>
									</div>
									<div class="inputHolder">
										<input class="userData" type="text" id="userName"
											name="userName" placeholder="Enter name" required="required" />
									</div>
								</div>

								<div class="inputContainer">
									<div class="iconHeader">
										<i class="fa fa-envelope icon" aria-hidden="true"></i>
									</div>
									<div class="inputHolder">
										<input class="userData" type="text" id="email" name="email"
											placeholder="Enter email" required="required" />
									</div>

								</div>
								<div class="inputContainer">
									<div class="iconHeader">
										<i class="fa fa-lock icon" aria-hidden="true"></i>
									</div>
									<div class="inputHolder">
										<input style="border: none; outline: none; box-shadow: none;"
											class="userData" type="text" id="password" name="password"
											placeholder="Enter password" required="required" />
									</div>

								</div>
								<div class="inputContainer">
									<div class="iconHeader">
										<i class="fa fa-phone icon" aria-hidden="true"></i>
									</div>
									<div class="inputHolder">
										<input style="border: none; outline: none; box-shadow: none;"
											class="userData" type="text" id="phoneNo" name="phoneNo"
											placeholder="Enter Mobile Number" required="required" />
									</div>

								</div>
								<div class="file-field input-field">
									<div class="file btn">
										<span>Image</span> <input type="file">
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text">
									</div>
								</div>

								<div class="forRegister">
									<label> <input class="with-gap gendarInput" id="Seller"
										name="registerBy" type="radio" value="Seller" /> <span>Seller</span>
									</label> <label> <input class="with-gap gendarInput" id="buyer"
										name="registerBy" type="radio" value="Buyer" /> <span>Buyer</span>
									</label>
								</div>
								<button type="button" class="btn" onclick="userRegister();">Register</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>