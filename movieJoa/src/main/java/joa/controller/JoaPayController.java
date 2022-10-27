package joa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

import org.json.JSONArray;
import joa.pay.model.*;
import joa.store.model.JoaStoreDTO;
import joa.store.model.JoaStoreService;
import joa.movie.model.*;

@Controller
public class JoaPayController {
	
	@Autowired
	private JoaPayService joaPayService;
	
	public static void merchantUid() {
		
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 20;
	    Random random = new Random();
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	                                   .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	                                   .limit(targetStringLength)
	                                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	                                   .toString();
	    System.out.println(generatedString);
	  }
	
	@RequestMapping("/joaStorePay.do")
	public ModelAndView joaStoreCartBuyNow(String idxsJson,String pay_price_sum,String pay_discount,String pay_total_sum, String mem_name, String mem_tel) {
		
		JSONArray jsonArr = new JSONArray(idxsJson);
		System.out.println(jsonArr.get(0));
		
		List<JoaPayCartListDTO> jpcList = new ArrayList<JoaPayCartListDTO>();
		JoaPayCartListDTO dto = new JoaPayCartListDTO();
		String car_pro_idx;
		
		for(int i=0;i<jsonArr.length();i++) {
			System.out.println("for:"+jsonArr.getString(i));
			car_pro_idx=jsonArr.getString(i);
			dto = joaPayService.storePayCartList(Integer.parseInt(car_pro_idx),"jtl3403");
			jpcList.add(dto);
		}

		ModelAndView mav=new ModelAndView();
		mav.addObject("pay_total_sum",pay_total_sum);
		mav.addObject("pay_discount",pay_discount);
		mav.addObject("pay_price_sum",pay_price_sum);
		mav.addObject("mem_name",mem_name);
		mav.addObject("mem_tel",mem_tel);
		mav.addObject("jpcList",jpcList);
		mav.setViewName("joaStore/joaStore_pay");
		
		return mav;
	}
	
	@RequestMapping("/joaStoreKakaoPay.do")
	public ModelAndView joaStoreKakaoPay(
			String payPro_mem_id, String payPro_mem_name, String payPro_mem_email,
			String payPro_mem_tel, String payPro_pg, String payPro_method, String payPro_pro_name,
			String payPro_price_sum, String payPro_discount, String payPro_total_price, String payPro_merchant_uid,
			JoaPayProDTO dto) {
		System.out.println("payPro_mem_id: "+payPro_mem_id);
		System.out.println("payPro_mem_name: "+payPro_mem_name);
		System.out.println("payPro_mem_email: "+payPro_mem_email);
		System.out.println("payPro_mem_tel: "+payPro_mem_tel);
		System.out.println("payPro_pg: "+payPro_pg);
		System.out.println("payPro_method: "+payPro_method);
		System.out.println("payPro_pro_name: "+payPro_pro_name);
		System.out.println("payPro_price_sum: "+payPro_price_sum);
		System.out.println("payPro_discount: "+payPro_discount);
		System.out.println("payPro_total_price: "+payPro_total_price);
		System.out.println("payPro_merchant_uid: "+payPro_merchant_uid);
		joaPayService.payProductResultAdd(dto);
		ModelAndView mav=new ModelAndView();
		mav.addObject("payList",dto);
		mav.setViewName("joaStore/joaStore_pay_result");
		return mav;
	}
	
	@RequestMapping("/joaBookPay.do")
	public ModelAndView joaBookPay(JoaPayMovDTO dto) {
		
		int result = joaPayService.joaBookPayAdd(dto);
		String msg;
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("payMsg",msg);
		mav.setViewName("joaBook/joaBook_pay_result");		
		return mav;
	}
	
	

}
