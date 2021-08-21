<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="community.qna.model.vo.QnA"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>

<%
	//QnA qna = (QnA)request.getAttribute("qna");
	ArrayList qnaList = (ArrayList) request.getAttribute("list");
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
<body id="category">

	<%@ include file="/views/common/menubar.jsp" %>

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Q&A</h1>
					<nav class="d-flex align-items-center">
						<a href="index.jsp">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Community Category<span class="lnr lnr-arrow-right"></span></a>
						<a href="QnA.jsp">Q&A</a>
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
								for(int i = 0; i < qnaList.size(); i++) {
									QnA qna = (QnA)qnaList.get(i);
							%>
							<div class="table-row">
								<div class="boardno"><%= qna.getQnANo() %></div>
								<div class="boardtitle">
									<a href="/Shoesgone/menubarsearch?menu=qna<%= qna.getQnANo() %>&page=<%= currentPage %>"><%= qna.getQnATitle() %></a>
								</div>
								<div class="register"><%= qna.getQnAWriter() %></div>
								<div class="registdate"><%= qna.getQnADate()%></div>
								<div class="hitcount"><%= qna.getQnAReadCount() %></div>
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
							<option value="5">Show 5</option>
							<option value="10">Show 10</option>
							<option value="20">Show 20</option>
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
					<% if(loginMember != null){ %>
						<a onclick="showWriteForm();" class="genric-btn primary default circle">글쓰기</a>
					</div>
					<% } %>
					
					

					<!-- 검색 -->
					<div class="" id="mc_embed_signup">

					<form target="_blank" novalidate="true"
						action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
						method="get" class="form-inline">

						<div class="d-flex flex-row">
							<select class="country_select">
									<option value="1">검색 기간</option>
									<div></div>
									<option value="2">1일</option>
									<option value="3">7일</option>
									<option value="4">1개월</option>
									<option value="5" id="uenroll">직접 입력</option>
							</select> &nbsp;
							<select class="country_select">
									<option value="1">검색 필터</option>
									<div></div>
									<option value="2">제목 + 내용</option>
									<option value="3">제목</option>
									<option value="4">내용</option>
									<option value="5">작성자</option>
							</select> &nbsp;

							<input class="form-control" name="SEARCH"
								placeholder="검색어를 입력하세요 " onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Search '" required=""
								type="text">


							<button class="click-btn btn btn-default">
								<i class="fa fa-long-arrow-right" aria-hidden="true"></i>
							</button>
							<div style="position: absolute; left: -5000px;">
								<input name="b_36c4fd991d266f23781ded980_aefe40901a"
									tabindex="-1" value="" type="text">
							</div>
						</div>
					</form>
				</div>
					
					
					
					
				</div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>
	
	
	<br><br><br><br><br>

	

	<!-- start footer Area -->
		<%@ include file="/views/common/footer.jsp" %>
	<!-- End footer Area -->
	
	
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
		
		location.href = "/Shoesgone/menubarsearch?menu=qnalist&page=" + page + "&limit=" + limit + "&sort=" + gsort;
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
	function showWriteForm(){
		location.href = "/Shoesgone/menubarsearch?menu=qnawrite";
	}
	
	</script>

</body>
</html>