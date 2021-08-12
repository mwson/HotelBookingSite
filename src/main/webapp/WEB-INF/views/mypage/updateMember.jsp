<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   
<%@include file="sub_img.html"%> 
<%@include file="sub_menu.jsp"%>

<article>
	<h2>회원정보 수정</h2>
	<form id="update" action="update" method="post" name="formm">
	
		<fieldset>
			<legend>Basic Info</legend>
			<label>User ID</label>
			<input type="text" name="id" id="id" readonly="readonly" value="${memberVO.id}">

			<br>
			<label>Password</label> 
			<input type="password" name="pwd" id="pwd" value="${memberVO.pwd}">
			<br> 
			<label>Name</label>
			<input type="text" name="name" id="name" readonly="readonly" value="${memberVO.name}">
			<br> 
			<label>E-Mail</label>
			<input type="text" name="email" value="${memberVO.email}">
			<br>
		</fieldset>
		
		<fieldset>
			<legend>Optional</legend>
			<label>Zip Code</label> 
			<input type="text" name="zip_num" size="10" value="${memberVO.zip_num}">      
			<input type="button" value="주소 찾기" class="dup" onclick="post_zip()">
			<br>
			<label>Address</label> 
			<input type="text" name="addr1" size="50" value="${memberVO.address}">
			<br>
			<label>Phone Number</label> 
			<input type="text" name="phone" value="${memberVO.phone}">
			<br>
		</fieldset>
		
		
		<div class="clear"></div>
		
		<div id="buttons">
			<input type="button" value="수정" class="submit" onclick="go_update()"> 
			<input type="reset" value="취소" class="cancel">
		</div>
		<br>
	</form>
</article>

<%@include file="../footer.jsp"%>  