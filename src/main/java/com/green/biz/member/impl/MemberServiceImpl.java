package com.green.biz.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MemberDAO;
import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.member.MemberService;
import com.green.biz.utils.Criteria;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	// "�����" ��й�ȣ ��ȸ
	@Override
	public int memberCheck(MemberVO vo) {
		int result = -1;
		
		String pwd_id_db = memberDao.memberCheck(vo.getId());
		
		if(pwd_id_db == null) {
			result = -1;
		} else {
			if(vo.getPwd().equals(pwd_id_db)) {
				result = 1;
			} else {
				result = 0;
			}
		}
		return result;
	}
	
	// "�����, ȸ������" ��ȸ
	@Override
	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}
	
	// "�����, ȸ������ ����" ��й�ȣ Ȯ��
	@Override
	public int pwdCheck(MemberVO vo) {
		return memberDao.pwdCheck(vo);
	}
	
	// "�����, ȸ������" �����ȣ ��ȸ
	@Override
	public List<AddressVO> selectAddressByDong(String dong) {
		return memberDao.selectAddressByDong(dong);
	}
	
	// "�����, ȸ������" ���(����)
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}
	
	// "�����, ���̵� �� ��й�ȣ ã��" ���̵� ��ȸ
	@Override
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		return memberDao.getMemberByNameAndEmail(vo);
	}
	
	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ��ȸ 
	@Override
	public MemberVO findPassword(MemberVO vo) {
		return memberDao.findPassword(vo);
	}
	
	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ����
	@Override
	public void changePassword(MemberVO vo) {
		memberDao.changePassword(vo);
	}
	
	// "�����, ȸ������" ����
	@Override
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);
	}
	
	// "������, ȸ�����" ��ȸ
	@Override
	public List<MemberVO> listMember(String key) {
		return memberDao.listMember(key);
	}
	
	// "������, ȸ�����" �� ���� ��ȸ
	@Override
	public int countMemberList(String name) {
		return memberDao.countMemberList(name);
	}
	
	// "������, ȸ�����" ��ȸ �� ����¡
	@Override
	public List<MemberVO> listMemberwithPaging(Criteria criteria, String key) {
		return memberDao.listMemberwithPaging(criteria, key);
	}

}
