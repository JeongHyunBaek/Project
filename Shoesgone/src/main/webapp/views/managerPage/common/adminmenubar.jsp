<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="sidebar" class="active">
		<div class="sidebar-wrapper active">
			<div class="sidebar-header">
				<div class="d-flex justify-content-between">
					<div class="logo">
						<a href="/Shoesgone/menubarsearch?menu=main" class="navbar-brand logo_h">
							슈즈곤
						</a>
					</div>
					<div class="toggler">
						<a href="#" class="sidebar-hide d-xl-none d-block">
							<i class="bi bi-x bi-middle"></i></a>
					</div>
				</div>
			</div>
			<div class="sidebar-menu">
				<ul class="menu">
					<li class="sidebar-title">Menu</li>

					<li class="sidebar-item active ">
						<a href="/Shoesgone/menubarsearch?menu=admin" class='sidebar-link'> 
							<i class="bi bi-grid-fill"></i> 
							<span>홈</span>
						</a>
					</li>

					<li class="sidebar-item ">
						<a href="/Shoesgone/itemlist.ad" class='sidebar-link'> 
								<i class="bi bi-file-earmark-medical-fill"></i> 
								<span>물품등록/관리</span>
						</a>
					</li>
					<li class="sidebar-item ">
						<a href="/Shoesgone/olist.ad" class='sidebar-link'> 
								<i class="bi bi-file-earmark-medical-fill"></i> 
								<span>주문현황</span>
						</a>
					</li>
					<li class="sidebar-item ">
						<a href="/Shoesgone/memberlist.ad" class='sidebar-link'> 
							<i class="bi bi-collection-fill"></i> 
							<span>사용자관리</span>
						</a>
					</li>

				</ul>
			</div>
			<button class="sidebar-toggler btn x">
				<i data-feather="x"></i>
			</button>
		</div>
	</div>
</body>
</html>