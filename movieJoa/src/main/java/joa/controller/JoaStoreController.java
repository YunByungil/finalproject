package joa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import joa.store.model.*;
import joa.adminMem.model.JoaAdminMemberDTO;
import joa.adminStore.model.*;
import joa.member.model.*;

@Controller
public class JoaStoreController {
	
	@Autowired
	private JoaStoreService joaStoreService;
	
	@RequestMapping("/joaStore.do")
	public ModelAndView joaStore() {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("joaStore/joaStore_store");
		return mav;
	}
	
	@RequestMapping("/joaStoreCategory.do")
	public ModelAndView joaStoreCombo(String category) {
		List<AdminStoreDTO> storeCategoryList=joaStoreService.storeCategoryList(category);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("category",category);
		mav.addObject("storeCategoryList",storeCategoryList);
		mav.setViewName("joaStore/joaStore_category");
		return mav;
	}
	
	@RequestMapping("/joaStoreProduct.do")
	public ModelAndView joaStoreProduct(@RequestParam("pro_idx")int pro_idx) {
		
		AdminStoreDTO dto=joaStoreService.storeProductInfo(pro_idx);
		ModelAndView mav=new ModelAndView();
		mav.addObject("storeProductInfo",dto);
		mav.setViewName("joaStore/joaStore_product");		
		return mav;
	}

	@RequestMapping("/joaStoreCart.do")
	public ModelAndView joaStoreCart(JoaStoreCartDTO dto) {
		System.out.println("car_mem_id : "+dto.getCar_mem_id());
		System.out.println("car_count : "+dto.getCar_count());
		System.out.println("pro_idx : "+dto.getCar_pro_idx());
		
		int cartItem=joaStoreService.storeCartLookup(dto.getCar_mem_id(),dto.getCar_pro_idx());
		
		int result;
		String msg;
		ModelAndView mav=new ModelAndView();		
		if(cartItem<=0) {
			result=joaStoreService.storeCartAdd(dto);
			msg=result>0?"상품을 장바구니에 담았습니다.":"장바구니에 담기 실패";
			mav.addObject("cartMsg",msg);

		}else if(cartItem>=1){
			result=joaStoreService.storeCartUpdate(dto);
			msg=result>0?"상품을 장바구니에 담았습니다.":"장바구니에 담기 실패";
			mav.addObject("cartMsg",msg);		
		}

		mav.setViewName("joaStore/joaStore_cart_msg");
		return mav;		
	}
	
	
	@RequestMapping("/joaStoreCartList.do")
	public ModelAndView joaStoreCartList(String car_mem_id,HttpSession session) {
			JoaMemberDTO udto=(JoaMemberDTO)session.getAttribute("userInfo");
			String sid=udto.getMem_id();

		List<JoaStoreDTO> storeCartList=joaStoreService.storeCartList(sid);
		ModelAndView mav=new ModelAndView();
		mav.addObject("storeCartList",storeCartList);
		mav.setViewName("joaStore/joaStore_cart");
		return mav;
	}
	
	@RequestMapping("/joaStoreCartDelete.do")
	public ModelAndView joaStoreCartDelete(String delete_car_idx,HttpSession session) {
		JoaMemberDTO udto=(JoaMemberDTO)session.getAttribute("userInfo");
		String sid=udto.getMem_id();
		int result = joaStoreService.storeCartDelete(delete_car_idx);		
		ModelAndView mav=new ModelAndView();
		
		List<JoaStoreDTO> storeCartList=joaStoreService.storeCartList(sid);
		mav.addObject("storeCartList",storeCartList);
		mav.setViewName("joaStore/joaStore_cart");
		return mav;
	}
	
	@RequestMapping("/selectCoupon.do")
	public String selectCoupon() {
		return "joaStore/joaStore_selectCoupon";
	}
	
	@RequestMapping("/joaStoreCartUpdateCount.do")
	public ModelAndView joaStoreCartUpdate(String update_car_idx, String update_car_count,HttpSession session) {
		JoaMemberDTO udto=(JoaMemberDTO)session.getAttribute("userInfo");
		String sid=udto.getMem_id();
		joaStoreService.storeCartUpdateCount(update_car_idx, update_car_count);
		
		ModelAndView mav=new ModelAndView();
		
		List<JoaStoreDTO> storeCartList=joaStoreService.storeCartList(sid);
		mav.addObject("storeCartList",storeCartList);
		mav.setViewName("joaStore/joaStore_cart");
		return mav;
	}

}