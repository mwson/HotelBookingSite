<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 중복확인</title>
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
	<div class="idCheck col-lg-4 col-md-4">
	    <h3 class="mb-5">아이디 중복확인</h3>
	    <div class="idCheck_form">
	        <form method="post" name="formm" id="theform" action="id_check_form">
	            <div class="idSearch">
	                <div class="idSearch_input">
						아이디 <input type="text" name="id" value="${id}"> 
	                </div>
	                <div class="idSearch_button">
	                    <input type="submit" class="btn btn-primary btn-sm btn-block" value="검색">
	                </div>
					<div class="idSearch_clear"></div>
	            </div>
                <c:if test="${message == 1}">
					<div class="idSearch_result">
	                    <div class="idSearch_result_fail">
	                        <script type="text/javascript">
	                            opener.document.formm.id.value="";
	                        </script>
	                        <br>
	                        ${id}는 이미 사용 중인 아이디입니다.
	                        <br>
	                    </div>
	                </div>
                </c:if>
                <c:if test="${message == -1}">
					<div class="idSearch_result">
						<br>
	                    <div class="idSearch_result_success">
	                        ${id}은(는) 사용 가능한 아이디입니다.
	                    </div>
	                    <div class="idSearch_result_success_button">
	                        <input type="button" class="btn btn-warning btn-sm btn-block" value="사용" onclick="idok()">
	                    </div>
	                    <br>
	                </div>
					<div class="idSearch_clear"></div>
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
	
	<script type="text/javascript">
		function idok() {
			opener.formm.id.value="${id}"; 
			opener.formm.reid.value="${id}";
			self.close();
		}
	</script>
</body>
</html>