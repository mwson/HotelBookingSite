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
import com.green.biz.dto.ProductCommentVO;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@RequestMapping(value = "/comments/")
@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@GetMapping(value = "/list", produces="application/json; charset=UTF-8")
	public Map<String, Object> commentList(Criteria criteria, @RequestParam(value = "pseq")int pseq) {
		Map<String, Object> commentInfo = new HashMap<>();
		
	  //List<ProductCommentVO> commentList = commentService.getCommentList(pseq);
		List<ProductCommentVO> commentList = commentService.getCommentListWithPaging(criteria, pseq);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(criteria);
		
		int totalComment = commentService.countCommentList(pseq);
		pageMaker.setTotalCount(totalComment);
		
		commentInfo.put("pageInfo", pageMaker);
		commentInfo.put("commentList", commentList);
		commentInfo.put("total", totalComment);
		
		return commentInfo;
	}
	
	@PostMapping(value = "/save")
	public String saveComment(HttpSession session, ProductCommentVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "not_logedin";
		} else {
			// 작성자는 화면에서 입력되지 않으므로 로그인정보에서 추출함
			vo.setWriter(loginUser.getId());
			
			if(commentService.saveComment(vo) == 1) {
				return "success";
			} else {
				return "fail";
			}
		}
	}

}
