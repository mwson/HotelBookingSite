<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>
<%@include file="../sub_menu.jsp"%>

<script type="text/javascript">
	function go_board_list() {
		var theForm = document.frm;
		theForm.action = "admin_board_list";
		theForm.submit();
	}
</script>
<article>
	<h1>상품수정</h1>  
	<form name="frm" id="board_update_form" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bseq" value="${boardVO.bseq}">
		<input type="hidden" name="code">
		<input type="hidden" name="nonmakeImg" value="${boardVO.image}">
		<table id="list">
			<tr>
				<th>제목</th>
				<td width="343" colspan="5">
					<input type="text" name="subject" id="subject" size="47" maxlength="100" value="${boardVO.subject}">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5">
					<textarea name="content" id="content" rows="8" cols="70">${boardVO.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td width="343" colspan="5">
					<img src="board_images/${boardVO.image}" width="200pt">     
					<br>
					<input type="file" name="board_image" id="board_image">
					<input type="hidden" name="image" value="${boardVO.image}">
				</td>
			</tr>    
		</table>
		
		<input class="btn" type="button" value="수정" onClick="go_board_update('${boardVO.bseq}')">           
		<input class="btn" type="button" value="취소" onClick="go_board_list()">
	</form> 
</article>

<%@include file="../footer.jsp"%>