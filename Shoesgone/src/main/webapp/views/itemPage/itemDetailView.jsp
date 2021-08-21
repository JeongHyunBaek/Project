<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="itemPage.model.vo.Item, itemPage.model.vo.Picture, java.util.ArrayList, community.review.model.vo.Review, orders.model.vo.Orders"%>
<%
//Item 객체를 가져옴
Item item = (Item) request.getAttribute("item");
ArrayList<Picture> plist = (ArrayList<Picture>) request.getAttribute("plist");
ArrayList<Integer> isizes = (ArrayList<Integer>) request.getAttribute("isizes");
ArrayList<Review> rlist = (ArrayList<Review>) request.getAttribute("rlist");
ArrayList<Picture> rplist = (ArrayList<Picture>) request.getAttribute("rplist");
ArrayList<String> rpnames = (ArrayList<String>) request.getAttribute("rpnames");
ArrayList<Orders> olist = (ArrayList<Orders>) request.getAttribute("olist");
%>
<!DOCTYPE html>
<html>
<head>
<!-- meta character set -->
<meta charset="UTF-8">
<!-- Site Title -->
<title>SHOP</title>

<!--
            CSS
            ============================================= -->
<link rel="stylesheet"
	href="/Shoesgone/resources/css/ion.rangeSlider.css" />
<link rel="stylesheet"
	href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css" />
<link rel="stylesheet"
	href="/Shoesgone/resources/plugins/slick/slick.css?after">
<link rel="stylesheet"
	href="/Shoesgone/resources/plugins/slick/slick-theme.css">
<link rel="stylesheet"
	href="/Shoesgone/resources/css/itemDetailView.css?after">
<style>
#related-style {
	width: 100%;
	margin: 3em auto;
	display: flex;
	flex-wrap: wrap;
}

#related-style li {
	width: 30%;
	list-style: none;
	padding: 5px;
	margin-left: auto;
	margin-right: auto;
}

