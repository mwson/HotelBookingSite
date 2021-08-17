<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>호텔그린</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
	<link rel="stylesheet" href="css/nice-select.css" type="text/css">
	<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
	<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
	<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<!--
	<link rel="stylesheet" href="css/shopping.css">
	-->
</head>
<body>
	<div id="preloder">
        <div class="loader"></div>
    </div>

    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-7">
                        <ul class="header__top__widget">
                            <li><span class="icon_pin_alt"></span> 서울시 용산구 OOO</li>
                            <li><span class="icon_phone"></span> (02) 1234-5678</li>
                        </ul>
                    </div>
                    <div class="col-lg-5">
                        <div class="header__top__right">
                            <div class="header__top__auth">
                                <ul>
	                                <c:choose>
										<c:when test="${empty sessionScope.loginUser}">
											<li><a href="#">관리자</a></li>
		                                    <li><a href="login_form">로그인</a></li>
		                                    <li><a href="contract">회원가입</a></li>
										</c:when>
										
										<c:otherwise>
											<li>
												<a href="#">
													${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
												</a>
											</li>
											<li><a href="logout">로그아웃</a></li>
										</c:otherwise>       
									</c:choose>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="header__nav__option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2">
                        <div class="header__logo">
                            <a href="index"><img src="img/logo.png" alt=""></a>
                        </div>
                    </div>
                    <div class="col-lg-10">
                        <div class="header__nav">
                            <nav class="header__menu">
                                <ul class="menu__class">
                                    <li class="active"><a href="index">메인</a></li>
                                    <li><a href="introduce_hotel">호텔 소개</a>
                                        <ul class="dropdown">
                                            <li><a href="introduce_hotel">호텔 개요</a></li>
                                            <li><a href="introduce_room">객실 안내</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">고객센터</a>
                                        <ul class="dropdown">
                                            <li><a href="notice_list">공지사항</a></li>
                                            <li><a href="./room-details.html">자주하는 질문</a></li>
                                            <li><a href="./blog-details.html">문의하기</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">마이 페이지</a>
                                        <ul class="dropdown">
                                            <li><a href="./about.html">회원정보 수정</a></li>
                                            <li><a href="./room-details.html">예약확인</a></li>
                                            <li><a href="./blog-details.html">장바구니</a></li>
                                            <li><a href="./blog-details.html">문의내역</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </nav>
                            <div class="header__nav__widget">
                                <a href="#">예약하기 <span class="arrow_right"></span></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="canvas__open">
                    <span class="fa fa-bars"></span>
                </div>
            </div>
        </div>
    </header>