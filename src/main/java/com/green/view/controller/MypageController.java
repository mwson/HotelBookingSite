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
	
	// "�����, ��ٱ���" �߰�
	@RequestMapping(value = "/cart_insert", method = RequestMethod.POST)
	public String CartInsert(CartVO vo, Model model, HttpSession session) {
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			
			// ��ٱ��� ������ ���� ���� ȣ��
			cartService.insertCart(vo);
		}
		
		return "redirect:cart_list";
	}
	
	// "�����, ��ٱ���" ��� ��ȸ
	@RequestMapping(value = "/cart_list")
	public String CartList(HttpSession session, Model model) {
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
	
	// "�����, ��ٱ���" ����
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
						
			// �ֹ������ ǥ���� ��, �ֹ���ȣ�� ����
			model.addAttribute("oseq", oseq);
		}
		
		return "redirect:order_complete";
	}
	
	/*
	 * "�����ϱ�" ó�� (��ٱ��Ͽ��� -> ����)
	 */
	@RequestMapping(value = "/order_complete")
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
		
		return "mypage/orderComplete";
	}
	
	@RequestMapping(value = "/orderList")
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
		
		return "mypage/orderList";
	}
	
	/*
	 * "���೻�� ��" ȭ��
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
		
		return "mypage/orderList";
	}
	
	/*
	 * "ȸ������ ����" �α��� ȭ��
	 */
	@RequestMapping(value = "/mypage_login", method = RequestMethod.POST)
	public String mypageLogin(MemberVO vo, Model model) {
		int result = memberService.loginID(vo);
		MemberVO loginUser = null;
		
		if(result == 1) { // ����� ���� ����
			loginUser = memberService.getMember(vo.getId());
			
			model.addAttribute("loginUser", loginUser);
			
			return "redirect:update_member_form";
		} else {
			return "member/loginFail";		
		}
	}
	
	/*
	 * "ȸ������ ����" ȭ��
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
	 * "ȸ������ ����" ������Ʈ
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