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
	<body onload="getAllCategories();getAllPostsByLoginUserId();">
		<jsp:include page="navbar.jsp" />
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<ul class="nav navbar-nav" id="categories">
						<li class="active"><a href="#">All Categories</a></li>
					</ul>
				</div>
			</nav>
			<div class="text-center">
				<h1>My Advertisements</h1>
			</div>
			<div class="row itemList">
			</div>
		</body>
	</html>
