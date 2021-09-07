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
	
	// "�����, ����(�����ϱ�)" ���� �˻�
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(BookingVO vo, Model model) {
		// �ߺ� ��ȸ
		String url = bookingCheck(vo, model);
		//String url = bookingCheck2(vo, model);
		
		// "���Ǹ��" ��ȸ
		roomList(model);		
		
		return url;
	}
	
	// "�����, �����ϱ�(��ư)" Ŭ������ �̵�
	@RequestMapping(value = "/booking_button")
	public String bookingButton(BookingVO vo, Model model) {
		// "üũ��, üũ�ƿ�, �ο�" �⺻�� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        
        // "üũ��" ����
        String today = sdf.format(cal.getTime());
        vo.setCheckin(today);
        
        // "üũ�ƿ�" ����
        cal.add(Calendar.DATE, 1);
        String tomorrow = sdf.format(cal.getTime());
        vo.setCheckout(tomorrow);
        
        // "�ο�" 1��
        vo.setPeople(1);
        // �ߺ� ��ȸ
        String url = bookingCheck(vo, model);
		
        // "���Ǹ��" ��ȸ
     	roomList(model);
        
		return url;
	}
	
	// "�����, ����" rid1(����Ʈ ��) ����
	@RequestMapping(value = "/booking_rid1")
	public String bookingSuite(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid(1);
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			int peopleCheck = roomService.userCountPeopleList(vo);
			// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(peopleCheck == 0) {
				return "booking/bookingCheckFail1";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail2";
			} else {
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = roomService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" rid2(���丮�� ��) ����
	@RequestMapping(value = "/booking_rid2")
	public String bookingSuperior(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid(2);
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			int peopleCheck = roomService.userCountPeopleList(vo);
			// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(peopleCheck == 0) {
				return "booking/bookingCheckFail1";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail2";
			} else {
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = roomService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" rid3(�𷰽� ��) ����
	@RequestMapping(value = "/booking_rid3")
	public String bookingDeluxe(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid(3);
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			int peopleCheck = roomService.userCountPeopleList(vo);
			// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(peopleCheck == 0) {
				return "booking/bookingCheckFail1";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail2";
			} else {
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = roomService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				
				return "booking/bookingPayment";
			}
		}
	}
	
	// "�����, ����" rid4(���Ĵٵ� ��) ����
	@RequestMapping(value = "/booking_rid4")
	public String bookingStandard(HttpSession session, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setRid(4);
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			int peopleCheck = roomService.userCountPeopleList(vo);
			System.out.println(peopleCheck);
			// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
			int bookingCheck = bookingService.countBookingCheck(vo);
			 
			if(peopleCheck == 0) {
				return "booking/bookingCheckFail1";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail2";
			} else {
				// ������ ��ȸ
				model.addAttribute("loginUser", loginUser);
				model.addAttribute("bookingVO", vo);
				
				// �� ��ȸ
				RoomVO roomVO = roomService.getRoom(vo.getRid());
				model.addAttribute("roomVO", roomVO);
				
				checkSubPriceCal(vo.getCheckin(), vo.getCheckout(), roomVO.getPrice(), model);
				
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
	// "�����, ����(�����ϱ�)" �ο�, üũ��, üũ�ƿ����� �ߺ� ��ȸ
	public String bookingCheck(BookingVO vo, Model model) {
		// ���� ��ȣ(�� 4��)
		int[] roomRid = new int[4];
		// ���� �ο� Ȯ��(�� 4��)
		int[] roomCheck = new int[4];
		// ���Ƿ� �ߺ� Ȯ�� (jsp������ 0: ����, 1: �Ұ���)
		int bookingCheck = 1;
		
		for(int i=0; i<roomRid.length; i++) {
			vo.setRid(i + 1);
			// ���� ��ȣ(1, 2, 3, 4)
			roomRid[i] = i + 1;
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			roomCheck[i] = roomService.userCountPeopleList(vo);
			
			// �ο����� �Խ� ����(1)
			if(roomCheck[i] >= 1) {
				vo.setRid(roomRid[i]);
				// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
				bookingCheck = bookingService.countBookingCheck(vo);
				
				// üũ��, üũ�ƿ�, ���Ƿ� �Խ� �Ұ���(1)
				if(bookingCheck >= 1) {
					model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
				// üũ��, üũ�ƿ�, ���Ƿ� �Խ� ����(0)
				} else {
					model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
				}
			// �ο����� �Խ� �Ұ���(0)
			} else {
				// jsp������ 0: ����, 1: �Ұ���
				bookingCheck = 1;
				
				model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
			}
		}

		return "booking/bookingSearch";
	}
	
	// "���Ǹ��" ��ȸ
	public void roomList(Model model) {
		RoomVO[] roomRid = new RoomVO[4];
		
		for(int i=0; i<roomRid.length; i++) {
			roomRid[i] = roomService.getRoom(i + 1);

			model.addAttribute(("roomRid" + (i + 1)), roomRid[i]);
		}
	}
	
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
		if(checkin.length() != 8) {
			checkin = checkSubstring(checkin);
		}
		if(checkout.length() != 8) {
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
	
}