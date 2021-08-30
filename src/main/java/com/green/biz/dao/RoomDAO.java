package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.RoomVO;
import com.green.biz.utils.Criteria;

@Repository("roomDAO")
public class RoomDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "�����, ����" ���� ��ȸ
	public RoomVO getRoom(int rid) {
		return mybatis.selectOne("RoomDAO.getRoom", rid);
	}
	
	// "������, ���Ǹ��" ��� �� ��ȸ
	public int adminCountRoomList(String type) {
		return mybatis.selectOne("RoomDAO.adminCountRoomList", type);
	}
	
	// "������, ���Ǹ��" ��ȸ
	public List<RoomVO> adminRoomListWithPaging(Criteria criteria, String type) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("type", type);
		
		return mybatis.selectList("RoomDAO.adminRoomListWithPaging", map);
	}
	
	// "������, ���Ǹ��" ���� ���
	public void insertRoom(RoomVO vo) {
		mybatis.insert("RoomDAO.insertRoom", vo);
	}
	
	// "������, ���Ǹ��" ���� ����
	public void updateRoom(RoomVO vo) {
		mybatis.update("RoomDAO.updateRoom", vo);
	}
	
	// "������, ���Ǹ��" ���� ����
	public void deleteRoom(int rid) {
		mybatis.delete("RoomDAO.deleteRoom", rid);
	}
	
}