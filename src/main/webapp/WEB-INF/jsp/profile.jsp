<!DOCTYPE html>
<html lang="en">
	<head>
		<title>UPSP</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<script type="text/javascript"
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAQ-3cnEgApWSRMuneCN2Ekpgwuk9d9UJM&libraries=places"></script>
		<script src="https://code.jquery.com/jquery-3.7.0.min.js"
			integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
			crossorigin="anonymous"></script>
		<script src="js/custom.js"></script>
		<link rel="stylesheet" href="css/style.css">
		<script src="js/profile.js"></script>

		<style type="text/css">

.user-image {
	padding: 3em 0;
}

.user-image img {
	width: 250px;
	height: 250px;
	border-radius: 50%;
	box-shadow: 0 0.6em 1.8em;
	object-fit: cover;
}

.content {
	color: #565656;
}

.name {
	font-size: 1.5em;
	text-transform: uppercase;
}

.username {
	font-size: 1em;
	color: #9e9e9e;
}

.links {
	display: flex;
	justify-content: center;
	margin: 1.5em 0;
}

.insta:hover {
	color: rgb(255, 70, 101);
	transform: scale(2, 2);
}

.git:hover {
	color: rgb(0, 0, 0);
	transform: scale(2, 2);
}

.linkedin:hover {
	color: rgba(4, 0, 253, 0.842);
	transform: scale(2, 2);
}

.facebook:hover {
	color: rgb(4, 0, 255);
	transform: scale(2, 2);
}

h3 {
	margin: 5px 0px;
}

/* CSS for messagin link */
.editProfile {
	text-align: center;
	display: inline-block;
	position: relative;
	text-decoration: none;
	color: white;
	text-transform: capitalize;
	width: 100%;
	background-image: linear-gradient(60deg, #000000, #02070b);
	font-size: 1.2em;
	padding: 6px;
	border-radius: 5em;
	overflow: hidden;
	border-radius: 5em;
}

.submit {
	text-align: center;
	display: inline-block;
	position: relative;
	text-decoration: none;
	color: white;
	text-transform: capitalize;
	background-image: linear-gradient(60deg, #bd3434, #ae212f);
	font-size: 1.2em;
	padding: 6px;
	border-radius: 5em;
	overflow: hidden;
	width: 200px;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	border-radius: 10px;
}

.modal-content {
	background-color: #fefefe;
	margin: 20% auto;
	padding: 30px;
	border: 1px solid #888;
	width: 50%;
	border-radius: 5px;
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

.changePasswordInput {
	margin: 10px 0px;
	padding: 3px 0px;
}
</style>
	</head>
	<body onload="loadUserById()">
		<jsp:include page="navbar.jsp" />
			<div class="container">
				<div class="text-center">
					<h1>Profile</h1>
				</div>
				<div class="user-image">
					<div class="row">
						<div class="col-sm-3">
							<img
								src="https://sialifehospital.com/wp-content/uploads/2021/04/testimonial-1.png"
								alt="this image contains user-image">
							<!-- <button onclick="editProfile()" class="editProfile">Edit
								Profile</button> -->
							<br>
							<br>
							<div id="changepswd"></div>
							<br>
							<button onclick="logout()" class="editProfile">Logout</button>
						</div>
						<div class="col-sm-8">
							<br>
							<br>
							<br>

							<form style="text-align: left;">
								<p>Enter Name</p>
								<input id="name-input" class="form-control editProfileInput" type="text"
									placeholder="Enter your full name :" required>
								<p>Enter Email</p>
								<input id="email" class="form-control editProfileInput" type="email"
									placeholder="Enter your email :" required>
								<p>Enter mobile number</p>
								<input id="mobileNumber" class=form-control editProfileInput type="text"
									placeholder="Enter your mobile number :" required><br>
								<div class="text-right">
									<button class="submit" type="button"
										onclick="editProfileById();">Update</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="content">
					<div id="editProfile" class="modal">
						<div class="modal-content">
							<span class="close" onclick="closeEditProfile()">&times;</span>
							<!-- Place your forgot password design content here -->
							<h2>-: Edit Profile :-</h2>
							<form style="text-align: left;">
								<p>Enter Name</p>
								<input id="name-input" class="form-control editProfileInput" type="text"
									placeholder="Enter your full name :" required>
								<br>
								<p>Enter Email</p>
								<input id="email" class="form-control editProfileInput" type="email"
									placeholder="Enter your email :" required>
								<br>
								<p>Enter mobile number</p>
								<input id="mobileNumber" class=form-control editProfileInput type="text"
									placeholder="Enter your mobile number :" required><br>
								<button style="padding: 5px 10px; width: 20%" type="button"
									onclick="editProfileById();">Update</button>
							</form>
						</div>
					</div>
					<div id="changePassword" class="modal">
						<div class="modal-content">
							<span class="close" onclick="closeChangePassword()">&times;</span>
							<!-- Place your forgot password design content here -->
							<h2>Change Password</h2>
							<form style="text-align: left;">
								<p>Enter New Password</p>
								<input id="newPassword" class="form-control changePasswordInput"
									type="password" placeholder="Enter Password" required>
								<div id="updtPswd" class="text-right"></div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</body>
	</html>
