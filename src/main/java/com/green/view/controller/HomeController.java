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
	
	// "�����, ����" ȭ��
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {
		// "�����, ����" ���Ǹ�� ��ȸ
		RoomVO[] roomRid = new RoomVO[4];
		
		for(int i=0; i<roomRid.length; i++) {
			roomRid[i] = roomService.getRoom(i + 1);

			model.addAttribute(("roomRid" + (i + 1)), roomRid[i]);
		}
		
		// "�����, ����" �ϴ� ���θ�� ��ȸ
		List<NoticeVO> promotionList = noticeService.getPromotionIndexBottomList();
		int pCount = 1;
		
		for(NoticeVO pList : promotionList) {
			model.addAttribute(("pList" + pCount), pList);
			pCount++;
		}
		
		// "�����, ����" �ϴ� �������� ��ȸ
		List<NoticeVO> noticeList = noticeService.getNoticeIndexBottomList();
		int nCount = 1;
		
		for(NoticeVO nList : noticeList) {
			model.addAttribute(("nList" + nCount), nList);
			nCount++;
		}
		
		return "index";
	}

	// "�����, ȣ�ڼҰ�" ����  ȣ�ڰ��� �̵�
	@RequestMapping(value = "/introduce_hotel")
	public String introduceHotel() {
		return "introduce/hotel";
	}
	
	// "�����, ȣ�ڼҰ�" ����  ���Ǿȳ� �̵�
	@RequestMapping(value = "/introduce_room")
	public String introduceRoom(Model model) {
		// "�����, ȣ�ڼҰ�" ���Ǹ�� ��ȸ
		RoomVO[] roomRid = new RoomVO[4];
		
		for(int i=0; i<roomRid.length; i++) {
			roomRid[i] = roomService.getRoom(i + 1);

			model.addAttribute(("roomRid" + (i + 1)), roomRid[i]);
		}
		
		return "introduce/room";
	}
	
	// "�����, ���Ǿȳ�" ���� ����Ʈ �� �� �̵�
	@RequestMapping(value = "/suite_room_detail")
	public String suiteRoom(Model model) {
		RoomVO roomRid1 = roomService.getRoom(1);

		model.addAttribute("roomRid1", roomRid1);
		
		return "introduce/suiteRoom";
	}
	
	// "�����, ���Ǿȳ�" ���� ���丮�� �� �� �̵�
	@RequestMapping(value = "/superior_room_detail")
	public String superiorRoom(Model model) {
		RoomVO roomRid2 = roomService.getRoom(2);

		model.addAttribute("roomRid2", roomRid2);
		
		return "introduce/superiorRoom";
	}
	
	// "�����, ���Ǿȳ�" ���� �𷰽� �� �� �̵�
	@RequestMapping(value = "/deluxe_room_detail")
	public String deluxeRoom(Model model) {
		RoomVO roomRid3 = roomService.getRoom(3);

		model.addAttribute("roomRid3", roomRid3);
		
		return "introduce/deluxeRoom";
	}
	
	// "�����, ���Ǿȳ�" ���� ���Ĵٵ� �� �� �̵�
	@RequestMapping(value = "/standard_room_detail")
	public String standardRoom(Model model) {
		RoomVO roomRid4 = roomService.getRoom(4);

		model.addAttribute("roomRid4", roomRid4);
		
		return "introduce/standardRoom";
	}
	
	// "�����, �����ϴ� ����" �̵�
	@RequestMapping(value = "/faq_list")
	public String faqList() {
		return "serviceCenter/faqList";
	}
	
}