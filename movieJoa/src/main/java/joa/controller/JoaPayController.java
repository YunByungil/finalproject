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
	public ModelAndView joaStoreCartBuyNow(String idxsJson) {
		
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
		mav.addObject("jpcList",jpcList);
		mav.setViewName("joaStore/joaStore_pay");
		return mav;
	}
	

}
