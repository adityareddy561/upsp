<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="preconnect" href="https://fonts.gstatic.com">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/profile.js"></script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

/* Assigning all the same properties to the body */
body {
	height: 100vh;
	display: flex;
	justify-content: center;
	background-color: rgb(0, 0, 0);
	align-items: center;
}

.container {
	width: 20em;
	background-color: rgb(255, 255, 255);
	overflow: hidden;
	border-radius: 1em;
	text-align: center;
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 1em;
}

.user-image {
	padding: 3em 0;
	background-image: linear-gradient(70deg, #61A1DD, #0083FD);
}

.user-image img {
	width: 7em;
	height: 7em;
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

a {
	text-decoration: none;
	color: #565656;
	transition: all 0.3s;
	font-size: 2em;
	margin-right: 1.2em;
}

a:last-child {
	margin: 0;
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
	width: 90%;
	background-image: linear-gradient(60deg, #0083FD, #61A1DD);
	font-size: 1.2em;
	padding: 6px;
	border-radius: 5em;
	overflow: hidden;
	border-radius: 5em;
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
<%
String userId = request.getParameter("userId");
%>
</head>
<body onload="loadUserById()">
	<div class="container">
		<div class="user-image">
			<img
				src="https://sialifehospital.com/wp-content/uploads/2021/04/testimonial-1.png"
				alt="this image contains user-image">
		</div>
		<h3 id="name"></h3>
		<h3 id="mail"></h3>
		<h3 id="mobile"></h3>
		<div class="content">
			<div class="links">
				<a class="facebook" href="" target="_blank" title="GFG_facebook">
					<i class="fab fa-facebook"></i>
				</a> <a class="git" href="" title="GFG_github" target="_blank"> <i
					class="fab fa-github-square"></i>
				</a> <a class="linkedin" href="" title="GFG_linkedin" target="_blank">
					<i class="fab fa-linkedin"></i>
				</a> <a class="insta" href="" target="_blank" title="GFG_instagram">
					<i class="fab fa-instagram-square"></i>
				</a>
			</div>
			<button onclick="editProfile()" class="editProfile">Edit
				Profile</button>
			<div id="editProfile" class="modal">
				<div class="modal-content">
					<span class="close" onclick="closeEditProfile()">&times;</span>
					<!-- Place your forgot password design content here -->
					<h2>-: Edit Profile :-</h2>
					<form style="text-align: left;">
						<p>Enter Name</p>
						<input id="name" class="editProfileInput" type="text"
							placeholder="Enter your full name :" required>
						<p>Enter Email</p>
						<input id="email" class="editProfileInput" type="email"
							placeholder="Enter your email :" required>
						<p>Enter mobile number</p>
						<input id="mobileNumber" class=editProfileInput type="text"
							placeholder="Enter your mobile number :" required><br>
						<button style="padding: 5px 10px; width: 20%" type="button"onclick="editProfileById();">Update</button>
					</form>
				</div>
			</div>
			<div id="changepswd" style="text-align: center; margin: 10px 0px;">

			</div>
			<div id="changePassword" class="modal">
				<div class="modal-content">
					<span class="close" onclick="closeChangePassword()">&times;</span>
					<!-- Place your forgot password design content here -->
					<h2>Change Password</h2>
					<form style="text-align: left;">
						<p>Enter New Password</p>
						<input id="newPassword" class="changePasswordInput"
							type="password" placeholder="Enter Password" required>
						<div id="updtPswd"></div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>