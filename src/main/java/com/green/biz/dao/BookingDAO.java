package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;

@Repository("bookingDAO")
public class BookingDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "사용자, 예약" 체크인, 체크아웃으로 객실 중복 조회
	public int countBookingCheck(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.countBookingCheck", vo);
	}
	
	// "사용자, 예약" 객실 조회
	public RoomVO getRoom(String rid) {
		return mybatis.selectOne("BookingDAO.getRoom", rid);
	}
	
	// "사용자, 예약" 예약 완료
	public int insertBooking(BookingVO vo) {
		return mybatis.insert("BookingDAO.insertBooking", vo);
	}
	
	// "사용자, 예약" 예약 조회
	public BookingVO getBooking(int bseq) {
		return mybatis.selectOne("BookingDAO.getBooking", bseq);
	}
}