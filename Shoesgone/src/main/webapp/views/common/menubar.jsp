<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="loginPage.model.vo.Login"%>
<%
	// 로그인 확인을 위해서 내장된 session 객체를 이용
	Login loginMember = (Login)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="/Shoesgone/resources/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title></title>
	
	<!--
		CSS
		============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/linearicons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nouislider.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/newMine.css">	
</head>
<body>
	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="/Shoesgone/index.jsp">슈즈곤</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/itemPage/category.jsp">SHOP</a></li>
							<% if(loginMember != null){ %>
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/customerservicePage/customerservice.jsp">고객센터</a></li>
							<% } %>
							<% if(loginMember == null){ %>
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/loginPage/login.jsp">로그인</a></li>
							<% }else{ %>
							<li class="nav-item"><a class="nav-link" onclick="javascript:location.href='/Shoesgone/logout';">로그아웃</a></li>
							<% } %>
							<li class="nav-item submenu dropdown active">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">커뮤니티</a>
								<ul class="dropdown-menu">
									<li class="nav-item active"><a class="nav-link" href="/Shoesgone/views/community/best/bestListView.jsp">Best 게시판</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/community/review/reviewListView.jsp">리뷰 게시판</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/community/gallery/galleryListView.jsp">Gallery</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/community/free/freeListView.jsp">자유게시판</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/community/qna/qnaListView.jsp">Q&A</a></li>
								</ul>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li class="nav-item">
								<button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
							</li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
		<div class="search_input" id="search_input_box">
			<div class="container">
				<form class="d-flex justify-content-between">
					<input type="text" class="form-control" id="search_input" placeholder="Search Here">
					<button type="submit" class="btn"></button>
					<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
				</form>
			</div>
		</div>
	</header>
	<!-- End Header Area -->
</body>
</html>