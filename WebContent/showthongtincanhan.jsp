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
				<li><a href="#">>Thông tin cá nhân</a></li>

			</ul>
		</div>

		<div class="content" align="center">
			<h2>Xem thông tin cá nhân</h2>
		</div>
		<div class="container text-center">
		<form action="DA_trangcanhan.jsp" method="post">
			<div class="row">
				<div class="thongtincanhan">

					<hr>
					<div class="taohoso" align="left">
						<div class="col-sm-3">
							<h4>Thông tin cá nhân</h4>
						</div>
						<div class="col-sm-6">
							<table class='table table-borderless'>

								<tbody>
									<tr>
										<td>ID Người dùng :</td>
										<td><%=arrAccount.get(0).getIdAccount()%></td>
									</tr>
									<tr>
										<td>Tên người dùng :</td>
										<td><%=arrAccount.get(0).getUsername()%></td>
									</tr>
									<tr>
										<td>Điện thoại :</td>
										<td><%=arrAccount.get(0).getPhoneNumber()%></td>
									</tr>
									<tr>
										<td>Email :</td>
										<td><%=arrAccount.get(0).getEmail()%></td>
									</tr>
									<tr>
										<%
											String cn = "Quản trị viên";
											if (!arrAccount.get(0).getRole())
												cn = "Người dùng";
										%>
										<td>Chức năng :</td>
										<td>cn</td>
									</tr>


								</tbody>
							</table>

						</div>
						<div class="col-sm-3"></div>
					</div>
				</div>
			</div>
			  <input type = "submit" value = "Quay lại"  class="btn btn-primary">
</form>
			<jsp:include page="footter.jsp"></jsp:include>
		</div>
		
</body>
</html>