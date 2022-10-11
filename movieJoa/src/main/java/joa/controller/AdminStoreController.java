package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminStoreController {
	
	@RequestMapping("/adminStore.do")
	public String adminStore() {
		return "admin/adminStore/adminStore_store";
	}


}
