function sendOtp(userId) {
	alert('click successsfull...');
	var otp = $('#otp').val();
	var request = {
		"otp": otp,
		"userId": userId,
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
					//sessionStorage.setItem('jsonToken', JSON.stringify(data.data.token));
					localStorage.setItem('jsonToken', JSON.stringify(data.data.token));
					window.location.assign('/homepage');
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