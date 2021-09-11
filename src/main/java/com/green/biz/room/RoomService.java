package com.green.biz.room;

import java.util.List;

import com.green.biz.dto.BookingVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.utils.Criteria;

public interface RoomService {
	// "사용자, 예약" 객실 수 체크
	public int countRoomList();
	
	// "사용자, 예약" 인원 수로 객실 체크
	public int countPeopleList(BookingVO vo);
	
	// "사용자 및 관리자, 예약 및 객실목록" 객실 조회
	public RoomVO getRoom(int rid);
	
	// "사용자, 객실목록" 조회
	public List<RoomVO> roomList();
	
	// "관리자, 객실목록" 목록 수 조회
	public int adminCountRoomList(String type);
	
	// "관리자, 객실목록" 조회
	public List<RoomVO> adminRoomListWithPaging(Criteria criteria, String type);
	
	// "관리자, 객실목록" 객실 등록
	public void insertRoom(RoomVO vo);
	
	// "관리자, 객실목록" 객실 수정
	public void updateRoom(RoomVO vo);
	
	// "관리자, 객실목록" 객실 삭제
	public void deleteRoom(int rid);
	
}
