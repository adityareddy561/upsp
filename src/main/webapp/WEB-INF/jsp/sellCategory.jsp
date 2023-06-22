<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.navbar {
	background-color: rgb(239, 241, 243);
	margin: 5px;
	display: flex;
}

.container {
	text-align: center;
}

.backIcon {
	padding: 0px 10px;
}

.backIcon i {
	color: black;
	font-size: 25px;
	cursor: pointer;
}

.head {
	color: black;
}

.chooseCategory {
	margin: 20px 10px;
	text-align: left;
}

.chooseCategory span {
	font-size: 20px;
	padding: 5px 10px;
}

.categoryList {
	border: 1px solid #cfcdcd;
	width: 100%;
}

.categoryTable {
	border: 1px solid #cfcdcd;
	width: 100%
}

.mainCategories {
	width: 50%;
}

.categoryName {
	cursor: pointer;
}

.categoryName td {
	color: #849b9e;
}

.fa-chevron-right {
	float: right;
}

.categrories {
	display: flex;
}

.subCategoryList {
	width: 60%;
}

.subCategoryTable {
	border: 1px solid #cfcdcd;
}

.subCategoryTable tr {
	display: none;
	cursor: pointer;
}
</style>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar">
		<div class="backIcon" onclick="back();">
			<i class="fa fa-arrow-left" aria-hidden="true"></i>

		</div>
	</nav>

	<div>
		<div class="container">
			<h5 class="head">POST YOUR AD</h5>
			<div class="categoryList">
				<div class="chooseCategory">
					<span>CHOOSE A CATEGORY</span>
				</div>
				<div class="categrories">
					<div class="mainCategories">
						<table class="categoryTable highlight">
							<tr class="categoryName"
								onclick="showSubCategories('category1');">
								<td id="category1"><i class="fa fa-car" aria-hidden="true"></i>
									Cars <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category2');">
								<td id="category2"><i class="fa fa-car" aria-hidden="true"></i>
									Properties <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category3');">
								<td id="category3"><i class="fa fa-car" aria-hidden="true"></i>
									Mobiles <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category4');">
								<td id="category4"><i class="fa fa-car" aria-hidden="true"></i>
									Jobs <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category5');">
								<td id="category5"><i class="fa fa-car" aria-hidden="true"></i>
									Bikes <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category6');">
								<td id="category6"><i class="fa fa-car" aria-hidden="true"></i>
									Electronics & Appliances <i class="fa fa-chevron-right"
									aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category7');">
								<td id="category7"><i class="fa fa-car" aria-hidden="true"></i>
									Commercial Vahicles & Spares <i class="fa fa-chevron-right"
									aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category8');">
								<td id="category8"><i class="fa fa-car" aria-hidden="true"></i>
									Furniture <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category9');">
								<td id="category9"><i class="fa fa-car" aria-hidden="true"></i>
									Fashion <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr id="category10" class="categoryName"
								onclick="showSubCategories('category10');">
								<td><i class="fa fa-car" aria-hidden="true"></i> Books,
									Sports & Hobbies <i class="fa fa-chevron-right"
									aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category11');">
								<td id="category11"><i class="fa fa-car" aria-hidden="true"></i>
									Pets <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
							<tr class="categoryName"
								onclick="showSubCategories('category12');">
								<td id="category12"><i class="fa fa-car" aria-hidden="true"></i>
									Services <i class="fa fa-chevron-right" aria-hidden="true"></i></td>
							</tr>
						</table>
					</div>

					<div class="subCategoryList">
						<table class="subCategoryTable highlight">
							<tr class="carsSubCetagory"
								onclick="addItemDetails('category1','carsSubCategory1');">
								<td id="carsSubCategory1">Cars</td>
							</tr>
							<tr class="propertiesSubCategory"
								onclick="addItemDetails('category2','propertiesSubCategory1')">
								<td id="propertiesSubCategory1">For Sale : House and
									Apartments</td>
							</tr>
							<tr class="propertiesSubCategory"
								onclick="addItemDetails('category2','propertiesSubCategory2')">
								<td id="propertiesSubCategory2">For Rent : House &
									Apartments</td>
							</tr>
							<tr class="propertiesSubCategory"
								onclick="addItemDetails('category2','propertiesSubCategory3')">
								<td id="propertiesSubCategory3">Lands & Plots</td>
							</tr>
							<tr class="propertiesSubCategory"
								onclick="addItemDetails('category2','propertiesSubCategory4')">
								<td id="propertiesSubCategory4">For Rent : Shops & Offices</td>
							</tr>
							<tr class="propertiesSubCategory"
								onclick="addItemDetails('category2','propertiesSubCategory5')">
								<td id="propertiesSubCategory5">For Sale : Shops & Offices</td>
							</tr>
							<tr class="propertiesSubCategory"
								onclick="addItemDetails('category2','propertiesSubCategory6')">
								<td id="propertiesSubCategory6">PG & Guest House</td>
							</tr>
							<tr class="mobilesSubCategory"
								onclick="addItemDetails('category3','mobilesSubCategory1')">
								<td id="mobilesSubCategory1">Mobile Phones</td>
							</tr>
							<tr class="mobilesSubCategory"
								onclick="addItemDetails('category3','mobilesSubCategory2')">
								<td id="mobilesSubCategory2">Accessories</td>
							</tr>
							<tr class="mobilesSubCategory"
								onclick="addItemDetails('category3','mobilesSubCategory3')">
								<td id="mobilesSubCategory3">Tablets</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory1')">
								<td id="jobSubCategory1">Data entry & Back office</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory2')">
								<td id="jobSubCategory2">Sales & Marketing</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory3')">
								<td id="jobSubCategory3">BPO & Telecaller</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory4')">
								<td id="jobSubCategory4">Driver</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory5')">
								<td id="jobSubCategory5">Office Assistant</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory6')">
								<td id="jobSubCategory6">Delivery & Collection</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory7')">
								<td id="jobSubCategory7">Teacher</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory8')">
								<td id="jobSubCategory8">Cook</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory9')">
								<td id="jobSubCategory9">Receptionist & Front office</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory10')">
								<td id="jobSubCategory10">Operator & Technician</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory11')">
								<td id="jobSubCategory11">IT Engineer & Developer</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory12')">
								<td id="jobSubCategory12">Hotel & Travel Executive</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory13')">
								<td id="jobSubCategory13">Accountant</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory14')">
								<td id="jobSubCategory14">Designer</td>
							</tr>
							<tr class="jobSubCategory"
								onclick="addItemDetails('category4','jobSubCategory15')">
								<td id="jobSubCategory15">Other Jobs</td>
							</tr>
							<tr class="BikeSubCategory"
								onclick="addItemDetails('category5','bikeSubCategory1')">
								<td id="bikeSubCategory1">MoterCycles</td>
							</tr>

							<tr class="BikeSubCategory"
								onclick="addItemDetails('category5','bikeSubCategory2')">
								<td id="bikeSubCategory2">Scooters</td>
							</tr>
							<tr class="BikeSubCategory"
								onclick="addItemDetails('category5','bikeSubCategory3')">
								<td id="bikeSubCategory3">Spare Parts</td>
							</tr>
							<tr class="BikeSubCategory"
								onclick="addItemDetails('category5','bikeSubCategory4')">
								<td id="bikeSubCategory4">Bicycles</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory1')">
								<td id="electronicsSubCategory1">TVs, Video - Audio</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory2')">
								<td id="electronicsSubCategory2">Kitchen & Other Appliances</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory3')">
								<td id="electronicsSubCategory3">Computers & Laptops</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory4')">
								<td id="electronicsSubCategory4">Cameras & Lenses</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory5')">
								<td id="electronicsSubCategory5">Games & Entertainment</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory6')">
								<td id="electronicsSubCategory6">Fridges</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory7')">
								<td id="electronicsSubCategory7">Computer Accessories</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory8')">
								<td id="electronicsSubCategory8">Hard Disks, Printers &
									Monitors</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory9')">
								<td id="electronicsSubCategory9">ACs</td>
							</tr>
							<tr class="electronicsSubCategory"
								onclick="addItemDetails('category6','electronicsSubCategory10')">
								<td id="electronicsSubCategory10">Washing Machines</td>
							</tr>
							<tr class="commercialVahiclesSubCategory"
								onclick="addItemDetails('category7','commercialVahiclesSubCategory1')">
								<td id="commercialVahiclesSubCategory1">Commercial & Other
									Vehicles</td>
							</tr>
							<tr class="commercialVahiclesSubCategory"
								onclick="addItemDetails('category7','commercialVahiclesSubCategory2')">
								<td id="commercialVahiclesSubCategory2">Spare Parts</td>
							</tr>
							<tr class="furnitureSubCategory"
								onclick="addItemDetails('category7','furnitureSubCategory1')">
								<td id="furnitureSubCategory1">Sofa & Dining</td>
							</tr>
							<tr class="furnitureSubCategory"
								onclick="addItemDetails('category7','furnitureSubCategory2')">
								<td id="furnitureSubCategory1">Beds & Wardrobes</td>
							</tr>
							<tr class="furnitureSubCategory"
								onclick="addItemDetails('category7','furnitureSubCategory3')">
								<td id="furnitureSubCategory2">Home Decor & Garden</td>
							</tr>
							<tr class="furnitureSubCategory"
								onclick="addItemDetails('category7','furnitureSubCategory4')">
								<td id="furnitureSubCategory3">Kids Furniture</td>
							</tr>
							<tr class="furnitureSubCategory"
								onclick="addItemDetails('category7','furnitureSubCategory5')">
								<td id="furnitureSubCategory4">Other Household Items</td>
							</tr>
							<tr class="fashionSubCategory"
								onclick="addItemDetails('category8','fashionSubCategory1')">
								<td id="fashionSubCategory1">Men</td>
							</tr>
							<tr class="fashionSubCategory"
								onclick="addItemDetails('category8','fashionSubCategory2')">
								<td id="fashionSubCategory2">Women</td>
							</tr>
							<tr class="fashionSubCategory"
								onclick="addItemDetails('category8','fashionSubCategory3')">
								<td id="fashionSubCategory3">Kids</td>
							</tr>
							<tr class="booksSportsSubCategory"
								onclick="addItemDetails('category9','booksSportsSubCategory1')">
								<td id="booksSportsSubCategory1">Books</td>
							</tr>
							<tr class="booksSportsSubCategory"
								onclick="addItemDetails('category9','booksSportsSubCategory2')">
								<td id="booksSportsSubCategory2">Gym & Fitness</td>
							</tr>
							<tr class="booksSportsSubCategory"
								onclick="addItemDetails('category9','booksSportsSubCategory3')">
								<td id="booksSportsSubCategory3">Musical Instruments</td>
							</tr>
							<tr class="booksSportsSubCategory"
								onclick="addItemDetails('category9','booksSportsSubCategory4')">
								<td id="booksSportsSubCategory4">Sports Equipment</td>
							</tr>
							<tr class="booksSportsSubCategory"
								onclick="addItemDetails('category9','booksSportsSubCategory5')">
								<td id="booksSportsSubCategory5">Other Hobbies</td>
							</tr>
							<tr class="petsSubCategory"
								onclick="addItemDetails('category10','petsSubCategory1')">
								<td id="petsSubCategory1">Fishes & Aquarium</td>
							</tr>
							<tr class="petsSubCategory"
								onclick="addItemDetails('category10','petsSubCategory2')">
								<td id="petsSubCategory2">Pet Food & Accessories</td>
							</tr>
							<tr class="petsSubCategory"
								onclick="addItemDetails('category10','petsSubCategory3')">
								<td id="petsSubCategory3">Dogs</td>
							</tr>
							<tr class="petsSubCategory"
								onclick="addItemDetails('category10','petsSubCategory4')">
								<td id="petsSubCategory4">Other Pets</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory1')">
								<td id="serviceSubCategory1">Education & Classes</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory2')">
								<td id="serviceSubCategory2">Tours & Travel</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory3')">
								<td id="serviceSubCategory3">Electronics Repair & Services</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory4')">
								<td id="serviceSubCategory4">Health & Beauty</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory5')">
								<td id="serviceSubCategory5">Home Renovation & Repair</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory6')">
								<td id="serviceSubCategory6">Cleaning & Pest Control</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory7')">
								<td id="serviceSubCategory7">Legal & Documentation Services</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory8')">
								<td id="serviceSubCategory8">Packers & Movers</td>
							</tr>
							<tr class="serviceSubCategory"
								onclick="addItemDetails('category11','serviceSubCategory9')">
								<td id="serviceSubCategory9">Other Services</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function addItemDetails(mainId, id) {
			let ele = document.getElementById(id).innerHTML;

			var root = document.getElementById(mainId), iter = document
					.createNodeIterator(root, NodeFilter.SHOW_TEXT), textnode;

			while (textnode = iter.nextNode()) {

				console.log(textnode.textContent + '/' + ele.trim())

				var selectedCategory = textnode.textContent + '/' + ele.trim();
				window.location.replace("sellingCategory?mess="
						+ selectedCategory);

			}

			window.location.assign("post");

		}
	</script>
	<%
	String categ = request.getParameter("mess");
	if (categ != null) {
		session.setAttribute("category", categ);
	} else {
		session.setAttribute("category", "hello");

	}
	%>

</body>
</html>