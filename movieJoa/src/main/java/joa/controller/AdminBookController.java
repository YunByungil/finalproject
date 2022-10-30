package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.paymovie.model.*;

@Controller
public class AdminBookController {

	@RequestMapping(value = "/theaterPay.do", method = RequestMethod.POST)
	public ModelAndView theaterPayForm(PayMovieDTO dto,
			@RequestParam(value = "payMov_sch_seat2", required = false)String payMov_sch_seat2) {
		ModelAndView mav = new ModelAndView();
		if (payMov_sch_seat2 == null || payMov_sch_seat2.equals("")) {
			System.out.println("가격 : "+dto.getPayMov_price());
			mav.addObject("idx", dto.getPayMov_the_idx());
			mav.addObject("title", dto.getPayMov_mov_title());
			mav.addObject("branch", dto.getPayMov_the_branch());
			mav.addObject("city", dto.getPayMov_the_city());
			mav.addObject("day", dto.getPayMov_sch_day());
			mav.addObject("theater", dto.getPayMov_sch_theater());
			mav.addObject("seat", dto.getPayMov_sch_seat());
			mav.addObject("price", dto.getPayMov_price());
			mav.addObject("hour", dto.getPayMov_sch_start_hour());
			mav.addObject("min", dto.getPayMov_sch_start_min());
		}else {
			System.out.println("가격 : "+dto.getPayMov_price());
			mav.addObject("idx", dto.getPayMov_the_idx());
			mav.addObject("title", dto.getPayMov_mov_title());
			mav.addObject("branch", dto.getPayMov_the_branch());
			mav.addObject("city", dto.getPayMov_the_city());
			mav.addObject("day", dto.getPayMov_sch_day());
			mav.addObject("theater", dto.getPayMov_sch_theater());
			mav.addObject("seat", dto.getPayMov_sch_seat());
			mav.addObject("seat2"," | "+payMov_sch_seat2);
			mav.addObject("price", dto.getPayMov_price());
			mav.addObject("hour", dto.getPayMov_sch_start_hour());
			mav.addObject("min", dto.getPayMov_sch_start_min());
		}
		
		mav.setViewName("joaBook/joaBook_pay");
		return mav;
	}
}
