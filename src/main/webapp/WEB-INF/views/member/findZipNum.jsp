<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>우편번호검색</title>
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
	<div class="findZipNum col-lg-4 col-md-4">
	    <h3 class="mb-5">우편번호검색</h3>
	    <div class="findZipNum_form">
	        <form method="post" name="formm" action="find_zip_num">
	            <div class="findZipNum_search">
	                <div class="findZipNum_search_input">
						동 이름 <input type="text" name="dong"> 
	                </div>
	                <div class="findZipNum_search_button">
	                    <input type="submit" class="btn btn-primary btn-sm btn-block" value="찾기">
	                </div>
	                <div class="findZipNum_search_clear"></div>
	            </div>
	        </form>
	    </div>
	    <div class="findZipNum_result">
	        <table class="table table-striped">
	            <thead>
	                <tr>
	                    <th style="width: 25%;">우편번호</th>
	                    <th>주소</th>
	                </tr>
	            </thead>
	            <c:forEach items="${addressList}" var="addressVO">
	                <tbody>
	                    <tr>
	                        <td>${addressVO.zip_num}</td>
	                        <td>
	                            <a href="#" onclick="return result('${addressVO.zip_num}', '${addressVO.sido}', '${addressVO.gugun}', '${addressVO.dong}')">
	                                ${addressVO.sido} ${addressVO.gugun} ${addressVO.dong} 
	                            </a>
	                        </td>
	                    </tr>
	                </tbody>
	            </c:forEach>
	        </table>
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
		function result(zip_num, sido, gugun, dong) {
			opener.document.formm.zip_num.value=zip_num;
			opener.document.formm.addr1.value=sido+" "+gugun+" "+dong;
			self.close();
		};
	</script>
</body>
</html>