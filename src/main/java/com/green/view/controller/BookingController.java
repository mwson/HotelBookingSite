package com.green.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.booking.BookingService;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.MemberVO;

@Controller
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	// "사용자, 예약" 인원, 체크인, 체크아웃으로 중복 조회	
	@RequestMapping(value = "/booking_list")
	public String bookingList() {
		return "booking/bookingList";
	}
	
	// "사용자, 예약" 인원, 체크인, 체크아웃으로 중복 조회
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(@RequestParam(value = "room")String room, BookingVO vo, Model model) {
		// 방 마다 중복 조회
		int suiteRoom = 0;
		int superiorRoom = 0;
		int deluxeRoom = 0;
		int standardRoom = 0;
		
		// 날짜, 인원, 객실 조회
		model.addAttribute("bookingVO", vo);
		model.addAttribute("room", room);
		
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
	
	//"사용자, 예약" 스위트 룸 예약 상세
	@RequestMapping(value = "/booking_suite_detail")
	public String bookingSuiteDetail(HttpSession session, BookingVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			
			
			
			return "booking/bookingDetail";
		}
	}
	
	//"사용자, 예약" 스위트 룸 예약 
	@RequestMapping(value = "/booking_suite")
	public String bookingSuite(BookingVO vo) {

		
		return "booking/bookingDetail";
	}
	
}