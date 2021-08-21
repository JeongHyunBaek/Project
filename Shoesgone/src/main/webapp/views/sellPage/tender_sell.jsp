<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="itemPage.model.vo.Item, itemPage.model.vo.Picture, java.util.ArrayList"
%>
<%
Item item = (Item) request.getAttribute("item");
ArrayList<Picture> plist = (ArrayList<Picture>) request.getAttribute("plist");
int size = Integer.parseInt(request.getParameter("size"));
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
</head>
<body>
	<%-- Menubar --%>
	<%@ include file="../common/menubar.jsp" %>
		
	<%-- Banner --%>
	<%@ include file="../common/sell_banner.html" %>
	
	<%-- Main Content --%>
	<!-- Start body Area -->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="your-class">
						<%
							for (Picture p : plist) {
						%>
						<div>
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/<%= p.getPicturepath() %>" alt="">
						</div>
						<%
							}
						%>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3>입찰 판매하기</h3>
						<h3><%= item.getItemEngName() %></h3>
						<h4><%= item.getItemKrName() %></h4>
						<a class="primary-btn">최저 판매가 : <%= item.getPrice() + "원" %></a><br>
						<form action="/Shoesgone/menubarsearch?menu=nowsell">
							<input type="hidden" name="menu" value="nowsell">
							<input type="hidden" name="itemno" value="<%= item.getItemNo() %>">
							<input type="hidden" name="size" value="<%= size %>">
							<input class="primary-btn" type="submit" value="즉시 구매가 : <%= item.getPrice() + "원" %>">
						</form><br>
						<a class="primary-btn"><span>Size</span> : <%= size %></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section class="checkout_area section_gap">
		<div class="container">
			<h3>입찰 기간 선택</h3>
			<hr>
			<input type="radio" id="confirm-radio"> 1일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="confirm-radio"></label>
			<input type="radio" id="confirm-radio" checked="checked"> 7일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="confirm-radio"></label>
			<input type="radio" id="confirm-radio"> 14일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="confirm-radio"></label>
			<input type="radio" id="confirm-radio"> 30일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label for="confirm-radio"></label>
			<input type="radio" id="confirm-radio"> 60일
			<label for="confirm-radio"></label>
			<p>(입찰 마감 기한 : yyyy년 mm월 dd일)</p>
			<hr>
			<div class="billing_details">
				<div class="row">
					<div class="col-lg-8">
						<h3>배송지 입력</h3>
						<form class="row contact_form" action="/Shoesgone/regteninsert" method="post" novalidate="novalidate">
							<input type="hidden" name="userno" value="<%= loginMember.getUserNo() %>">
							<input type="hidden" name="userid" value="<%= loginMember.getUserId() %>">
							<input type="hidden" name="itemno" value="<%= item.getItemNo() %>">
							<div class="col-md-6 form-group p_star">
								<h3>판매 상품 정보 입력</h3>
								<input type="text" class="form-control" id="itemname" name="itemname" value="<%= item.getItemEngName() + "(" + item.getItemKrName() + ")" %>" readonly><br>
								<input type="number" class="form-control" id="size" name="size" value="<%= size %>" readonly><br>
								<input type="number" class="form-control" id="price" name="price" placeholder="희망 판매가" required>
								<br>
								<h3>반품 배송지 입력</h3>
								<input type="text" class="form-control" id="username" name="username" placeholder="이름" value="<%= loginMember.getUserName() %>" required><br>
								<input type="tel" class="form-control" id="phone" name="phone" placeholder="전화번호" value="<%= loginMember.getPhone() %>" required><br>
								<input type="email" class="form-control" id="email" name="email" placeholder="이메일" value="<%= loginMember.getEmail() %>" required><br>
								<input type="text" class="form-control postcodify_postcode5" id="post" name="post" placeholder="우편번호" required>
								<button type="button" id="postcodify_search_button" onclick="searchaddress();">검색</button><br><br>
								<input type="text" class="form-control postcodify_address" id="address" name="address" placeholder="주소" required><br>
								<input type="text" class="form-control postcodify_extra_info" id="detailaddress" name="detailaddress" placeholder="상세주소" required><br>
							</div>
					</div>
					<div class="col-lg-4">
						<div class="order_box">
							<h2>등록 상품</h2>
							<ul class="list">
								<li><a href="#">제품명 <span>가격</span></a></li>
								<li><a href="#"><%= item.getItemKrName() %> <div id="last" class="last"> </div></a></li>
							</ul>
							<ul class="list list_2">
								<li><a>배송비 <span>2500</span></a></li>
								<li><a>정산비용 <span>152500</span></a></li>
							</ul>
							<hr>
							<div class="default-select" id="default-select"">
								<select name="penalty" required>
									<option value="계좌이체">계좌이체</option>
									<option value="카드결제">카드결제</option>
								</select>
							</div>
							<br>
							<div class="creat_account">
								<input type="checkbox" id="f-option4" name="selector" required>
								<label for="f-option4"><a href="#">검수 기준</a>과 <a href="#">개인 정보 정책</a>에 동의합니다. </label>
							</div>
							<input type="submit" value="상품 등록하기"> &nbsp;
							<input type="reset" value="등록취소">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End body Area -->
	
	<%-- Footer --%>
	<%@ include file="../common/footer.jsp" %>
	
</body>
</html>