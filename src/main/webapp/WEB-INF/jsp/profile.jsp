<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/sellingCategory.js" type="text/javascript"></script>

<script src="js/profile.js" type="text/javascript"></script>
<script src="js/updateAds.js" type="text/javascript"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.showProfile {
display:none;
	width: 30%;
}

#viewProfile {
	width: 40%;
}

#editProfile {
	width: 40%;
}

.profile {
	padding: 10px 20px;
	border: 2px solid #002f33;
	background-color: #002f33;
	color: white;
	cursor: pointer;
	margin: 10px 10px;
}

.profile:hover {
	background-color: white;
	color: #002f33;
}

#userProfile {
	width: 30%;
	border: 1px solid gray;
	text-align: center;
	display: none;
}

.checkAds {
	padding: 10px 10px;
	width: 40%;
	background:
}

.userImage {
	width: 55px;
	margin: 10px;
}

.profileEdit {
	width: 70%;
	border: 1px solid gray;
}

.edition {
	display: flex;
}

.info {
	width: 50%;
	margin: 5px 10px;
}

hr {
	border: 1px solid gray;
}

#head {
	text-align: center;
	font-size: 20px;
}

.imgContainer {
	display: flex;
	margin: 10px 10px;
	position: relative;
}

#name {
	margin-left: 10px;
}

.profileOption {
	text-align: center;
}

#userName {
	margin-left: 30px;
}

.fa-info-circle {
	margin-top: 15px;
	padding: 5px 10px;
}

#aboutUser {
	
}

.inputContainer {
	width: 80%;
	border: 1px solid #002f33;
	margin: 20px 10px;
	padding: 10px 10px;
	border-radius: 3px;
}

.userInput {
	background: none;
	width: 100%;
	border: none;
	outline: none;
	box-shadow: none;
}

.updateBtn {
	margin: 10px 10px;
	padding: 10px 10px;
	border: 1px solid #002f33;
	background-color: white;
}

.editionBtn {
	width: 70%;
	display: flex;
	justify-content: space-between;
	display: flex;
	margin: auto;
}

.aboutInfo {
	display: flex;
	text-align: center;
	width: 50%;
	margin: auto;
	margin-top: -25px;
}

.verfied {
	margin: 5px 10px;
	cursor: pointer;
}

.adsContaier {
	border: 1px solid gray;
	text-align: center;
	display: none;
}

ul li {
	padding: 5px 10px;
	margin: 10px 0px;
	cursor: pointer;
}

.checkAds li:hover {
	background-color: lightPink;
}

.adsData {
	display: flex;
}

.myAds {
	
}

table tr td img {
	width: 100%;
}

.actionBtn {
	display: flex;
	justify-content: space-between;
	padding: 10px 10px;
}

.actionBtn button {
	margin: 5px 20px;
}

.productImage {
	width: 20%;
}

.container {
	display: none;
}

#myform textarea {
	box-shadow: none;
}

.profileBtns {
	width: 30%;
	text-align: center;
	padding-top: 30px;
}

.profileContainer {
	display: flex;
	display:none;
	border: 1px solid gray;
	margin: 10px 10px;
	padding: 10px 10px;
}
</style>
</head>
<body>
	<div class="card showProfile">
		<div class="imgContainer">
			<img class="userImage" alt=""
				src="https://cdn-icons-png.flaticon.com/512/3135/3135715.png">
			<h5 id="name">M.Ishaq Khan</h5>

		</div>
		<div class="profileOption">
			<button class="profile" id="viewProfile"
				onclick="showOptions('profileContainer');">View & Edit
				Profile</button>
			<br>
			<hr>
			<ul class="checkAds highlight">
				<li onclick="showAds('adsContainer');">
					<p>My Ads</p>
				</li>
			</ul>
		</div>
	</div>


	<div class="profileContainer" id="profileContainer">
		<div class="profileBtns">
			<button class="profile" onclick="viewProfile('userProfile');">View
				Profile</button><br>
			<button class="profile" onclick="editProfile('profileEdit');">Edit
				Profile</button>

		</div>
		<div class="profileEdit" id="profileEdit">
			<p class="header" id="head">Edit
				Profile</p>
			<hr>

			<div class="edition">
				<div class="info">
					<p class="header">Basic information</p>

					<div class="inputContainer" id="inputName">
						<input class="userInput" type="text" name="userName"
							placeholder="userName" value="">
					</div>
					<div class="inputContainer" id="inputAboutUser">
						<input class="userInput" type="text" name="aboutUser"
							placeholder="about User" value="">
					</div>
				</div>

				<div class="info" id="contactInfo">
					<p>Contact information</p>
					<div class="inputContainer" id="inputNumber">
						<input class="userInput" type="text" name="contactNumber"
							placeholder="Contact Number" value="">
					</div>
					<div class="inputContainer" id="inputEmail">
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




	</div>
	<script type="text/javascript">
		function showOptions(id) {
			let profile = document.getElementById(id);
			profile.style.display = "block";
			profile.style.display = "flex";

		}
		function viewProfile(id) {
			let profile = document.getElementById(id);
			if (profile.style.display ==="none") {
				profile.style.display = "block";
				document.getElementById('profileEdit').style.display = "none"
			} else {
				profile.style.display = "none";
			}
		}
		function editProfile(id) {
			let profile = document.getElementById(id);
			if (profile.style.display === "none") {
				profile.style.display = "block";
				document.getElementById('userProfile').style.display = "none"
			} else {
				profile.style.display = "none";
			}
		}
		function showAds(id) {
			document.getElementById(id).style.display = "block";
		}
		function updateProduct(id, name, owner, price, desc) {
			var Pid = document.getElementById(id).innerHTML;
			var Pname = document.getElementById(name).innerHTML;
			var Powner = document.getElementById(owner).innerHTML;
			var Pprice = document.getElementById(price).innerHTML;
			var Pdesc = document.getElementById(desc).innerHTML;

			console.log(Pid);
			console.log(Pname);
			console.log(Pprice);
			console.log(Powner);
			console.log(Pdesc);

			document.getElementById('id').value = Pid;

			document.getElementById('productName').value = Pname;

			document.getElementById('productPrice').value = Pprice;

			document.getElementById('productOwner').value = Powner;

			document.getElementById('productDescription').value = Pdesc;

			document.getElementById('adsContainer').style.display = "none";

			document.getElementById('container').style.display = "block";

		}
		function updateProfile() {
			alert('profile update successfully..');
			document.getElementById('postAdds').style.display = "block";
			document.getElementById('profileEdit').style.display = "none";

		}
	</script>
</body>
</html>