<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<div class="breadcrumb-option set-bg" data-setbg="img/breadcrumb-bg.jpg">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h1>공지사항</h1>
                    <div class="breadcrumb__links">
                        <a href="index">메인</a>
                        <span>고객센터</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4">
                <div class="blog__sidebar">
                    <div class="blog__sidebar__search">
                        <h4>검색</h4>
                        <form action="#">
                            <input type="text" placeholder="입력">
                            <button type="submit">검색</button>
                        </form>
                    </div>
                    <div class="blog__sidebar__categories">
                        <h4>고객센터</h4>
                        <ul>
                            <li><a href="notice_list">공지사항</a></li>
                            <li><a href="#">자주하는 질문</a></li>
                            <li><a href="#">문의하기</a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <div class="col-lg-8 col-md-8">
                <div class="row">
                	<c:forEach items="${noticeList}" var="noticeVO">
	                    <div class="col-lg-6 col-md-6">
	                        <div class="blog__item">
	                            <div class="blog__item__pic">
	                                <img src="img/blog/blog-1.jpg" alt="">
	                                <!-- 사진
	                                <img src="${noticeVO.image}" alt="">
	                                -->
	                                <div class="tag">${noticeVO.kind}</div>
	                            </div>
	                            <div class="blog__item__text">
	                                <p>
	                                	<i class="fa fa-clock-o"></i>
	                                	<fmt:formatDate value="${noticeVO.indate}" type="date"/>
	                                </p>
	                                <h5><a href="notice_detail?nseq=${noticeVO.nseq}">${noticeVO.subject}</a></h5>
	                            </div>
	                        </div>
	                    </div>
	                </c:forEach>
                    <div class="col-lg-12">
                        <div class="pagination__number blog__pagination">
                            <a href="#">1</a>
                            <a href="#">2</a>
                            <a href="#">Next <span class="arrow_right"></span></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>