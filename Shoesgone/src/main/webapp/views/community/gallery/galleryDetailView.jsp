<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="community.gallery.model.vo.Gallery"%>
<%@page import="loginPage.model.vo.Login"%>
<%@page import="community.reply.model.vo.Reply"%>
<%@page import="java.util.List"%>
<%
	Gallery gallery = (Gallery)request.getAttribute("gallery");
	List<Reply> replyList = (List)request.getAttribute("replyList"); 
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
%> 

<!DOCTYPE html>
<html>


<body id="category">

	<%@ include file="/views/common/menubar.jsp" %>

<script type="text/javascript">
function moveUpdateView(){
	location.href = "/Shoesgone/galleryupview?gNo=<%= gallery.getGalleryNo() %>&page=<%= currentPage %>";
}

function requestDelete(){
	location.href = "/Shoesgone/gallerydelete?gNo=<%= gallery.getGalleryNo() %>&rfile=<%= gallery.getGalleryRenameFilename() %>";
	alert("삭제되었습니다.");
}


</script>
	

	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Gallery</h1>
					<nav class="d-flex align-items-center">
						<a href="index.jsp">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Community Category<span class="lnr lnr-arrow-right"></span></a>
						<a href="gallery.jsp">Gallery</a>
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
							<td width="60%" colspan="3"><%= gallery.getGalleryTitle() %></td><!-- 제목 -->
							<th width="10%">번호</th>
							<td width="5%"><%= gallery.getGalleryNo() %></td> <!-- 번호 -->
						</tr>
						
						<tr>
							<th width="10%">작성자</th>
							<td width="10%"><%= gallery.getGalleryWriter() %></td>
							<th width="10%">작성일</th>
							<td width="15%"><%= gallery.getGalleryDate()%></td> <!-- 작성일  -->
							<th>조회수</th>
							<td width=""><%= gallery.getGalleryReadCount() %></td>
						</tr>
						<tr>
							<th colspan="6">첨부파일</th>
						</tr>
						<tr>
							<th colspan="1">내용</th>
							<th colspan="5"><%= gallery.getGalleryContent() %></th>
						</tr>
						<tr align="center">
						<th colspan="6">
							<button href="#" class="genric-btn primary small">신고 </button>
							<button href="#" class="genric-btn primary small">추천 </button>
							<button onclick="javascript:location.href='/Shoesgone/gallerylist?page=<%= currentPage %>';" class="genric-btn primary small">목록</button>
							&nbsp;
							<% Login loginMemberInfo = (Login)session.getAttribute("loginMember");
							   if(loginMemberInfo != null &&
									   gallery.getGalleryWriter() == loginMember.getUserNo()) {
								   // out.println("작성자ID와 로그인한 사용자ID가 같음");
							%>
							<button onclick="moveUpdateView(); return false;" class="genric-btn primary-border small">수정</button>
							<button onclick="requestDelete(); return false;" class="genric-btn primary-border small">삭제</button>
							<% } %>
						</th>
						</tr>
					</table>
				</div>
			</div>
			
			
			<!-- 댓글 확인용 -->
			<div class="comments-area ">
                        <h4>댓글 : <%=replyList.size() %></h4>
                        <%
                        	for(int i = 0; i < replyList.size(); i++ ) {
                        		Reply reply = replyList.get(i);
                        		String leftPadding = "";
                        		if(reply.getReplyLevel() == 2) {
                        			leftPadding = "left-padding";
                        		}
                        %>
                        <div class="comment-list <%=leftPadding %>" >
                            <div class="single-comment justify-content-between d-flex">
                                <div class="user justify-content-between d-flex">
                                    <div class="thumb">
                                        <img src="img/blog/c1.jpg" alt="">
                                    </div>
                                    <div class="desc">
                                        <h5><a href="#"><%= reply.getReplyWriter() %></a></h5>
                                        <p class="date"><%= reply.getReplyDate() %></p>
                                        <p class="comment">
                                            <%= reply.getReplyContent() %>
                                        </p>
                                    </div>
                                </div>
                                <% if(loginMember != null){ %>
                                <div class="reply-btn">
                                	<a href="" class="btn-reply text-uppercase">추천 </a>
                                	<a href="" class="btn-reply text-uppercase">답글달기</a>
                                	<a href="" class="btn-reply text-uppercase">신고 </a>
                                </div>
                                <% } %>
                            </div>
                        </div>
                        <% } %>
                        
                    </div>
				
							
							
				<!-- 댓글 남기기용 -->		
				<% if(loginMember != null){ %>
					<div class="comment-form">
                        <h4>댓글 남기기</h4>
                        <form>
                            <div class="form-group form-inline">
                                <div class="form-group col-lg-6 col-md-6 name"> 
                                    <input type="text" class="form-control" id="name" placeholder="작성자" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Name'">                                     
                                </div> &nbsp; &nbsp; &nbsp; &nbsp;
                                <a href="#" class="genric-btn primary radius">등록</a>
                            </div>
                            
                            <div class="form-group">
                                <textarea class="form-control mb-10" rows="5" name="message" placeholder="내용을 입력해주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
                            </div>
                            
                        </form>
                    </div>
                <% } %>
				
						
				
				
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