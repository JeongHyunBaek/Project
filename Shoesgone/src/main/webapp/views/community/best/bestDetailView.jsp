<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="community.best.model.vo.Best"%>
<%
	Best best = (Best)request.getAttribute("best");
%>
<!DOCTYPE html>
<html>
<head>
	
</head>

<body id="category">

	<%@ include file="/views/common/menubar.jsp" %>


	

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>리뷰 게시판</h1>
					<nav class="d-flex align-items-center">
						<a href="index.jsp">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Community Category<span class="lnr lnr-arrow-right"></span></a>
						<a href="review.jsp">리뷰 게시판</a>
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
				<div class="order_details_table">
				
				<div class="table-responsive">
					<table class="table">
						<tr>
							
							<th width="10%">제목</th>
							<td width="60%" colspan="3">여기에는 제목이 들어갑니다.</td>
							<th width="10%">번호</th>
							<td width="5%">22</td>
						</tr>
						
						<tr>
							<th width="10%">작성자</th>
							<td width="10%">작성식</td>
							<th width="10%">작성일</th>
							<td width="15%">2021-01-21</td>
							<th>조회수</th>
							<td width="">999</td>
						</tr>
						<tr>
							<th colspan="1">내용</th>
							<th colspan="5">매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.매우 긴 내용이 들어가야할 것 같습니다.</th>
						</tr>
						<tr align="center">
						<th colspan="6">
							<button>신고</button>
							<button>추천</button>
						</th>
						</tr>
					</table>
				</div>
			</div>
				
						
				
				
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
				<div class="WritingWrp">
					
                	
                </div>
				</section>
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				
				
				
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>

	
<br><br><br><br><br>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>