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

import com.green.biz.cart.CartService;
import com.green.biz.dto.AddressVO;
import com.green.biz.dto.CartVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.OrderVO;
import com.green.biz.member.MemberService;
import com.green.biz.order.OrderService;

@Controller
public class MypageController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/cart_insert", method = RequestMethod.POST)
	public String CartInsert(CartVO vo, Model model, HttpSession session) {
		// ���ǿ� ����� ����� ������ �о�´�.
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) { // ���� �α��� �ȵ� ������
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			
			// ��ٱ��� ������ ���� ���� ȣ��
			cartService.insertCart(vo);
		}
		
		return "redirect:cart_list";	// ��ٱ��� ����� ��ȸ�Ͽ� ��ٱ��� ��� ȭ�� ǥ��
	}
	
	@RequestMapping(value = "/cart_list")
	public String CartList(HttpSession session, Model model) {
		// ���ǿ� ����� �α��� ������ �о��
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			List<CartVO> cartList = cartService.listCart(loginUser.getId());
			
			// �Ѿ� ���
			int totalPrice = 0;
			for(CartVO cart : cartList) {
				totalPrice += cart.getQuantity() * cart.getPrice2();
			}
			
			model.addAttribute("cartList", cartList);
			model.addAttribute("totalPrice", totalPrice);
		}
		
		return "mypage/cartList";
	}
	
	@RequestMapping(value = "/cart_delete")
	public String CartDelete(@RequestParam(value = "cseq")int[] cseq) {
		for(int i=0; i<cseq.length; i++) {
			System.out.println("������ cart seq = " + cseq[i]);
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
						
			// �ֹ������ ǥ���� ��, �ֹ���ȣ�� ����
			model.addAttribute("oseq", oseq);
		}
		
		return "redirect:order_list";
	}
	
	/*
	 * �ֹ����� ���
	 */
	@RequestMapping(value = "/order_list")
	public String orderListAction(@RequestParam(value = "oseq")int oseq, HttpSession session, OrderVO vo, Model model) {
		// ���ǿ� ����� �α��� ������ �о��
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			vo.setOseq(oseq);
			vo.setResult("1");
			// ����ں� ��ó�� �ֹ����� ��ȸ
			List<OrderVO> orderList = orderService.listOrderById(vo);
			
			// �ֹ� �Ѿ� ���
			int totalPrice = 0;
			for(OrderVO order : orderList) {
				totalPrice += order.getQuantity() * order.getPrice2();
			}
			
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
		}
		
		return "mypage/orderList";
	}
	
	@RequestMapping(value = "/mypage")
	public String myPageView(HttpSession session, Model model) {
		// ���ǿ� ����� �α��� ������ �о��
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// ����ڰ� �ֹ��� ��� �ֹ���ȣ�� ��ȸ
			OrderVO vo1 = new OrderVO();
			vo1.setId(loginUser.getId());
			vo1.setResult("1");
			List<Integer> oseqList = orderService.selectSeqOrdering(vo1); 
			
			// �ֹ���� ���� ���� ����Ʈ ���� ����
			List<OrderVO> orderList = new ArrayList<OrderVO>();
			
			// ��� �ֹ���ȣ�� ���� �ֹ�������� ����
			for(int oseq : oseqList) {
				OrderVO vo2 = new OrderVO();
				vo2.setId(loginUser.getId());
				vo2.setResult("1");
				vo2.setOseq(oseq);
				
				// �� �ֹ���ȣ�� ���� �ֹ����� ��ȸ
				List<OrderVO> orderList2 = orderService.listOrderById(vo2);
				// ������ ��ȸ�� �ֹ������� ������� ����
				OrderVO vo3 = new OrderVO();
				vo3.setIndate(orderList2.get(0).getIndate());
				vo3.setOseq(orderList2.get(0).getOseq());
				
				if(orderList2.size() > 1) {
					vo3.setPname(orderList2.get(0).getPname() + " �� " + (orderList2.size() -1) + "��");
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
			model.addAttribute("title", "(�������� �ֹ� ����)");
			model.addAttribute("orderList", orderList);
		}
		
		return "mypage/mypage";
	}
	
	@RequestMapping(value = "/order_detail")
	public String orderDetailView(HttpSession session, OrderVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {			
			vo.setId(loginUser.getId());
			vo.setResult("");
			
			List<OrderVO> orderList = orderService.listOrderById(vo);
			
			// �ֹ��� ���� ����
			OrderVO orderDetail = new OrderVO();
			orderDetail.setIndate(orderList.get(0).getIndate());
			orderDetail.setOseq(orderList.get(0).getOseq());
			orderDetail.setMname(orderList.get(0).getMname());			
			orderDetail.setResult(orderList.get(0).getResult());
			
			// �ֹ� �հ� �ݾ� ���
			int totalPrice = 0;
			for(int i=0; i<orderList.size(); i++) {
				totalPrice += (orderList.get(i).getQuantity()) * (orderList.get(i).getPrice2());
			}
			
			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("orderList", orderList);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("title", "(�ֹ� �� ����)");
		}
		
		return "mypage/orderDetail";
	}
	
	/*
	 * �� �ֹ����� ��ȸ ó��
	 * ó������� ������� ������� ��� �ֹ��� ��ȸ
	 */
	@RequestMapping(value = "/order_all")
	public String orderAllView(HttpSession session, OrderVO vo, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			// ������� ��ü �ֹ� ��ȸ
			vo.setId(loginUser.getId());
			vo.setResult("");	// ó������� �������� ����
			List<Integer> oseqList = orderService.selectSeqOrdering(vo);
			
			// ������� ��� ����� List����
			List<OrderVO> orderList = new ArrayList<>();
			for(int oseq : oseqList) {
				// �ֹ���� ��ȸ�� ���� �Է� ����
				OrderVO vo2 = new OrderVO();
				vo2.setId(loginUser.getId());
				vo2.setResult("");
				vo2.setOseq(oseq);
				
				// �ֹ���ȣ�� �ֹ�����
				List<OrderVO> orderList2 = orderService.listOrderById(vo2);
				// �ֹ� ������� ����
				OrderVO vo3 = new OrderVO();
				vo3 = orderList2.get(0);
				if(orderList2.size() > 1) {
					vo3.setPname(vo3.getPname() + " �� " + (orderList2.size() -1) + "��");
				} else {
					vo3.setPname(vo3.getPname());
				}
				
				int totalPrice = 0;
				for(OrderVO vo4 : orderList2) {
					totalPrice += vo4.getQuantity() * vo4.getPrice2();
				}
				vo3.setPrice2(totalPrice);
				
				// �ֹ���������� ��� ����Ʈ�� ����
				orderList.add(vo3);
			}
			model.addAttribute("title", "(�� �ֹ� ����)");
			model.addAttribute("orderList", orderList);
		}
		
		return "mypage/mypage";
	}
	
	@RequestMapping(value = "/update_member", method = RequestMethod.GET)
	public String updateMemverView(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			model.addAttribute("loginUser", loginUser);			
		}
		return "mypage/updateMember";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateMember(@RequestParam(value = "addr1")String addr1, MemberVO vo, Model model) {
		vo.setAddress(addr1);
		memberService.updateMember(vo);
		String id = vo.getId();
		MemberVO memberVO = new MemberVO();
		memberVO = memberService.getMember(id);
		model.addAttribute("loginUser", memberVO);		
		
		return "mypage/mypage";
	}	
		
	@RequestMapping(value = "/match_pwd", method = RequestMethod.GET)
	public String matchPassword(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		String OriginPwd = loginUser.getPwd();
		model.addAttribute("originPwd", OriginPwd);
		return "mypage/matchPassword";
	}
	
	@RequestMapping(value = "/password_check", method = RequestMethod.GET)
	public String passwordCheck() {	
		return "mypage/updateMember";		
	}

	
}
