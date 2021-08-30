package com.green.biz.booking;

import java.util.List;

import com.green.biz.dto.BookingVO;
import com.green.biz.utils.Criteria;

public interface BookingService {
	
	// "�����, ����" üũ��, üũ�ƿ����� �ߺ� ��ȸ
	public int countBookingCheck(BookingVO vo);
	
	// "�����, ����" ����Ϸ�	
	public void insertBooking(BookingVO vo);
	
	// "�����, ����" ���� ��ȸ
	public BookingVO getBooking(int bseq);
	
	//  "�����, ����" ��� ��ȸ
	public List<BookingVO> getBookingList(String id);
	
	// "�����, ����" ��� �� ��ȸ
	public int userCountBookingList(String id);
	
	// "�����, ����" ��� ��ȸ �� ����¡	
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id);
	
	// "�����, ����" �� ��ȸ
	public BookingVO getBookingDetail(BookingVO vo);
	
}
