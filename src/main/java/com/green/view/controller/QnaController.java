package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.MemberVO;
import com.green.biz.dto.QnaVO;
import com.green.biz.qna.QnaService;

@Controller
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	// "사용자, Q&A" 목록 조회
	@RequestMapping(value = "/qna_list", method = RequestMethod.GET)
	public String qnaList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<QnaVO> qnaList = qnaService.listQna(loginUser.getId());
			
			model.addAttribute("qnaList", qnaList);
			
			return "qna/qnaList";
		}
	}
	
	// "사용자, Q&A" 상세 조회
	@RequestMapping(value = "/qna_detail", method = RequestMethod.GET)
	public String qnaView(HttpSession session, QnaVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// 개별 게시글 저장
			QnaVO qnaVO = qnaService.getQna(vo.getQseq());
			
			model.addAttribute("qnaVO", qnaVO);
			
			return "qna/qnaDetail";
		}
	}
	
	// "사용자, Q&A" 등록 폼 이동
	@RequestMapping(value = "/qna_write_form", method = RequestMethod.GET)
	public String qnaWriteView(HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			return "qna/qnaWrite";
		}		
	}
	
	// "사용자, Q&A" 등록
	@RequestMapping(value = "/qna_write", method = RequestMethod.POST)
	public String qnaWriteAction(HttpSession session, QnaVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			vo.setName(loginUser.getName());
		
			qnaService.insertQna(vo);
			
			// "사용자, Q&A" 등록 후 목록 이동
			return "redirect:qna_list";
		}
	}

}