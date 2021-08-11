package com.green.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.board.BoardService;
import com.green.biz.dao.BoardDAO;
import com.green.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> listBoard() {
		return boardDAO.listBoard();
	}

	@Override
	public BoardVO getBoard(int bseq) {
		return boardDAO.getBoard(bseq);
	}

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(int bseq) {
		boardDAO.deleteBoard(bseq);
	}

}
