<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Site Title -->
	<title>로그인</title>
	
	<!-- 네이버 로그인 라이브러리 -->
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  	
  	<!-- 카카오 로그인 라이브러리 -->
  	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  	<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
	
	<style>
		#uid-error{
			font-size:1px;
			color: red;
		}
		
		#upwd-error{
			font-size:1px;
			color: red;
		}
		
		.register-info{
			text-align: left;
			color: black;
			font-weight: bold;
			margin-left: 10px;
		}
		
		#search-id{
			color: grey;
			margin-right: 30px;
		}
		
		#search-pwd{
			color: grey;
			margin-left: 30px;
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
					<h1>로그인</h1>
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
				<div class="col-lg-6">
					<div class="login_box_img">
						<img class="img-fluid" src="/Shoesgone/resources/img/login.jpg" alt="">
						<div class="hover">
							<h4>New to our website?</h4>
							<p>There are advances being made in science and technology everyday, and a good example of this is the</p>
							<a class="primary-btn" href="/Shoesgone/menubarsearch?menu=registration">회원가입</a>
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="login_form_inner">
						<h3>슈즈곤</h3>
						<form class="row login_form" action="/Shoesgone/login" method="post" id="contactForm" novalidate="novalidate">
							<div class="col-md-12 form-group">
								<input type="email" class="form-control" id="uid" name="userid" placeholder="아이디" onfocus="this.placeholder = ''" onblur="this.placeholder = '아이디'">
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="upwd" name="userpwd" placeholder="비밀번호" onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호'">
							</div>
							
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">로그인</button>
								<!-- 네이버아이디로로그인 버튼 노출 영역 -->
								<div id="naver_id_login"></div>
 								<a href="https://kauth.kakao.com/oauth/authorize?client_id=999b3da31dfc63667c43a9de93bdc59d&redirect_uri=http://localhost:8080/Shoesgone/kakaologin&response_type=code">
 									<img src="/Shoesgone/resources/img/kakao_login_medium_narrow.png">
								</a>
							</div>
							<div class="col-md-12">
								  <a href="/Shoesgone/menubarsearch?menu=searchid" id="search-id">아이디 찾기 </a>
								  <a href="/Shoesgone/menubarsearch?menu=searchpassword" id="search-pwd">비밀번호 찾기</a>
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
	
	<!-- 네이버아이디로로그인 자바스크립트 -->
	<script>
		var naver_id_login = new naver_id_login("pLtvMVEvTQdyI5iaulw9",
				"http://localhost:8080/Shoesgone/views/loginPage/naverCallback.jsp");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("green", 3, 40);
		naver_id_login
				.setDomain("http://localhost:8080/Shoesgone/views/loginPage/login.jsp");
		naver_id_login.setState(state);
		naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>
	
	<!-- 유효성검사 자바스크립트 -->
	<script type="text/javascript">
		$("#contactForm").validate({
			rules: {
			    userid: {
			      required: true,
			      email: true
			    },
			    userpwd: {
			    	required: true,
			    	pw_regexp: true,
			    	minlength: 8,
			    	maxlength: 16
				}
			  },
			  messages: {
			    userid: {
			      required: "이메일 주소를 정확히 입력해주세요.",
			      email: "이메일 주소를 정확히 입력해주세요."
			    },
			    userpwd: {
			    	required: "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)",
			    	pw_regexp: "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)",
			    	minlength: "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)",
			    	maxlength: "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)"
			    }
			  },
			  errorClass: "error-info"
		});
		
		// 비밀번호 유효성 검사
		$.validator.addMethod("pw_regexp",  function( value, element ) {
			return this.optional(element) ||  /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/.test(value);
	   });
	</script>
</body>
</html>