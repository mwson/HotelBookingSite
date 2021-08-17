package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.ProductVO;
import com.green.biz.product.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;
	
	/*
	 * "메인" 이동
	 */
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {
		// 신상품 조회 서비스 호출
		List<ProductVO> newProductList = productService.getNewProductList();
		model.addAttribute("newProductList", newProductList);

		// 베스트상품 조회 서비스 호출		
		List<ProductVO> bestProductList = productService.getBestProductList();
		model.addAttribute("bestProductList", bestProductList);
		
		return "index";
	}
	
	/*
	 * "호텔 개요" 이동
	 */
	@RequestMapping(value = "/introduce_hotel")
	public String introduceHotel() {
		return "introduce/hotel";
	}
	
	/*
	 * "호텔 객실" 이동
	 */
	@RequestMapping(value = "/introduce_room")
	public String introduceRoom() {
		return "introduce/room";
	}
	
	/*
	 * "스위트 룸 상세" 이동
	 */
	@RequestMapping(value = "/suiteRoom_detail")
	public String suiteRoom() {
		return "introduce/suiteRoom";
	}
	
	/*
	 * "슈페리어 룸 상세" 이동
	 */
	@RequestMapping(value = "/superior_room")
	public String superiorRoom() {
		return "introduce/superiorRoom";
	}
	
	/*
	 * "디럭스 룸 상세" 이동
	 */
	@RequestMapping(value = "/deluxe_room")
	public String deluxeRoom() {
		return "introduce/deluxeRoom";
	}
	
	/*
	 * "스탠다드 룸 상세" 이동
	 */
	@RequestMapping(value = "/standard_room")
	public String standardRoom() {
		return "introduce/standardRoom";
	}
	
}