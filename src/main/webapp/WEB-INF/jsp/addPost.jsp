<%@page import="java.text.NumberFormat"%>
	<%@page import="javax.swing.text.Document"%>
		<%@page import="javax.swing.plaf.metal.MetalBorders.Flush3DBorder"%>
			<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
				<!DOCTYPE html>
				<html>
					<head>
						<meta charset="UTF-8">
						<title>Post</title>
						<link rel="stylesheet"
							href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
						<script src="js/sellingCategory.js" type="text/javascript"></script>
						<script src="js/addPost.js" type="text/javascript"></script>
						<style type="text/css">
.navbar {
	background-color: rgb(239, 241, 243);
	margin: 5px;
	display: flex;
}

.backIcon {
	padding: 0px 10px;
}

.backIcon i {
	color: black;
	font-size: 25px;
	cursor: pointer;
}

.header {
	text-align: center;
	color: #002f33;
}

.postDetailContainer {
	border: 1px solid gray;
}

.postDetailContainer h6 {
	margin-left: 10px;
	color: #002f33;
}

#selectedCategory {
	color: #002f33;
	margin-left: 10px;
}

.add {
	border: 1px solid gray;
	border-radius: 3px;
	margin: 0px 10px;
}

.addDiscription {
	border: 1px solid gray;
	border-radius: 3px;
	margin: 0px 10px;
}

.inputHeader {
	margin-left: 10px;
	margin-bottom: -2px;
}

hr {
	border: 1px solid gray;
}

#title {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

#brand {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

#model {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

#year {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

.Btn {
	margin: 5px 7px;
	padding: 5px 5px;
	border: 1px solid gray;;
}

.price {
	width: 50%;
}

#price {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

.location {
	width: 50%;
}

#location {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

#driven {
	border: none;
	outline: none;
	box-shadow: none;
	padding: 0px 5px;
}

#discription {
	border: none;
	outline: none;
	box-shadow: none;
	margin-top: 10px;
	padding: 5px 10px
}

.details {
	padding: 5px 10px;
	display: flex;
	justify-content: space-between;
	width: 100%;
	display: flex;
}

.mainInfo {
	width: 45%;
}

.moreInfo {
	width: 45%;
}

.priceLocation {
	margin: 5px 5px;
}

.postBtn {
	width: 40%;
	padding: 10px 10px;
	margin: 10px 10px;
	background: none;
	border: none;
	background-color: #002f33;
	color: white;
}

.addimg {
	width: 40%;
	padding: 10px 10px;
	margin: 10px 10px;
	background: none;
	border: none;
	background-color: #002f33;
	color: white;
}

.DataBtn {
	margin-left: 4px;
}

.peropertiesSection {
	display: none;
}
.jobSection
{
display: none;}
.serviceSection{
display: none;}
.propertiesSection p {
	margin-left: 5px;
	background-color: gray;
}
.mobileSection{
display: none;}

.bikeSection
{
display: none;}
.postImgContainer {
 display : flex;
	margin: 10px 10px;
	padding: 10px 10px;
	display: flex;
}

.postImages {
	width: 25%;
	border: 1px solid gray;
	padding: 10px 10px;
}

