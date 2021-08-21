<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="community.review.model.vo.Review" %>
<%
	Review review = (Review)request.getAttribute("review");
%>
<!DOCTYPE html>
<html>
<head>
</head>

<body>

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

	<!--================Checkout Area =================-->
	<section class="checkout_area section_gap">
		<div class="container">


			<div class="billing_details">
				<div class="row">
					<div class="col-lg-8">
						<h3>글 수정하기</h3>
						<form class="row contact_form" action="/Shoesgone/menubarsearch?menu=reviewupdate" method="post"
							novalidate="novalidate" enctype="multipart/form-data">
							<div class="col-md-6 form-group p_star">
								<select class="country_select">
									<option value="1">게시판을 선택해 주세요</option>
									<div></div>
									<option value="2">리뷰 게시판</option>
									<option value="3">갤러리</option>
									<option value="4">자유게시판</option>
									<option value="5">Q&A</option>
								</select>
							</div>
							
							<!-- 수업용버튼자료 -->
							<div class="button-group-area mt-40">
								<tr>
									<th colspan="2">
										<input type="submit" value="수정하기"> &nbsp; 
										<input type="reset" value="수정취소"> &nbsp;
										<input type="button" value="이전페이지로 이동" 
												onclick="javascript:history.go(-1); return false;"> &nbsp;
										<input type="button" value="목록" onclick="javascript:location.href='/Shoesgone/menubarsearch?menu=reviewpage&page=1'; return false;">
									</th>
								</tr>
							</div>

							<!--  버튼오류  -->
							<!-- <div class="button-group-area mt-40"> 
							<a onclick="javascript:history.go(-1); return false;" class="genric-btn primary circle arrow">취소<span class="lnr lnr-arrow-right"></span></a>
							<a type="submit" class="genric-btn primary circle arrow">등록<span class="lnr lnr-arrow-right"></span></a> 
							<a onclick="javascript:history.go(-1); return false;" class="genric-btn primary circle arrow">목록<span class="lnr lnr-arrow-right"></span></a>
							</div> -->

							<div class="col-md-12 form-group p_star">
								<input type="text" class="form-control" id="first" name="title" placeholder="제목을 입력해주세요" required> 
							</div>
							<div class="col-md-12 form-group p_star">
								<tr>
									<th>첨부파일</th>
									<td>
										<% if (review.getReviewOriginalFilename() != null) { %> 
											<%= review.getReviewOriginalFilename()%> &nbsp; 
											<input type="checkbox" name="deleteFlag" value="yes">
											파일삭제 <br> 
											변경 : <input type="file" name="upfile">
										<% } else { %> 
											첨부된 파일 없음 <br> 
											추가 : <input type="file"name="upfile"> 
										<% } %>

									</td>
								</tr>
							</div>
							<div class="col-md-12 form-group p_star">
								<textarea class="form-control" name="message" id="message" rows="1"
									placeholder="내용을 입력해주세요."></textarea>
							</div>
						</form>
					</div>
					
					<div class="col-lg-4">
						<div class="order_box">
							<h2>설정</h2>
							<ul class="set_list">
								<li class="set_item"><div class="FormInputCheck">
										<input id="coment" type="checkbox" class="input_check"><label
											for="coment" class="label"> 댓글 허용 </label>
									</div></li>
								<li class="set_item"><div class="FormInputCheck">
										<input id="external_sharing" type="checkbox"
											class="input_check"><label for="external_sharing"
											class="label"> 외부 공유 허용 </label>
									</div></li>
								<li class="set_item"><div class="FormInputCheck">
										<input id="copy" type="checkbox" class="input_check"><label
											for="copy" class="label"> 복사 · 저장 허용 </label>
									</div></li>
								<li class="set_item"><div class="FormInputCheck">
										<input id="automatic_source" type="checkbox"
											class="input_check"><label for="automatic_source"
											class="label"> 자동출처 사용 </label>
									</div></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Checkout Area =================-->

		<%@ include file="/views/common/footer.jsp" %>

</body>
</html>