#related-style li img {
	width: 100%;
}
</style>
</head>
<body id="itemdetail">

	<%@ include file="../common/menubar.jsp"%>

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Product Details Page</h1>
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
						<%
						for (Picture p : plist) {
						%>
						<div>
							<img class="img-fluid"
								src="/Shoesgone/resources/img/shoes_images/<%=p.getPicturepath()%>"
								alt="">
						</div>
						<%
						}
						%>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text" style="margin-top: 0px">
						<h3><%=item.getItemEngName()%></h3>
						<h4><%=item.getItemKrName()%></h4>
						<div class="detail_size lg">
							<br> <br>
						</div>
						<div class="detail_price lg">
							<div class="title">
								<span class="title_txt">최근 거래가</span> <span
									style="float: right; font-size: large; margin-right: 30%;"><%=olist.get(1).getPrice()%>원</span>
							</div>
							<br> <br>
						</div>
						<div class="card_area d-flex align-items-center">
							<a class="primary-btn"
								href="/Shoesgone/menubarsearch?menu=buyaccept&itemno=<%=item.getItemNo()%>">구매하기</a>
							<a class="primary-btn"
								href="/Shoesgone/menubarsearch?menu=sellaccept&itemno=<%=item.getItemNo()%>">판매하기</a>
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
											<h5><%=item.getBrand()%></h5>
										</td>
									</tr>
									<tr>
										<td>
											<h5>모델 번호</h5>
										</td>
										<td>
											<h5><%=item.getModelNo()%></h5>
										</td>
									</tr>
									<tr>
										<td>
											<h5>신발 색상</h5>
										</td>
										<td>
											<h5><%=item.getShoesColors()%></h5>
										</td>
									</tr>
									<tr>
										<td>
											<h5>발매가</h5>
										</td>
										<td>
											<h5><%=item.getPrice()%></h5>
										</td>
									</tr>
									<tr>
										<td>
											<h5>발매일</h5>
										</td>
										<td>
											<h5><%=item.getDropDate()%></h5>
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
					<div class="shoes_statistics">
						<div>
							<h4>거래추이</h4>
							<table class="graph_options">
								<tr>
									<td><select class="graph_size" id="graph_size"
										onchange=reloadPage()>
											<option value="0">사이즈별</option>
											<%
											for (int i : isizes) {
											%>
											<option value="<%=i%>"><%=i%></option>
											<%
											}
											%>
									</select></td>
									<td><select class="graph_days" id="graph_days"
										onchange=reloadPage()>
											<option value="1" selected>일별</option>
											<option value="7">주별</option>
											<option value="30">월별</option>
									</select></td>
								</tr>
							</table>
							<div>
								<iframe id="iframecontext" src="" width="100%" height="280px"
									frameborder=0 framespacing=0></iframe>
							</div>
						</div>
						<br>
					</div>
					<div class="sales_detail" style="padding-left: 33%;">
						<button class="primary-btn" data-bs-toggle="modal"
							data-bs-target="#ItemADD"
							style="text-align: center; margin: auto;">거래내역 자세히 보기</button>
						<div class="modal fade" id="ItemADD" tabindex="-1" role="dialog"
							aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
							<div
								class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable"
								role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="ItemADDTitle">판매기록</h5>
										<button type="button" class="close rounded-pill"
											data-bs-dismiss="modal" aria-label="Close"
											style="background: white;">X</button>
									</div>
									<div class="modal-body">
										<table class="table table-striped" id="table1">
											<thead>
												<tr>
													<th>주문번호</th>
													<th>사이즈</th>
													<th>가격</th>
													<th>판매날짜</th>
												</tr>
											</thead>
											<tbody>
												<%
												for (Orders o : olist) {
												%>
												<tr>
													<td><%=o.getOrdersNo()%></td>
													<td><%=o.getSize()%></td>
													<td><%=o.getPrice()%></td>
													<td><%=o.getPurDate() %></td>
												</tr>
												<%
												}
												%>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="size_recommend_box">
						<strong>사이즈 추천</strong>
						<p class="box_recommend_size">고객의 추천사이즈로 주관적입니다.</p>
						<div class="size_recommend_table"
							style="overflow-y: scroll; height: 150px;">
							<table class="idpagereview" border="1" cellspacing="0">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>별점</th>
									<th>조회수</th>
								</tr>
								<% for (Review r : rlist) { %>
								<tr>

									<td><a href="/Shoesgone/menubarsearch?menu=review<%=r.getReviewNo()%>&page=1"><%=r.getReviewNo()%></a></td>
									<td><%=r.getReviewTitle()%></td>
									<td><%=r.getReviewStar()%>/10</td>
									<td><%=r.getReviewReadCount()%></td>
								</tr>
								<% } %>
							</table>
						</div>
					</div>
					<div id="related-style"></div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Product Description Area =================-->
	<hr>
	<!--================ Start Related Product Area =================-->
	<div class="product_extra_area">
		<div class="container">
			<div class="slick-related" style="background: none;">
				<%
				for (int i = 0; i < rplist.size(); i++) {
				%>
				<div>
					<a
						href="/Shoesgone/menubarsearch?menu=item<%=rplist.get(i).getModelno()%>">
						<img class="img-fluid"
						src="/Shoesgone/resources/img/shoes_images/<%=rplist.get(i).getPicturepath()%>"
						alt="">
						<p
							style="text-align: center; text-decoration: none; color: black;">
							<%=rpnames.get(i)%></p>
					</a>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
	<!--================ End Related Product Area =================-->
	<!-- End related-product Area -->

	<%@ include file="../common/footer.jsp"%>

	<script type="text/javascript"
		src="/Shoesgone/resources/plugins/slick/slick.js"></script>
	<script type="text/javascript"
		src="/Shoesgone/resources/plugins/slick/slick.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	<script src="/Shoesgone/resources/js/instafeed.min.js"></script>
	<script
		src="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script
		src="/Shoesgone/resources/plugins/assets/js/bootstrap.bundle.min.js"></script>

	<script
		src="/Shoesgone/resources/plugins/assets/vendors/simple-datatables/simple-datatables.js?after"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.your-class').slick({
				slide : 'div',
				infinite : true,
				dots : true,
				infinite : true,
				speed : 500,
				fade : true,
				cssEase : 'linear',
				prevArrow : "<button type='button' class='slick-prev'>Previous</button>", // 이전 화살표 모양 설정
				nextArrow : "<button type='button' class='slick-next'>Next</button>", // 다음 화살표 모양 설정
				draggable : true
			});
			$('.slick-related').slick({
				  dots: true,
				  infinite: false,
				  speed: 300,
				  slidesToShow: 4,
				  slidesToScroll: 4,
				  responsive: [
				    {
				      breakpoint: 1024,
				      settings: {
				        slidesToShow: 3,
				        slidesToScroll: 3,
				        infinite: true,
				        dots: true
				      }
				    },
				    {
				      breakpoint: 600,
				      settings: {
				        slidesToShow: 2,
				        slidesToScroll: 2
				      }
				    },
				    {
				      breakpoint: 480,
				      settings: {
				        slidesToShow: 1,
				        slidesToScroll: 1
				      }
				    }
				    // You can unslick at a given breakpoint now by adding:
				    // settings: "unslick"
				    // instead of a settings object
				  ]
				});
		});
				
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			var itemno = <%=item.getItemNo()%>
			var graphoption1 = document.getElementById("graph_size");
			var graphoption2 = document.getElementById("graph_days");
			graphoption1 = graphoption1.options[graphoption1.selectedIndex].value;
			graphoption2 = graphoption2.options[graphoption2.selectedIndex].value;
			
			document.getElementById("iframecontext").src = "/Shoesgone/ItemDG?itemno=" + itemno + "&option1=" + graphoption1 + "&option2=" + graphoption2;
		});
	</script>
	<script>
	function reloadPage() {
		var itemno = <%=item.getItemNo()%>
		var option1 = document.getElementById("graph_size");
		var option2 = document.getElementById("graph_days");
		option1 = option1.options[option1.selectedIndex].value;
		option2 = option2.options[option2.selectedIndex].value;
		
		document.getElementById("iframecontext").src = "/Shoesgone/ItemDG?itemno="+itemno+"&option1="+option1+"&option2="+option2;
	}
	</script>
	<script>
		var feed3 = new Instafeed({
	    	target: 'related-style',
	    	template: '<li><a href="{{link}}"><img title="{{caption}}" src="{{image}}" /></a></li>',
	    	limit: 6,
	    	accessToken: 'IGQVJXcEVqbjRwMVB2a2VvcEZACY3Y3am5fX3h1bHMtdnJadjMtVHhNdnhoZAFdPS194clRqSTItWXQ1TE5hbG5xVWk1aThydVl0VmJCZAWFnRU9zdkwwcUFTVkZAGcEVsZAWFIZAW5nV2RvSVl2VDhOM0tDcwZDZD'
	    });
	    feed3.run();
	</script>
</body>
</html>