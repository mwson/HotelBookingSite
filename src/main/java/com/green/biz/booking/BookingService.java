package com.green.biz.booking;

import java.util.List;

import com.green.biz.dto.BookingVO;
import com.green.biz.utils.Criteria;

public interface BookingService {
	
	// "사용자, 예약" 체크인, 체크아웃으로 중복 조회
	public int countBookingCheck(BookingVO vo);
	
	// "사용자, 예약" 예약완료	
	public void insertBooking(BookingVO vo);
	
	// "사용자, 예약" 예약 조회
	public BookingVO getBooking(int bseq);
	
	//  "사용자, 예약" 목록 조회
	public List<BookingVO> getBookingList(String id);
	
	// "사용자, 예약" 목록 수 조회
	public int userCountBookingList(String id);
	
	// "사용자, 예약" 목록 조회 및 페이징	
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id);
	
	// "사용자, 예약" 상세 조회
	public BookingVO getBookingDetail(BookingVO vo);
	
}
