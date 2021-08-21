<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- meta character set -->
<meta charset="UTF-8">

<%-- 페이지 이름 --%>
<title>Shoe's Gone</title>

<!-- CSS -->
<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.css" />
<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css" />
</head>
<body>
	<%-- Menubar --%>
	<%@ include file="../common/menubar.jsp" %>
		
	<%-- Banner --%>
	<%@ include file="../common/sell_banner.html" %>
	
	<%-- Main Content --%>
	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_Product_carousel">
						<div class="single-prd-item">
							<img class="img-fluid" src="/Shoesgone/resources/img/category/s-p1.jpg" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid" src="/Shoesgone/resources/img/category/s-p1.jpg" alt="">
						</div>
						<div class="single-prd-item">
							<img class="img-fluid" src="/Shoesgone/resources/img/category/s-p1.jpg" alt="">
						</div>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text" style="margin-top: 0px">
						<h3>nike_dunk_low_black</h3>
						<h2>$149.99</h2>
						<ul class="list">
							<li><a class="active" href="#"><span>카테고리</span> : nike_dunk_low</a></li>
							<li><a href="#"><span>사이즈</span> : In 180mm</a></li>
							<li><a href="#"><span>발매년도</span> : 2021-06-07</a></li>
						</ul>
						<hr>
						<div class="button-group-area mt-10">
							<h2>판매 사이즈 선택</h2>
							<h6>판매가(원)</h6>
							<table>
								<tr>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="230"><font color="black">230</font></a>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="235"><font color="black">235</font></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="240"><font color="black">240</font></a>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td>
									<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="245"><font color="black">245</font></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="250"><font color="black">250</font></a>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="255"><font color="black">255</font></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="260"><font color="black">260</font></a>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="265"><font color="black">265</font></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="270"><font color="black">270</font></a>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="275"><font color="black">275</font></a>
									</td>
								</tr>
								<tr>
									<td>
										<a href="/Shoesgone/views/sellPage/sell_accept.jsp" class="genric-btn default-border radius" value="280"><font color="black">280</font></a>
									</td>
									<td></td>
									<td></td>
									<td></td>
									<td><a href="/Shoesgone/views/sellPage/sell_accept.jsp"
										class="genric-btn default-border radius" value="285"><font color="black">285</font></a></td>
								</tr>
							</table>
						</div>
						<div class="card_area d-flex align-items-center"></div>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<!--================End Single Product Area =================-->
	
	<%-- Footer --%>
	<%@ include file="../common/footer.jsp" %>

</body>
</html>