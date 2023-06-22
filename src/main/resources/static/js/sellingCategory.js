function showSubCategories(id){
//	console.log('file reach success...');
	//var itemId=document.getElementById(id)
	//console.log(itemId.innerHTML);
	if(id ==="category1"){
//document.getElementById("selectedCategory").innerHTML = html;

		//console.log(html);
		const subCategory=document.getElementsByClassName("carsSubCetagory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
				console.log('condition true');
				console.log(subCategory[i].innerHTML);
				subCategory[i].style.display="none";

			}else{
	     		subCategory[i].style.display="block";

			}
		}
	}
	else if(id ==="category2"){
			const subCategory=document.getElementsByClassName("propertiesSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
				subCategory[i].style.display="none";

			}else{
				subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category3"){
		const subCategory=document.getElementsByClassName("mobilesSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
				subCategory[i].style.display="none";

			}else{
				subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category4"){
		const subCategory=document.getElementsByClassName("jobSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category5"){
		const subCategory=document.getElementsByClassName("BikeSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category6"){
		const subCategory=document.getElementsByClassName("electronicsSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category7"){
		const subCategory=document.getElementsByClassName("commercialVahiclesSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category8"){
		const subCategory=document.getElementsByClassName("furnitureSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category9"){
				const subCategory=document.getElementsByClassName("fashionSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

	}
else if(id ==="category10"){
		const subCategory=document.getElementsByClassName("booksSportsSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category11"){
		const subCategory=document.getElementsByClassName("petsSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
else if(id ==="category12"){
		const subCategory=document.getElementsByClassName("serviceSubCategory");
		for(var i=0;i<subCategory.length;i++){
			if(subCategory[i].style.display==="block"){
							subCategory[i].style.display="none";

			}else{
						subCategory[i].style.display="block";

			}
		}

		
	}
}
	function showSellingCategory(){
			console.log('connection success...');
            window.location.assign("sellingCategory");
            		
		}

function likePost(){
	var post=document.getElementById('btnForLike');
	
	var dislike='<i class="fa fa-heart-o like" aria-hidden="true"></i>'
	var like='<i class="fa fa-heart like" aria-hidden="true"></i>'
	var post=document.getElementById('btnForLike');
	if(post.innerHTML===like){
	post.innerHTML= dislike;
	}else{
		post.innerHTML=like;
	}
	
	
}
function savePost(){
	var unsave='<i class="fa fa-bookmark-o save" aria-hidden="true"></i>'
	var save='<i class="fa fa-bookmark save" aria-hidden="true"></i>'
	var post=document.getElementById('btnForSave');
	if(post.innerHTML===unsave){
	post.innerHTML= save;
	}else{
		post.innerHTML=unsave;
	}
	
}
function back(){
	     window.location.assign("homepage");
}

