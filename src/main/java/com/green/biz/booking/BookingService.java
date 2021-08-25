package com.green.biz.booking;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;

public interface BookingService {
	
	// "�����, ����" üũ��, üũ�ƿ����� �ߺ� ��ȸ
	public int countBookingCheck(BookingVO vo);
	
	// "�����, ����" ���� ��ȸ
	public RoomVO getRoom(String rid);
	
	// "�����, ����" ���� �Ϸ�	
	public int insertBooking(BookingVO vo);
	
	// "�����, ����" ���� ��ȸ
	public BookingVO getBooking(int bseq);
}
