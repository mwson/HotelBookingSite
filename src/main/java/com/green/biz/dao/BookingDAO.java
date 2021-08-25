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
	
	// "�����, ����" üũ��, üũ�ƿ����� ���� �ߺ� ��ȸ
	public int countBookingCheck(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.countBookingCheck", vo);
	}
	
	// "�����, ����" ���� ��ȸ
	public RoomVO getRoom(String rid) {
		return mybatis.selectOne("BookingDAO.getRoom", rid);
	}
	
	// "�����, ����" ���� �Ϸ�
	public int insertBooking(BookingVO vo) {
		return mybatis.insert("BookingDAO.insertBooking", vo);
	}
	
	// "�����, ����" ���� ��ȸ
	public BookingVO getBooking(int bseq) {
		return mybatis.selectOne("BookingDAO.getBooking", bseq);
	}
}