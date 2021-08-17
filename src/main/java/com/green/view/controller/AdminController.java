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
		
		if(result == 1) { // 정상 로그인 -> 제품목록 화면으로 이동
			WorkerVO adminUser = adminService.getEmployee(workerId);
			
			model.addAttribute("adminUser", adminUser);
			
			return "redirect:admin_product_list";
		} else {
			if(result == 0) {
				model.addAttribute("message", "비밀번호를 확인하세요!");
			} else {
				model.addAttribute("message", "아이디를 확인하세요!");
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
			pageMaker.setCri(criteria); // 현재 페이지와 페이지당 항목 수 설정
			
			// 전체 게시글의 수 조회
			int totalCount = productService.countProductList(key);
			pageMaker.setTotalCount(totalCount);
			//System.out.println("페이징 정보: " + pageMaker);
			
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
	 * 상품 등록 처리
	 */
	@RequestMapping(value = "/admin_product_write")
	public String adminProductWrite(HttpSession session,
			@RequestParam(value = "product_image")MultipartFile uploadFile, ProductVO vo) {
		WorkerVO adminUser = (WorkerVO)session.getAttribute("adminUser");
		
		if(adminUser == null) {
			return "admin/main";
		} else {
			String fileName = "";
			
			if(!uploadFile.isEmpty()) {	// 화면에서 product_image 필드에 이미지가 입력된 경우
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);	// VO 객체에 이미지파일명 저장
				
				// 이미지 파일을 업로드 하기 위해 이미지 저장 실제 경로를 구한다.
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				//System.out.println("이동 이미지 경로: " + image_path);				
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);	// 상품이미지 저장 경로로 이동시킴
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
			
			//System.out.println("등록제품 = " + vo);
			
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
			model.addAttribute("productVO", productVO);	// 화면에 전달할 상품상세정보

			int index = (Integer.parseInt(productVO.getKind())); // 상품 분류코드를 읽어온다.
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
			
			model.addAttribute("productVO", productVO);	// 화면에 전달할 상품상세정보
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
			
			if(!uploadFile.isEmpty()) {	// 화면에서 product_image 필드에 이미지가 입력된 경우
				fileName = uploadFile.getOriginalFilename();
				vo.setImage(fileName);	// VO 객체에 이미지파일명 저장
				
				// 이미지 파일을 업로드 하기 위해 이미지 저장 실제 경로를 구한다.
				String image_path = session.getServletContext().getRealPath("WEB-INF/resources/product_images/");
				//System.out.println("이동 이미지 경로: " + image_path);				
				
				try {
					File file = new File(image_path + fileName);
					uploadFile.transferTo(file);	// 상품이미지 저장 경로로 이동시킴
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
			
			//System.out.println("상품정보  = " + vo);
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
	 * 주문완료 처리(입금 확인)
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
	 * 회원목록 조회 처리
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
	 * Q&A 목록 출력
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
	 * 클릭한 Qna정보 조회 출력
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
	 * QnA 관리자 답변 처리
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
	 * 상품별 판매 실적 화면 출력
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
	 * 상품별 판매 실적 데이터 조회 및 전송(JSON 데이터 포맷 전송)
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