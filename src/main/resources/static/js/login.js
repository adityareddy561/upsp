function login() {
	var userName = $('#username').val();
	var password = $('#password').val();
	var request = {
		"username": userName,
		"password": password
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/auth/login",
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['message'] == 'Login Sucessfull') {
				localStorage.setItem('loginUser', JSON.stringify(data.data));
				window.location.assign('otp');
			} else {
				alert("User name and Password is wrong !")
			}
		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}

function openForgotPasswordModal() {
	var modal = document.getElementById("forgotPasswordModal");
	modal.style.display = "block";
}

function closeForgotPasswordModal() {
	var modal = document.getElementById("forgotPasswordModal");
	modal.style.display = "none";
}

function forgetPassword() {
	var email = $('#forgetPasswordEmail').val();
	$.ajax({
		type: "GET",
		contentType: "application/json",
		url: "/api/user/forgotPassword/" + email,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			$('#forgot-password-close').click();
			alert('Your temporary password sent to email')
		},
		error: function () {
			document.getElementById('feedback').innerHTML = "No Products Available";
		}
	});
}
