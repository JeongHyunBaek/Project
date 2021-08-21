<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="loginPage.model.vo.Login, information.model.vo.Information"%>
    
    <%
	Information information = (Information)request.getAttribute("information"); 

	

%>  
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>회원정보수정</title>
	<script type="text/javascript" src="/Shoesgone/resources/js/jquery-3.6.0.min.js"></script>
	<!--
            CSS
            ============================================= -->
         ============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/linearicons.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/nouislider.min.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
	<style type="text/css">
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
					
				</div>
			</div>
		</div>
	</section>
	
	<!--================Contact Area =================-->

	
	<section>
	<div><br><br><br>
	
	
<h2 align="center">회원정보수정</h2><br>
<hr>
<form id="iform" method="post" action="/Shoesgone/menubarsearch?menu=iupdate" >
<!-- 제출시(전송시 : submit 버튼 눌렀을 때)에 
유효성검사 실행되도록 함 
결과가 false 일 때 전송을 취소되게 해야 하므로 
return 함수명() 으로 실행해야 됨. 
onsubmit="return checkAll();"
-->

<table align="center" width="600">
<tr><th width="180">이름</th>
<td><input type="text" id="name" name="username" value="<%if(information.getUserName() != null){ %><%= information.getUserName() %><% }else{%><%}%>"></td></tr>
<tr><th width="180">아이디</th>
<td><input type="text" id="userid" name="userid" value="<%= information.getUserId() %>" readonly></td></tr>
<tr><th width="180">이메일</th>
<td><input type="email" id="email" name="email" value="<%if(information.getEmail() != null){ %><%= information.getEmail() %><% }else{%><%}%>" ></td></tr>
<tr><th width="180">*비밀번호</th>
<td><input type="password" id="userpwd" name="userpwd" size="30" placeholder="영문, 숫자, 특수문자 조합 8-16자" required><br>비밀번호를 입력하셔야 정보가 수정됩니다.</td></tr>
<tr><th width="180">*비밀번호 확인</th>
<td><input type="password" id="userpwd2" name="userpwd2" size="30" required><br></td></tr>
<tr><th width="180">휴대폰번호</th>
<td><input type="text" id="phone" name="phone" value="<%if(information.getPhone() != null){ %><%= information.getPhone() %><% }else{%><%}%>" ></td></tr>

<tr><th width="180">우편번호</th>
					<td>
						<input type="text" name="address" class="postcodify_postcode5" size="6" value="<%if(information.getAddress() != null){ String[] address = information.getAddress().split(","); %><%= address[0] %><%}else{%> <%}%>">
						<button type="button" id="postcodify_search_button" >검색</button>
					</td>
<tr>
					<th width="180">도로명주소</th>
					<td><input type="text" name="address" class="postcodify_address" value="<%if(information.getAddress() != null){ String[] address = information.getAddress().split(","); %><%= address[1] %><%}else{%> <%}%>"></td>
				</tr>
				<tr>
					<th width="180">상세주소</th>
					<td><input type="text" name="address" class="postcodify_extra_info" value="<%if(information.getAddress() != null){ String[] address = information.getAddress().split(","); %><%= address[2] %><%}else{%> <%}%>"></td>
				</tr>
				
							
					
					
					
					
					
					
