	
		function viewProfile(id) {
			window.location.assign('checkProfile');
			//let profile = document.getElementById(id);
					//	document.getElementById('postAdds').style.display="none";
					//	document.getElementById('dropContent').style.display="none";

			//profile.style.display = "block";
		}
		function editProfile(id) {
			let profile = document.getElementById(id);
     		document.getElementById('postAdds').style.display="none";
		    document.getElementById('dropContent').style.display="none";
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
	function showCategories(){
		window.location.assign('sellingCategory');
		
	}
