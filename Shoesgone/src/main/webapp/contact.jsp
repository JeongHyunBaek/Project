<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Shoesgone</title>
</head>

<body>
	<!-- Start Header Area -->
	<%@ include file="/views/common/menubar.jsp" %>
	<!-- End Header Area -->

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>마이페이지</h1>
					
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
<section class="features-area section_gap">
		<div class="container">
			<div class="row features-inner">
				<!-- single features -->
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<a href="/Shoesgone/menubarsearch?menu=olist<%= loginMember.getUserNo() %>"><img src="resources/img/joo.png" alt="" width="60px" height="60px"></a>
						</div>
						<h6>주문내역조회</h6>
						<p>주문하신 상품 내역을 <br>확인하실 수 있습니다.</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<a href="/Shoesgone/menubarsearch?menu=ilist<%= loginMember.getUserId() %>"><img src="resources/img/soo.png" alt="" width="60px" height="60px"></a>
						</div>
						<h6>회원정보수정</h6>
						<p>개인정보를 수정하고<br> 관리할 수 있습니다.</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<a href="/Shoesgone/menubarsearch?menu=plist<%= loginMember.getUserNo() %>"><img src="resources/img/point.png" alt="" width="60px" height="60px"></a>
						</div>
						<h6>포인트조회</h6>
						<p>보유하고 계신 포인트<br> 내역을 확인합니다.</p>
					</div>
				</div>
				<!-- single features -->
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<a href="/Shoesgone/menubarsearch?menu=wlist<%= loginMember.getUserNo() %>"><img src="resources/img/heart.png" alt="" width="60px" height="60px"></a>
						</div>
						<h6>관심상품</h6>
						<p>관심상품으로 등록하신<br> 상품을 확인합니다.</p>
					</div>
				</div>
				<br><br>
					<!-- single features -->
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-features">
						<div class="f-icon">
							<a href="/Shoesgone/menubarsearch?menu=rlist<%= loginMember.getUserNo() %>"><img src="resources/img/gg.png" alt="" width="60px" height="60px"></a>
						</div>
						<h6>나의글보기</h6>
						<p>나의 질문,답변,게시글 등을<br>
						한눈에 확인합니다.</p>
					</div>
				</div>
				<div class="col-lg-2 col-md-6 col-sm-6">
					<div class="single-features" style="border-right: none">
						<div class="f-icon">
							<a href="/Shoesgone/menubarsearch?menu=nlistcustomer"><img src="resources/img/goo.png" alt="" width="60px" height="60px"></a>
						</div>
						<h6>고객센터</h6>
						<p>
						고객센터페이지로<br> 이동합니다.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================Contact Area =================-->
	
	<!--================Contact Area =================-->

	<!-- start footer Area -->
	<%@ include file="/views/common/footer.jsp" %>
	<!-- End footer Area -->

</body>

</html>