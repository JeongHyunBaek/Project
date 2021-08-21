<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="categoryPage.model.vo.Item, categoryPage.model.vo.Picture, categoryPage.model.vo.SellBid, categoryPage.model.vo.BuyBid, categoryPage.model.vo.Notice, java.util.ArrayList" %>
<%
	ArrayList<Item> regItem1 = (ArrayList<Item>)request.getAttribute("regItem1");
	ArrayList<Picture> regItem2 = (ArrayList<Picture>)request.getAttribute("regItem2");
	ArrayList<Item> hotItem1 = (ArrayList<Item>)request.getAttribute("hotItem1");
	ArrayList<Picture> hotItem2 = (ArrayList<Picture>)request.getAttribute("hotItem2");
	ArrayList<Item> recItem1 = (ArrayList<Item>)request.getAttribute("recItem1");
	ArrayList<Picture> recItem2 = (ArrayList<Picture>)request.getAttribute("recItem2");
	ArrayList<Item> newBuyPrice1 = (ArrayList<Item>)request.getAttribute("newBuyPrice1");
	ArrayList<Picture> newBuyPrice2 = (ArrayList<Picture>)request.getAttribute("newBuyPrice2");
	ArrayList<SellBid> newBuyPrice3 = (ArrayList<SellBid>)request.getAttribute("newBuyPrice3");
	ArrayList<Item> newSellPrice1 = (ArrayList<Item>)request.getAttribute("newSellPrice1");
	ArrayList<Picture> newSellPrice2 = (ArrayList<Picture>)request.getAttribute("newSellPrice2");
	ArrayList<BuyBid> newSellPrice3 = (ArrayList<BuyBid>)request.getAttribute("newSellPrice3");
	ArrayList<Item> upcomingRelease1 = (ArrayList<Item>)request.getAttribute("upcomingRelease1");
	ArrayList<Picture> upcomingRelease2 = (ArrayList<Picture>)request.getAttribute("upcomingRelease2");
	ArrayList<Notice> notice = (ArrayList<Notice>)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>슈즈곤</title>
	<!--
		CSS
		============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="/Shoesgone/resources/css/magnific-popup.css">
	
	<style>
		#ad-image-margin{
			margin-left: auto;
			margin-right: auto;
		}
		
		#ad1-style{
			background-color: rgb(54, 130, 176);
			text-align: center;
			cursor: pointer;
		}
		
		#ad2-style{
			background-color: rgb(227, 31, 106);
			text-align: center;
			cursor: pointer;
		}
		
		#ad3-style{
			background-color: rgb(160, 185, 190);
			text-align: center;
			cursor: pointer;
		}
		
		#ad4-style{
			background-color: rgb(255, 103, 17);
			text-align: center;
			cursor: pointer;
		}
		
		#today-style, #shoesgone-style{
			width: 100%;
			margin: 3em auto;
			display: flex;
			flex-wrap: wrap;
		}
		
		#today-style li, #shoesgone-style li{
			width: 16%;
			list-style: none;
			padding: 15px;
			margin-left: auto;
			margin-right: auto;
		}
		
		#today-style li img, #shoesgone-style li img{
			width: 100%;
		}
		
		#cursor-pointer{
			cursor: pointer;
		}
		
		.item-background-color1{
			background-color: rgb(241, 241, 234);
		}
		
		.item-background-color2{
			background-color: rgb(244, 244, 244);
		}
		
		.item-background-color3{
			background-color: rgb(235, 240, 245);
		}
		
		.item-background-color4{
			background-color: rgb(246, 238, 237);
		}
		
		.item-background-color5{
			background-color: rgb(231, 239, 236);
		}
	</style>
