package com.green.biz.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.ProductDAO;
import com.green.biz.dto.ProductVO;
import com.green.biz.dto.SalesQuantity;
import com.green.biz.product.ProductService;
import com.green.biz.utils.Criteria;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;
	
	@Override
	public ProductVO getProduct(ProductVO vo) {
		return productDao.getProduct(vo);
	}

	@Override
	public List<ProductVO> getProductList() {
		return productDao.getProductList();
	}

	@Override
	public List<ProductVO> getNewProductList() {
		return productDao.getNewProductList();
	}

	@Override
	public List<ProductVO> getBestProductList() {
		return productDao.getBestProductList();
	}

	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		return productDao.getProductListByKind(kind);
	}
	
	@Override
	public int countProductList(String name) {
		return productDao.countProductList(name);
	}

	@Override
	public List<ProductVO> listProduct(String name) {
		return productDao.listProduct(name);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		productDao.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		productDao.updateProduct(vo);
	}

	@Override
	public List<ProductVO> listWithPaging(Criteria criteria, String key) {
		return productDao.listWithPaging(criteria, key);
	}

	@Override
	public List<SalesQuantity> getProductSales() {
		return productDao.getProductSales();
	}

}