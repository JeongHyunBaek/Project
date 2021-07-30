<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>포인트조회</title>
	<!--
            CSS
            ============================================= -->
         ============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/linearicons.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/nouislider.min.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
	<style type="text/css">
	.point{
	text-align : center;

	}
	.page_wrap {
	text-align:center;
	font-size:0;
 }
.page_nation {
	display:inline-block;
}
.page_nation .none {
	display:none;
}
.page_nation a {
	display:block;
	margin:0 3px;
	float:left;
	border:1px solid #e6e6e6;
	width:28px;
	height:28px;
	line-height:28px;
	text-align:center;
	background-color:#fff;
	font-size:13px;
	color:#999999;
	text-decoration:none;
}
.page_nation .arrow {
	border:1px solid #ccc;
}
.page_nation .pprev {
	background:#f8f8f8 url('img/page_pprev.png') no-repeat center center;
	margin-left:0;
}
.page_nation .prev {
	background:#f8f8f8 url('img/page_prev.png') no-repeat center center;
	margin-right:7px;
}
.page_nation .next {
	background:#f8f8f8 url('img/page_next.png') no-repeat center center;
	margin-left:7px;
}
.page_nation .nnext {
	background:#f8f8f8 url('img/page_nnext.png') no-repeat center center;
	margin-right:0;
}
.page_nation a.active {
	background-color:#42454c;
	color:#fff;
	border:1px solid #42454c;
}
	</style>
</head>

<body>

	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="index.html"><img src="img/logo.png" alt=""></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">Shop</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="category.html">Shop Category</a></li>
									<li class="nav-item"><a class="nav-link" href="single-product.html">Product Details</a></li>
									<li class="nav-item"><a class="nav-link" href="checkout.html">Product Checkout</a></li>
									<li class="nav-item"><a class="nav-link" href="cart.html">Shopping Cart</a></li>
									<li class="nav-item"><a class="nav-link" href="confirmation.html">Confirmation</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">Blog</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
									<li class="nav-item"><a class="nav-link" href="single-blog.html">Blog Details</a></li>
								</ul>
							</li>
							<li class="nav-item submenu dropdown">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">Pages</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
									<li class="nav-item"><a class="nav-link" href="tracking.html">Tracking</a></li>
									<li class="nav-item"><a class="nav-link" href="elements.html">Elements</a></li>
								</ul>
							</li>
							<li class="nav-item active"><a class="nav-link" href="contact.html">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item"><a href="#" class="cart"><span class="ti-bag"></span></a></li>
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container">
				<form class="d-flex justify-content-between">
					<input type="text" class="form-control" id="search_input" placeholder="Search Here">
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
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Mypage</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Mypage</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	
	<!--================Contact Area =================-->
	<section>
<div width="960px"><br><br><br>
<h2 align="center">포인트 조회</h2>
<hr width="960px" color="black">
<center>총 적립금 : -,---원</center>
<hr width="960px" color="black">
</div>
<div><table border="1" summary="적립 내역 목록 입니다" class="point" align="center">
<caption></caption>
    
        <colgroup >
<col width="15%">
<col width="15%">
<col width="25%">
<col width="auto">
</colgroup>
<thead><tr>
<th scope="col">주문날짜</th>
                <th scope="col">적립금</th>
                <th scope="col">관련 주문</th>
                <th scope="col">적립내용</th>
            </tr></thead>
<tbody class="pointtable">
<tr class="first xans-record-">
<td>2020-04-30</td>
                <td class="mileage">-390원</td>
                <td><a href="/myshop/order/detail.html?order_id="></a></td>
                <td>1년마다 한번씩 소멸예정인 적립금을 당일 예약합니다.</td>
            </tr>
