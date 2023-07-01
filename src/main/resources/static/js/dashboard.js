function getAllCategoriesForAdmin() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	if (localStorage.getItem('adminRole') === null) {
		window.location.assign('login');
		return
	}
	if (localStorage.getItem('adminRole') != 0) {
		window.location.assign('login');
		return
	}
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
					$('#chooseCat')
						.append(
							'<option value="' + data.data[item].id + '">' + data.data[item].categoryName + '</option>'
						);
				}
			} else {
				document.getElementById('feedback').innerHTML = "No Data Available";
			}
		},
		error: function () {
			document.getElementById('feedback').innerHTML = "No Data Available";
		}
	});
}

function addCategoryByAdmin() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	if (localStorage.getItem('adminRole') === null) {
		window.location.assign('login');
		return
	}
	if (localStorage.getItem('adminRole') != 0) {
		window.location.assign('login');
		return
	}
	var categoryName = $('.categoryName2').val();
	if (categoryName == undefined || categoryName === "" || categoryName === null) {
		alert("category name must be filled!!");
		return;
	}
	var request = {
		"categoryName": categoryName
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/add/category",
		data: myJSON,
		dataType: 'json',
		cache: false,
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		timeout: 600000,
		success: function (data) {
			if (data['message'] == 'success') {
				if (data['statusCode'] == 401) {
					window.location.assign('login');
					return
				}
				try {
					alert('Category added successfully')
				} catch (error) {
					console.error('An error occurred in the success block:', error.message);
					alert("something went wrong");
				}
			} else {
				alert("something went wrong");
			}
		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}

function addSubCategoryByAdmin() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	if (localStorage.getItem('adminRole') === null) {
		window.location.assign('login');
		return
	}
	if (localStorage.getItem('adminRole') != 0) {
		window.location.assign('login');
		return
	}
	var categoryId = $('#chooseCat').find('option:selected').attr('value');

	var subcategoryName = $('.SubcategoryName2').val();
	var request = {
		"categoryId": categoryId,
		"subCategoryName": subcategoryName
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/add/subCategory",
		data: myJSON,
		dataType: 'json',
		cache: false,
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		timeout: 600000,
		success: function (data) {
			if (data['message'] == 'success') {
				if (data['statusCode'] == 401) {
					window.location.assign('login');
					return
				}
				try {
					alert('Sub category added successfully')
				} catch (error) {
					console.error('An error occurred in the success block:', error.message);
					alert("something went wrong");
				}
			} else {
				alert("something went wrong");
			}
		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}

/** Get All category */
function getAllCategoryListForAdmin() {
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
					let htmlString = '';
					htmlString += '<tr><td>' + (item + 1) + '</td><td>' + data.data[item].categoryName + '</td>';
					htmlString += '<td>';
					htmlString += '<div class="likeBtn" style="display:flex">';
					htmlString += '<button id="' + 'like' + data.data[item].id + '" onclick="editCategoryById(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-edit like" aria-hidden="true"></i>';
					htmlString += '</button>';
					htmlString += '<button text-right" id="' + 'save' + data.data[item].id + '" onclick="deleteCategoryById(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-close save" aria-hidden="true"></i>';
					htmlString += '</button>';
					htmlString += '</div>';
					htmlString += '</td></tr>';
					$('#category-data-list').append(htmlString);
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

function deleteCategoryById(id) {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	if (confirm("Are you sure you want to delete?")) {
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			url: "/api/delete/category/" + id,
			headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				if (data['statusCode'] == 401) {
					window.location.assign('login');
					return
				}
				if (data['status'] == 'OK') {
					getAllCategoryListForAdmin();
					alert('Category delete  successfully');
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

/** Get All category */
function getAllSubCategoryListForAdmin() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/subCategory",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data.data.length > 0) {
				for (var item in data.data) {
					let htmlString = '';
					htmlString += '<tr><td>' + (item + 1) + '</td><td>' + data.data[item].categoryName + '</td>';
					htmlString += '<td>' + data.data[item].subCategoryName + '</td>';
					htmlString += '<td>';
					htmlString += '<div class="likeBtn" style="display:flex">';
					htmlString += '<button id="' + 'like' + data.data[item].id + '" onclick="editSubCategoryById(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-edit like" aria-hidden="true"></i>';
					htmlString += '</button>';
					htmlString += '<button text-right" id="' + 'save' + data.data[item].id + '" onclick="deleteSubCategoryById(' + data.data[item].id + ');">';
					htmlString += '<i class="fa fa-close save" aria-hidden="true"></i>';
					htmlString += '</button>';
					htmlString += '</div>';
					htmlString += '</td></tr>';
					$('#category-data-list').append(htmlString);
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

function deleteSubCategoryById(id) {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	if (confirm("Are you sure you want to delete?")) {
		$.ajax({
			type: "DELETE",
			contentType: "application/json",
			url: "/api/delete/subCategory/" + id,
			headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
			dataType: 'json',
			cache: false,
			timeout: 600000,
			success: function (data) {
				if (data['statusCode'] == 401) {
					window.location.assign('login');
					return
				}
				if (data['status'] == 'OK') {
					getAllCategoryListForAdmin();
					alert('Category delete  successfully');
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

/** Get All category */
function getAllSiteFeedbackListForAdmin() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/site/feedback",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data.data.length > 0) {
				for (var item in data.data) {
					let htmlString = '';
					htmlString += '<tr><td>' + (item + 1) + '</td><td>' + data.data[item].name + '</td>';
					htmlString += '<td>' + data.data[item].email + '</td>';
					htmlString += '<td>' + data.data[item].mobileNumber + '</td>';
					htmlString += '<td>' + data.data[item].message + '</td></tr>';
					$('#category-data-list').append(htmlString);
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

function logout() {
	localStorage.clear();
	window.location.assign('login');
}

/** Get All category */
function getAllReportListForAdmin() {
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/getAll/report",
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data.data.length > 0) {
				for (var item in data.data) {
					let htmlString = '';
					htmlString += '<tr><td>' + item + '</td>';
					htmlString += '<td>' + data.data[item].query + '</td>';
					htmlString += '<td>' + data.data[item].username + '</td>';
					htmlString += '<td>' + data.data[item].productName + '</td></tr>';
					$('#category-data-list').append(htmlString);
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