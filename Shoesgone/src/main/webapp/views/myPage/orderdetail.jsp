<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="orderlist.model.vo.Orderlist" %>    
<%
Orderlist orderlist = (Orderlist)request.getAttribute("orderlist");
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%> 
<!DOCTYPE html>
<html>

<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>주문상세보기</title>
<style type="text/css">

.orderdetail{
	align : center;
}
.th{
 text-align : center;
}
.page_wrap {
	text-align:center;
	font-size:0;
 }
.page_nation {
	display:inline-block;
}
.page_nation .none {
	display:none;
}
.page_nation a {
	display:block;
	margin:0 3px;
	float:left;
	border:1px solid #e6e6e6;
	width:28px;
	height:28px;
	line-height:28px;
	text-align:center;
	background-color:#fff;
	font-size:13px;
	color:#999999;
	text-decoration:none;
}
.page_nation .arrow {
	border:1px solid #ccc;
}
.page_nation .pprev {
	background:#f8f8f8 url('img/page_pprev.png') no-repeat center center;
	margin-left:0;
}
.page_nation .prev {
	background:#f8f8f8 url('img/page_prev.png') no-repeat center center;
	margin-right:7px;
}
.page_nation .next {
	background:#f8f8f8 url('img/page_next.png') no-repeat center center;
	margin-left:7px;
}
.page_nation .nnext {
	background:#f8f8f8 url('img/page_nnext.png') no-repeat center center;
	margin-right:0;
}
.page_nation a.active {
	background-color:#42454c;
	color:#fff;
	border:1px solid #42454c;
}
	</style>
	
</head>

<body>

	<!-- Start Header Area -->
	<%@ include file="../common/menubar.jsp" %>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>마이페이지</h1>
					<nav class="d-flex align-items-center">
					</nav>
				</div>
			</div>
		</div>
	</section>
	
	<!--================Contact Area =================-->
	<section><br><br><br>
	
    <div class="title">
        <h2 align="center">주문상세보기</h2><hr><br>
    </div>
   
    <div class="order_detail_1" align="center">
    <div class="order_detail_2">
				<h3 class="order_detail_tit" text-align="center" align="center" >주문 정보</h3>
				
				<table class="tbl" cellspacing="0" border="1" summary="정보" width="600px" style="text-align:center;">
					
						<colgroup>
						<col width="140">
						<col width="*">
						</colgroup>
					<tbody>
					<tr>
						<th>주문번호 </th>
						<td><%= orderlist.getOrdersNo() %></td>
					</tr>
					<tr>
						<th>주문일</th>
						<td><%= orderlist.getPurDate() %></td>
					</tr>
					<tr class="last">
						<th>결제수단</th>
						<td><%= orderlist.getPayment() %></td>
					</tr>
					</tbody>
					</table>
					
					</div>
					
					<div class="order_detail_2"><br><br>
			
				<h3 class="order_detail_tit">배송지 정보
					
				</h3>
				<table class="tbl" cellspacing="0" border="1" summary="정보" width="600px" style="text-align:center;">
					
						<colgroup>
						<col width="140">
						<col width="*">
						</colgroup>
					<tbody>

					<tr>
						<th>배송지 주소</th>
						<td><%= orderlist.getAddress() %></td>
					</tr>

					<tr class="last">
						<th>
						<span>연락처</span>
						</th>
						<td><%= orderlist.getPhone() %></td>
					</tr>
					</tbody>
					</table><br><br>
			</div>
			  <div class="order_detail_2">
				<h3 class="order_detail_tit" text-align="center" align="center">상품정보</h3>
				
				<table class="tbl" cellspacing="0" border="1" summary="정보" width="600px" style="text-align:center;">
					
						<colgroup>
						<col width="140">
						<col width="*">
						</colgroup>
					<tbody>
			
					<tr>
						<th>주문상품</th>
						<td colspan = 2><a href="/Shoesgone/menubarsearch?menu=item<%= orderlist.getItemNo() %>"><%= orderlist.getItemEngName() %><br><%= orderlist.getItemKrName() %></a></td>
					</tr>
					<tr class="last">
						<th>사이즈</th>
						<td><%= orderlist.getShoesSize() %></td>
					</tr>
					</tbody>
					</table>
					
					</div>
			</div>
			<br>
			<div class="order_calculate_area_n mt30" align="center">
						<!--20201113 총 상품금액영역 UI 변경-->
						<div class="order_deal_price_n_4_n">
							<div class="order_deal_price_n_txt">
							<div class="order_h_area_n">
							<strong>총 상품금액</strong>
							</div>
							<div class="order_result_area_n">
							<em><span><%= orderlist.getPrice() %></span></em>
							<span class="won">원</span>
							</div>
							
						</div>
					</div>

					<!--//20201113 총 상품금액영역 UI 변경-->
						<span class="order_minus_n_4_1">-</span>

						<div class="order_deal_price_n_4">
							<div class="order_h_area_n">
							<strong><span class="cart_fcT2">추가할인(적립금)</span></strong>
							</div>
							<div class="order_result_area_n">
								<em><span class="cart_fcT2"><%= orderlist.getPoint() %></span></em>
								<span class="won"><span class="cart_fcT2">원</span></span>
							</div>
						</div>

						<span class="order_plus_n_4">+</span>

						<div class="order_deal_price_n_4">
							<div class="order_h_area_n">
							<strong>총 배송비</strong>
							</div>
							<div class="order_result_area_n">
							<em><span><%= orderlist.getDelFee() %></span></em>
							<span class="won">원</span>
							</div>
						</div>

						<span class="order_equal_n_4">=</span>

						<div class="order_deal_payment_n_4">
							<div class="order_h_area_n">
							<strong><em class="cart_fcT3">총 결제금액</em></strong>
							</div>
							<div class="order_result_area_n">
								<em><span class="cart_fcT3"><%= orderlist.getPrice() - orderlist.getPoint() + orderlist.getDelFee() %></span></em>
								<span class="won"><span class="cart_fcT3">원</span></span><br><br>
							</div>
						</div>
					</div>
					<center><button onclick="javascript:history.go(-1);" class="genric-btn primary">목록</button></a></center><br><br>
</section>
	<!--================Contact Area =================-->

	<!-- start footer Area -->
		<%@ include file="../common/footer.jsp" %>
	<!-- End footer Area -->

</body>

</html>