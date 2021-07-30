<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Login login = (Login)request.getAttribute("login"); %>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>아이디 찾기</title>
	
	<style>
		#email-success{
			font-size: 20px;
			color: black;
			font-weight: bold;
		}
		
		#email-address{
			text-align: center;
			color: grey;
			margin-left: 10px;
		}
		#email-address-print{
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
					<h1>아이디 찾기</h1>
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
						<p id=email-success>이메일 주소 찾기에 성공하였습니다.</p>
						<hr style="height: 1px;" width="30%" color="black"><br>
						<form class="row login_form" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<h6 id=email-address>이메일 주소</h6>
							</div>
							<div class="col-md-12 form-group">
								<p id=email-address-print><%= login.getUserId() %></p>
 							</div>
							<div class="col-md-12 form-group">
								<button type="button" value="submit" class="primary-btn" onclick="location.href = 'http://localhost:8080/Shoesgone/views/loginPage/searchPassword.jsp';">비밀번호 찾기</button>
							</div>
							<div class="col-md-12 form-group">
								<button type="button" value="submit" class="primary-btn" onclick="location.href = 'http://localhost:8080/Shoesgone/views/loginPage/login.jsp';">로그인</button>
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