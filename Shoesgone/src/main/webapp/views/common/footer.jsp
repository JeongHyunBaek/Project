<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title></title>
	
	<style>
		#grey-color{
			color: grey;
		}
		
		#white-color{
			color: white;
		}
		
		.popOpenBtnCmmn{
			cursor: pointer;
		}
		
		.popCmmn {
		  display:none;
		  position:fixed;
		  top:0;
		  left:0;
		  width:100%;
		  height:100%;
		}
		
		.popBg {
		  position:absolute;
		  top:0;
		  left:0;
		  width:100%;
		  height:100%;
		  background:rgba(0,0,0,0.7);
		}
		
		.popInnerBox {
		  display:flex;
		  justify-content:space-between;
		  flex-direction:column;
		  position:absolute;
		  top:50%;
		  left:50%;
		  width:400px;
		  height:250px;
		  margin:-125px 0 0 -200px;
		  text-align:center;
		  background:#fff;
		  border-radius:5px;
		}
		
		.popHead {
		  padding:15px;
		  color: black;
		  font-weight: bold;
		  font-size:18px;
		}
		
		.popBody {
		  padding:10px;
		  box-sizing:border-box;
		  font-size:14px;
		  color: black;
		  margin-bottom: 100px;
		}
		
		#close-button { 
			float:right;
			display:inline-block;
			padding:2px 5px;
			font-weight: 700;
			text-shadow: 0 1px 0 #fff;
			font-size: 1.3rem;
		}
		
		#close-button:hover { 
			border: 0;
			cursor:pointer;
			opacity: .75;
		}
		
		.cursor-pointer{
			cursor: pointer;
		}
		
		.privacy-tos{
			margin-left: 50px;
		}
		
		#insta-face{
			margin-left: auto;
			margin-right: 20px;
		}
		
		#copy-right{
			margin-left: 35px;
		}
	</style>
