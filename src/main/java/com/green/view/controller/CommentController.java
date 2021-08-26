package com.green.view.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.biz.comment.CommentService;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@RequestMapping(value = "/comments/")
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping(value = "/list", produces="application/json; charset=UTF-8")
	public Map<String, Object> commentList(@RequestParam(value="nseq") int nseq, Criteria criteria) {
		Map<String, Object> commentInfo = new HashMap<>();		
	    
	    List<NoticeCommentVO> commentList = commentService.getCommentListWithPaging(criteria, nseq);
	    
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalComment = commentService.countCommentList(nseq);
		pageMaker.setTotalCount(totalComment);
		
		System.out.println(pageMaker.toString());
		
		commentInfo.put("pageInfo", pageMaker);		
		commentInfo.put("commentList", commentList);
		commentInfo.put("total", totalComment);
		
		return commentInfo;
	}
	
	@PostMapping(value = "/save")
	public String saveComment(HttpSession session, NoticeCommentVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "not_logedin";
		} else {
			// �ۼ��ڴ� ȭ�鿡�� �Էµ��� �����Ƿ� �α����������� ������
			vo.setWriter(loginUser.getId());
			
			if(commentService.saveComment(vo) == 1) {
				return "success";
			} else {
				return "fail";
			}
		}
	}

}
