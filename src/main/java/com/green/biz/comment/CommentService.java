package com.green.biz.comment;

import java.util.List;

import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.dto.ProductCommentVO;
import com.green.biz.utils.Criteria;

public interface CommentService {
	
	public List<ProductCommentVO> getCommentList(int pseq);
	
	public int saveComment(NoticeCommentVO vo);
	
	public int updateComment(ProductCommentVO vo);
	
	public int deleteComment(int comment_seq);
	
	public int countCommentList(int nseq);
	
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq);
	
}