<%-- <input type="text" name="address" id="address" size="50" value="<%if(information.getAddress() != null){ %><%= information.getAddress() %><% }else{%><%}%>"> --%>
<!-- <input type="text" name="address2" id="address" size="50"> -->
</td></tr>
<tr><th width="180">신발사이즈</th><td>
<select name="shoesize">
<option  value="<%= information.getShoesSize() %>" selected><%= information.getShoesSize() %></option>
<option value="215">215</option>
<option value="220">220</option>
<option value="225">225</option>
<option value="230">230</option>
<option value="235">235</option>
<option value="240">240</option>
<option value="245">245</option>
<option value="250">250</option>
<option value="255">255</option>
<option value="260">260</option>
<option value="265">265</option>
<option value="270">270</option>
<option value="275">275</option>
<option value="280">280</option>
<option value="285">285</option>
<option value="290">290</option>
<option value="295">295</option>
<option value="300">300</option>
<option value="305">305</option>
<option value="310">310</option>
<option value="315">315</option>
<option value="320">320</option>
</select>
</td></tr>
<tr><th width="180">은행명</th><td>
<select name="bankname">
<option  value="<%= information.getBankName() %>" selected ><%if(information.getBankName() != null){ %><%= information.getBankName() %><% }else{%><%}%></option>
  	<option value="기업은행">기업은행</option>
	<option value="국민은행">국민은행</option>
	<option value="외환은행">외환은행</option>
	<option value="수협">수협</option>
	<option value="농협">농협</option>
	<option value="우리은행">우리은행</option>
	<option value="제일은행">제일은행</option>
	<option value="씨티은행">씨티은행</option>
	<option value="대구은행">대구은행</option>
	<option value="부산은행">부산은행</option>
	<option value="광주은행">광주은행</option>
	<option value="제주은행">제주은행</option>
	<option value="전북은행">전북은행</option>
	<option value="경남은행">경남은행</option>
	<option value="새마을금고">새마을금고</option>
	<option value="신협">신협</option>
	<option value="우체국">우체국</option> 
	<option value="하나은행">하나은행</option>
	<option value="신한은행">신한은행</option>
 
</select>
</td></tr>
<tr><th width="180">계좌번호</th>
<td><input type="text" id="accountno" name="accountno" size="50" value="<%if(information.getAccountNo() != null){ %><%= information.getAccountNo() %><% }else{%><%}%>" ></td></tr>

<tr><th colspan="2">
<br>
<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
		<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
	<center><input type="submit" value="수정하기" class="genric-btn primary small" >&nbsp;
	<a href="/Shoesgone/menubarsearch?menu=mypage" class="genric-btn primary small">목록보기</a></center>
	
	
</th></tr>
</table><hr><br><br><br>
</form>
</div>
</section>
	<!--================Contact Area =================-->

	<!-- start footer Area -->
	<%@ include file="../common/footer.jsp" %>
	<!-- End footer Area -->

	<!--================Contact Success and Error message Area =================-->
	<div id="success" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Thank you</h2>
					<p>Your message is successfully sent...</p>
				</div>
			</div>
		</div>
	</div>

	<!-- Modals error -->

	<div id="error" class="modal modal-message fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Sorry !</h2>
					<p> Something went wrong </p>
				</div>
			</div>
		</div>
	</div>
	<!--================End Contact Success and Error message Area =================-->

	
		<script src="/Shoesgone/resources/js/vendor/jquery-2.2.4.min.js"></script>
		<script type="text/javascript" src="/Shoesgone/resources/js/jquery-3.6.0.min.js"></script>
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
				<script>
					/*  검색 단추를 누르면 팝업 레이어가 열리도록 설정한다. */
					$(function(){
						$("#postcodify_search_button").postcodifyPopUp();
					});
				</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	 crossorigin="anonymous"></script>
	<script src="/Shoesgone/resources/js/vendor/bootstrap.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.nice-select.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.sticky.js"></script>
	<script src="/Shoesgone/resources/js/nouislider.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="/Shoesgone/resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="/Shoesgone/resources/js/gmaps.min.js"></script>
	<script src="/Shoesgone/resources/js/main.js"></script>
<script src="/Shoesgone/resources/js/jquery-validation-1.19.3/dist/jquery.validate.min.js"></script>
<!-- 유효성검사 자바스크립트 -->
<script type="text/javascript">
	


	$("#iform").validate({
		rules: {
		    userpwd: {
		    	required : true,
		    	pw_regexp: true,
		    	minlength: 8,
		    	maxlength: 16
			}
		  },
		  messages: {
		   
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
	
	$(function(){ $("#alert-success").hide(); 
	$("#alert-danger").hide(); $("input").keyup(
	function(){ 
	var pwd1=$("#userpwd").val(); 
	var pwd2=$("#userpwd2").val(); 
	if(pwd1 != "" || pwd2 != ""){ 
		if(pwd1 == pwd2){ $("#alert-success").show(); 
		$("#alert-danger").hide(); $("#submit").removeAttr("disabled"); 
		}else{ $("#alert-success").hide(); $("#alert-danger").show(); 
		$("#submit").attr("disabled", "disabled"); } } }); });



	
</script>



</body>
</html>