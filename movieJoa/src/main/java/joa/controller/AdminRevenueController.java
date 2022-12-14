package joa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import joa.adminMem.model.JoaAdminMemberDTO;
import joa.adminMovie.model.AdminMovieDTO;
import joa.adminRevenue.model.JoaAdminPayMovieDAO;
import joa.adminRevenue.model.JoaAdminPayMovieDTO;
import joa.adminRevenue.model.JoaAdminPayProductDAO;
import joa.adminRevenue.model.JoaAdminPayProductDTO;
import joa.adminStore.model.AdminStoreDTO;

@Controller
public class AdminRevenueController {
	
	@Autowired
	private JoaAdminPayMovieDAO joaAdminPayMovieDao;
	@Autowired
	private JoaAdminPayProductDAO joaAdminPayProductDao;

	@RequestMapping("/adminRevenueMain.do")
	public ModelAndView adminRevenueMainGo() {
		ModelAndView mav=new ModelAndView();
		int arr[]=new int[5];
		arr=joaAdminPayMovieDao.payAgeCount();
		int nowMonthMovieRevenue=joaAdminPayMovieDao.nowMonthMovieRevenue();
		int nowMonth=joaAdminPayMovieDao.nowMonth();
		int nowYear=joaAdminPayMovieDao.nowYear();
		int nowMonthProductRevenue=joaAdminPayProductDao.nowMonthProductRevenue();
		int nowMonthSpectator=joaAdminPayMovieDao.nowMonthSpectator();
		int mangender=joaAdminPayMovieDao.mangender();
		int allgender=joaAdminPayMovieDao.allgender();
		String nowMonthBestMovie=joaAdminPayMovieDao.nowMonthBestMovie();
		String nowMonthBestProduct=joaAdminPayProductDao.nowMonthBestProduct();
		mav.addObject("nowMonthBestProduct", nowMonthBestProduct);
		mav.addObject("nowMonthBestMovie", nowMonthBestMovie);
		mav.addObject("arr",arr);
		mav.addObject("allgender", allgender);
		mav.addObject("nowMonthProductRevenue", nowMonthProductRevenue);
		mav.addObject("nowMonthMovieRevenue", nowMonthMovieRevenue);
		mav.addObject("nowMonth",nowMonth);
		mav.addObject("nowYear",nowYear);
		mav.addObject("nowMonthSpectator", nowMonthSpectator);
		mav.addObject("mangender",mangender);
		mav.setViewName("admin/adminRevenue/adminRevenue_main");
		return mav;
	}
	@RequestMapping(value="/adminRevenueShop.do")
	public ModelAndView adminRevenueShopGo() {
		ModelAndView mav=new ModelAndView();
		List<JoaAdminMemberDTO> list=joaAdminPayMovieDao.revenueShop();
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0; i<list.size(); i++) {
			String temp=list.get(i).getAdmin_shop();
			int result=joaAdminPayMovieDao.revenueShopMoney(temp);
			map.put(temp, result);
		}
		mav.addObject("list",list);
		mav.addObject("map",map);
		mav.setViewName("admin/adminRevenue/adminRevenue_shop");
		return mav;
	}
	@RequestMapping("/adminRevenueProduct.do")
	public ModelAndView adminRevenueProductGo() {
		ModelAndView mav=new ModelAndView();
		List<AdminStoreDTO> list=joaAdminPayProductDao.revenueStore();
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0; i<list.size(); i++) {
			String temp=list.get(i).getPro_name();
			int result=joaAdminPayProductDao.revenueStoreMoney(temp);
			map.put(temp, result);
		}
		mav.addObject("list", list);
		mav.addObject("map", map);
		mav.setViewName("admin/adminRevenue/adminRevenue_product");
		return mav;
	}
	@RequestMapping("/adminRevenueMovie.do")
	public ModelAndView adminRevenueMovieGo() {
		ModelAndView mav=new ModelAndView();
		List<AdminMovieDTO> list=joaAdminPayMovieDao.revenueMovie();
		Map<String, Integer> map=new HashMap<String, Integer>();
		for(int i=0; i<list.size(); i++) {
			String temp=list.get(i).getMov_title();
			int result=joaAdminPayMovieDao.revenueMovieMoney(temp);
			map.put(temp, result);
		}
		mav.addObject("list", list);
		mav.addObject("map", map);
		mav.setViewName("admin/adminRevenue/adminRevenue_movie");
		return mav;
	}
	@RequestMapping("/adminRevenueGender.do")
	public ModelAndView adminRevenueGenderGo() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/adminRevenue/adminRevenue_gender");
		return mav;
	}
	@RequestMapping("/adminRevenueAge.do")
	public ModelAndView adminRevenueAgeGo() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("admin/adminRevenue/adminRevenue_age");
		return mav;
	}
	@RequestMapping("/adminRevenueSpectator.do")
	public ModelAndView adminRevenueSpectatorGo() {
		ModelAndView mav=new ModelAndView();
		List<AdminMovieDTO> list=joaAdminPayMovieDao.revenueMovie();
		Map<String, Integer> map=new HashMap<String , Integer>();
		for(int i=0; i<list.size(); i++) {
			String temp=list.get(i).getMov_title();
			int result=joaAdminPayMovieDao.movieSpectatorCount(temp);
			map.put(temp, result);
		}
		mav.addObject("list", list);
		mav.addObject("map", map);
		mav.setViewName("admin/adminRevenue/adminRevenue_spectator");
		return mav;
	}
	@RequestMapping("adminRevenueShopDetail.do")
	public ModelAndView adminRevenueShopDetailGo(String paymov_the_branch){
		ModelAndView mav=new ModelAndView();
		List<JoaAdminPayMovieDTO> list=joaAdminPayMovieDao.revenueShopDetail(paymov_the_branch);
		mav.addObject("list", list);
		mav.setViewName("admin/adminRevenue/adminRevenue_shop_detail");
		return mav;
	}
	@RequestMapping("adminRevenueMovieDetail.do")
	public ModelAndView adminRevenueMovieDetailGo(String paymov_mov_title) {
		ModelAndView mav=new ModelAndView();
		List<JoaAdminPayMovieDTO> list=joaAdminPayMovieDao.revenunMovieDetail(paymov_mov_title);
		mav.addObject("list", list);
		mav.setViewName("admin/adminRevenue/adminRevenue_movie_detail");
		return mav;
	}
	@RequestMapping("adminRevenueProductDetail.do")
	public ModelAndView adminRevenueProductDetailGo(String paypro_pro_name) {
		ModelAndView mav=new ModelAndView();
		List<JoaAdminPayProductDTO> list=joaAdminPayProductDao.revenueProductDetail(paypro_pro_name);
		mav.addObject("list", list);
		mav.setViewName("admin/adminRevenue/adminRevenue_product_detail");
		return mav;
	}
}
