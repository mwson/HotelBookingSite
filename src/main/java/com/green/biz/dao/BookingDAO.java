package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.utils.Criteria;

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
	
	// "�����, ����" ����Ϸ�
	public void insertBooking(BookingVO vo) {
		mybatis.insert("BookingDAO.insertBooking", vo);
	}
	
	// "�����, ����" ���� ��ȸ
	public BookingVO getBooking(int bseq) {
		return mybatis.selectOne("BookingDAO.getBooking", bseq);
	}
	
	//  "�����, ����" ��� ��ȸ
	public List<BookingVO> getBookingList(String id) {
		return mybatis.selectList("BookingDAO.getBookingList", id);
	}
	
	// "�����, ����" ��� �� ��ȸ
	public int userCountBookingList(String id) {
		return mybatis.selectOne("BookingDAO.userCountBookingList", id);
	}
	
	//  "�����, ����" ��� ��ȸ �� ����¡	
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("id", id);
		
		return mybatis.selectList("BookingDAO.userBookingListWithPaging", map);
	}
	
	//  "�����, ����" �� ��ȸ
	public BookingVO getBookingDetail(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.getBookingDetail", vo);
	}
	
}