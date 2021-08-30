package com.green.biz.booking.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.booking.BookingService;
import com.green.biz.dao.BookingDAO;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.SalesBooking;
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
	
	// "사용자, 예약 및 관리자, 예약목록" 상세 조회
	@Override
	public BookingVO getBookingDetail(int bseq) {
		return bookingDao.getBookingDetail(bseq);
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
	
	// "관리자, 예약목록" 목록 수 조회
	@Override
	public int adminCountBookingList(String name) {
		return bookingDao.adminCountBookingList(name);
	}
	
	// "관리자, 예약목록" 조회 및 페이징
	@Override
	public List<BookingVO> adminBookingListWithPaging(Criteria criteria, String name) {
		return bookingDao.adminBookingListWithPaging(criteria, name);
	}
	
	// "관리자, 예약목록" 예약 승인
	@Override
	public void updateBookingResult(int bseq) {
		bookingDao.updateBookingResult(bseq);
	}
	// "관리자, 예약목록" 예약 취소
	@Override
	public void updateBookingCancel(int bseq) {
		bookingDao.updateBookingCancel(bseq);
	}
	
	// "관리자, 예약실적" 조회
	@Override
	public List<SalesBooking> getBookingSales() {
		return bookingDao.getBookingSales();
	}
	
}
