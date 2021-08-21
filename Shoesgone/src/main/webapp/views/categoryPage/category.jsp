<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="categoryPage.model.vo.ItemPicture, java.util.*" %>
<%
	String sort = request.getAttribute("sort").toString();
	ArrayList<ItemPicture> item = (ArrayList<ItemPicture>)request.getAttribute("item");
	Random random = new Random();
%>
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
		
		.cursor-pointer{
			cursor: pointer;
		}
		
		#orange-bar{
			background-color: #ff9f00;
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
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=sneakers">스니커즈<span class="number"></span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#meatFish" aria-expanded="false" aria-controls="meatFish"><span
								 class="lnr lnr-arrow-right"></span>브랜드<span class="number">(모든 브랜드)</span></a>
							<ul class="collapse" id="meatFish" data-toggle="collapse" aria-expanded="false" aria-controls="meatFish">
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=nike">Nike<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=jordan">Jordan<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=new balance">New Balance<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=adidas">Adidas<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=golden goose">Golden Goose<span class="number"></span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#cooking" aria-expanded="false" aria-controls="cooking"><span
								 class="lnr lnr-arrow-right"></span>성별<span class="number">(모든 성별)</span></a>
							<ul class="collapse" id="cooking" data-toggle="collapse" aria-expanded="false" aria-controls="cooking">
								<li class="main-nav-list child"><a href="#">남성<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="#">여성<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="#">키즈<span class="number"></span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#beverages" aria-expanded="false" aria-controls="beverages"><span
								 class="lnr lnr-arrow-right"></span>컬렉션<span class="number">(모든 컬렉션)</span></a>
							<ul class="collapse" id="beverages" data-toggle="collapse" aria-expanded="false" aria-controls="beverages">
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=jordan 1">Jordan 1<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=jordan 4">Jordan 4<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=jordan 6">Jordan 6<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=nike dunk">Dunk<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=air force">Nike Air Force<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=new balance 327">New Balance 327<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=new balance 992">New Balance 992<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=adidas yeezy">Adidas Yeezy<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=x sacai">x Sacai<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=luxury">Luxury Collection<span class="number"></span></a></li>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#homeClean" aria-expanded="false" aria-controls="homeClean"><span
								 class="lnr lnr-arrow-right"></span>스니커즈 사이즈<span class="number">(모든 사이즈)</span></a>
							<ul class="collapse" id="homeClean" data-toggle="collapse" aria-expanded="false" aria-controls="homeClean">
								<table id="size-table">
									<tr>
										<td><input class="cursor-pointer" type=button value="215" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size1'"></td>
										<td><input class="cursor-pointer" type=button value="220" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size2'"></td>
										<td><input class="cursor-pointer" type=button value="225" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size3'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="230" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size4'"></td>
										<td><input class="cursor-pointer" type=button value="235" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size5'"></td>
										<td><input class="cursor-pointer" type=button value="240" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size6'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="245" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size7'"></td>
										<td><input class="cursor-pointer" type=button value="250" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size8'"></td>
										<td><input class="cursor-pointer" type=button value="255" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size9'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="260" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size10'"></td>
										<td><input class="cursor-pointer" type=button value="265" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size11'"></td>
										<td><input class="cursor-pointer" type=button value="270" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size12'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="275" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size13'"></td>
										<td><input class="cursor-pointer" type=button value="280" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size14'"></td>
										<td><input class="cursor-pointer" type=button value="285" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size15'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="290" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size16'"></td>
										<td><input class="cursor-pointer" type=button value="295" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size17'"></td>
										<td><input class="cursor-pointer" type=button value="300" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size18'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="305" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size19'"></td>
										<td><input class="cursor-pointer" type=button value="310" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size20'"></td>
										<td><input class="cursor-pointer" type=button value="315" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size21'"></td>
									</tr>
									<tr>
										<td><input class="cursor-pointer" type=button value="320" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size22'"></td>
										<td><input class="cursor-pointer" type=button value="325" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size23'"></td>
										<td><input class="cursor-pointer" type=button value="330" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size24'"></td>
									</tr>
							</table>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#clothes" aria-expanded="false" aria-controls="clothes"><span 
								class="lnr lnr-arrow-right"></span>의류 사이즈<span class="number">(모든 사이즈)</span></a>
							<ul class="collapse" id="clothes" data-toggle="collapse" aria-expanded="false" aria-controls="clothes">
								<table  id="size-table">
									<tr>
										<td><input type=button value="XXS" id="clothes-style"></td>
										<td><input type=button value="XS" id="clothes-style"></td>
									</tr>
									<tr>
										<td><input type=button value="S" id="clothes-style"></td>
										<td><input type=button value="M" id="clothes-style"></td>
									</tr>
									<tr>
										<td><input type=button value="L" id="clothes-style"></td>
										<td><input type=button value="XL" id="clothes-style"></td>
									</tr>
									<tr>
										<td><input type=button value="XXL" id="clothes-style"></td>
										<td><input type=button value="XXXL" id="clothes-style"></td>
									</tr>
								</table>
								<br>
								<table>
									<tr>
										<td><input type=button value="28" id="shoes-pants"></td>
										<td><input type=button value="29" id="shoes-pants"></td>
										<td><input type=button value="30" id="shoes-pants"></td>
									</tr>
									<tr>
										<td><input type=button value="31" id="shoes-pants"></td>
										<td><input type=button value="32" id="shoes-pants"></td>
										<td><input type=button value="33" id="shoes-pants"></td>
									</tr>
									<tr>
										<td><input type=button value="34" id="shoes-pants"></td>
										<td><input type=button value="35" id="shoes-pants"></td>
										<td><input type=button value="36" id="shoes-pants"></td>
									</tr>
								</table>
							</ul>
						</li>
						<li class="main-nav-list"><a data-toggle="collapse" href="#officeProduct" aria-expanded="false" aria-controls="officeProduct"><span
								 class="lnr lnr-arrow-right"></span>가격<span class="number">(모든 가격)</span></a>
							<ul class="collapse" id="officeProduct" data-toggle="collapse" aria-expanded="false" aria-controls="officeProduct">
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=price1">10만원 이하<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=price2">10만원 - 30만원 이하<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=price3">30만원 - 50만원 이하<span class="number"></span></a></li>
								<li class="main-nav-list child"><a href="/Shoesgone/menubarsearch?menu=price4">50만원 이상<span class="number"></span></a></li>
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
				<div class="filter-bar d-flex flex-wrap align-items-center" id="orange-bar">
					<div class="sorting mr-auto">
					</div>
					<div>		
						<div class="sorting">
							<% if(sort == "") { %>
							<select id="sort" onchange="if(this.value) location.href='/Shoesgone/menubarsearch?menu=' + (this.value);">
								<option value="sort-hot">인기순</option>
								<option value="sort-premium">프리미엄순</option>
								<option value="sort-buy">즉시 구매가순</option>
								<option value="sort-sell">즉시 판매가순</option>
								<option value="sort-drop">발매일순</option>
							</select>
							<% } else if(sort.equals("sort-hot")){ %>
							<select id="sort" onchange="if(this.value) location.href='/Shoesgone/menubarsearch?menu=' + (this.value);">
								<option value="sort-hot" selected>인기순</option>
								<option value="sort-premium">프리미엄순</option>
								<option value="sort-buy">즉시 구매가순</option>
								<option value="sort-sell">즉시 판매가순</option>
								<option value="sort-drop">발매일순</option>
							</select>
							<% } else if(sort.equals("sort-premium")){ %>
							<select id="sort" onchange="if(this.value) location.href='/Shoesgone/menubarsearch?menu=' + (this.value);">
								<option value="sort-hot">인기순</option>
								<option value="sort-premium" selected>프리미엄순</option>
								<option value="sort-buy">즉시 구매가순</option>
								<option value="sort-sell">즉시 판매가순</option>
								<option value="sort-drop">발매일순</option>
							</select>
							<% } else if(sort.equals("sort-buy")){ %>
							<select id="sort" onchange="if(this.value) location.href='/Shoesgone/menubarsearch?menu=' + (this.value);">
								<option value="sort-hot">인기순</option>
								<option value="sort-premium">프리미엄순</option>
								<option value="sort-buy" selected>즉시 구매가순</option>
								<option value="sort-sell">즉시 판매가순</option>
								<option value="sort-drop">발매일순</option>
							</select>
							<% } else if(sort.equals("sort-sell")){ %>
							<select id="sort" onchange="if(this.value) location.href='/Shoesgone/menubarsearch?menu=' + (this.value);">
								<option value="sort-hot">인기순</option>
								<option value="sort-premium">프리미엄순</option>
								<option value="sort-buy">즉시 구매가순</option>
								<option value="sort-sell" selected>즉시 판매가순</option>
								<option value="sort-drop">발매일순</option>
							</select>
							<% } else if(sort.equals("sort-drop")){ %>
							<select id="sort" onchange="if(this.value) location.href='/Shoesgone/menubarsearch?menu=' + (this.value);">
								<option value="sort-hot">인기순</option>
								<option value="sort-premium">프리미엄순</option>
								<option value="sort-buy">즉시 구매가순</option>
								<option value="sort-sell">즉시 판매가순</option>
								<option value="sort-drop" selected>발매일순</option>
							</select>
							<% } %>
						</div>
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row">
						<% for (ItemPicture ip : item){ %>
						<!-- single product -->
						<div class="col-lg-3 col-md-6 cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=item<%= ip.getItemNo() %>';">
							<div class="single-product">
								<img class="img-fluid item-background-color<%= random.nextInt(5) + 1 %>" src="/Shoesgone/resources/img/shoes_images/<%= ip.getPicturepath() %>" alt="">
								<div class="product-details">
									<h6><%= ip.getItemKrName() %></h6>
									<div class="price">
										<h6><%= ip.getPrice() %>원</h6>
									</div>
									<div class="prd-bottom">
									</div>
								</div>
							</div>
						</div>
						<% } %>
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
	<!-- ajax로 정렬 기준 값을 서블릿으로 전달 -->
	<!-- <script>
		$(document).ready(function(){
			$('#sort').change(function(){
				var sortId = document.getElementById("sort");
				var sortValue = sortId.options[sortId.selectedIndex].value;
				
				$.ajax({
					type: 'GET',
					data: { "sortValue": sortValue },
					url: 'menubarsearch?menu=sort'
				});
			});
		});
	</script> -->
</body>
</html>