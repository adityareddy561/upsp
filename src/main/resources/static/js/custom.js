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
					var id = "'like" + data.data[item].id + "'"
					var sid = "'save" + data.data[item].id + "'"
					$('.itemList').append(
						'<li class="itemdescription">' +
						'<div class="aboutItem">' +
						'<div class="imageContainer" onclick="getProductDetailById(' + data.data[item].id + ');">' +
						'<img class="itemImage" alt="" src="https://cars.tatamotors.com/images/dark/m-altroz-home.jpg">' +
						'</div>' +
						'<div class="likeBtn">' +
						'<div id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">' +
						'<i class="fa fa-heart-o like" aria-hidden="true"></i>' +
						'</div>' +
						'<div id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">' +
						'<i class="fa fa-bookmark-o save" aria-hidden="true"></i>' +
						'</div>' +
						'<div id="btnForDelete" onclick="deletePost();">' +
						'<i class="fa fa-trash-o" style="font-size:15px"></i>' +
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
						'<div id="btnForDelete" onclick="deletePost();">' +
						'<i class="fa fa-trash-o" style="font-size:15px"></i>' +
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
			localStorage.removeItem('pId')
			localStorage.setItem('pId', JSON.stringify(data.data.id));
			window.location.assign('/postDetails');

		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
function getProductById() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/get/product/" + Number(localStorage.getItem('pId')),
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			$('.mainItemDetails').append('<p id="price">name:- ' + data.data.productName + '</p>'
				+ '<p id="KmDriven">price:- ₹' + data.data.price + '</p>'
				+ '<p id="condition">address:- ' + data.data.address + '</p>'
				+ '<p id="address">about:- ' + data.data.description + '</p>');

		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
function getAllcategoriesWithSubCategory() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/categories/subcategories",
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data.data.length > 0) {
				var htmlString = "";
				var itemList = $('.accordion');
				itemList.empty();
				for (var item in data.data) {
					console.log(data.data[item].category.id)
					var catname = data.data[item].category.categoryName;
					catname = "'" + catname + "'";
					htmlString += '	<div class="accordion__item">'
						+ '<div class="accordion__item__header">' + data.data[item].category.categoryName + '</div>' + '<div class="accordion__item__content">'

					for (var item1 in data.data[item].subCategories) {
						var subCatID = data.data[item].subCategories[item1].id;
						subCatID = "'" + subCatID + "'";
						console.log(data.data[item].subCategories[item1].subCategoryName)
						htmlString += '<h4  onclick="opneProduct(' + catname + ', ' + subCatID + ')" style="cursor: pointer; ">'
							+ data.data[item].subCategories[item1].subCategoryName + '</h4>'
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






function addReportOnPost() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var text = $('[placeholder="Enter report :"]').val();
	var request = {
		"query": text,
		"buyerId": Number(localStorage.getItem('uId')),
		"productId": Number(localStorage.getItem('pId'))
	};
	var myJSON = JSON.stringify(request);

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/add/report",
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				alert('Report added successfully')
			} else {
				alert('something went Wrong !')
			}

		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}
function addFeedbackOnPost() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var text = $('[placeholder="Enter feedback :"]').val();
	var request = {
		"query": text,
		"buyerId": Number(localStorage.getItem('uId')),
		"productId": Number(localStorage.getItem('pId'))
	};
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
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				alert('FeedBack added successfully')
			} else {
				alert('something went Wrong !')
			}

		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}
function likeAndDislike(pid) {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var request = {
		"buyerId": Number(localStorage.getItem('uId')),
		"productId": pid
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/add/like",
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				likePost('like' + pid)
			} else {
				alert('something went Wrong !')
			}

		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}
function saveAndUnsavePost(pid) {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var request = {
		"buyerId": Number(localStorage.getItem('uId')),
		"productId": pid
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/save/product",
		data: myJSON,
		dataType: 'json',
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				savePost('save' + pid)
			} else {
				alert('something went Wrong !')
			}

		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}
function deleteById(pid) {
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/delete/product/" + pid,
		data: myJSON,
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				alert('post delete  successfully')
			} else {
				alert('something went Wrong !')
			}

		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}

function likePost(id) {
	var dislike = '<i class="fa fa-heart-o like" aria-hidden="true"></i>'
	var like = '<i class="fa fa-heart like" aria-hidden="true"></i>'
	var post = document.getElementById(id);
	if (post.innerHTML === like) {
		post.innerHTML = dislike;
	} else {
		post.innerHTML = like;
	}


}
function savePost(id) {
	var unsave = '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>'
	var save = '<i class="fa fa-bookmark save" aria-hidden="true"></i>'
	var post = document.getElementById(id);
	if (post.innerHTML === unsave) {
		post.innerHTML = save;
	} else {
		post.innerHTML = unsave;
	}

}

function logout() {
	localStorage.clear();
	window.location.assign('login');
}

