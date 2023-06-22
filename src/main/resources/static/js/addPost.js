function postAdd(){
	console.log("page is ready..");
	alert("page is ready..");
		      var title =$('#title').val();
              var brand=$('#brand').val();
		      var model =$('#model').val();
              var year=$('#year').val();
              var description=$('#discription').val();
           console.log(title);
           console.log(brand);
           console.log(model);
           console.log(year);
           console.log(description);

		
	var request = {
		 "title" : title,
		 "brand": brand,
		 "model" : model,
		 "year": year,
		 "description" : description,
		   };
	var myJSON =JSON.stringify(request);

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url :"/api/posting/"+myJSON,
		data :null,
		cache : false,
		timeout :600000,
		
		success  : function(data) {
		console.log('request send successfully...');
			if(data['message'] =='success'){
				console.log('msg success...');
				alert('msg success');
						//changeNavbar();
			
			}else{
				alert("User name and Password is wrong !")
						//changeNavbar();

			}
		},
		error : function(e) {
						alert("Internal Server Error");
		}
				})

	
}

function postDetails(subCategory){
	if(subCategory==="cars"){
		console.log('connection success...');
		document.getElementById('cars&BikesSection').style.display="block";
	    document.getElementById('peropertiesSection').style.display="none";
		document.getElementById('mobileSection').style.display="none";
		document.getElementById('jobSection').style.display="none";
		document.getElementById('bikeSection').style.display="none";
		document.getElementById('commercialVahiclesSection').style.display="none";
		document.getElementById('serviceSection').style.display="none";

	}
}




function showPostImages(clas){
	console.log('click success..')
			   const imgCollection = document.getElementsByClassName(clas);
			   for(let i=0;i<imgCollection.length;i++){   
				   document.getElementById('postImg'+i).src=imgCollection[i];
			   }

}

function back(id){
     window.location.assign("sellingCategory");
}