.postImages input {
	border: none;
	outline: none;
	box-shadow: none;
}
</style>
					</head>
					<body>
						<nav class="navbar">
							<div class="backIcon" id="back" onclick="back('back');">
								<i class="fa fa-arrow-left" aria-hidden="true"></i>

							</div>
						</nav>

						<div class="container">
							<h3 class="header">POST YOUR AD</h3>
							<div class="postDetailContainer">
								<h6>SELECTED CATEGORY</h6>
								<%
									String categry= session.getAttribute(" category").toString();
									out.println("<span id='selectedCategory'>" + categry + "</span>");
								if (categry.equalsIgnoreCase("cars/cars")) {

								}
								%>
								<hr>
								<p class="header">INCLUDE SOME DETAILS</p>
								<div class="details">
									<div class="mainInfo">
										<p class="inputHeader">Add Title*</p>
										<div class="add year">
											<div class="title">
												<input id="title" class="detailsInput" placeholder="Add Title"
													required="required" />
											</div>

										</div>

										<p class="inputHeader">Brand*</p>
										<div class="add Brand">
											<div class="brand">
												<input id="brand" class="detailsInput" placeholder="Add Brand"
													required="required" />
											</div>

										</div>
										<div class="cars&BikesSection">
											<p class="inputHeader">Model*</p>
											<div class="add Brand">
												<div class="model">
													<input id="model" class="detailsInput" placeholder="Add Model"
														required="required" />
												</div>
											</div>
											<p class="inputHeader">Project Name.</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Enter Project Name" required="required" />
												</div>

											</div>

										</div>
										<p class="inputHeader">Description*</p>

										<div class="addDiscription">
											<div class="discription">
												<textarea id="discription" class="detailsInput"
													placeholder="Add Description"></textarea>
											</div>

										</div>
										<p class="inputHeader">Year*</p>
										<div class="add year">
											<div class="year">
												<input id="year" class="detailsInput" placeholder="Add Year"
													required="required" />
											</div>

										</div>
										<div class="peropertiesSection">
											<p class="inputHeader">Super Builtup area (ft²) *</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Super Buitup Area" required="required" />
												</div>

											</div>
											<p class="inputHeader">Carpet Area(ft²) *</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Carpet Area" required="required" />
												</div>

											</div>
											<p class="inputHeader">Maintenance</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Maintenance" required="required" />
												</div>

											</div>
											<p class="inputHeader">Total Floors</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Total Floors" required="required" />
												</div>

											</div>
											<p class="inputHeader">Floor No.</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Enter Floor No.." required="required" />
												</div>

											</div>

										</div>
										<div class="jobSection">
											<p class="inputHeader">Salary From</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Total Floors" required="required" />
												</div>

											</div>
											<p class="inputHeader">Salary To</p>
											<div class="add Driven">
												<div class="driven">
													<input id="driven" class="detailsInput"
														placeholder="Enter Floor No.." required="required" />
												</div>

											</div>

										</div>


									</div>
									<div class="moreInfo">
										<div>
											<div class="cars&BikesSection">
												<p class="inputHeader">Fuel*</p>
												<div class="DataBtn">
													<button class="fuel Btn">CNG & Hybrids</button>
													<button class="fuel Btn">Diesel</button>
													<button class="fuel Btn">Electric</button>
													<button class="fuel Btn">LPG</button>
													<button class="fuel Btn">Petrol</button>
												</div>
												<p class="inputHeader">TransMission*</p>
												<div class="DataBtn">
													<button class="Transmission Btn">Automatic</button>
													<button class="Transmission Btn">Manual</button>
												</div>
												<p class="inputHeader">KM Driven*</p>

												<div class="add Driven">
													<div class="driven">
														<input id="driven" class="detailsInput"
															placeholder="Enter KM Driven" required="required" />
													</div>

												</div>


												<p class="inputHeader">No. Of Owners*</p>
												<div class="DataBtn">
													<button class="owner Btn">1st</button>
													<button class="owner Btn">2nd</button>
													<button class="owner Btn">3rd</button>
													<button class="owner Btn">4th</button>
													<button class="owner Btn">4+</button>
												</div>
											</div>
											<div class="peropertiesSection">
												<p class="inputHeader">Type*</p>
												<div class="DataBtn">
													<button class="type Btn">Apartments</button>
													<button class="type Btn">Builder Floors</button>
													<button class="type Btn">Farm Houses</button>
													<button class="type Btn">Housee & Villas</button>
												</div>
												<p class="inputHeader">Bedrooms*</p>
												<div class="DataBtn">
													<button class="bedrooms Btn">1</button>
													<button class="bedrooms Btn">2</button>
													<button class="bedrooms Btn">3</button>
													<button class="bedrooms Btn">4</button>
													<button class="bedrooms Btn">4+</button>
												</div>
												<p class="inputHeader">Bathrooms*</p>
												<div class="DataBtn">
													<button class="bathrooms Btn">1</button>
													<button class="bathrooms Btn">2</button>
													<button class="bathrooms Btn">3</button>
													<button class="bathrooms Btn">4</button>
													<button class="bathrooms Btn">4+</button>
												</div>
												<p class="inputHeader">Furnishing*</p>
												<div class="DataBtn">
													<button class="furnishing Btn">Furnished</button>
													<button class="furnishing Btn">Semi-Furnished</button>
													<button class="furnishing Btn">UnFurnished</button>
												</div>
												<p class="inputHeader">Construction Status*</p>
												<div class="DataBtn">
													<button class="construction Btn">New Launch</button>
													<button class="construction Btn">Ready to move</button>
													<button class="construction Btn">Under Construction</button>
												</div>
												<p class="inputHeader">Listed by*</p>
												<div class="DataBtn">
													<button class="Listed Btn">Builder</button>
													<button class="Listed Btn">Dealer</button>
													<button class="Listed Btn">Owner</button>
												</div>
												<p class="inputHeader">Car Parking*</p>
												<div class="DataBtn">
													<button class="Parking Btn">0</button>
													<button class="Parking Btn">1</button>
													<button class="Parking Btn">2</button>
													<button class="Parking Btn">3</button>
													<button class="Parking Btn">3+</button>
												</div>
												<p class="inputHeader">Facing*</p>
												<div class="add Facing">
													<div class="brand">
														<input id="brand" class="detailsInput" list="facing"
															name="myFacing" placeholder="Add Facing" required="required" />
														<datalist id="facing">
															<option value="East">
																<option value="North">
																	<option value="North-East">
																		<option value="North-West">
																			<option value="South">
																				<option value="South-East">
																					<option value="South-West">
																						<option value="West">
																						</datalist>
																					</div>
																				</div>
																			</div>
																			<div class="mobileSection">
																				<div id="forTablets">
																					<p class="inputHeader">Type</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">iPad</button>
																						<button class="Parking Btn">Samsung</button>
																						<button class="Parking Btn">Other Tablets</button>
																					</div>
																				</div>
																				<div id="forAccessories">
																					<p class="inputHeader">Type</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">Mobile</button>
																						<button class="Parking Btn">Tablets</button>
																					</div>
																				</div>
																			</div>
																			<div class="jobSection">
																				<p class="inputHeader">Salary Period*</p>
																				<div class="DataBtn">
																					<button class="Parking Btn">Hourly</button>
																					<button class="Parking Btn">Weekly</button>
																					<button class="Parking Btn">Monthly</button>
																					<button class="Parking Btn">yearly</button>
																				</div>
																				<p class="inputHeader">Position*</p>
																				<div class="DataBtn">
																					<button class="Parking Btn">Contract</button>
																					<button class="Parking Btn">Full-time</button>
																					<button class="Parking Btn">Half-time</button>
																					<button class="Parking Btn">Temporary</button>
																				</div>


																			</div>
																			<div class="bikeSection">
																				<div id="forBicycles">
																					<p class="inputHeader">Brand*</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">Hercules</button>
																						<button class="Parking Btn">Hero</button>
																						<button class="Parking Btn">Other Brands</button>
																					</div>


																				</div>
																			</div>
																			<div class="commercialVahiclesSection">
																				<div id="forSpareParts">
																					<p class="inputHeader">Type*</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">Wheels & Tyres</button>
																						<button class="Parking Btn">Audio & Other Accessories</button>
																						<button class="Parking Btn">Other Spare Parts</button>
																					</div>

																				</div>
																			</div>
																			<div class="serviceSection">
																				<div id="forEducation">
																					<p class="inputHeader">Type*</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">Tution</button>
																						<button class="Parking Btn">Hobby Classes</button>
																						<button class="Parking Btn">Skill Development</button>
																						<button class="Parking Btn">Others</button>
																					</div>
																				</div>
																				<div id="forHealthBeauty">
																					<p class="inputHeader">Type*</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">Fitness & Wellness</button>
																						<button class="Parking Btn">Salons Services</button>
																						<button class="Parking Btn">Health & Safety</button>
																						<button class="Parking Btn">Others</button>
																					</div>
																				</div>
																				<div id="forCleaningPestControl">
																					<p class="inputHeader">Type*</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">Home Cleaning</button>
																						<button class="Parking Btn">Pest Control</button>
																						<button class="Parking Btn">Car Cleaning</button>
																						<button class="Parking Btn">Others</button>
																					</div>
																				</div>
																				<div id="forDocumentionService">
																					<p class="inputHeader">Type*</p>
																					<div class="DataBtn">
																						<button class="Parking Btn">RTO Related</button>
																						<button class="Parking Btn">KYC Related</button>
																						<button class="Parking Btn">Notary Serivces</button>
																						<button class="Parking Btn">Others</button>
																					</div>
																				</div>

																			</div>
																		</div>
																	</div>
																</div>
																<hr>
																<div class="priceLocation">
																	<p class="inputHeader">Price*</p>
																	<div class="add price">
																		<div class="price">
																			<input id="price" class="detailsInput" placeholder="Add
																				Price" />
																		</div>

																	</div>
																	<hr>
																	<p style="font-size: 20px;">CONFIRM YOUR LOCATION</p>
																	<p class="inputHeader">State*</p>
																	<div class="add location">
																		<div class="location">
																			<input id="location" class="detailsInput"
																				placeholder="Add Location" />
																		</div>

																	</div>
																	<hr>
																	<p class="inputHeader">Upload Up to 8 Photos</p>
																	<div class="postImgContainer">
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg0" alt="" src="">
																		</div>
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg1" alt="" src="">

																		</div>
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg2" alt="" src="">

																		</div>
																	</div>
																	<div class="postImgContainer">
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg3" alt="" src="">

																		</div>
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg4" alt="" src="">

																		</div>
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg5" alt="" src="">

																		</div>
																		<div class="postImages">
																			<input type="file" name="postImage" class="imgInput"
																				value="">
																			<img id="postImg6" alt="" src="">

																		</div>
																	</div>
																	<button class="addimg" type="button"
																		onclick="showPostImages('imgInput');">Add Images</button>
																	<hr>

																	<button type="button" class="postBtn" onclick="postAdd();">Post
																		Now</button>
																</div>


															</div>
														</div>
													</body>
												</html>