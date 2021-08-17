package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	/*
	 * "공지사항" 출력
	 */
	@RequestMapping(value = "/notice_list")
	public String noticeList(Model model) {
		List<NoticeVO> noticeList = noticeService.listNotice();
		
		model.addAttribute("noticeList", noticeList);
	
		return "serviceCenter/notice";
	}
	
	/*
	 * "공지사항 상세" 출력
	 */
	@RequestMapping(value = "/notice_detail")
	public String noticeDetail(NoticeVO vo, Model model) {
		NoticeVO noticeVO = noticeService.getNotice(vo.getNseq());
		model.addAttribute("noticeVO", noticeVO);
		
		List<NoticeVO> noticeList = noticeService.listNoticeView();
		noticeList.remove(0);
		
		model.addAttribute("noticeList", noticeList);
		
		return "serviceCenter/noticeDetail";
	}
	
}
