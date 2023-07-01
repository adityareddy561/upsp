/** Get All category */
function getAllCategories() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/category",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data.data.length > 0) {
				for (var item in data.data) {
					$('#categories')
						.append(
							'<li><a onclick=searchByCategory("' + data.data[item].categoryName + '")>' + data.data[item].categoryName + '</a></li>'
						);
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Task Available";
			}
		},
		error: function () {
			document.getElementById('feedback').innerHTML = "No Task Available";
		}
	});
}

function getPosts() {
	if (localStorage.getItem('adminRole') === null || localStorage.getItem('adminRole') === 2 || localStorage.getItem('adminRole') === '2') {
		getAllPosts();
	} else if (localStorage.getItem('adminRole') === 1 || localStorage.getItem('adminRole') === "1") {
		getAllPostsWithLikeAndSaveStatus();
	}
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
		success: function (data) {
			$('.itemList').html('');
			if (data.data.length > 0) {
				for (var item in data.data) {
					var itemlist = $('.itemList');
					var htmlString = "";
					htmlString += '<div class="col-sm-2">';
					htmlString += '<div class="card">';
					htmlString += '<a onClick="getProductDetailById(' + data.data[item].id + ');"><img src="http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data[item].image) + '" alt="Denim Jeans"></a>';
					htmlString += '<h3>' + data.data[item].productName + '</h3>';
					if (data.data[item].discountPrice != 0) {
						htmlString += '<p class="price original-price">$' + data.data[item].price + '</p>';
						htmlString += '<p class="price discounted-price">' + data.data[item].discountPrice + '</p>';
					} else {
						htmlString += '<p class="price discounted-price">$' + data.data[item].price + '</p>';
					}
					htmlString += '<div class="likeBtn row">';
					htmlString += '<div class="col-sm-6" id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-heart-o like" aria-hidden="true"></i>';
					htmlString += '</div>';
					htmlString += '<div class="col-sm-5 text-right" id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>';
					htmlString += '</div>';
					htmlString += '</div>';
					htmlString += '</div>';
					htmlString += '</div>';
					itemlist.append(htmlString);

				}
			} else {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		},
		error: function () {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}

function searchByQuery() {
	var query = $('#searchItem').val();
	if (query !== "") {
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "/api/getAll/productByQuery/" + query,
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				var itemlist = $('.itemList');
				itemlist.empty();
				if (data.data.length > 0) {
					for (var item in data.data) {
						var htmlString = "";
						htmlString += '<div class="col-sm-2">';
						htmlString += '<div class="card">';
						htmlString += '<a onClick="getProductDetailById(' + data.data[item].id + ');"><img src="http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data[item].image) + '" alt="Denim Jeans"></a>';
						htmlString += '<h3>' + data.data[item].productName + '</h3>';
						if (data.data[item].discountPrice != 0) {
							htmlString += '<p class="price original-price">$' + data.data[item].price + '</p>';
							htmlString += '<p class="price discounted-price">' + data.data[item].discountPrice + '</p>';
						} else {
							htmlString += '<p class="price discounted-price">$' + data.data[item].price + '</p>';
						}
						htmlString += '<div class="likeBtn row">';
						htmlString += '<div class="col-sm-6" id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">';
						htmlString += '<i class="fa fa-heart-o like" aria-hidden="true"></i>';
						htmlString += '</div>';
						htmlString += '<div class="col-sm-5 text-right" id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">';
						htmlString += '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>';
						htmlString += '</div>';
						htmlString += '</div>';
						htmlString += '</div>';
						htmlString += '</div>';
						itemlist.append(htmlString);

					}
				} else {
					document.getElementById('feedback').innerHTML = "No Products Available";
				}
			},
			error: function () {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		});
	} else {
		getAllPosts();
	}
}

