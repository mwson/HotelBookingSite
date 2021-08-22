package com.green.view.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.cart.CartService;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.OrderVO;
import com.green.biz.member.MemberService;
import com.green.biz.order.OrderService;

@Controller
@SessionAttributes("loginUser")
public class MypageController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberService memberService;
	
	// "사용자, 장바구니" 추가
	@RequestMapping(value = "/cart_insert", method = RequestMethod.POST)
	public String CartInsert(CartVO vo, Model model, HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			
			// 장바구니 저장을 위해 서비스 호출
			cartService.insertCart(vo);
		}
		
		return "redirect:cart_list";
	}
	
	// "사용자, 장바구니" 목록 조회
	@RequestMapping(value = "/cart_list")
	public String CartList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<CartVO> cartList = cartService.listCart(loginUser.getId());
			
			// 총액 계산
			int totalPrice = 0;
			for(CartVO cart : cartList) {
				totalPrice += cart.getQuantity() * cart.getPrice2();
			}
			
			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalPrice);
		}
		
		return "mypage/cartList";
	}
	
	// "사용자, 장바구니" 삭제
	@RequestMapping(value = "/cart_delete")
	public String CartDelete(@RequestParam(value = "cseq")int[] cseq) {
		for(int i=0; i<cseq.length; i++) {
			cartService.deleteCart(cseq[i]);
		}
		
		return "redirect:cart_list";
	}
	
	@RequestMapping(value = "/order_insert")
	public String orderInsert(HttpSession session, OrderVO vo, Model model) {
		int oseq = 0;
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());	
			oseq = orderService.insertOrder(vo);
						
			// 주문목록을 표시할 때, 주문번호를 전달
			model.addAttribute("oseq", oseq);
		}
		
		return "redirect:order_complete";
	}
	
	/*
	 * "예약하기" 처리 (장바구니에서 -> 예약)
	 */
	@RequestMapping(value = "/order_complete")
	public String orderListAction(@RequestParam(value = "oseq")int oseq, HttpSession session, OrderVO vo, Model model) {
		// 세션에 저장된 로그인 정보를 읽어옴
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			vo.setOseq(oseq);
			vo.setResult("1");
			// 사용자별 미처리 주문내역 조회
			List<OrderVO> orderList = orderService.listOrderById(vo);
			
			// 주문 총액 계산
			int totalPrice = 0;
			for(OrderVO order : orderList) {
				totalPrice += order.getQuantity() * order.getPrice2();
			}
			
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
		}
		
		return "mypage/orderComplete";
	}
	
	@RequestMapping(value = "/orderList")
	public String myPageView(HttpSession session, Model model) {
		// 세션에 저장된 로그인 정보를 읽어옴
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// 사용자가 주문한 모든 주문번호를 조회
			OrderVO vo1 = new OrderVO();
			vo1.setId(loginUser.getId());
			vo1.setResult("1");
			List<Integer> oseqList = orderService.selectSeqOrdering(vo1); 
			
			// 주문요약 정보 저장 리스트 변수 생성
			List<OrderVO> orderList = new ArrayList<OrderVO>();
			
			// 모든 주문번호에 대해 주문요약정보 생성
			for(int oseq : oseqList) {
				OrderVO vo2 = new OrderVO();
				vo2.setId(loginUser.getId());
				vo2.setResult("1");
				vo2.setOseq(oseq);
				
				// 각 주문번호에 대해 주문내역 조회
				List<OrderVO> orderList2 = orderService.listOrderById(vo2);
				// 위에서 조회한 주문내역의 요약정보 생성
				OrderVO vo3 = new OrderVO();
				vo3.setIndate(orderList2.get(0).getIndate());
				vo3.setOseq(orderList2.get(0).getOseq());
				
				if(orderList2.size() > 1) {
					vo3.setPname(orderList2.get(0).getPname() + " 외 " + (orderList2.size() -1) + "건");
				} else {
					vo3.setPname(orderList2.get(0).getPname());
				}
				
				int totalPrice = 0;
				for(int i=0; i<orderList2.size(); i++) {
					totalPrice += (orderList2.get(i).getQuantity()) * (orderList2.get(i).getPrice2());
				}
				vo3.setPrice2(totalPrice);
				
				orderList.add(vo3);
			}
			model.addAttribute("title", "(진행중인 주문 내역)");
			model.addAttribute("orderList", orderList);
		}
		
		return "mypage/orderList";
	}
	
	/*
	 * "예약내역 상세" 화면
	 */
	@RequestMapping(value = "/order_detail")
	public String orderDetailView(HttpSession session, OrderVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {			
			vo.setId(loginUser.getId());
			vo.setResult("");
			
			List<OrderVO> orderList = orderService.listOrderById(vo);
			
			// 주문자 정보 생성
			OrderVO orderDetail = new OrderVO();
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setOseq(orderList.get(0).getOseq());
			orderDetail.setMname(orderList.get(0).getMname());			
			orderDetail.setResult(orderList.get(0).getResult());
			
			// 주문 합계 금액 계산
			int totalPrice = 0;
			for(int i=0; i<orderList.size(); i++) {
				totalPrice += (orderList.get(i).getQuantity()) * (orderList.get(i).getPrice2());
			}
			
			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("title", "(주문 상세 정보)");
		}
		
		return "mypage/orderDetail";
	}
	
	/*
	 * 총 주문내역 조회 처리
	 * 처리결과에 관계없이 사용자의 모든 주문을 조회
	 */
	@RequestMapping(value = "/order_all")
	public String orderAllView(HttpSession session, OrderVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// 사용자의 전체 주문 조회
			vo.setId(loginUser.getId());
			vo.setResult("");	// 처리결과를 지정하지 않음
			List<Integer> oseqList = orderService.selectSeqOrdering(vo);
			
			// 요약정보 목록 저장용 List변수
			List<OrderVO> orderList = new ArrayList<>();
			for(int oseq : oseqList) {
				// 주문목록 조회를 위한 입력 설정
				OrderVO vo2 = new OrderVO();
				vo2.setId(loginUser.getId());
				vo2.setResult("");
				vo2.setOseq(oseq);
				
				// 주문번호별 주문내역
				List<OrderVO> orderList2 = orderService.listOrderById(vo2);
				// 주문 요약정보 생성
				OrderVO vo3 = new OrderVO();
				vo3 = orderList2.get(0);
				if(orderList2.size() > 1) {
					vo3.setPname(vo3.getPname() + " 외 " + (orderList2.size() -1) + "건");
				} else {
					vo3.setPname(vo3.getPname());
				}
				
				int totalPrice = 0;
				for(OrderVO vo4 : orderList2) {
					totalPrice += vo4.getQuantity() * vo4.getPrice2();
				}
				vo3.setPrice2(totalPrice);
				
				// 주문요약정보를 요약 리스트에 저장
				orderList.add(vo3);
			}
			model.addAttribute("title", "(총 주문 내역)");
			model.addAttribute("orderList", orderList);
		}
		
		return "mypage/orderList";
	}
	
	/*
	 * "회원정보 수정" 로그인 화면
	 */
	@RequestMapping(value = "/mypage_login", method = RequestMethod.POST)
	public String mypageLogin(MemberVO vo, Model model) {
		int result = memberService.loginID(vo);
		MemberVO loginUser = null;
		
		if(result == 1) { // 사용자 인증 성공
			loginUser = memberService.getMember(vo.getId());
			
			model.addAttribute("loginUser", loginUser);
			
			return "redirect:update_member_form";
		} else {
			return "member/loginFail";		
		}
	}
	
	/*
	 * "회원정보 수정" 화면
	 */
	@RequestMapping(value = "/update_member_form", method = RequestMethod.GET)
	public String updateMemverView(HttpSession session,  Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			MemberVO memberVO = memberService.getMember(loginUser.getId());

			model.addAttribute("memberVO", memberVO);

			return "mypage/updateMember";		
		}
	}
	
	/*
	 * "회원정보 수정" 업데이트
	 */
	@RequestMapping(value = "/update_member", method = RequestMethod.POST)
	public String updateMember(HttpSession session, @RequestParam(value = "default_pwd")String default_pwd,
			@RequestParam(value = "addr1")String addr1, @RequestParam(value = "addr2")String addr2, MemberVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if(loginUser == null) {
			return "member/login";
		} else {
			if(vo.getPwd().isEmpty()) {
				vo.setPwd(default_pwd);
			}
			
			vo.setAddress(addr1 + " " + addr2);

			memberService.updateMember(vo);
			
			return "redirect:update_member_form";
		}
	}	
	
}