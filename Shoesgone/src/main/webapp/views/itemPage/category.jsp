<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>SHOP</title>
	
	<style>
		#shoes-pants{
			width: 70px;
			height: 35px;
			background-color: white;
			border-color: grey;
		}
		
		#clothes-style{
			width: 105px;
			height: 35px;
			background-color: white;
			border-color: grey;"
		}
		
		#size-table{
			margin-left: auto;
			margin-right: auto;
		}
	</style>
</head>

<body id="category">
	<%@ include file="../common/menubar.jsp" %>

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
		
								<table id="size-table">
									<tr>
										<td><input type=button value="215" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="220" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="225" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="230" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="235" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="240" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="245" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="250" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="255" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="260" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="265" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="270" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="275" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="280" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="285" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="290" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="295" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="300" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="305" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="310" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="315" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="320" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="325" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="330" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
							</table>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#clothes" aria-expanded="false" aria-controls="clothes"><span 
								class="lnr lnr-arrow-right"></span>의류 사이즈<span class="number">(모든 사이즈)</span></a>
							<ul class="collapse" id="clothes" data-toggle="collapse" aria-expanded="false" aria-controls="clothes">
								<table  id="size-table">
									<tr>
										<td><input type=button value="XXS" id="clothes-style" onclick="location.href='#'"></td>
										<td><input type=button value="XS" id="clothes-style" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="S" id="clothes-style" onclick="location.href='#'"></td>
										<td><input type=button value="M" id="clothes-style" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="L" id="clothes-style" onclick="location.href='#'"></td>
										<td><input type=button value="XL" id="clothes-style" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="XXL" id="clothes-style" onclick="location.href='#'"></td>
										<td><input type=button value="XXXL" id="clothes-style" onclick="location.href='#'"></td>
									</tr>
								</table>
								<br>
								<table>
									<tr>
										<td><input type=button value="28" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="29" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="30" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="31" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="32" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="33" id="shoes-pants" onclick="location.href='#'"></td>
									</tr>
									<tr>
										<td><input type=button value="34" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="35" id="shoes-pants" onclick="location.href='#'"></td>
										<td><input type=button value="36" id="shoes-pants" onclick="location.href='#'"></td>
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
							
						</form>
					</div>
					<div>
						<!-- <div class="head">Color</div> -->
						<form action="#">
							
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
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>