package joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.adminRevenue.model.JoaAdminPayMovieDAO;
import joa.adminRevenue.model.JoaAdminPayProductDAO;

@Controller
public class AdminRevenueController {
	
	@Autowired
	private JoaAdminPayMovieDAO joaAdminPayMovieDao;
	@Autowired
	private JoaAdminPayProductDAO joaAdminPayProductDao;

	@RequestMapping("/adminRevenueMain.do")
	public ModelAndView adminRevenueMainGo() {
		ModelAndView mav=new ModelAndView();
		int nowMonthMovieRevenue=joaAdminPayMovieDao.nowMonthMovieRevenue();
		int nowMonth=joaAdminPayMovieDao.nowMonth();
		int nowYear=joaAdminPayMovieDao.nowYear();
		int nowMonthProductRevenue=joaAdminPayProductDao.nowMonthProductRevenue();
		int nowMonthSpectator=joaAdminPayMovieDao.nowMonthSpectator();
		mav.addObject("nowMonthProductRevenue", nowMonthProductRevenue);
		mav.addObject("nowMonthMovieRevenue", nowMonthMovieRevenue);
		mav.addObject("nowMonth",nowMonth);
		mav.addObject("nowYear",nowYear);
		mav.addObject("nowMonthSpectator", nowMonthSpectator);
		mav.setViewName("admin/adminRevenue/adminRevenue_main");
		return mav;
	}

}
