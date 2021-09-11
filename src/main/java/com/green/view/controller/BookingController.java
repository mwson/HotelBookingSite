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
	
	// "�����, ����(�����ϱ�)" ���� �˻�
	@RequestMapping(value = "/booking_search")
	public String bookingSearch(BookingVO vo, Model model) {
		// �ߺ� ��ȸ
		bookingCheck(vo, model);
		
		// "���Ǹ��" ��ȸ
		roomList(model);		
		
		return "booking/bookingSearch";
	}
	
	// "�����, �����ϱ�(��ư)" Ŭ������ �̵�
	@RequestMapping(value = "/booking_button")
	public String bookingButton(BookingVO vo, Model model) {
		// "üũ��, üũ�ƿ�, �ο�" �⺻�� ����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        
        // "üũ��" ���ó�¥(�⺻ ��)
        String today = sdf.format(cal.getTime());
        vo.setCheckin(today);
        
        // "üũ�ƿ�" ���ϳ�¥(�⺻ ��)
        cal.add(Calendar.DATE, 1);
        String tomorrow = sdf.format(cal.getTime());
        vo.setCheckout(tomorrow);
        
        // "�ο�" 1��(�⺻ ��)
        vo.setPeople(1);
        
        // "����" �ߺ� ��ȸ
        bookingCheck(vo, model);
		
        // "���Ǹ��" ��ȸ
     	roomList(model);
        
     	return "booking/bookingSearch";
	}
	
	@RequestMapping(value = "/booking_fail")
	public String bookingFail(@RequestParam(value = "roomRid")int roomRid, BookingVO vo) {
		// ���� id
		vo.setRid(roomRid);
		// ���� ������� Ȯ��(��� : "y", �Ұ��� : "n")
		RoomVO roomUseyn = roomService.getRoom(vo.getRid());
		// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
		int peopleCheck = roomService.countPeopleList(vo);
		// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
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
	
	// "�����, ����" �����ϱ�
	@RequestMapping(value = "/booking")
	public String booking(HttpSession session, @RequestParam(value = "roomRid")int roomRid, BookingVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// ���� id
			vo.setRid(roomRid);
			// ���� ������� Ȯ��(��� : "y", �Ұ��� : "n")
			RoomVO roomUseyn = roomService.getRoom(vo.getRid());
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			int peopleCheck = roomService.countPeopleList(vo);
			// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(roomUseyn.getUseyn().equals("n")) {
				return "booking/bookingCheckFail1";
			} else if(peopleCheck == 0) {
				return "booking/bookingCheckFail2";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail3";
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
			// ���� ������� Ȯ��(��� : "y", �Ұ��� : "n")
			RoomVO roomUseyn = roomService.getRoom(vo.getRid());
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			int peopleCheck = roomService.countPeopleList(vo);
			// üũ��, üũ�ƿ�, ���Ƿ� �ߺ� Ȯ��(0: ����, 1: �Ұ���)
			int bookingCheck = bookingService.countBookingCheck(vo);
			
			if(roomUseyn.getUseyn().equals("n")) {
				return "booking/bookingCheckFail1";
			} else if(peopleCheck == 0) {
				return "booking/bookingCheckFail2";
			} else if(bookingCheck >= 1) {
				return "booking/bookingCheckFail3";
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
	 * ���
	 */
	// "�����, ����(�����ϱ�)" �ο�, üũ��, üũ�ƿ����� �ߺ� ��ȸ
	public void bookingCheck(BookingVO vo, Model model) {
		// ���� ��
		int roomCount = roomService.countRoomList(); 
		// ���� ��ȣ
		int[] roomRid = new int[roomCount];
		// ���� �ο� Ȯ��
		int[] peopleCheck = new int[roomCount];

		for(int i=0; i<roomCount; i++) {
			// ���Ƿ� �ߺ� Ȯ�� (jsp���� 0: ����, 1: �Ұ���)
			int bookingCheck = 1;
			// ���� ��ȣ ����
			vo.setRid(i + 1);
			// ���� ��ȣ
			roomRid[i] = i + 1;
			// ���� ������� Ȯ��(��� : "y", �Ұ��� : "n")
			RoomVO roomUseyn = roomService.getRoom(vo.getRid());
			// ���� �ο� Ȯ��(0: �Ұ���, 1: ����)
			peopleCheck[i] = roomService.countPeopleList(vo);
			
			// ���� ������� Ȯ��(��� : "y")
			if(roomUseyn.getUseyn().equals("y")) {
				// �ο����� �Խ� ����(1)
				if(peopleCheck[i] >= 1) {
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
					model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
				}
			// ���� ������� Ȯ��(�̻�� : "n")
			} else {				
				model.addAttribute(("bookingRid" + (roomRid[i])), bookingCheck);
			}
		}
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