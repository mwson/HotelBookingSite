package com.green.biz.booking.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.booking.BookingService;
import com.green.biz.dao.BookingDAO;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDAO bookingDao;
	
	@Override
	public int countBookingCheck(BookingVO vo) {
		return bookingDao.countBookingCheck(vo);
	}

	@Override
	public RoomVO getRoom(String rid) {
		return bookingDao.getRoom(rid);
	}

	@Override
	public int insertBooking(BookingVO vo) {
		return bookingDao.insertBooking(vo);
	}

	@Override
	public BookingVO getBooking(int bseq) {
		return bookingDao.getBooking(bseq);
	}

}
