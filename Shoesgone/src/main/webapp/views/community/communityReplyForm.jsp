<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


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
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-categories">
					<div class="head">커뮤니티</div>
					<ul class="main-categories">
						<li class="main-nav-list"><a href="/SProject/views/community/Best.jsp" aria-expanded="false"><span
								 class="lnr lnr-arrow-right"></span>Best 게시판</a>
						</li>
						<li class="main-nav-list"><a href="/SProject/views/community/review.jsp" aria-expanded="false"><span
								 class="lnr lnr-arrow-right"></span>리뷰 게시판</a>
							</li>
						<li class="main-nav-list"><a href="/SProject/views/community/gallery.jsp" aria-expanded="false"><span
								 class="lnr lnr-arrow-right"></span>갤러리</a>
							</li>
						<li class="main-nav-list"><a href="/SProject/views/community/free.jsp" aria-expanded="false"><span
								 class="lnr lnr-arrow-right"></span>자유게시판</a>
							</li>
						<li class="main-nav-list"><a href="/SProject/views/community/QnA.jsp" aria-expanded="false"><span
								 class="lnr lnr-arrow-right"></span>Q&A</a>
							</li>
					</ul>
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
				<div class="WritingWrp">
					
                	
                </div>
				</section>
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				<div class="comments-area ">
                        <h4>댓글 : 3</h4>
                        <div class="comment-list">
                            <div class="single-comment justify-content-between d-flex">
                                <div class="user justify-content-between d-flex">
                                    <div class="thumb">
                                        <img src="img/blog/c1.jpg" alt="">
                                    </div>
                                    <div class="desc">
                                        <h5><a href="#">작성자1</a></h5>
                                        <p class="date">December 4, 2018 at 3:12 pm </p>
                                        <p class="comment">
                                            댓글내용 1
                                        </p>
                                    </div>
                                </div>
                                <div class="reply-btn">
                                	<a href="" class="btn-reply text-uppercase">추천</a>
                                    <a href="" class="btn-reply text-uppercase">답글달기</a>
                                </div>
                            </div>
                        </div>
                        <div class="comment-list left-padding">
                            <div class="single-comment justify-content-between d-flex">
                                <div class="user justify-content-between d-flex">
                                    <div class="thumb">
                                        <img src="img/blog/c2.jpg" alt="">
                                    </div>
                                    <div class="desc">
                                        <h5><a href="#">답글1</a></h5>
                                        <p class="date">December 4, 2018 at 3:12 pm </p>
                                        <p class="comment">
                                            답글1
                                        </p>
                                    </div>
                                </div>
                                <div class="reply-btn">
                                	<a href="" class="btn-reply text-uppercase">추천</a>
                                </div>
                            </div>
                        </div>
                        
                        <div class="comment-list">
                            <div class="single-comment justify-content-between d-flex">
                                <div class="user justify-content-between d-flex">
                                    <div class="thumb">
                                        <img src="img/blog/c4.jpg" alt="">
                                    </div>
                                    <div class="desc">
                                        <h5><a href="#">작성자2</a></h5>
                                        <p class="date">December 4, 2018 at 3:12 pm </p>
                                        <p class="comment">
                                            댓글내용 2
                                        </p>
                                    </div>
                                </div>
                                <div class="reply-btn">
                                	<a href="" class="btn-reply text-uppercase">추천</a>
                                    <a href="" class="btn-reply text-uppercase">답글달기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div class="comment-form">
                        <h4>댓글 남기기</h4>
                        <form>
                            <div class="form-group form-inline">
                                <div class="form-group col-lg-6 col-md-6 name"> 
                                    <input type="text" class="form-control" id="name" placeholder="작성자" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Name'">
                                </div> &nbsp; &nbsp; &nbsp; &nbsp;
                                <a href="#" class="primary-btn submit_btn">등록</a>
                            </div>
                            
                            <div class="form-group">
                                <textarea class="form-control mb-10" rows="5" name="message" placeholder="내용을 입력해주세요." onfocus="this.placeholder = ''" onblur="this.placeholder = 'Messege'" required=""></textarea>
                            </div>
                            
                        </form>
                    </div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>
<br><br><br><br><br>
	<!-- start footer Area -->
	<%@ include file="/views/common/footer.jsp" %>
	<!-- End footer Area -->

</body>
</html>