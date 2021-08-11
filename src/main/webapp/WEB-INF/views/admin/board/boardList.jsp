<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>
<%@include file="../sub_menu.jsp"%>

<article>
	<h1>공지사항 리스트</h1>  
	<form name="frm" id="board_list" method="post">
		<input type="hidden" name="bseq">
		<table style="float: right;">
			<tr>
				<td> 
					<input class="btn" type="button" value="등록" onclick="go_board_write_form()">
				</td>
			</tr>
		</table>
		<table id="orderList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>    
			</tr>
			
			<c:forEach items="${boardList}" var="boardVO">  
				<tr>
					<td>
						${boardVO.bseq}
					</td>
					<td> 
						<a href="#" onClick="go_board_detail('${boardVO.bseq}')">
							${boardVO.subject} 
						</a>
					</td>
					<td><fmt:formatDate value="${boardVO.indate}"/></td>
				</tr>
			</c:forEach>
		</table>
	</form>    
</article>

<%@include file="../footer.jsp"%>