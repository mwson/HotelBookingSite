package com.green.biz.product;

import java.util.List;

import com.green.biz.dto.ProductVO;
import com.green.biz.dto.SalesQuantity;
import com.green.biz.utils.Criteria;

public interface ProductService {
	
	public ProductVO getProduct(ProductVO vo);
	
	public List<ProductVO> getProductList();
	
	public List<ProductVO> getNewProductList();
	
	public List<ProductVO> getBestProductList();

	public List<ProductVO> getProductListByKind(String kind);
	
	public int countProductList(String name);
	
	public List<ProductVO> listProduct(String name);
	
	public void insertProduct(ProductVO vo);
	
	public void updateProduct(ProductVO vo);
	
	public List<ProductVO> listWithPaging(Criteria criteria, String key);
	
	public List<SalesQuantity> getProductSales();
}
