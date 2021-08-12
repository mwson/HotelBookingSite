<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="mypage/matchPassword.js"></script>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<style type="text/css">
	body{   
		background-color:#B96DB5;
		font-family: Verdana;
	}
	
	#popup{   
		padding: 0 10px;
	}
	
	#popup h1 {
		font-family: "Times New Roman", Times, serif;
		font-size: 45px;
		color: #CCC;
		font-weight: normal;
	}
	
	table#zipcode {
		border-collapse: collapse;	/* border 사이의 간격 없앰 */   
		border-top: 3px solid  #fff;  
		border-bottom: 3px solid  #fff;
		width: 100%;  
		margin-top: 15px; 
	}
	
	table#zipcode th, table#zipcode td{   
		text-align: center;
		border-bottom: 1px dotted  #fff;  
		color: #FFF;   
	}
	
	table th, td{
		padding: 10px;
	}
	
	table#zipcode a{
		display: block; 
		height: 20px;
		text-decoration: none;
		color: #fff;
		padding: 10px;
	}
	
	table#zipcode a:hover{
		color: #F90;
		font-weight: bold;
	}
</style>

</head>
<body>
	<div id="popup">
		<h1>비밀번호 확인</h1>
		<form method="get" id="checkPassword" name="formm" action="password_check">
			<input type="hidden" id="originPwd" value="${originPwd}"/>
			비밀번호 <input id="inputPwd" type="password" name="inputPwd" value="">
			<input type="button" value="입력" onclick="passwordCheck2()">
		</form>
	</div>
</body>
</html>