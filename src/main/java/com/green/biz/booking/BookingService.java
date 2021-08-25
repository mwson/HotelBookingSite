package com.green.biz.booking;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;

public interface BookingService {
	
	// "사용자, 예약" 체크인, 체크아웃으로 중복 조회
	public int countBookingCheck(BookingVO vo);
	
	// "사용자, 예약" 객실 조회
	public RoomVO getRoom(String rid);
	
	// "사용자, 예약" 예약 완료	
	public int insertBooking(BookingVO vo);
	
	// "사용자, 예약" 예약 조회
	public BookingVO getBooking(int bseq);
}
