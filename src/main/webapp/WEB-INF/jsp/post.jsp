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
.addPost {
	padding: 10px 20px;
	border: 2px solid #002f33;
	background-color: #002f33;
	color: white;
	cursor: pointer;
	margin: 10px 10px;
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
	width: 15%;
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
	display: none;
	border: 1px solid gray;
	margin: 10px 10px;
	padding: 10px 10px;
}

table tr th {
	padding: 10px 20px;
}

.emptyAds {
	border: 1px solid gray;
	text-align: center;
	padding: 50px;
	margin: 20px 20px;
}

#emptyImg {
	width: 30%;
}
</style>
</head>
<body>
	<button onclick="addPost();">click for add</button>

	<div class="adsContainer" id="adsContainer">
		<div class="emptyAds" id="emptyAds">
			<img id="emptyImg" alt=""
				src="https://cdn.dribbble.com/users/8106/screenshots/15480894/media/1af3c28dc6bd8d62d351308e5a03133c.png?compress=1&resize=400x300&vertical=center">
			<p>You haven't listed anything yet</p>
			<button id="saveChanges" class="addPost" onclick="showCategories();">Start
				Selling</button>
		</div>
		<div class="myAdsList" id="myAds">
			<div class="myAds" id="ads1">
				<table>
					<tr>
						<th>Product Image</th>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Product Owner</th>
						<th>Product Price</th>
						<th>Created At</th>
						<th>Last Update</th>
						<th>Product Description</th>
						<th>Action Btn</th>

					</tr>
					<tr>
						<td class="productImage">
							<div>
								<img alt=""
									src="https://cars.tatamotors.com/images/dark/m-altroz-home.jpg">

							</div>
						</td>
						<td id="PId">1</td>
						<td id="PName">Audi</td>
						<td id="POwner">M.Ishaq</td>
						<td id="PPrice">500000</td>
						<td>Created At</td>
						<td>Last Update</td>
						<td id="PDescription">this is mostly used model in audi
							history</td>
						<td>
							<div class="actionBtn">
								<button class="btn"
									onclick="updateProduct('PId','PName','POwner','PPrice','PDescription');">Edit</button>
								<button class="btn">Delete</button>
							</div>
						</td>
					</tr>
					<tr>
						<td class="productImage">
							<div>
								<img alt=""
									src="https://cars.tatamotors.com/images/dark/m-altroz-home.jpg">

							</div>
						</td>
						<td id="PId2">Product Id</td>
						<td id="PName2">Product Name</td>
						<td id="POwner2">Product Owner</td>
						<td id="PPrice2">Product Price</td>
						<td>Created At</td>
						<td>Last Update</td>
						<td id="PDescription2">Product Description</td>
						<td>
							<div class="actionBtn">
								<button class="btn"
									onclick="updateProduct('PId2','PName2','POwner2','PPrice2','PDescription2');">Edit</button>
								<button class="btn">Delete</button>
							</div>
						</td>
					</tr>
					<tr>
						<td class="productImage">
							<div>
								<img alt=""
									src="https://cars.tatamotors.com/images/dark/m-altroz-home.jpg">

							</div>
						</td>

						<td id="PId3">Product Id</td>
						<td id="PName3">Product Name</td>
						<td id="pOwner3">Product Owner</td>
						<td id="PPrice3">Product Price</td>
						<td>Created At</td>
						<td>Last Update</td>
						<td id="PDescription3">Product Description</td>
						<td>
							<div class="actionBtn">
								<button class="btn"
									onclick="updateProduct('PId3','PName3','POwner3','PPrice3','PDescription3');">Edit</button>
								<button class="btn">Delete</button>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div>
		<div class="container" id="container">
			<div class="row">
				<div class="col m6 offset-m3">
					<div class="card">
						<div class="card-content">
							<h4 style="margin-top: 10px;" class="center-align">Product
								Update</h4>
							<h5 id="msg" class="center-align"></h5>
							<div class="form ">
								<form id="myform">
									<label>Product ID : </label> <input type="text" id="id"
										name="id" value="1" /> <label>Product Name : </label> <input
										type="text" id="productName" name="productName" value="Audi" />
									<label>Product Price : </label> <input type="text"
										id="productPrice" name="productPrice" value="5000000" /> <label>Product
										Owner : </label> <input type="text" id="productOwner"
										name="productOwner" value="M.Ishaq" /> <label>Product
										Description : </label>
									<textarea rows="" cols=" " id="productDescription"
										value="this is the most Used model in audi history"></textarea>
									<button type="submit" class="btn blue" onclick="postUpdate();">Save
										Updates</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function addPost() {
			var table = document.querySelector('table');

			var tableValue = new Array();
			tableValue.push(['https://cars.tatamotors.com/images/dark/m-altroz-home.jpg', 'Product Id', 'Product name', 'Product Owner',
					'Product Price', 'created At', 'last Upate..',
					'Decription', '12' ]);
			tableValue.push(['https://cars.tatamotors.com/images/dark/m-altroz-home.jpg', 'Product Id', 'Product name', 'Product Owner',
					'Product Price', 'created At', 'last Upate..',
					'Decription', '12' ]);

			for (var i = 0; i < tableValue.length; i++) {
				var tr = table.insertRow(-1);

				for (var j = 0; j < 8; j++) {
					var td = document.createElement('td');
					if (j === 0) {
						console.log('condition success..');
						td = tr.insertCell(-1);

						var div = document.createElement('div');
						var img = document.createElement('img');
						img.src = tableValue[i][j];
						div.appendChild(img);
						td.appendChild(div);

					}else {
						td = tr.insertCell(-1);
						td.innerHTML = tableValue[i][j];
					}
					tr.appendChild(td);

				}
				table.appendChild(tr);
			}
		}
	</script>
</body>
</html>