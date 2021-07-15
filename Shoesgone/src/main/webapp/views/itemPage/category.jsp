<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="loginPage.model.vo.Login"%>
<%
	// 로그인 확인을 위해서 내장된 session 객체를 이용
	Login loginMember = (Login)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<meta charset="UTF-8">
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="/Shoesgone/resources/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>SHOP</title>

	<!--
            CSS
            ============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/linearicons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nouislider.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/newMine.css">
</head>

<body id="category">

	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="/Shoesgone/index.jsp">슈즈곤</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/itemPage/category.jsp">SHOP</a></li>
							<li class="nav-item"><a class="nav-link" href="#">고객센터</a></li>
							<% if(loginMember == null){ %>
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/loginPage/login.jsp">로그인</a></li>
							<% }else{ %>
							<li class="nav-item"><a class="nav-link" onclick="javascript:location.href='/Shoesgone/logout';">로그아웃</a></li>
							<% } %>
						</ul>
						<ul class="nav navbar-nav navbar-right">
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
					<h1>SHOP</h1>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<div class="container">
		<div class="row">
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-categories">
					<div class="head">필터</div>
					<ul class="main-categories">
						<li class="main-nav-list"><a data-toggle="collapse" href="#fruitsVegetable" aria-expanded="false" aria-controls="fruitsVegetable"><span
								 class="lnr lnr-arrow-right"></span>카테고리<span class="number">(모든 카테고리)</span></a>
							<ul class="collapse" id="fruitsVegetable" data-toggle="collapse" aria-expanded="false" aria-controls="fruitsVegetable">
								<li class="main-nav-list child"><a href="#">스니커즈<span class="number">(13)</span></a></li>
								<li class="main-nav-list child"><a href="#">의류<span class="number">(09)</span></a></li>
								<li class="main-nav-list child"><a href="#">패션 잡화<span class="number">(17)</span></a></li>
								<li class="main-nav-list child"><a href="#">테크<span class="number">(01)</span></a></li>
								<li class="main-nav-list child"><a href="#">라이프<span class="number">(11)</span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
								 class="lnr lnr-arrow-right"></span>브랜드<span class="number">(모든 브랜드)</span></a>
							<ul class="collapse" id="meatFish" data-toggle="collapse" aria-expanded="false" aria-controls="meatFish">
								<li class="main-nav-list child"><a href="#">Frozen Fish<span class="number">(13)</span></a></li>
								<li class="main-nav-list child"><a href="#">Dried Fish<span class="number">(09)</span></a></li>
								<li class="main-nav-list child"><a href="#">Fresh Fish<span class="number">(17)</span></a></li>
								<li class="main-nav-list child"><a href="#">Meat Alternatives<span class="number">(01)</span></a></li>
								<li class="main-nav-list child"><a href="#">Meat<span class="number">(11)</span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#cooking" aria-expanded="false" aria-controls="cooking"><span
								 class="lnr lnr-arrow-right"></span>성별<span class="number">(모든 성별)</span></a>
							<ul class="collapse" id="cooking" data-toggle="collapse" aria-expanded="false" aria-controls="cooking">
								<li class="main-nav-list child"><a href="#">남성<span class="number">(13)</span></a></li>
								<li class="main-nav-list child"><a href="#">여성<span class="number">(09)</span></a></li>
								<li class="main-nav-list child"><a href="#">키즈<span class="number">(17)</span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#beverages" aria-expanded="false" aria-controls="beverages"><span
								 class="lnr lnr-arrow-right"></span>컬렉션<span class="number">(모든 컬렉션)</span></a>
							<ul class="collapse" id="beverages" data-toggle="collapse" aria-expanded="false" aria-controls="beverages">
								<li class="main-nav-list child"><a href="#">Frozen Fish<span class="number">(13)</span></a></li>
								<li class="main-nav-list child"><a href="#">Dried Fish<span class="number">(09)</span></a></li>
								<li class="main-nav-list child"><a href="#">Fresh Fish<span class="number">(17)</span></a></li>
								<li class="main-nav-list child"><a href="#">Meat Alternatives<span class="number">(01)</span></a></li>
								<li class="main-nav-list child"><a href="#">Meat<span class="number">(11)</span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#homeClean" aria-expanded="false" aria-controls="homeClean"><span
								 class="lnr lnr-arrow-right"></span>스니커즈 사이즈<span class="number">(모든 사이즈)</span></a>
							<ul class="collapse" id="homeClean" data-toggle="collapse" aria-expanded="false" aria-controls="homeClean">
								<!-- <li class="main-nav-list child"><a href="#">Frozen Fish<span class="number">(13)</span></a></li>
								<li class="main-nav-list child"><a href="#">Dried Fish<span class="number">(09)</span></a></li>
								<li class="main-nav-list child"><a href="#">Fresh Fish<span class="number">(17)</span></a></li>
								<li class="main-nav-list child"><a href="#">Meat Alternatives<span class="number">(01)</span></a></li>
								<li class="main-nav-list child"><a href="#">Meat<span class="number">(11)</span></a></li> -->
								<table style="margin-left: auto; margin-right: auto">
									<tr>
										<td><input type=button value="215" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="220" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="225" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="230" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="235" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="240" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="245" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="250" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="255" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="260" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="265" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="270" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="275" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="280" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="285" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="290" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="295" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="300" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="305" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="310" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="315" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="320" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="325" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="330" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
							</table>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#clothes" aria-expanded="false" aria-controls="clothes"><span 
								class="lnr lnr-arrow-right"></span>의류 사이즈<span class="number">(모든 사이즈)</span></a>
							<ul class="collapse" id="clothes" data-toggle="collapse" aria-expanded="false" aria-controls="clothes">
								<table  style="margin-left: auto; margin-right: auto">
									<tr>
										<td><input type=button value="XXS" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="XS" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="S" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="M" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="L" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="XL" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="XXL" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="XXXL" style="width: 105px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
							</table>
							<br>
							<table>
								<tr>
										<td><input type=button value="28" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="29" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="30" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="31" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="32" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="33" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="34" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="35" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
										<td><input type=button value="36" style="width: 70px; height: 35px; background-color: white; border-color: grey;" onclick="location.href='#'"></td>
									</tr>
							</table>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#officeProduct" aria-expanded="false" aria-controls="officeProduct"><span
								 class="lnr lnr-arrow-right"></span>가격<span class="number">(모든 가격)</span></a>
							<ul class="collapse" id="officeProduct" data-toggle="collapse" aria-expanded="false" aria-controls="officeProduct">
								<li class="main-nav-list child"><a href="#">10만원 이하<span class="number">(13)</span></a></li>
								<li class="main-nav-list child"><a href="#">10만원 - 30만원 이하<span class="number">(09)</span></a></li>
								<li class="main-nav-list child"><a href="#">30만원 - 50만원 이하<span class="number">(17)</span></a></li>
								<li class="main-nav-list child"><a href="#">50만원 이상<span class="number">(01)</span></a></li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="sidebar-filter mt-50">
					<!-- <div class="top-filter-head">Product Filters</div> -->
					<div>
						<!-- <div class="head">Brands</div> -->
						<form action="#">
							<!-- <ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">Apple<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="asus" name="brand"><label for="asus">Asus<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="gionee" name="brand"><label for="gionee">Gionee<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="micromax" name="brand"><label for="micromax">Micromax<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="samsung" name="brand"><label for="samsung">Samsung<span>(19)</span></label></li>
							</ul> -->
						</form>
					</div>
					<div>
						<!-- <div class="head">Color</div> -->
						<form action="#">
							<!-- <ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="black" name="color"><label for="black">Black<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="balckleather" name="color"><label for="balckleather">Black
										Leather<span>(29)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="blackred" name="color"><label for="blackred">Black
										with red<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="gold" name="color"><label for="gold">Gold<span>(19)</span></label></li>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="spacegrey" name="color"><label for="spacegrey">Spacegrey<span>(19)</span></label></li>
							</ul> -->
						</form>
					</div>
					<div>
						<!-- <div class="head">Price</div> -->
						<div class="price-range-area">
							<div></div>
							<div class="value-wrapper d-flex">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					
					<div class="sorting mr-auto">
					</div>
					<div>		
						<div class="sorting">
						<select>
							<option value="1">인기순</option>
							<option value="1">프리미엄순</option>
							<option value="1">즉시 구매가순</option>
							<option value="1">즉시 판매가순</option>
							<option value="1">발매일순</option>
						</select>
					</div>
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row">
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p1.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p2.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p3.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p2.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p2.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p2.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p4.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p5.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p6.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p6.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p6.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<img class="img-fluid" src="/Shoesgone/resources/img/product/p6.jpg" alt="">
								<div class="product-details">
									<h6>addidas New Hammer sole
										for Sports person</h6>
									<div class="price">
										<h6>$150.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				<div>
					<div class="sorting mr-auto">
					</div>
					<div class="pagination">
					</div>
				</div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>
	
	<!-- Start exclusive deal Area -->
	<section class="exclusive-deal-area">
		<div class="container-fluid">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-6 no-padding exclusive-left">
					<div class="row clock_sec clockdiv" id="clockdiv">
						<div class="col-lg-12">
							<p>SERVICE GUIDE</p>
							<h1>슈즈곤 처음이지? <br>서비스 소개를 확인해보세요.</h1>
						</div>
					</div>
					<a href="blog.html" class="primary-btn">서비스 안내</a>
				</div>
				<div class="col-lg-6 no-padding exclusive-right">
						<!-- single exclusive carousel -->
						<div class="single-exclusive-slider">
							<img  class="img-fluid" src="/Shoesgone/resources/img/product/e-p1.png" alt="">
							<div class="product-details">
								<div class="price">
									<h6>$150.00</h6>
									<h6 class="l-through">$210.00</h6>
								</div>
								<p>DOWNLOAD THE APP</p>
								<h4>슈즈곤 앱을 설치하여<br> 한정판 스니커즈를 FLEX 하세요!</h4>
								<div class="add-bag d-flex align-items-center justify-content-center">
									<a href="appInstall.html" class="primary-btn" onclick="window.open(this.href, '_blank', 'width=500px, height=500px, toolbars=no, scrollbars=yes'); return false;">앱 설치하기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!-- End exclusive deal Area -->

	<!-- Start brand Area -->
	<section class="brand-area section_gap">
		<div class="container-new">
		<div class="row">
			<div class="right-side">
				<h5>이용안내</h5><br>
				<p><a style="color: grey" href="inspection.html" onclick="window.open(this.href, '_blank', 'width=500px, height=500px, toolbars=no, scrollbars=yes'); return false;">검수기준</a></p>
				<p><a style="color: grey" href="policy.html" onclick="window.open(this.href, '_blank', 'width=500px, height=500px, toolbars=no, scrollbars=yes'); return false;">이용정책</a></p>
				<p><a style="color: grey" href="penalty.html" onclick="window.open(this.href, '_blank', 'width=500px, height=500px, toolbars=no, scrollbars=yes'); return false;">페널티 정책</a></p>
				<p><a style="color: grey" href="guideline.html" onclick="window.open(this.href, '_blank', 'width=500px, height=500px, toolbars=no, scrollbars=yes'); return false;">커뮤니티 가이드라인</a></p>
			</div>
			<div class="right-side">
				<h5>고객지원</h5><br>
				<p><a style="color: grey" href="#">공지사항</a></p>
				<p><a style="color: grey" href="blog.html">서비스 소개</a></p>
				<p><a style="color: grey" href="single-blog.html">쇼룸 안내</a></p>
				<p><a style="color: grey" href="#">판매자 방문접수</a></p>
			</div>
			<div class="right-0 right-side">
				<h5>고객센터 1588-9999</h5><br>
				<p>운영시간 평일 11:00 - 18:00 (토 ∙ 일, 공휴일 휴무) 점심시간</p>
				<p>점심시간 평일 13:00 - 14:00</p>
				<h6>1:1 문의하기는 앱에서만 가능합니다.</h6><br>
				<a href="#" class="primary-btn">자주 묻는 질문</a>
			</div>
			</div>
		</div>
	</section>
	<!-- End brand Area -->

	<!-- start footer Area -->
	<footer class="footer-area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6><a style="color: white" href="privacy-policy.html">개인정보처리방침</a></h6>
						<p>
							Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore
							magna aliqua.
						</p>
					</div>
				</div>
				<div class="col-lg-4  col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<h6><a style="color: white" href="TOS.html">이용약관</a></h6>
						
						<div class="" id="mc_embed_signup">

							<form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
							 method="get" class="form-inline">

								<div class="d-flex flex-row">
				
									<div style="position: absolute; left: -5000px;">
										<input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
									</div>

								</div>
								<div class="info"></div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-3  col-md-6 col-sm-6">
					<div class="single-footer-widget mail-chimp">
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-footer-widget">
						<div class="footer-social d-flex align-items-center">
							<a href="https://www.instagram.com/"><i class="fa fa-instagram"></i></a>
							<a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
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

	<!-- Modal Quick Product View -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="container relative">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="product-quick-view">
					<div class="row align-items-center">
						<div class="col-lg-6">
							<div class="quick-view-carousel">
								<div class="item" style="background: url(/Shoesgone/resources/img/organic-food/q1.jpg);">

								</div>
								<div class="item" style="background: url(/Shoesgone/resources/img/organic-food/q1.jpg);">

								</div>
								<div class="item" style="background: url(/Shoesgone/resources/img/organic-food/q1.jpg);">

								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="quick-view-content">
								<div class="top">
									<h3 class="head">Mill Oil 1000W Heater, White</h3>
									<div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
									<div class="category">Category: <span>Household</span></div>
									<div class="available">Availibility: <span>In Stock</span></div>
								</div>
								<div class="middle">
									<p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are
										looking for something that can make your interior look awesome, and at the same time give you the pleasant
										warm feeling during the winter.</p>
									<a href="#" class="view-full">View full Details <span class="lnr lnr-arrow-right"></span></a>
								</div>
								<div class="bottom">
									<div class="color-picker d-flex align-items-center">Color:
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
									</div>
									<div class="quantity-container d-flex align-items-center mt-15">
										Quantity:
										<input type="text" class="quantity-amount ml-15" value="1" />
										<div class="arrow-btn d-inline-flex flex-column">
											<button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
											<button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
										</div>

									</div>
									<div class="d-flex mt-20">
										<a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
										<a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
										<a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>



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