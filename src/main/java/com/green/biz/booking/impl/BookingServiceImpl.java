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
	
	// "�����, ����" üũ��, üũ�ƿ����� �ߺ� ��ȸ
	@Override
	public int countBookingCheck(BookingVO vo) {
		return bookingDao.countBookingCheck(vo);
	}
	
	// "�����, ����" ���� ��ȸ
	@Override
	public RoomVO getRoom(String rid) {
		return bookingDao.getRoom(rid);
	}
	
	// "�����, ����" ����Ϸ�
	@Override
	public void insertBooking(BookingVO vo) {
		bookingDao.insertBooking(vo);
	}
	
	// "�����, ����" ���� ��ȸ
	@Override
	public BookingVO getBooking(int bseq) {
		return bookingDao.getBooking(bseq);
	}
	
	//  "�����, ����" ��� ��ȸ
	@Override
	public List<BookingVO> getBookingList(String id) {
		return bookingDao.getBookingList(id);
	}
	
	// "�����, ����" ��� �� ��ȸ
	@Override
	public int userCountBookingList(String id) {
		return bookingDao.userCountBookingList(id);
	}
	
	// "�����, ����" ��� ��ȸ �� ����¡	
	@Override
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id) {
		return bookingDao.userBookingListWithPaging(criteria, id);
	}
	
	// "�����, ����" �� ��ȸ
	@Override
	public BookingVO getBookingDetail(BookingVO vo) {
		return bookingDao.getBookingDetail(vo);
	}

}
