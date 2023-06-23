<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.mainNavbar {
	position: fixed;
	top: 0;
}

.nav-wrapper {
	background-color: rgb(239, 241, 243);
	display: flex;
	padding: 10px;
	justify-content: space-between;
}

.brandLogo {
	color: #002f34;
	font-size: 25px;
}

.brand {
	margin-top: -18px;
	text-align: center;
	cursor: pointer;
}

#logoDesc {
	color: black;
	margin-top: -45px;
}

.locationSearch {
	border: 1px solid black;
	width: 60%;
}

.sub-nav {
	width: 30%;
	display: flex;
	justify-content: space-between;
	display: flex;
}

#location {
	border: none;
	outline: none;
	box-shadow: none;
}

.loginBtn {
	color: black;
	background: none;
	font-size: 20px;
}

.registerBtn {
	color: black;
	background: none;
	font-size: 20px;
}

.browsLocation {
	display: flex;
	margin: auto;
}

.fa-search {
	margin-top: -12px;
	padding: 5px 10px;
	color: black;
}

.searching {
	border: 1px solid black;
	display: flex;
	width: 40%;
}

#searchItem {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 5px 5px;
	margin-top: -8px;
}

.forSearch {
	background-color: #002f33;
}

#seacrhingIcon {
	color: white;
	margin-top: -20px;
}

.subNavbar {
	background-color: rgb(239, 241, 243);
	margin: 5px;
	display: flex;
	margin-top: 75px;
}

.subNavbar ul li a {
	color: #003135;
	background: none;
}

.subNavbar ul li a:hover {
	color: #40b0b8;
	background: none;
}

#sellBtn {
	padding: 5px 10px;
	border: none;
	background: none;
	font-size: 20px;
}

profileBtn {
	padding: 5px 10px;
	border: none;
	background: none;
	font-size: 20px;
}

.btn {
	color: black;
}

#registerBtn {
	padding: 5px 10px;
	border: none;
	background: none;
	font-size: 20px;
}

.allCategory a {
	color: #003135;
	cursor: pointer;
	margin-left: 15px;
}

.itemContainer {
	background-color: #ebeeef;
	padding: 10px 10px;
	margin: 10px 10px;
	'
}

.itemdescription {
	width: 23%;
	border: 1px solid gray;
	padding: 5px 5px;
	background-color: white;
	cursor: pointer;
	margin: 0px 10px;
}

.itemImage {
	width: 100%;
}

.likeBtn {
	float: right;
	display: flex;
	margin-top: 8px;
	background-color: white;
}

.like {
	margin: 0px 5px;
	cursor: pointer;
}

.save {
	margin: 0px 5px;
	cursor: pointer;
}

.aboutItem {
	
}

.desc {
	margin: 5px 5px;
}

.postingTime {
	margin-left: 180px;
}

.itemList {
	display: flex;
	flex-wrap: wrap;
	list-style-type: none;
	padding: 0;
}

.forScroll {
	display: flex;
}

.scrollBtn {
	border: none;
	background: none;
}

#userP {
	display: none;
}

#dropPoint {
	cursor: pointer;
}

#dropContent {
	display: none;
	position: absolute;
	margin-top: 55px;
}

#dropContent p {
	color: black;
}
</style>

<link rel="stylesheet" href="css/profile.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- <script src="js/register.js" type="text/javascript"></script> -->
<script src="js/custom.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/sellingCategory.js" type="text/javascript"></script>
<script src="js/profile.js" type="text/javascript"></script>
<script src="js/updateProfile.js" type="text/javascript"></script>

