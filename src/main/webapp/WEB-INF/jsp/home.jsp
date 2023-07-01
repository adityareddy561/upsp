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
		<style>
			.card {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
    margin: auto;
    text-align: center;
    font-family: arial;
	margin-top: 10px;
  }

  .card img{
	width: 70%;
	height: 200px;
  }
  
  .price {
    color: grey;
    font-size: 22px;
  }
  
  .card button {
    border: none;
    outline: 0;
    padding: 12px;
    color: white;
    background-color: #000;
    text-align: center;
    cursor: pointer;
    width: 100%;
    font-size: 18px;
  }
  
  .card button:hover {
    opacity: 0.7;
  }
		</style>
	</head>
	<body onload="getAllCategories();getPosts();">
		<jsp:include page="navbar.jsp" />
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<ul class="nav navbar-nav" id="categories">
						<li class="active"><a onclick="searchByCategory('all')">All Categories</a></li>
					</ul>
				</div>
			</nav>
			<div class="text-center">
				<h1>Advertisements</h1>
			</div>
			<div class="row itemList">
			</div>
			<div id="feedback" class="feedback"></div>
		</body>
	</html>
