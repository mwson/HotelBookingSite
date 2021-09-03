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
	
	// "사용자" 비밀번호 조회
	public String memberCheck(String id) {
		return mybatis.selectOne("MemberDAO.memberCheck", id);
	}
	
	// "사용자, 회원정보" 조회
	public MemberVO getMember(String id) {
		return mybatis.selectOne("MemberDAO.getMember", id);
	}
	
	// "사용자, 회원정보 수정" 비밀번호 확인
	public int pwdCheck(MemberVO vo) {
		String pwd = null;
		int result = -1;
		
		pwd = mybatis.selectOne("MemberDAO.memberCheck", vo.getId());
		
		if(pwd == null) {
			result = -1;
		} else if(pwd.equals(vo.getPwd())) {
			result = 1;
		} else {
			result = 0;
		}
		
		return result;
	}
	
	// "사용자, 회원가입" 우편번호 조회
	public List<AddressVO> selectAddressByDong(String dong) {
		return mybatis.selectList("MemberDAO.selectAddressByDong", dong);
	}
	
	// "사용자, 회원가입" 등록(가입)
	public void insertMember(MemberVO vo) {
		mybatis.insert("MemberDAO.insertMember", vo);
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 아이디 조회
	public MemberVO getMemberByNameAndEmail(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberByNameAndEmail", vo);
	}

	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 조회 
	public MemberVO findPassword(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}

	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 수정
	public void changePassword(MemberVO vo) {
		mybatis.update("MemberDAO.changePassword", vo);
	}
	
	// "사용자, 회원정보" 수정
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}
	
	// "관리자, 회원목록" 조회
	public List<MemberVO> listMember(String key) {
		return mybatis.selectList("MemberDAO.listMember", key);
	}
	
	// "관리자, 회원목록" 총 개수 조회
	public int countMemberList(String name) {
		return mybatis.selectOne("MemberDAO.countMemberList", name);
	}
		
	// "관리자, 회원목록" 조회 및 페이징
	public List<MemberVO> listMemberwithPaging(Criteria criteria, String key) {
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("criteria", criteria);
		map.put("key", key);
		
		return mybatis.selectList("MemberDAO.listMemberwithPaging", map);
	}
	
}