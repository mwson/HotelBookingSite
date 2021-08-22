package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// "사용자, 공지사항" 조회 및 페이징
	@RequestMapping(value = "/notice_list")
	public String adminNoticeList(Criteria criteria, @RequestParam(value = "key", defaultValue = "")String key, Model model) {
		List<NoticeVO> noticeList = noticeService.listNoticewithPaging(criteria, key);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalCount = noticeService.countNoticeList(key);
		pageMaker.setTotalCount(totalCount);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageMaker", pageMaker);

		return "serviceCenter/noticeList";
		
	}
	
	// "사용자, 공지사항" 상세 조회 및 하단 조회
	@RequestMapping(value = "/notice_detail")
	public String noticeDetail(NoticeVO vo, Model model) {
		NoticeVO noticeVO = noticeService.getNotice(vo.getNseq());
		model.addAttribute("noticeVO", noticeVO);
		
		List<NoticeVO> noticeList = noticeService.getNoticeBottomList();
		noticeList.remove(0);
		
		model.addAttribute("noticeList", noticeList);
		
		return "serviceCenter/noticeDetail";
	}
	
}
