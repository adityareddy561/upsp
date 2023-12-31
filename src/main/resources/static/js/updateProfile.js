function updateProfile() {
	var email = $('#emailInput').val();
	var firstName = $('#firstnameInput').val();
	var lastName = $('#lastnameInput').val();
	var gender = $('#genderInput').val();
	var request = {
		"email": email,
		"firstName": firstName,
		"lastName": lastName,
		"gender": gender
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/profileUpdate/" + myJSON,
		data: null,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function (data) {
			if (data['message'] == 'success') {
				window.location.assign('homepage');
			} else {
				alert("User name and Password is wrong !")
				changeNavbar();
			}
		},
		error: function (e) {
			alert("Internal Server Error");
		}
	})
}
