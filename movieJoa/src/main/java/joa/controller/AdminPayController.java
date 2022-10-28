package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.adminPay.model.AdminPayService;
import joa.pay.model.JoaPayMovDTO;
import joa.review.model.JoaReviewDTO;

@Controller
public class AdminPayController {
	
	@Autowired
	private AdminPayService adminPayService;
	
	@RequestMapping(value={"/listAdminPay.do","/searchAdminPay.do"})
	public ModelAndView listAdminPay(
		@RequestParam(value="cp", defaultValue="1")int cp,
		@RequestParam(value="s_k",  defaultValue="--")String s_k,
		@RequestParam(value="s_v", defaultValue="--")String s_v) {
		int listSize=10;
		int pageSize=5;
		int totalCnt=adminPayService.adminPayTotalCnt(s_k, s_v);
		String pageStr=joa.page.PageModule.makePage("listAdminPay.do", totalCnt, listSize, pageSize, cp);
		List<JoaPayMovDTO> adminPayList=adminPayService.listAdminPay(cp, listSize, s_k, s_v); 
		ModelAndView mav= new ModelAndView();
		mav.addObject("s_k",s_k);
		mav.addObject("s_v",s_v);
		mav.addObject("pageStr",pageStr);
		mav.addObject("adminPayList",adminPayList);
		mav.setViewName("admin/adminPay/adminPay_listAdminPay");
		return mav;
	}
	
	@RequestMapping("/deleteAdminPay.do")
	public ModelAndView deleteAdminPay(
			@RequestParam(value="payMov_idx", defaultValue="0")int payMov_idx) {
		int result = adminPayService.deleteAdminPay(payMov_idx);
		String msg=result>0?"해당 현황 정보 삭제에 성공했습니다.":"해당 현황 정보 삭제에 실패했습니다.";
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("nextPage","/movieJoa/listAdminPay.do");
		mav.setViewName("admin/adminPay/msg");
		return mav;
	}
	
	@RequestMapping("/detailAdminPay.do")
	public ModelAndView reviewDetail(
			@RequestParam(value="payMov_idx", defaultValue="0")int payMov_idx) {
		JoaPayMovDTO dto= adminPayService.detailAdminPay(payMov_idx);
		ModelAndView mav=new ModelAndView();
		if (dto==null) {
			mav.addObject("msg","잘못된 접근입니다.");
			mav.setViewName("admin/adminPay/msg");
		}else {
			mav.addObject("dto",dto);
			mav.setViewName("admin/adminPay/adminPay_detailAdminPay");
		}
		return mav;
	}
	
	

}
