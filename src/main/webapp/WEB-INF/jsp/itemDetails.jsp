<%@page import="com.upspapp.modal.Advertisement"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="UTF-8">
					<title>postDetails</title>
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
					<script src="js/custom.js"></script>
					<link rel="stylesheet" href="css/style.css">
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

body {
  margin: 0;
  background-color: #fff;
}

.bg-1 {
  height: 500px;
}

.mainWindow {
  background-color: #fff;
}

.product-img {
  max-width: 100%;
  max-height: 100%;
}

.item-desc {
  width: 100%;
  height: 100%;
  text-overflow: ellipsis;
}
.item-desc  {
  text-justify: inter-word;
}
.relatedCards {
  width: 100%;
  height: 150px;
  cursor: pointer;
}
.relatedCards img {
    width: 100%;
    height: 80%;
  }

  .star {
    width: 25px;
    height: 25px;
    transition: .6s all;
  }
  #rating {
    cursor: pointer;
    display: inline-block
  }
  #review-form .input-group-addon {
    min-width: 100px;
  }
  #review-form .btn {
    min-width: 100px;
  }
  #review-form input[type="text"],
  #review-form textarea {
    width: 100%;
  }
  #review-form .form-group {
    margin-bottom: 15px;
  }
  #review-form .help-block {
    display: block;
    margin-top: 5px;
    margin-bottom: 10px;
  }
  
  blockquote {
    border-left: 5px solid rgb(238, 238, 238);
    padding-left: 20px;
  }
  
  blockquote .footer{
    display: block;
    font-size: 80%;
  }

  .stars-container {
    margin-bottom: 5px;
  }
