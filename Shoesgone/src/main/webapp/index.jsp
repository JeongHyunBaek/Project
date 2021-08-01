<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>슈즈곤</title>
	<!--
		CSS
		============================================= -->
	<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.css" />
	<link rel="stylesheet" href="/Shoesgone/resources/css/ion.rangeSlider.skinFlat.css" />
	<link rel="stylesheet" href="/Shoesgone/resources/css/magnific-popup.css">
	
	<style>
		#ad-image-margin{
			margin-left: auto;
			margin-right: auto;
		}
		
		#ad1-style{
			background-color: rgb(54, 130, 176);
			text-align: center;
		}
		
		#ad2-style{
			background-color: rgb(227, 31, 106);
			text-align: center;
		}
		
		#ad3-style{
			background-color: rgb(160, 185, 190);
			text-align: center;
		}
		
		#ad4-style{
			background-color: rgb(255, 103, 17);
			text-align: center;
		}
		
		#today-style, #shoesgone-style{
			width: 100%;
			margin: 3em auto;
			display: flex;
			flex-wrap: wrap;
		}
		
		#today-style li, #shoesgone-style li{
			width: 16%;
			list-style: none;
			padding: 15px;
			margin-left: auto;
			margin-right: auto;
		}
		
		#today-style li img, #shoesgone-style li img{
			width: 100%;
		}
	</style>
