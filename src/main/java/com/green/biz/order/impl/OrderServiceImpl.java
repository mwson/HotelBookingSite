package com.green.biz.order.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.cart.CartService;
import com.green.biz.dao.OrderDAO;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.OrderVO;
import com.green.biz.order.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDAO orderDao;
	@Autowired
	private CartService cartService;
	
	@Override
	public int selectMaxOseq() {
		return orderDao.selectMaxOseq();
	}
	
	/*
	 * �ֹ����� ����
	 */
	@Override
	public int insertOrder(OrderVO vo) {
		int oseq = 0;
		
		// �ֹ����̺��� ���� oseq��ȣ�� �о�´�.
		oseq = selectMaxOseq();	// ���� �ֹ���ȣ ����
		
		// �ֹ� ���̺� �ֹ���ȣ�� ȸ�� ID ����
		vo.setOseq(oseq);
		orderDao.insertOrder(vo);
		
		// ��ٱ��� ����� �о�´�.
		List<CartVO> cartList = cartService.listCart(vo.getId());
		
		// ��ٱ����� ������ order_detail ���̺� ����
		for(CartVO cartVO : cartList) {
			OrderVO order = new OrderVO();
			order.setOseq(oseq);
			order.setPseq(cartVO.getPseq());
			order.setQuantity(cartVO.getQuantity());
			
			insertOrderDetail(order);
			
			// ��ٱ��� ���̺� ������Ʈ
			cartService.updateCart(cartVO.getCseq());
		}
		
		return oseq;
	}

	@Override
	public void insertOrderDetail(OrderVO vo) {
		orderDao.insertOrderDetail(vo);
	}

	@Override
	public List<OrderVO> listOrderById(OrderVO vo) {
		return orderDao.listOrderById(vo);
	}

	@Override
	public List<Integer> selectSeqOrdering(OrderVO vo) {
		return orderDao.selectSeqOrdering(vo);
	}

	@Override
	public List<OrderVO> listOrder(String key) {
		return orderDao.listOrder(key);
	}

	@Override
	public void updateOrderResult(int odseq) {
		orderDao.updateOrderResult(odseq);
	}

}