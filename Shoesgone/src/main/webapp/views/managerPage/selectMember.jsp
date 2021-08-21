<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import=" information.model.vo.Information"%>
	
	<% 
	Information information = (Information)request.getAttribute("information"); 
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자페이지</title>
</head>
<body>
	<div class="card-body">
		<h3>회원정보조회</h3>
		<table style="text-align :left;">
	
				<tr>
					<th>회원번호</th>
					<td><%= information.getUserNo() %></td>
				</tr>
				<tr>
					<th>회원 아이디</th>
					<td><%= information.getUserId() %></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><%if(information.getUserName() != null){ %><%= information.getUserName() %><% }else{%><%}%></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><%if(information.getEmail() != null){ %><%= information.getEmail() %><% }else{%><%}%></td>
				</tr>
				<tr>
					<th>휴대폰 번호</th>
					<td><%if(information.getPhone() != null){ %><%= information.getPhone() %><% }else{%><%}%></td>
				</tr>
		
		</table>
	</div>
</body>
</html>