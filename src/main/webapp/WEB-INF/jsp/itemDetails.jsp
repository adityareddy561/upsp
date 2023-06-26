<%@page import="com.upspapp.modal.Advertisement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postDetails</title>
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/postDetails.js" type="text/javascript"></script>
<script src="js/custom.js" type="text/javascript"></script>
<style type="text/css">
.mainContainer {
	margin-top: 20px;
	display: flex;
}

.imgContainer {
	display: flex;
	width: 80%;
}

.itemImage {
	white-space: nowrap;
	overflow: auto;
}

.itemImage img {
	width: 100%;
}

.aboutItem {
	display: flex;
	margin: 10px 20px;
	border: 1px solid gray;
	margin: 10px 20px;
}

.chatWithSeller {
	border: 1px solid gray;
	margin: 0px 5px;
	padding: 5px 5px;
	text-align: center;
}

#feedbackHeader {
	font-size: 25px;
}

.feedback {
	border: 1px solid gray;
	margin: 5px 5px;
	padding: 5px 5px;
	text-align: center;
}

.feedback textarea {
	margin-top: 5px;
	border-radius: 3px;
}

#forEmail {
	border: 1px solid gray;
	margin: 5px 5px;
	border-radius: 3px;
}

#useremail {
	border: none;
	outline: none;
	box-shadow: none;
}

.itemData {
	padding: 10px 10px;
	width: 50%;
}

#chatBtn {
	font-size: 20px;
	padding: 30 10px;
	margin: 20px 10px;
}

.itemData {
	display: flex;
	justify-content: space-between;
}

.mainItemDetails {
	border: 1px solid gray;
	margin: 10px 5px;
	padding: 5px 5px;
}

#sellerName {
	font-size: 25px;
}

.details {
	border: 1px solid gray;
	width: 100%;
}

.ratingStar {
	margin: 10px;
}

.ratingStar i {
	color: lightGray;
	font-size: 20px;
}

#rate p {
	font-size: 25px;
}

.rate {
	margin: 10px;
}

.Postfeedback {
	border: 1px solid gray;
	text-align: center;
	margin: 5px 5px;
}

.Postfeedback button {
	margin: 10px 10px;
}

#rating {
	margin: 10px 10px;
}

#close {
	margin: 5px 10px;
	padding: 5px 5px;
	float: right;
}

.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
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
	margin: 20% auto;
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

.reportInput {
	margin: 10px 0px;
	width: 35%;
	padding: 3px 0px;
}

.feedbackButton {
	text-align: center;
	display: inline-block;
	position: relative;
	text-decoration: none;
	color: white;
	text-transform: capitalize;
	width: 90%;
	background-image: linear-gradient(60deg, #0083FD, #61A1DD);
	font-size: 16px;
	padding: 5px;
	overflow: hidden;
	border-radius: 5px;
}
</style>
</head>
<body onload="getProductById();">

	<div class="mainContainer">
		<div class="imgContainer">
			<button>
				<i class="fa fa-chevron-left" aria-hidden="true"
					onclick="closeCard();"></i>
			</button>
			<div class="itemImage">
				<img alt=""
					src="https://thumbs.dreamstime.com/b/environment-earth-day-hands-trees-growing-seedlings-bokeh-green-background-female-hand-holding-tree-nature-field-gra-130247647.jpg">
			</div>
			<button>
				<i class="fa fa-chevron-right" aria-hidden="true"></i>
			</button>
		</div>
		<div>
			<div class="mainItemDetails">
				
				
				
			</div>
			<div class="chatWithSeller">
				<p id="sellerName">Seller</p>
				<button id="chatBtn">Chat With Seller</button>
			</div>
			<div class="Postfeedback">
				<button onclick="opneFeedback()" class="feedbackButton">Leave
					a Feedback</button>
				<br>
				<button type="button" class="btn btn-primary" onclick="report()">Report
					the Post</button>
			</div>

		</div>

	</div>
	<div id="feedbackModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeFeedback()">&times;</span>
			<!-- Place your forgot password design content here -->
			<h2>-: Feedback :-</h2>

			<form style="text-align: left;">
				<p>Enter feedback</p>
				<input id="name" class="reportInput" type="text"
					placeholder="Enter feedback :" required>
				<button style="padding: 5px 10px;" type="button"
					onclick="addFeedbackOnPost();">Send Feedback</button>
			</form>
		</div>
	</div>
	<div id="report" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeReport()">&times;</span>
			<!-- Place your forgot password design content here -->
			<h2>-: Report :-</h2>

			<form style="text-align: left;">
				<p>Enter Report</p>
				<input id="name" class="reportInput" type="text"
					placeholder="Enter report :" required>
				<button style="padding: 5px 10px;" type="button"
					onclick="addReportOnPost();">Report</button>
			</form>
		</div>
	</div>
</body>
</html>