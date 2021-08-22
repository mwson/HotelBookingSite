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
	
	public List<ProductVO> listProduct(String name);
	
	public int countProductList(String name);
	
	public List<ProductVO> listProductWithPaging(Criteria criteria, String key);
	
	public void insertProduct(ProductVO vo);
	
	public void updateProduct(ProductVO vo);
	
	public void deleteProduct(int pseq);
	
	public List<SalesQuantity> getProductSales();
}
