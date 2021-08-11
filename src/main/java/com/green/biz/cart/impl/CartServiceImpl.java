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
	
	@Override
	public void insertCart(CartVO vo) {
		cartDao.insertCart(vo);
	}

	@Override
	public List<CartVO> listCart(String userId) {
		return cartDao.listCart(userId);
	}

	@Override
	public void deleteCart(int cseq) {
		cartDao.deleteCart(cseq);
	}

	@Override
	public void updateCart(int cseq) {
		cartDao.updateCart(cseq);
		
	}

}
