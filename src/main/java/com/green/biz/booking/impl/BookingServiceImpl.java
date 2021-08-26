package com.green.biz.booking.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.booking.BookingService;
import com.green.biz.dao.BookingDAO;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.utils.Criteria;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDAO bookingDao;
	
	// "사용자, 예약" 체크인, 체크아웃으로 중복 조회
	@Override
	public int countBookingCheck(BookingVO vo) {
		return bookingDao.countBookingCheck(vo);
	}
	
	// "사용자, 예약" 객실 조회
	@Override
	public RoomVO getRoom(String rid) {
		return bookingDao.getRoom(rid);
	}
	
	// "사용자, 예약" 예약완료
	@Override
	public void insertBooking(BookingVO vo) {
		bookingDao.insertBooking(vo);
	}
	
	// "사용자, 예약" 예약 조회
	@Override
	public BookingVO getBooking(int bseq) {
		return bookingDao.getBooking(bseq);
	}
	
	//  "사용자, 예약" 목록 조회
	@Override
	public List<BookingVO> getBookingList(String id) {
		return bookingDao.getBookingList(id);
	}
	
	// "사용자, 예약" 목록 수 조회
	@Override
	public int userCountBookingList(String id) {
		return bookingDao.userCountBookingList(id);
	}
	
	// "사용자, 예약" 목록 조회 및 페이징	
	@Override
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id) {
		return bookingDao.userBookingListWithPaging(criteria, id);
	}
	
	// "사용자, 예약" 상세 조회
	@Override
	public BookingVO getBookingDetail(BookingVO vo) {
		return bookingDao.getBookingDetail(vo);
	}

}
