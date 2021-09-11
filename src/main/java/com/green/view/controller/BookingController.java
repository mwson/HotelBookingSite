package com.green.view.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.booking.BookingService;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.room.RoomService;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	@Autowired
	private RoomService roomService;
	
	// "사용자, 메인(예약하기)" 예약 검색
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(BookingVO vo, Model model) {
		// 중복 조회
		bookingCheck(vo, model);
		
		// "객실목록" 조회
		roomList(model);		
		
		return "booking/bookingSearch";
	}
	
	// "사용자, 예약하기(버튼)" 클릭으로 이동
	@RequestMapping(value = "/booking_button")
	public String bookingButton(BookingVO vo, Model model) {
		// "체크인, 체크아웃, 인원" 기본값 전달
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        
        // "체크인" 오늘날짜(기본 값)
        String today = sdf.format(cal.getTime());
        vo.setCheckin(today);
        
        // "체크아웃" 내일날짜(기본 값)
        cal.add(Calendar.DATE, 1);
        String tomorrow = sdf.format(cal.getTime());
        vo.setCheckout(tomorrow);
        
        // "인원" 1명(기본 값)
        vo.setPeople(1);
        
        // "객실" 중복 조회
        bookingCheck(vo, model);
		
        // "객실목록" 조회
     	roomList(model);
        
     	return "booking/bookingSearch";
	}
	
	@RequestMapping(value = "/booking_fail")
	public String bookingFail(@RequestParam(value = "roomRid")int roomRid, BookingVO vo) {
		// 객실 id
		vo.setRid(roomRid);
		// 객실 사용유무 확인(사용 : "y", 불가능 : "n")
		RoomVO roomUseyn = roomService.getRoom(vo.getRid());
		// 객실 인원 확인(0: 불가능, 1: 가능)
		int peopleCheck = roomService.countPeopleList(vo);
		// 체크인, 체크아웃, 객실로 중복 확인(0: 가능, 1: 불가능)
		int bookingCheck = bookingService.countBookingCheck(vo);
		
		if(roomUseyn.getUseyn().equals("n")) {
			return "booking/bookingCheckFail1";
		} else if(peopleCheck == 0) {
			return "booking/bookingCheckFail2";
		} else if(bookingCheck >= 1) {
			return "booking/bookingCheckFail3";
		} else {
			return "redirect:booking_button";
		}
	}
	
	// "사용자, 예약" 예약하기
	@RequestMapping(value = "/booking")
	public String booking(HttpSession session, @RequestParam(value = "roomRid")int roomRid, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// 객실 id
			vo.setRid(roomRid);
			// 객실 사용유무 확인(사용 : "y", 불가능 : "n")
			RoomVO roomUseyn = roomService.getRoom(vo.getRid());
			// 객실 인원 확인(0: 불가능, 1: 가능)
			int peopleCheck = roomService.countPeopleList(vo);
			// 체크인, 체크아웃, 객실로 중복 확인(0: 가능, 1: 불가능)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(roomUseyn.getUseyn().equals("n")) {
				return "booking/bookingCheckFail1";
			} else if(peopleCheck == 0) {
				return "booking/bookingCheckFail2";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail3";
			} else {
				// 예약자 조회
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// 룸 조회
				RoomVO roomVO = roomService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "사용자, 예약" 예약완료
	@RequestMapping(value = "/booking_complete")
	public String bookingComplete(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// 객실 사용유무 확인(사용 : "y", 불가능 : "n")
			RoomVO roomUseyn = roomService.getRoom(vo.getRid());
			// 객실 인원 확인(0: 불가능, 1: 가능)
			int peopleCheck = roomService.countPeopleList(vo);
			// 체크인, 체크아웃, 객실로 중복 확인(0: 가능, 1: 불가능)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(roomUseyn.getUseyn().equals("n")) {
				return "booking/bookingCheckFail1";
			} else if(peopleCheck == 0) {
				return "booking/bookingCheckFail2";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail3";
			} else {
				vo.setId(loginUser.getId());
				// vo.getBseq()에 bseq값 반환
				bookingService.insertBooking(vo);
				
				BookingVO bookingVO = bookingService.getBooking(vo.getBseq());
				model.addAttribute("bookingVO", bookingVO);

				checkSubPriceCal(bookingVO.getCheckin(), bookingVO.getCheckout(), bookingVO.getPrice(), model);
	
				return "booking/bookingComplete";
			}
		}
	}
	
	/*
	 * 모듈
	 */
	// "사용자, 메인(예약하기)" 인원, 체크인, 체크아웃으로 중복 조회
	public void bookingCheck(BookingVO vo, Model model) {
		// 객실 수
		int roomCount = roomService.countRoomList(); 
		// 객실 번호
		int[] roomRid = new int[roomCount];
		// 객실 인원 확인
		int[] peopleCheck = new int[roomCount];

		for(int i=0; i<roomCount; i++) {
			// 객실로 중복 확인 (jsp에서 0: 가능, 1: 불가능)
			int bookingCheck = 1;
			// 객실 번호 설정
			vo.setRid(i + 1);
			// 객실 번호
			roomRid[i] = i + 1;
			// 객실 사용유무 확인(사용 : "y", 불가능 : "n")
			RoomVO roomUseyn = roomService.getRoom(vo.getRid());
			// 객실 인원 확인(0: 불가능, 1: 가능)
			peopleCheck[i] = roomService.countPeopleList(vo);
			
			// 객실 사용유무 확인(사용 : "y")
			if(roomUseyn.getUseyn().equals("y")) {
				// 인원으로 입실 가능(1)
				if(peopleCheck[i] >= 1) {
					vo.setRid(roomRid[i]);
					// 체크인, 체크아웃, 객실로 중복 확인(0: 가능, 1: 불가능)
					bookingCheck = bookingService.countBookingCheck(vo);
					
					// 체크인, 체크아웃, 객실로 입실 불가능(1)
					if(bookingCheck >= 1) {
						model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
					// 체크인, 체크아웃, 객실로 입실 가능(0)
					} else {
						model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
					}
				// 인원으로 입실 불가능(0)
				} else {
					model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
				}
			// 객실 사용유무 확인(미사용 : "n")
			} else {				
				model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
			}
		}
	}
	
	// "객실목록" 조회
	public void roomList(Model model) {
		RoomVO[] roomRid = new RoomVO[4];
		
		for(int i=0; i<roomRid.length; i++) {
			roomRid[i] = roomService.getRoom(i + 1);

			model.addAttribute(("roomRid" + (i + 1)), roomRid[i]);
		}
	}
	
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