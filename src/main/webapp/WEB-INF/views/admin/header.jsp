<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="main">
    <nav class="navbar navbar-expand navbar-light navbar-bg">
        <a class="sidebar-toggle js-sidebar-toggle">
            <i class="hamburger align-self-center"></i>
        </a>
        <div class="navbar-collapse collapse">
            <ul class="navbar-nav navbar-align">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="admin_order_list" data-bs-toggle="dropdown">
                        <span class="text-dark"><i class="align-middle me-1" data-feather="user"></i> 관리자</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end">
                        <a class="dropdown-item" href="admin_logout_user_index"><i class="align-middle me-1" data-feather="log-in"></i> 그린호텔 메인</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="admin_logout"><i class="align-middle me-1" data-feather="log-out"></i> 로그아웃</a>
                    </div>
                </li>
            </ul>
        </div>
    </nav>