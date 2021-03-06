package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.utils.Criteria;

@Repository("roomDAO")
public class RoomDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
		
	// "사용자, 예약" 객실 수 체크
	public int countRoomList() {
		return mybatis.selectOne("RoomDAO.countRoomList");
	}
	
	// "사용자, 예약" 인원 수로 객실 체크
	public int countPeopleList(BookingVO vo) {
		return mybatis.selectOne("RoomDAO.countPeopleList", vo);
	}
	
	// "사용자 및 관리자, 예약 및 객실목록" 객실 조회
	public RoomVO getRoom(int rid) {
		return mybatis.selectOne("RoomDAO.getRoom", rid);
	}
	
	// "사용자, 객실목록" 조회
	public List<RoomVO> roomList() {
		return mybatis.selectList("RoomDAO.roomList");
	}
	
	// "관리자, 객실목록" 목록 수 조회
	public int adminCountRoomList(String type) {
		return mybatis.selectOne("RoomDAO.adminCountRoomList", type);
	}
	
	// "관리자, 객실목록" 조회
	public List<RoomVO> adminRoomListWithPaging(Criteria criteria, String type) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("type", type);
		
		return mybatis.selectList("RoomDAO.adminRoomListWithPaging", map);
	}
	
	// "관리자, 객실목록" 객실 등록
	public void insertRoom(RoomVO vo) {
		mybatis.insert("RoomDAO.insertRoom", vo);
	}
	
	// "관리자, 객실목록" 객실 수정
	public void updateRoom(RoomVO vo) {
		mybatis.update("RoomDAO.updateRoom", vo);
	}
	
	// "관리자, 객실목록" 객실 삭제
	public void deleteRoom(int rid) {
		mybatis.delete("RoomDAO.deleteRoom", rid);
	}
	
}