<meta charset="UTF-8">
<title>Home page</title>
</head>
<body onload="getAllCategories();getAllPosts();">
	<div>
		<div class="">
			<nav class="mainNavbar">
				<div class="nav-wrapper">
					<div class="sub-nav">
						<div class="brand">
							<a href="#" class="brandLogo">U P S P</a>
							<p id="logoDesc">Quick Sell Used Item</p>
						</div>
						<div class="locationSearch">
							<div class="browsLocation">
								<i class="fa fa-search" aria-hidden="true"></i> <input
									id="location" class="location" list="browsers" name="myBrowser"
									placeholder="Search for location" />
								<datalist id="browsers">
									<option value="Chrome">
								</datalist>
							</div>
						</div>
					</div>
					<div class="searching">
						<input id="searchItem" type="text"
							placeholder="find cars mobiles and more.">
						<div class="forSearch">
							<i id="seacrhingIcon" class="fa fa-search" aria-hidden="true"
								onclick="searchByQuery();"></i>
						</div>
					</div>
					<ul id="" class="right hide-on-med-and-down">
						<li><a class="loginBtn" id="loginBtn" href="checkProfile">Me</a></li>
						<li><a class="loginBtn" id="loginBtn" href="login">Login</a></li>
						<li><a class="registerBtn" href="registration">Register</a></li>
						<li><a class="registerBtn" href="#"
							onclick="showSellingCategory();">Sell</a></li>
					</ul>
				</div>
			</nav>

		</div>

		<div class="postAdds" id="postAdds">
			<nav class="subNavbar">
				<div class="allCategory">
					<a>AllCategory <i class="fa fa-chevron-down" aria-hidden="true"></i>
					</a>
				</div>
				<ul id="categories"></ul>
			</nav>
			<ul class="itemList">

			</ul>
			<div id="feedback" class="feedback"></div>
		</div>
		<div id="userProfile">
			<div>
				<div class="imgContainer">
					<img id="userImage" class="userImage" alt=""
						src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png">
					<div>
						<h4 id="userName">M.Ishaq Khan</h4>
					</div>
				</div>
				<div class="aboutInfo">
					<i style="color: black;" class="fa fa-info-circle"
						aria-hidden="true"></i>
					<p id="aboutUser">this is about user</p>

				</div>
				<div style="text-align: left; margin: 5px 10px; padding: 5px 10px">
					<p style="">User verified with</p>
					<div style="margin-top: -10px;">
						<i class="fa fa-google verfied" aria-hidden="true"></i> <i
							class="fa fa-phone-square verified" aria-hidden="true"></i>

					</div>
				</div>

			</div>
		</div>
		<div class="profileEdit" id="profileEdit">
			<p class="header" id="head">Edit Profile</p>
			<hr>

			<div class="edition">
				<div class="info">
					<p class="header">Basic information</p>

					<div class="inputContainer" id="inputFirstName">
						<input class="userInput" id="firstnameInput" type="text"
							name="firstName" placeholder="firstName" value="">
					</div>
					<div class="inputContainer" id="inputLastName">
						<input class="userInput" id="lastnameInput" type="text"
							name="lastName" placeholder="lastName" value="">
					</div>
					<div class="inputContainer" id="inputAboutUser">
						<input class="userInput" id="aboutInput" type="text"
							name="aboutUser" placeholder="about User" value="">
					</div>
				</div>

				<div class="info" id="contactInfo">
					<p>Contact information</p>
					<div class="inputContainer" id="inputAboutUser">
						<input class="userInput" id="genderInput" type="text"
							name="userGender" placeholder="User gendar" value="">
					</div>
					<div class="inputContainer" id="inputAboutUser">
						<input class="userInput" id="emailInput" type="email" name="email"
							placeholder="Email" value="">
					</div>
				</div>
			</div>
			<hr>
			<div class="editionBtn">
				<button id="discard" class="profile">Discard</button>
				<button id="saveChanges" class="profile" onclick="updateProfile();">Save
					Changes</button>

			</div>
		</div>

	</div>

	<script type="text/javascript">
		function showProfile() {
			console.log('hello..');
			//document.getElementById('dropD').style.display="block";
			if (document.getElementById('dropD').style.display === "block") {
				document.getElementById('dropD').style.display = "none";
			} else {
				document.getElementById('dropD').style.display = "block"
			}
		}

		function openProfile() {
			if (document.getElementById('dropContent').style.display === "none") {
				document.getElementById('dropContent').style.display = "block";

			} else {
				document.getElementById('dropContent').style.display = "none";
			}
		}
	</script>
</body>
</html>