function getProductDetailById(id) {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/get/product/" + id,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			localStorage.removeItem('pId')
			localStorage.setItem('pId', JSON.stringify(data.data.id));
			window.location.assign('/postDetails');

		},
		error: function () {
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
		success: function (data) {
			$('.itemImage').append('<img class="product-img p-2"'
				+ 'src="' + 'http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data.image) + '">');
			$('#name').html(data.data.productName);
			$('#price').html("$" + data.data.price);
			$('#address').html(data.data.address);
			$('#description').html(data.data.description);
			$("#chat-button").html('<a class="btn btn-xs mb-1 btn-warning" onclick="setSellerId(' + data.data.sellerId + ')">Chat With Seller</a>');
		},
		error: function () {
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
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data.data.length > 0) {
				var htmlString = "";
				var itemList = $('.accordion');
				itemList.empty();
				for (var item in data.data) {
					var catname = data.data[item].category.categoryName;
					catname = "'" + catname + "'";
					htmlString += '	<div class="accordion__item">'
						+ '<div class="accordion__item__header">' + data.data[item].category.categoryName + '</div>' + '<div class="accordion__item__content">'

					for (var item1 in data.data[item].subCategories) {
						var subCatID = data.data[item].subCategories[item1].id;
						subCatID = "'" + subCatID + "'";
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
		error: function () {
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
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				closeReport();
				alert('Report added successfully')
			} else {
				alert('something went Wrong !')
			}

		},
		error: function (e) {
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
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				closeFeedback();
				alert('FeedBack added successfully')
			} else {
				alert('something went Wrong !')
			}

		},
		error: function (e) {
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
		success: function (data) {
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
		error: function (e) {
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
		success: function (data) {
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
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}
function deleteById(pid) {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	if (confirm("Are you sure you want to delete?")) {
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			url: "/api/delete/product/" + pid,
			headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				if (data['statusCode'] == 401) {
					window.location.assign('login');
					return
				}
				if (data['message'] == 'success') {
					getAllPostsByLoginUserId();
					alert('post delete  successfully')
				} else {
					alert('something went Wrong !')
				}

			},
			error: function (e) {
				alert("Internal Server Error");
			}
		});
	}
}

function likePost(id) {
	var dislike = '<i class="fa fa-heart-o like" aria-hidden="true"></i>'
	var like = '<i class="fa fa-heart like" aria-hidden="true" style="color:red;"></i>'
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

function initialize() {
	var input = document.getElementById('searchTextField');
	var autocomplete = new google.maps.places.Autocomplete(input);
}
google.maps.event.addDomListener(window, 'load', initialize);


function findProductsByLocation() {
	var Address = $('[placeholder="Enter a location"]').val();
	if (Address !== "") {
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "/api/search/Product/location/" + Address,
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				var itemlist = $('.itemList');
				itemlist.empty();
				if (data.data.length > 0) {
					for (var item in data.data) {
						var itemlist = $('.itemList');
						var htmlString = "";
						htmlString += '<div class="col-sm-2">';
						htmlString += '<div class="card">';
						htmlString += '<a onClick="getProductDetailById(' + data.data[item].id + ');"><img src="http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data[item].image) + '" alt="Denim Jeans"></a>';
						htmlString += '<h3>' + data.data[item].productName + '</h3>';
						if (data.data[item].discountPrice != 0) {
							htmlString += '<p class="price original-price">$' + data.data[item].price + '</p>';
							htmlString += '<p class="price discounted-price">' + data.data[item].discountPrice + '</p>';
						} else {
							htmlString += '<p class="price discounted-price">$' + data.data[item].price + '</p>';
						}
						htmlString += '<div class="likeBtn row">';
						htmlString += '<div class="col-sm-6" id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">';
						htmlString += '<i class="fa fa-heart-o like" aria-hidden="true"></i>';
						htmlString += '</div>';
						htmlString += '<div class="col-sm-5 text-right" id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">';
						htmlString += '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>';
						htmlString += '</div>';
						htmlString += '</div>';
						htmlString += '</div>';
						htmlString += '</div>';
						itemlist.append(htmlString);
					}
				} else {
					document.getElementById('feedback').innerHTML = "No Products Available";
				}
			},
			error: function () {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		});
	} else {
		getAllPosts();
	}
}
function getAllPostsByLoginUserId() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	$('.itemList').html("");
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/product/" + Number(localStorage.getItem('uId')),
		dataType: 'json',
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data.data.length > 0) {
				for (var item in data.data) {
					var itemlist = $('.itemList');
					var htmlString = "";
					htmlString += '<div class="col-sm-2">';
					htmlString += '<div class="card">';
					htmlString += '<a onClick="getProductDetailById(' + data.data[item].id + ');"><img src="http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data[item].image) + '" alt="Denim Jeans"></a>';
					htmlString += '<h3>' + data.data[item].productName + '</h3>';
					if (data.data[item].discountPrice != 0) {
						htmlString += '<p class="price original-price">$' + data.data[item].price + '</p>';
						htmlString += '<p class="price discounted-price">' + data.data[item].discountPrice + '</p>';
					} else {
						htmlString += '<p class="price discounted-price">$' + data.data[item].price + '</p>';
					}
					htmlString += '<div class="likeBtn row">';
					htmlString += '<div class="col-sm-6" id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-heart-o like" aria-hidden="true"></i>';
					htmlString += '</div>';
					htmlString += '<div class="col-sm-5 text-right" id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>';
					htmlString += '</div>';
					htmlString += '</div>';
					htmlString += '<div id="btnForDelete" onclick="deleteById(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-trash-o" style="font-size:15px"></i>';
					htmlString += '</div>';
					htmlString += '</div>';
					htmlString += '</div>';
					itemlist.append(htmlString);
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		},
		error: function () {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}

function shareToFriend() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var email = $('#shareinput').val();
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/sharePost/" + Number(localStorage.getItem('uId')) + "/" + email + "/" + Number(localStorage.getItem('pId')),
		dataType: 'json',
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data['message'] == 'success') {
				closeShare();
				alert("post shared successfully")
			} else {
				alert('something went Wrong !')
			}

		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}

