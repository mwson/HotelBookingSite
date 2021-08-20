<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>

<script type="text/javascript">
	function go_board_list() {
		var theForm = document.frm;
		theForm.action = "admin_board_list";
		theForm.submit();
	}
</script>
<article>
	<h1>공지사항 리스트</h1>
	<form name="frm" id="board_detail_form" method="post">
		<input type="hidden" name="bseq" value="${boardVO.bseq}">
		<table id="orderList">
			<tr>
				<th width="20%">제목</th>
				<td>${boardVO.subject}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${boardVO.indate}"/></td>  
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardVO.content}</td>  
			</tr>
		</table>
		
		<input type="button" class="btn" value="수정" onClick="go_board_update_form('${boardVO.bseq}')">
		<input type="button" class="btn" value="삭제" onClick="go_board_delete()">
		<input type="button" class="btn" value="목록" onClick="go_board_list()">
	</form>
</article>

<%@include file="../footer.jsp"%>