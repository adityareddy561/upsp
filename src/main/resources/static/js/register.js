function userRegister() {
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
		success: function (data) {
			try {
				if (data['message'] == 'success') {
					window.location.assign('/login');
				} else {
					alert("User name and Password is wrong !")
				}
			} catch (error) {
				alert("Error occurred in success block");
			}
		},
		error: function (e) {
			alert("Internal Server Error");
		}
	});
}