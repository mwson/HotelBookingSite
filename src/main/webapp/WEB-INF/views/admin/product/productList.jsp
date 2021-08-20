<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../sideMenu.jsp"%>
<%@include file="../header.jsp"%>

<main class="content">
	<div class="container-fluid p-0">
		<div class="mb-3">
			<h1 class="h3 d-inline align-middle">상품목록</h1>
		</div>
		
        <form method="post" id="product_form" name="product_form">         
			<div class="row">
				<div class="col-8 col-lg-9">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">상품목록</h5>
							<h6 class="card-subtitle text-muted">등록한 상품목록입니다.</h6>
						</div>
						<div class="card-body text-center">
							<table class="table table-striped" style="text-align: center;">
								<thead>
									<tr>
										<th style="width: 10%">등록번호</th>
										<th style="width: 40%">상품명</th>
										<th style="width: 20%">가격</th>
										<th style="width: 15%">등록일</th>
                                        <th style="width: 15%">사용유무</th> 
									</tr>
								</thead>
								
								<tbody>
                                	<c:choose>
                                        <c:when test="${productListSize<=0}">
                                            <tr>
                                                <td colspan="5">
													등록된 상품이 없습니다.
                                                </td>      
                                            </tr>
                                        </c:when>
                                        
                                        <c:otherwise>
                                            <c:forEach items="${productList}" var="productVO">
                                                <tr>  
                                                    <td>${productVO.pseq}</td>    
                                                    <td>
                                                        <a href="admin_product_detail${pageMaker.makeQuery(pageMaker.cri.pageNum)}&pseq=${productVO.pseq}">
                                                            ${productVO.name}
                                                        </a>
                                                    </td>      
                                                    <td><fmt:formatNumber value="${productVO.price2}"/></td>
                                                    <td><fmt:formatDate value="${productVO.regdate}"/></td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test='${productVO.useyn=="n"}'>
																<input type="checkbox" id="useyn" name="useyn" disabled="disabled"> 미 사용
															</c:when>
															
                                                            <c:otherwise>
                                                            	<input type="checkbox" checked="checked" disabled="disabled"> 사용
                                                            </c:otherwise>
                                                        </c:choose>	
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:otherwise>    
                                	</c:choose>
								</tbody>                                	
							</table>
						</div>
						
						<%@include file="productPageArea.jsp"%>
						
					</div>
				</div>
	
				<div class="col-4 col-lg-3">
					<div class="card">
						<div class="card-header">
							<h5 class="card-title">검색</h5>
							<h6 class="card-subtitle text-muted">상품을 입력하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
								<input type="text" class="form-control" id="key" name="key">
                                <input type="button" class="btn btn-secondary" value="검색" onclick="go_search_product()">
							</div>
						</div>
                        <hr>
                        <div class="card-header">
							<h5 class="card-title">상품등록</h5>
							<h6 class="card-subtitle text-muted">상품을 등록하세요.</h6>
						</div>
						<div class="card-body">
							<div class="btn-group col-12 col-lg-12">
                                <input type="button" class="btn btn-primary btn-lg" value="상품등록" onclick="go_search_write()">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</main>

<%@include file="../footer.jsp"%>