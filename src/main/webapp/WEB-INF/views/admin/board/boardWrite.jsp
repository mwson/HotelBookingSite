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
	<h1>게시판등록</h1>  
	<!-- [1] 파일을 업로드 하기 위해서는 폼태그를 post 방식으로 전송하고, 인코딩 타입을 multipart/form-data 로 지정해야 한다. -->
	<form name="frm" id="board_write_form" method="post" enctype="multipart/form-data">
		<table id="list">
			<tr>
				<th>제목</th>
				<td width="343" colspan="5">
					<input type="text" name="subject" id="subject" size="47" maxlength="100">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="5">
					<textarea name="content" id="content" rows="8" cols="70"></textarea>
				</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td width="343" colspan="5">
					<!-- [2] 파일 업로드를 하기 위한 input 태그는 타입 속성 값을 file로 지정해야 한다. -->
					<input type="file" name="board_image" id="board_image">
				</td>
			</tr>    
		</table>
		
		<input class="btn" type="button" value="등록" onClick="go_board_write()">           
		<input class="btn" type="button" value="취소" onClick="go_board_list()">
	</form> 
</article>

<%@include file="../footer.jsp"%>