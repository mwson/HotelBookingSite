<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>  
<%@include file="sub_img.html"%> 
<%@include file="sub_menu.jsp"%>

<article>
	<h2>진행 완료 주문 내역</h2>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>주문일자</th>
				<th>주문번호</th>
				<th>상품명</th>
				<th>결제 금액</th>
				<th>주문 상세</th>   
			</tr>
			<c:forEach items="${orderList1}" var="orderVO">
				<tr>  
					<td>
						<fmt:formatDate value="${orderVO.indate}" type="date"/>
					</td>
					<td>${orderVO.oseq}</td>    
					<td>${orderVO.pname}</td>
					<td>
						<fmt:formatNumber value="${orderVO.price2}" type="currency"/>
					</td>
					<td>
						<a href="order_detail?oseq=${orderVO.oseq}"> 조회 </a><!--  -->
					</td>
				</tr>
			</c:forEach>    
		</table>   
		    
		<div class="clear"></div>
		
	</form>  
</article>

 <article>
	<h2>진행중인 주문 내역</h2>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>주문일자</th>
				<th>주문번호</th>
				<th>상품명</th>
				<th>결제 금액</th>
				<th>주문 상세</th>   
			</tr>
			<c:forEach items="${orderList2}" var="orderVO2">
				<tr>  
					<td>
						<fmt:formatDate value="${orderVO2.indate}" type="date"/>
					</td>
					<td>${orderVO2.oseq}</td>    
					<td>${orderVO2.pname}</td>
					<td>
						<fmt:formatNumber value="${orderVO2.price2}" type="currency"/>
					</td>
					<td>
						<a href="order_detail?oseq=${orderVO2.oseq}"> 조회 </a>
					</td>
				</tr>
			</c:forEach>    
		</table>   
		    
		<div class="clear"></div>
		
		<div id="buttons" style="float: right">
			<input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='index'"> 
		</div>
	</form>  
</article>
 
<%@include file="../footer.jsp"%>    