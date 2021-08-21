<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="itemPage.model.vo.Item, java.util.ArrayList"%>
<% 
	ArrayList<Item> items = (ArrayList<Item>) request.getAttribute("items");
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
                            <h3>물품현황</h3>
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
                        <div class="card-header" style="padding:unset;padding-top:10px;padding-right:35px;">
                        	<button type="button" class="btn btn-danger" data-bs-toggle="modal" 
                        	data-bs-target="#ItemADD" style="float:right;">물품추가</button>
                          	<div class="modal fade" id="ItemADD" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                              <div class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable" role="document">
                                  <div class="modal-content">
                                      <div class="modal-header">
                                          <h5 class="modal-title" id="ItemADDTitle">물품정보 추가</h5>
                                          <button type="button" class="close rounded-pill" data-bs-dismiss="modal" aria-label="Close" style="background:black;">
                                              <i data-feather="x"></i>
                                          </button>
                                      </div>
                                      <div class="modal-body">
                                      	<form action="/Shoesgone/iteminsert.ad" method="post" enctype="multipart/form-data">
                                           <div class="form-group">
                                           	<label for="itemengname">영문명</label>
                                           	<input type="text" class="form-control" name="itemengname" value="">
                                           	<label for="itemkrname">국문명</label>
                                           	<input type="text" class="form-control" name="itemkrname" value="">
                                           	<label for="itembrand">브랜드</label>
                                           	<input type="text" class="form-control" name="itembrand" value="">
                                           	<label for="itemmodelno">모델 번호</label>
                                           	<input type="text" class="form-control" id="ItemADDmodelno" name="itemmodelno" value="">
                                           	<input type="button" class="btn btn-sm btn-outline-primary" value="중복체크" onclick="return dupmodelCheck();"><br>
                                           	<label for="itemcolors">색상(,로만구분)</label>
                                           	<input type="text" class="form-control" id="ItemADDcolors" name="itemcolors" value="">
                                           	<label for="itemprice">가격(원)</label>
                                           	<input type="number" class="form-control" name="itemprice" value="">
                                           	<label for="itemdropdate">발매일자</label>
                                           	<input type="date" class="form-control" name="itemdropdate" value="">
                                           	<label for="itempictures">첨부파일</label>
                                           	<input type="button" id="additem" class="close rounded-pill" style="background:black;">추가
                                           	<input type="button" id="removeitem" class="close rounded-pill" style="background:black;">제거
                                           	<div id="inputfiles"></div>
                                           	<h5 class="card-title" style="font-size: 1rem; color: rgba(35,28,99,.7);">사이즈</h5>
                                           	<div class="card-content">
	                                         	<div class="card-body" id="shoessizes" style="padding:0;">
	                                         		<ul class="list-unstyled mb-0">
	                                         			<% for(int k=0; k<25; k++){ %>
	                                         			<li class="d-inline-block me-2 mb-1">
	                                         				<div class="form-check">
	                                         					<div class="checkbox">
	                                         						<input type="checkbox" name="shoessize" class="form-check-input" value="<%= k*5 + 200 %>" >
	                                         						<label for="checkbox1"><%= k*5 + 200 %></label>
	                                         					</div>
	                                         				</div>
	                                         			</li>
	                                         			<% } %>
	                                         		</ul>
	                                         	</div>
                                           	</div>
                                           	<input type="submit" class="btn btn-primary ml-1" value="등록하기" style="float:right;">
                                           	<input type="reset" class="btn btn-light-secondary" value="초기화" style="float:right;margin-right:5px;">
                                           	<br>
                                           	</div>
                                       	</form>
                                      </div>
                                  </div>
                              </div>
                          	</div>
                        </div>
                        <div class="card-body">
                            <table class="table table-striped" id="table1">
                                <thead>
                                    <tr>
                                        <th>상품 영문명</th>
                                        <th>브랜드</th>
                                        <th>모델번호 </th>
                                        <th>가격 </th>
                                        <th>발매일자 </th>
                                        <th>수정하기</th>
                                        <th>삭제하기</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<% for(Item i : items){ 
                                		String[] sizes = i.getShoesSizes().split(",");
                                		String[] checked = new String[25];
                                		for(String size : sizes){
                                			switch(size){
                                			case "200": checked[0] = "checked"; break;
                                			case "205": checked[1] = "checked"; break;
                                			case "210": checked[2] = "checked"; break;
                                			case "215": checked[3] = "checked"; break;
                                			case "220": checked[4] = "checked"; break;
                                			case "225": checked[5] = "checked"; break;
                                			case "230": checked[6] = "checked"; break;
                                			case "235": checked[7] = "checked"; break;
                                			case "240": checked[8] = "checked"; break;
                                			case "245": checked[9] = "checked"; break;
                                			case "250": checked[10] = "checked"; break;
                                			case "255": checked[11] = "checked"; break;
                                			case "260": checked[12] = "checked"; break;
                                			case "265": checked[13] = "checked"; break;
                                			case "270": checked[14] = "checked"; break;
                                			case "275": checked[15] = "checked"; break;
                                			case "280": checked[16] = "checked"; break;
                                			case "285": checked[17] = "checked"; break;
                                			case "290": checked[18] = "checked"; break;
                                			case "295": checked[19] = "checked"; break;
                                			case "300": checked[20] = "checked"; break;
                                			case "305": checked[21] = "checked"; break;
                                			case "310": checked[22] = "checked"; break;
                                			case "315": checked[23] = "checked"; break;
                                			case "320": checked[24] = "checked"; break;
                                			}
                                		}
                                	%>
                                    <tr>
                                        <td><%= i.getItemEngName() %></td>
                                        <td><%= i.getBrand() %></td>
                                        <td><%= i.getModelNo() %></td>
                                        <td><%= i.getPrice() %></td>
                                        <td><%= i.getDropDate() %></td>
                                        <td>
                                        	<button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModalCenter<%= i.getItemNo() %>">수정하기</button>
                                        	<div class="modal fade" id="exampleModalCenter<%= i.getItemNo() %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered modal-dialog-centered modal-dialog-scrollable" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalCenterTitle">물품정보 수정</h5>
                                                        <button type="button" class="close rounded-pill" data-bs-dismiss="modal" aria-label="Close" style="background:black;">
                                                            <i data-feather="x"></i>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                    	<form action="/Shoesgone/itemupdate.ad" method="post">
	                                                        <div class="form-group">
	                                                        	<label for="itemno">물품번호</label>
	                                                        	<input type="number" class="form-control" name="itemno" value="<%= i.getItemNo() %>" readonly>
	                                                        	<label for="itemengname">영문명</label>
	                                                        	<input type="text" class="form-control" name="itemengname" value="<%= i.getItemEngName() %>">
	                                                        	<label for="itemkrname">국문명</label>
	                                                        	<input type="text" class="form-control" name="itemkrname" value="<%= i.getItemKrName() %>">
	                                                        	<label for="itembrand">브랜드</label>
	                                                        	<input type="text" class="form-control" name="itembrand" value="<%= i.getBrand() %>">
	                                                        	<label for="itemmodelno">모델 번호</label>
	                                                        	<input type="text" class="form-control" name="itemmodelno" value="<%= i.getModelNo() %>">
	                                                        	<label for="itemcolors">색상(,로만구분)</label>
	                                                        	<input type="text" class="form-control" name="itemcolors" value="<%= i.getShoesColors() %>">
	                                                        	<label for="itemprice">가격(원)</label>
	                                                        	<input type="number" class="form-control" name="itemprice" value="<%= i.getPrice() %>">
	                                                        	<label for="itemregdate">수정일자</label>
	                                                        	<input type="date" class="form-control" name="itemregdate" value="<%= i.getRegDate() %>" readonly>
	                                                        	<label for="itemdropdate">발매일자</label>
	                                                        	<input type="date" class="form-control" name="itemdropdate" value="<%= i.getDropDate() %>">
	                                                        </div>
	                                                        <div>
	                                                        	<h5 class="card-title" style="font-size: 1rem; color: rgba(35,28,99,.7);">사이즈</h5>
	                                                        </div>
	                                                        <div class="card-content">
	                                                        	<div class="card-body" id="itemsizes" style="padding:0;">
	                                                        		<ul class="list-unstyled mb-0">
	                                                        			<% for(int j=0; j<25; j++){ %>
	                                                        			<li class="d-inline-block me-2 mb-1">
	                                                        				<div class="form-check">
	                                                        					<div class="checkbox">
	                                                        						<input type="checkbox" name="size" class="form-check-input" value="<%= j*5 + 200 %>" <%= checked[j] %>>
	                                                        						<label for="checkbox1"><%= j*5 + 200 %></label>
	                                                        					</div>
	                                                        				</div>
	                                                        			</li>
	                                                        			<% } %>
	                                                        		</ul>
	                                                        	</div>
	                                                        </div>
	                                                        <input type="submit" class="btn btn-primary ml-1" value="수정하기" style="float:right;">
	                                                        <input type="reset" class="btn btn-light-secondary" value="초기화" style="float:right;margin-right:5px;">
	                                                        <br>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        	</div>
                                    	</td>
                                    	<td>
                                    		<a type="button" class="btn btn-danger" href="/Shoesgone/itemdelete.ad?itemno=<%= i.getItemNo() %>">삭제하기</a>
                                    	</td>
                                    </tr>
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
	<script type="text/javascript">
    function dupmodelCheck(){
    	//jQuery.ajax();
    	$.ajax({
    		url: "/Shoesgone/dupmodelno",
    		type: "post",
    		data: {modelno: $("#ItemADDmodelno").val()},
    		success: function(data){
    			console.log("success : " + data);
    			if(data == "ok"){
    				alert("등록가능합니다.");
    				$("#ItemADDcolors").focus();
    			}else{
    				alert("이미 사용중인 아이디입니다.");
    				$("#ItemADDmodelno").select();
    			}
    		},
    		error: function(jqXHR, textStatus, errorThrown){
    			console.log("error : " + jqXHR + ", " 
    					+ textStatus + ", " + errorThrown);
    			return false;
    		}
    	});
    }
    
    $(document).ready(function() {
        $('#additem').click(function() {
            const html = '<input type="file" value="" name="files' + filenum + '" />';
            $('#inputfiles').append(html);
            filenum += 1;
        });
        
        $('#intreset').click(function() {
            filenum = 0;
        });
        
        $('#removeitem').click(function() {
        	$("#inputfiles *").remove();
        	filenum = 0;
        });
    });
    
    var filenum = 0;
    </script>
    <script src="/Shoesgone/resources/plugins/assets/js/main.js"></script>
</body>

</html>