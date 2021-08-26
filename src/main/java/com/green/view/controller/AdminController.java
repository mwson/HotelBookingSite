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
	
	// "������" �α��� �� �̵�
	@RequestMapping(value = "/admin_login_form")
	public String adminLoginView() {
		return "admin/login";
	}
	
	// "������" �α���
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
				model.addAttribute("message", "��й�ȣ�� Ȯ���ϼ���!");
			} else {
				model.addAttribute("message", "���̵� Ȯ���ϼ���!");
			}
			
			return "admin/login";
		}
	}
	
	// "������" �α׾ƿ�
	@RequestMapping(value = "/admin_logout")
	public String adminLogout(SessionStatus status) {
		status.setComplete();
		
		return "admin/login";
	}
	
	// "������" �α׾ƿ� �� ���� �̵�
	@RequestMapping(value = "/admin_logout_user_index")
	public String adminLogoutUserIndex(SessionStatus status) {
		status.setComplete();
		
		return "redirect:index";
	}
	
	// "������, ������" ��ȸ(�˻�) �� ����¡ 
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
	
	// "������, ������" ����ó��
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
	
	// "������, ��ǰ���" ��ȸ
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
	
	// "������, ��ǰ���" ��� �� �̵�
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
	
	// "������, ��ǰ���" ���
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
	
	// "������, ��ǰ���" �� ��ȸ 
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
	
	// "������, ��ǰ���" ���� 
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

	// "������, ��ǰ���" ���� �� �̵� 
	@RequestMapping(value = "/admin_product_update_form")
	public String adminProductUpdateView(HttpSession session, ProductVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			String[] kindList = {"Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			ProductVO productVO = productService.getProduct(vo);
			
			model.addAttribute("productVO", productVO);	// ȭ�鿡 ������ ��ǰ������
			model.addAttribute("kindList", kindList);
			
			return "admin/product/productUpdate";
		}
	}
	
	// "������, ��ǰ���" ���� 
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
	
	// "������, �������" ��ȸ
	@RequestMapping(value = "/admin_sales_record_form")
	public String adminSalesRecordForm(HttpSession session) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/login";
		} else {
			return "admin/order/salesRecords";
		}
	}
	
	// "������, �������" ��ȸ �� ����(JSON ������ ���� ����)
	@RequestMapping(value = "/sales_record_chart", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SalesQuantity> salesRecordChart() {
		List<SalesQuantity> listSales = productService.getProductSales();
		
		return listSales;
	}
	
	// "������, �������׸��" ��ȸ �� ����¡
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
	
	// "������, �������׸��" �� ��ȸ
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
	
	// "������, �������׸��" ��� �� �̵�
	@RequestMapping(value = "/admin_notice_write_form")
	public String adminNoticeWriteForm(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");

		if(adminUser == null) {
			return "admin/login";
		} else {
			return "admin/notice/noticeWrite";
		}
	}
	
	// "������, �������׸��" ���
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
	
	// "������, �������׸��" ���� �� �̵�
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

	// "������, �������׸��" ����
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
	
	// "������, �������׸��" ����
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
	// "������, Q&A���" ��ȸ
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
	
	// "������, Q&A���" ��ȸ �� ����¡
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
	
	// "������ Q&A" �� ��ȸ
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
	

	// "������, Q&A" �亯 ���
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
	// "������, ȸ�����" ��ȸ
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
	
	// "������, ȸ�����" ��ȸ �� ����¡
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