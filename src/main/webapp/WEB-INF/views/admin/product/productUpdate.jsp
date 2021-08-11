<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../header.jsp"%>
<%@include file="../sub_menu.jsp"%>

<script type="text/javascript">
	function admin_product_list() {
		var theForm = document.frm;
		theForm.action = "admin_product_list";
		theForm.submit();
	}
</script>
<article>
	<h1>상품수정</h1>  
	<form name="frm" id="update_form" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pseq" value="${productVO.pseq}">
		<input type="hidden" name="code" >
		<input type="hidden" name="nonmakeImg" value="${productVO.image}">
		<table id="list">
			<tr>
				<th>상품분류</th>
				<td colspan="5">
					<select name="kind" id="kind">
						<c:forEach items="${kindList}" var="kind" varStatus="status">
							<c:choose>
								<c:when test="${productVO.kind==status.count}">
									<option value="${status.count}" selected="selected">${kind}</option>
								</c:when>
								
								<c:otherwise>
									<option value="${status.count}">${kind}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> 
				</td>
			</tr>
			
			<tr>
			<th>상품명</th>
				<td width="343" colspan="5">
					<input type="text" name="name" id="name" size="47" maxlength="100" value="${productVO.name}">
				</td>
			</tr>
			
			<tr>
				<th>원가[A]</th>
				<td width="70">        
					<input type="text" name="price1" id="price1" size="11" onKeyUp='NumFormat(this)' value="${productVO.price1}">
				</td>
				<th>판매가[B]</th>
				<td width="70">
					<input type="text" name="price2" id="price2" size="11" onBlur="go_ab()" onKeyUp='NumFormat(this)' value="${productVO.price2}">
				</td>
				<th>[B-A]</th>
				<td width="72">
					<input type="text" name="price3" id="price3" size="11" readonly onKeyUp='NumFormat(this)'>
				</td>
			</tr>
			
			<tr>
				<th>베스트상품</th>
				<td>
					<c:choose>
						<c:when test='${productVO.bestyn=="y"}'>
							<input type="checkbox" name="bestyn" id="bestyn" value="y" checked="checked">
						</c:when>
						
						<c:otherwise>
							<input type="checkbox" name="bestyn" id="bestyn" value="n">
						</c:otherwise>
					</c:choose>
				</td>
				<th>사용유무</th>
				<td>
					<c:choose>
						<c:when test='${productVO.useyn=="y"}'>
							<input type="checkbox" name="useyn" id="useyn" value="y" checked="checked">
						</c:when>
						
						<c:otherwise>
							<input type="checkbox" name="useyn" id="useyn" value="n">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			
			<tr>
				<th>상세설명</th>
				<td colspan="5">
					<textarea name="content" id="content" rows="8" cols="70" >${productVO.content}</textarea>
				</td>
			</tr>
			
			<tr>
				<th>상품이미지</th>
				<td colspan="5">
					<img src="product_images/${productVO.image}" width="200pt">     
					<br>
					<input type="file" name="product_image" id="product_image">
					<input type="hidden" name="image" value="${productVO.image}">
				</td> 
			</tr>    
		</table>
		
		<input class="btn" type="button" value="수정" onClick="go_mod_save('${productVO.pseq}')">           
		<input class="btn" type="button" value="취소" onClick="admin_product_list()">
	</form> 
</article>

<%@include file="../footer.jsp"%>