<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Login login = (Login)request.getAttribute("login"); %>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>비밀번호 찾기</title>
	
	<style>
		#temp-email{
			text-align: center;
			color: black;
		}
		#pwd-print{
			font-size: 15px;
			color: black;
			font-weight: bold;
		}
	</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>

	<!-- Start Banner Area -->
		<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>비밀번호 찾기</h1>
					<nav class="d-flex align-items-center">
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->

	<!--================Login Box Area =================-->
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="login_form_inner">
						<form class="row login_form" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<h6 id="temp-email">임시 비밀번호를 전송하였습니다.</h6>
								<h6 id="temp-email">전송 받은 임시 비밀번호로 로그인해주세요.</h6>
							</div>
							<div class="col-md-12 form-group">
								<p id="pwd-print"><%= login.getUserPwd() %></p>
 							</div>
							<div class="col-md-12 form-group">
								<button type="button" value="submit" class="primary-btn" onclick="location.href='/Shoesgone/menubarsearch?menu=login';">로그인</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->

	<%@ include file="../common/footer.jsp" %>
</body>
</html>