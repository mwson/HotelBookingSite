package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProductVO;
import com.green.biz.dto.SalesQuantity;
import com.green.biz.utils.Criteria;

@Repository("productDAO")
public class ProductDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public ProductVO getProduct(ProductVO vo) {
		return mybatis.selectOne("ProductDAO.getProduct", vo);
	}
	
	public List<ProductVO> getProductList() {
		return mybatis.selectList("ProductDAO.getProductList");
	}
	
	public List<ProductVO> getNewProductList() {
		return mybatis.selectList("ProductDAO.getNewProductList");
	}
	
	public List<ProductVO> getBestProductList() {
		return mybatis.selectList("ProductDAO.getBestProductList");
	}
	
	public List<ProductVO> getProductListByKind(String kind) {
		return mybatis.selectList("ProductDAO.getProductListByKind", kind);
	}
	
	// 총 상품 목록의 개수 조회
	public int countProductList(String name) {
		return mybatis.selectOne("ProductDAO.countProductList", name);
	}
	
	// "상품목록" 
	public List<ProductVO> listWithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("ProductDAO.listProductWithPaging", map);
	}
	
	// 상품 목록 조회
	public List<ProductVO> listProduct(String name) {
		return mybatis.selectList("ProductDAO.listProduct", name);
	}
	
	// 상품 추가
	public void insertProduct(ProductVO vo) {
		mybatis.insert("ProductDAO.insertProduct", vo);
	}
	
	// 상품 수정
	public void updateProduct(ProductVO vo) {
		mybatis.update("ProductDAO.updateProduct", vo);
	}
	
	// 상품 삭제
	public void deleteProduct(int pseq) {
		mybatis.delete("ProductDAO.deleteProduct", pseq);
	}
	
	/*
	 * 상품별 판매 실적
	 */
	public List<SalesQuantity> getProductSales() {
		return mybatis.selectList("ProductDAO.getProductSales");
	}
	
}
