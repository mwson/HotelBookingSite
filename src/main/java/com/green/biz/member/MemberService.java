package com.green.biz.member;

import java.util.List;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;

public interface MemberService {
	
	// 회원 로그인
	public int loginID(MemberVO vo);
	
	// 회원 상세정보 조회
	public MemberVO getMember(String id);
	
	// 회원ID 인증
	public int confirmID(String id);
	
	// 회원추가
	public void insertMember(MemberVO vo);
	
	// 우편번호 찾기
	public List<AddressVO> selectAddressByDong(String dong);
	
	// 사용자이름과 이메일을 조건으로 사용자정보 조회
	public MemberVO getMemberByNameAndEmail(MemberVO vo);
	
	// 사용자 아이디와 이름, 이메일을 조건으로 사용자정보 조회
	public MemberVO findPassword(MemberVO vo);
	
	// 사용자 암호 변경
	public void changePassword(MemberVO vo);
	
	// 회원목록 조회
	public List<MemberVO> listMember(String key);
	
	public void updateMember(MemberVO vo);
}
