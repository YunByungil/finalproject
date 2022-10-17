package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoaPayController {
	
	@RequestMapping("/joaStoreCartBuyNow.do")
	public String joaStoreCartBuyNow() {
		return "joaStore/joaStore_pay";
	}

}
