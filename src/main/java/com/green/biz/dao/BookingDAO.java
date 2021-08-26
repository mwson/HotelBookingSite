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
	
	// "사용자, 예약" 체크인, 체크아웃으로 객실 중복 조회
	public int countBookingCheck(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.countBookingCheck", vo);
	}
	
	// "사용자, 예약" 객실 조회
	public RoomVO getRoom(String rid) {
		return mybatis.selectOne("BookingDAO.getRoom", rid);
	}
	
	// "사용자, 예약" 예약완료
	public void insertBooking(BookingVO vo) {
		mybatis.insert("BookingDAO.insertBooking", vo);
	}
	
	// "사용자, 예약" 예약 조회
	public BookingVO getBooking(int bseq) {
		return mybatis.selectOne("BookingDAO.getBooking", bseq);
	}
	
	//  "사용자, 예약" 목록 조회
	public List<BookingVO> getBookingList(String id) {
		return mybatis.selectList("BookingDAO.getBookingList", id);
	}
	
	// "사용자, 예약" 목록 수 조회
	public int userCountBookingList(String id) {
		return mybatis.selectOne("BookingDAO.userCountBookingList", id);
	}
	
	//  "사용자, 예약" 목록 조회 및 페이징	
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("id", id);
		
		return mybatis.selectList("BookingDAO.userBookingListWithPaging", map);
	}
	
	//  "사용자, 예약" 상세 조회
	public BookingVO getBookingDetail(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.getBookingDetail", vo);
	}
	
}