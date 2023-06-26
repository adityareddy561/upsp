
function viewProfile(id) {
	window.location.assign('checkProfile');
	//let profile = document.getElementById(id);
	//	document.getElementById('postAdds').style.display="none";
	//	document.getElementById('dropContent').style.display="none";

	//profile.style.display = "block";
}
function editProfile(id) {
	let profile = document.getElementById(id);
	document.getElementById('postAdds').style.display = "none";
	document.getElementById('dropContent').style.display = "none";
	profile.style.display = "block";

}
function showAds() {
	window.location.assign('ads');
}
function updateProduct(id, name, owner, price, desc) {
	var Pid = document.getElementById(id).innerHTML;
	var Pname = document.getElementById(name).innerHTML;
	var Powner = document.getElementById(owner).innerHTML;
	var Pprice = document.getElementById(price).innerHTML;
	var Pdesc = document.getElementById(desc).innerHTML;

	document.getElementById('id').value = Pid;

	document.getElementById('productName').value = Pname;

	document.getElementById('productPrice').value = Pprice;

	document.getElementById('productOwner').value = Powner;

	document.getElementById('productDescription').value = Pdesc;

	document.getElementById('adsContainer').style.display = "none";

	document.getElementById('container').style.display = "block";

}
function showCategories() {
	window.location.assign('sellingCategory');

}
function changePassword() {
	var modal = document.getElementById("changePassword");
	modal.style.display = "block";
}

function closeChangePassword() {
	var modal = document.getElementById("changePassword");
	modal.style.display = "none";
}

function updatePassword(id) {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var password = $('#newPassword').val();
	var request = {
		"id": id,
		"newPassword": password
	};
	var myJSON = JSON.stringify(request);

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/change/password",
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
			if (data['message'] == 'Login Sucessfull') {
				window.location.assign('otp?userId=' + data.data);
			} else {
				console.log(data['message']);
				alert("User name and Password is wrong !")

			}
		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}


function loadUserById() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/user/get/" + localStorage.getItem('uId'),
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['statusCode'] == 401) {
				window.location.assign('login');
				return
			}
			$('#name').append(data.data.fullName);
			$('#mail').append(data.data.email);
			$('#mobile').append(data.data.mobileNumber);
			$('#changepswd').append('<span style="cursor: pointer;" onclick="changePassword(' + data.data.id + ')">'
				+ 'Change Password</span>');
			$('#updtPswd').append('<button onclick="updatePassword(' + data.data.id + ')" style="padding: 5px 10px"'
				+ 'type="submit">Send</button>');

		},
		error: function() {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
function editProfileById() {
	if (localStorage.getItem('jsonToken') === null) {
		window.location.assign('login');
		return
	}
	var name = $('[placeholder="Enter your full name :"]').val();
	var email = $('[placeholder="Enter your email :"]').val();
	var contact = $('[placeholder="Enter your mobile number :"]').val();
	var request = {
		"fullName": name,
		"email": email,
		"mobileNumber": contact,
		"id": Number(localStorage.getItem('uId'))

	};
	var myJSON = JSON.stringify(request);

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/user/update",
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
				alert('Update User Successfully')
			} else {
				console.log(data['message']);
				alert("something went wrong !")

			}
		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}
function editProfile() {
	var modal = document.getElementById("editProfile");
	modal.style.display = "block";
}

function closeEditProfile() {
	var modal = document.getElementById("editProfile");
	modal.style.display = "none";
}
