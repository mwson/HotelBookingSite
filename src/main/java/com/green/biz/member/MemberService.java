package com.green.biz.member;

import java.util.List;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.utils.Criteria;

public interface MemberService {
	
	// "�����" ��й�ȣ ��ȸ
	public int memberCheck(MemberVO vo);
	
	// "�����, ȸ������" ��ȸ
	public MemberVO getMember(String id);
	
	// "�����, ȸ������ ����" ��й�ȣ Ȯ��
	public int pwdCheck(MemberVO vo);
	
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
