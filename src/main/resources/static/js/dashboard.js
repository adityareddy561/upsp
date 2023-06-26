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
		success: function(data) {
			if (data.data.length > 0) {
				for (var item in data.data) {
					$('#chooseCat')
						.append(
							'<option value="' + data.data[item].id + '">' + data.data[item].categoryName + '</option>'
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
		success: function(data) {
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
		error: function(e) {
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
		success: function(data) {
			if (data['message'] == 'success') {
				if (data['statusCode'] == 401) {
					window.location.assign('login');
					return
				}
				try {
					alert(' Sub category added successfully')
				} catch (error) {
					console.error('An error occurred in the success block:', error.message);
					alert("something went wrong");
				}
			} else {
				alert("something went wrong");
			}
		},
		error: function(e) {
			alert("Internal Server Error");
		}

	});

} 