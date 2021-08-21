<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="orderlist.model.vo.Orderlist, java.util.ArrayList"%>
    
       
     <% 

ArrayList<Orderlist> list = (ArrayList<Orderlist>)request.getAttribute("list");
int listCount = ((Integer)request.getAttribute("listCount")).intValue();
int startPage = ((Integer)request.getAttribute("startPage")).intValue();
int endPage = ((Integer)request.getAttribute("endPage")).intValue();
int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();




	%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DataTable - Mazer Admin Dashboard</title>

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
                            <h3>주문현황 </h3>
                            <br>
                            
                        </div>
                        <div class="col-12 col-md-6 order-md-2 order-first">
                            <nav aria-label="breadcrumb" class="breadcrumb-header float-start float-lg-end">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">DataTable</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
                <section class="section">
                    <div class="card">
                        <div class="card-header">
                            
                        </div>
                        <div class="card-body">
                            <table class="table table-striped" id="table1">
                                <thead>
                                    <tr>
                                        <th>상품명</th>
                                        <th>주문금액(수량)</th>
                                        <th>판매자</th>
                                        <th>구매자</th>
                                        <th>진행상태 </th>
                                    </tr>
                                </thead>
                                <tbody>
                                 <%
						
						for(int i = 0; i < list.size(); i++){
					%>
                                    <tr>
                                        <td><%= list.get(i).getItemEngName() %></td>
                                        <td><%= list.get(i).getPrice() %>(<%= list.get(i).getCount() %>)</td>
                                        <td><a href="#" onclick="window.open('/Shoesgone/info.ad?userNo=<%= list.get(i).getSellerNo() %>','name','resizable=no width=600 height=500');return false">
                                        <%= list.get(i).getSellerNo() %></a></td>
                                        <td><a href="#" onclick="window.open('/Shoesgone/info.ad?userNo=<%= list.get(i).getBuyerNo() %>','name','resizable=no width=600 height=500');return false">
                                        <%= list.get(i).getBuyerNo() %></a></td>
                                        <td>
                                            <span class="badge bg-success"><%= list.get(i).getProgress() %></span>
                                        </td>
                                    </tr>
                                         <% }	%>   
                                </tbody>
                            </table>
                        </div>
                    </div>

                </section>
            </div>

            <footer>
                <div class="footer clearfix mb-0 text-muted">
                    <div class="float-start">
                        <p>2021 &copy; Mazer</p>
                    </div>
                    <div class="float-end">
                        <p>Crafted with <span class="text-danger"><i class="bi bi-heart"></i></span> by <a
                                href="http://ahmadsaugi.com">A. Saugi</a></p>
                    </div>
                </div>
            </footer>
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