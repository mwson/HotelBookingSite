package com.green.biz.booking.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.booking.BookingService;
import com.green.biz.dao.BookingDAO;
import com.green.biz.dto.BookingVO;

@Service("bookingService")
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDAO bookingDao;
	
	@Override
	public int countBookingCheck(BookingVO vo) {
		return bookingDao.countBookingCheck(vo);
	}

}