</head>
<body>
	<!-- Start exclusive deal Area -->
	<section class="exclusive-deal-area">
		<div class="container-fluid">
			<div class="row justify-content-center align-items-center">
				<div class="col-lg-6 no-padding exclusive-left">
					<div class="row clock_sec clockdiv" id="clockdiv">
						<div class="col-lg-12">
							<p>SERVICE GUIDE</p>
							<h1>슈즈곤 처음이지? <br>서비스 소개를 확인해보세요.</h1>
						</div>
					</div>
					<a class="primary-btn" id="white-color" onclick="window.open('/Shoesgone/views/common/service_intro.jsp')">서비스 안내</a>
				</div>
				<div class="col-lg-6 no-padding exclusive-right">
						<!-- single exclusive carousel -->
						<div class="single-exclusive-slider">
							<img  class="img-fluid" src="/Shoesgone/resources/img/product/e-p1.png" alt="">
							<div class="product-details">
								<div class="price">
									<h6>$150.00</h6>
									<h6 class="l-through">$210.00</h6>
								</div>
								<p>DOWNLOAD THE APP</p>
								<h4>슈즈곤 앱을 설치하여<br> 한정판 스니커즈를 FLEX 하세요!</h4>
								<div class="add-bag d-flex align-items-center justify-content-center">
									<a class="primary-btn popOpenBtnCmmn" id="white-color" data-num="5">앱 설치하기</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</section>
	<!-- End exclusive deal Area -->

	<!-- Start brand Area -->
	<section class="brand-area section_gap">
		<div class="container-new">
		<div class="row">
			<div class="right-side">
				<h5>이용안내</h5><br>
				<p><a class="popOpenBtnCmmn" id="grey-color" data-num="1">검수기준</a></p>
				<p><a class="popOpenBtnCmmn" id="grey-color" data-num="2">이용정책</a></p>
				<p><a class="popOpenBtnCmmn" id="grey-color" data-num="3">페널티 정책</a></p>
				<p><a class="popOpenBtnCmmn" id="grey-color" data-num="4">커뮤니티 가이드라인</a></p>
			</div>
			<div class="right-side">
				<h5>고객지원</h5><br>
				<% if(loginMember != null){ %>
					<% if(loginMember.getMgr().toString().equals("Y")){ %>
						<p><a id="grey-color" href="/Shoesgone/menubarsearch?menu=nlistadmin">공지사항</a></p>
					<% }else{ %>
						<p><a id="grey-color" href="/Shoesgone/menubarsearch?menu=nlistcustomer">공지사항</a></p>
					<% } %>
				<% }else{ %>
					<p><a id="grey-color" href="/Shoesgone/menubarsearch?menu=nlistcustomer">공지사항</a></p>
				<% } %>
				<p><a class="cursor-pointer" id="grey-color" onclick="window.open('/Shoesgone/views/common/service_intro.jsp')">서비스 소개</a></p>
				<p><a class="cursor-pointer" id="grey-color" onclick="window.open('/Shoesgone/views/common/showroom_guide.jsp')">쇼룸 안내</a></p>
				<p><a class="cursor-pointer" id="grey-color" onclick="window.open('/Shoesgone/views/common/seller_visit.jsp')">판매자 방문접수</a></p>
			</div>
			<div class="right-0 right-side">
				<h5>고객센터 1588-9999</h5><br>
				<p>운영시간 평일 11:00 - 18:00 (토 ∙ 일, 공휴일 휴무) 점심시간</p>
				<p>점심시간 평일 13:00 - 14:00</p>
				<h6>1:1 문의하기는 앱에서만 가능합니다.</h6><br>
				<a href="/Shoesgone/menubarsearch?menu=faq" class="primary-btn">자주 묻는 질문</a>
			</div>
		</div>
		<div id="popUp_1" class="popCmmn">
			<div class="popBg" data-num="1"></div>
			<div class="popInnerBox">
		    	<div class="popHead">검수기준
			    	<span class="popCloseBtnCmmn" id="close-button" data-num="1">&times;</span>
		    	</div>
		    	<div class="popBody">검수기준입니다.</div>
		    </div>
		</div>
		<div id="popUp_2" class="popCmmn">
			<div class="popBg" data-num="2"></div>
		  	<div class="popInnerBox">
		    	<div class="popHead">이용정책
		    		<span class="popCloseBtnCmmn" id="close-button" data-num="2">&times;</span>
		    	</div>
		    	<div class="popBody">이용정책입니다.</div>
		    </div>
		</div>
		<div id="popUp_3" class="popCmmn">
			<div class="popBg" data-num="3"></div>
		  	<div class="popInnerBox">
		    	<div class="popHead">페널티 정책
		    		<span class="popCloseBtnCmmn" id="close-button" data-num="3">&times;</span>
		    	</div>
		    	<div class="popBody">페널티 정책입니다.</div>
		  	</div>
		</div>
		<div id="popUp_4" class="popCmmn">
			<div class="popBg" data-num="4"></div>
		  	<div class="popInnerBox">
		    	<div class="popHead">커뮤니티 가이드라인
		    		<span class="popCloseBtnCmmn" id="close-button" data-num="4">&times;</span>
		    	</div>
		    	<div class="popBody">커뮤니티 가이드라인입니다.</div>
		  	</div>
		</div>
		<div id="popUp_5" class="popCmmn">
			<div class="popBg" data-num="5"></div>
			<div class="popInnerBox">
				<div class="popHead">앱 설치하여 사용해주세요!
					<span class="popCloseBtnCmmn" id="close-button" data-num="5">&times;</span>
				</div>
				<div class="popBody">앱 설치입니다.</div>
			</div>
		</div>
		</div>
	</section>
	<!-- End brand Area -->

	<!-- start footer Area -->
	<footer class="footer-area">
		<div class="row">
			<h6><a class="privacy-tos" id="white-color" href="/Shoesgone/views/common/privacyPolicy.jsp">개인정보처리방침</a></h6>
			<h6><a class="privacy-tos" id="white-color" href="/Shoesgone/views/common/tos.jsp">이용약관</a></h6>
			<div class="footer-social" id="insta-face">
				<a href="https://www.instagram.com/"><i class="fa fa-instagram"></i></a>
				<a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
			</div>
		</div>
		<div id="copy-right">
			슈즈곤 주식회사 · 대표 백정현 &nbsp; 사업자등록번호: 777-77-77777사업자정보확인 &nbsp; 통신판매업: 제 2021-서울마포A-0101호<br>
			<p>사업장소재지: 서울시 마포구 양화로 127, 첨단빌딩 7층 &nbsp; 개인정보관리책임자: 윤형석 &nbsp; 호스팅 서비스: 슈즈곤 클라우드 (주)</p>
			슈즈곤(주)는 통신판매 중개자로서 통신판매의 당사자가 아니므로 개별 판매자가 등록한 상품정보에 대해서 책임을 지지 않습니다.<br>
			단, 거래과정에서 검수하고 보증하는 내용에 대한 책임은 당사에 있습니다.
		</div>
		<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
		<div id="copy-right">
			<p class="footer-text">Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a></p><br>
		</div>
		<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
	</footer>
	<!-- End footer Area -->
  	
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
	<script type="text/javascript">
		$(function() {
			setPop();
		});
		// 팝업 세팅
		function setPop() {
			var popOpenBtn = $('.popOpenBtnCmmn');
			//팝업 열기
			popOpenBtn.on('click', function() {
				var clickNum = $(this).attr('data-num');
				$('#popUp_' + clickNum).fadeIn(200);
			})
			//팝업 닫기
			$('.popBg, .popCloseBtnCmmn').on('click', function() {
				var clickNum = $(this).attr('data-num');
				$('#popUp_' + clickNum).fadeOut(200);
			})
		}
	</script>
</body>
</html>