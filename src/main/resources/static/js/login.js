function login() {
	alert('click successsfull...')
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
		success: function(data) {
			console.log('response recieve successfully...');
			console.log(data);
			if (data['message'] == 'Login Sucessfull') {
				console.log('response successfully...');
				window.location.assign('otp?userId='+data.data);
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