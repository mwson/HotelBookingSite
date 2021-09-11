<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="card-body text-center">
	<ul class="text-center">
		<c:if test="${pageMaker.prev}">
			<a href="admin_member_list${pageMaker.makeQuery(pageMaker.startPage-1)}&key=${key}">[이전]</a>
		</c:if>
		
		<!-- [1][2][3].. 처리 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
			<a href="admin_member_list${pageMaker.makeQuery(index)}&key=${key}">[${index}]</a>
		</c:forEach>
		
		<c:if test="${pageMaker.next}">
			<a href="admin_member_list${pageMaker.makeQuery(pageMaker.endPage+1)}&key=${key}">[다음]</a>
		</c:if>		
	</ul>
</div>