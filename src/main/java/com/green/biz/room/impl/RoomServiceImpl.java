package com.green.biz.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.RoomDAO;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.room.RoomService;
import com.green.biz.utils.Criteria;

@Service("roomService")
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDAO roomDao;
	
	// "사용자, 예약" 인원 수 체크
	@Override
	public int userCountPeopleList(BookingVO vo) {
		return roomDao.userCountPeopleList(vo);
	}
	
	// "사용자 및 관리자, 예약 및 객실목록" 객실 조회
	@Override
	public RoomVO getRoom(int rid) {
		return roomDao.getRoom(rid);
	}
	
	// "사용자 및 관리자, 예약 및 객실목록" 객실 조회
	@Override
	public List<RoomVO> roomList() {
		return roomDao.roomList();
	}
	
	// "관리자, 객실목록" 목록 수 조회
	@Override
	public int adminCountRoomList(String type) {
		return roomDao.adminCountRoomList(type);
	}
	
	// "관리자, 객실목록" 조회
	@Override
	public List<RoomVO> adminRoomListWithPaging(Criteria criteria, String type) {
		return roomDao.adminRoomListWithPaging(criteria, type);
	}
	
	// "관리자, 객실목록" 객실 등록
	@Override
	public void insertRoom(RoomVO vo) {
		roomDao.insertRoom(vo);
	}
	
	// "관리자, 객실목록" 객실 수정
	@Override
	public void updateRoom(RoomVO vo) {
		roomDao.updateRoom(vo);
	}
	
	// "관리자, 객실목록" 객실 삭제
	@Override
	public void deleteRoom(int rid) {
		roomDao.deleteRoom(rid);
	}

}
