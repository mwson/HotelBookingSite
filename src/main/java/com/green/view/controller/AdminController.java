package com.green.view.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.admin.AdminService;
import com.green.biz.booking.BookingService;
import com.green.biz.dto.BookingVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.dto.QnaVO;
import com.green.biz.dto.RoomVO;
import com.green.biz.dto.SalesBooking;
import com.green.biz.dto.WorkerVO;
import com.green.biz.member.MemberService;
import com.green.biz.notice.NoticeService;
import com.green.biz.qna.QnaService;
import com.green.biz.room.RoomService;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
@SessionAttributes("adminUser")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private RoomService roomService;
	
	// "관리자" 로그인 폼 이동
	@RequestMapping(value = "/admin_login_form")
	public String adminLoginView() {
		return "admin/login";
	}
	
	// "관리자" 로그인
	@RequestMapping(value = "/admin_login")
	public String adminLogin(@RequestParam(value = "workerId")String workerId,
			@RequestParam(value = "workerPwd")String workerPwd, Model model) {
		int result = adminService.workerCheck(workerId, workerPwd);
		WorkerVO adminUser = null;
		
		if(result == 1) {
			adminUser = adminService.getEmployee(workerId);
			
			model.addAttribute("adminUser", adminUser);
			
			return "redirect:admin_booking_list";
		} else {
			if(result == 0) {
				model.addAttribute("message", "비밀번호를 확인하세요!");
			} else {
				model.addAttribute("message", "아이디를 확인하세요!");
			}
			
			return "admin/login";
		}
	}
	
	// "관리자" 로그아웃
	@RequestMapping(value = "/admin_logout")
	public String adminLogout(SessionStatus status) {
		status.setComplete();
		
		return "admin/login";
	}
	
	// "관리자" 로그아웃 및 메인 이동
	@RequestMapping(value = "/admin_logout_user_index")
	public String adminLogoutUserIndex(SessionStatus status) {
		status.setComplete();
		
		return "redirect:index";
	}
	
	// "관리자, 예약목록" 조회(검색) 및 페이징 
	@RequestMapping(value = "/admin_booking_list")
	public String adminOrderList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<BookingVO> bookingList = bookingService.adminBookingListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = bookingService.adminCountBookingList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("bookingListSize", bookingList.size());
			model.addAttribute("bookingList", bookingList);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("key", key);
			
			return "admin/booking/bookingList";
		}
	}
	
	// "관리자, 예약목록" 예약 승인
	@RequestMapping(value = "/admin_booking_approve")
	public String adminBookingApprove(HttpSession session,
			@RequestParam(value = "result")int[] bseq) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			for(int i = 0; i<bseq.length; i++) {
				bookingService.updateBookingResult(bseq[i]);
			}
			
			return "redirect:admin_booking_list";
		}
	}
	
	// "사용자, 예약" 상세 조회
	@RequestMapping(value = "/admin_booking_detail")
	public String adminBookingDetail(HttpSession session, BookingVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			BookingVO bookingVO = bookingService.getBookingDetail(vo.getBseq());
			model.addAttribute("bookingVO", bookingVO);
			
			checkSubPriceCal(bookingVO.getCheckin(), bookingVO.getCheckout(), bookingVO.getPrice(), model);
			
			return "admin/booking/bookingDetail";
		}
	}
	
	// "관리자, 예약목록" 예약 상세 승인
	@RequestMapping(value = "/admin_booking_detail_approve")
	public String adminBookingDetailApprove(HttpSession session, BookingVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			bookingService.updateBookingResult(vo.getBseq());
			
			return "redirect:admin_booking_list";
		}
	}
	
	// "관리자, 예약목록" 예약 취소
	@RequestMapping(value = "/admin_booking_detail_cancel")
	public String adminBookingDetailCancel(HttpSession session, BookingVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			bookingService.updateBookingCancel(vo.getBseq());
			
			return "redirect:admin_booking_list";
		}
	}
	
	// "관리자, 객실목록" 조회
	@RequestMapping(value = "/admin_room_list")
	public String adminRoomList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<RoomVO> roomList = roomService.adminRoomListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = roomService.adminCountRoomList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("roomListSize", roomList.size());
			model.addAttribute("roomList", roomList);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("key", key);
			
			return "admin/room/roomList";
		}
	}
	
	// "관리자, 객실목록" 상세 조회 
	@RequestMapping(value = "/admin_room_detail")
	public String adminRoomDetail(HttpSession session, RoomVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			RoomVO roomVO = roomService.getRoom(vo.getRid());
			model.addAttribute("roomVO", roomVO);
			
			return "admin/room/roomDetail";
		}
	}
	
	// "관리자, 객실목록" 수정 폼 이동 
	@RequestMapping(value = "/admin_room_update_form")
	public String adminRoomUpdateForm(HttpSession session, RoomVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			RoomVO roomVO = roomService.getRoom(vo.getRid());
			model.addAttribute("roomVO", roomVO);
			
			return "admin/room/roomUpdate";
		}
	}
	
	// "관리자, 객실목록" 수정
	@RequestMapping(value = "/admin_room_update")
	public String adminRoomUpdate(HttpSession session,
			@RequestParam(value = "room_image")MultipartFile uploadFile, RoomVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);
				
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/room_images/");			
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			
			if(vo.getUseyn() == null) {
				vo.setUseyn("n");
			}
			
			roomService.updateRoom(vo);
			
			return "redirect:admin_room_detail?rid=" + vo.getRid();
		}
	}
	
	// "관리자, 객실목록" 객실 삭제 
	@RequestMapping(value = "/admin_room_delete")
	public String adminRoomDelete(HttpSession session, RoomVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			roomService.deleteRoom(vo.getRid());
			
			return "redirect:admin_room_list";
		}
	}
	
	// "관리자, 객실목록" 등록 폼 이동
	@RequestMapping(value = "/admin_room_write_form")
	public String adminRoomWriteForm(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {			
			return "admin/room/roomWrite";
		}
	}
	
	// "관리자, 상품목록" 등록
	@RequestMapping(value = "/admin_room_write")
	public String adminRoomWrite(HttpSession session,
			@RequestParam(value = "room_image")MultipartFile uploadFile, RoomVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);
				
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/room_images/");
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			roomService.insertRoom(vo);
			
			return "redirect:admin_room_list";
		}
	}
	
	// "관리자, 예약실적" 조회
	@RequestMapping(value = "/admin_sales_record_form")
	public String adminSalesRecordForm(HttpSession session) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			return "admin/booking/salesRecords";
		}
	}
	
	// "관리자, 예약실적" 조회 및 전송(JSON 데이터 포맷 전송)
	@RequestMapping(value = "/sales_record_chart", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SalesBooking> salesRecordChart() {
		List<SalesBooking> salesList = bookingService.getBookingSales();
		
		return salesList;
	}
	
	// "관리자, 공지사항목록" 조회 및 페이징
	@RequestMapping(value = "/admin_notice_list")
	public String adminNoticeList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			List<NoticeVO> noticeList = noticeService.noticeListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = noticeService.countNoticeList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("noticeListSize", noticeList.size());
			model.addAttribute("noticeList", noticeList);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("key", key);

			return "admin/notice/noticeList";
		}
	}
	
	// "관리자, 공지사항목록" 상세 조회
	@RequestMapping(value = "/admin_notice_detail")
	public String adminNoticeDetail(HttpSession session, NoticeVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			NoticeVO noticeVO = noticeService.getNotice(vo.getNseq());

			model.addAttribute("noticeVO", noticeVO);

			return "admin/notice/noticeDetail";
		}
	}
	
	// "관리자, 공지사항목록" 등록 폼 이동
	@RequestMapping(value = "/admin_notice_write_form")
	public String adminNoticeWriteForm(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			String[] kindList = {"-----------", "프로모션", "공지사항", "이벤트"};
			
			model.addAttribute("kindList", kindList);
			
			return "admin/notice/noticeWrite";
		}
	}
	
	// "관리자, 공지사항목록" 등록
	@RequestMapping(value = "/admin_notice_write")
	public String adminBoardWrite(HttpSession session,
			@RequestParam(value = "notice_image")MultipartFile uploadFile, NoticeVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";

			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);

				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/notice_images/");		

				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			noticeService.insertNotice(vo);

			return "redirect:admin_notice_list";
		}
	}
	
	// "관리자, 공지사항목록" 수정 폼 이동
	@RequestMapping(value = "/admin_notice_update_form")
	public String adminNoticeUpdateForm(HttpSession session, NoticeVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			NoticeVO noticeVO = noticeService.getNotice(vo.getNseq());
			String[] kindList = {"-----------", "프로모션", "공지사항", "이벤트"};
			
			model.addAttribute("noticeVO", noticeVO);
			model.addAttribute("kindList", kindList);
			
			return "admin/notice/noticeUpdate";
		}
	}

	// "관리자, 공지사항목록" 수정
	@RequestMapping(value = "/admin_notice_update")
	public String adminNoticeUpdate(HttpSession session,
			@RequestParam(value = "notice_image")MultipartFile uploadFile, NoticeVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";

			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);

				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/notice_images/");		

				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			
			noticeService.updateNotice(vo);

			return "redirect:admin_notice_detail?nseq=" + vo.getNseq();
		}
	}
	
	// "관리자, 공지사항목록" 삭제
	@RequestMapping(value = "/admin_notice_delete")
	public String adminNoticeDelete(HttpSession session, NoticeVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			noticeService.deleteNotice(vo.getNseq());
			
			return "redirect:admin_notice_list";
		}
	}
	
	/*
	// "관리자, Q&A목록" 조회
	@RequestMapping(value = "/admin_qna_list")
	public String adminQnaList(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<QnaVO> qnaList = qnaService.listAllQna();
			
			model.addAttribute("qnaList", qnaList);
			
			return "admin/qna/qnaList";
		}
	}
	*/
	
	// "관리자, Q&A목록" 조회 및 페이징
	@RequestMapping(value = "/admin_qna_list")
	public String adminQnaList(HttpSession session, Criteria criteria,
		@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<QnaVO> qnaList = qnaService.adminQnaListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = qnaService.adminCountQnaList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("qnaListSize", qnaList.size());
			model.addAttribute("qnaList", qnaList);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("key", key);
			
			return "admin/qna/qnaList";
		}
	}
	
	// "관리자 Q&A" 상세 조회
	@RequestMapping(value = "/admin_qna_detail")
	public String adminQnaDetail(HttpSession session, QnaVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			QnaVO qnaVO = qnaService.getQna(vo.getQseq());
			
			model.addAttribute("qnaVO", qnaVO);
			
			return "admin/qna/qnaDetail";
		}
	}
	

	// "관리자, Q&A" 답변 등록
	@RequestMapping(value = "/admin_qna_repsave")
	public String adminQnaRepsave(HttpSession session, QnaVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			qnaService.updateQna(vo);
			
			return "redirect:admin_qna_list";
		}
	}
	
	/*
	// "관리자, 회원목록" 조회
	@RequestMapping(value = "/admin_member_list")
	public String adminMemberList(HttpSession session,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<MemberVO> memberList = memberService.listMember(key);
			
			model.addAttribute("memberList", memberList);
			
			return "admin/member/memberList";
		}
	}
	*/
	
	// "관리자, 회원목록" 조회 및 페이징
	@RequestMapping(value = "/admin_member_list")
	public String adminMemberList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<MemberVO> memberList = memberService.listMemberwithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = memberService.countMemberList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("memberListSize", memberList.size());
			model.addAttribute("memberList", memberList);
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("key", key);
			
			return "admin/member/memberList";
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