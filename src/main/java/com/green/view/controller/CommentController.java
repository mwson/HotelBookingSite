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
	
	// "사용자, 공지사항 댓글" 조회 및 페이징
	@GetMapping(value = "/list", produces="application/json; charset=UTF-8")
	public Map<String, Object> commentList(@RequestParam(value="nseq") int nseq, Criteria criteria) {
		Map<String, Object> commentInfo = new HashMap<>();		
	    
		// List<NoticeCommentVO> commentList = commentService.getCommentList(nseq);
	    List<NoticeCommentVO> commentList = commentService.getCommentListWithPaging(criteria, nseq);
	    
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalComment = commentService.countCommentList(nseq);
		pageMaker.setTotalCount(totalComment);
		
		commentInfo.put("pageInfo", pageMaker);		
		commentInfo.put("commentList", commentList);
		commentInfo.put("total", totalComment);
		
		return commentInfo;
	}
	
	// "사용자, 공지사항 댓글" 등록
	@PostMapping(value = "/save")
	public String saveComment(HttpSession session, NoticeCommentVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "not_logedin";
		} else {
			String writer = loginUser.getName() + "(" + loginUser.getId() + ")";
			vo.setWriter(writer);
			
			if(commentService.saveComment(vo) == 1) {
				return "success";
			} else {
				return "fail";
			}
		}
	}
	
	// "사용자, 공지사항 댓글" 수정
	@PostMapping(value = "/update")
	public String updateComment(HttpSession session, NoticeCommentVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "not_logedin";
		} else {
			if(commentService.updateComment(vo) == 1) {
				return "success";
			} else {
				return "fail";
			}
		}
	}
	
	// "사용자, 공지사항 댓글" 삭제
	@PostMapping(value = "/delete")
	public String deleteComment(HttpSession session, NoticeCommentVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "not_logedin";
		} else {
			if(commentService.deleteComment(vo.getNcseq()) == 1) {
				return "success";
			} else {
				return "fail";
			}
		}
	}

}