</head>
<body>

	<%@ include file="views/common/menubar.jsp" %>

	<!-- start banner Area -->
	<section class="banner-area">
		<div class="container">
			<div class="row fullscreen align-items-center justify-content-start">
				<div class="col-lg-12">
					<div class="active-banner-slider owl-carousel">
						<!-- single-slide -->
						<% for (int i = notice.size() - 1; i >= notice.size() - 7; i--){ %>
						<div class="row single-slide align-items-center d-flex" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=notice<%= notice.get(i).getNoticeNo() %>';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1><%= notice.get(i).getNoticeTitle() %></h1>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<% } %>
					</div><br><br><br>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	
	<!-- start product Area -->
	<section>
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>발매 상품</h1>			
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=regitem1';">
						<div class="single-product">
							<img class="img-fluid item-background-color1" src="/Shoesgone/resources/img/shoes_images/<%= regItem2.get(0).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= regItem1.get(0).getItemKrName() %></h6>
								<div class="price">
									<h6><%= regItem1.get(0).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=regitem2';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= regItem2.get(1).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= regItem1.get(1).getItemKrName() %></h6>
								<div class="price">
									<h6><%= regItem1.get(1).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=regitem3';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= regItem2.get(2).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= regItem1.get(2).getItemKrName() %></h6>
								<div class="price">
									<h6><%= regItem1.get(2).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=regitem4';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= regItem2.get(3).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= regItem1.get(3).getItemKrName() %></h6>
								<div class="price">
									<h6><%= regItem1.get(3).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>오늘의 스타일</h1>			
						</div>
					</div>
				</div>
					<div id="today-style"></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad1-style" onclick="location.href='/Shoesgone/menubarsearch?menu=ad1';">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DH3227-105_0.png" alt="">
			</div>
			<div>
				<h1 id="white-color">조던 1 x 트래비스 스캇 x 프라그먼트 레트로 하이 OG SP 밀리터리 블루</h1><br>
			</div>
		</section>
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>인기 상품</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=hotitem1';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= hotItem2.get(0).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= hotItem1.get(0).getItemKrName() %></h6>
								<div class="price">
									<h6><%= hotItem1.get(0).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=hotitem2';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= hotItem2.get(1).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= hotItem1.get(1).getItemKrName() %></h6>
								<div class="price">
									<h6><%= hotItem1.get(1).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=hotitem3';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= hotItem2.get(2).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= hotItem1.get(2).getItemKrName() %></h6>
								<div class="price">
									<h6><%= hotItem1.get(2).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=hotitem4';">
						<div class="single-product">
							<img class="img-fluid item-background-color4" src="/Shoesgone/resources/img/shoes_images/<%= hotItem2.get(3).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= hotItem1.get(3).getItemKrName() %></h6>
								<div class="price">
									<h6><%= hotItem1.get(3).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>슈즈곤</h1>			
						</div>
					</div>
				</div>
					<div id="shoesgone-style"></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad2-style" onclick="location.href='/Shoesgone/menubarsearch?menu=ad2';">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DH7695-600_0.png" alt="">
			</div>
			<div>
				<h1 id="white-color">나이키 x 파라 SB 덩크 로우 프로 앱스트랙트 아트</h1><br>
			</div>
		</section>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>추천 상품</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=recitem1';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= recItem2.get(0).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= recItem1.get(0).getItemKrName() %></h6>
								<div class="price">
									<h6><%= recItem1.get(0).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=recitem2';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= recItem2.get(1).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= recItem1.get(1).getItemKrName() %></h6>
								<div class="price">
									<h6><%= recItem1.get(1).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=recitem3';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= recItem2.get(2).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= recItem1.get(2).getItemKrName() %></h6>
								<div class="price">
									<h6><%= recItem1.get(2).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=recitem4';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= recItem2.get(3).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= recItem1.get(3).getItemKrName() %></h6>
								<div class="price">
									<h6><%= recItem1.get(3).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad3-style" onclick="location.href='/Shoesgone/menubarsearch?menu=ad3';">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/GCOMS590-W55_0.png" alt="">
			</div>
			<div>
				<h1 id="white-color">골든구스 슈퍼스타 화이트 블랙탭 스니커즈</h1><br>
			</div>
		</section>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>새로운 즉시 구매가</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newbuyprice1';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= newBuyPrice2.get(0).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newBuyPrice1.get(0).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newBuyPrice3.get(0).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newbuyprice2';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= newBuyPrice2.get(1).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newBuyPrice1.get(1).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newBuyPrice3.get(1).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newbuyprice3';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= newBuyPrice2.get(2).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newBuyPrice1.get(2).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newBuyPrice3.get(2).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newbuyprice4';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= newBuyPrice2.get(3).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newBuyPrice1.get(3).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newBuyPrice3.get(3).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>새로운 즉시 판매가</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newsellprice1';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= newSellPrice2.get(0).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newSellPrice1.get(0).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newSellPrice3.get(0).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newsellprice2';">
						<div class="single-product">
							<img class="img-fluid item-background-color4" src="/Shoesgone/resources/img/shoes_images/<%= newSellPrice2.get(1).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newSellPrice1.get(1).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newSellPrice3.get(1).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newsellprice3';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= newSellPrice2.get(2).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newSellPrice1.get(2).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newSellPrice3.get(2).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=newsellprice4';">
						<div class="single-product">
							<img class="img-fluid item-background-color1" src="/Shoesgone/resources/img/shoes_images/<%= newSellPrice2.get(3).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= newSellPrice1.get(3).getItemKrName() %></h6>
								<div class="price">
									<h6><%= newSellPrice3.get(3).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad4-style" onclick="location.href='/Shoesgone/menubarsearch?menu=ad4';">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DD1877-002_0.png" alt="">
			</div>
			<div>
				<h1 id="white-color">나이키 x 사카이 블레이저 로우 아이언 그레이</h1><br>
			</div>
		</section>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>발매 예정</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=upcomingrelease1';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= upcomingRelease2.get(0).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= upcomingRelease1.get(0).getItemKrName() %></h6>
								<div class="price">
									<h6><%= upcomingRelease1.get(0).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=upcomingrelease2';">
						<div class="single-product">
							<img class="img-fluid item-background-color3" src="/Shoesgone/resources/img/shoes_images/<%= upcomingRelease2.get(1).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= upcomingRelease1.get(1).getItemKrName() %></h6>
								<div class="price">
									<h6><%= upcomingRelease1.get(1).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=upcomingrelease3';">
						<div class="single-product">
							<img class="img-fluid item-background-color5" src="/Shoesgone/resources/img/shoes_images/<%= upcomingRelease2.get(2).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= upcomingRelease1.get(2).getItemKrName() %></h6>
								<div class="price">
									<h6><%= upcomingRelease1.get(2).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6" id="cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=upcomingrelease4';">
						<div class="single-product">
							<img class="img-fluid item-background-color2" src="/Shoesgone/resources/img/shoes_images/<%= upcomingRelease2.get(3).getPicturepath() %>" alt="">
							<div class="product-details">
								<h6><%= upcomingRelease1.get(3).getItemKrName() %></h6>
								<div class="price">
									<h6><%= upcomingRelease1.get(3).getPrice() %>원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
	</section>
	<!-- end product Area -->

	<%@ include file="views/common/footer.jsp" %>

	<script src="/Shoesgone/resources/js/instafeed.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery-ui.min.js"></script>
	<script src="/Shoesgone/resources/js/animated_bg.js"></script>
	<script>
	    var feed1 = new Instafeed({
	    	target: 'today-style',
	    	template: '<li><a href="{{link}}"><img title="{{caption}}" src="{{image}}" /></a></li>',
	    	limit: 6,
	    	accessToken: 'IGQVJXcEVqbjRwMVB2a2VvcEZACY3Y3am5fX3h1bHMtdnJadjMtVHhNdnhoZAFdPS194clRqSTItWXQ1TE5hbG5xVWk1aThydVl0VmJCZAWFnRU9zdkwwcUFTVkZAGcEVsZAWFIZAW5nV2RvSVl2VDhOM0tDcwZDZD'
	    });
	    feed1.run();
	    
	    var feed2 = new Instafeed({
	    	target: 'shoesgone-style',
	    	template: '<li><a href="{{link}}"><img title="{{caption}}" src="{{image}}" /></a></li>',
	    	limit: 6,
	    	accessToken: 'IGQVJXcEVqbjRwMVB2a2VvcEZACY3Y3am5fX3h1bHMtdnJadjMtVHhNdnhoZAFdPS194clRqSTItWXQ1TE5hbG5xVWk1aThydVl0VmJCZAWFnRU9zdkwwcUFTVkZAGcEVsZAWFIZAW5nV2RvSVl2VDhOM0tDcwZDZD'
	    });
	    feed2.run();
	</script>
	
	<script>
		jQuery(document).ready(function(){
			$('.banner-area').animatedBG({
				colorSet: ['rgb(20, 122, 61)', 'rgb(58, 194, 162)', 'rgb(77, 89, 81)', 'rgb(225, 218, 204)', 'rgb(249, 249, 249)'],
				speed: 2000
			});
		});
	</script>
</body>
</html>