<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>비밀번호 찾기</title>
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
	<div class="findPwdResult col-lg-4 col-md-4">
		<h3 class="mb-5">비밀번호 찾기</h3>
        <div class="findPwdResult_form">
			<form method="post" name="formm" id="pwd_form">
				<input type="hidden" name="id" value="${id}">
				<c:if test="${message == 1}">
					<h5 class="mb-4" style="text-align: center; color: #E9AD28;">비밀번호 변경</h5>
					<div class="mb-4">
	                    <label for="pwd">비밀번호</label>
	                    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호">
                	</div>
                	<div class="mb-4">
	                    <label for="pwdCheck">비밀번호 확인</label>
	                    <input type="password" class="form-control" id="pwdCheck" name="pwdCheck" placeholder="비밀번호 확인">
                	</div>
                	<input type="button" class="btn btn-warning btn-lg btn-block" value="확인" onclick="changePassword()">
                </c:if>
                <c:if test="${message == -1}">
					<p class="mb-3">입력하신 정보를 찾을 수 없습니다.</p>
					<input type="button" class="btn btn-warning btn-lg btn-block" value="확인" onclick="idok()">
				</c:if>
            </form>
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
	
	<script type="text/javascript">
		function idok() {
			self.close();
		}
	</script>
</body>
</html>