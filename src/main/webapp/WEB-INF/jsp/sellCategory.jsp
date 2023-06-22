<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sell</title>

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<script src="js/sellCategory.js"></script>

<style>
body {
	font-family: Verdana, 'Roboto', sans-serif, Monospace;
	background: #E6D16B;
	line-height: 1.5;
}

main {
	max-width: 80%;
	margin: 10px auto;
}

.center {
	display: flex;
	justify-content: center;
	align-items: center; //
	height: 200px;
	border: 3px solid green;
}

.container {
	max-width: 900px;
	margin: auto
}

.title {
	text-align: center;
	font-family: Arial;
	margin-top: 50px;
	margin-bottom: 50px
}

.accordion__item {
	margin-bottom: 10px
}

.accordion__item__header {
	background-color: #CBEAFE;
	padding: 15px;
	cursor: pointer;
	position: relative;
	color: #000;
	font-family: Arial;
	font-weight: 400;
	font-size: 20px
}

.accordion__item__header::before {
	height: 15px;
	width: 15px;
	content: "";
	position: absolute;
	right: 15px;
	top: 15px;
	transition: .5s all;
	transform: rotate(45deg);
	border-right: 2px solid #000;
	border-bottom: 2px solid #000
}

.accordion__item__header.active {
	background-color: #33a0ff;
	color: #fff;
	transition: .5s
}

.accordion__item__header.active::before {
	transform: rotate(-135deg);
	top: 23px;
	border-right: 2px solid #fff;
	border-bottom: 2px solid #fff
}

.accordion__item__content {
	overflow-y: auto;
	padding: 0;
	display: none
}

.testbtn {
	border: 1px solid #99cc44 !important;
	border-left: 5px solid #99cc44 !important;
	border-right: 5px solid #99cc44 !important;
	border-top: 5px solid #99cc44 !important;
	border-bottom: 5px solid #99cc44 !important;
	-webkit-border-radius: 25px;
	border-radius: 25px;
	margin-right: 10px;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.testbtn {
		width: 100%;
		height: auto;
		padding: 0 !important;
		margin: 1px !important;
		font-size: 18px;
	}
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
.button2 {background-color: #008CBA;
       color: white;
       margin-left: 200px;

}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
}

.productInput {
	padding: 3px 0px;
}
</style>
<script src="js/custom.js" type="text/javascript"></script>
</head>

<body onload="getAllcategoriesWithSubCategory();">

	<div class="w3-panel">
		<h1 class="title"
			style="vertical-align: middle; margin-top: 10px; margin-bottom: 10px;">POST
			YOUR AD</h1>
	</div>

	<!-- <div class="w3-border"> -->
	<div class="w3-bar w3-theme center"></div>
	<h3 class="title"
		style="vertical-align: middle; margin-top: 10px; margin-bottom: 10px;">CHOOSE
		A CATEGORY</h3>
	<br>
	<br>

	<div id="Category1" class="w3-container category w3-animate-opacity">
		<main>

			<div class="container">
				<div class="accordion">
				</div>
				<!-- id accordion end -->

			</div>
			<div id="opneProduct" class="modal">
				<div class="modal-content">
					<span class="close" onclick="closeProduct()">&times;</span>
					<!-- Place your forgot password design content here -->
					<h2>Add product</h2>
					<form id="addPostForm" style="text-align: left;">
					<div style="display: flex;">
					<div>
						<p>product name</p>
						<input class="productInput" type="text"
							placeholder="Enter product name" required>
						<p>price</p>
						<input class="productInput" type="text"
							placeholder="Enter price" required>
							</div>
							<div style="margin-left: 40px">
							<p>Address</p>
						<input class="productInput" type="text"
							placeholder="Enter Address" required><br>
						<p>description</p>
						<input class="productInput" type="text"
							placeholder="Enter description" required><br>
							</div>
							</div>
						<button class="button button2">Add</button>
					</form>
				</div>
			</div>
		</main>
	</div>
	<!-- Script for Tabs. No Need to Edit This. -->
	<script>
		function opneProduct(CatName,subCatId) {
			var modal = document.getElementById("opneProduct");
			modal.style.display = "block";
		}

		function closeProduct() {
			var modal = document.getElementById("opneProduct");
			modal.style.display = "none";
		}
	</script>


	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>



</body>
</html>