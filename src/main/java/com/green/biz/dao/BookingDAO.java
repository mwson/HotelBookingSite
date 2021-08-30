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
	
	// "�����, ����" üũ��, üũ�ƿ����� ���� �ߺ� ��ȸ
	public int countBookingCheck(BookingVO vo) {
		return mybatis.selectOne("BookingDAO.countBookingCheck", vo);
	}
	
	// "�����, ����" ����Ϸ�
	public void insertBooking(BookingVO vo) {
		mybatis.insert("BookingDAO.insertBooking", vo);
	}
	
	// "�����, ����" ���� ��ȸ
	public BookingVO getBooking(int bseq) {
		return mybatis.selectOne("BookingDAO.getBooking", bseq);
	}
	
	// "�����, ���� �� ������, ������" �� ��ȸ
	public BookingVO getBookingDetail(int bseq) {
		return mybatis.selectOne("BookingDAO.getBookingDetail", bseq);
	}
	
	//  "�����, ����" ��� ��ȸ
	public List<BookingVO> getBookingList(String id) {
		return mybatis.selectList("BookingDAO.getBookingList", id);
	}
	
	// "�����, ����" ��� �� ��ȸ
	public int userCountBookingList(String id) {
		return mybatis.selectOne("BookingDAO.userCountBookingList", id);
	}
	
	// "�����, ����" ��� ��ȸ �� ����¡	
	public List<BookingVO> userBookingListWithPaging(Criteria criteria, String id) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("id", id);
		
		return mybatis.selectList("BookingDAO.userBookingListWithPaging", map);
	}
	
	// "������, ������" ��� �� ��ȸ
	public int adminCountBookingList(String name) {
		return mybatis.selectOne("BookingDAO.adminCountBookingList", name);
	}
	
	// "������, ������" ��ȸ �� ����¡
	public List<BookingVO> adminBookingListWithPaging(Criteria criteria, String name) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("name", name);
		
		return mybatis.selectList("BookingDAO.adminBookingListWithPaging", map);
	}
	
	// "������, ������" ���� ����
	public void updateBookingResult(int bseq) {
		mybatis.update("BookingDAO.updateBookingResult", bseq);
	}
	
	// "������, ������" ���� ���
	public void updateBookingCancel(int bseq) {
		mybatis.update("BookingDAO.updateBookingCancel", bseq);
	}
	
	// "������, �������" ��ȸ
	public List<SalesBooking> getBookingSales() {
		return mybatis.selectList("BookingDAO.getBookingSales");
	}
	
}