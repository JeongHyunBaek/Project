<%@page import="itemregsta.model.vo.ItemRegSta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="itemPage.model.vo.Item, itemPage.model.vo.Picture, java.util.ArrayList"
%>
<%
ArrayList<ItemRegSta> rlist = (ArrayList<ItemRegSta>) request.getAttribute("rlist");
ArrayList<Picture> plist = (ArrayList<Picture>) request.getAttribute("plist");
ArrayList<Integer> isizes = (ArrayList<Integer>) request.getAttribute("isizes");
String itemEngName = request.getParameter("itemengname");
String itemKrName = request.getParameter("itemkrname");
%>
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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/css/bootstrap.css">

<link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/vendors/simple-datatables/style.css">

<link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/vendors/bootstrap-icons/bootstrap-icons.css">
<link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/css/app.css">
<link rel="shortcut icon" href="/Shoesgone/resources/plugins/assets/images/favicon.svg" type="image/x-icon">
</head>
<body>
	<%-- Menubar --%>
	<%@ include file="../common/menubar.jsp" %>
		
	<%-- Banner --%>
	<%@ include file="../common/buy_banner.html" %>
	
	<%-- Main Content --%>
	<%-- 사이즈 선택 --%>
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="your-class">
						<%
						for (Picture p : plist) {
						%>
						<div>
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/<%=p.getPicturepath()%>" alt="">
						</div>
						<%
						}
						%>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text" style="margin-top: 0px">
						<h3><%= itemEngName %></h3>
						<h4><%= itemKrName %></h4>
						<ul class="list">
							<li><a class="active" href="#"><span>카테고리</span> : nike_dunk_low</a></li>
							<li><a href="#"><span>사이즈</span> : In 180mm</a></li>
							<li><a href="#"><span>발매년도</span> : 2021-06-07</a></li>
						</ul>
						<hr>
						<div class="button-group-area mt-10">
							<h2>원하는 상품을 선택해주세요.</h2>
							<table class="table table-striped" id="table1">
								<thead>
									<tr>
										<th>제품명</th>
										<th>등록일</th>
										<th>가격</th>
										<th>구매하기</th>
									</tr>
								</thead>
								<tbody>
									<% for(ItemRegSta r : rlist){ %>
										<tr>
											<td><%= itemEngName %></td>
											<td><%= r.getRegDate() %></td>
											<td><%= r.getPrice() %></td>
											<td><form action="/Shoesgone/menubarsearch?menu=orderselect">
												<input type="hidden" name="menu" value="orderselect">
												<input type="hidden" name="itemno" value="<%= r.getItemNo() %>">
												<input type="hidden" name="regno" value="<%= r.getRegNo() %>">
												<input type="submit" value="구매하기">
											</form></td>
										</tr>
									<% } %>
								</tbody>
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
	<%-- 사이즈 선택 --%>

	<%-- 연관 상품 --%>
	<section class="related-product-area section_gap_bottom">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-6 text-center">
					<div class="section-title">
						<h1>Deals of the Week</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-9">
					<div class="row">
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r1.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r2.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r3.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r5.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r6.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6 mb-20">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r7.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r9.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r10.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-4 col-md-4 col-sm-6">
							<div class="single-related-product d-flex">
								<a href="#"><img src="/Shoesgone/resources/img/r11.jpg" alt=""></a>
								<div class="desc">
									<a href="#" class="title">Black lace Heels</a>
									<div class="price">
										<h6>$189.00</h6>
										<h6 class="l-through">$210.00</h6>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="ctg-right">
						<a href="#" target="_blank"> <img
							class="img-fluid d-block mx-auto"
							src="/Shoesgone/resources/img/category/c5.jpg" alt="">
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%-- 연관 상품 --%>
	
	<%-- Footer --%>
	<%@ include file="../common/footer.jsp" %>
	
	<%-- JS --%>
	<script src="/Shoesgone/resources/plugins/assets/js/main.js"></script>
	<script src="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script src="/Shoesgone/resources/plugins/assets/js/bootstrap.bundle.min.js"></script>

	<script src="/Shoesgone/resources/plugins/assets/vendors/simple-datatables/simple-datatables.js?after"></script>
	<script>
        // Simple Datatable
        let table1 = document.querySelector('#table1');
        let dataTable = new simpleDatatables.DataTable(table1);
    </script>
</body>
</html>