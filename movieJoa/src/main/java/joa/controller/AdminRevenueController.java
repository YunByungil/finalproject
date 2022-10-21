package joa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminRevenueController {

	@RequestMapping("/adminRevenueMain.do")
	public String adminRevenueMainGo() {
		return "admin/adminRevenue/adminRevenue_main";
	}

}
