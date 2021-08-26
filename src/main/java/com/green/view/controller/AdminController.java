package com.green.view.controller;

import java.io.File;
import java.io.IOException;
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
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.dto.OrderVO;
import com.green.biz.dto.ProductVO;
import com.green.biz.dto.QnaVO;
import com.green.biz.dto.SalesQuantity;
import com.green.biz.dto.WorkerVO;
import com.green.biz.member.MemberService;
import com.green.biz.notice.NoticeService;
import com.green.biz.order.OrderService;
import com.green.biz.product.ProductService;
import com.green.biz.qna.QnaService;
import com.green.biz.utils.Criteria;
import com.green.biz.utils.PageMaker;

@Controller
@SessionAttributes("adminUser")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private MemberService memberService;
	
	// "관리자" 로그인 폼 이동
	@RequestMapping(value = "/admin_login_form")
	public String adminLoginView() {
		return "admin/login";
	}
	
	// "관리자" 로그인
	@RequestMapping(value = "/admin_login")
	public String adminLogin(@RequestParam(value = "workerId")String workerId, @RequestParam(value = "workerPwd")String workerPwd,
			Model model) {
		
		int result = adminService.workerCheck(workerId, workerPwd);
		
		if(result == 1) {
			WorkerVO adminUser = adminService.getEmployee(workerId);
			
			model.addAttribute("adminUser", adminUser);
			
			return "redirect:admin_order_list";
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
	@RequestMapping(value = "/admin_order_list")
	public String adminOrderList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<OrderVO> orderList = orderService.listOrderwithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = orderService.countOrderList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("orderList", orderList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "admin/order/orderList";
		}
	}
	
	// "관리자, 예약목록" 예약처리
	@RequestMapping(value = "/admin_order_save")
	public String admin_order_save(HttpSession session,
			@RequestParam(value = "result")int[] odseq) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			for(int i = 0; i<odseq.length; i++) {
				orderService.updateOrderResult(odseq[i]);
			}
			
			return "redirect:admin_order_list";
		}
	}
	
	// "관리자, 상품목록" 조회
	@RequestMapping(value = "/admin_product_list")
	public String adminProductList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			List<ProductVO> productList = productService.listProductWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = productService.countProductList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("productListSize", productList.size());
			model.addAttribute("productList", productList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "admin/product/productList";
		}
	}
	
	// "관리자, 상품목록" 등록 폼 이동
	@RequestMapping(value = "/admin_product_write_form")
	public String adminProductWriteView(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String[] kindList = {"Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			
			model.addAttribute("kindList", kindList);
			
			return "admin/product/productWrite";
		}
	}
	
	// "관리자, 상품목록" 등록
	@RequestMapping(value = "/admin_product_write")
	public String adminProductWrite(HttpSession session,
			@RequestParam(value = "product_image")MultipartFile uploadFile, ProductVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);
				
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			
			productService.insertProduct(vo);
			
			return "redirect:admin_product_list";
		}
	}
	
	// "관리자, 상품목록" 상세 조회 
	@RequestMapping(value = "/admin_product_detail")
	public String adminProductDetail(HttpSession session, ProductVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String[] kind = {"", "Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			
			ProductVO productVO = productService.getProduct(vo);
			model.addAttribute("productVO", productVO);
			
			int index = (Integer.parseInt(productVO.getKind()));
			model.addAttribute("kind", kind[index]);
			
			return "admin/product/productDetail";
		}
	}
	
	// "관리자, 상품목록" 삭제 
	@RequestMapping(value = "/admin_product_delete")
	public String adminProductDelete(HttpSession session, ProductVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			productService.deleteProduct(vo.getPseq());
			
			return "redirect:admin_product_list";
		}
	}

	// "관리자, 상품목록" 수정 폼 이동 
	@RequestMapping(value = "/admin_product_update_form")
	public String adminProductUpdateView(HttpSession session, ProductVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String[] kindList = {"Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			ProductVO productVO = productService.getProduct(vo);
			
			model.addAttribute("productVO", productVO);	// 화면에 전달할 상품상세정보
			model.addAttribute("kindList", kindList);
			
			return "admin/product/productUpdate";
		}
	}
	
	// "관리자, 상품목록" 수정 
	@RequestMapping(value = "/admin_product_update")
	public String adminProductUpdate(HttpSession session,
			@RequestParam(value = "product_image")MultipartFile uploadFile, ProductVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);
				
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");			
				
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
			
			if(vo.getBestyn() == null) {
				vo.setBestyn("n");
			}
			
			productService.updateProduct(vo);
			
			return "redirect:admin_product_detail?pseq=" + vo.getPseq();
		}
	}
	
	// "관리자, 예약실적" 조회
	@RequestMapping(value = "/admin_sales_record_form")
	public String adminSalesRecordForm(HttpSession session) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			return "admin/order/salesRecords";
		}
	}
	
	// "관리자, 예약실적" 조회 및 전송(JSON 데이터 포맷 전송)
	@RequestMapping(value = "/sales_record_chart", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SalesQuantity> salesRecordChart() {
		List<SalesQuantity> listSales = productService.getProductSales();
		
		return listSales;
	}
	
	// "관리자, 공지사항목록" 조회 및 페이징
	@RequestMapping(value = "/admin_notice_list")
	public String adminNoticeList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			List<NoticeVO> noticeList = noticeService.listNoticewithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria);
			
			int totalCount = noticeService.countNoticeList(key);
			pageMaker.setTotalCount(totalCount);
			
			model.addAttribute("noticeList", noticeList);
			model.addAttribute("pageMaker", pageMaker);

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

			model.addAttribute("noticeVO", noticeVO);

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
			
			model.addAttribute("qnaList", qnaList);
			model.addAttribute("pageMaker", pageMaker);
			
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
			
			model.addAttribute("memberList", memberList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "admin/member/memberList";
		}
	}
	
}