package com.green.biz.cart;

import java.util.List;

import com.green.biz.dto.CartVO;

public interface CartService {
	
	// "사용자, 장바구니" 추가
	public void insertCart(CartVO vo);
	
	// "사용자, 장바구니" 목록 조회
	public List<CartVO> listCart(String userId);

	// "사용자, 장바구니" 삭제
	public void deleteCart(int cseq);
	
	// "관리자, 장바구니" 예약
	public void updateCart(int cseq);

}
