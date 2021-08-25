package com.green.view.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.biz.booking.BookingService;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.RoomVO;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
		
	// "사용자, 메인(예약하기)" 인원, 체크인, 체크아웃으로 중복 조회
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(BookingVO vo, Model model) {
		// 방 마다 중복 조회
		int suiteRoom = 0;
		int superiorRoom = 0;
		int deluxeRoom = 0;
		int standardRoom = 0;
		
		// 날짜, 인원, 객실 조회
		model.addAttribute("bookingVO", vo);
		
		// 인원 4명 조회
		if(vo.getPeople() >= 4) {
			// 스위트 룸(4명), rid: 1
			// 체크인, 체크아웃으로 중복 조회
			vo.setRid("1");	
			suiteRoom = bookingService.countBookingCheck(vo);
			
			if(suiteRoom >= 1) {
				// 예약불가(2)
				model.addAttribute("suiteRoom", "2");
				model.addAttribute("superiorRoom", "2");
				model.addAttribute("deluxeRoom", "2");
				model.addAttribute("standardRoom", "2");
				
				return "booking/bookingList";
			} else {
				// 예약가능(1)
				model.addAttribute("suiteRoom", "1");
				model.addAttribute("superiorRoom", "2");
				model.addAttribute("deluxeRoom", "2");
				model.addAttribute("standardRoom", "2");
				
				return "booking/bookingList";
			}
		// 인원 3명 조회			
		} if(vo.getPeople() == 3) {
			// 스위트 룸(4명), rid: 1
			vo.setRid("1");	
			suiteRoom = bookingService.countBookingCheck(vo);
			if(suiteRoom >= 1) {
				model.addAttribute("suiteRoom", "2");
				
				// 슈페리어 룸(3명), rid: 2
				vo.setRid("2");	
				superiorRoom = bookingService.countBookingCheck(vo);
				if(superiorRoom >= 1) {
					model.addAttribute("superiorRoom", "2");
					model.addAttribute("deluxeRoom", "2");
					model.addAttribute("standardRoom", "2");
					
					return "booking/bookingList";
				} else {
					model.addAttribute("superiorRoom", "1");
					model.addAttribute("deluxeRoom", "2");
					model.addAttribute("standardRoom", "2");
					
					return "booking/bookingList";
				}
			} else {
				model.addAttribute("suiteRoom", "1");
				
				// 슈페리어 룸(3명), rid: 2
				vo.setRid("2");	
				superiorRoom = bookingService.countBookingCheck(vo);
				if(superiorRoom >= 1) {
					model.addAttribute("superiorRoom", "2");
					model.addAttribute("deluxeRoom", "2");
					model.addAttribute("standardRoom", "2");
					
					return "booking/bookingList";
				} else {
					model.addAttribute("superiorRoom", "1");
					model.addAttribute("deluxeRoom", "2");
					model.addAttribute("standardRoom", "2");
					
					return "booking/bookingList";
				}
			}
		// 인원 2명 이하		
		} else {
			// 스위트 룸(4명), rid: 1
			vo.setRid("1");	
			suiteRoom = bookingService.countBookingCheck(vo);
			if(suiteRoom >= 1) {
				model.addAttribute("suiteRoom", "2");
				
				// 슈페리어 룸(3명), rid: 2
				vo.setRid("2");	
				superiorRoom = bookingService.countBookingCheck(vo);
				if(superiorRoom >= 1) {
					model.addAttribute("superiorRoom", "2");
					
					// 디럭스 룸(2명), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					} else {
						model.addAttribute("deluxeRoom", "1");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					}
				} else {
					model.addAttribute("superiorRoom", "1");
					
					// 디럭스 룸(2명), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					} else {
						model.addAttribute("deluxeRoom", "1");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					}
				}
			} else {
				model.addAttribute("suiteRoom", "1");
				
				// 슈페리어 룸(3명), rid: 2
				vo.setRid("2");	
				superiorRoom = bookingService.countBookingCheck(vo);
				if(superiorRoom >= 1) {
					model.addAttribute("superiorRoom", "2");
					
					// 디럭스 룸(2명), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					} else {
						model.addAttribute("deluxeRoom", "1");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					}
				} else {
					model.addAttribute("superiorRoom", "1");
					
					// 디럭스 룸(2명), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					} else {
						model.addAttribute("deluxeRoom", "1");
						
						// 스탠다드 룸(2명), rid: 4
						vo.setRid("4");	
						standardRoom = bookingService.countBookingCheck(vo);
						if(standardRoom >= 1) {
							model.addAttribute("standardRoom", "2");
							
							return "booking/bookingList";
						} else {
							model.addAttribute("standardRoom", "1");
							
							return "booking/bookingList";
						}
					}
				}
			}
		}
	}
	
	// "사용자" 예약하기 화면 이동	
	@RequestMapping(value = "/booking_list")
	public String bookingList(BookingVO vo, Model model) {
		// "체크인, 체크아웃, 인원" 기본값 전달
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        
        // "체크인"오늘
        String today = sdf.format(cal.getTime());
        vo.setCheckin(today);
        
        // "체크아웃" 내일
        cal.add(Calendar.DATE, 1);
        String tomorrow = sdf.format(cal.getTime());
        vo.setCheckout(tomorrow);
        
        // "인원" 1명
        vo.setPeople(1);
        
        model.addAttribute("bookingVO", vo);
		
		return "booking/bookingList";
	}
	
	// "사용자, 예약" 스위트 룸 결제
	@RequestMapping(value = "/booking_suite")
	public String bookingSuite(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid("1");
			int suiteRoom = bookingService.countBookingCheck(vo);
			
			if(suiteRoom >= 1) {
				return "booking/bookingFail";
			} else {
				// 예약자 조회
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// 룸 조회
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "사용자, 예약" 슈페리어 룸 결제
	@RequestMapping(value = "/booking_superior")
	public String bookingSuperior(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid("2");
			int suiteRoom = bookingService.countBookingCheck(vo);
			
			if(suiteRoom >= 1) {
				return "booking/bookingFail";
			} else {
				// 예약자 조회
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// 룸 조회
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "사용자, 예약" 디럭스 룸 결제
	@RequestMapping(value = "/booking_deluxe")
	public String bookingDeluxe(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid("3");
			int suiteRoom = bookingService.countBookingCheck(vo);
			
			if(suiteRoom >= 1) {
				return "booking/bookingFail";
			} else {
				// 예약자 조회
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// 룸 조회
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "사용자, 예약" 스탠다드 룸 결제
	@RequestMapping(value = "/booking_standard")
	public String bookingStandard(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid("4");
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(bookingCheck >= 1) {
				return "booking/bookingFail";
			} else {
				// 예약자 조회
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// 룸 조회
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
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
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(bookingCheck >= 1) {
				return "booking/bookingFail";
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
		if(checkin.length() != 8 || checkout.length() != 8) {
			checkin = checkSubstring(checkin);
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
	
	/*
	// "사용자, 예약" 예약 결제
	public void bookingDetail(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		// 예약자 조회
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("bookingVO", vo);
		
		// 룸 조회
		RoomVO roomVO = bookingService.getRoom(vo.getRid());
		model.addAttribute("roomVO", roomVO);
		
		String checkin = vo.getCheckin();
		String checkout = vo.getCheckout();
		
		// "체크인, 체크아웃" 문자열 출력 
		String checkin_sub = checkSubstring(checkin);
		String checkout_sub = checkSubstring(checkout);
		model.addAttribute("checkin", checkin_sub);
		model.addAttribute("checkout", checkout_sub);
		
		// "체크인, 체크아웃" 날짜 계산 
		long checkinout_cal = checkCalculation(checkin, checkout);
		model.addAttribute("checkinout_cal", checkinout_cal);

		// 객실 요금(1박 요금 * 날짜) 계산
		long roomPrice = (long)(roomVO.getPrice() * checkinout_cal);
		model.addAttribute("roomPrice", roomPrice);
		
		// 부가가치세 계산(객실요금 * 0.1)
		long vat = (long)(roomPrice * 0.1);
		model.addAttribute("vat", vat);
		
		// 총 요금 계산(객실요금 * 0.1)
		long totalPrice = (long)(roomPrice + vat);
		model.addAttribute("totalPrice", totalPrice);
	}
	*/
	
}