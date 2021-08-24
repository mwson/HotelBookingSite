package com.green.biz.booking;

import com.green.biz.dto.BookingVO;

public interface BookingService {
	
	// "사용자, 예약" 체크인, 체크아웃으로 중복 조회
	public int countBookingCheck(BookingVO vo);
	
}
