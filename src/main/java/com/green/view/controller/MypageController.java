package com.green.view.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.booking.BookingService;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.member.MemberService;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
@SessionAttributes("loginUser")
public class MypageController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private BookingService bookingService;
	
	/*
	//  "사용자, 예약" 목록조회
	@RequestMapping(value = "/booking_list")
	public String bookingList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<BookingVO> bookingList = bookingService.getBookingList(loginUser.getId());
			model.addAttribute("bookingList", bookingList);
			
			return "mypage/bookingList";
		}
	}
	*/
	
	//  "사용자, 예약" 목록조회 및 페이징	
	@RequestMapping(value = "/booking_list")
	public String bookingListWithPaging(HttpSession session, Criteria criteria, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			String id = loginUser.getId();
			
			List<BookingVO> bookingList = bookingService.userBookingListWithPaging(criteria, id);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = bookingService.userCountBookingList(id);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("bookingList", bookingList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "mypage/bookingList";
		}
	}
	
	// "사용자, 예약" 상세조회
	@RequestMapping(value = "/booking_detail")
	public String bookingDetail(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			BookingVO bookingVO = bookingService.getBookingDetail(vo.getBseq());
			model.addAttribute("bookingVO", bookingVO);
			
			checkSubPriceCal(bookingVO.getCheckin(), bookingVO.getCheckout(), bookingVO.getPrice(), model);
			
			return "mypage/bookingDetail";
		}
	}

	// "사용자, 회원정보 수정" 비밀번호 확인 화면 이동
	@RequestMapping(value = "/update_member_form", method = RequestMethod.GET)
	public String updateMemberForm(HttpSession session,  Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			return "mypage/passwordCheck";		
		}
	}
	

	// "사용자, 회원정보 수정" 비밀번호 찾기 폼 팝업
	@RequestMapping(value = "/pwdCheck_find_pwd_form", method = RequestMethod.GET)
	public String pwdCheckFindPwdForm(HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			return "mypage/findPassword";
		}
	}
	
	// "사용자, 회원정보 수정" 비밀번호 확인 후 이동
	@RequestMapping(value = "/update_member_form_pwdCheck", method = RequestMethod.POST)
	public String updateMemberFormPwdCheck(HttpSession session, MemberVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			int result = memberService.pwdCheck(vo);

			if(result == 1) {
				MemberVO memberVO = memberService.getMember(loginUser.getId());
				model.addAttribute("memberVO", memberVO);
				
				return "mypage/updateMember";
			} else {
				return "mypage/passwordFail";		
			}
		}
	}
	
	// "사용자, 회원정보 수정" 업데이트
	@RequestMapping(value = "/update_member", method = RequestMethod.POST)
	public String updateMember(HttpSession session, @RequestParam(value = "default_pwd")String default_pwd,
			@RequestParam(value = "addr1")String addr1, @RequestParam(value = "addr2")String addr2, MemberVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		} else {
			if(vo.getPwd().isEmpty()) {
				vo.setPwd(default_pwd);
			}
			
			if(addr2.isEmpty()) {
				vo.setAddress(addr1);
			} else {
				vo.setAddress(addr1 + " " + addr2);
			}

			memberService.updateMember(vo);
			
			return "redirect:update_member_form";
		}
	}	
	
	/*
	 * 모듈화
	 */
	// "체크인, 체크아웃" (yyyyMMdd) 자르기
	public String checkSubstring(String checkinout) {		
		String yyyy = checkinout.substring(0, 4);
		String MM = checkinout.substring(5, 7);
		String dd = checkinout.substring(8, 10);
		
		String checkinout_sub = (yyyy + "" + MM + "" + dd + "");
		
		return checkinout_sub;
	}
	
	// "체크인, 체크아웃" (년, 월, 일) 변환
	public String checkConversion(String checkinout) {
		String yyyy = checkinout.substring(0, 4);
		String MM = checkinout.substring(4, 6);
		String dd = checkinout.substring(6);
		
		String checkinout_con = (yyyy + "년 " + MM + "월 " + dd + "일");
		
		return checkinout_con;
	}
	
	// "체크인, 체크아웃" 날짜 계산 
	public long checkCalculation(String checkin, String checkout) {
		long checkinout_cal = 0;
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date sdf_checkin = sdf.parse(checkin);
            Date sdf_checkout = sdf.parse(checkout);
            
            checkinout_cal = (sdf_checkout.getTime() - sdf_checkin.getTime()) / (24 * 60 * 60 * 1000);
        } catch(ParseException e) {
            e.printStackTrace();
        }

        return checkinout_cal;
	}
	
	// "문자열, 요금" 계산 및 출력 
	public void checkSubPriceCal(String checkin, String checkout, int dayPrice, Model model) {
		// "체크인, 체크아웃" (yyyyMMdd) 자르기
		if(checkin.length() != 8) {
			checkin = checkSubstring(checkin);
		}
		if(checkout.length() != 8) {
			checkout = checkSubstring(checkout);
		}
		
		// "체크인, 체크아웃" (년, 월, 일) 변환
		String checkin_con = checkConversion(checkin);
		String checkout_con = checkConversion(checkout);
		model.addAttribute("checkin", checkin_con);
		model.addAttribute("checkout", checkout_con);
		
		// "체크인, 체크아웃" 날짜 계산 
		long checkinout_cal = checkCalculation(checkin, checkout);
		model.addAttribute("checkinout_cal", checkinout_cal);
		
		// 객실 요금(1박 요금 * 날짜) 계산
		long roomPrice = (long)(dayPrice * checkinout_cal);
		model.addAttribute("roomPrice", roomPrice);
		
		// 부가가치세 계산(객실요금 * 0.1)
		long vat = (long)(roomPrice * 0.1);
		model.addAttribute("vat", vat);
		
		// 총 요금 계산(객실요금 * 0.1)
		long totalPrice = (long)(roomPrice + vat);
		model.addAttribute("totalPrice", totalPrice);		
	}
	
}