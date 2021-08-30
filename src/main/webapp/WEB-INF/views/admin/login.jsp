<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>호텔그린</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
	<link rel="stylesheet" href="css/nice-select.css" type="text/css">
	<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
	<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
	<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
	<link rel="stylesheet" href="css/admin/admin.css" type="text/css">
</head>
<body>
	<main class="d-flex w-100">
		<div class="container d-flex flex-column">
			<div class="row vh-100">
				<div class="col-sm-10 col-md-8 col-lg-5 mx-auto d-table h-100">
					<div class="d-table-cell align-middle">
						<div class="card">
							<div class="card-body">
								<div class="m-sm-5">
									<div class="text-center mb-5">
										<img src="img/logo.png" width="132" height="132" />										
									</div>
									
									<form method="post" id="formm" name="formm" action="admin_login">
										<p class="text-danger" style="text-align: center">${message}</p>
										<div class="mb-3">
											<label class="form-label">아이디</label>
											<input type="text" class="form-control form-control-lg" id="workerId" name="workerId" placeholder="아이디" value="admin">
										</div>
										<div class="mb-3">
											<label class="form-label">비밀번호</label>
											<input type="password" class="form-control form-control-lg" id="workerPwd" name="workerPwd" placeholder="비밀번호" value="admin">
										</div>
										<div class="text-center mt-4">
											<input type="button" class="btn btn-primary btn-lg" value="로그인" onclick="worker_check()">											
										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>

	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/jquery.slicknav.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>
    <script type="text/javascript" src="js/admin/admin.min.js"></script>
    
    <script type="text/javascript" src="admin/admin.js"></script>
</body>
</html>