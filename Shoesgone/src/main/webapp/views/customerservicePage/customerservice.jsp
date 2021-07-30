<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<title>고객센터</title>
<script type="text/javascript" src="/Shoesgone/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("table *").css('width','100%');
	$("table *").css('border-top','1px');
	$("table *").css('color','blue');
}
</script>
<!--
            CSS
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
#floatdiv {

    position:fixed; _position:absolute; _z-index:-1;

    width:100px;

    display:inline-block;/* overflow:hidden;  같은 의미? */

    right:0px; /* //화면 오른쪽에 위치한다. left로 변경가능 */

    top:20%; /* //화면 위쪽과의 간격 */

    background-color: transparent;

    margin:0;

}

#floatdiv ul  { list-style: none; }

#floatdiv li  { margin-bottom: 2px; text-align: left; }

#floatdiv a   { color: #5D5D5D; border: 0; text-decoration: none; display: float; }

#floatdiv a:hover, #floatdiv .menu  { background-color: #5D5D5D; color: #fff; } /* 마우스오버 시 배경/글씨 색깔 */

#floatdiv .menu, #floatdiv .last    { margin-bottom: 0px; }

 

 

#floatContent {

    padding:5px;

border-width: 2px;

border-color: #7f7f7f;

border-style: solid;

border-bottom-left-radius: 10px;

border-bottom-right-radius: 10px;

}

 

#floatTitle {

width:100px;

height:30px;

line-height:30px;

background-color: #7f7f7f;

/* 텍스트 */

color: #fff;

text-align: center;

text-decoration: none;

font-weight:bold;

font-size:12px;

/* 모양 */

border-top-left-radius: 10px;

