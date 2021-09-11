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
	
	// "����� �� ������ ��������" ��ȸ �� ����¡
	@RequestMapping(value = "/notice_list")
	public String noticeListWithPaging(Criteria criteria, @RequestParam(value = "key", defaultValue = "")String key, Model model) {
		List<NoticeVO> noticeList = noticeService.noticeListWithPaging(criteria, key);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalCount = noticeService.countNoticeList(key);
		pageMaker.setTotalCount(totalCount);
		
		model.addAttribute("noticeListSize", noticeList.size());
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("key", key);

		return "serviceCenter/noticeList";
	}
	
	// "�����, ��������" �� ��ȸ �� �ϴ� ��ȸ
	@RequestMapping(value = "/notice_detail")
	public String noticeDetail(NoticeVO vo, Model model) {
		NoticeVO noticeVO = noticeService.getNotice(vo.getNseq());
		model.addAttribute("noticeVO", noticeVO);
		
		List<NoticeVO> noticeList = noticeService.getNoticeBottomList();
		
		model.addAttribute("noticeList", noticeList);
		
		return "serviceCenter/noticeDetail";
	}
	
}
