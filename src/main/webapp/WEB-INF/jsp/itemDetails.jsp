<%@page import="com.upspapp.modal.Advertisement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>postDetails</title>
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

#feedback {
	margin: 10px 10px;
}

#feed

#rating {
	margin: 10px 10px;
}

#close {
	margin: 5px 10px;
	padding: 5px 5px;
	float: right;
}

.modal {
	width: 30%;
}
</style>
</head>
<body>

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
				<%
				// Retrieve the product data from sessionStorage
				String productDataJSON = (String) session.getAttribute("productData");
				System.out.println(productDataJSON);
				if (productDataJSON != null) {
					// Parse the JSON data to a Java object
					ObjectMapper objectMapper = new ObjectMapper();
					Advertisement productData = objectMapper.readValue(productDataJSON, Advertisement.class);
				%>
				<p id="price"><%="₹ " + productData.getPrice()%></p>
				<p id="KmDriven"><%=productData.getProductName()%></p>
				<p id="condition"><%=productData.getAddress()%></p>
				<p id="address"><%=productData.getDescription()%></p>
				<%
				} else {
				%>
				<p id="feedback">No Products Available</p>
				<%
				}
				%>
			</div>
			<div class="chatWithSeller">
				<p id="sellerName">Seller</p>
				<button id="chatBtn">Chat With Seller</button>
			</div>
			<div class="Postfeedback">
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#feedback">Leave a Feedback</button>
				<br>
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#review">Rate the Post</button>
			</div>

		</div>

	</div>
	<div class="modal fade" id="review" role="dialog">
		<div class="row">
			<div class="col s12 m12">
				<i id="close" class="card fa fa-times" aria-hidden="true"></i>
				<div class="card">
					<div class="card-content center-align" id="rate">
						<p>Rating Review</p>
						<div class="ratingStar">
							<i id="star1" class="fa fa-star" aria-hidden="true"
								onclick="showRate('star1');"></i> <i id="star2"
								class="fa fa-star" aria-hidden="true"
								onclick="showRate('star2');"></i> <i id="star3"
								class="fa fa-star" aria-hidden="true"
								onclick="showRate('star3');"></i> <i id="star4"
								class="fa fa-star" aria-hidden="true"
								onclick="showRate('star4');"></i> <i id="star5"
								class="fa fa-star" aria-hidden="true"
								onclick="showRate('star5');"></i>
						</div>
					</div>
					<div class="card-action center-align">
						<a href="#" onclick="sendRating();">Rate</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="feedback" role="dialog">
		<div class="row">
			<div class="col s12 m12">
				<div class="card">
					<div class="card-content"></div>
					<div class="card-action">
						<a href="#">This is a link</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function showRate(id) {
			var starId = document.getElementById(id);
			if (starId.style.color === "lightgray") {
				starId.style.color = "rgb(255 191 67)";
			} else {
				starId.style.color = "lightgray";
			}
		}
	</script>
</body>
</html>