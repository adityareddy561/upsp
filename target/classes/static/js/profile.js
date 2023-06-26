
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

function updatePassword() {
	alert('click ...')
	//var uid = $('#id').val();
	//var password = $('#newPassword').val();
	alert("Enter")

	var request = {
		"id": 1,
		"newPassword": '12345'
	};
	alert("success")
	var myJSON = JSON.stringify(request);

	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/api/change/password",
		data: myJSON,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {
			alert("updatePassword")
			console.log('response recieve successfully...');
			console.log(data);
			if (data['message'] == 'Login Sucessfull') {
				console.log('response successfully...');
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