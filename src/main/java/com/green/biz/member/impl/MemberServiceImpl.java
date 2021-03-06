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
	
	// "사용자" 비밀번호 조회
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
	
	// "사용자, 회원정보" 조회
	@Override
	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}
	
	// "사용자, 회원정보 수정" 비밀번호 확인
	@Override
	public int pwdCheck(MemberVO vo) {
		return memberDao.pwdCheck(vo);
	}
	
	// "사용자, 회원가입" 우편번호 조회
	@Override
	public List<AddressVO> selectAddressByDong(String dong) {
		return memberDao.selectAddressByDong(dong);
	}
	
	// "사용자, 회원가입" 등록(가입)
	@Override
	public void insertMember(MemberVO vo) {
		memberDao.insertMember(vo);
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 아이디 조회
	@Override
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		return memberDao.getMemberByNameAndEmail(vo);
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 조회 
	@Override
	public MemberVO findPassword(MemberVO vo) {
		return memberDao.findPassword(vo);
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 수정
	@Override
	public void changePassword(MemberVO vo) {
		memberDao.changePassword(vo);
	}
	
	// "사용자, 회원정보" 수정
	@Override
	public void updateMember(MemberVO vo) {
		memberDao.updateMember(vo);
	}
	
	// "관리자, 회원목록" 조회
	@Override
	public List<MemberVO> listMember(String key) {
		return memberDao.listMember(key);
	}
	
	// "관리자, 회원목록" 총 개수 조회
	@Override
	public int countMemberList(String name) {
		return memberDao.countMemberList(name);
	}
	
	// "관리자, 회원목록" 조회 및 페이징
	@Override
	public List<MemberVO> listMemberwithPaging(Criteria criteria, String key) {
		return memberDao.listMemberwithPaging(criteria, key);
	}

}
