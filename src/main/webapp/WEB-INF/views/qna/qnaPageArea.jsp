<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-lg-12">
	<div class="pagination__number blog__pagination" style="text-align: center">
		<c:if test="${pageMaker.prev}">
			<a href="qna_list${pageMaker.makeQuery(pageMaker.startPage-1)}"><span class="arrow_left"></span> 이전</a>
		</c:if>
		
		<!-- 1, 2, 3.. 처리 -->
		<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="index">
			<a href="qna_list${pageMaker.makeQuery(index)}">${index}</a>
		</c:forEach>
		
		<c:if test="${pageMaker.next}">
			<a href="qna_list${pageMaker.makeQuery(pageMaker.endPage+1)}">다음 <span class="arrow_right"></span></a>
		</c:if>		
    </div>
</div>