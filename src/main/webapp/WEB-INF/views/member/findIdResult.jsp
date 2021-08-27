<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
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
	<div class="findIdResult">
		<h3 class="mb-5">아이디 찾기</h3>
		<div style="padding: 0 5%;">
	        <div class="findIdResult_form col-lg-3 col-md-3">
				<form method="POST" name=formm>
					<c:if test="${message == 1}">
						<script type="text/javascript">
							opener.document.formm.id.value="${id}";
						</script>
						<p class="mb-3">조회된 아이디는 ${id}입니다.</p>
					</c:if>
					<c:if test="${message == -1}">
						<p class="mb-3">입력하신 정보를 찾을 수 없습니다.</p>
					</c:if>
					<input type="button" class="btn btn-warning btn-lg btn-block" value="확인" onclick="idok()">
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
	
	<script type="text/javascript">
		function idok() {
			self.close();
		}
	</script>
</body>
</html>