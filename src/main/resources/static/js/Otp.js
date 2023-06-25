function sendOtp() {
	var otp = $('#otp').val();
	var request = {
		"otp": otp,
		"userId": localStorage.getItem('loginUser'),
		"termsAndConditions": true
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/otpVerification",
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			if (data['message'] == 'Login Sucessfull') {
				try {
					localStorage.clear();
					if (data.data.user_details.role == 0) {
						localStorage.setItem('jsonToken', data.data.token);
						localStorage.setItem('uId', data.data.user_details.id);
						localStorage.setItem('adminRole', data.data.user_details.role);
						window.location.assign('/dashboard');
						return
					}
					//sessionStorage.setItem('jsonToken', JSON.stringify(data.data.token));
					localStorage.setItem('jsonToken', data.data.token);
					localStorage.setItem('uId', data.data.user_details.id);
					console.log(localStorage.getItem('jsonToken'));
					window.location.assign('/index');
				} catch (error) {
					// Handle the error in the success block
					console.error('An error occurred in the success block:', error.message);
					alert("Error occurred in success block");
				}
			} else {
				alert("Otp is wrong or expired !")
			}
		},
		error: function(e) {
			alert("Internal Server Error");
		}

	});

}