package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.OrderVO;
import com.green.biz.utils.Criteria;

@Repository("orderDAO")
public class OrderDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int selectMaxOseq() {
		return mybatis.selectOne("OrderDAO.selectMaxOseq");
	}
	
	public int insertOrder(OrderVO vo) {
		return mybatis.insert("OrderDAO.insertOrder", vo);
	}
	
	public void insertOrderDetail(OrderVO vo) {
		mybatis.insert("OrderDAO.insertOrderDetail", vo);
	}
	
	public List<OrderVO> listOrderById(OrderVO vo) {
		return mybatis.selectList("OrderDAO.listOrderById", vo);
	}
	
	public List<Integer> selectSeqOrdering(OrderVO vo) {
		return mybatis.selectList("OrderDAO.selectSeqOrdering", vo);
	}
	
	// "�ֹ����" �� ���� ��ȸ ó��
	public int countOrderList(String name) {
		return mybatis.selectOne("OrderDAO.countOrderList", name);
	}
	
	// ��ü �ֹ����� ��ȸ
	public List<OrderVO> listOrder(String key) {
		return mybatis.selectList("OrderDAO.listOrder", key);
	}
	
	// "������" ��ȸ �� ����¡
	public List<OrderVO> listOrderwithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("OrderDAO.listOrderwithPaging", map);
	}
	
	// �ֹ��Ϸ� ó��
	public void updateOrderResult(int odseq) {
		mybatis.update("OrderDAO.updateOrderResult", odseq);
	}
	
}