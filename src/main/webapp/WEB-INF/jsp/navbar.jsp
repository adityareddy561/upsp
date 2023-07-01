 <nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="home">
				<img src="images/upsp-logo.png" alt="" style="width: 150px; height:
					50px;">
			</a>
		</div>
		<!-- <ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">Page 1</a></li>
			<li><a href="#">Page 2</a></li>
		</ul> -->
		<form class="navbar-form navbar-left">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Enter a location"
					autocomplete="on" runat="server"
					onblur="findProductsByLocation()">
				<!-- <div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</div> -->
			</div>

			<div class="input-group">
				<input type="text" id="searchItem" class="form-control" placeholder="Search"
					name="search">
				<div class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="glyphicon glyphicon-search" onclick="searchByQuery();"></i>
					</button>
				</div>
			</div>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a id="loginBtn" href="feedback">Feedback</a></li>
			<li id="link1"><a id="loginBtn" href="myAdvertisements">My
					Ads</a></li>
			<li id="link2"><a id="loginBtn" href="checkProfile">Profile</a></li>
			<li id="link3"><a href="sellingCategory">Sell</a></li>
			<li id="link4"><a href="#" onclick="logout();">Logout</a></li>
			<li id="link-signup"><a href="registration"><span class="glyphicon
						glyphicon-user"></span>
					Sign Up</a></li>
			<li id="link-signin"><a href="login"><span class="glyphicon
						glyphicon-log-in"></span> Login</a></li>
		</ul>
	</div>
</nav>