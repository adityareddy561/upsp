function postUpdate() {
	var title = $('#productName').val();
	var price = $('#productPrice').val();
	var owner = $('#productOwner').val();
	var description = $('#productDescription').val();
	var request = {
		"title": title,
		"price": price,
		"owner": owner,
		"description": description
	};
	var myJSON = JSON.stringify(request);
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/postUpdate/" + myJSON,
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
