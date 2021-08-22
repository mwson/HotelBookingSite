package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.utils.Criteria;

@Repository("memberDAO")
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// "�����, ȸ������" ��ȸ
	public MemberVO getMember(String id) {
		return mybatis.selectOne("MemberDAO.getMember", id);
	}
	
	// "�����, �α���" ��ȸ(���̵�, ��й�ȣ ��ġ)
	public int loginID(MemberVO vo) {
		String pwd = null;
		int result = -1;
		
		pwd = mybatis.selectOne("MemberDAO.confirmID", vo.getId());
		
		if(pwd == null) {
			result = -1;
		} else if(pwd.equals(vo.getPwd())) {
			result = 1;
		} else {
			result = 0;
		}
		
		return result;
	}
	
	// "�����, ȸ������ �� �α���" ��ȸ(���̵� �� ��й�ȣ)
	public int confirmID(String id) {
		String pwd = mybatis.selectOne("MemberDAO.confirmID", id);
		
		if(pwd != null) {
			return 1;
		} else {
			return -1;
		}
	}
	
	// "�����, ȸ������" �����ȣ ��ȸ
	public List<AddressVO> selectAddressByDong(String dong) {
		return mybatis.selectList("MemberDAO.selectAddressByDong", dong);
	}
	
	// "�����, ȸ������" ���(����)
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	// "�����, ���̵� �� ��й�ȣ ã��" ���̵� ��ȸ
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberByNameAndEmail", vo);
	}

	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ��ȸ 
	public MemberVO findPassword(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}

	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ����
	public void changePassword(MemberVO vo) {
		mybatis.update("MemberDAO.changePassword", vo);
	}
	
	// "�����, ȸ������" ����
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}
	
	// "������, ȸ�����" ��ȸ
	public List<MemberVO> listMember(String key) {
		return mybatis.selectList("MemberDAO.listMember", key);
	}
	
	// "������, ȸ�����" �� ���� ��ȸ
	public int countMemberList(String name) {
		return mybatis.selectOne("MemberDAO.countMemberList", name);
	}
		
	// "������, ȸ�����" ��ȸ �� ����¡
	public List<MemberVO> listMemberwithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("MemberDAO.listMemberwithPaging", map);
	}
	
}