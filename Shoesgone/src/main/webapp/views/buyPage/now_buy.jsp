<%@page import="itemregsta.model.vo.ItemRegSta"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="itemPage.model.vo.Item"
	import="itemPage.model.vo.Item, itemPage.model.vo.Picture, java.util.ArrayList"%>
<%
Item item = (Item) request.getAttribute("item");
ArrayList<Picture> plist = (ArrayList<Picture>) request.getAttribute("plist");
ItemRegSta reg = (ItemRegSta) request.getAttribute("reg");
%>
<!DOCTYPE html>
<html>
<head>
<!-- meta character set -->
<meta charset="UTF-8">

<%-- 페이지 이름 --%>
<title>Shoe's Gone</title>

<link rel="stylesheet"
	href="/Shoesgone/resources/css/ion.rangeSlider.css" />
<link rel="stylesheet"
	href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css" />

</head>

<!-- jQuery와 Postcodify를 로딩한다. -->
<script>
	/*  검색 단추를 누르면 팝업 레이어가 열리도록 설정한다. */
	function searchaddress() {
		$("#postcodify_search_button").postcodifyPopUp();
	}
</script>

<body>
	<%-- Menubar --%>
	<%@ include file="../common/menubar.jsp"%>

	<%-- Banner --%>
	<%@ include file="../common/buy_banner.html"%>

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
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/<%=p.getPicturepath()%>" alt="">
						</div>
						<%
						}
						%>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
						<h3>즉시 구매하기</h3>
						<h3><%=item.getItemEngName()%></h3>
						<h4><%=item.getItemKrName()%></h4>
						<a class="primary-btn">즉시 구매가 : <%=item.getPrice() + "원"%></a><br>
						<form action="/Shoesgone/menubarsearch?menu=tenderbuy">
							<input type="hidden" name="menu" value="tenderbuy">
							<input type="hidden" name="itemno" value="<%= item.getItemNo() %>">
							<input type="hidden" name="size" value="<%= reg.getSize() %>">
							<input type="hidden" name="regno" value="<%= reg.getRegNo() %>">
							<input class="primary-btn" type="submit" value="최저 구매가 : <%=item.getPrice() + "원"%>">
						</form>
						<br> <a class="primary-btn"><span>Size</span> : <%= reg.getSize() %></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<section class="checkout_area section_gap">
		<div class="container">
			<div class="cupon_area">
				<div class="check_title">
					<h2>
						포인트 사용하기 <a href="#">(잔여 포인트 조회하기)</a>
					</h2>
				</div>
				<input type="text" placeholder="사용할 포인트를 입력해주세요.">
				<a class="tp_btn" href="#">포인트 적용</a>
			</div>
			<div class="billing_details">
				<div class="row">
					<div class="col-lg-8">
						<h3>배송지 입력</h3>
						<form class="row contact_form" action="/Shoesgone/menubarsearch?menu=orderinsert" method="post" novalidate="novalidate">
							<input type="hidden" name="menu" value="orderinsert">
							<input type="hidden" name="userno" value="<%=loginMember.getUserNo()%>">
							<input type="hidden" name="userid" value="<%=loginMember.getUserId()%>">
							<input type="hidden" name="itemno" value="<%=item.getItemNo()%>">
							<input type="hidden" name="price" value="<%= reg.getPrice() %>">
							<input type="hidden" name="sellerno" value="<%= reg.getUserNo() %>">
							<input type="hidden" name="size" value="<%= reg.getSize() %>">
							<div class="col-md-6 form-group p_star">
								<input type="number" class="form-control" id="size" name="size" placeholder="사이즈" value="<%= reg.getSize() %>" required readonly><br>
								<input type="text" class="form-control" id="username" name="username" placeholder="이름" value="<%=loginMember.getUserName()%>" required readonly><br>
								<input type="tel" class="form-control" id="phone" name="phone" placeholder="전화번호" value="<%=loginMember.getPhone()%>" required><br>
								<input type="email" class="form-control" id="email" name="email" placeholder="이메일" value="<%=loginMember.getEmail()%>" required><br>
								<input type="text" class="form-control postcodify_postcode5" id="post" name="post" placeholder="우편번호" required>
								<button type="button" id="postcodify_search_button" onclick="searchaddress();">검색</button><br><br>
								<input type="text" class="form-control postcodify_address" id="address" name="address" placeholder="주소" required><br>
								<input type="text" class="form-control postcodify_extra_info" id="detailaddress" name="detailaddress" placeholder="상세주소" required><br>
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<h3>배송 요청사항</h3>
								</div>
								<textarea class="form-control" name="etc" id="etc" rows="1" placeholder="배송시 요청사항(예:부재시 문 앞에 놓아주세요.)"></textarea>
							</div>
					</div>
					<div class="col-lg-4">
						<div class="order_box">
							<h2>Your Order</h2>
							<ul class="list">
								<li><a>제품명 <span>가격</span></a></li>
								<li><a href="#">슈즈곤 신발 1 <span class="middle">x 01</span> <span class="last">150000</span></a></li>
							</ul>
							<ul class="list list_2">
								<li><a href="#">제품 가격 총합 <span>150000</span></a></li>
								<li><a href="#">배송비 <span>2500</span></a></li>
								<li><a href="#">전체가격 <span>150000</span></a></li>
							</ul>
							<div class="default-select" id="default-select"">
								<select name="payment" required>
									<option value="무통장입금">무통장입금</option>
									<option value="가상계좌">가상계좌</option>
									<option value="신용카드">신용카드</option>
									<option value="모바일결제">모바일결제</option>
								</select>
							</div><br>
							<div class="creat_account">
								<input type="radio" id="f-option4" name="payment" value="account" required>
								<label for="f-option4"><a href="#">검수 기준</a>과 <a href="#">개인 정보 정책</a>에 동의합니다. </label>
							</div>
							<input type="submit" value="주문하기"> &nbsp;
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
	<%@ include file="../common/footer.jsp"%>

	<%-- JS --%>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
</body>
</html>