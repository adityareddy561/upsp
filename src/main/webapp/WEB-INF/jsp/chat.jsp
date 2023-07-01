<!DOCTYPE HTML PUBLIC >
<html>
<head>
<title></title>
<script src="index.js" type="module"></script>
<script type="text/javascript" charset="utf-8" src="jquery.mobile/jquery-1.7.2.min"></script>
<link rel="stylesheet" href="css/chat.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/websocket.js"></script>
<script src="js/chatlist.js"></script>
<script src="js/chat.js"></script>
</head>
<body onload="chatlist()">

		<nav>
			<div id="nav">
               <ul class="itemList">

		       </ul>
			</div>
        </nav>
	
	<section class="msger" >
	<header class="msger-header" >
	<div class="msger-header-title">
		
	</div>
	<div class="msger-header-options">
		<span><i class="fas fa-cog"></i></span>
	</div>
	</header> <main class="msger-chat" id="msgtest">

	</main>
	<form class="msger-inputarea" id="msgFormId">
		<input type="text" id="message" class="msger-input" name="massage"
			placeholder="Enter your message...">
		<button type="button" class="msger-send-btn" onclick="sendMessage();">Send</button>
		
	</form>
	</section>
	
</body>
</html>

	<!-- <div class="msg left-msg">
		<div class="msg-img"
			style="background-image: url(https://image.flaticon.com/icons/svg/327/327779.svg)"></div>
		<div class="msg-bubble">
			<div class="msg-info">
				<div class="msg-info-name">BOT</div>
				<div class="msg-info-time">12:45</div>
			</div>
			<div class="msg-text">Hi, welcome to SimpleChat! Go ahead and
				send me a message</div>
		</div>
	</div>
	<div class="msg right-msg">
		<div class="msg-img"
			style="background-image: url(https://image.flaticon.com/icons/svg/145/145867.svg)"></div>
		<div class="msg-bubble">
			<div class="msg-info">
				<div class="msg-info-name">Sajad</div>
				<div class="msg-info-time">12:46</div>
			</div>
			<div class="msg-text">You can change your name in JS section!</div>
		</div>
	</div> -->