</head>
<body>

	<%@ include file="views/common/menubar.jsp" %>

	<!-- start banner Area -->
	<section class="banner-area">
		<div class="container">
			<div class="row fullscreen align-items-center justify-content-start">
				<div class="col-lg-12">
					<div class="active-banner-slider owl-carousel">
						<!-- single-slide -->
						<div class="row single-slide align-items-center d-flex" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>택배사 휴무 안내</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<!-- single-slide -->
						<div class="row single-slide" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5">
								<div class="banner-content">
									<h1>개인정보 이용 처리방침 변경 안내</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<!-- single-slide -->
						<div class="row single-slide align-items-center d-flex" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>부정거래 이용제한 조치 안내</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<div class="row single-slide align-items-center d-flex" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>가품거래 시도와 관련한 조치사항</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<div class="row single-slide align-items-center d-flex" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>이용약관 변경 안내</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<div class="row single-slide align-items-center d-flex" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>7월 이벤트 당첨자 안내</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
						<div class="row single-slide align-items-center d-flex" style="cursor: pointer;" onclick="location.href='http://localhost:8080/Semi_Project/notice-page.html';">
							<div class="col-lg-5 col-md-6">
								<div class="banner-content">
									<h1>휴무일 안내</h1>
									<p>테스트 페이지입니다.</p>
									<div class="add-bag d-flex align-items-center">
									</div>
								</div>
							</div>
							<div class="col-lg-7">
								<div class="banner-img">
									<img class="img-fluid" src="/Shoesgone/resources/img/banner/banner-img.png" alt="">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End banner Area -->
	
	<!-- start product Area -->
	<section>
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>발매 상품</h1>			
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-035_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 쉐도우 2.0</h6>
								<div class="price">
									<h6>194,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-105_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 블랙 모카</h6>
								<div class="price">
									<h6>457,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-134_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 유니버시티 블루</h6>
								<div class="price">
									<h6>320,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-180_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 일렉트로 오렌지</h6>
								<div class="price">
									<h6>176,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>오늘의 스타일</h1>			
						</div>
					</div>
				</div>
					<div id="today-style"></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad1-style">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/travis_scott.png" alt="">
			</div>
			<div>
				<h1 id="white-color">조던 1 x 트래비스 스캇 x 프라그먼트 레트로 하이 OG SP 밀리터리 블루</h1><br>
			</div>
		</section>
		<!-- single product slide -->
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>인기 상품</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-402_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 하이퍼 로얄</h6>
								<div class="price">
									<h6>319,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/575441-402_0.png" alt="">
							<div class="product-details">
								<h6>(GS) 조던 1 레트로 하이 OG 하이퍼 로얄</h6>
								<div class="price">
									<h6>292,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/CU7544-400_0.png" alt="">
							<div class="product-details">
								<h6>나이키 x 앰부쉬 덩크 하이 딥 로얄 블루</h6>
								<div class="price">
									<h6>489,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DC0774-105_0.png" alt="">
							<div class="product-details">
								<h6>addidas New Hammer sole
									for Sports person</h6>
								<div class="price">
									<h6>$150.00</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>슈즈곤</h1>			
						</div>
					</div>
				</div>
					<div id="shoesgone-style"></div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad2-style">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/abstract_art.png" alt="">
			</div>
			<div>
				<h1 id="white-color">나이키 x 파라 SB 덩크 로우 프로 앱스트랙트 아트</h1><br>
			</div>
		</section>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>추천 상품</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DD1391-100_0.png" alt="">
							<div class="product-details">
								<h6>나이키 덩크 로우 레트로 블랙</h6>
								<div class="price">
									<h6>289,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DD1503-101_0.png" alt="">
							<div class="product-details">
								<h6>(W) 나이키 덩크 로우 블랙</h6>
								<div class="price">
									<h6>260,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DD1875-200_0.png" alt="">
							<div class="product-details">
								<h6>나이키 x 사카이 베이퍼와플 세서미 앤 블루 보이드</h6>
								<div class="price">
									<h6>604,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DD3223-100_0.png" alt="">
							<div class="product-details">
								<h6>나이키 x 피스마이너스원 에어포스 1 로우 파라노이즈 2.0</h6>
								<div class="price">
									<h6>470,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad3-style">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/golden_goose_superstar.png" alt="">
			</div>
			<div>
				<h1 id="white-color">골든구스 슈퍼스타 화이트 블랙탭 스니커즈</h1><br>
			</div>
		</section>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>새로운 즉시 구매가</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DH0690-200_0.png" alt="">
							<div class="product-details">
								<h6>조던 6 x 트래비스 스캇 레트로 SP 브리티쉬 카키</h6>
								<div class="price">
									<h6>348,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DJ0606-400_0.png" alt="">
							<div class="product-details">
								<h6>나이키 SB 덩크 로우 프로 프리미엄 바르셀로나</h6>
								<div class="price">
									<h6>240,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/DJ5718-300_0.png" alt="">
							<div class="product-details">
								<h6>조던 4 x 유니온 레트로 SP 데저트 모스</h6>
								<div class="price">
									<h6>345,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/GZ5554_0.png" alt="">
							<div class="product-details">
								<h6>아디다스 이지 슬라이드 퓨어</h6>
								<div class="price">
									<h6>137,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>			
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>새로운 즉시 판매가</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/M992EB_0.png" alt="">
							<div class="product-details">
								<h6>뉴발란스 992 메이드 인 USA 블랙 그레이</h6>
								<div class="price">
									<h6>195,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/M992GR_0.png" alt="">
							<div class="product-details">
								<h6>뉴발란스 992 메이드 인 USA 그레이 (D 스탠다드)</h6>
								<div class="price">
									<h6>210,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/MS327FE_0.png" alt="">
							<div class="product-details">
								<h6>뉴발란스 327 화이트 블랙</h6>
								<div class="price">
									<h6>110,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-035_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 쉐도우 2.0</h6>
								<div class="price">
									<h6>194,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
		<section id="ad4-style">
			<div class="col-lg-4" id="ad-image-margin">
				<img class="img-fluid" src="/Shoesgone/resources/img/sacai_blazer.png" alt="">
			</div>
			<div>
				<h1 id="white-color">나이키 x 사카이 블레이저 로우 아이언 그레이</h1><br>
			</div>
		</section>
		<div class="single-product-slider">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1></h1>
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-6 text-center">
						<div class="section-title">
							<h1>발매 예정</h1>
						</div>
					</div>
				</div>
				<div class="row">
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-105_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 블랙 모카</h6>
								<div class="price">
									<h6>457,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-134_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 유니버시티 블루</h6>
								<div class="price">
									<h6>357,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-180_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 일렉트로 오렌지</h6>
								<div class="price">
									<h6>176,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
					<!-- single product -->
					<div class="col-lg-3 col-md-6">
						<div class="single-product">
							<img class="img-fluid" src="/Shoesgone/resources/img/shoes_images/555088-402_0.png" alt="">
							<div class="product-details">
								<h6>조던 1 레트로 하이 OG 하이퍼 로얄</h6>
								<div class="price">
									<h6>319,000원</h6>
								</div>
								<div class="prd-bottom">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 text-center">
				<div class="section-title">
					<h1></h1>			
				</div>
			</div>
		</div>
	</section>
	<!-- end product Area -->

	<%@ include file="views/common/footer.jsp" %>

	<script src="/Shoesgone/resources/js/instafeed.min.js"></script>
	<script>
	    var feed1 = new Instafeed({
	    	target: 'today-style',
	    	template: '<li><a href="{{link}}"><img title="{{caption}}" src="{{image}}" /></a></li>',
	    	limit: 6,
	    	accessToken: 'IGQVJXcEVqbjRwMVB2a2VvcEZACY3Y3am5fX3h1bHMtdnJadjMtVHhNdnhoZAFdPS194clRqSTItWXQ1TE5hbG5xVWk1aThydVl0VmJCZAWFnRU9zdkwwcUFTVkZAGcEVsZAWFIZAW5nV2RvSVl2VDhOM0tDcwZDZD'
	    });
	    feed1.run();
	    
	    var feed2 = new Instafeed({
	    	target: 'shoesgone-style',
	    	template: '<li><a href="{{link}}"><img title="{{caption}}" src="{{image}}" /></a></li>',
	    	limit: 6,
	    	accessToken: 'IGQVJXcEVqbjRwMVB2a2VvcEZACY3Y3am5fX3h1bHMtdnJadjMtVHhNdnhoZAFdPS194clRqSTItWXQ1TE5hbG5xVWk1aThydVl0VmJCZAWFnRU9zdkwwcUFTVkZAGcEVsZAWFIZAW5nV2RvSVl2VDhOM0tDcwZDZD'
	    });
	    feed2.run();
	</script>
</body>
</html>