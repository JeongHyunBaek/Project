<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="myboard.model.vo.Myboard, java.util.ArrayList,  java.io.PrintWriter,java.sql.Date"%>
    
  <%
  ArrayList<Myboard> flist = (ArrayList<Myboard>)request.getAttribute("flist");

  int flistCount = ((Integer)request.getAttribute("flistCount")).intValue();
  int startPage = ((Integer)request.getAttribute("startPage")).intValue();
  int endPage = ((Integer)request.getAttribute("endPage")).intValue();
  int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
  int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
  %>
<!DOCTYPE html>
<html>

<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>나의글보기</title>

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
					<nav class="d-flex align-items-center">
					</nav>
				</div>
			</div>
		</div>
	</section>
	
	<!--================Contact Area =================-->

<section>
<br><br>
<h2 align="center">나의 글 보기</h2>


<center>
<ul id="menubar" style="align:center;">
	<li><a href="/Shoesgone/menubarsearch?menu=rlist<%= loginMember.getUserNo() %>">리뷰게시판</a></li>
	<li><a href="/Shoesgone/menubarsearch?menu=glist<%= loginMember.getUserNo() %>">갤러리</a></li>
	<li><a href="/Shoesgone/menubarsearch?menu=flistmy<%= loginMember.getUserNo() %>">자유게시판</a></li>
	<li><a href="/Shoesgone/menubarsearch?menu=qlistmy<%= loginMember.getUserNo() %>">QnA</a></li>
</ul></center>
<br>
<hr>
		<section class="product_description_area">
			<div class="container">
			<center><h3>자유게시판</h3></center><br>
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
							
						
							
						for(int i = 0; i < flist.size(); i++){
					%>
								<tr>
								
									<td class="name" style = "text-align:center"><%= flist.get(i).getTextNo() %></td>
									<td class="title" style = "text-align:center"><a href="/Shoesgone/menubarsearch?menu=freedetail<%= flist.get(i).getTextNo() %>"><%= flist.get(i).getTitle() %></td>
									<td class="name" style = "text-align:center"><%= flist.get(i).getWriter() %></td>
									<td class="date" style = "text-align:center"><%= flist.get(i).getRegistDate() %></td>
									<td class="hit" style = "text-align:center"><%= flist.get(i).getTextReadcount() %></td>
								</tr>
								<% }
								%>
								<!-- -->
							</tbody>
						</table><br>
						 
 <br><br>
<%-- 페이징 처리 --%>
<div style="text-align:center;">
	<% if(currentPage <= 1){ %>
		[맨처음] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=freelistmy<%= loginMember.getUserNo() %>&page=1">[맨처음]</a> &nbsp;
	<% } %>
	<!-- 이전 페이지 그룹으로 이동 -->
	<% if((currentPage - 10) < startPage && 
			(currentPage - 10) > 1){ %>
		<a href="/Shoesgone/menubarsearch?menu=freelistmy<%= loginMember.getUserNo() %>&page=<%= startPage - 10 %>">[이전그룹]</a> &nbsp;
	<% }else{ %>
		[이전그룹] &nbsp;
	<% } %>
	
	<!-- 현재 페이지 그룹의 페이지 숫자 출력 -->
	<% for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
	%>
		 <font color="red" size="4"><b>[<%= p %>]</b></font>
		<% }else{ %>
			<a href="/Shoesgone/menubarsearch?menu=freelistmy<%= loginMember.getUserNo() %>&page=<%= p %>"><%= p %></a>
	<% }} %>
	
	<!-- 다음 페이지 그룹으로 이동 -->
	<% if((currentPage + 10) > endPage && 
			(currentPage + 10) < maxPage){ %>
		<a href="/Shoesgone/menubarsearch?menu=freelistmy<%= loginMember.getUserNo() %>&page=<%= endPage + 10 %>">[다음그룹]</a> &nbsp;
	<% }else{ %>
		[다음그룹] &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage){ %>
		[맨끝] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=freelistmy<%= loginMember.getUserNo() %>&page=<%= maxPage %>">[맨끝]</a> &nbsp;
	<% } %>
</div>
					
					<hr>
					</div>
					</div><br><center><a href="/Shoesgone/menubarsearch?menu=mypage" class="genric-btn primary">목록보기</a></center>
		</section>
</section>
	<!--================Contact Area =================-->

	<%@ include file="../common/footer.jsp" %>
</body>

</html>