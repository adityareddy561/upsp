
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
		<script src="js/sellingCategory.js"></script>
		<script src="js/custom.js"></script>
		<link rel="stylesheet" href="css/style.css">
		<style>
			body {
				font-family: Verdana, 'Roboto', sans-serif, Monospace;
				line-height: 1.5;
			}
			
			main {
				max-width: 80%;
				margin: 10px auto;
			}
			
			.center {
				display: flex;
				justify-content: center;
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
				background-color: #000000;
				padding: 15px;
				cursor: pointer;
				position: relative;
				color: rgb(255, 255, 255);
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
				background-color: #000000;
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
			
			.button2 {
				background-color: #008CBA;
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
			
			.button-21 {
				align-items: center;
				appearance: none;
				background-color: #3EB2FD;
				background-image: linear-gradient(1deg, #4F58FD, #149BF3 99%);
				background-size: calc(100% + 20px) calc(100% + 20px);
				border-radius: 100px;
				border-width: 0;
				box-shadow: none;
				box-sizing: border-box;
				color: #FFFFFF;
				cursor: pointer;
				display: inline-flex;
				font-family: CircularStd, sans-serif;
				font-size: 1rem;
				height: auto;
				justify-content: center;
				line-height: 1.5;
				padding: 6px 20px;
				position: relative;
				text-align: center;
				text-decoration: none;
				transition: background-color .2s, background-position .2s;
				user-select: none;
				-webkit-user-select: none;
				touch-action: manipulation;
				vertical-align: top;
				white-space: nowrap;
				margin-left: 190px;
				margin-top: 50px;
			}
			
			.button-21:active, .button-21:focus {
				outline: none;
			}
			
			.button-21:hover {
				background-position: -20px -20px;
			}
			
			.button-21:focus:not(:active) {
				box-shadow: rgba(40, 170, 255, 0.25) 0 0 0 .125em;
			}
			</style>
	</head>
	<body onload="getAllcategoriesWithSubCategory();">
		<jsp:include page="navbar.jsp" />

			<div class="text-center">
				<h1>Post Your AD</h1>
			</div>
			<hr>
			<h3 class="title"
				style="vertical-align: middle; margin-top: 10px; margin-bottom: 10px;">CHOOSE
				A CATEGORY</h3>
			<br>
			<br>
			<div id="Category1" class="w3-container category w3-animate-opacity">
				<main>

					<div class="container">
						<div class="accordion"></div>
						<!-- id accordion end -->

					</div>
					<div id="opneProduct" class="modal">
						<div class="modal-content">
							<span class="close" onclick="closeProduct()">&times;</span>
							<!-- Place your forgot password design content here -->
							<h2>Add product</h2>
							<form id="addPostForm" style="text-align: left;"
								enctype="multipart/form-data">
								<div class="row">
									<div class="col-sm-6">
										<p>Product Name</p>
										<input class="productInput form-control" type="text"
											placeholder="Enter product name" required>
									</div>
									<div class="col-sm-6">
										<p>Price</p>
										<input class="productInpu form-control" type="text"
											placeholder="Enter price" required>
									</div>
									<br>
									<div class="col-sm-6">
										<p>Address</p>
										<input id="searchTextField" class="productInput form-control"
											type="text"
											placeholder="Enter a location" autocomplete="on" runat="server" /><br>
									</div>
									<div class="col-sm-6">
										<p>Description</p>
										<input class="productInput form-control" type="text"
											placeholder="Enter description" required><br>
									</div>
									<div style="margin-left: 40px">
										<p>Image</p>
										<input id="productImg" class="productInput" type="file" />
									</div>
								</div>
								<div class="text-center">
									<button id="addItem" type="button" class="btn btn-primary"
										role="button">Add Product
									</button>
								</div>
							</form>
						</div>
					</div>
				</main>
			</div>

			<script
				src="https://cdn.jsdelivr.net/npm/uuid@8.3.2/dist/umd/uuid.min.js"></script>
			<script>
		let catName1 = "";
		let subCatId1 = "";
		function opneProduct(CatName, subCatId) {
			catName1 = CatName;
			subCatId1 = subCatId;
			console.log(catName1 + "=" + subCatId1);
			var addItemButton = document.getElementById("addItem");
			//addItemButton.setAttribute("onclick", "addItem()");
			var modal = document.getElementById("opneProduct");
			modal.style.display = "block";
		}

		function closeProduct() {
			var modal = document.getElementById("opneProduct");
			modal.style.display = "none";
		}
		$('#addItem').click(function(event) {
			addItem();
		});
		function addItem() {
			var token = generateToken();
			var name = $('[placeholder="Enter product name"]').val();
			var price = $('[placeholder="Enter price"]').val();
			var Address = $('[placeholder="Enter a location"]').val();
			var description = $('[placeholder="Enter description"]').val();
			var fileInput = $('#productImg')[0];
			var image = fileInput.files[0];
			var formData = new FormData();
			formData.append('file', image);
			$.ajax({
				type : "POST",
				url : "/api/file/uploadFile?fileName=" + token,
				data : formData,
				headers : {
					"Authorization" : "Bearer "
							+ localStorage.getItem('jsonToken')
				},
				processData : false,
				contentType : false,
				cache : false,
				timeout : 600000,
				success : function(data) {
					var request = {
						"categoryName" : catName1,
						"productName" : name,
						"price" : price,
						"description" : description,
						"sellerId" : localStorage.getItem('uId'),
						"address" : Address,
						"subCategoryId" : subCatId1,
						"image" : data['data']
					};
					var myJSON2 = JSON.stringify(request);
					$.ajax({
						type : "POST",
						contentType : "application/json",
						url : "/api/add/product",
						data : myJSON2,
						dataType : 'json',
						headers : {
							"Authorization" : "Bearer "
									+ localStorage.getItem('jsonToken')
						},
						cache : false,
						timeout : 600000,
						success : function(data) {
						$('[placeholder="Enter product name"]').val('');
			$('[placeholder="Enter price"]').val('');
			$('[placeholder="Enter a location"]').val('');
			$('[placeholder="Enter description"]').val('');
							closeProduct();
							alert(" Post Added Successfully")
						},
						error : function(e) {
							alert("Internal Server Error");
						}
					});
				},
				error : function(e) {
					alert("Internal Server Error");
				}
			});
		}

		function generateToken() {
			var chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
			var token = '';
			for (var i = 0; i < 32; i++) {
				var randomIndex = Math.floor(Math.random() * chars.length);
				token += chars[randomIndex];
			}
			return token;
		}
	</script>
		</body>
	</html>
