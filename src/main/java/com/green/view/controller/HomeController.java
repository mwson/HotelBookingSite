package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.NoticeVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.room.RoomService;

@Controller
public class HomeController {
	
	@Autowired
	private RoomService roomService;
	@Autowired
	private NoticeService noticeService;
	
	// "사용자, 메인" 화면
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {
		// "사용자, 메인" 객실목록 조회
		RoomVO[] roomRid = new RoomVO[4];
		
		for(int i=0; i<roomRid.length; i++) {
			roomRid[i] = roomService.getRoom(i + 1);

			model.addAttribute(("roomRid" + (i + 1)), roomRid[i]);
		}
		
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
	public String introduceRoom(Model model) {
		// "사용자, 호텔소개" 객실목록 조회
		RoomVO[] roomRid = new RoomVO[4];
		
		for(int i=0; i<roomRid.length; i++) {
			roomRid[i] = roomService.getRoom(i + 1);

			model.addAttribute(("roomRid" + (i + 1)), roomRid[i]);
		}
		
		return "introduce/room";
	}
	
	// "사용자, 객실안내" 에서 스위트 룸 상세 이동
	@RequestMapping(value = "/suite_room_detail")
	public String suiteRoom(Model model) {
		RoomVO roomRid1 = roomService.getRoom(1);

		model.addAttribute("roomRid1", roomRid1);
		
		return "introduce/suiteRoom";
	}
	
	// "사용자, 객실안내" 에서 슈페리어 룸 상세 이동
	@RequestMapping(value = "/superior_room_detail")
	public String superiorRoom(Model model) {
		RoomVO roomRid2 = roomService.getRoom(2);

		model.addAttribute("roomRid2", roomRid2);
		
		return "introduce/superiorRoom";
	}
	
	// "사용자, 객실안내" 에서 디럭스 룸 상세 이동
	@RequestMapping(value = "/deluxe_room_detail")
	public String deluxeRoom(Model model) {
		RoomVO roomRid3 = roomService.getRoom(3);

		model.addAttribute("roomRid3", roomRid3);
		
		return "introduce/deluxeRoom";
	}
	
	// "사용자, 객실안내" 에서 스탠다드 룸 상세 이동
	@RequestMapping(value = "/standard_room_detail")
	public String standardRoom(Model model) {
		RoomVO roomRid4 = roomService.getRoom(4);

		model.addAttribute("roomRid4", roomRid4);
		
		return "introduce/standardRoom";
	}
	
	// "사용자, 자주하는 질문" 이동
	@RequestMapping(value = "/faq_list")
	public String faqList() {
		return "serviceCenter/faqList";
	}
	
}