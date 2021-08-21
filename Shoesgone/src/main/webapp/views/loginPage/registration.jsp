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
		.error-info{
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
		details[open] > summary ~ * { 
			animation:reveal 0.5s;
			margin-left: 45px;
		}
		.tpt { 
			color: black; 
		}
		.cursor-pointer {
			cursor: pointer;
		}
		#size-table{
			margin-left: auto;
			margin-right: auto;
		}
		#shoes-pants{
			width: 70px;
			height: 35px;
			background-color: white;
			border-color: grey;
		}
		.hidden {
			height:100%; 
			min-height:100%; 
			overflow:hidden !important; 
			touch-action:none;
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
								<input type="text" class="form-control popOpenBtnCmmn" id="shoesSize" name="shoesSize" data-num="6" readonly placeholder="선택하세요(클릭)" onfocus="this.placeholder = ''" onblur="this.placeholder = '선택하세요(클릭)'">
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">이름 *</h6>
								<input type="text" class="form-control" id="username" name="username" placeholder="예) 홍길동" onfocus="this.placeholder = ''" onblur="this.placeholder = '예) 홍길동'">
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">전화번호 *</h6>
								<input type="text" class="form-control" id="phone" name="phone" placeholder="예) 01012345678" onfocus="this.placeholder = ''" onblur="this.placeholder = '예) 01012345678'">
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">우편번호 *</h6>
								<input type="text" class="form-control postcodify_postcode5 cursor-pointer" id="postcodify_search_button" name="address1" size="6" readonly placeholder="우편번호(클릭)" onfocus="this.placeholder = ''" onblur="this.placeholder = '우편번호(클릭)'">
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">도로명 주소 *</h6>
								<input type="text" class="form-control postcodify_address" id="streetaddress" name="address2" readonly placeholder="도로명 주소" onfocus="this.placeholder = ''" onblur="this.placeholder = '도로명 주소'">
							</div>
							<div class="col-md-12 form-group">
							<h6 class="register-info">상세 주소 *</h6>
								<input type="text" class="form-control postcodify_extra_info" id="detailaddress" name="address3" placeholder="상세 주소" onfocus="this.placeholder = ''" onblur="this.placeholder = '상세 주소'">
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
						<div id="popUp_6" class="popCmmn">
							<div class="popBg" data-num="6" ></div>
							<div class="popInnerBox" style="overflow: auto;">
						    	<div class="popHead">사이즈 선택
							    	<span class="popCloseBtnCmmn" id="close-button" data-num="6">&times;</span>
						    	</div>
						    	<div class="popBody">
						    		<table id="size-table">
										<tr>
											<td><input class="cursor-pointer" type=button value="220" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="225" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="230" id="shoes-pants"></td>
										</tr>
										<tr>
											<td><input class="cursor-pointer" type=button value="235" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="240" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="245" id="shoes-pants"></td>
										</tr>
										<tr>
											<td><input class="cursor-pointer" type=button value="250" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="255" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="260" id="shoes-pants"></td>
										</tr>
										<tr>
											<td><input class="cursor-pointer" type=button value="265" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="270" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="275" id="shoes-pants"></td>
										</tr>
										<tr>
											<td><input class="cursor-pointer" type=button value="280" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="285" id="shoes-pants"></td>
											<td><input class="cursor-pointer" type=button value="290" id="shoes-pants"></td>
										</tr>
										<tr>
											<td><input class="cursor-pointer" type=button value="295" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size16'"></td>
											<td><input class="cursor-pointer" type=button value="300" id="shoes-pants" onclick="location.href='/Shoesgone/menubarsearch?menu=size17'"></td>
										</tr>
									</table>
								</div>
						    </div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->

	<%@ include file="../common/footer.jsp" %>
	
	<script src="/Shoesgone/resources/js/jquery-validation-1.19.3/dist/jquery.validate.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	<script>
		/*  검색 단추를 누르면 팝업 레이어가 열리도록 설정한다. */
		$(function(){
			$("#postcodify_search_button").postcodifyPopUp();
		});
	</script>
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
				},
				username : {
					required : true
				},
				phone : {
					required : true,
					telnum : true
				},
				address1 : {
					required : true
				},
				address2 : {
					required : true
				},
				address3 : {
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
				},
				username : {
					required : "이름을 입력해주세요."
				},
				phone : {
					required : "전화번호를 정확히 입력해주세요.",
					telnum : "전화번호를 정확히 입력해주세요."
				},
				address1 : {
					required : ""
				},
				address2 : {
					required : ""
				},
				address3 : {
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
		
		$.validator.addMethod("telnum", function(telnum, element){
		      var pattern = /^01[016789]{1}[0-9]{3,4}[0-9]{4}$/;

		      if(!pattern.test(telnum)){
		        return this.optional(element)||false;
		      }
		      return true;
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
	
	<script>
		$('.cursor-pointer').click(function(){
			var div = document.getElementById('popUp_6');
			
			$('#shoesSize').val(this.value);
			
			div.style.display = 'none';
		});
	</script>
</body>
</html>