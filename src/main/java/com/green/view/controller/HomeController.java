package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;

@Controller
public class HomeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// "사용자, 메인" 화면
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {
		// "사용자, 메인" 하단 프로모션 조회
		List<NoticeVO> promotionList = noticeService.getPromotionIndexBottomList();
		int pCount = 1;
		
		for(NoticeVO pList : promotionList) {
			model.addAttribute(("pList" + pCount), pList);
			pCount++;
		}
		
		// "사용자, 메인" 하단 공지사항 조회
		List<NoticeVO> noticeList = noticeService.getNoticeIndexBottomList();
		int nCount = 1;
		
		for(NoticeVO nList : noticeList) {
			model.addAttribute(("nList" + nCount), nList);
			nCount++;
		}
		
		return "index";
	}

	// "사용자, 호텔소개" 에서  호텔개요 이동
	@RequestMapping(value = "/introduce_hotel")
	public String introduceHotel() {
		return "introduce/hotel";
	}
	
	// "사용자, 호텔소개" 에서  객실안내 이동
	@RequestMapping(value = "/introduce_room")
	public String introduceRoom() {
		return "introduce/room";
	}
	
	// "사용자, 객실안내" 에서 스위트 룸 상세 이동
	@RequestMapping(value = "/suiteRoom_detail")
	public String suiteRoom() {
		return "introduce/suiteRoom";
	}
	
	// "사용자, 객실안내" 에서 슈페리어 룸 상세 이동
	@RequestMapping(value = "/superior_room")
	public String superiorRoom() {
		return "introduce/superiorRoom";
	}
	
	// "사용자, 객실안내" 에서 디럭스 룸 상세 이동
	@RequestMapping(value = "/deluxe_room")
	public String deluxeRoom() {
		return "introduce/deluxeRoom";
	}
	
	// "사용자, 객실안내" 에서 스탠다드 룸 상세 이동
	@RequestMapping(value = "/standard_room")
	public String standardRoom() {
		return "introduce/standardRoom";
	}
	
	// "사용자, 자주하는 질문" 이동
	@RequestMapping(value = "/faq_list")
	public String faqList() {
		return "serviceCenter/faqList";
	}
	
}