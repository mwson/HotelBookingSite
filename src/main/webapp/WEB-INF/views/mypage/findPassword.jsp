<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 / 비밀번호 찾기</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
	<link rel="stylesheet" href="css/nice-select.css" type="text/css">
	<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
	<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
	<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div class="findIdAndPassword col-lg-4 col-md-4">
        <div class="findPw col-lg-3 col-md-3">
            <h3 class="mb-5">비밀번호 찾기</h3>
			<div class="findPw_form">
	            <form method="get" name="findPwd" id="findPwd" action="find_password">
	                <div class="mb-4">
	                    <label for="id">아이디</label>
	                    <input type="text" class="form-control" id="idPw" name="id" placeholder="아이디">
	                </div>
	                <div class="mb-4">
	                    <label for="email">이름</label> 
	                    <input type="text" class="form-control" id="namePw" name="name" placeholder="이름">
	                </div>
	                <div class="mb-4">
	                    <label for="email">이메일</label> 
	                    <input type="text" class="form-control" id="emailPw" name="email" placeholder="이메일">
	                </div>
	                <input type="button" class="btn btn-warning btn-lg btn-block" value="비밀번호 찾기" onclick="pwdCheckFindPwd()">
	            </form>
            </div>
        </div>
    </div>
	
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.nice-select.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/jquery.slicknav.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/main.js"></script>

	<script type="text/javascript" src="mypage/findPassword.js"></script>
</body>
</html>