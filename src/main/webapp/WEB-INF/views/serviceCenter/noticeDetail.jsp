<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<%@include file="../header.jsp"%>

<section class="blog-hero spad set-bg" data-setbg="images/hbg-1.jpg">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-10 text-center">
                <div class="blog__hero__text">
                    <div class="tag">${noticeVO.kind}</div>
                    <h2>${noticeVO.kind} 상세</h2>
                    <ul>
                        <li><i class="fa fa-clock-o"></i><fmt:formatDate value="${noticeVO.indate}" type="date"/></li>
                        <li><i class="fa fa-user"></i>그린호텔</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="blog-details spad">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-lg-10">
                <div class="blog__details__content">
                    <div class="blog__details__desc">
                        <div class="blog__details__desc__item">
                            <h3>${noticeVO.subject}</h3>
                            <p>${noticeVO.content}</p>
                        </div>
                    </div>
                    <div class="blog__details__pic">
                        <div class="row">
                            <div class="col-lg-12 col-md-12">
                                <div class="row">
									<img src="notice_images/${noticeVO.image}" alt="">
                                </div>
                            </div>
                        </div>
                    </div>

                    <%@include file="noticeComment.jsp"%>

                </div>
            </div>
        </div>
    </div>
</section>

<section class="feature-blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title bd-title">
                    <h2>공지사항 목록</h2>
                </div>
            </div>
        </div>
        <div class="row">
			<c:forEach items="${noticeList}" var="noticeVO">
	            <div class="col-lg-4 col-md-4 col-sm-6">
	                <div class="blog__item">
	                    <div class="blog__item__pic">
	                        <img src="notice_images/${noticeVO.image}" alt="">
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
        </div>
    </div>
</section>

<%@include file="../footer.jsp"%>