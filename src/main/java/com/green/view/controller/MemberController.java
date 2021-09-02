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
	
	// "�����, �α���" �� �̵�
	@RequestMapping(value = "/login_form", method = RequestMethod.GET)
	public String loginView() {
		return "member/login";
	}
	
	// "�����, �α���" �α���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(MemberVO vo, HttpServletRequest request, Model model) {
		int result = memberService.loginID(vo);
		MemberVO loginUser = null;
		
		if(result == 1) { // ����� ���� ����
			loginUser = memberService.getMember(vo.getId());
			
			model.addAttribute("loginUser", loginUser);
			
			// ���� �������� ���� ���� ����
			String referer = request.getHeader("Referer");
			// ���� ������ �α������� ���
			String loginForm = "http://localhost:8181/biz/login_form";
			
			if(referer.equals(loginForm) || referer == null) {	
				return "index";
			} else {
				return "redirect:" + referer;
			}
		} else {
			// "�����, �α���" �α��� ����
			return "member/loginFail";
		}
	}
	
	// "�����, ȸ������" ��� �̵�
	@RequestMapping(value = "/contract", method = RequestMethod.GET)
	public String contractView() {
		return "member/contract";
	}
	
	// "�����, ȸ������" ȸ������ �� �̵�
	@RequestMapping(value = "/join_form", method = RequestMethod.POST)
	public String joinView() {
		return "member/join";
	}

	// "�����, ȸ������" ���̵� �ߺ� �� �̵�
	@RequestMapping(value = "/id_check_form", method = RequestMethod.GET)
	public String idCheckView(@RequestParam(value = "id", defaultValue = "", required = true)String id, Model model) {
		model.addAttribute("id", id);
		
		return "member/idCheck";
	}
	
	// "�����, ȸ������" ���̵� �ߺ� ��ȸ
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
	// "�����, ȸ������" ���̵� �ߺ����� ����
	@RequestMapping(value = "/id_check_confirmed", method = RequestMethod.GET)
	public String idCheckConfirmed(MemberVO vo, Model model) {
		model.addAttribute("id", vo.getId());
		model.addAttribute("reid", vo.getId());
		
		return "member/join";
	}
	*/
	
	// "�����, ȸ������" �����ȣ ��ȸ �� �̵�
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.GET)
	public String findZipNumView() {
		return "member/findZipNum";
	}
	
	// "�����, ȸ������" �����ȣ ��ȸ
	@RequestMapping(value = "/find_zip_num", method = RequestMethod.POST)
	public String findZipNumAction(AddressVO vo, Model model) {
		List<AddressVO> addressList = memberService.selectAddressByDong(vo.getDong());
	
		model.addAttribute("addressList", addressList);
		
		return "member/findZipNum";
	}
	
	// "�����, ȸ������" ���(����)
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(@RequestParam(value = "addr1")String addr1, @RequestParam(value = "addr2")String addr2, MemberVO vo) {
		vo.setAddress(addr1 + " " + addr2);
		memberService.insertMember(vo);
		
		return "member/login";
	}
	
	// "�����" �α׾ƿ�
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status) {
		status.setComplete();	// ���� ������ ����
		
		return "member/login";
	}
	
	// "�����, ���̵� �� ��й�ȣ ã��" �� �̵�
	@RequestMapping(value = "/find_idAndPwd_form", method = RequestMethod.GET)
	public String findIdView() {
		return "member/findIdAndPassword";
	}
	
	// "�����, ���̵� �� ��й�ȣ ã��" ���̵� ��ȸ
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
	
	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ��ȸ 
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
	
	// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ����
	@RequestMapping(value = "/change_Password", method = RequestMethod.POST)
	public String changePassword(MemberVO vo) {
		memberService.changePassword(vo);
		
		// "�����, ���̵� �� ��й�ȣ ã��" ��й�ȣ ���� �� �˾� �ݱ�		
		return "member/close";
	}
	
}