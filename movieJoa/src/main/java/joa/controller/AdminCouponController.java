package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
      mav.addObject("nextPage","/movieJoa/listCoupon.do");
      mav.setViewName("admin/adminCoupon/msg");
      return mav;
   }
   
   @RequestMapping(value={"/listCoupon.do","/searchCoupon.do"})
   public ModelAndView listCoupon(
         @RequestParam(value="cp", defaultValue="1")int cp,
         @RequestParam(value="s_k",  defaultValue="--")String s_k,
         @RequestParam(value="s_v", defaultValue="--")String s_v) {
      int totalCnt=adminCouponService.adminCouponTotalCnt(s_k, s_v);
      int listSize=10;
      int pageSize=5;
      String pageStr=joa.page.PageModule.makePage("listCoupon.do", totalCnt, listSize, pageSize, cp);
      List<AdminCouponDTO> couponList=adminCouponService.listCoupon(cp, listSize, s_k, s_v);
      ModelAndView mav= new ModelAndView();
      mav.addObject("s_k",s_k);
      mav.addObject("s_v",s_v);
      mav.addObject("pageStr",pageStr);
      mav.addObject("couponList",couponList);
      mav.setViewName("admin/adminCoupon/adminCoupon_listCoupon");
      return mav;
   }
   
   @RequestMapping("/deleteCoupon.do")
   public ModelAndView deleteCoupon(
         @RequestParam(value="cou_idx", defaultValue="0")int cou_idx) {
      int result = adminCouponService.deleteCoupon(cou_idx);
      String msg=result>0?"해당 쿠폰 정보 삭제에 성공했습니다.":"해당 쿠폰 정보 삭제에 실패했습니다.";
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg",msg);
      mav.addObject("nextPage","/movieJoa/listCoupon.do");
      mav.setViewName("admin/adminCoupon/msg");
      return mav;
   }

   
   
      

}
