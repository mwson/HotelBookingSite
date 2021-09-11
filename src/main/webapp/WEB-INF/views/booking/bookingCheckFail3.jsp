<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>예약실패</title>
</head>
<body>
	<script type="text/javascript">
		alert("이미 예약된 날짜입니다. 다른 조건으로 검색하세요.");
		history.go(-1);
	</script>
</body>
</html>