function referToFriend() {

	var email = $('#shareinput').val();
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/referFriend/" + email,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['message'] == 'success') {
				alert(" shared successfully")
			} else {
				alert('something went Wrong !')
			}

		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}

/** Get All post */
function getAllPostsWithLikeAndSaveStatus() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/products/likeAndsave/status",
		dataType: 'json',
		cache: false,
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		timeout: 600000,
		success: function (data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			if (data.data.length > 0) {
				for (var item in data.data) {
					var itemlist = $('.itemList');
					var htmlString = "";
					htmlString += '<div class="col-sm-2">';
					htmlString += '<div class="card">';
					htmlString += '<a onClick="getProductDetailById(' + data.data[item].id + ');"><img src="http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data[item].image) + '" alt="Denim Jeans"></a>';
					htmlString += '<h3>' + data.data[item].productName + '</h3>';
					if (data.data[item].discountPrice != 0) {
						htmlString += '<p class="price original-price">$' + data.data[item].price + '</p>';
						htmlString += '<p class="price discounted-price">' + data.data[item].discountPrice + '</p>';
					} else {
						htmlString += '<p class="price discounted-price">$' + data.data[item].price + '</p>';
					}
					htmlString += '<div class="likeBtn row">';
					htmlString += '<div class="col-sm-6" id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-heart-o like" aria-hidden="true"></i>';
					htmlString += '</div>';
					htmlString += '<div class="col-sm-5 text-right" id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>';
					htmlString += '</div>';
					htmlString += '</div>';
					htmlString += '</div>';
					htmlString += '</div>';
					itemlist.append(htmlString);
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		},
		error: function () {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}


function addSiteFeedback() {
	var name = $('#name').val();
	var email = $('#email').val();
	var mobileNumber = $('#mobileNumber').val();
	var message = $('#message').val();

	var request = {
		"name": name,
		"email": email,
		"mobileNumber": mobileNumber,
		"message": message
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/add/site/feedback",
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['status'] == 'OK') {
				$('#name').val('');
				$('#email').val('');
				$('#mobileNumber').val('');
				$('#message').val('');
				alert('Feedback sent to admin')
			} else {
				alert('something went Wrong !')
			}
		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}

$(document).ready(function () {
	if (localStorage.getItem('jsonToken') !== null) {
		$("#link1").css('display', 'block');
		$("#link2").css('display', 'block');
		$("#link3").css('display', 'block');
		$("#link4").css('display', 'block');
		$("#link-signin").css('display', 'none');
		$("#link-signup").css('display', 'none');
	} else {
		$("#link1").css('display', 'none');
		$("#link2").css('display', 'none');
		$("#link3").css('display', 'none');
		$("#link4").css('display', 'none');
		$("#link-signin").css('display', 'block');
		$("#link-signup").css('display', 'block');
	}
});

function searchByCategory(category) {
	if (category !== "all") {
		$.ajax({
			type: "GET",
			contentType: "application/json",
			url: "/api/getAll/productByQuery/" + category,
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				var itemlist = $('.itemList');
				itemlist.html('');
				if (data.data.length > 0) {
					for (var item in data.data) {
						var htmlString = "";
						htmlString += '<div class="col-sm-2">';
						htmlString += '<div class="card">';
						htmlString += '<a onClick="getProductDetailById(' + data.data[item].id + ');"><img src="http://localhost:8181/api/file/getFile/' + encodeURIComponent(data.data[item].image) + '" alt="Denim Jeans"></a>';
						htmlString += '<h3>' + data.data[item].productName + '</h3>';
						if (data.data[item].discountPrice != 0) {
							htmlString += '<p class="price original-price">$' + data.data[item].price + '</p>';
							htmlString += '<p class="price discounted-price">' + data.data[item].discountPrice + '</p>';
						} else {
							htmlString += '<p class="price discounted-price">$' + data.data[item].price + '</p>';
						}
						htmlString += '<div class="likeBtn row">';
						htmlString += '<div class="col-sm-6" id="' + 'like' + data.data[item].id + '" onclick="likeAndDislike(' + data.data[item].id + ');">';
						htmlString += '<i class="fa fa-heart-o like" aria-hidden="true"></i>';
						htmlString += '</div>';
						htmlString += '<div class="col-sm-5 text-right" id="' + 'save' + data.data[item].id + '" onclick="saveAndUnsavePost(' + data.data[item].id + ');">';
						htmlString += '<i class="fa fa-bookmark-o save" aria-hidden="true"></i>';
						htmlString += '</div>';
						htmlString += '</div>';
						htmlString += '</div>';
						htmlString += '</div>';
						itemlist.append(htmlString);

					}
				} else {
					document.getElementById('feedback').innerHTML = "No Products Available";
				}
			},
			error: function () {
				document.getElementById('feedback').innerHTML = "No Products Available";
			}
		});
	} else {
		getAllPosts();
	}
}