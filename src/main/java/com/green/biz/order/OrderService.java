package com.green.biz.order;

import java.util.List;

import com.green.biz.dto.OrderVO;
import com.green.biz.utils.Criteria;

public interface OrderService {
	
	public int selectMaxOseq();
	
	public int insertOrder(OrderVO vo);
	
	public void insertOrderDetail(OrderVO vo);
	
	public List<OrderVO> listOrderById(OrderVO vo);
	
	public List<Integer> selectSeqOrdering(OrderVO vo);
	
	public List<OrderVO> listOrder(String key);
	
	public int countOrderList(String name);

	public List<OrderVO> listOrderwithPaging(Criteria criteria, String key);
	
	public void updateOrderResult(int odseq);
	
}