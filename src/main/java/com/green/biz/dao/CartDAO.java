package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.CartVO;

@Repository("cartDAO")
public class CartDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "사용자, 장바구니" 추가
	public void insertCart(CartVO vo) {
		mybatis.insert("CartDAO.insertCart", vo);
	}
	
	// "사용자, 장바구니" 목록 조회
	public List<CartVO> listCart(String userId) {
		return mybatis.selectList("CartDAO.listCart", userId);
	}
	
	// "사용자, 장바구니" 삭제
	public void deleteCart(int cseq) {
		mybatis.delete("CartDAO.deleteCart", cseq);
	}
	
	// "관리자, 장바구니" 예약
	public void updateCart(int cseq) {
		mybatis.update("CartDAO.updateCart", cseq);
	}
	
}
