function chatlist() {
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "http://localhost:8181/api/userbyrole/getAll",
    dataType: 'json',
    headers: { "Authorization": "Bearer " + localStorage.getItem('jsonToken') },
    cache: false,
    timeout: 600000,
    success: function(data) {
      console.log(data.data)
      if (data.data.length > 0) {
        for (var item in data.data) {
          $('.itemList').append(
            '<li><a id="profilesender" onClick=singleResponse(\"' + data.data[item].email.trim() + '\")>'+data.data[item].email+
            '</a></li>');

        }
      } 
    },
    error : function(e) {
     
    }
  });
}
function myFunction() {
	
  var data = document.getElementById("count_id").value;
  var  datacount = (parseInt(data) + 1);
  document.getElementById("count_id").value = datacount;	
  document.getElementById("profilesender").value = "Clicked";
  
}
//  setInterval(function(){
//   document.getElementById("profilesender").click();	
//    }, 1000);

let receiverId = "";
function singleResponse(email) {
  receiverId=email
	const msgerForm = get(".msger-inputarea");
const msgerInput = get(".msger-input");

const BOT_IMG = "https://image.flaticon.com/icons/svg/327/327779.svg";
$('#msgtest').html("");
  $.ajax({
    type: "GET",
    contentType: "application/json",
    url: "http://localhost:8181/api/messages/get/"+email+"/"+localStorage.getItem("user_details"),
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
     // document.getElementById("profilesender").value = "Clicked";
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
