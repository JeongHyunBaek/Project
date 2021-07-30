<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>회원가입</title>

	<style>
		#userid-error{
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
		.agree-check{
			color: black;
			margin-left: 5px;
		}
		details[open] > summary ~ * { animation:reveal 0.5s; margin-left: 45px;}
		.tpt { color: black; }
	</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<!-- Start Banner Area -->
		<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>회원가입</h1>
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
						<h1>회원가입</h1><br>
						<form class="row login_form" action="/Shoesgone/enroll" method="post" id="contactForm" novalidate="novalidate">
							
							<div class="col-md-12 form-group">
							<h6 class="register-info">이메일 주소 *</h6>
								<input type="email" class="form-control" id="userid" name="userid" placeholder="예) ShoesGone@shoes.co.kr" onfocus="this.placeholder = ''" onblur="this.placeholder = '예) ShoesGone@shoes.co.kr'">
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">비밀번호 *</h6>
								<input type="password" class="form-control" id="upwd" name="userpwd" placeholder="영문, 숫자, 특수문자 조합 8-16자" onfocus="this.placeholder = ''" onblur="this.placeholder = '영문, 숫자, 특수문자 조합 8-16자'">
								<!-- <p style="font-size:1px; color: red; margin-right:110px;">영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)</p> -->
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">신발 사이즈(선택)</h6>
								<input type="text" class="form-control" id="shoesSize" name="shoesSize" placeholder="선택하세요" onfocus="this.placeholder = ''" onblur="this.placeholder = '선택하세요'">
							</div>
							<div class="col-md-12 form-group">
								<div class="creat_account">
									<details>
										<summary class="agree-check"><label><input type="checkbox" id="ageAgree" name="ageAgree" onclick="ageCheckAll();">[필수] 만14세 이상이며 모두 동의합니다.</label></summary>
										<div class="tpt"><input type="checkbox" id="tos" name="tos" onclick="tos_pp_check();">이용약관</div>
										<div class="tpt"><input type="checkbox" id="privacyPolicy" name="privacyPolicy" onclick="tos_pp_check();">개인정보처리방침</div>
									</details>
									<details>
										<summary class="agree-check"><label><input type="checkbox" id="adAgree" name="adAgree" onclick="adCheckAll();">[선택] 광고성 정보 수신에 모두 동의합니다.</label></summary>
										<div class="tpt"><input type="checkbox" id="appPush" name="appPush" onclick="ap_msg_email();">앱 푸시</div>
										<div class="tpt"><input type="checkbox" id="message" name="message" onclick="ap_msg_email();">문자 메시지</div>
										<div class="tpt"><input type="checkbox" id="email" name="email" onclick="ap_msg_email();">이메일</div>
									</details>
								</div>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn">가입하기</button>
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
			rules : {
				userid : {
					required : true,
					email : true,
					remote : {
						type : "post",
						url : "/Shoesgone/validate"
					}
				},
				userpwd : {
					required : true,
					pw_regexp : true,
					minlength : 8,
					maxlength : 16
				},
				ageAgree : {
					required : true
				}
			},
			messages : {
				userid : {
					required : "이메일 주소를 정확히 입력해주세요.",
					email : "이메일 주소를 정확히 입력해주세요.",
					remote : "이미 사용 중인 이메일입니다."
				},
				userpwd : {
					required : "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)",
					pw_regexp : "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)",
					minlength : "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)",
					maxlength : "영문, 숫자, 특수문자를 조합하여 입력해주세요. (8-16자)"
				},
				ageAgree : {
					required : ""
				}
			},
			errorClass : "error-info"
		});

		$.validator.addMethod("pw_regexp", function(value, element) {
			return this.optional(element)
					|| /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/
							.test(value);
		});

		function ageCheckAll() {
			if ($("#ageAgree").is(':checked')) {
				$("input[name=tos]").prop("checked", true);
				$("input[name=privacyPolicy]").prop("checked", true);
			} else {
				$("input[name=tos]").prop("checked", false);
				$("input[name=privacyPolicy]").prop("checked", false);
			}
		}

		function adCheckAll() {
			if ($("#adAgree").is(':checked')) {
				$("input[name=appPush]").prop("checked", true);
				$("input[name=message]").prop("checked", true);
				$("input[name=email]").prop("checked", true);
			} else {
				$("input[name=appPush]").prop("checked", false);
				$("input[name=message]").prop("checked", false);
				$("input[name=email]").prop("checked", false);
			}
		}

		function tos_pp_check() {
			if($("#tos").is(':checked') && $("#privacyPolicy").is(':checked')){
				$("input[name=ageAgree]").prop("checked", true);
			}
			else{
				$("input[name=ageAgree]").prop("checked", false);
			}
		}
		
		function ap_msg_email() {
			if($("#appPush").is(':checked') && $("#message").is(':checked') && $("#email").is(':checked')){
				$("input[name=adAgree]").prop("checked", true);
			}
			else{
				$("input[name=adAgree]").prop("checked", false);
			}
		}
	</script>
</body>
</html>