<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.ArrayList, loginPage.model.vo.Login, information.model.vo.Information"%>
<% 
	ArrayList<Information> users = (ArrayList<Information>) request.getAttribute("users");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shoesgone</title>

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/css/bootstrap.css">

    <link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/vendors/simple-datatables/style.css">

    <link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/vendors/bootstrap-icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/Shoesgone/resources/plugins/assets/css/app.css">
    <link rel="shortcut icon" href="/Shoesgone/resources/plugins/assets/images/favicon.svg" type="image/x-icon">
</head>
<body>
    <div id="app">
    	<%@ include file="/views/managerPage/common/adminmenubar.jsp"%>
        <div id="main">
            <header class="mb-3">
                <a href="#" class="burger-btn d-block d-xl-none">
                    <i class="bi bi-justify fs-3"></i>
                </a>
            </header>
			
            <div class="page-heading">
                <div class="page-title">
                    <div class="row">
                        <div class="col-12 col-md-6 order-md-1 order-last">
                            <h3>사용자 현황</h3>
                            <br>
                        </div>
                        <div class="col-12 col-md-6 order-md-2 order-first">
                            <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">x</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">DataTable</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
                <section class="section">
                    <div class="card">
                        <div class="card-header" style="padding:unset;padding-top:10px;padding-right:35px;">
							관리자
                        </div>
                        <div class="card-body">
                            <table class="table table-striped" id="table1">
                                <thead>
                                    <tr>
                                        <th> 사용자 번호 </th>
                                        <th> 이름 </th>
                                        <th> ID </th>
                                        <th> 이메일 </th>
                                        <th> 전화번호 </th>
                                        <th> 잔여포인트 </th>
                                        <th> 매니저여부 </th>
                                        <th> 로그인 여부 </th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<% for(Information user:users){ %>
                                		<% if(user.getMgr().equals("Y")){ %>
		                                    <tr id="row<%= user.getUserNo() %>" style="background:lightgreen;">
		                                        <td><%= user.getUserNo() %></td>
		                                        <td><%= user.getUserName() %></td>
		                                        <td><%= user.getUserId() %></td>
		                                        <td><%= user.getEmail() %></td>
		                                        <td><%= user.getPhone() %></td>
		                                        <td><%= user.getPoint() %></td>
		                                        <td id="mgr<%= user.getUserNo() %>">
		                                        	<%= user.getMgr() %> &nbsp;&nbsp;
		                                        	<input type="button" value="변경" onclick="location.href='/Shoesgone/updatemgr.ad?userno=<%= user.getUserNo() %>';">
		                                        </td>
		                                        <td>
		                                        	<%= user.getLoginOk() %> &nbsp;&nbsp;
		                                        	<input type="button" value="변경" onclick="location.href='/Shoesgone/updatelok.ad?userno=<%= user.getUserNo() %>';">
		                                        </td>
		                                    </tr>
	                                    <% }else{ %>
	                                    	<tr id="row<%= user.getUserNo() %>">
		                                        <td><%= user.getUserNo() %></td>
		                                        <td><%= user.getUserName() %></td>
		                                        <td><%= user.getUserId() %></td>
		                                        <td><%= user.getEmail() %></td>
		                                        <td><%= user.getPhone() %></td>
		                                        <td><%= user.getPoint() %></td>
		                                        <td id="mgr<%= user.getUserNo() %>">
		                                        	<%= user.getMgr() %> &nbsp;&nbsp;
		                                        	<input type="button" value="변경" onclick="location.href='/Shoesgone/updatemgr.ad?userno=<%= user.getUserNo() %>';">
		                                        </td>
		                                        <td>
		                                        	<%= user.getLoginOk() %> &nbsp;&nbsp;
		                                        	<input type="button" value="변경" onclick="location.href='/Shoesgone/updatelok.ad?userno=<%= user.getUserNo() %>';">
		                                        </td>
		                                    </tr>
	                                    <% } %>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
            </div>
            <%@ include file="/views/managerPage/common/adminfooter.jsp"%>
        </div>
    </div>
    <script src="/Shoesgone/resources/plugins/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script src="/Shoesgone/resources/plugins/assets/js/bootstrap.bundle.min.js"></script>

    <script src="/Shoesgone/resources/plugins/assets/vendors/simple-datatables/simple-datatables.js?after"></script>
    <script type="text/javascript" src="/Shoesgone/resources/js/jquery-3.6.0.min.js"></script>
    <script>
        // Simple Datatable
        let table1 = document.querySelector('#table1');
        let dataTable = new simpleDatatables.DataTable(table1);
    </script>
    <script src="/Shoesgone/resources/plugins/assets/js/main.js"></script>
</body>
</html>