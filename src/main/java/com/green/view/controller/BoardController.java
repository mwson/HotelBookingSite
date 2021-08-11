package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.biz.board.BoardService;
import com.green.biz.dto.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/board_list")
	public String boardList(Model model) {
		
		List<BoardVO> boardList = boardService.listBoard();
		
		model.addAttribute("boardList", boardList);
		
		return "board/boardList";
	}
	
	@RequestMapping(value = "/board_view")
	public String boardView(BoardVO vo, Model model) {
		BoardVO boardVO = boardService.getBoard(vo.getBseq());
		
		model.addAttribute("boardVO", boardVO);
		
		return "board/boardView";
	}
	
}
