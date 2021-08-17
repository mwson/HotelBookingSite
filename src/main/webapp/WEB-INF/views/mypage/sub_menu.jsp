<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<meta charset="UTF-8">
<nav id="sub_menu">

<div class="menu_wrapp">
	<ul>
		<li><a href="#" onclick="window.open('match_pwd','비밀번호 확인','width=600, height=200, menubar=no, status=no, toolbar=no');">회원정보 수정</a></li>
	</ul>
	<ul>
		<li><a href="mypage">예약확인</a></li>
		
	</ul>
	<ul class="dep1">
			<li><a href="#">장바구니</a></li>
			<ul class="dep2" style="display:none">
				<li><a href="cart_list">장바구니(cart)내역</a></li>
				<li><a href="mypage">진행중인 주문내역</a></li>
				<li><a href="order_all">총 주문내역</a></li><!--  -->
			</ul>
			</ul>
	<ul class="dep1_1">
			<li><a href="#">문의내역</a></li><!--  -->
			<ul class="dep2_1" style="display:none">
				<li><a href="qna_list">문의내역</a></li>
				<li><a href="qna_write_form">문의하기</a></li>
			</ul>
			</ul>
	
</div>
<script>
            $(".dep1").click(function(){
                if($(".dep2").is(":visible")){
                    $(".dep2").slideUp();
                }
                else{
                    $(".dep2").slideDown();
                }
            })
            
            $(".dep1_1").click(function(){
                if($(".dep2_1").is(":visible")){
                    $(".dep2_1").slideUp();
                }
                else{
                    $(".dep2_1").slideDown();
                }
            })
        </script>	
</nav> 