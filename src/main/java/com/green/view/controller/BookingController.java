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
	
	// "�����, ����" �ο�, üũ��, üũ�ƿ����� �ߺ� ��ȸ	
	@RequestMapping(value = "/booking_list")
	public String bookingList() {
		return "booking/bookingList";
	}
	
	// "�����, ����" �ο�, üũ��, üũ�ƿ����� �ߺ� ��ȸ
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(@RequestParam(value = "room")String room, BookingVO vo, Model model) {
		// �� ���� �ߺ� ��ȸ
		int suiteRoom = 0;
		int superiorRoom = 0;
		int deluxeRoom = 0;
		int standardRoom = 0;
		
		// ��¥, �ο�, ���� ��ȸ
		model.addAttribute("bookingVO", vo);
		model.addAttribute("room", room);
		
		// �ο� 4�� ��ȸ
		if(vo.getPeople() >= 4) {
			// ����Ʈ ��(4��), rid: 1
			// üũ��, üũ�ƿ����� �ߺ� ��ȸ
			vo.setRid("1");	
			suiteRoom = bookingService.countBookingCheck(vo);
			
			if(suiteRoom >= 1) {
				// ����Ұ�(2)
				model.addAttribute("suiteRoom", "2");
				model.addAttribute("superiorRoom", "2");
				model.addAttribute("deluxeRoom", "2");
				model.addAttribute("standardRoom", "2");
				
				return "booking/bookingList";
			} else {
				// ���డ��(1)
				model.addAttribute("suiteRoom", "1");
				model.addAttribute("superiorRoom", "2");
				model.addAttribute("deluxeRoom", "2");
				model.addAttribute("standardRoom", "2");
				
				return "booking/bookingList";
			}
		// �ο� 3�� ��ȸ			
		} if(vo.getPeople() == 3) {
			// ����Ʈ ��(4��), rid: 1
			vo.setRid("1");	
			suiteRoom = bookingService.countBookingCheck(vo);
			if(suiteRoom >= 1) {
				model.addAttribute("suiteRoom", "2");
				
				// ���丮�� ��(3��), rid: 2
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
				
				// ���丮�� ��(3��), rid: 2
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
		// �ο� 2�� ����		
		} else {
			// ����Ʈ ��(4��), rid: 1
			vo.setRid("1");	
			suiteRoom = bookingService.countBookingCheck(vo);
			if(suiteRoom >= 1) {
				model.addAttribute("suiteRoom", "2");
				
				// ���丮�� ��(3��), rid: 2
				vo.setRid("2");	
				superiorRoom = bookingService.countBookingCheck(vo);
				if(superiorRoom >= 1) {
					model.addAttribute("superiorRoom", "2");
					
					// �𷰽� ��(2��), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// ���Ĵٵ� ��(2��), rid: 4
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
						
						// ���Ĵٵ� ��(2��), rid: 4
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
					
					// �𷰽� ��(2��), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// ���Ĵٵ� ��(2��), rid: 4
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
						
						// ���Ĵٵ� ��(2��), rid: 4
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
				
				// ���丮�� ��(3��), rid: 2
				vo.setRid("2");	
				superiorRoom = bookingService.countBookingCheck(vo);
				if(superiorRoom >= 1) {
					model.addAttribute("superiorRoom", "2");
					
					// �𷰽� ��(2��), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// ���Ĵٵ� ��(2��), rid: 4
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
						
						// ���Ĵٵ� ��(2��), rid: 4
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
					
					// �𷰽� ��(2��), rid: 3
					vo.setRid("3");	
					deluxeRoom = bookingService.countBookingCheck(vo);
					if(deluxeRoom >= 1) {
						model.addAttribute("deluxeRoom", "2");
						
						// ���Ĵٵ� ��(2��), rid: 4
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
						
						// ���Ĵٵ� ��(2��), rid: 4
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
	
	//"�����, ����" ����Ʈ �� ���� ��
	@RequestMapping(value = "/booking_suite_detail")
	public String bookingSuiteDetail(HttpSession session, BookingVO vo) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			
			
			
			return "booking/bookingDetail";
		}
	}
	
	//"�����, ����" ����Ʈ �� ���� 
	@RequestMapping(value = "/booking_suite")
	public String bookingSuite(BookingVO vo) {

		
		return "booking/bookingDetail";
	}
	
}