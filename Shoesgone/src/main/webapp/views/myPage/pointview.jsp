<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="point.model.vo.Point, java.util.ArrayList"%>
   <% 

ArrayList<Point> list = (ArrayList<Point>)request.getAttribute("list");
 ArrayList<Point> pointlist = (ArrayList<Point>)request.getAttribute("pointlist");
int listCount = ((Integer)request.getAttribute("listCount")).intValue();
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
	<title>포인트조회</title>
<style type="text/css">
.point{
	text-align : center;
}
.page_wrap {
	text-align:center;
	font-size:0;
}
.page_nation {
	display:inline-block;
}
.page_nation .none {
	display:none;
}
.page_nation a {
	display:block;
	margin:0 3px;
	float:left;
	border:1px solid #e6e6e6;
	width:28px;
	height:28px;
	line-height:28px;
	text-align:center;
	background-color:#fff;
	font-size:13px;
	color:#999999;
	text-decoration:none;
}
.page_nation .arrow {
	border:1px solid #ccc;
}
.page_nation .pprev {
	background:#f8f8f8 url('img/page_pprev.png') no-repeat center center;
	margin-left:0;
}
.page_nation .prev {
	background:#f8f8f8 url('img/page_prev.png') no-repeat center center;
	margin-right:7px;
}
.page_nation .next {
	background:#f8f8f8 url('img/page_next.png') no-repeat center center;
	margin-left:7px;
}
.page_nation .nnext {
	background:#f8f8f8 url('img/page_nnext.png') no-repeat center center;
	margin-right:0;
}
.page_nation a.active {
	background-color:#42454c;
	color:#fff;
	border:1px solid #42454c;
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
	<% 
		int pointamount = 0;
	for(int i = 0; i < pointlist.size(); i++){ 
		
	pointamount +=  pointlist.get(i).getPoint();
	}%>
<div width="960px"><br><br><br>
<h2 align="center">포인트 조회</h2>
<hr width="960px" color="black">
<strong><center>총 적립금 :<%= pointamount %> 원 </center></strong>
<hr width="960px" color="black">
</div>
<div><table border="1" summary="적립 내역 목록 입니다" class="point" align="center">
<caption></caption>
    
        <colgroup >
<col width="15%">
<col width="15%">
<col width="25%">
<col width="auto">
</colgroup>
<thead><tr>
<th scope="col" width="100">주문날짜</th>
                <th scope="col" >적립금</th>
                <th scope="col">관련 주문</th>
                <th scope="col">적립내용</th>
            </tr></thead>
<tbody class="pointtable">
<%
							
						
							
						for(int i = 0; i < list.size(); i++){
					%>
<tr class="first xans-record-">
<td><%= list.get(i).getRegistDate() %></td>
<td class="mileage"><%= list.get(i).getPoint() %></td>
<td><a href="/Shoesgone/menubarsearch?menu=odetail<%= list.get(i).getOrderNo() %>"><%= list.get(i).getOrderNo() %></a></td>
<td><%= list.get(i).getHistory() %></td>
            </tr>
            
            <% }	%>
</tbody>

<!-- <tbody class="displaynone"><tr>
<td colspan="4" class="nodata">적립내역이 없습니다.</td>
            </tr></tbody> -->
            
</table>
 <%-- 페이징 처리 --%>
<div style="text-align:center;">
	<% if(currentPage <= 1){ %>
		[맨처음] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=pointlist<%= loginMember.getUserNo() %>&page=1">[맨처음]</a> &nbsp;
	<% } %>
	<!-- 이전 페이지 그룹으로 이동 -->
	<% if((currentPage - 10) < startPage && 
			(currentPage - 10) > 1){ %>
		<a href="/Shoesgone/menubarsearch?menu=pointlist<%= loginMember.getUserNo() %>&page=<%= startPage - 10 %>">[이전그룹]</a> &nbsp;
	<% }else{ %>
		[이전그룹] &nbsp;
	<% } %>
	
	<!-- 현재 페이지 그룹의 페이지 숫자 출력 -->
	<% for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
	%>
		 <font color="red" size="4"><b>[<%= p %>]</b></font>
		<% }else{ %>
			<a href="/Shoesgone/menubarsearch?menu=pointlist<%= loginMember.getUserNo() %>&page=<%= p %>"><%= p %></a>
	<% }} %>
	
	<!-- 다음 페이지 그룹으로 이동 -->
	<% if((currentPage + 10) > endPage && 
			(currentPage + 10) < maxPage){ %>
		<a href="/Shoesgone/menubarsearch?menu=pointlist<%= loginMember.getUserNo() %>&page=<%= endPage + 10 %>">[다음그룹]</a> &nbsp;
	<% }else{ %>
		[다음그룹] &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage){ %>
		[맨끝] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=pointlist<%= loginMember.getUserNo() %>&page=<%= maxPage %>">[맨끝]</a> &nbsp;
	<% } %>
</div>
   
</div></div><hr><center><a href="/Shoesgone/menubarsearch?menu=mypage" class="genric-btn primary">목록보기</a></center><br><br><br>
</section>
	<!--================Contact Area =================-->

	<%@ include file="../common/footer.jsp" %>

</body>

</html>