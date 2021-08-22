package com.green.biz.cart;

import java.util.List;

import com.green.biz.dto.CartVO;

public interface CartService {
	
	// "�����, ��ٱ���" �߰�
	public void insertCart(CartVO vo);
	
	// "�����, ��ٱ���" ��� ��ȸ
	public List<CartVO> listCart(String userId);

	// "�����, ��ٱ���" ����
	public void deleteCart(int cseq);
	
	// "������, ��ٱ���" ����
	public void updateCart(int cseq);

}
