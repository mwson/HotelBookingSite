package com.green.biz.member;

import java.util.List;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.utils.Criteria;

public interface MemberService {
	
	// "�����, ȸ������" ��ȸ
	public MemberVO getMember(String id);
	
	// "�����, �α���" ��ȸ(���̵�, ��й�ȣ ��ġ)
	public int loginID(MemberVO vo);
	
	// "�����, ȸ������ �� �α���" ��ȸ(���̵� �� ��й�ȣ)
	public int confirmID(String id);
	
	// "�����, ȸ������" �����ȣ ��ȸ
	public List<AddressVO> selectAddressByDong(String dong);
	
	// "�����, ȸ������" ���(����)
	public void insertMember(MemberVO vo);
	
	// "�����, ���̵� �� ��й�ȣ ã��" ���̵� ��ȸ
	public MemberVO getMemberByNameAndEmail(MemberVO vo);
	
	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ��ȸ 
	public MemberVO findPassword(MemberVO vo);
	
	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ����
	public void changePassword(MemberVO vo);
	
	// "�����, ȸ������" ����
	public void updateMember(MemberVO vo);
	
	// "������, ȸ�����" ��ȸ
	public List<MemberVO> listMember(String key);

	// "������, ȸ�����" �� ���� ��ȸ
	public int countMemberList(String name);
	
	// "������, ȸ�����" ��ȸ �� ����¡
	public List<MemberVO> listMemberwithPaging(Criteria criteria, String key);
	
}
