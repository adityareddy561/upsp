function userRegister() {
	alert('click successsfull...');
	var email = $('#email').val();
	var password = $('#password').val();
	var name = $('#userName').val();
	var mobileNumber = $('#phoneNo').val();
	var userType = $("input[type='radio']:checked").val();
	var image = $('[type="file"]').val();
	var request = {
		"email": email,
		"password": password,
		"fullName": name,
		"mobileNumber": mobileNumber,
		"userType": userType,
		"profileImage": image
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/user/add",
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			alert("Enter");
			console.log(data);
			try {
				if (data['message'] == 'success') {
					alert('response successfully...');
					window.location.assign('/homepage');
				} else {
					console.log(data['message']);
					alert("User name and Password is wrong !")

				}
			} catch (error) {
				// Handle the error in the success block
				console.error('An error occurred in the success block:', error.message);
				alert("Error occurred in success block");
			}
		},
		error: function(e) {
			alert("Internal Server Error");
		}
	});
}