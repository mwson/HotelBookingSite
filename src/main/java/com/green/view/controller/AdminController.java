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
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "/admin_login_form")
	public String adminLoginView() {
		return "admin/main";
	}
	
	@RequestMapping(value = "/admin_login")
	public String adminLogin(@RequestParam(value = "workerId")String workerId, @RequestParam(value = "workerPwd")String workerPwd,
			Model model) {
		
		int result = adminService.workerCheck(workerId, workerPwd);
		
		if(result == 1) { // ���� �α��� -> ��ǰ��� ȭ������ �̵�
			WorkerVO adminUser = adminService.getEmployee(workerId);
			
			model.addAttribute("adminUser", adminUser);
			
			return "redirect:admin_product_list";
		} else {
			if(result == 0) {
				model.addAttribute("message", "��й�ȣ�� Ȯ���ϼ���!");
			} else {
				model.addAttribute("message", "���̵� Ȯ���ϼ���!");
			}
			
			return "admin/main";
		}
	}
	
	@RequestMapping(value = "/admin_logout")
	public String adminLogout(SessionStatus status) {
		status.setComplete();
		
		return "admin/main";
	}
	
	@RequestMapping(value = "/admin_product_list")
	public String adminProductList(HttpSession session, Criteria criteria,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			//List<ProductVO> productList = productService.listProduct(key);
			List<ProductVO> productList = productService.getListWithPaging(criteria, key);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(criteria); // ���� �������� �������� �׸� �� ����
			
			// ��ü �Խñ��� �� ��ȸ
			int totalCount = productService.countProductList(key);
			pageMaker.setTotalCount(totalCount);
			//System.out.println("����¡ ����: " + pageMaker);
			
			model.addAttribute("productListSize", productList.size());
			model.addAttribute("productList", productList);
			model.addAttribute("pageMaker", pageMaker);
			
			return "admin/product/productList";
		}
	}
	
	@RequestMapping(value = "/admin_product_write_form")
	public String adminProductWriteView(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			String[] kindList = {"Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			
			model.addAttribute("kindList", kindList);
			
			return "admin/product/productWrite";
		}
	}
	
	/*
	 * ��ǰ ��� ó��
	 */
	@RequestMapping(value = "/admin_product_write")
	public String adminProductWrite(HttpSession session,
			@RequestParam(value = "product_image")MultipartFile uploadFile, ProductVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {	// ȭ�鿡�� product_image �ʵ忡 �̹����� �Էµ� ���
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);	// VO ��ü�� �̹������ϸ� ����
				
				// �̹��� ������ ���ε� �ϱ� ���� �̹��� ���� ���� ��θ� ���Ѵ�.
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				//System.out.println("�̵� �̹��� ���: " + image_path);				
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);	// ��ǰ�̹��� ���� ��η� �̵���Ŵ
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			
			//System.out.println("�����ǰ = " + vo);
			
			productService.insertProduct(vo);
			
			return "redirect:admin_product_list";
		}
	}
	
	@RequestMapping(value = "/admin_product_detail")
	public String adminProductDetail(HttpSession session, ProductVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			String[] kind = {"", "Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			
			ProductVO productVO = productService.getProduct(vo);
			model.addAttribute("productVO", productVO);	// ȭ�鿡 ������ ��ǰ������

			int index = (Integer.parseInt(productVO.getKind())); // ��ǰ �з��ڵ带 �о�´�.
			model.addAttribute("kind", kind[index]);
			
			return "admin/product/productDetail";
		}
	}
	
	@RequestMapping(value = "/admin_product_update_form")
	public String adminProductUpdateView(HttpSession session, ProductVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			String[] kindList = {"Heels", "Boots", "Sandals", "Slipers", "Sneekers", "Sale"};
			ProductVO productVO = productService.getProduct(vo);
			
			model.addAttribute("productVO", productVO);	// ȭ�鿡 ������ ��ǰ������
			model.addAttribute("kindList", kindList);
			
			return "admin/product/productUpdate";
		}
	}
	
	@RequestMapping(value = "/admin_product_update")
	public String adminProductUpdate(HttpSession session,
			@RequestParam(value = "product_image")MultipartFile uploadFile, ProductVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {	// ȭ�鿡�� product_image �ʵ忡 �̹����� �Էµ� ���
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);	// VO ��ü�� �̹������ϸ� ����
				
				// �̹��� ������ ���ε� �ϱ� ���� �̹��� ���� ���� ��θ� ���Ѵ�.
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				//System.out.println("�̵� �̹��� ���: " + image_path);				
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);	// ��ǰ�̹��� ���� ��η� �̵���Ŵ
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
			
			//System.out.println("��ǰ����  = " + vo);
			productService.updateProduct(vo);
			
			return "redirect:admin_product_detail?pseq=" + vo.getPseq();
		}
	}
	
	@RequestMapping(value = "/admin_order_list")
	public String adminOrderList(HttpSession session,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			List<OrderVO> orderList = orderService.listOrder(key);
			
			model.addAttribute("orderList", orderList);
			
			return "admin/order/orderList";
		}
	}
	
	/*
	 * �ֹ��Ϸ� ó��(�Ա� Ȯ��)
	 */
	@RequestMapping(value = "/admin_order_save")
	public String admin_order_save(HttpSession session,
			@RequestParam(value = "result")int[] odseq) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			for(int i = 0; i<odseq.length; i++) {
				orderService.updateOrderResult(odseq[i]);
			}
			
			return "redirect:admin_order_list";
		}
	}
	
	/*
	 * ȸ����� ��ȸ ó��
	 */
	@RequestMapping(value = "/admin_member_list")
	public String adminMemberList(HttpSession session,
			@RequestParam(value = "key", defaultValue = "")String key, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			List<MemberVO> memberList = memberService.listMember(key);
			
			model.addAttribute("memberList", memberList);
			
			return "admin/member/memberList";
		}
	}
	
	/*
	 * Q&A ��� ���
	 */
	@RequestMapping(value = "/admin_qna_list")
	public String adminQnaList(HttpSession session, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			List<QnaVO> qnaList = qnaService.listAllQna();
			
			model.addAttribute("qnaList", qnaList);
			
			return "admin/qna/qnaList";
		}
	}
	
	/*
	 * Ŭ���� Qna���� ��ȸ ���
	 */
	@RequestMapping(value = "/admin_qna_detail")
	public String adminQnaDetail(HttpSession session, QnaVO vo, Model model) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			QnaVO qnaVO = qnaService.getQna(vo.getQseq());
			
			model.addAttribute("qnaVO", qnaVO);
			
			return "admin/qna/qnaDetail";
		}
	}
	
	/*
	 * QnA ������ �亯 ó��
	 */
	@RequestMapping(value = "/admin_qna_repsave")
	public String adminQnaRepsave(HttpSession session, QnaVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			qnaService.updateQna(vo);
			
			return "redirect:admin_qna_list";
		}
	}
	
	/*
	 * ��ǰ�� �Ǹ� ���� ȭ�� ���
	 */
	@RequestMapping(value = "/admin_sales_record_form")
	public String adminSalesRecordForm(HttpSession session) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			return "admin/order/salesRecords";
		}
	}
	
	/*
	 * ��ǰ�� �Ǹ� ���� ������ ��ȸ �� ����(JSON ������ ���� ����)
	 */
	@RequestMapping(value = "/sales_record_chart", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<SalesQuantity> salesRecordChart() {
		List<SalesQuantity> listSales = productService.getProductSales();
		
		for(SalesQuantity item : listSales) {
			System.out.println(item);
		}
		
		return listSales;
	}
	
}