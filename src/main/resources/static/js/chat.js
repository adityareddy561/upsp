


function chat() {
  var message = document.getElementById("message").value;
  var jsonData = {
			"message" : message,
			"receiver" : receiverId
		};

    var myJSON = JSON.stringify(jsonData);
  $.ajax({
    
		type : "POST",
		url : "http://localhost:8181/api/message/add",
		data : myJSON,
		dataType : 'json',
		headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
    contentType : "application/json",
		cache : false,
		timeout : 600000,
		success : function(data) {
			getMessageBody(receiverId)
		},
		error : function(e) {
			alert("not send");
		},
	});
}
const getMessageBody = (username) =>{
  email=username;
	const msgerForm = get(".msger-inputarea");
const msgerInput = get(".msger-input");

const BOT_IMG = "https://image.flaticon.com/icons/svg/327/327779.svg";
$('#msgtest').html("");
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "http://localhost:8181/api/messages/get/"+email,
    dataType: 'json',
    headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
    cache: false,
    timeout: 600000,
    success: function(data) {
      console.log(data.data)
      if (data.data.length > 0) {
        for (var item in data.data) {
          BOT_NAME=data.data[item].sender;
          msgText=data.data[item].message;
          time=data.data[item].createdAt;
          if(BOT_NAME==email){
            appendMessage(BOT_NAME, BOT_IMG, "left", msgText,time);
          }else{
            appendMessage(BOT_NAME, BOT_IMG, "right", msgText,time);
          }
          
        }
      } 
    },
    error : function(e) {
     
    },
  });
}
function appendMessage(name, img, side, text,time) {
  // Simple solution for small apps
  const msgHTML = `
    <div class="msg ${side}-msg">
      <div class="msg-img" style="background-image: url(${img})"></div>

      <div class="msg-bubble">
        <div class="msg-info">
          <div class="msg-info-name">${name}</div>
          <div class="msg-info-time">${time}</div>
        </div>

        <div class="msg-text">${text}</div>
      </div>
    </div>
  `;
  const msgerChat = get(".msger-chat");
  msgerChat.insertAdjacentHTML("beforeend", msgHTML);
  msgerChat.scrollTop += 500;
}

function get(selector, root = document) {
  return root.querySelector(selector);
}

function formatDate(date) {
  const h = "0" + date.getHours();
  const m = "0" + date.getMinutes();

  return `${h.slice(-2)}:${m.slice(-2)}`;
}

function random(min, max) {
  return Math.floor(Math.random() * (max - min) + min);
}
