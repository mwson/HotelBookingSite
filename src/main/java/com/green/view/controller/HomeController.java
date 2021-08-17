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
	 * "����" �̵�
	 */
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {
		// �Ż�ǰ ��ȸ ���� ȣ��
		List<ProductVO> newProductList = productService.getNewProductList();
		model.addAttribute("newProductList", newProductList);

		// ����Ʈ��ǰ ��ȸ ���� ȣ��		
		List<ProductVO> bestProductList = productService.getBestProductList();
		model.addAttribute("bestProductList", bestProductList);
		
		return "index";
	}
	
	/*
	 * "ȣ�� ����" �̵�
	 */
	@RequestMapping(value = "/introduce_hotel")
	public String introduceHotel() {
		return "introduce/hotel";
	}
	
	/*
	 * "ȣ�� ����" �̵�
	 */
	@RequestMapping(value = "/introduce_room")
	public String introduceRoom() {
		return "introduce/room";
	}
	
	/*
	 * "����Ʈ �� ��" �̵�
	 */
	@RequestMapping(value = "/suiteRoom_detail")
	public String suiteRoom() {
		return "introduce/suiteRoom";
	}
	
	/*
	 * "���丮�� �� ��" �̵�
	 */
	@RequestMapping(value = "/superior_room")
	public String superiorRoom() {
		return "introduce/superiorRoom";
	}
	
	/*
	 * "�𷰽� �� ��" �̵�
	 */
	@RequestMapping(value = "/deluxe_room")
	public String deluxeRoom() {
		return "introduce/deluxeRoom";
	}
	
	/*
	 * "���Ĵٵ� �� ��" �̵�
	 */
	@RequestMapping(value = "/standard_room")
	public String standardRoom() {
		return "introduce/standardRoom";
	}
	
}