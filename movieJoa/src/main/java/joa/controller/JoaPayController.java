package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class JoaPayController {
	
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
	public ModelAndView joaStoreCartBuyNow() {
		merchantUid();
		ModelAndView mav=new ModelAndView();
		mav.setViewName("joaStore/joaStore_pay");
		return mav;
	}

}
