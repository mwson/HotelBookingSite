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
	
	// "�����, ����" ȭ��
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index(Model model) {
		List<NoticeVO> noticeList = noticeService.getNoticeBottomList();
		int count = 1;
		
		for(NoticeVO vo : noticeList) {
			model.addAttribute(("noticeVO" + count), vo);
			count++;
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
	public String introduceRoom() {
		return "introduce/room";
	}
	
	// "�����, ���Ǿȳ�" ���� ����Ʈ �� �� �̵�
	@RequestMapping(value = "/suiteRoom_detail")
	public String suiteRoom() {
		return "introduce/suiteRoom";
	}
	
	// "�����, ���Ǿȳ�" ���� ���丮�� �� �� �̵�
	@RequestMapping(value = "/superior_room")
	public String superiorRoom() {
		return "introduce/superiorRoom";
	}
	
	// "�����, ���Ǿȳ�" ���� �𷰽� �� �� �̵�
	@RequestMapping(value = "/deluxe_room")
	public String deluxeRoom() {
		return "introduce/deluxeRoom";
	}
	
	// "�����, ���Ǿȳ�" ���� ���Ĵٵ� �� �� �̵�
	@RequestMapping(value = "/standard_room")
	public String standardRoom() {
		return "introduce/standardRoom";
	}
	
	// "�����, �����ϴ� ����" �̵�
	@RequestMapping(value = "/faq_list")
	public String faqList() {
		return "serviceCenter/faqList";
	}
	
}