package com.green.biz.member;

import java.util.List;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.utils.Criteria;

public interface MemberService {
	
	// "사용자" 비밀번호 조회
	public int memberCheck(MemberVO vo);
	
	// "사용자, 회원정보" 조회
	public MemberVO getMember(String id);
	
	// "사용자, 회원정보 수정" 비밀번호 확인
	public int pwdCheck(MemberVO vo);
	
	// "사용자, 회원가입" 우편번호 조회
	public List<AddressVO> selectAddressByDong(String dong);
	
	// "사용자, 회원가입" 등록(가입)
	public void insertMember(MemberVO vo);
	
	// "사용자, 아이디 및 비밀번호 찾기" 아이디 조회
	public MemberVO getMemberByNameAndEmail(MemberVO vo);
	
	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 조회 
	public MemberVO findPassword(MemberVO vo);
	
	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 수정
	public void changePassword(MemberVO vo);
	
	// "사용자, 회원정보" 수정
	public void updateMember(MemberVO vo);
	
	// "관리자, 회원목록" 조회
	public List<MemberVO> listMember(String key);

	// "관리자, 회원목록" 총 개수 조회
	public int countMemberList(String name);
	
	// "관리자, 회원목록" 조회 및 페이징
	public List<MemberVO> listMemberwithPaging(Criteria criteria, String key);
	
}
