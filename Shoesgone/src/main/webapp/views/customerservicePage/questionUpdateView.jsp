<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="loginPage.model.vo.Login, question.model.vo.Question"%>
<% 

Question question = (Question)request.getAttribute("question");

%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">

<head>
<!-- Mobile Specific Meta -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
<title>고객센터</title>
<!--
            CSS
            ============================================= -->
<link rel="stylesheet" href="/Shoesgone/resources/css/linearicons.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
<link rel="stylesheet"
	href="/Shoesgone/resources/css/font-awesome.min.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
<link rel="stylesheet"
	href="/Shoesgone/resources/css/nouislider.min.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
<style type="text/css">
#floatdiv {

    position:fixed; _position:absolute; _z-index:-1;

    width:100px;

    display:inline-block;/* overflow:hidden;  같은 의미? */

    right:0px; /* //화면 오른쪽에 위치한다. left로 변경가능 */

    top:20%; /* //화면 위쪽과의 간격 */

    background-color: transparent;

    margin:0;

}

#floatdiv ul  { list-style: none; }

#floatdiv li  { margin-bottom: 2px; text-align: left; }

#floatdiv a   { color: #5D5D5D; border: 0; text-decoration: none; display: float; }

#floatdiv a:hover, #floatdiv .menu  { background-color: #5D5D5D; color: #fff; } /* 마우스오버 시 배경/글씨 색깔 */

#floatdiv .menu, #floatdiv .last    { margin-bottom: 0px; }

 

 

#floatContent {

    padding:5px;

border-width: 2px;

border-color: #7f7f7f;

border-style: solid;

border-bottom-left-radius: 10px;

border-bottom-right-radius: 10px;

}

 

#floatTitle {

width:100px;

height:30px;

line-height:30px;

background-color: #7f7f7f;

/* 텍스트 */

color: #fff;

text-align: center;

text-decoration: none;

font-weight:bold;

font-size:12px;

/* 모양 */

border-top-left-radius: 10px;

border-top-right-radius: 10px;

 

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
			<div
				class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>고객센터</h1>
					
				</div>
			</div>
		</div>
	</section>

	<!--================Contact Area =================-->
	<section>
		<br>
		<br>
		<br>
		<article>

			<div class="container" role="main">

				<h2>1:1문의</h2>

				<div class="row">
					<form action="/Shoesgone/menubarsearch?menu=quupdate" method="post">
					<input type="hidden" name="qnum" value="<%= question.getQuestionNo() %>">	
					
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd; width: 1000px;">

							<thead>
								<tr>
									<th colspan="2"
										style="background-color: #eeeeee; text-align: center;">게시판
										글쓰기 양식</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="text" class="form-control"
										name="title" maxlength="50"
										style="width: 950px;" value="<%= question.getQuestionTitle()%>" required></td>
								</tr>
								<tr>
									
									<td><input type="text" class="form-control" name="writer" style="width: 950px;" readonly
										value="<%= loginMember.getUserId() %>"></td>
								</tr>
								<tr>
									<td><textarea class="form-control" "
											name="content" maxlength="2048"
											style="width: 950px; height: 350px;" required><%= question.getQuestionContent() %></textarea></td>
								</tr>
							</tbody>
						</table>
						<!-- 글쓰기 버튼 생성 -->
						<center>
							<input type="submit" value="수정하기"
								class="genric-btn primary small"> &nbsp; <input
								type="reset" value="작성취소" class="genric-btn primary small">
							&nbsp; <input type="button" value="목록"
								class="genric-btn primary small"
								onclick="javascript:location.href='/Shoesgone/menubarsearch?menu=questionpage&page=1'; return false;">
						</center>
					</form>
				</div>

			</div>






			<div></div>
			<br>
			<br>
			<br>

			</div>

		</article>

					<div id="floatdiv">

<div id="floatTitle">상담채널</div>

<div id="floatContent">

<ul>

<li>

<a href="http://pf.kakao.com/_Ahxoas"><img src="/Shoesgone/resources/img/kakach.png" width = "80px"></a>

</li>

<li>


<a href="#" onclick="window.open('https://console.dialogflow.com/api-client/demo/embedded/6178e851-ef1a-409a-a182-c4828ae3b8b2','챗봇','resizable=no width=600 height=500');return false"><img src="/Shoesgone/resources/img/chatbot.jpg" width = "80px"></a>
</li>

</ul>

</div>



<!-- //floatMenu -->

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
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
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
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<i class="fa fa-close"></i>
					</button>
					<h2>Sorry !</h2>
					<p>Something went wrong</p>
				</div>
			</div>
		</div>
	</div>
	<!--================End Contact Success and Error message Area =================-->


	<script src="/Shoesgone/resources/js/vendor/jquery-2.2.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script src="/Shoesgone/resources/js/vendor/bootstrap.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.ajaxchimp.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.nice-select.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.sticky.js"></script>
	<script src="/Shoesgone/resources/js/nouislider.min.js"></script>
	<script src="/Shoesgone/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="/Shoesgone/resources/js/owl.carousel.min.js"></script>
	<!--gmaps Js-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="/Shoesgone/resources/js/gmaps.min.js"></script>
	<script src="/Shoesgone/resources/js/main.js"></script>
</body>

</html>