<tr class="xans-record-">
<td>2018-06-13</td>
                <td class="mileage">130원</td>
                <td><a href="/myshop/order/detail.html?order_id=20180601-0004546">20180601-0004546</a></td>
                <td>구매에 대한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2018-06-10</td>
                <td class="mileage">40원</td>
                <td><a href="/myshop/order/detail.html?order_id=20180601-0004546">20180601-0004546</a></td>
                <td>구매에 대한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2018-06-10</td>
                <td class="mileage">100원</td>
                <td><a href="/myshop/order/detail.html?order_id=20180601-0004546">20180601-0004546</a></td>
                <td>구매에 대한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2018-06-10</td>
                <td class="mileage">120원</td>
                <td><a href="/myshop/order/detail.html?order_id=20180601-0004546">20180601-0004546</a></td>
                <td>구매에 대한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2018-06-01</td>
                <td class="mileage">-750원</td>
                <td><a href="/myshop/order/detail.html?order_id=20180601-0004546">20180601-0004546</a></td>
                <td>상품구매시 사용한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2017-10-25</td>
                <td class="mileage">70원</td>
                <td><a href="/myshop/order/detail.html?order_id=20171008-0036459">20171008-0036459</a></td>
                <td>구매에 대한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2017-10-25</td>
                <td class="mileage">180원</td>
                <td><a href="/myshop/order/detail.html?order_id=20171008-0036459">20171008-0036459</a></td>
                <td>구매에 대한 적립금</td>
            </tr>
<tr class="xans-record-">
<td>2017-10-20</td>
                <td class="mileage">500원</td>
                <td><a href="/myshop/order/detail.html?order_id=&nbsp;">&nbsp;</a></td>
                <td>6일이상배송지연적립금</td>
            </tr>
<tr class="xans-record-">
<td>2017-10-08</td>
                <td class="mileage">-970원</td>
                <td><a href="/myshop/order/detail.html?order_id=20171008-0036459">20171008-0036459</a></td>
                <td>상품구매시 사용한 적립금</td>
            </tr>
</tbody>

<!-- <tbody class="displaynone"><tr>
<td colspan="4" class="nodata">적립내역이 없습니다.</td>
            </tr></tbody> -->
            
</table>
 <div class="page_wrap">
   <div class="page_nation">
      <a class="arrow pprev" href="#"></a>
      <a class="arrow prev" href="#"></a>
      <a href="#" class="active">1</a>
      <a href="#">2</a>
      <a href="#">3</a>
      <a href="#">4</a>
      <a href="#">5</a>
      <a href="#">6</a>
      <a href="#">7</a>
      <a href="#">8</a>
      <a href="#">9</a>
      <a href="#">10</a>
      <a class="arrow next" href="#"></a>
      <a class="arrow nnext" href="#"></a>
   </div>
   
</div></div><hr><center><a href="#" class="genric-btn primary">목록보기</a></center><br><br><br>
</section>
	<!--================Contact Area =================-->

	<!-- start footer Area -->
	<footer class="footer-area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>About Us</h6>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore
							magna aliqua.
						</p>
					</div>
				</div>
				<div class="col-lg-4  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Newsletter</h6>
						<p>Stay update with our latest</p>
						<div class="" id="mc_embed_signup">

							<form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
							 method="get" class="form-inline">

								<div class="d-flex flex-row">

									<input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '"
									 required="" type="email">


									<button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
									<div style="position: absolute; left: -5000px;">
										<input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
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
							<li><img src="img/i1.jpg" alt=""></li>
							<li><img src="img/i2.jpg" alt=""></li>
							<li><img src="img/i3.jpg" alt=""></li>
							<li><img src="img/i4.jpg" alt=""></li>
							<li><img src="img/i5.jpg" alt=""></li>
							<li><img src="img/i6.jpg" alt=""></li>
							<li><img src="img/i7.jpg" alt=""></li>
							<li><img src="img/i8.jpg" alt=""></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6>Follow Us</h6>
						<p>Let us be social</p>
						<div class="footer-social d-flex align-items-center">
							<a href="#"><i class="fa fa-facebook"></i></a>
							<a href="#"><i class="fa fa-twitter"></i></a>
							<a href="#"><i class="fa fa-dribbble"></i></a>
							<a href="#"><i class="fa fa-behance"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
				<p class="footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
</p>
			</div>
		</div>
	</footer>
	<!-- End footer Area -->

	<!--================Contact Success and Error message Area =================-->
	<div id="success" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Thank you</h2>
					<p>Your message is successfully sent...</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Modals error -->

	<div id="error" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Sorry !</h2>
					<p> Something went wrong </p>
				</div>
			</div>
		</div>
	</div>
	<!--================End Contact Success and Error message Area =================-->


	
		<script src="/Shoesgone/resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="/Shoesgone/resources/js/vendor/bootstrap.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.nice-select.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.sticky.js"></script>
	<script src="/Shoesgone/resources/js/nouislider.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="/Shoesgone/resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="/Shoesgone/resources/js/gmaps.min.js"></script>
	<script src="/Shoesgone/resources/js/main.js"></script>
</body>

</html>