
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta http-equiv="Content-Language" content="en">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>DashBoard</title>
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1,
			user-scalable=no, shrink-to-fit=no" />
		<meta name="description"
			content="This is an example dashboard created using build-in elements and
			components.">
		<meta name="msapplication-tap-highlight" content="no">
		<link
			href="https://demo.dashboardpack.com/architectui-html-free/main.css"
			rel="stylesheet">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
			<style type="text/css">
				.button-91 {
					color: #fff;
					padding: 15px 25px;
					background-color: #000000;
					background-image: radial-gradient(93% 87% at 87% 89%, rgba(0, 0, 0, 0.23)
						0%, transparent 86.18%),
						radial-gradient(66% 66% at 26% 20%, rgba(255, 255, 255, 0.55) 0%,
						rgba(255, 255, 255, 0) 69.79%, rgba(255, 255, 255, 0) 100%);
					box-shadow: inset -3px -3px 9px rgba(255, 255, 255, 0.25), inset 0px 3px
						9px rgba(255, 255, 255, 0.3), inset 0px 1px 1px
						rgba(255, 255, 255, 0.6), inset 0px -8px 36px rgba(0, 0, 0, 0.3),
						inset 0px 1px 5px rgba(255, 255, 255, 0.6), 2px 19px 31px
						rgba(0, 0, 0, 0.2);
					border-radius: 14px;
					font-weight: bold;
					font-size: 16px;
					border: 0;
					user-select: none;
					-webkit-user-select: none;
					touch-action: manipulation;
					cursor: pointer;
				}
				
				.brandLogo {
					color: #002f34;
					font-size: 20px;
					font-weight: 900;
				}
				
				#input1 {
					padding: 7px;
					border-radius: 6px;
					font-size: 16px;
					background: #fbfbfb;
					border: 2px solid transparent;
					height: 36px;
					box-shadow: 0 0 0 1px #dddddd, 0 2px 4px 0 rgb(0 0 0/ 7%), 0 1px 1.5px 0
						rgb(0 0 0/ 5%); : focus { border : 2px solid #000;
					border-radius: 4px;
				}
				
				}
				.brand {
					text-align: center;
					cursor: pointer;
				}
				
				#logoDesc {
					color: black;
				}
				
				.button-3 {
					appearance: none;
					background-color: #000000;
					border: 1px solid rgba(27, 31, 35, .15);
					border-radius: 6px;
					box-shadow: rgba(27, 31, 35, .1) 0 1px 0;
					box-sizing: border-box;
					color: #fff !important;
					cursor: pointer;
					display: inline-block;
					font-family: -apple-system, system-ui, "Segoe UI", Helvetica, Arial,
						sans-serif, "Apple Color Emoji", "Segoe UI Emoji";
					font-size: 14px;
					font-weight: 600;
					line-height: 20px;
					padding: 6px 16px;
					position: relative;
					text-align: center;
					text-decoration: none;
					user-select: none;
					-webkit-user-select: none;
					touch-action: manipulation;
					vertical-align: middle;
					white-space: nowrap;
					width: 100%;
				}
				
				.button-3:focus:not(:focus-visible):not(.focus-visible) {
					box-shadow: none;
					outline: none;
				}
				
				.button-3:hover {
					background-color: #000000;
				}
				
				.button-3:focus {
					box-shadow: rgba(46, 164, 79, .4) 0 0 0 3px;
					outline: none;
				}
				
				.button-3:disabled {
					background-color: #000000;
					border-color: rgba(27, 31, 35, .1);
					color: rgba(255, 255, 255, .8);
					cursor: default;
				}
				
				.button-3:active {
					background-color: #000000;
					box-shadow: rgba(20, 70, 32, .2) 0 1px 0 inset;
				}
				</style>
	</head>

	<body onload="getAllCategoriesForAdmin();">
		<div
			class="app-container app-theme-white body-tabs-shadow fixed-sidebar
			fixed-header">
			<div class="app-header header-shadow">
				<div class="app-header__logo">
					<div class="brand">
						<a href="#" class="brandLogo">U P S P</a>
						<p id="logoDesc">Quick Sell Used Item</p>
					</div>

				</div>
				<div class="app-header__mobile-menu">
					<div>
						<button type="button"
							class="hamburger hamburger--elastic mobile-toggle-nav">
							<span class="hamburger-box"> <span class="hamburger-inner"></span>
							</span>
						</button>
					</div>
				</div>
				<div class="app-header__menu">
					<span>
						<button type="button"
							class="btn-icon btn-icon-only btn btn-primary btn-sm
							mobile-toggle-header-nav">
							<span class="btn-icon-wrapper"> <i
									class="fa fa-ellipsis-v fa-w-6"></i>
							</span>
						</button>
					</span>
				</div>
				<div class="app-header__content"></div>
			</div>
			<div class="ui-theme-settings">
				<div class="theme-settings__inner">
					<div class="scrollbar-container">
						<div class="theme-settings__options-wrapper">
							<h3 class="themeoptions-heading">Layout Options</h3>
							<div class="p-3">
								<ul class="list-group">
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="switch has-switch switch-container-class"
														data-class="fixed-header">
														<div class="switch-animate switch-on">
															<input type="checkbox" checked data-toggle="toggle"
																data-onstyle="success">
														</div>
													</div>
												</div>
												<div class="widget-content-left">
													<div class="widget-heading">Fixed Header</div>
													<div class="widget-subheading">Makes the header top
														fixed, always visible!</div>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="switch has-switch switch-container-class"
														data-class="fixed-sidebar">
														<div class="switch-animate switch-on">
															<input type="checkbox" checked data-toggle="toggle"
																data-onstyle="success">
														</div>
													</div>
												</div>
												<div class="widget-content-left">
													<div class="widget-heading">Fixed Sidebar</div>
													<div class="widget-subheading">Makes the sidebar left
														fixed, always visible!</div>
												</div>
											</div>
										</div>
									</li>
									<li class="list-group-item">
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="switch has-switch switch-container-class"
														data-class="fixed-footer">
														<div class="switch-animate switch-off">
															<input type="checkbox" data-toggle="toggle"
																data-onstyle="success">
														</div>
													</div>
												</div>
												<div class="widget-content-left">
													<div class="widget-heading">Fixed Footer</div>
													<div class="widget-subheading">Makes the app footer
														bottom fixed, always visible!</div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>

							<div class="p-3">
								<ul class="list-group">
									<li class="list-group-item">
										<h5 class="pb-2">Choose Color Scheme</h5>
										<div class="theme-settings-swatches">
											<div class="swatch-holder bg-primary switch-header-cs-class"
												data-class="bg-primary header-text-light"></div>
											<div class="swatch-holder bg-secondary switch-header-cs-class"
												data-class="bg-secondary header-text-light"></div>
											<div class="swatch-holder bg-success switch-header-cs-class"
												data-class="bg-success header-text-dark"></div>
											<div class="swatch-holder bg-info switch-header-cs-class"
												data-class="bg-info header-text-dark"></div>
											<div class="swatch-holder bg-warning switch-header-cs-class"
												data-class="bg-warning header-text-dark"></div>
											<div class="swatch-holder bg-danger switch-header-cs-class"
												data-class="bg-danger header-text-light"></div>
											<div class="swatch-holder bg-light switch-header-cs-class"
												data-class="bg-light header-text-dark"></div>
											<div class="swatch-holder bg-dark switch-header-cs-class"
												data-class="bg-dark header-text-light"></div>
											<div class="swatch-holder bg-focus switch-header-cs-class"
												data-class="bg-focus header-text-light"></div>
											<div class="swatch-holder bg-alternate switch-header-cs-class"
												data-class="bg-alternate header-text-light"></div>
											<div class="divider"></div>
											<div
												class="swatch-holder bg-vicious-stance switch-header-cs-class"
												data-class="bg-vicious-stance header-text-light"></div>
											<div
												class="swatch-holder bg-midnight-bloom switch-header-cs-class"
												data-class="bg-midnight-bloom header-text-light"></div>
											<div class="swatch-holder bg-night-sky switch-header-cs-class"
												data-class="bg-night-sky header-text-light"></div>
											<div
												class="swatch-holder bg-slick-carbon switch-header-cs-class"
												data-class="bg-slick-carbon header-text-light"></div>
											<div class="swatch-holder bg-asteroid switch-header-cs-class"
												data-class="bg-asteroid header-text-light"></div>
											<div class="swatch-holder bg-royal switch-header-cs-class"
												data-class="bg-royal header-text-light"></div>
											<div
												class="swatch-holder bg-warm-flame switch-header-cs-class"
												data-class="bg-warm-flame header-text-dark"></div>
											<div
												class="swatch-holder bg-night-fade switch-header-cs-class"
												data-class="bg-night-fade header-text-dark"></div>
											<div
												class="swatch-holder bg-sunny-morning switch-header-cs-class"
												data-class="bg-sunny-morning header-text-dark"></div>
											<div
												class="swatch-holder bg-tempting-azure switch-header-cs-class"
												data-class="bg-tempting-azure header-text-dark"></div>
											<div class="swatch-holder bg-amy-crisp switch-header-cs-class"
												data-class="bg-amy-crisp header-text-dark"></div>
											<div
												class="swatch-holder bg-heavy-rain switch-header-cs-class"
												data-class="bg-heavy-rain header-text-dark"></div>
											<div
												class="swatch-holder bg-mean-fruit switch-header-cs-class"
												data-class="bg-mean-fruit header-text-dark"></div>
											<div
												class="swatch-holder bg-malibu-beach switch-header-cs-class"
												data-class="bg-malibu-beach header-text-light"></div>
											<div class="swatch-holder bg-deep-blue switch-header-cs-class"
												data-class="bg-deep-blue header-text-dark"></div>
											<div
												class="swatch-holder bg-ripe-malin switch-header-cs-class"
												data-class="bg-ripe-malin header-text-light"></div>
											<div
												class="swatch-holder bg-arielle-smile switch-header-cs-class"
												data-class="bg-arielle-smile header-text-light"></div>
											<div
												class="swatch-holder bg-plum-plate switch-header-cs-class"
												data-class="bg-plum-plate header-text-light"></div>
											<div
												class="swatch-holder bg-happy-fisher switch-header-cs-class"
												data-class="bg-happy-fisher header-text-dark"></div>
											<div
												class="swatch-holder bg-happy-itmeo switch-header-cs-class"
												data-class="bg-happy-itmeo header-text-light"></div>
											<div
												class="swatch-holder bg-mixed-hopes switch-header-cs-class"
												data-class="bg-mixed-hopes header-text-light"></div>
											<div
												class="swatch-holder bg-strong-bliss switch-header-cs-class"
												data-class="bg-strong-bliss header-text-light"></div>
											<div
												class="swatch-holder bg-grow-early switch-header-cs-class"
												data-class="bg-grow-early header-text-light"></div>
											<div class="swatch-holder bg-love-kiss switch-header-cs-class"
												data-class="bg-love-kiss header-text-light"></div>
											<div
												class="swatch-holder bg-premium-dark switch-header-cs-class"
												data-class="bg-premium-dark header-text-light"></div>
											<div
												class="swatch-holder bg-happy-green switch-header-cs-class"
												data-class="bg-happy-green header-text-light"></div>
										</div>
									</li>
								</ul>
							</div>

							<div class="p-3">
								<ul class="list-group">
									<li class="list-group-item">
										<h5 class="pb-2">Choose Color Scheme</h5>
										<div class="theme-settings-swatches">
											<div class="swatch-holder bg-primary switch-sidebar-cs-class"
												data-class="bg-primary sidebar-text-light"></div>
											<div
												class="swatch-holder bg-secondary switch-sidebar-cs-class"
												data-class="bg-secondary sidebar-text-light"></div>
											<div class="swatch-holder bg-success switch-sidebar-cs-class"
												data-class="bg-success sidebar-text-dark"></div>
											<div class="swatch-holder bg-info switch-sidebar-cs-class"
												data-class="bg-info sidebar-text-dark"></div>
											<div class="swatch-holder bg-warning switch-sidebar-cs-class"
												data-class="bg-warning sidebar-text-dark"></div>
											<div class="swatch-holder bg-danger switch-sidebar-cs-class"
												data-class="bg-danger sidebar-text-light"></div>
											<div class="swatch-holder bg-light switch-sidebar-cs-class"
												data-class="bg-light sidebar-text-dark"></div>
											<div class="swatch-holder bg-dark switch-sidebar-cs-class"
												data-class="bg-dark sidebar-text-light"></div>
											<div class="swatch-holder bg-focus switch-sidebar-cs-class"
												data-class="bg-focus sidebar-text-light"></div>
											<div
												class="swatch-holder bg-alternate switch-sidebar-cs-class"
												data-class="bg-alternate sidebar-text-light"></div>
											<div class="divider"></div>
											<div
												class="swatch-holder bg-vicious-stance switch-sidebar-cs-class"
												data-class="bg-vicious-stance sidebar-text-light"></div>
											<div
												class="swatch-holder bg-midnight-bloom switch-sidebar-cs-class"
												data-class="bg-midnight-bloom sidebar-text-light"></div>
											<div
												class="swatch-holder bg-night-sky switch-sidebar-cs-class"
												data-class="bg-night-sky sidebar-text-light"></div>
											<div
												class="swatch-holder bg-slick-carbon switch-sidebar-cs-class"
												data-class="bg-slick-carbon sidebar-text-light"></div>
											<div class="swatch-holder bg-asteroid switch-sidebar-cs-class"
												data-class="bg-asteroid sidebar-text-light"></div>
											<div class="swatch-holder bg-royal switch-sidebar-cs-class"
												data-class="bg-royal sidebar-text-light"></div>
											<div
												class="swatch-holder bg-warm-flame switch-sidebar-cs-class"
												data-class="bg-warm-flame sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-night-fade switch-sidebar-cs-class"
												data-class="bg-night-fade sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-sunny-morning switch-sidebar-cs-class"
												data-class="bg-sunny-morning sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-tempting-azure switch-sidebar-cs-class"
												data-class="bg-tempting-azure sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-amy-crisp switch-sidebar-cs-class"
												data-class="bg-amy-crisp sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-heavy-rain switch-sidebar-cs-class"
												data-class="bg-heavy-rain sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-mean-fruit switch-sidebar-cs-class"
												data-class="bg-mean-fruit sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-malibu-beach switch-sidebar-cs-class"
												data-class="bg-malibu-beach sidebar-text-light"></div>
											<div
												class="swatch-holder bg-deep-blue switch-sidebar-cs-class"
												data-class="bg-deep-blue sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-ripe-malin switch-sidebar-cs-class"
												data-class="bg-ripe-malin sidebar-text-light"></div>
											<div
												class="swatch-holder bg-arielle-smile switch-sidebar-cs-class"
												data-class="bg-arielle-smile sidebar-text-light"></div>
											<div
												class="swatch-holder bg-plum-plate switch-sidebar-cs-class"
												data-class="bg-plum-plate sidebar-text-light"></div>
											<div
												class="swatch-holder bg-happy-fisher switch-sidebar-cs-class"
												data-class="bg-happy-fisher sidebar-text-dark"></div>
											<div
												class="swatch-holder bg-happy-itmeo switch-sidebar-cs-class"
												data-class="bg-happy-itmeo sidebar-text-light"></div>
											<div
												class="swatch-holder bg-mixed-hopes switch-sidebar-cs-class"
												data-class="bg-mixed-hopes sidebar-text-light"></div>
											<div
												class="swatch-holder bg-strong-bliss switch-sidebar-cs-class"
												data-class="bg-strong-bliss sidebar-text-light"></div>
											<div
												class="swatch-holder bg-grow-early switch-sidebar-cs-class"
												data-class="bg-grow-early sidebar-text-light"></div>
											<div
												class="swatch-holder bg-love-kiss switch-sidebar-cs-class"
												data-class="bg-love-kiss sidebar-text-light"></div>
											<div
												class="swatch-holder bg-premium-dark switch-sidebar-cs-class"
												data-class="bg-premium-dark sidebar-text-light"></div>
											<div
												class="swatch-holder bg-happy-green switch-sidebar-cs-class"
												data-class="bg-happy-green sidebar-text-light"></div>
										</div>
									</li>
								</ul>
							</div>

							<div class="p-3">
								<ul class="list-group">
									<li class="list-group-item">
										<h5 class="pb-2">Page Section Tabs</h5>
										<div class="theme-settings-swatches">
											<div role="group" class="mt-2 btn-group">
												<button type="button"
													class="btn-wide btn-shadow btn-primary btn btn-secondary
													switch-theme-class"
													data-class="body-tabs-line">Line</button>
												<button type="button"
													class="btn-wide btn-shadow btn-primary active btn btn-secondary
													switch-theme-class"
													data-class="body-tabs-shadow">Shadow</button>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="app-main">
				<div class="app-sidebar sidebar-shadow">
					<div class="app-header__logo">
						<div class="logo-src"></div>
						<div class="header__pane ml-auto">
							<div>
								<button type="button"
									class="hamburger close-sidebar-btn hamburger--elastic"
									data-class="closed-sidebar">
									<span class="hamburger-box"> <span
											class="hamburger-inner"></span>
									</span>
								</button>
							</div>
						</div>
					</div>
					<div class="app-header__mobile-menu">
						<div>
							<button type="button"
								class="hamburger hamburger--elastic mobile-toggle-nav">
								<span class="hamburger-box"> <span class="hamburger-inner"></span>
								</span>
							</button>
						</div>
					</div>
					<div class="app-header__menu">
						<span>
							<button type="button"
								class="btn-icon btn-icon-only btn btn-primary btn-sm
								mobile-toggle-header-nav">
								<span class="btn-icon-wrapper"> <i
										class="fa fa-ellipsis-v fa-w-6"></i>
								</span>
							</button>
						</span>
					</div>
					<jsp:include page="sidebar.jsp" />
				</div>
				<div class="app-main__outer">
					<div class="app-wrapper-footer">
						<div class="app-footer">
							<div class="app-footer__inner"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
						</div>
						<div class="col-sm-6" style=" margin:0 auto;
							width:500px; text-align:center;">
							<br>
							<br>
							<form id="myForm">
								<!-- Form fields and inputs go here -->
								<label>Name : </label>
								<input type="text" placeholder="Name" id="input1"
									class="categoryName2"><br>
								<div class="text-center">
									<input class="button-91"
										type="submit" value="Add" onclick="addCategoryByAdmin();"
										style="margin-top: 30px;">
								</div>
							</form>
							<br>
						</div>
						<div class="col-sm-3">
						</div>

					</div>
					<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
				</div>
			</div>

			<script type="text/javascript">
		function addCategory() {
			document.getElementById('myForm2').reset();
			document.getElementById('myForm2').style.display = 'none';
			const addButton = document.getElementById('addCat');
			const form = document.getElementById('myForm');
			addButton.addEventListener('click', function() {
				form.style.display = 'block'; // Show the form
			});
			form.addEventListener('submit', function(event) {
				event.preventDefault();
				form.reset();
				form.style.display = 'none';
			});
		}

		function addSubCategory() {
			document.getElementById('myForm').reset();
			document.getElementById('myForm').style.display = 'none';
			const addButton = document.getElementById('addSubCat');
			const form = document.getElementById('myForm2');
			addButton.addEventListener('click', function() {
				form.style.display = 'block'; // Show the form
			});
			form.addEventListener('submit', function(event) {
				event.preventDefault();
				form.reset();
				form.style.display = 'none';
			});
		}
	</script>
			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
			<script
				src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<script src="js/dashboard.js"></script>
		</body>
	</html>
