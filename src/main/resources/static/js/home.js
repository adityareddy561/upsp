function showAdds(id) {
	document.getElementById(id).style.display = 'block';
	if (id === 'cars') {
		document.getElementById('mobiles').style.display = 'none';
		document.getElementById('bikes').style.display = 'none';
		document.getElementById('properties').style.display = 'none';
	} else if (id === 'mobiles') {
		document.getElementById('cars').style.display = 'none';
		document.getElementById('bikes').style.display = 'none';
		document.getElementById('properties').style.display = 'none';
	} else if (id === 'bikes') {
		document.getElementById('mobiles').style.display = 'none';
		document.getElementById('cars').style.display = 'none';
		document.getElementById('properties').style.display = 'none';
	} else if (id === 'properties') {
		document.getElementById('mobiles').style.display = 'none';
		document.getElementById('bikes').style.display = 'none';
		document.getElementById('cars').style.display = 'none';
	}
}