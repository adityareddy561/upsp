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
			alert('ok')
			sessionStorage.setItem('productData', JSON.stringify(data.data));
			window.location.assign('/postDetails');

		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
function getAllcategoriesWithSubCategory() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/categories/subcategories",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data.data.length > 0) {
				var htmlString = "";
				var itemList = $('.accordion');
				itemList.empty();
				for (var item in data.data) {
					console.log(data.data[item].category.id)
					console.log(data.data[item].category.categoryName)
					htmlString += '	<div class="accordion__item">'
						+ '<div class="accordion__item__header">' + data.data[item].category.categoryName + '</div>' + '<div class="accordion__item__content">'

					for (var item1 in data.data[item].subCategories) {
						console.log(data.data[item].subCategories[item1].id)
						console.log(data.data[item].subCategories[item1].subCategoryName)
						htmlString += '<h4  onclick="opneProduct()" style="cursor: pointer;">' + data.data[item].subCategories[item1].subCategoryName + '</h4>'
					}
					htmlString += '</div></div>'
					itemList.html(htmlString);
				}
				$('body').append('	<script>'
					+ 'if ($(".accordion__item__header").length > 0) {'
					+ 'var active = "active";'
					+ '$(".accordion__item__header").click(function() {'
					+ '$(this).toggleClass(active);'
					+ '$(this).next("div").slideToggle(200);});}</script>')

			} else {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}


		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
