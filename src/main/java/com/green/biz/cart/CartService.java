package com.green.biz.cart;

import java.util.List;

import com.green.biz.dto.CartVO;

public interface CartService {
	
	public void insertCart(CartVO vo);
	
	public List<CartVO> listCart(String userId);
	
	public void deleteCart(int cseq);
	
	public void updateCart(int cseq);

}
