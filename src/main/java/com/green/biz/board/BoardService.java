package com.green.biz.board;

import java.util.List;

import com.green.biz.dto.BoardVO;

public interface BoardService {
		
	public List<BoardVO> listBoard();
	
	public BoardVO getBoard(int bseq);
	
	public void insertBoard(BoardVO vo);
	
	public void updateBoard(BoardVO vo);
	
	public void deleteBoard(int bseq);
}
