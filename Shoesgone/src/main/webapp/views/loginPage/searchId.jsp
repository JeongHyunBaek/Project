<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>아이디 찾기</title>
	
	<style>
		#temp-email{
			text-align: left;
			color: black;
			margin-left: 10px;
		}
		
		#put-phone{
			text-align: left;
			color: black;
			font-weight: bold;
			margin-left: 10px;
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
						<h1>아이디 찾기</h1><br>
						<hr style="height: 1px;" width="30%" color="black"><br>
						<form class="row login_form" action="/Shoesgone/searchid" method="post" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<h6 id="temp-email">가입 시 등록한 휴대폰 번호를 입력하면</h6>
								<h6 id="temp-email">이메일 주소의 일부를 알려드립니다.</h6>
							</div>
							<div class="col-md-12 form-group">
								<h6 id="put-phone">휴대폰 번호</h6>
								<input type="tel" class="form-control" id="phone" name="phone" placeholder="가입하신 휴대폰 번호" onfocus="this.placeholder = ''" onblur="this.placeholder = '가입하신 휴대폰 번호'">
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">					
								</div>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">아이디 찾기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->

	<%@ include file="../common/footer.jsp" %>

	<script src="/Shoesgone/resources/js/jquery-validation-1.19.3/dist/jquery.validate.min.js"></script>
	<script type="text/javascript">
		$("#contactForm").validate({
			rules: {
			    phone: {
			      required: true,
			      telnum: true
			    }
			  },
			  messages: {
			    phone: {
			      required: "",
			      telnum: ""
			    }
			  }
		});
		
		$.validator.addMethod("telnum", function(telnum, element){
		      var pattern = /^01[016789]{1}[0-9]{3,4}[0-9]{4}$/;

		      if(!pattern.test(telnum)){
		        return this.optional(element)||false;
		      }
		      return true;
		});
	</script>
</body>
</html>