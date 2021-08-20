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
	
	// "주문목록" 총 개수 조회 처리
	public int countOrderList(String name) {
		return mybatis.selectOne("OrderDAO.countOrderList", name);
	}
	
	// 전체 주문내역 조회
	public List<OrderVO> listOrder(String key) {
		return mybatis.selectList("OrderDAO.listOrder", key);
	}
	
	// "예약목록" 조회 및 페이징
	public List<OrderVO> listOrderwithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("OrderDAO.listOrderwithPaging", map);
	}
	
	// 주문완료 처리
	public void updateOrderResult(int odseq) {
		mybatis.update("OrderDAO.updateOrderResult", odseq);
	}
	
}