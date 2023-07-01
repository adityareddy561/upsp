function showRate(id) {
	var starId = document.getElementById(id);
	if (starId.style.color === "lightgray") {
		starId.style.color = "rgb(255 191 67)";
	} else {
		starId.style.color = "lightgray";
	}
}
function report() {
	var modal = document.getElementById("report");
	modal.style.display = "block";
}

function closeReport() {
	var modal = document.getElementById("report");
	modal.style.display = "none";
}
function opneFeedback() {
	var modal = document.getElementById("feedbackModal");
	modal.style.display = "block";
}

function closeFeedback() {
	var modal = document.getElementById("feedbackModal");
	modal.style.display = "none";
}
function openshare() {
	var modal = document.getElementById("sharemodel");
	modal.style.display = "block";
}

function closeShare() {
	var modal = document.getElementById("sharemodel");
	modal.style.display = "none";
}