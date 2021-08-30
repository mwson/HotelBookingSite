package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.SalesBooking;
import com.green.biz.utils.Criteria;

@Repository("bookingDAO")
public class BookingDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "사용자, 예약" 체크인, 체크아웃으로 객실 중복 조회
	public int countBookingCheck(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.countBookingCheck", vo);
	}
	
	// "사용자, 예약" 예약완료
	public void insertBooking(BookingVO vo) {
		mybatis.insert("BookingDAO.insertBooking", vo);
	}
	
	// "사용자, 예약" 예약 조회
	public BookingVO getBooking(int bseq) {
		return mybatis.selectOne("BookingDAO.getBooking", bseq);
	}
	
	// "사용자, 예약 및 관리자, 예약목록" 상세 조회
	public BookingVO getBookingDetail(int bseq) {
		return mybatis.selectOne("BookingDAO.getBookingDetail", bseq);
	}
	
	//  "사용자, 예약" 목록 조회
	public List<BookingVO> getBookingList(String id) {
		return mybatis.selectList("BookingDAO.getBookingList", id);
	}
	
	// "사용자, 예약" 목록 수 조회
	public int userCountBookingList(String id) {
		return mybatis.selectOne("BookingDAO.userCountBookingList", id);
	}
	
	// "사용자, 예약" 목록 조회 및 페이징	
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("id", id);
		
		return mybatis.selectList("BookingDAO.userBookingListWithPaging", map);
	}
	
	// "관리자, 예약목록" 목록 수 조회
	public int adminCountBookingList(String name) {
		return mybatis.selectOne("BookingDAO.adminCountBookingList", name);
	}
	
	// "관리자, 예약목록" 조회 및 페이징
	public List<BookingVO> adminBookingListWithPaging(Criteria criteria, String name) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("name", name);
		
		return mybatis.selectList("BookingDAO.adminBookingListWithPaging", map);
	}
	
	// "관리자, 예약목록" 예약 승인
	public void updateBookingResult(int bseq) {
		mybatis.update("BookingDAO.updateBookingResult", bseq);
	}
	
	// "관리자, 예약목록" 예약 취소
	public void updateBookingCancel(int bseq) {
		mybatis.update("BookingDAO.updateBookingCancel", bseq);
	}
	
	// "관리자, 예약실적" 조회
	public List<SalesBooking> getBookingSales() {
		return mybatis.selectList("BookingDAO.getBookingSales");
	}
	
}