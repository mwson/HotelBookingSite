package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;

@Repository("memberDAO")
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원 상세정보 조회
	public MemberVO getMember(String id) {
		return mybatis.selectOne("MemberDAO.getMember", id);
	}
	
	// 회원 ID 존재 확인
	public int confirmID(String id) {
		String pwd = mybatis.selectOne("MemberDAO.confirmID", id);
		
		if(pwd != null) {
			return 1;
		} else {
			return -1;
		}
	}
	
	/*
	 * 회원 로그인
	 */
	public int loginID(MemberVO vo) {
		String pwd = null;
		int result = -1;
		
		pwd = mybatis.selectOne("MemberDAO.confirmID", vo.getId());
		
		// DB에서 조회한 password와 사용자가 입력한 password 비교
		if(pwd == null) {	// 비밀번호가 없는 경우
			result = -1;
		} else if(pwd.equals(vo.getPwd())) {	// id와 pwd가 일치하는 경우
			result = 1;
		} else {	// 비밀번호가 일치하지 않음
			result = 0;
		}
		
		return result;
	}
	
	// 회원 추가
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	// 동 이름으로 우편번호 찾기
	public List<AddressVO> selectAddressByDong(String dong) {
		return mybatis.selectList("MemberDAO.selectAddressByDong", dong);
	}
	
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberByNameAndEmail", vo);
	}
	
	public MemberVO findPassword(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}
	
	public void changePassword(MemberVO vo) {
		mybatis.update("MemberDAO.changePassword", vo);
	}
	
	public List<MemberVO> listMember(String key) {
		return mybatis.selectList("MemberDAO.listMember", key);
	}
	
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}
}