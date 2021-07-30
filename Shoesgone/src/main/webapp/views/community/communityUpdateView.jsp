<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="../../resources/img/fav.png">
<!-- Author Meta -->
<meta name="author" content="CodePixar">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>슈즈곤</title>

<!--
            CSS
            ============================================= -->
<link rel="stylesheet" href="../../resources/css/linearicons.css">
<link rel="stylesheet" href="../../resources/css/owl.carousel.css">
<link rel="stylesheet" href="../../resources/css/themify-icons.css">
<link rel="stylesheet" href="../../resources/css/font-awesome.min.css">
<link rel="stylesheet" href="../../resources/css/nice-select.css">
<link rel="stylesheet" href="../../resources/css/nouislider.min.css">
<link rel="stylesheet" href="../../resources/css/bootstrap.css">
<link rel="stylesheet" href="../../resources/css/main.css">
</head>

<body>

	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="index.jsp"><img
						src="../../resources/img/logo.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="blog.jsp">Blog</a></li>
									<li class="nav-item"><a class="nav-link"
										href="single-blog.jsp">Blog Details</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown active"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Community
									Category</a>
								<ul class="dropdown-menu">
									<li class="nav-item active"><a class="nav-link"
										href="category.jsp">Best 게시판</a></li>
									<li class="nav-item"><a class="nav-link"
										href="single-product.jsp">리뷰 게시판</a></li>
									<li class="nav-item"><a class="nav-link"
										href="checkout.jsp">Gallery</a></li>
									<li class="nav-item"><a class="nav-link" href="cart.jsp">자유게시판</a></li>
									<li class="nav-item"><a class="nav-link"
										href="confirmation.jsp">Q&A</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link" href="contact.jsp">고객센터</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">로그인</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
									<li class="nav-item"><a class="nav-link"
										href="tracking.jsp">Tracking</a></li>
									<li class="nav-item"><a class="nav-link"
										href="elements.jsp">Elements</a></li>
								</ul></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item">
								<button class="search">
									<span class="lnr lnr-magnifier" id="search"></span>
								</button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container">
				<form class="d-flex justify-content-between">
					<input type="text" class="form-control" id="search_input"
						placeholder="Search Here">
					<button type="submit" class="btn"></button>
					<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
				</form>
			</div>
		</div>
	</header>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Checkout</h1>
					<nav class="d-flex align-items-center">
						<a href="index.jsp">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="single-product.jsp">Checkout</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Checkout Area =================-->
	<section class="checkout_area section_gap">
		<div class="container">


			<div class="billing_details">
				<div class="row">
					<div class="col-lg-8">
						<h3>글 수정하기</h3>
						<form class="row contact_form" action="#" method="post"
							novalidate="novalidate">
							<div class="col-md-6 form-group p_star">
								<select class="country_select">
									<option value="1">게시판을 선택해 주세요</option>
									<div></div>
									<option value="2">리뷰 게시판</option>
									<option value="3">갤러리</option>
									<option value="4">자유게시판</option>
									<option value="5">Q&A</option>
								</select>
							</div>
							<div class="button-group-area mt-40"> 
							<a onclick="javascript:history.go(-1); return false;" class="genric-btn primary circle arrow">취소<span class="lnr lnr-arrow-right"></span></a>
							<a type="submit" class="genric-btn primary circle arrow">등록<span class="lnr lnr-arrow-right"></span></a> 
							<a onclick="javascript:history.go(-1); return false;" class="genric-btn primary circle arrow">목록<span class="lnr lnr-arrow-right"></span></a>
							</div>
							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="first" name="name">
								<span class="placeholder" data-placeholder="제목을 입력해주세요"></span>
							</div>
							<div class="col-md-12 form-group p_star">
								<tr><th>첨부파일: </th><td><input type="file" name="upfile"></td></tr>
							</div>
							<div class="col-md-12 form-group p_star">
								<textarea class="form-control" name="message" id="message" rows="1"
									placeholder="내용을 입력해주세요."></textarea>
							</div>
						</form>
					</div>
					<div class="col-lg-4">
						<div class="order_box">
							<h2>설정</h2>
							<ul class="set_list">
								<li class="set_item"><div class="FormInputCheck">
										<input id="coment" type="checkbox" class="input_check"><label
											for="coment" class="label"> 댓글 허용 </label>
									</div></li>
								<li class="set_item"><div class="FormInputCheck">
										<input id="external_sharing" type="checkbox"
											class="input_check"><label for="external_sharing"
											class="label"> 외부 공유 허용 </label>
									</div></li>
								<li class="set_item"><div class="FormInputCheck">
										<input id="copy" type="checkbox" class="input_check"><label
											for="copy" class="label"> 복사 · 저장 허용 </label>
									</div></li>
								<li class="set_item"><div class="FormInputCheck">
										<input id="automatic_source" type="checkbox"
											class="input_check"><label for="automatic_source"
											class="label"> 자동출처 사용 </label>
									</div></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Checkout Area =================-->

	<!-- start footer Area -->
	<footer class="footer-area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>About Us</h6>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore dolore magna aliqua.</p>
					</div>
				</div>
				<div class="col-lg-4  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Newsletter</h6>
						<p>Stay update with our latest</p>
						<div class="" id="mc_embed_signup">

							<form target="_blank" novalidate="true"
								action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
								method="get" class="form-inline">

								<div class="d-flex flex-row">

									<input class="form-control" name="EMAIL"
										placeholder="Enter Email" onfocus="this.placeholder = ''"
										onblur="this.placeholder = 'Enter Email '" required=""
										type="email">


									<button class="click-btn btn btn-default">
										<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
									</button>
									<div style="position: absolute; left: -5000px;">
										<input name="b_36c4fd991d266f23781ded980_aefe40901a"
											tabindex="-1" value="" type="text">
									</div>

									<!-- <div class="col-lg-4 col-md-4">
													<button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button>
												</div>  -->
								</div>
								<div class="info"></div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget mail-chimp">
						<h6 class="mb-20">Instragram Feed</h6>
						<ul class="instafeed d-flex flex-wrap">
							<li><img src="../../resources/img/i1.jpg" alt=""></li>
							<li><img src="../../resources/img/i2.jpg" alt=""></li>
							<li><img src="../../resources/img/i3.jpg" alt=""></li>
							<li><img src="../../resources/img/i4.jpg" alt=""></li>
							<li><img src="../../resources/img/i5.jpg" alt=""></li>
							<li><img src="../../resources/img/i6.jpg" alt=""></li>
							<li><img src="../../resources/img/i7.jpg" alt=""></li>
							<li><img src="../../resources/img/i8.jpg" alt=""></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Follow Us</h6>
						<p>Let us be social</p>
						<div class="footer-social d-flex align-items-center">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-dribbble"></i></a> <a href="#"><i
								class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div
				class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
				<p class="footer-text m-0">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					Copyright &copy;
					<script>
						document.write(new Date().getFullYear());
					</script>
					All rights reserved | This template is made with <i
						class="fa fa-heart-o" aria-hidden="true"></i> by <a
						href="https://colorlib.com" target="_blank">Colorlib</a>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>
			</div>
		</div>
	</footer>
	<!-- End footer Area -->


	<script src="../../resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script src="../../resources/js/vendor/bootstrap.min.js"></script>
	<script src="../../resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="../../resources/js/jquery.nice-select.min.js"></script>
	<script src="../../resources/js/jquery.sticky.js"></script>
	<script src="../../resources/js/nouislider.min.js"></script>
	<script src="../../resources/js/jquery.magnific-popup.min.js"></script>
	<script src="../../resources/js/owl.carousel.min.js"></script>
	
	
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="../../resources/js/gmaps.min.js"></script>
	<script src="../../resources/js/main.js"></script>
</body>
</html>