package com.green.biz.member;

import java.util.List;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;

public interface MemberService {
	
	// ȸ�� �α���
	public int loginID(MemberVO vo);
	
	// ȸ�� ������ ��ȸ
	public MemberVO getMember(String id);
	
	// ȸ��ID ����
	public int confirmID(String id);
	
	// ȸ���߰�
	public void insertMember(MemberVO vo);
	
	// �����ȣ ã��
	public List<AddressVO> selectAddressByDong(String dong);
	
	// ������̸��� �̸����� �������� ��������� ��ȸ
	public MemberVO getMemberByNameAndEmail(MemberVO vo);
	
	// ����� ���̵�� �̸�, �̸����� �������� ��������� ��ȸ
	public MemberVO findPassword(MemberVO vo);
	
	// ����� ��ȣ ����
	public void changePassword(MemberVO vo);
	
	// ȸ����� ��ȸ
	public List<MemberVO> listMember(String key);
	
	public void updateMember(MemberVO vo);
}
