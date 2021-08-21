<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="question.model.vo.Question, loginPage.model.vo.Login, java.util.ArrayList, java.io.PrintWriter,java.sql.Date" %>    
<% 

ArrayList<Question> list = (ArrayList<Question>)request.getAttribute("list");
int listCount = ((Integer)request.getAttribute("listCount")).intValue();
int startPage = ((Integer)request.getAttribute("startPage")).intValue();
int endPage = ((Integer)request.getAttribute("endPage")).intValue();
int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
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
<script type="text/javascript" src="/Shoesgone/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

</script>
<script type="text/javascript">
function showWriteForm(){
	location.href = "/Shoesgone/views/customerservicePage/questionWriteForm.jsp";
}
</script>
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
<style type="text/css">
ul#menubar {
	text-align: center;
	align: center;
	list-style: none;
	position: relative;
	
	/* top: -30px; */
}
ul#menubar li {
	algin: center;
	text-align: center;
	display:inline-block;
	width: 120px;
	height: 30px;
	
	padding: 0;
}
ul#menubar li a {
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	background: orange;
	color: white;
	text-align: center;
	
	margin: 0;
	
	padding-top: 5px;
}
ul#menubar li a:hover {
	text-decoration: none;
	width: 120px;
	height: 30px;
	display: block;
	background: white;
	color: orange;
	text-align: center;
	font-weight: bold;
	margin: 0;
	padding-top: 5px;
}


.sub_news{
 font-size: 16px;

 
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
	<section><br><br>
	<h2 align="center">고객센터</h2>
	
	<ul id="menubar" style="align:center;">
	<li><a href="/Shoesgone/menubarsearch?menu=nlistadmin">공지사항</a></li>
	<li><a href="/Shoesgone/menubarsearch?menu=flistadmin">자주묻는질문</a></li>
	<li><a href="/Shoesgone/menubarsearch?menu=qulistadmin">1:1문의</a></li>
</ul>
<br>
<hr>
		<section class="product_description_area">
			<div class="container">
						<center><h3>1:1문의</h3></center><br>
						<table class="sub_news" border="0" cellpadding="7px"
							summary="게시판의 글제목 리스트" align="center" text-align="center">
							
							<colgroup>
								<col width="50" >
								<col width="450">
								<col width="150">
								<col width="100">
								<col width="100">
							</colgroup>
							<thead style="border-bottom:0.5px solid #444444 ; border-collapse : collapse;
							">
								<tr>
								    <th scope="col" style = "text-align:center">번호</th>
									<th scope="col" style = "text-align:center">제목</th>
									<th scope="col" style = "text-align:center">작성자</th>
									<th scope="col" style = "text-align:center">작성일</th>
									<th scope="col" style = "text-align:center">조회수</th>
									
								</tr>
							</thead>
							<tbody>
							<%
							
						
							
						for(int i = 0; i < list.size(); i++){
					%>
					
								<tr>
								 <td style = "text-align:center"><%= list.get(i).getQuestionNo() %></td>
								 <td style = "text-align:center">
	<% if(list.get(i).getQuestionLevel() == 2){  //원글의 답글 일 때 %>
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;☞
		<% } %>
		<a href="/Shoesgone/menubarsearch?menu=qudetail.ad<%= list.get(i).getQuestionNo() %>"><%= list.get(i).getQuestionTitle() %></a></td>
								 <td style = "text-align:center"><%= list.get(i).getQuestionWriter() %></td>
								 <td style = "text-align:center"><%= list.get(i).getQuestionDate() %></td>
								 <td style = "text-align:center"><%= list.get(i).getQuestionReadcount() %></td> 
								
								</tr>
								<% }
								%>
								<!-- -->
								
							</tbody>
						</table><br>
						
	<br>
<%-- 페이징 처리 --%>
<div style="text-align:center;">
	<% if(currentPage <= 1){ %>
		[맨처음] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=qulist.ad1">[맨처음]</a> &nbsp;
	<% } %>
	<!-- 이전 페이지 그룹으로 이동 -->
	<% if((currentPage - 10) < startPage && 
			(currentPage - 10) > 1){ %>
		<a href="/Shoesgone/menubarsearch?menu=qulist.ad<%= startPage - 10 %>">[이전그룹]</a> &nbsp;
	<% }else{ %>
		[이전그룹] &nbsp;
	<% } %>
	
	<!-- 현재 페이지 그룹의 페이지 숫자 출력 -->
	<% for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
	%>
		 <font color="red" size="4"><b>[<%= p %>]</b></font>
		<% }else{ %>
			<a href="/Shoesgone/menubarsearch?menu=qulist.ad<%= p %>"><%= p %></a>
	<% }} %>
	
	<!-- 다음 페이지 그룹으로 이동 -->
	<% if((currentPage + 10) > endPage && 
			(currentPage + 10) < maxPage){ %>
		<a href="/Shoesgone/menubarsearch?menu=qulist.ad<%= endPage + 10 %>">[다음그룹]</a> &nbsp;
	<% }else{ %>
		[다음그룹] &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage){ %>
		[맨끝] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=qulist.ad<%= maxPage %>">[맨끝]</a> &nbsp;
	<% } %>
</div>
				<hr>
						
							 
						
						
						
						</div></section>
					
						<!-- 리스트 게시판 끝-->


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
</body>

</html>