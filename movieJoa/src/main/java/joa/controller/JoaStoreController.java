package joa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.store.model.*;
import joa.adminStore.model.*;

@Controller
public class JoaStoreController {
	
	@Autowired
	private JoaStoreDAO joaStoreDao;
	
	@RequestMapping("/joaStore.do")
	public ModelAndView joaStore() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("joaStore/joaStore_store");
		return mav;
	}
	
	@RequestMapping("/joaStoreCategory.do")
	public ModelAndView joaStoreCombo(String category) {
		List<AdminStoreDTO> storeCategoryList=joaStoreDao.storeCategoryList(category);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("category",category);
		mav.addObject("storeCategoryList",storeCategoryList);
		mav.setViewName("joaStore/joaStore_category");
		return mav;
	}
	
	@RequestMapping("/joaStoreProduct.do")
	public ModelAndView joaStoreProduct(@RequestParam("pro_idx")int pro_idx) {
		
		AdminStoreDTO dto=joaStoreDao.storeProductInfo(pro_idx);
		ModelAndView mav=new ModelAndView();
		mav.addObject("storeProductInfo",dto);
		mav.setViewName("joaStore/joaStore_product");		
		return mav;
	}

	@RequestMapping("/joaStoreCart.do")
	public String joaStoreCart() {
		return "joaStore/joaStore_cart";
	}
	
	@RequestMapping("/joaStorePay.do")
	public String joaStorePay() {
		return "joaStore/joaStore_pay";
	}

}