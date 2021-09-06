package com.green.biz.room;

import java.util.List;

import com.green.biz.dto.RoomVO;
import com.green.biz.utils.Criteria;

public interface RoomService {
	
	// "����� �� ������, ���� �� ���Ǹ��" ���� ��ȸ
	public RoomVO getRoom(int rid);
	
	// "�����, ���Ǹ��" ��ȸ
	public List<RoomVO> roomList();
	
	// "������, ���Ǹ��" ��� �� ��ȸ
	public int adminCountRoomList(String type);
	
	// "������, ���Ǹ��" ��ȸ
	public List<RoomVO> adminRoomListWithPaging(Criteria criteria, String type);
	
	// "������, ���Ǹ��" ���� ���
	public void insertRoom(RoomVO vo);
	
	// "������, ���Ǹ��" ���� ����
	public void updateRoom(RoomVO vo);
	
	// "������, ���Ǹ��" ���� ����
	public void deleteRoom(int rid);
	
}
