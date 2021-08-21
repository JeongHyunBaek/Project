<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shoesgone 관리자페이지</title>

<link rel="preconnect" href="https://fonts.gstatic.com">
<link
   href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap"
   rel="stylesheet">
<link rel="stylesheet"
   href="/Shoesgone/resources/plugins/assets/css/bootstrap.css">

<link rel="stylesheet"
   href="/Shoesgone/resources/plugins/assets/vendors/iconly/bold.css">

<link rel="stylesheet"
   href="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
<link rel="stylesheet"
   href="/Shoesgone/resources/plugins/assets/vendors/bootstrap-icons/bootstrap-icons.css">
<link rel="stylesheet"
   href="/Shoesgone/resources/plugins/assets/css/app.css">
<link rel="shortcut icon"
   href="/Shoesgone/resources/plugins/assets/images/favicon.svg"
   type="image/x-icon">
</head>
<div id="app">
   <%@ include file="/views/managerPage/common/adminmenubar.jsp"%>
   <div id="main">
      <header class="mb-3">
      </header>

      <div class="page-heading">
         <h3>관리자홈페이지</h3>
      </div>
      <div class="page-content">
         <section class="row">
            <div class="col-12 col-lg-9">
               <div class="row">
                  <div class="col-6 col-lg-3 col-md-6">
                     <div class="card">
                        <div class="card-body px-3 py-4-5">
                           <div class="row">
                              <div class="col-md-4">
                                 <div class="stats-icon purple">
                                    <i class="iconly-boldShow"></i>
                                 </div>
                              </div>
                              <div class="col-md-8">
                                 <h6 class="text-muted font-semibold">Profile Views</h6>
                                 <h6 class="font-extrabold mb-0">112.000</h6>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-6 col-lg-3 col-md-6">
                     <div class="card">
                        <div class="card-body px-3 py-4-5">
                           <div class="row">
                              <div class="col-md-4">
                                 <div class="stats-icon blue">
                                    <i class="iconly-boldProfile"></i>
                                 </div>
                              </div>
                              <div class="col-md-8">
                                 <h6 class="text-muted font-semibold">Followers</h6>
                                 <h6 class="font-extrabold mb-0">183.000</h6>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-6 col-lg-3 col-md-6">
                     <div class="card">
                        <div class="card-body px-3 py-4-5">
                           <div class="row">
                              <div class="col-md-4">
                                 <div class="stats-icon green">
                                    <i class="iconly-boldAdd-User"></i>
                                 </div>
                              </div>
                              <div class="col-md-8">
                                 <h6 class="text-muted font-semibold">Following</h6>
                                 <h6 class="font-extrabold mb-0">80.000</h6>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <div class="col-6 col-lg-3 col-md-6">
                     <div class="card">
                        <div class="card-body px-3 py-4-5">
                           <div class="row">
                              <div class="col-md-4">
                                 <div class="stats-icon red">
                                    <i class="iconly-boldBookmark"></i>
                                 </div>
                              </div>
                              <div class="col-md-8">
                                 <h6 class="text-muted font-semibold">Saved Post</h6>
                                 <h6 class="font-extrabold mb-0">112</h6>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="row">
                  <div class="col-12">
                     <div class="card">
                        <div class="card-header">
                           <h4>Profile Visit</h4>
                        </div>
                        <div class="card-body">
                           <div id="chart-profile-visit"></div>
                        </div>
                     </div>
                  </div>
               </div>
               
            </div>
            
         </section>
      </div>
      <%@ include file="/views/managerPage/common/adminfooter.jsp"%>
   </div>
</div>
<script
   src="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script
   src="/Shoesgone/resources/plugins/assets/js/bootstrap.bundle.min.js"></script>

<script
   src="/Shoesgone/resources/plugins/assets/vendors/apexcharts/apexcharts.js"></script>
<script src="/Shoesgone/resources/plugins/assets/js/pages/dashboard.js"></script>

<script src="/Shoesgone/resources/plugins/assets/js/main.js"></script>
</body>

</html>