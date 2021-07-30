<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="itemPage.model.vo.Item, loginPage.model.vo.Login, itemPage.model.vo.Picture, java.util.ArrayList"%>
<%
	//Item 객체를 가져옴
	Item item = (Item) request.getAttribute("item");
	Login loginMember = (Login)session.getAttribute("loginMember");
	ArrayList<Picture> plist = (ArrayList<Picture>)request.getAttribute("plist");
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
	<link rel="stylesheet" href="/Shoesgone/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nouislider.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
	<link rel="stylesheet" href="/Shoesgone/resources/plugins/slick/slick.css?after">
	<link rel="stylesheet" href="/Shoesgone/resources/plugins/slick/slick-theme.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/itemDetailView.css">
</head>
<body id="itemdetail">
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
						<h1>Product Details Page</h1>
						<nav class="d-flex align-items-center">
							<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
							<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
							<a href="single-product.html">product-details</a>
						</nav>
					</div>
				</div>
			</div>
		</section>
	<!-- End Banner Area -->
	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="your-class">
						<% for(Picture p : plist){ %>
    					<div>
    						<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/<%= p.getPicturepath() %>" alt="">
    					</div>
    					<% } %>
  					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text" style="margin-top: 0px">
						<h3><%= item.getItemEngName() %></h3>
						<h4><%= item.getItemKrName() %></h4>
						<div class="detail_size lg">
							<div class="title">
								<span class="title_txt">사이즈</span>
							</div>
							<div class="size">
								<a href="#" class="btn_size">
									<span class="btn_text">모든사이즈</span>
								</a>
							</div>
						</div>
						<div class="detail_price lg">
							<div class="title">
								<span class="title_txt">최근 거래가</span>
							</div>
							<div class="price">
								<span class="price_txt">minimum price</span>
							</div>
						</div>
						<div class="card_area d-flex align-items-center">
							<a class="primary-btn" href="#">구매하기</a>
							<a class="primary-btn" href="#">판매하기</a>
							<!-- <a class="icon_btn" href="#"><i class="lnr lnr lnr-diamond"></i></a>
							<a class="icon_btn" href="#"><i]\ class="lnr lnr lnr-heart"></i></a> -->
						</div>
						<br>
						<div class="s_product_table">
						<h3>제품 상세정보</h3>
						<table class="table_specification">
							<tbody>
								<tr>
									<td>
										<h5>브랜드</h5>
									</td>
									<td>
										<h5><%= item.getBrand() %></h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>모델 번호</h5>
									</td>
									<td>
										<h5><%= item.getModelNo() %></h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>신발 색상</h5>
									</td>
									<td>
										<h5><%= item.getShoesColors() %></h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>발매가</h5>
									</td>
									<td>
										<h5><%= item.getPrice() %></h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>발매일</h5>
									</td>
									<td>
										<h5><%= item.getDropDate() %></h5>
									</td>
								</tr>
							</tbody>
						</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->
	<hr>
	<!--================Product Description Area =================-->
	<div class="product_extra_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="shoes_statistics" >
    					<div>
    					<h4>거래추이</h4>
    					<table class="graph_options">
    						<tr>
    							<td>
    								<select>
										<option>사이즈별</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
								</td>
								<td>
									<select>
										<option>기간별</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
									</select>
    							</td>
    						</tr>
    					</table>
    					<img class="sales_graph" src="/Shoesgone/resources/img/product_detail_example/kream_yeezy_graph.png">
    					</div>
    					<br>
    					<h5>거래기록</h5>
    					<br>
    					<div><img class="sales_record" src="product_detail_example/resources/img/product_detail_example/yeezy_sales_record.png" ></div>
    					<br>
  					</div>
  					<div class="sales_detail">
  						<a class="primary-btn" href="#" style="text-align: center; margin: auto;">거래내역 자세히 보기</a>
  					</div>
				</div>
				<div class="col-lg-6">
					<div class="size_recommend_box">
						<strong>사이즈 추천</strong>
						<p class="box_recommend_size">고객의 추천사이즈로 주관적입니다.</p>
						<div class="size_recommend_table" style="overflow-y: scroll; height:150px;">
							<ul>
								<li>1</li>
								<li>2</li>
								<li>3</li>
								<li>4</li>
								<li>5</li>
								<li>6</li>
								<li>7</li>
								<li>8</li>
								<li>9</li>
								<li>10</li>
								<li>11</li>
								<li>12</li>
								<li>13</li>
								<li>14</li>
								<li>15</li>
								<li>16</li>
								<li>17</li>
								<li>18</li>
								<li>19</li>
								<li>20</li>
								<li>21</li>
								<li>22</li>
								<li>23</li>
								<li>24</li>
								<li>25</li>
								<li>26</li>
								<li>27</li>
								<li>28</li>
								<li>29</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Product Description Area =================-->

	<!-- End related-product Area -->

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
							<li><img src="/Shoesgone/resources/img/i1.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i2.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i3.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i4.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i5.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i6.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i7.jpg" alt=""></li>
							<li><img src="/Shoesgone/resources/img/i8.jpg" alt=""></li>
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
	gmaps Js
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="/Shoesgone/resources/js/gmaps.min.js"></script>
	<script src="/Shoesgone/resources/js/main.js"></script>
	<script type="text/javascript" src="/Shoesgone/resources/plugins/slick/slick.js"></script>
	<script type="text/javascript" src="/Shoesgone/resources/plugins/slick/slick.min.js"></script>
	<script type="text/javascript">
    $(document).ready(function(){
    	$('.your-class').slick({
    		slide: 'div',
    		infinite: true,
    		slidesToshow: 1,
    		dots: true,
    		infinite: true,
    		speed: 500,
    		fade: true,
    		cssEase: 'linear',
    		prevArrow : "<button type='button' class='slick-prev'>Previous</button>",		// 이전 화살표 모양 설정
			nextArrow : "<button type='button' class='slick-next'>Next</button>",		// 다음 화살표 모양 설정
			draggable : true
    		});
    });
  	</script>
</body>
</html>