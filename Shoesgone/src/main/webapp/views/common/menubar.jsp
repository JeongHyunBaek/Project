<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="loginPage.model.vo.Login, categoryPage.model.vo.ItemPicture, java.util.ArrayList"%>
<%
	// 로그인 확인을 위해서 내장된 session 객체를 이용
	Login loginMember = (Login)session.getAttribute("loginMember");
	ArrayList<ItemPicture> search = (ArrayList<ItemPicture>)request.getAttribute("search");
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
	
	<style>
		.listBox{
			max-width: 500px;
		}
		
		.listInner{
			margin: 10px 5px;
			padding: 4px;
			display: none;
		}
		
		.engname{
			font-weight: bold;
			color: white;
		}
		
		.krname{
			color: white;
		}
		
		.picturepath{
			width: 20%;
		}
		
		.white-color{
			background-color: white;
		}
		
		.cursor-pointer{
			cursor: pointer;
		}
	</style>
</head>
<body>
	<!-- Start Header Area -->
	<header class="header_area sticky-header">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light main_box">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<a class="navbar-brand logo_h" href="/Shoesgone/menubarsearch?menu=main">슈즈곤</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
					 aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto">
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=shop">SHOP</a></li>
							<% if(loginMember != null){ %>
								<% if(loginMember.getMgr().toString().equals("Y")){ %>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/views/managerPage/adminIndex.jsp">관리자페이지</a></li>
								<% }else{ %>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=mypage">마이페이지</a></li>
								<% } %>
							<% } %>
							
							<% if(loginMember != null){ %>
								<% if(loginMember.getMgr().toString().equals("Y")){ %>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=nlistadmin">고객센터</a></li>
								<% }else{ %>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=nlistcustomer">고객센터</a></li>
								<% } %>
							<% } %>
							<li class="nav-item submenu dropdown active">
								<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
								 aria-expanded="false">Community Category</a>
								<ul class="dropdown-menu">
									<li class="nav-item active"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=best">Best 게시판</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=review">리뷰 게시판</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=gallery">Gallery</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=free">자유게시판</a></li>
									<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=qna">Q&A</a></li>
								</ul>
							</li>
							<% if(loginMember == null){ %>
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=login">로그인</a></li>
							<% }else{ %>
							<li class="nav-item"><a class="nav-link" href="/Shoesgone/menubarsearch?menu=logout">로그아웃</a></li>
							<% } %>
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
				<a class="d-flex justify-content-between">
					<input type="text" class="form-control" id="search_input" onkeyup="filter()" onKeypress="javascript:if(event.keyCode == 13) location.href='/Shoesgone/menubarsearch?menu=text&text=' + (this.value);" placeholder="브랜드명, 모델명, 모델번호 등">
					<button type="submit" class="btn"></button>
					<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
				</a>
			</div>
		    <div>
		    	<div class="listBox">
		    		<% for (ItemPicture ip: search){ %>
			    	<div class="listInner cursor-pointer" onclick="location.href='/Shoesgone/menubarsearch?menu=item<%= ip.getItemNo() %>'">
			    		<p><img class="picturepath" src="/Shoesgone/resources/img/shoes_images/<%= ip.getPicturepath() %>"><br>
			    		<span class="engname"><%= ip.getItemEngName() %></span><br>
			    		<span class="krname"><%= ip.getItemKrName() %></span></p>
			    		<hr class="white-color">
			      	</div>
			      	<% } %>
		      	</div>
		    </div>
		</div>
	</header>
	<!-- End Header Area -->
	
	<script>
      function filter() {
        let search = document.getElementById("search_input").value.toLowerCase();
        let listInner = document.getElementsByClassName("listInner");

        for (let i = 0; i < listInner.length; i++) {
          engname = listInner[i].getElementsByClassName("engname");
          krname = listInner[i].getElementsByClassName("krname");
          picturepath = listInner[i].getElementsByClassName("picturepath");
          if (engname[0].innerHTML.toLowerCase().indexOf(search) != -1 || 
        		  krname[0].innerHTML.toLowerCase().indexOf(search) != -1 ||
        		  picturepath[0].innerHTML.toLowerCase().indexOf(search) != -1
          ) {
            listInner[i].style.display = "block"
          } else {
            listInner[i].style.display = "none"
          }
        }
      }
    </script>
    <script>
    
    </script>
</body>
</html>