</style>
				</head>
				<body onload="getProductById(); getAllCategories(); getReviews()">
					<jsp:include page="navbar.jsp" />
						<!-- <nav class="navbar navbar-inverse">
							<div class="container-fluid">
								<ul class="nav navbar-nav" id="categories">
									<li class="active"><a href="#">All Categories</a></li>
								</ul>
							</div>
						</nav> -->
						<div class="container m-auto">
							<div class="m-4 mainWindow shadow bg-white-rounded p-1">

								<!-- Window 1-->
								<div class="d-flex flex-row flex-no-wrap row">
									<!-- Product Image Section-->
									<div class="flex-grow-1 m-2 col-sm-4 itemImage">
									</div>
									<!-- Product Image Section-->

									<!-- Product Desc Section-->
									<div class="flex-grow-1 m-2 p-1 col-sm-8">
										<div class="d-flex flex-column">
											<div class="desc p-1 d-flex justify-content-between">
												<h4 id="name"><h4>
														<h4 id="price"><h4>
															</div>
															<div class="seller-name p-1">
																<small id="address"></small>
															</div>
															<div class="item-desc" id="description">
															</div>
															<br>
															<br>
															<div class="sizes mt-1 pr-1">
																<!-- <button type="button" class="btn btn-xs mb-1 btn-warning"
																	onclick="opneFeedback()">Leave
																	a Feedback</button> -->
																<button type="button" class="btn btn-xs mb-1 btn-primary"
																	onclick="report()">Report Spam </button>
																<button type="button" class="btn btn-xs mb-1 btn-success"
																	onclick="openshare()">Share </button>
															</div>
															<br>
															<br>
															<div id="chat-button"></div>
															<!-- <div class="chatWithSeller">
																<button id="chatBtn" class="bg-color text-color">Seller</button><br>
																<button id="chatBtn">Chat With Seller</button>
															</div> -->
														</div>
													</div>
													<!-- Product Image Section-->
												</div>

											</div>
										</div>
										<div class="container">
											<form id="review-form" action="index.html" method="post">
												<h2>Write Your Review</h2>
												<div id="rating">
													<svg class="star" id="1" viewBox="0 12.705 512 486.59" x="0px"
														y="0px" xml:space="preserve" style="fill: #f39c12;">
														<polygon points="256.814,12.705 317.205,198.566 512.631,198.566
															354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295
															159.102,313.435 1,198.566 196.426,198.566"></polygon>
													</svg>
													<svg class="star" id="2" viewBox="0 12.705 512 486.59" x="0px"
														y="0px" xml:space="preserve" style="fill: #f39c12;">
														<polygon points="256.814,12.705 317.205,198.566 512.631,198.566
															354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295
															159.102,313.435 1,198.566 196.426,198.566"></polygon>
													</svg>
													<svg class="star" id="3" viewBox="0 12.705 512 486.59" x="0px"
														y="0px" xml:space="preserve" style="fill: #f39c12;">
														<polygon points="256.814,12.705 317.205,198.566 512.631,198.566
															354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295
															159.102,313.435 1,198.566 196.426,198.566"></polygon>
													</svg>
													<svg class="star" id="4" viewBox="0 12.705 512 486.59" x="0px"
														y="0px" xml:space="preserve" style="fill: #f39c12;">
														<polygon points="256.814,12.705 317.205,198.566 512.631,198.566
															354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295
															159.102,313.435 1,198.566 196.426,198.566"></polygon>
													</svg>
													<svg class="star" id="5" viewBox="0 12.705 512 486.59" x="0px"
														y="0px" xml:space="preserve" style="fill: #808080;">
														<polygon points="256.814,12.705 317.205,198.566 512.631,198.566
															354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295
															159.102,313.435 1,198.566 196.426,198.566"></polygon>
													</svg>
												</div>
												<div class="form-group">
													<label class="control-label" for="review">Your Review:</label>
													<textarea class="form-control" rows="5" placeholder="Your Reivew"
														name="review" id="review"></textarea>
													<span id="reviewInfo" class="help-block pull-right">
														<span id="remaining">99</span> Characters remaining
													</span>
												</div>
												<input id="submitForm" type="submit" class="btn btn-primary"
													value="Submit">
											</form>
											<h2>Reviews:</h2>
											<div id="review-container">
											</div>
										</div>
										<div id="feedbackModal" class="modal">
											<div class="modal-content">
												<span class="close" onclick="closeFeedback()">&times;</span>
												<!-- Place your forgot password design content here -->
												<h2>-: Feedback :-</h2>

												<form style="text-align: left;">
													<p>Enter feedback</p>
													<input id="name" class="reportInput form-control" type="text"
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
													<input id="name" class="reportInput form-control" type="text"
														placeholder="Enter report :" required>
													<button style="padding: 5px 10px;" type="button"
														onclick="addReportOnPost();">Report</button>
												</form>
											</div>
										</div>
										<div id="sharemodel" class="modal">
											<div class="modal-content">
												<span class="close" onclick="closeShare()">&times;</span>
												<h2>-: Refer to Friend :-</h2>
												<form style="text-align: left;">
													<p>Enter Email</p>
													<input id="shareinput" class="reportInput form-control"
														type="email"
														placeholder="Enter email :" required>
													<button style="padding: 5px 10px;" type="button"
														onclick="shareToFriend();">Share</button>
												</form>
											</div>
										</div>

										<script>
											function starsReducer(state, action) {
    switch (action.type) {
      case 'HOVER_STAR': {
        return {
          starsHover: action.value,
          starsSet: state.starsSet
        }
      }
      case 'CLICK_STAR': {
        return {
          starsHover: state.starsHover,
          starsSet: action.value
        }
      }
        break;
      default:
        return state
    }
  }

  var StarContainer = document.getElementById('rating');
  var StarComponents = StarContainer.children;

  var state = {
    starsHover: 0,
    starsSet: 4
  }

  function render(value) {
    for(var i = 0; i < StarComponents.length; i++) {
      StarComponents[i].style.fill = i < value ? '#f39c12' : '#808080'
    }
  }

  for (var i=0; i < StarComponents.length; i++) {
    StarComponents[i].addEventListener('mouseenter', function() {
      state = starsReducer(state, {
        type: 'HOVER_STAR',
        value: this.id
      })
      render(state.starsHover);
    })

    StarComponents[i].addEventListener('click', function() {
      state = starsReducer(state, {
        type: 'CLICK_STAR',
        value: this.id
      })
      render(state.starsHover);
    })
  }

  StarContainer.addEventListener('mouseleave', function() {
    render(state.starsSet);
  })

  var review = document.getElementById('review');
  var remaining = document.getElementById('remaining');
  review.addEventListener('input', function(e) {
    review.value = (e.target.value.slice(0,99));
    remaining.innerHTML = (99-e.target.value.length);
  })

  var form = document.getElementById("review-form")

  form.addEventListener('submit', function(e) {
    e.preventDefault();
    let request = {
      rating: state.starsSet,
      review: form['review'].value,
	  userId: Number(localStorage.getItem('uId')),
	  productId: Number(localStorage.getItem('pId'))
    }

	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/add/feedback",
		data: myJSON,
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['status'] == 'OK') {
				form.reset();
				getReviews();
				alert('Feedback sent successfully')
			} else {
				alert('something went Wrong !')
			}

		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
  })

  document.getElementById('submit').addEventListener('click', function(e) {
    e.preventDefault();
    document.getElementById('submitForm').click();
  })

  var reviews = {
    reviews: [
      {
        stars: 3,
        name: 'bob',
        city: 'Noosk',
        review: '1 Thompson Greenspon is so grateful to have worked with CPASiteSolutions on our'
      },{
        stars: 4,
        name: 'bobbo',
        city: 'WinNoosk',
        review: '2 Thompson Greenspon is so grateful to have worked with CPASiteSolutions on our'
      },{
        stars: 2,
        name: 'bobster',
        city: 'NooSKI',
        review: '3 Thompson Greenspon is so grateful to have worked with CPASiteSolutions on our'
      },
    ]
  }

  function ReviewStarContainer(stars) {
    var div = document.createElement('div');
    div.className = "stars-container";
    for (var i = 0; i < 5; i++) {
      var svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
      svg.setAttribute('viewBox',"0 12.705 512 486.59");
      svg.setAttribute('x',"0px");
      svg.setAttribute('y',"0px");
      svg.setAttribute('xml:space',"preserve");
      svg.setAttribute('class',"star");
      var svgNS = svg.namespaceURI;
      var star = document.createElementNS(svgNS,'polygon');
      star.setAttribute('points', '256.814,12.705 317.205,198.566 512.631,198.566 354.529,313.435 414.918,499.295 256.814,384.427 98.713,499.295 159.102,313.435 1,198.566 196.426,198.566');
      star.setAttribute('fill', i < stars ? '#f39c12' : '#808080');
      svg.appendChild(star);
      div.appendChild(svg);
    }
    return div;
  }

  function ReviewContentContainer(name, review) {

    var reviewee = document.createElement('div');
    reviewee.className = "reviewee footer";
    reviewee.innerHTML  = '- ' + name

    var comment = document.createElement('p');
    comment.innerHTML = review;

    var div = document.createElement('div');
    div.className = "review-content";
    div.appendChild(comment);
    div.appendChild(reviewee);

    return div;
  }

  function ReviewsContainer(review) {
    var div = document.createElement('blockquote');
    div.className = "review";
    div.appendChild(ReviewStarContainer(review.rating));
    div.appendChild(ReviewContentContainer(review.username,review.review));
    return div;
  }

  function getReviews() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/feedbacks/get/product/" + Number(localStorage.getItem('pId')),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data.data.length > 0) {
				var htmlString = "";
				var itemList = $('.accordion');
				itemList.empty();
				for (var item in data.data) {
					document.getElementById('review-container').appendChild(ReviewsContainer(data.data[item]))
				}

			}
		},
		error: function () {
		}
	});
}

$(document).ready(function () {
	if (localStorage.getItem('jsonToken') !== null) {
		$("#review-form").css('display', 'block');
	} else {
		$("#review-form").css('display', 'none');
	}
});

function setSellerId(sellerId){
	localStorage.setItem("seller",sellerId);
	window.location.assign("/chat");
}
										</script>
									</body>
								</html>