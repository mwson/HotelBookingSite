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
	<link rel="stylesheet" href="css/admin/admin.css" type="text/css">
	
	<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
    <div class="wrapper">
        <nav id="sidebar" class="sidebar js-sidebar">
            <div class="sidebar-content js-simplebar">
                <a class="sidebar-brand" href="admin_order_list">
                    <span class="align-middle">관리자</span>
                </a>

                <ul class="sidebar-nav">
                    <li class="sidebar-header">
						예약 및 상품
                    </li>
					<li class="sidebar-item">
						<a class="sidebar-link" href="admin_order_list">
							<i class="align-middle" data-feather="check-square"></i> <span class="align-middle">예약목록</span>
						</a>
					</li>
					<li class="sidebar-item">
						<a class="sidebar-link" href="admin_room_list">
							<i class="align-middle" data-feather="shopping-bag"></i> <span class="align-middle">객실목록</span>
						</a>
					</li>
					<li class="sidebar-item">
						<a class="sidebar-link" href="admin_sales_record_form">
							<i class="align-middle" data-feather="trending-up"></i> <span class="align-middle">예약실적</span>
						</a>
					</li>

                    <li class="sidebar-header">
						고객센터
                    </li>
					<li class="sidebar-item">
						<a class="sidebar-link" href="admin_notice_list">
							<i class="align-middle" data-feather="list"></i> <span class="align-middle">공지사항목록</span>
						</a>
					</li>
					<li class="sidebar-item">
						<a class="sidebar-link" href="admin_qna_list">
							<i class="align-middle" data-feather="coffee"></i> <span class="align-middle">Q&amp;A목록</span>
						</a>
					</li>

                    <li class="sidebar-header">
						회원관리
                    </li>
					<li class="sidebar-item">
                        <a class="sidebar-link" href="admin_member_list">
                            <i class="align-middle" data-feather="users"></i> <span class="align-middle">회원목록</span>
                        </a>
                    </li>
                </ul>

                <div class="sidebar-cta">
                    <div class="sidebar-cta-content">
                        <strong class="d-inline-block mb-2">그린호텔</strong>
                        <div class="mb-3 text-sm">
                           	그린호텔 메인으로 이동하려면
							<br>
							아래 버튼을 클릭하세요.
                        </div>
                        <div class="d-grid">
                            <a href="admin_logout_user_index" class="btn btn-primary">로그아웃</a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>