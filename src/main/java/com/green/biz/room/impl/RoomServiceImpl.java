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
	
	// "�����, ����" �ο� �� üũ
	@Override
	public int userCountPeopleList(BookingVO vo) {
		return roomDao.userCountPeopleList(vo);
	}
	
	// "����� �� ������, ���� �� ���Ǹ��" ���� ��ȸ
	@Override
	public RoomVO getRoom(int rid) {
		return roomDao.getRoom(rid);
	}
	
	// "����� �� ������, ���� �� ���Ǹ��" ���� ��ȸ
	@Override
	public List<RoomVO> roomList() {
		return roomDao.roomList();
	}
	
	// "������, ���Ǹ��" ��� �� ��ȸ
	@Override
	public int adminCountRoomList(String type) {
		return roomDao.adminCountRoomList(type);
	}
	
	// "������, ���Ǹ��" ��ȸ
	@Override
	public List<RoomVO> adminRoomListWithPaging(Criteria criteria, String type) {
		return roomDao.adminRoomListWithPaging(criteria, type);
	}
	
	// "������, ���Ǹ��" ���� ���
	@Override
	public void insertRoom(RoomVO vo) {
		roomDao.insertRoom(vo);
	}
	
	// "������, ���Ǹ��" ���� ����
	@Override
	public void updateRoom(RoomVO vo) {
		roomDao.updateRoom(vo);
	}
	
	// "������, ���Ǹ��" ���� ����
	@Override
	public void deleteRoom(int rid) {
		roomDao.deleteRoom(rid);
	}

}
