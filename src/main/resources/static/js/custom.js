/** Get All category */
function getAllCategories() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/category",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			console.log(data.data)
			if (data.data.length > 0) {
				for (var item in data.data) {
					$('#categories')
						.append(
							'<li><a>' + data.data[item].categoryName + '</a></li>'
						);
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Task Available";
			}
		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Task Available";
		}
	});
}

/** Get All post */
function getAllPosts() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/product",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			console.log(data.data)
			if (data.data.length > 0) {
				for (var item in data.data) {
					$('.itemList').append(
						'<li class="itemdescription">' +
						'<div class="aboutItem">' +
						'<div class="imageContainer" onclick="getProductDetailById(' + data.data[item].id + ');">' +
						'<img class="itemImage" alt="" src="https://cars.tatamotors.com/images/dark/m-altroz-home.jpg">' +
						'</div>' +
						'<div class="likeBtn">' +
						'<div id="btnForLike" onclick="likePost();">' +
						'<i class="fa fa-heart-o like" aria-hidden="true"></i>' +
						'</div>' +
						'<div id="btnForSave" onclick="savePost();">' +
						'<i class="fa fa-bookmark-o save" aria-hidden="true"></i>' +
						'</div>' +
						'</div>' +
						'<div class="desc">' +
						'<h6 class="price"> ₹ ' + data.data[item].price + '</h6>' +
						'<h6 class="price">    ' + data.data[item].productName + '</h6>' +
						'</div>' +
						'</li>');
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}

function searchByQuery() {
	var query = $('#searchItem').val();
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/productByQuery/" + query,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			console.log(data.data)
			if (data.data.length > 0) {
				var itemList = $('.itemList');
				itemList.empty();
				for (var item in data.data) {
					itemList.append(
						'<li class="itemdescription">' +
						'<div class="aboutItem">' +
						'<div class="imageContainer" onclick="getProductDetailById(' + data.data[item].id + ');">' +
						'<img class="itemImage" alt="" src="https://cars.tatamotors.com/images/dark/m-altroz-home.jpg">' +
						'</div>' +
						'<div class="likeBtn">' +
						'<div id="btnForLike" onclick="likePost();">' +
						'<i class="fa fa-heart-o like" aria-hidden="true"></i>' +
						'</div>' +
						'<div id="btnForSave" onclick="savePost();">' +
						'<i class="fa fa-bookmark-o save" aria-hidden="true"></i>' +
						'</div>' +
						'</div>' +
						'<div class="desc">' +
						'<h6 class="price"> ₹ ' + data.data[item].price + '</h6>' +
						'<h6 class="price">    ' + data.data[item].productName + '</h6>' +
						'</div>' +
						'</li>');
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}

function getProductDetailById(id) {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/get/product/" + id,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			alert('yeee')
			console.log(data.data)
			console.log(data.data.length)
			window.location.assign('/postDetails');
				$('.mainItemDetails').append(
					'< p id = "price" >₹ ' + data.data.price + '</p >'
					+ '<p id="KmDriven">' + data.data.productName + '</p>'
					+ '<p id="condition">' + data.data.address + '</p>'
					+ '<p id="address">' + data.data.description + '</p>'
				);
		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
