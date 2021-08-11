<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
    
<%@include file="../header.jsp"%>   
<%@include file="sub_img.html"%> 
<%@include file="sub_menu.jsp"%>
 
<article>
	<h2>공지사항 게시판</h2>
	<h3>공지사항</h3>
		<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th> 
			</tr>
			
			<c:forEach items="${boardList}" var="boardVO">
				<tr>  
					<td>${boardVO.bseq}</td>    
					<td>
						<a href="board_view?bseq=${boardVO.bseq}">${boardVO.subject}</a>
					</td>      
					<td>
						<fmt:formatDate value="${boardVO.indate}" type="date"/>
					</td>
				</tr>
			</c:forEach>    
		</table>
		
		<div class="clear"></div>
		
		<div id="buttons" style="float:right">
			<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index'">  
		</div>
	</form>
</article>
  
<%@include file="../footer.jsp"%>