package com.green.biz.comment;

import java.util.List;

import com.green.biz.dto.NoticeCommentVO;
import com.green.biz.utils.Criteria;

public interface CommentService {
	
	// "�����, �������� ���" ��ȸ
	public List<NoticeCommentVO> getCommentList(int nseq);
	
	// "�����, �������� ���" �� ���� ��ȸ
	public int countCommentList(int nseq);
	
	// "�����, �������� ���" ��ȸ �� ����¡
	public List<NoticeCommentVO> getCommentListWithPaging(Criteria criteria, int nseq);
	
	// "�����, �������� ���" ���
	public int saveComment(NoticeCommentVO vo);
	
	// "�����, �������� ���" ����
	public int updateComment(NoticeCommentVO vo);
	
	// "�����, �������� ���" ����
	public int deleteComment(int ncseq);
	
}
