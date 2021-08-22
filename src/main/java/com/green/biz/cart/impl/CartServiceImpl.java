package com.green.biz.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.cart.CartService;
import com.green.biz.dao.CartDAO;
import com.green.biz.dto.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDao;

	// "사용자, 장바구니" 추가
	@Override
	public void insertCart(CartVO vo) {
		cartDao.insertCart(vo);
	}
	
	// "사용자, 장바구니" 목록 조회
	@Override
	public List<CartVO> listCart(String userId) {
		return cartDao.listCart(userId);
	}
	
	// "사용자, 장바구니" 삭제
	@Override
	public void deleteCart(int cseq) {
		cartDao.deleteCart(cseq);
	}
	
	// "관리자, 장바구니" 예약
	@Override
	public void updateCart(int cseq) {
		cartDao.updateCart(cseq);
		
	}

}
