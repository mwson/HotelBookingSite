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
	
	// "�����, ����" üũ��, üũ�ƿ����� �ߺ� ��ȸ
	@Override
	public int countBookingCheck(BookingVO vo) {
		return bookingDao.countBookingCheck(vo);
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
	
	// "�����, ���� �� ������, ������" �� ��ȸ
	@Override
	public BookingVO getBookingDetail(int bseq) {
		return bookingDao.getBookingDetail(bseq);
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
	
	// "������, ������" ��� �� ��ȸ
	@Override
	public int adminCountBookingList(String name) {
		return bookingDao.adminCountBookingList(name);
	}
	
	// "������, ������" ��ȸ �� ����¡
	@Override
	public List<BookingVO> adminBookingListWithPaging(Criteria criteria, String name) {
		return bookingDao.adminBookingListWithPaging(criteria, name);
	}
	
	// "������, ������" ���� ����
	@Override
	public void updateBookingResult(int bseq) {
		bookingDao.updateBookingResult(bseq);
	}
	// "������, ������" ���� ���
	@Override
	public void updateBookingCancel(int bseq) {
		bookingDao.updateBookingCancel(bseq);
	}
	
	// "������, �������" ��ȸ
	@Override
	public List<SalesBooking> getBookingSales() {
		return bookingDao.getBookingSales();
	}
	
}
