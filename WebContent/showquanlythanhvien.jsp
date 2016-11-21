<%@page import="model.bean.Account"%>
<%@page import="model.bean.Tindang"%>
<%@page import="model.bean.Vacxin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Quản lý thành viên</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
<style type="text/css">
.tt tr td {
	padding-top: 10px;
	padding: 10px 10px;
	font-size: 16pt;
}

.sub {
	margin-top: 20px;
	margin-bottom: 20px;
	width: 150px;
	font-size: 14pt;
	background-color: green;
	color: white;
	height: 35px;
}

.text {
	font-size: 14pt;
}

.loi {
	color: red;
}

.content {
	padding-top: 10px;
	padding-bottom: 20px;
	background-image: url(images/default.png);
	width: 100%;
}

#main {
	padding-left: 5%;
}
</style>
</head>
<%
	ArrayList<Account> arrAccount = new ArrayList<Account>();
    arrAccount = (ArrayList<Account>) request.getAttribute("arrAccount");
%>
<body>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="head-link" align="center">
				<ul>
					<li><a href="ShowTrangChu?">Trang chủ</a></li>
					<li><a href="DA_showtrangcanhan?">>Trang cá nhân</a></li>
					<li><a href="#">>Quản lý thành viên</a></li>
					
				</ul>
		</div> 
		
		<div class="content" align="center">
			<h2>Xem các thành viên</h2>
			<form action="" method="post">
				
				<table class="table">
				<thead>
				
      <tr>
        <th>STT</th>
        <th>ID </th>
        <th>Tên </th>
        <th>Điện thoại</th>
        <th>Email</th>
        <th>Chức năng</th>
      </tr>
    </thead>

						
					<%
						for (int i = 0; i < arrAccount.size(); i++) {
					%>
					 <tbody>
                     <tr class="success">
				<% 
				String cn="Quản trị viên";
				if(!arrAccount.get(i).getRole())
					cn="Người dùng";
				%>
							<th align="center"><%=i+1%></th>
							<th align="center"><%=arrAccount.get(i).getIdAccount()%></th>
							<th align="center"><%=arrAccount.get(i).getUsername()%></th>
                            <th align="center"><%=arrAccount.get(i).getPhoneNumber()%></th>
                            <th align="center"><%=arrAccount.get(i).getEmail()%></th>
                            <th align="center"><%= cn%></th>
					</tr>
					<%
						}
					%>
					
				
				</table>
			
			</form>
		</div>
		
		<jsp:include page="footter.jsp"></jsp:include>
	</div>
</body>
</html>