<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="itemPage.model.vo.Item, itemPage.model.vo.Picture, itemPage.model.service.ItemDetailService, java.util.ArrayList"
%>
<%
int itemNo = Integer.parseInt(request.getParameter("itemno"));
int size = Integer.parseInt(request.getParameter("size"));
Item item = new ItemDetailService().selectOne(itemNo);
ArrayList<Picture> plist = new ItemDetailService().selectPList(itemNo);
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
	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_Product_carousel">
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
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text" style="margin-top: 0px">
						<h1>상품 판매 등록이 완료되었습니다.</h1>
						<h3><%= item.getItemEngName() %></h3>
						<h4><%= item.getItemKrName() %></h4>
						<h3>사이즈 : <%= size %></h3>
						<div class="card_area d-flex align-items-center">
							<a class="primary-btn" href="/Shoesgone/menubarsearch?menu=shop">계속 쇼핑 하기</a>
						</div>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->
	
	<%-- Footer --%>
	<%@ include file="../common/footer.jsp" %>

</body>
</html>