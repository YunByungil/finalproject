package joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import joa.adminCoupon.model.AdminCouponDTO;
import joa.adminCoupon.model.AdminCouponService;

@Controller
public class AdminCouponController {
	
	@Autowired
	private AdminCouponService adminCouponService;
	
	@RequestMapping(value="/addCouponForm.do", method=RequestMethod.GET)
	public String addCoupon() {
		return "admin/adminCoupon/adminCoupon_addCoupon";
	}
	
	@RequestMapping(value="/addCoupon.do", method=RequestMethod.POST)
	public ModelAndView addCoupon(AdminCouponDTO dto) {
		int result = adminCouponService.addCoupon(dto);
		String msg=result>0?"쿠폰 등록에 성공하였습니다.":"쿠폰 등록에 실패하였습니다.";
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("admin/adminCoupon/msg");
		return mav;
		
		
	}
		
		
	
	
	

}
