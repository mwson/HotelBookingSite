package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.green.biz.dto.AddressVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.member.MemberService;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// "사용자, 로그인" 폼 이동
	@RequestMapping(value = "/login_form", method = RequestMethod.GET)
	public String loginView() {
		return "member/login";
	}
	
	// "사용자, 로그인" 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(MemberVO vo, HttpServletRequest request, Model model) {
		int result = memberService.loginID(vo);
		MemberVO loginUser = null;
		
		if(result == 1) { // 사용자 인증 성공
			loginUser = memberService.getMember(vo.getId());
			
			model.addAttribute("loginUser", loginUser);
			
			// 이전 페이지에 대한 정보 저장
			String referer = request.getHeader("Referer");
			// 이전 정보가 로그인폼일 경우
			String loginForm = "http://localhost:8181/biz/login_form";
			
			if(referer.equals(loginForm) || referer == null) {	
				return "index";
			} else {
				return "redirect:" + referer;
			}
		} else {
			// "사용자, 로그인" 로그인 실패
			return "member/loginFail";
		}
	}
	
	// "사용자, 회원가입" 약관 이동
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public String contractView() {
		return "member/contract";
	}
	
	// "사용자, 회원가입" 회원가입 폼 이동
	@RequestMapping(value = "/join_form", method = RequestMethod.POST)
	public String joinView() {
		return "member/join";
	}

	// "사용자, 회원가입" 아이디 중복 폼 이동
	@RequestMapping(value = "/id_check_form", method = RequestMethod.GET)
	public String idCheckView(@RequestParam(value = "id", defaultValue = "", required = true)String id, Model model) {
		model.addAttribute("id", id);
		
		return "member/idCheck";
	}
	
	// "사용자, 회원가입" 아이디 중복 조회
	@RequestMapping(value = "/id_check_form", method = RequestMethod.POST)
	public String idCheckAction(@RequestParam(value = "id", defaultValue = "", required = true)String id, Model model) {
		MemberVO user = memberService.getMember(id);
		
		if(user != null) {
			model.addAttribute("message", 1);
		} else {
			model.addAttribute("message", -1);
		}
		
		model.addAttribute("id", id);
		
		return "member/idCheck";
	}
	
	/*
	// "사용자, 회원가입" 아이디 중복없음 전송
	@RequestMapping(value = "/id_check_confirmed", method = RequestMethod.GET)
	public String idCheckConfirmed(MemberVO vo, Model model) {
		model.addAttribute("id", vo.getId());
		model.addAttribute("reid", vo.getId());
		
		return "member/join";
	}
	*/
	
	// "사용자, 회원가입" 우편번호 조회 폼 이동
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.GET)
	public String findZipNumView() {
		return "member/findZipNum";
	}
	
	// "사용자, 회원가입" 우편번호 조회
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.POST)
	public String findZipNumAction(AddressVO vo, Model model) {
		List<AddressVO> addressList = memberService.selectAddressByDong(vo.getDong());
	
		model.addAttribute("addressList", addressList);
		
		return "member/findZipNum";
	}
	
	// "사용자, 회원가입" 등록(가입)
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(@RequestParam(value = "addr1")String addr1, @RequestParam(value = "addr2")String addr2, MemberVO vo) {
		vo.setAddress(addr1 + " " + addr2);
		memberService.insertMember(vo);
		
		return "member/login";
	}
	
	// "사용자" 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();	// 현재 세션을 종료
		
		return "member/login";
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 폼 이동
	@RequestMapping(value = "/find_idAndPwd_form", method = RequestMethod.GET)
	public String findIdView() {
		return "member/findIdAndPassword";
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 아이디 조회
	@RequestMapping(value = "/find_id", method = RequestMethod.GET)
	public String findIdAction(MemberVO vo, Model model) {
		MemberVO vo2 = memberService.getMemberByNameAndEmail(vo);
		
		if(vo2 != null) {
			model.addAttribute("message", 1);
			model.addAttribute("id", vo2.getId());
		} else {
			model.addAttribute("message", -1);
		}

		return "member/findIdResult";
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 조회 
	@RequestMapping(value = "/find_password", method = RequestMethod.GET)
	public String findPassword(MemberVO vo, Model model) {
		MemberVO vo2 = memberService.findPassword(vo);
		
		if(vo2 != null) {
			model.addAttribute("message", 1);
			model.addAttribute("id", vo2.getId());
		} else {
			model.addAttribute("message", -1);
		}
		
		return "member/findPwdResult";
	}
	
	// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 수정
	@RequestMapping(value = "/change_Password", method = RequestMethod.POST)
	public String changePassword(MemberVO vo) {
		memberService.changePassword(vo);
		
		// "사용자, 아이디 및 비밀번호 찾기" 비밀번호 수정 후 팝업 닫기		
		return "member/close";
	}
	
}