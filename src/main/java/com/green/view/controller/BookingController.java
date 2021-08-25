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
		
	// "�����, ����(�����ϱ�)" �ο�, üũ��, üũ�ƿ����� �ߺ� ��ȸ
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(BookingVO vo, Model model) {
		// �� ���� �ߺ� ��ȸ
		int suiteRoom = 0;
		int superiorRoom = 0;
		int deluxeRoom = 0;
		int standardRoom = 0;
		
		// ��¥, �ο�, ���� ��ȸ
		model.addAttribute("bookingVO", vo);
		
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
	
	// "�����" �����ϱ� ȭ�� �̵�	
	@RequestMapping(value = "/booking_list")
	public String bookingList(BookingVO vo, Model model) {
		// "üũ��, üũ�ƿ�, �ο�" �⺻�� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        
        // "üũ��"����
        String today = sdf.format(cal.getTime());
        vo.setCheckin(today);
        
        // "üũ�ƿ�" ����
        cal.add(Calendar.DATE, 1);
        String tomorrow = sdf.format(cal.getTime());
        vo.setCheckout(tomorrow);
        
        // "�ο�" 1��
        vo.setPeople(1);
        
        model.addAttribute("bookingVO", vo);
		
		return "booking/bookingList";
	}
	
	// "�����, ����" ����Ʈ �� ����
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
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" ���丮�� �� ����
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
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" �𷰽� �� ����
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
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" ���Ĵٵ� �� ����
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
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = bookingService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				//bookingDetail(session, vo, model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" ����Ϸ�
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
				// vo.getBseq()�� bseq�� ��ȯ
				bookingService.insertBooking(vo);
				
				BookingVO bookingVO = bookingService.getBooking(vo.getBseq());
				model.addAttribute("bookingVO", bookingVO);

				checkSubPriceCal(bookingVO.getCheckin(), bookingVO.getCheckout(), bookingVO.getPrice(), model);
	
				return "booking/bookingComplete";
			}
		}
	}
	
	
	/*
	 * ���ȭ
	 */
	// "üũ��, üũ�ƿ�" (yyyyMMdd) �ڸ���
	public String checkSubstring(String checkinout) {		
		String yyyy = checkinout.substring(0, 4);
		String MM = checkinout.substring(5, 7);
		String dd = checkinout.substring(8, 10);
		
		String checkinout_sub = (yyyy + "" + MM + "" + dd + "");
		
		return checkinout_sub;
	}
	
	// "üũ��, üũ�ƿ�" (��, ��, ��) ��ȯ
	public String checkConversion(String checkinout) {
		String yyyy = checkinout.substring(0, 4);
		String MM = checkinout.substring(4, 6);
		String dd = checkinout.substring(6);
		
		String checkinout_con = (yyyy + "�� " + MM + "�� " + dd + "��");
		
		return checkinout_con;
	}
	
	// "üũ��, üũ�ƿ�" ��¥ ��� 
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
	
	// "���ڿ�, ���" ��� �� ��� 
	public void checkSubPriceCal(String checkin, String checkout, int dayPrice, Model model) {
		// "üũ��, üũ�ƿ�" (yyyyMMdd) �ڸ���
		if(checkin.length() != 8 || checkout.length() != 8) {
			checkin = checkSubstring(checkin);
			checkout = checkSubstring(checkout);
		}
		
		// "üũ��, üũ�ƿ�" (��, ��, ��) ��ȯ
		String checkin_con = checkConversion(checkin);
		String checkout_con = checkConversion(checkout);
		model.addAttribute("checkin", checkin_con);
		model.addAttribute("checkout", checkout_con);
		
		// "üũ��, üũ�ƿ�" ��¥ ��� 
		long checkinout_cal = checkCalculation(checkin, checkout);
		model.addAttribute("checkinout_cal", checkinout_cal);
		
		// ���� ���(1�� ��� * ��¥) ���
		long roomPrice = (long)(dayPrice * checkinout_cal);
		model.addAttribute("roomPrice", roomPrice);
		
		// �ΰ���ġ�� ���(���ǿ�� * 0.1)
		long vat = (long)(roomPrice * 0.1);
		model.addAttribute("vat", vat);
		
		// �� ��� ���(���ǿ�� * 0.1)
		long totalPrice = (long)(roomPrice + vat);
		model.addAttribute("totalPrice", totalPrice);		
	}
	
	/*
	// "�����, ����" ���� ����
	public void bookingDetail(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		// ������ ��ȸ
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("bookingVO", vo);
		
		// �� ��ȸ
		RoomVO roomVO = bookingService.getRoom(vo.getRid());
		model.addAttribute("roomVO", roomVO);
		
		String checkin = vo.getCheckin();
		String checkout = vo.getCheckout();
		
		// "üũ��, üũ�ƿ�" ���ڿ� ��� 
		String checkin_sub = checkSubstring(checkin);
		String checkout_sub = checkSubstring(checkout);
		model.addAttribute("checkin", checkin_sub);
		model.addAttribute("checkout", checkout_sub);
		
		// "üũ��, üũ�ƿ�" ��¥ ��� 
		long checkinout_cal = checkCalculation(checkin, checkout);
		model.addAttribute("checkinout_cal", checkinout_cal);

		// ���� ���(1�� ��� * ��¥) ���
		long roomPrice = (long)(roomVO.getPrice() * checkinout_cal);
		model.addAttribute("roomPrice", roomPrice);
		
		// �ΰ���ġ�� ���(���ǿ�� * 0.1)
		long vat = (long)(roomPrice * 0.1);
		model.addAttribute("vat", vat);
		
		// �� ��� ���(���ǿ�� * 0.1)
		long totalPrice = (long)(roomPrice + vat);
		model.addAttribute("totalPrice", totalPrice);
	}
	*/
	
}