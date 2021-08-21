<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="community.best.model.vo.Best"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%
	//Best best = (Best)request.getAttribute("best");
	ArrayList bestList = (ArrayList) request.getAttribute("list");
	int limit = Integer.parseInt(request.getAttribute("limit").toString());
	int currentPage = Integer.parseInt(request.getAttribute("currentPage").toString());
	int maxPage = Integer.parseInt(request.getAttribute("maxPage").toString());
	int startPage = Integer.parseInt(request.getAttribute("startPage").toString());
	int endPage = Integer.parseInt(request.getAttribute("endPage").toString());
	int listCount = Integer.parseInt(request.getAttribute("listCount").toString());
	String gSort = (String)request.getAttribute("sort");
	if(gSort == null || "".equals(gSort)) {
		gSort = "0";
	}
%>
<!DOCTYPE html>
<html>
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
	<title>슈즈곤</title>

	<!--
            CSS
            ============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/linearicons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/owl.carousel.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/themify-icons.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nice-select.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/nouislider.min.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/bootstrap.css">
	<link rel="stylesheet" href="/Shoesgone/resources/css/main.css">
	
</head>

<body id="category">

	<%@ include file="/views/common/menubar.jsp" %>

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Best 게시판</h1>
					<nav class="d-flex align-items-center">
						<a href="index.jsp">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Community Category<span class="lnr lnr-arrow-right"></span></a>
						<a href="Best.jsp">Best 게시판</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<div class="container">
		<div class="row">
			
			<%@ include file="/views/common/communityCategory.jsp" %>

			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="mr-auto">
					</div>
					<div class="default-select" id="default-select" >
						<select id="sort" style="display: none;">
							<option value="0">정렬</option>
							<option value="likedown">인기순↓</option>
							<option value="likeup">인기순↑</option>
							<option value="oldest">최신순↓</option>
							<option value="newest">최신순↑</option>
							<option value="picture">사진글</option>
						</select>
						<div class="nice-select" tabindex="0">
							<span class="current">정렬</span>
							<ul class="list">
								<li data-value="0" class="option">정렬</li>
								<li data-value="likedown" class="option">인기순↓</li>
								<li data-value="likeup" class="option">인기순↑</li>
								<li data-value="oldest" class="option">최신순↓</li>
								<li data-value="newest" class="option">최신순↑</li>
								<li data-value="picture" class="option">사진글</li>
							</ul>
						</div>		
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="progress-table-wrap">
						<div class="progress-table">
							<div class="table-head">
								<div class="boardno">번호</div>
								<div class="boardtitle">제목</div>
								<div class="register">작성자</div>
								<div class="registdate">작성일</div>
								<div class="hitcount">조회수</div>
							</div>
							<%
								for(int i = 0; i < bestList.size(); i++) {
									Best best = (Best)bestList.get(i);
							%>
							<div class="table-row">
								<div class="boardno"><%= best.getBestNo() %></div>
								<div class="boardtitle"><%= best.getBestTitle() %></div>
								<div class="register"><%= best.getBestWriter() %></div>
								<div class="registdate"><%= best.getBestDate()%></div>
								<div class="hitcount"><%= best.getBestReadCount() %></div>
							</div>
							<%
								}
							%>
						</div>
					</div>
				</section>
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting mr-auto">
						<select>
							<option value="1">Show 5</option>
							<option value="1">Show 10</option>
							<option value="1">Show 20</option>
						</select>
					</div>
					<div class="pagination">
						<a href="javascript:prev();" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
						<%
							String currentDecorator = "";
							for(int i = 1; i < maxPage + 1; i++) {
								if(currentPage == i) {
									currentDecorator = " class='active'";
								} else {
									currentDecorator = "";
								}
						%>
						<a href="javascript:movePage(<%=i%>);" <%= currentDecorator%>><%=i%></a>
						<%
							}
						%>
						<%
							if(maxPage > 5) {
						%>
						<a href="#" class="dot-dot"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
						<a href="javascript:movePage(<%=endPage%>);"><%=endPage%></a>
						<%
							}
						%>
						<a href="javascript:next();" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
												
					</div>
					<div class="button-group-area mt-40 ml-auto">
						<a href="#" class="genric-btn primary default circle">글쓰기</a>
					</div>
					
				</div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var limit = <%= limit %>;
	var currentPage = <%= currentPage %>;
	var maxPage = <%= maxPage %>;
	var startPage = <%= startPage %>;
	var endPage = <%= endPage %>;
	var listCount = <%= listCount %>;
	var gsort = "<%=gSort%>";
	
	$(document).ready(function(){
		$('#limit').niceSelect();
		$('#limit').val(limit).niceSelect('update');

    	$('#limit').change(function() {
    		$('#limit').niceSelect('update');
    		//console.log($('#sort').val());	
    		limit = $('#limit').val();
    		movePage(1);
    	});
    	
    	$('#sort').niceSelect();
    	$('#sort').val(gsort).niceSelect('update');
    	
    	$('#sort').change(function() {
    		$('#sort').niceSelect('update');
    		//console.log($('#sort').val());	
    		gsort = $('#sort').val();
    		movePage(1);
    	});
   	
    });
    
	function movePage(page) {
		
		location.href = "/Shoesgone/bestlist?page=" + page + "&limit=" + limit + "&sort=" + gsort;
	};
	
	function prev() {
		if(currentPage > 1) {
			movePage(currentPage - 1);
		} else {
			alert("이미 첫 페이지입니다.");
		}
	}
	
	function next() {
		if(currentPage == maxPage) {
			alert("이미 끝 페이지입니다.")
		} else {
			movePage(currentPage + 1);	
		}
	}
	</script>
	<script type="text/javascript">
	var limit = <%= limit %>;
	var currentPage = <%= currentPage %>;
	var maxPage = <%= maxPage %>;
	var startPage = <%= startPage %>;
	var endPage = <%= endPage %>;
	var listCount = <%= listCount %>;
	var gsort = "<%=gSort%>";
	
	$(document).ready(function(){
		$('#limit').niceSelect();
		$('#limit').val(limit).niceSelect('update');

    	$('#limit').change(function() {
    		$('#limit').niceSelect('update');
    		//console.log($('#sort').val());	
    		limit = $('#limit').val();
    		movePage(1);
    	});
    	
    	$('#sort').niceSelect();
    	$('#sort').val(gsort).niceSelect('update');
    	
    	$('#sort').change(function() {
    		$('#sort').niceSelect('update');
    		//console.log($('#sort').val());	
    		gsort = $('#sort').val();
    		movePage(1);
    	});
   	
    });
    
	function movePage(page) {
		
		location.href = "/Shoesgone/bestlist?page=" + page + "&limit=" + limit + "&sort=" + gsort;
	};
	
	function prev() {
		if(currentPage > 1) {
			movePage(currentPage - 1);
		} else {
			alert("이미 첫 페이지입니다.");
		}
	}
	
	function next() {
		if(currentPage == maxPage) {
			alert("이미 끝 페이지입니다.")
		} else {
			movePage(currentPage + 1);	
		}
	}
	</script>
	<br><br><br><br><br>

	<!-- start footer Area -->
		<%@ include file="/views/common/footer.jsp" %>
	<!-- End footer Area -->




</body>
</html>