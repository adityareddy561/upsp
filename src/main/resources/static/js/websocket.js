
        var stompClient = null;
        const BOT_IMG = "https://image.flaticon.com/icons/svg/327/327779.svg";
            var socket = new SockJS("http://localhost:8181/ws");
            stompClient = Stomp.over(socket);
            stompClient.connect({"Authorization" : "Bearer "+localStorage.getItem("jsonToken")}, function (frame) {
             //setConnected(true);
              console.log("Connected: " + frame);
              stompClient.subscribe(
                "/topic/greetings",
                function (messageOutput) {
                  showGreeting(JSON.parse(messageOutput.body));
                }
              );
            });
         

        function sendMessage() {
            var message = document.getElementById("message").value;
            //stompClient.send("/app/chat", {}, message+"#@#"+receiverId);
            stompClient.send("/app/chat", {"Authorization" : "Bearer "+localStorage.getItem("jsonToken")}, JSON.stringify( {'message':message,'receiver':localStorage.getItem("seller"),'sender':localStorage.getItem("uId")}));
            console.log("Sent message: " + message);
        }

        function showGreeting(data) {
          $('#msgtest').html("");
          console.log(data.data)
         
            for (var item in data.data) {
              BOT_NAME=data.data[item].sender;
              msgText=data.data[item].message;
              time=data.data[item].createdAt;
              if(BOT_NAME==localStorage.getItem("seller")){
                appendMessage(BOT_NAME, BOT_IMG, "left", msgText,time);
              }else{
                appendMessage(BOT_NAME, BOT_IMG, "right", msgText,time);
              }
              
            }
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