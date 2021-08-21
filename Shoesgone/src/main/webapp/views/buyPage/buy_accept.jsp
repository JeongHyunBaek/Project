<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="itemPage.model.vo.Item, itemPage.model.vo.Picture, java.util.ArrayList"
%>
<%
Item item = (Item) request.getAttribute("item");
ArrayList<Picture> plist = (ArrayList<Picture>) request.getAttribute("plist");
ArrayList<Integer> isizes = (ArrayList<Integer>) request.getAttribute("isizes");
int userNo = 0;
Login loginmember = (Login)session.getAttribute("loginMember");
if(loginmember != null){
	userNo = loginmember.getUserNo();
}
%>
<!DOCTYPE html>
<html>
<head>
<!-- meta character set -->
<meta charset="UTF-8">

<%-- 페이지 이름 --%>
<title>Shoe's Gone</title>

<!-- CSS -->
<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.css"/>
<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css"/>
</head>
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
						<% for (Picture p : plist) { %>
							<div>
								<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/<%=p.getPicturepath()%>" alt="">
							</div>
						<% } %>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<form action="/Shoesgone/menubarsearch?menu=orlist">
						<input type="hidden" name="itemno" value="<%=item.getItemNo()%>">
						<input type="hidden" name="menu" value="orlist">
						<input type="hidden" name="itemengname" value="<%= item.getItemEngName() %>">
						<input type="hidden" name="itemkrname" value="<%= item.getItemKrName() %>">
						<input type="hidden" name="userno" value="<%= userNo %>">
						<div class="s_product_text">
							<h3>구매하시기 전에 꼭 확인하세요.</h3>
							<h3><%=item.getItemEngName()%></h3>
							<h4><%=item.getItemKrName()%></h4>
							<h2><%=item.getPrice()%>원</h2>
							<ul class="list">
								<li>
									<div class="default-select" id="default-select"">
										<select name="size" required>
											<option selected="selected">-- Size --</option>
											<%
											for (int size : isizes) {
											%>
											<option value="<%=size%>"><%=size%></option>
											<%
											}
											%>
										</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</div>
								</li>
							</ul>
							<div class="switch-wrap d-flex justify-content-between">
								<p>
									구매하려는 상품이 맞습니다. <input type="checkbox" id="primary-checkbox" checked required>
									<label for="primary-checkbox"></label><br>
									국내/해외에서 발매한 정품 상품입니다. <input type="checkbox" id="primary-checkbox" checked required>
									<label for="primary-checkbox"></label><br>
									제조사에서 불량으로 인정하지 않는 기준은 하자로 판단하지 않습니다. <input type="checkbox" id="primary-checkbox" checked required>
									<label for="primary-checkbox"></label><br>
									슈즈곤의 최신 이용정책을 모두 확인하였으며, 구매를 계속합니다. <input type="checkbox" id="primary-checkbox" checked required>
									<label for="primary-checkbox"></label>
								</p>
							</div>
							<div class="card_area d-flex align-items-center">
								<a href="/Shoesgone/menubarsearch?menu=check_buy_standard" class="genric-btn primary circle">검수기준</a> &nbsp; &nbsp;
								<input type="submit" value="즉시 구매" class="genric-btn primary circle">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- End body Area -->

	<%-- Footer --%>
	<%@ include file="../common/footer.jsp"%>

</body>
</html>