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
        <div class="findId">
			<h3 class="mb-5">아이디 찾기</h3>
        	<div class="findId_form">
	            <form name="findId" id="findId" action="find_id" method="get">
	                <div class="mb-4">
	                    <label for="id">이름</label>
	                    <input type="text" class="form-control" id="nameId" name="name" placeholder="이름">
	                </div>
	                <div class="mb-4">
	                    <label for="email">이메일</label> 
	                    <input type="text" class="form-control" id="emailId" name="email" placeholder="이메일">
	                </div>
	                <input type="button" class="btn btn-warning btn-lg btn-block" value="아이디 찾기" onclick="findMemberId()">
	            </form>
			</div>
        </div>
        <br>
        <hr class="mb-4">
        <div class="findPw col-lg-3 col-md-3">
            <h3 class="mb-5">비밀번호 찾기</h3>
			<div class="findPw_form">
	            <form name="findPw" id="findPw" action="find_password" method="get">
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
	                <input type="button" class="btn btn-warning btn-lg btn-block" value="비밀번호 찾기" onclick="findPassword()">
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

	<script type="text/javascript" src="member/findIdAndPassword.js"></script>
</body>
</html>