border-top-right-radius: 10px;

 

}
.sub_news{
 font-size: 16px;

 
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
					<a class="navbar-brand logo_h" href="index.html"><img
						src="img/logo.png" alt=""></a>
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
							<li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="category.html">Shop Category</a></li>
									<li class="nav-item"><a class="nav-link"
										href="single-product.html">Product Details</a></li>
									<li class="nav-item"><a class="nav-link"
										href="checkout.html">Product Checkout</a></li>
									<li class="nav-item"><a class="nav-link" href="cart.html">Shopping
											Cart</a></li>
									<li class="nav-item"><a class="nav-link"
										href="confirmation.html">Confirmation</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Blog</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
									<li class="nav-item"><a class="nav-link"
										href="single-blog.html">Blog Details</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
									<li class="nav-item"><a class="nav-link"
										href="tracking.html">Tracking</a></li>
									<li class="nav-item"><a class="nav-link"
										href="elements.html">Elements</a></li>
								</ul></li>
							<li class="nav-item active"><a class="nav-link"
								href="contact.html">Contact</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item"><a href="#" class="cart"><span
									class="ti-bag"></span></a></li>
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
					<h1>CustomerSerive</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">CustomerSerive</a>
					</nav>
				</div>
			</div>
		</div>
	</section>

	<!--================Contact Area =================-->
	<section><br><br><br>
	<h2 align="center">고객센터</h2><hr>
		<section class="product_description_area">
			<div class="container">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item"><a class="nav-link" id="home-tab"
						data-toggle="tab" href="#home" role="tab" aria-controls="home"
						aria-selected="true">공지사항</a></li>
					<li class="nav-item"><a class="nav-link" id="profile-tab"
						data-toggle="tab" href="#profile" role="tab"
						aria-controls="profile" aria-selected="false">자주묻는질문</a></li>
					<li class="nav-item"><a class="nav-link" id="contact-tab"
						data-toggle="tab" href="#contact" role="tab"
						aria-controls="contact" aria-selected="false">1:1문의</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade" id="home" role="tabpanel"
						aria-labelledby="home-tab">
						<!-- 리스트 게시판 시작-->
						
						<table class="sub_news" border="0" cellpadding="7px"
							summary="게시판의 글제목 리스트" align="center">
							
							<colgroup>
								<col width="50" >
								<col width="450">
								<col width="150">
								<col width="100">
								<col width="100">
							</colgroup>
							<thead style="border-bottom:0.5px solid #444444 ; border-collapse : collapse;
							"
							>
								<tr >
								    <th scope="col" style = "text-align:center; font-color:orange;">번호</th>
									<th scope="col" style = "text-align:center">제목</th>
									<th scope="col" style = "text-align:center">작성자</th>
									<th scope="col" style = "text-align:center">작성일</th>
									<th scope="col" style = "text-align:center">조회수</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
								
								<td class="number" style = "text-align:center">1</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<td class="number" style = "text-align:center">2</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목2</a></td>
									<td class="name" style = "text-align:center">글쓴이이름2</td>
									<td class="date" style = "text-align:center">2008-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">3</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">4</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">5</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<!-- -->
								
							</tbody>
						</table><br><br>
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
</div>
						<!-- 리스트 게시판 끝-->
					</div>
					<div class="tab-pane fade" id="profile" role="tabpanel"
						aria-labelledby="profile-tab">
						<table class="sub_news" border="0" cellpadding="7px"
							summary="게시판의 글제목 리스트" align="center">
							
							<colgroup>
								<col width="50" >
								<col width="450">
								<col width="150">
								<col width="100">
								<col width="100">
							</colgroup>
							<thead style="border-bottom:0.5px solid #444444 ; border-collapse : collapse;
							"
							>
								<tr >
								    <th scope="col" style = "text-align:center; font-color:orange;">번호</th>
									<th scope="col" style = "text-align:center">제목</th>
									<th scope="col" style = "text-align:center">작성자</th>
									<th scope="col" style = "text-align:center">작성일</th>
									<th scope="col" style = "text-align:center">조회수</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
								
								<td class="number" style = "text-align:center">1</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<td class="number" style = "text-align:center">2</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목2</a></td>
									<td class="name" style = "text-align:center">profile</td>
									<td class="date" style = "text-align:center">2008-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">3</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">4</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">5</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<!-- -->
							</tbody>
						</table><br><br>
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
</div>
						<!-- 리스트 게시판 끝-->
					</div>
					
					
					<div class="tab-pane fade" id="contact" role="tabpanel"
						aria-labelledby="contact-tab">
						<table class="sub_news" border="0" cellpadding="7px"
							summary="게시판의 글제목 리스트" align="center">
							
							<colgroup>
								<col width="50" >
								<col width="450">
								<col width="150">
								<col width="100">
								<col width="100">
							</colgroup>
							<thead style="border-bottom:0.5px solid #444444 ; border-collapse : collapse;
							"
							>
								<tr >
								    <th scope="col" style = "text-align:center; font-color:orange;">번호</th>
									<th scope="col" style = "text-align:center">제목</th>
									<th scope="col" style = "text-align:center">작성자</th>
									<th scope="col" style = "text-align:center">작성일</th>
									<th scope="col" style = "text-align:center">조회수</th>
									
								</tr>
							</thead>
							<tbody>
								<tr>
								
								<td class="number" style = "text-align:center">1</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<td class="number" style = "text-align:center">2</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목2</a></td>
									<td class="name" style = "text-align:center">글쓴이이름2</td>
									<td class="date" style = "text-align:center">2008-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">3</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">4</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">5</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<tr>
								
								<td class="number" style = "text-align:center">6</td>
									<td class="title" style = "text-align:center"><a href="#">게시판 제목
										</td>
									<td class="name" style = "text-align:center">글쓴이이름</td>
									<td class="date" style = "text-align:center">2021-01-01</td>
									<td class="hit" style = "text-align:center">1234</td>
								</tr>
								<!-- -->
							</tbody>
							
						</table><br>
						<center><a href="customerwrite.html"><input type="submit" value="작성하기" class="genric-btn primary small"></a>
						</center>
						
						 <br>
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
</div>
						</div>
							 
						
						
						
						</div>
					<br><center><a href="#" class="genric-btn primary">목록보기</a></center>
						<!-- 리스트 게시판 끝-->
					<div id="floatdiv">

<div id="floatTitle">상담채널</div>

<div id="floatContent">

<ul>

<li>

<img src="/Shoesgone/resources/img/kakach.png" width = "80px"><a href="#"></a>

</li>

<li>

<img src="/Shoesgone/resources/img/chatbot.jpg" width = "80px"><a href="#"></a>

</li>

</ul>

</div>

</div>

<!-- //floatMenu -->
		</section>
		<!--================Contact Area =================-->

		<!-- start footer Area -->
		<footer class="footer-area section_gap">
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-md-6 col-sm-6">
						<div class="single-footer-widget">
							<h6>About Us</h6>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore dolore magna aliqua.
							</p>
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

		<!--================Contact Success and Error message Area =================-->
		<div id="success" class="modal modal-message fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
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
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<i class="fa fa-close"></i>
						</button>
						<h2>Sorry !</h2>
						<p>Something went wrong</p>
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