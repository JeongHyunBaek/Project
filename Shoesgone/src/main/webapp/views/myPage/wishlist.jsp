<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="wishlist.model.vo.Wishlist, java.util.ArrayList"%>
    
     <% 

ArrayList<Wishlist> list = (ArrayList<Wishlist>)request.getAttribute("list");
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
	<title>위시리스트</title>
	
<style type="text/css">

.th{
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
	<script type="text/javascript">
	function validate() {
		 
		 if (!checkPassword(form.userpwd.value,
	                form.usepwd2.value)) {
	            return false;
		 }
		  return true; 
	 }

</script>

 
</head>

<body>

	<%@ include file="../common/menubar.jsp" %>

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
	<section><br><br><br>
<div class="wishlist">
    <!--@css(/css/module/myshop/orderOldHistoryList.css)-->
    <!--
        $login_url = /member/login.html
    -->
    <div class="title">
        <h2 align="center">위시리스트</h2><hr><br>
    </div>

    <table class="th" border="1" summary="" align="center" width="960px">
        <caption></caption>
        <thead>
            <tr>
                <th scope="col" class="number" width="40px">선택</th>
                <th scope="col" class="product" width="500px">상품정보</th>
                <th scope="col" class="price" width="100px">상품금액</th>
  
                <th scope="col" class="state" width="100px">주문하기</th>
            </tr>
        </thead>
        <tbody class="{$list_display|display}">
          <%
						
						for(int i = 0; i < list.size(); i++){
					%>
            <tr>
                <td>
                    
                   <a href="/Shoesgone/menubarsearch?menu=wdelete<%= loginMember.getUserNo() %>&wnum=<%= list.get(i).getWishlistNo() %>" onclick="alert('정말 삭제하시겠습니까?');return true;"><button class="genric-btn primary small" >삭제</button></a>
                </td>
                <td class="product"><strong><a href="/Shoesgone/menubarsearch?menu=item<%= list.get(i).getItemNo() %>"><%= list.get(i).getItemEngName() %><br><%= list.get(i).getItemKrName() %></a></strong> </td>
                <td class="price"><strong><%= list.get(i).getPrice() %></strong></td>
                
                <td class="state"><a href="/Shoesgone/menubarsearch?menu=buyaccept&itemno=<%= list.get(i).getItemNo() %>"><button type="submit" class="genric-btn primary-border small">주문</button></a></td>
            </tr>
            <tr>
              <% }	%>   
        </tbody>
    </table>
    <center>
    <a href="/Shoesgone/menubarsearch?menu=walldelete<%= loginMember.getUserNo() %>" onclick="alert('정말 삭제하시겠습니까?');return true;"><button type="button" class="genric-btn primary small">전체삭제</button></a></center>
    
    <br>
<%-- 페이징 처리 --%>
<div style="text-align:center;">
	<% if(currentPage <= 1){ %>
		[맨처음] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=wishlist<%= loginMember.getUserNo() %>&page=1">[맨처음]</a> &nbsp;
	<% } %>
	<!-- 이전 페이지 그룹으로 이동 -->
	<% if((currentPage - 10) < startPage && 
			(currentPage - 10) > 1){ %>
		<a href="/Shoesgone/menubarsearch?menu=wishlist<%= loginMember.getUserNo() %>&page=<%= startPage - 10 %>">[이전그룹]</a> &nbsp;
	<% }else{ %>
		[이전그룹] &nbsp;
	<% } %>
	
	<!-- 현재 페이지 그룹의 페이지 숫자 출력 -->
	<% for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
	%>
		 <font color="red" size="4"><b>[<%= p %>]</b></font>
		<% }else{ %>
			<a href="/Shoesgone/menubarsearch?menu=wishlist<%= loginMember.getUserNo() %>&page=<%= p %>"><%= p %></a>
	<% }} %>
	
	<!-- 다음 페이지 그룹으로 이동 -->
	<% if((currentPage + 10) > endPage && 
			(currentPage + 10) < maxPage){ %>
		<a href="/Shoesgone/menubarsearch?menu=wishlist<%= loginMember.getUserNo() %>&page=<%= endPage + 10 %>">[다음그룹]</a> &nbsp;
	<% }else{ %>
		[다음그룹] &nbsp;
	<% } %>
	
	<% if(currentPage >= maxPage){ %>
		[맨끝] &nbsp;
	<% }else{ %>
		<a href="/Shoesgone/menubarsearch?menu=wishlist<%= loginMember.getUserNo() %>&page=<%= maxPage %>">[맨끝]</a> &nbsp;
	<% } %>
</div>

    <hr><center><a href="/Shoesgone/menubarsearch?menu=mypage" class="genric-btn primary">목록보기</a></center><br><br><br>
</div>
</section>
	<!--================Contact Area =================-->

<%@ include file="../common/footer.jsp" %>
	
</body>

</html>