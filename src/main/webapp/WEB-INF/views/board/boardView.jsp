<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>   
<%@include file="sub_img.html"%> 
<%@include file="sub_menu.jsp"%>   

<article>
	<h2>공지사항 게시판</h2>
	<h3>공지사항</h3>
	<form name="formm" method="post">
		<table id="notice">
			<tr>
				<th>제목</th>
				<td>${boardVO.subject}</td> 
			</tr>
			<tr>
				<th>등록일</th>
				<td>
					<fmt:formatDate value="${boardVO.indate}" type="date"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardVO.content}</td>
			</tr>
		</table>
		
		<div class="clear"></div>
		
		<div id="buttons" style="float:right">
			<input type="button" value="목록보기" class="submit" onclick="location.href='board_list'"> 
			<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index'">  
		</div>
	</form>
</article>

<%@include file="../footer.jsp"%>